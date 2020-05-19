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

	// 登录首页
	@RequestMapping("login")
	public ModelAndView dlShow() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("operateType", "D");
		return mv;
	}

	// 跳转注册
	@RequestMapping("zcShow")
	public ModelAndView zcShow() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("operateType", "R");
		return mv;
	}

	// 获取注册的数据，插入到数据库
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

	// 登录判断，如果是普通用户则跳转到用户首页，admin账号则跳转至管理员界面
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
				// 将用户名存储到cookie中
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

	// 从cookie中获取用户名的方法，再去获取当前登录的用户时直接调用这个方法就可以
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

	// 查询所有线路,供订票使用
	@RequestMapping("searchUserOrders")
	public ModelAndView searchUserOrders() {
		ModelAndView mv = new ModelAndView("user/orderShow");
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxUserXianLu();
		mv.addObject("xls", xls);
		return mv;
	}

	// 返回按钮
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

	// 跳转到确认预定的界面
	@RequestMapping("QueRenOrders")
	public ModelAndView QueRenOrders(String id) {
		int idXianlu = Integer.parseInt(id);
		XianLu xl = usdao.getXianLu(idXianlu);
		ModelAndView mv = new ModelAndView("user/QueRenOrders");
		mv.addObject("xl", xl);
		mv.addObject("type", "U");
		return mv;
	}

	// 预定车票，插入数据库
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
			// 预定成功的提示
			mv.addObject("orderResult", "success");
		} else {
			// 预定失败（已经预定了）
			mv.addObject("orderResult", "fail");
		}
		return mv;
	}

	// 查询用户所有的预定信息
	@RequestMapping("tuipiaoShow")
	public ModelAndView tuipiaoShow(HttpServletRequest request) {
		String username = getCookieName(request);
		ModelAndView mv = new ModelAndView("user/tuiPiaoShow");
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxOrder(username);
		mv.addObject("xls", xls);
		return mv;
	}

	// 退票的数据库操作
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

	// 查询用户所有的预定信息（用于改签）
	@RequestMapping("gaiqianShow")
	public ModelAndView gaiqianShow(HttpServletRequest request) {
		String username = getCookieName(request);
		ModelAndView mv = new ModelAndView("user/gaiqianShow");
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxOrder(username);
		mv.addObject("xls", xls);
		return mv;
	}

	// 点击改签，查询起始地和目的地和之前订单相同的车票信息
	@RequestMapping("gaiqianReShow")
	public ModelAndView gaiqianReShow(String id, String qsdsj, String mddsj) {
		ModelAndView mv = new ModelAndView("user/gaiqianReShow");
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxGaiQianXianLu(qsdsj, mddsj);
		mv.addObject("agoId", id);
		mv.addObject("xls", xls);
		return mv;
	}

	// 改签，删除原来的，重新插入改签后的
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
				mv.addObject("gaiqianResult", "改签成功");
			}
		}
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxOrder(username);
		mv.addObject("xls", xls);
		return mv;
	}

	// 搜索控制，判断用户到底输入了起始地还是目的地，都没有输入就查询所有的线路
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

	// 跳转到所有信息页面
	@RequestMapping("xxcxShow")
	public ModelAndView xxcxShow() {
		ModelAndView mv = new ModelAndView("user/xxcxShow");
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxXianLu();
		mv.addObject("xls", xls);
		return mv;
	}

	// 跳转到个人信息界面
	@RequestMapping("grxxShow")
	public ModelAndView grxxShow(HttpServletRequest request) {
		String username = getCookieName(request);
		User us = new User();
		us = usdao.searchUser(username);
		ModelAndView mv = new ModelAndView("user/UserMessage");
		mv.addObject("us", us);
		return mv;
	}

	// 修改个人信息的数据库操作
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

	//查看公告
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
