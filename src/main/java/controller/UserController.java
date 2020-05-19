package controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDao;
import entity.GongGao;
import entity.User;
import entity.XianLu;

@Controller
public class UserController {
	UserDao usdao = new UserDao();

	// ��¼��ҳ
	@RequestMapping("login")
	public ModelAndView dlShow() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("operateType", "D");
		return mv;
	}

	// ��תע��
	@RequestMapping("zcShow")
	public ModelAndView zcShow() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("operateType", "R");
		return mv;
	}

	// ��ȡע������ݣ����뵽���ݿ�
	@RequestMapping("zcyz")
	public ModelAndView zcyz(User user) {
		UserDao usdao = new UserDao();
		boolean flag = usdao.addUser(user);
		ModelAndView mv = new ModelAndView("login");
		if (flag) {
			mv.addObject("ZCresult", "success");
		} else {
			mv.addObject("ZCresult", "fail");
		}
		mv.addObject("operateType", "D");
		return mv;
	}

	// ��¼�жϣ��������ͨ�û�����ת���û���ҳ��admin�˺�����ת������Ա����
	@RequestMapping("dlyz")
	public ModelAndView dlyz(User user, HttpServletResponse response) {
		UserDao usdao = new UserDao();
		if ("admin".equals(user.getUsername())) {
			boolean flagAdmin = usdao.searchUser(user);
			if (flagAdmin) {
				ModelAndView mv = new ModelAndView("admin/AdminIndex");
				List<XianLu> xls = new ArrayList<XianLu>();
				xls = usdao.cxOrder();
				mv.addObject("xls", xls);
				List<GongGao> ggs = new ArrayList<GongGao>();
				ggs = usdao.cxGongGao();
				mv.addObject("ggs", ggs);
				return mv;
			} else {
				ModelAndView mv = new ModelAndView("login");
				mv.addObject("DLresult", "fail");
				mv.addObject("operateType", "D");
				return mv;
			}
		} else {
			boolean flag = usdao.searchUser(user);
			if (flag) {
				// ���û����洢��cookie��
				String cookUserName = "";
				try {
					cookUserName = URLEncoder.encode(user.getUsername(), "utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				Cookie cookie = new Cookie("cookUserName", cookUserName);
				cookie.setMaxAge(3600);
				response.addCookie(cookie);
				ModelAndView mv = new ModelAndView("user/index");
				mv.addObject("username", user.getUsername());
				List<GongGao> ggs = new ArrayList<GongGao>();
				ggs = usdao.cxGongGao();
				mv.addObject("ggs", ggs);
				return mv;
			} else {
				ModelAndView mv = new ModelAndView("login");
				mv.addObject("DLresult", "fail");
				mv.addObject("operateType", "D");
				return mv;
			}
		}
	}

	// ��cookie�л�ȡ�û����ķ�������ȥ��ȡ��ǰ��¼���û�ʱֱ�ӵ�����������Ϳ���
	public String getCookieName(HttpServletRequest request) {
		String name = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if ("cookUserName".equals(cookies[i].getName())) {
					try {
						name = URLDecoder.decode(cookies[i].getValue(), "UTF-8");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return name;
	}

	// ��ѯ������·,����Ʊʹ��
	@RequestMapping("searchUserOrders")
	public ModelAndView searchUserOrders() {
		ModelAndView mv = new ModelAndView("user/orderShow");
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxUserXianLu();
		mv.addObject("xls", xls);
		return mv;
	}

	// ���ذ�ť
	@RequestMapping("returnBtnUserIndex")
	public ModelAndView returnBtn(HttpServletRequest request) {
		String username = getCookieName(request);
		ModelAndView mv = new ModelAndView("user/index");
		List<GongGao> ggs = new ArrayList<GongGao>();
		ggs = usdao.cxGongGao();
		mv.addObject("ggs", ggs);
		mv.addObject("username", username);
		return mv;
	}

	// ��ת��ȷ��Ԥ���Ľ���
	@RequestMapping("QueRenOrders")
	public ModelAndView QueRenOrders(String id) {
		int idXianlu = Integer.parseInt(id);
		XianLu xl = usdao.getXianLu(idXianlu);
		ModelAndView mv = new ModelAndView("user/QueRenOrders");
		mv.addObject("xl", xl);
		mv.addObject("type", "U");
		return mv;
	}

	// Ԥ����Ʊ���������ݿ�
	@RequestMapping("orderChePiao")
	public ModelAndView orderChePiao(String id, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("user/index");
		String username = getCookieName(request);
		int idOrder = Integer.parseInt(id);
		boolean flag = usdao.insertOrders(idOrder, username);
		List<GongGao> ggs = new ArrayList<GongGao>();
		ggs = usdao.cxGongGao();
		mv.addObject("ggs", ggs);
		mv.addObject("username", username);
		if (flag) {
			// Ԥ���ɹ�����ʾ
			mv.addObject("orderResult", "success");
		} else {
			// Ԥ��ʧ�ܣ��Ѿ�Ԥ���ˣ�
			mv.addObject("orderResult", "fail");
		}
		return mv;
	}

	// ��ѯ�û����е�Ԥ����Ϣ
	@RequestMapping("tuipiaoShow")
	public ModelAndView tuipiaoShow(HttpServletRequest request) {
		String username = getCookieName(request);
		ModelAndView mv = new ModelAndView("user/tuiPiaoShow");
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxOrder(username);
		mv.addObject("xls", xls);
		return mv;
	}

	// ��Ʊ�����ݿ����
	@RequestMapping("tuipiao")
	public ModelAndView tuipiao(String id, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("user/tuiPiaoShow");
		String username = getCookieName(request);
		int idXianlu = Integer.parseInt(id);
		boolean flag = usdao.tuipiao(idXianlu, username);
		if (flag) {
			mv.addObject("tuipiaoResult", "success");
		}
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxOrder(username);
		mv.addObject("xls", xls);
		return mv;
	}

	// ��ѯ�û����е�Ԥ����Ϣ�����ڸ�ǩ��
	@RequestMapping("gaiqianShow")
	public ModelAndView gaiqianShow(HttpServletRequest request) {
		String username = getCookieName(request);
		ModelAndView mv = new ModelAndView("user/gaiqianShow");
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxOrder(username);
		mv.addObject("xls", xls);
		return mv;
	}

	// �����ǩ����ѯ��ʼ�غ�Ŀ�ĵغ�֮ǰ������ͬ�ĳ�Ʊ��Ϣ
	@RequestMapping("gaiqianReShow")
	public ModelAndView gaiqianReShow(String id, String qsdsj, String mddsj) {
		ModelAndView mv = new ModelAndView("user/gaiqianReShow");
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxGaiQianXianLu(qsdsj, mddsj);
		mv.addObject("agoId", id);
		mv.addObject("xls", xls);
		return mv;
	}

	// ��ǩ��ɾ��ԭ���ģ����²����ǩ���
	@RequestMapping("gaiqian")
	public ModelAndView gaiqian(String id, String agoId, HttpServletRequest request) {
		String username = getCookieName(request);
		int idXianlu = Integer.parseInt(id);
		int reAgoId = Integer.parseInt(agoId);
		ModelAndView mv = new ModelAndView("user/gaiqianShow");
		boolean deleteflag = usdao.tuipiao(reAgoId, username);
		if (deleteflag) {
			boolean insertflag = usdao.insertOrders(idXianlu, username);
			if (insertflag) {
				mv.addObject("gaiqianResult", "��ǩ�ɹ�");
			}
		}
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxOrder(username);
		mv.addObject("xls", xls);
		return mv;
	}

	// �������ƣ��ж��û�������������ʼ�ػ���Ŀ�ĵأ���û������Ͳ�ѯ���е���·
	@RequestMapping("searchChePiao")
	public ModelAndView searchChePiao(String qsdxj, String mddxj) {
		ModelAndView mv = new ModelAndView("user/orderShow");
		List<XianLu> xls = new ArrayList<XianLu>();
		if (!"".equals(qsdxj)) {
			xls = usdao.cxSearchChePiaoQsd(qsdxj);
		} else if (!"".equals(mddxj)) {
			xls = usdao.cxSearchChePiaoMdd(mddxj);
		} else {
			xls = usdao.cxUserXianLu();
		}
		mv.addObject("xls", xls);
		return mv;
	}

	// ��ת��������Ϣҳ��
	@RequestMapping("xxcxShow")
	public ModelAndView xxcxShow() {
		ModelAndView mv = new ModelAndView("user/xxcxShow");
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxXianLu();
		mv.addObject("xls", xls);
		return mv;
	}

	// ��ת��������Ϣ����
	@RequestMapping("grxxShow")
	public ModelAndView grxxShow(HttpServletRequest request) {
		String username = getCookieName(request);
		User us = new User();
		us = usdao.searchUser(username);
		ModelAndView mv = new ModelAndView("user/UserMessage");
		mv.addObject("us", us);
		return mv;
	}

	// �޸ĸ�����Ϣ�����ݿ����
	@RequestMapping("editUserGrxx")
	public ModelAndView editUserGrxx(User us, HttpServletRequest request) {
		String username = getCookieName(request);
		ModelAndView mv = new ModelAndView("user/index");
		boolean flag = usdao.editUserGrxx(us);
		if (flag) {
			mv.addObject("editResult", "success");
		}
		List<GongGao> ggs = new ArrayList<GongGao>();
		ggs = usdao.cxGongGao();
		mv.addObject("ggs", ggs);
		mv.addObject("username", username);
		return mv;
	}

	//�鿴����
	@RequestMapping("userLookGongGao")
	public ModelAndView userLookGongGao(String id) {
		int idGG = Integer.parseInt(id);
		ModelAndView mv = new ModelAndView("user/LookGG");
		GongGao gg = new GongGao();
		gg = usdao.cxGongGao(idGG);
		mv.addObject("gg", gg);
		// mv.addObject("type", "C");
		return mv;
	}
}
