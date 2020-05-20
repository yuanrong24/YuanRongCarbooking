package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDao;
import entity.GongGao;
import entity.User;
import entity.XianLu;

@Controller
public class AdminController {
	UserDao usdao = new UserDao();

	// ��ת��������·��jspҳ��,���޸���·��תͬһ�����棬���Ǹ���type��ֵȥ��ʾ��ͬ����
	@RequestMapping("addXianLuShow")
	public ModelAndView addXianLuShow() {
		ModelAndView mv = new ModelAndView("admin/editAndAddXianLu");
		mv.addObject("type", "C");
		return mv;
	}

	// �޸���·չʾȫ����·�б�
	@RequestMapping("editXianLuLBShow")
	public ModelAndView editXianLuLBShow() {
		ModelAndView mv = new ModelAndView("admin/editXianLu");
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxXianLu();
		mv.addObject("xls", xls);
		return mv;
	}

	// �޸���·չʾÿ����·������
	@RequestMapping("editXianLuShow")
	public ModelAndView editXianLuShow(String id) {
		int idXianlu = Integer.parseInt(id);
		XianLu xl = usdao.getXianLu(idXianlu);
		ModelAndView mv = new ModelAndView("admin/editAndAddXianLu");
		mv.addObject("xl", xl);
		mv.addObject("type", "U");
		return mv;
	}

	// �޸���·
	@RequestMapping("editXianLu")
	public ModelAndView editXianLu(XianLu xl) {
		boolean flag = usdao.editXianLu(xl);
		ModelAndView mv = new ModelAndView("admin/AdminIndex");
		if (flag) {
			mv.addObject("editResult", "success");
		}
		return mv;
	}

	// ������·�������ݿ��������
	@RequestMapping("addXianLu")
	public ModelAndView addXianLu(XianLu xl) {
		ModelAndView mv = new ModelAndView("admin/AdminIndex");
		boolean flag = usdao.addXianLu(xl);
		if (flag) {
			mv.addObject("ZJXLresult", "success");
		} else {
			mv.addObject("ZJXLresult", "fail");
		}
		return mv;
	}

	// ������·���༭��·��ɾ����·�ķ��ذ�ť
	@RequestMapping("returnAdminIndex")
	public ModelAndView returnAdminIndex() {
		ModelAndView mv = new ModelAndView("admin/AdminIndex");
		List<GongGao> ggs = new ArrayList<GongGao>();
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxOrder();
		ggs = usdao.cxGongGao();
		String yhglback = "1";
		mv.addObject("xls", xls);
		mv.addObject("ggs", ggs);
		mv.addObject("yhglback", yhglback);
		return mv;
	}

	// ��תɾ����·����
	@RequestMapping("delXianLuShow")
	public ModelAndView delXianLuShow() {
		ModelAndView mv = new ModelAndView("admin/delXianLu");
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxXianLu();
		mv.addObject("xls", xls);
		return mv;
	}

	// ɾ����·
	@RequestMapping("delXianLu")
	public ModelAndView delXianLu(String id) {
		int idXianlu = Integer.parseInt(id);
		boolean flag = usdao.delXianLu(idXianlu);
		ModelAndView mv = new ModelAndView("admin/delXianLu");
		if (flag) {
			mv.addObject("delResult", "success");
		}
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxXianLu();
		mv.addObject("xls", xls);
		return mv;
	}

	// ��ʾ��Ʊ�б�
	@RequestMapping("weiHuChePiao")
	public ModelAndView weiHuChePiao() {
		ModelAndView mv = new ModelAndView("admin/weiHuChePiao");
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxXianLu();
		mv.addObject("xls", xls);
		return mv;
	}

	// ���úͿ�����Ʊ
	@RequestMapping("sfkqChePiao")
	public ModelAndView sfkqChePiao(String id, String sfkqzt) {
		ModelAndView mv = new ModelAndView("admin/weiHuChePiao");
		int idXianlu = Integer.parseInt(id);
		boolean sfkqResult = usdao.jyChePiao(idXianlu, sfkqzt);
		if (sfkqResult) {
			mv.addObject("sfkqResult", "success");
		}
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxXianLu();
		mv.addObject("xls", xls);
		return mv;
	}

	// ��ת���༭��Ʊ��Ϣ�Ľ���
	@RequestMapping("editChePiaoShow")
	public ModelAndView editChePiaoShow(String id) {
		int idXianlu = Integer.parseInt(id);
		XianLu xl = usdao.getXianLu(idXianlu);
		ModelAndView mv = new ModelAndView("admin/editChePiao");
		mv.addObject("xl", xl);
		return mv;
	}

	// ��ȡǰ̨�޸ĵĳ�Ʊ����Ϣ���������ݿ�
	@RequestMapping("editChePiao")
	public ModelAndView editChePiao(XianLu xl) {
		ModelAndView mv = new ModelAndView("admin/weiHuChePiao");
		boolean flag = usdao.editChePiao(xl);
		if (flag) {
			mv.addObject("editChePiaoResult", "success");
		}
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxXianLu();
		mv.addObject("xls", xls);
		mv.addObject("xl", xl);
		return mv;
	}

	// ��ת��Ʊ�����
	@RequestMapping("piaoWuGuanLiShow")
	public ModelAndView piaoWuGuanLiShow(XianLu xl) {
		ModelAndView mv = new ModelAndView("admin/piaoWuGuanLi");
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxXianLu();
		mv.addObject("xls", xls);
		return mv;
	}

	// ��ת�������û����棻
	@RequestMapping("addUserShow")
	public ModelAndView addUser() {
		ModelAndView mv = new ModelAndView("admin/addAndEditUser");
		mv.addObject("type", "C");
		return mv;
	}

	// ��ȡע������ݣ����뵽���ݿ�
	@RequestMapping("addUser")
	public ModelAndView addUser(User user) {
		ModelAndView mv = new ModelAndView("admin/AdminIndex");
		if ("".equals(user.getId())) {
			boolean flag = usdao.addUser(user);
			if (flag) {
				mv.addObject("addUserResult", "success");
			}
		} else {
			boolean flag = usdao.editUser(user);
			if (flag) {
				mv.addObject("editResult", "success");
			}
		}
		return mv;
	}

	// ��ת��չʾȫ���û��Ľ��棨�޸ģ���
	@RequestMapping("editUserShow")
	public ModelAndView editUserShow() {
		ModelAndView mv = new ModelAndView("admin/userShow");
		List<User> users = new ArrayList<User>();
		users = usdao.cxUser();
		mv.addObject("users", users);
		return mv;
	}

	// ��ת�������û����޸Ľ��棻
	@RequestMapping("editUserShowMore")
	public ModelAndView editUserShowMore(String id) {
		int userId = Integer.parseInt(id);
		User us = usdao.getUser(userId);
		ModelAndView mv = new ModelAndView("admin/addAndEditUser");
		mv.addObject("user", us);
		mv.addObject("type", "U");
		return mv;
	}

	// ��ȡע������ݣ����뵽���ݿ�
	@RequestMapping("editUser")
	public ModelAndView editUser(User user) {
		UserDao usdao = new UserDao();
		boolean flag = usdao.addUser(user);
		ModelAndView mv = new ModelAndView("admin/AdminIndex");
		if (flag) {
			mv.addObject("editResult", "success");
		}
		return mv;
	}

	// ��ת��չʾȫ���û��Ľ���(ɾ��)��
	@RequestMapping("delUserShow")
	public ModelAndView delUserShow() {
		ModelAndView mv = new ModelAndView("admin/delUser");
		List<User> users = new ArrayList<User>();
		users = usdao.cxUser();
		mv.addObject("users", users);
		return mv;
	}

	// ɾ���û���
	@RequestMapping("delUser")
	public ModelAndView delUser(String id) {
		ModelAndView mv = new ModelAndView("admin/delUser");
		int userId = Integer.parseInt(id);
		boolean flag = usdao.delUser(userId);
		if (flag) {
			mv.addObject("delResult", "success");
		}
		List<User> users = new ArrayList<User>();
		users = usdao.cxUser();
		mv.addObject("users", users);
		return mv;
	}

	// ��ת��չʾȫ���û��Ľ���(�鿴�û���¼)��
	@RequestMapping("searchUserSignShow")
	public ModelAndView searchUserSignShow() {
		ModelAndView mv = new ModelAndView("admin/searchUserSign");
		List<User> users = new ArrayList<User>();
		users = usdao.cxUser();
		mv.addObject("users", users);
		return mv;
	}

	// ��ת�鿴ĳ���û�ÿһ��������ҳ��
	@RequestMapping("searchUserOrdersSignShow")
	public ModelAndView searchUserSignShow(String username) {
		ModelAndView mv = new ModelAndView("admin/searchUserSignShow");
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxOrder(username);
		mv.addObject("xls", xls);
		return mv;
	}
	/*
	 * // ������ѯ����
	 * 
	 * @RequestMapping("adminDingDanShow") public ModelAndView
	 * tuipiaoShow(HttpServletRequest request) { ModelAndView mv = new
	 * ModelAndView("admin/AdminIndex"); List<XianLu> xls = new ArrayList<XianLu>();
	 * xls = usdao.cxOrder(); mv.addObject("xls", xls); return mv; }
	 */

	// ɾ�����������ݿ����
	@RequestMapping("AdminTuipiao")
	public ModelAndView tuipiao(String id, String username) {
		ModelAndView mv = new ModelAndView("admin/AdminIndex");
		int idXianlu = Integer.parseInt(id);
		boolean flag = usdao.tuipiao(idXianlu, username);
		if (flag) {
			mv.addObject("tuipiaoResult", "success");
		}
		List<GongGao> ggs = new ArrayList<GongGao>();
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxOrder();
		ggs = usdao.cxGongGao();
		mv.addObject("xls", xls);
		mv.addObject("ggs", ggs);
		return mv;
	}

	// ��ת�����ӹ����jspҳ��
	@RequestMapping("addAdminGg")
	public ModelAndView addAdminGg() {
		ModelAndView mv = new ModelAndView("admin/AddGG");
		mv.addObject("type", "A");
		return mv;
	}

	// ���ӹ�������ݿ����
	@RequestMapping("addGonggao")
	public ModelAndView addGonggao(GongGao gg) {
		ModelAndView mv = new ModelAndView("admin/AdminIndex");
		boolean flag = usdao.addGongGao(gg);
		if (flag) {
			mv.addObject("addUserResult", "success");
		}
		return mv;
	}

	/*
	 * // ��̨�����ѯ����
	 * 
	 * @RequestMapping("adminGongGaoShow") public ModelAndView
	 * adminGongGaoShow(HttpServletRequest request) { ModelAndView mv = new
	 * ModelAndView("admin/AdminIndex"); List<GongGao> ggs = new
	 * ArrayList<GongGao>(); ggs = usdao.cxGongGao(); mv.addObject("ggs", ggs);
	 * return mv; }
	 */
	// ɾ���������ݿ����
	@RequestMapping("adminDelGongGao")
	public ModelAndView adminDelGongGao(String id) {
		ModelAndView mv = new ModelAndView("admin/AdminIndex");
		int idGG = Integer.parseInt(id);
		boolean flag = usdao.delGongGao(idGG);
		if (flag) {
			mv.addObject("tuipiaoResult", "success");
		}
		List<GongGao> ggs = new ArrayList<GongGao>();
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxOrder();
		ggs = usdao.cxGongGao();
		mv.addObject("xls", xls);
		mv.addObject("ggs", ggs);
		return mv;
	}

	// ��ת���޸Ĺ����jspҳ��
	@RequestMapping("adminEditGongGao")
	public ModelAndView adminEditGongGao(String id) {
		int idGG = Integer.parseInt(id);
		ModelAndView mv = new ModelAndView("admin/AddGG");
		GongGao gg = new GongGao();
		gg = usdao.cxGongGao(idGG);
		mv.addObject("gg", gg);
		mv.addObject("type", "C");
		return mv;
	}

	// �޸Ĺ�������ݿ����
	@RequestMapping("editGonggao")
	public ModelAndView editGonggao(GongGao gg) {
		ModelAndView mv = new ModelAndView("admin/AdminIndex");
		boolean flag = usdao.editGonggao(gg);
		if (flag) {
			mv.addObject("editResult", "success");
		}
		List<GongGao> ggs = new ArrayList<GongGao>();
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxOrder();
		ggs = usdao.cxGongGao();
		mv.addObject("xls", xls);
		mv.addObject("ggs", ggs);
		return mv;
	}

	// �༭��·���������ƣ��ж��û�������������ʼ�ػ���Ŀ�ĵأ���û������Ͳ�ѯ���е���·
	@RequestMapping("adminEditSearchChePiao")
	public ModelAndView adminEditSearchChePiao(String qsdxj, String mddxj) {
		ModelAndView mv = new ModelAndView("admin/editXianLu");
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

	// ɾ����·���������ƣ��ж��û�������������ʼ�ػ���Ŀ�ĵأ���û������Ͳ�ѯ���е���·
	@RequestMapping("adminDelSearchChePiao")
	public ModelAndView adminDelSearchChePiao(String qsdxj, String mddxj) {
		ModelAndView mv = new ModelAndView("admin/delXianLu");
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
}
