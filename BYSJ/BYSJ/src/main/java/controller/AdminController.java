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

	// 跳转到增加线路的jsp页面,和修改线路跳转同一个界面，但是根据type的值去显示不同功能
	@RequestMapping("addXianLuShow")
	public ModelAndView addXianLuShow() {
		ModelAndView mv = new ModelAndView("admin/editAndAddXianLu");
		mv.addObject("type", "C");
		return mv;
	}

	// 修改线路展示全部线路列表
	@RequestMapping("editXianLuLBShow")
	public ModelAndView editXianLuLBShow() {
		ModelAndView mv = new ModelAndView("admin/editXianLu");
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxXianLu();
		mv.addObject("xls", xls);
		return mv;
	}

	// 修改线路展示每个线路的详情
	@RequestMapping("editXianLuShow")
	public ModelAndView editXianLuShow(String id) {
		int idXianlu = Integer.parseInt(id);
		XianLu xl = usdao.getXianLu(idXianlu);
		ModelAndView mv = new ModelAndView("admin/editAndAddXianLu");
		mv.addObject("xl", xl);
		mv.addObject("type", "U");
		return mv;
	}

	// 修改线路
	@RequestMapping("editXianLu")
	public ModelAndView editXianLu(XianLu xl) {
		boolean flag = usdao.editXianLu(xl);
		ModelAndView mv = new ModelAndView("admin/AdminIndex");
		if (flag) {
			mv.addObject("editResult", "success");
		}
		return mv;
	}

	// 增加线路，向数据库插入数据
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

	// 增加线路、编辑线路、删除线路的返回按钮
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

	// 跳转删除线路界面
	@RequestMapping("delXianLuShow")
	public ModelAndView delXianLuShow() {
		ModelAndView mv = new ModelAndView("admin/delXianLu");
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxXianLu();
		mv.addObject("xls", xls);
		return mv;
	}

	// 删除线路
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

	// 显示车票列表
	@RequestMapping("weiHuChePiao")
	public ModelAndView weiHuChePiao() {
		ModelAndView mv = new ModelAndView("admin/weiHuChePiao");
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxXianLu();
		mv.addObject("xls", xls);
		return mv;
	}

	// 禁用和开启车票
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

	// 跳转到编辑车票信息的界面
	@RequestMapping("editChePiaoShow")
	public ModelAndView editChePiaoShow(String id) {
		int idXianlu = Integer.parseInt(id);
		XianLu xl = usdao.getXianLu(idXianlu);
		ModelAndView mv = new ModelAndView("admin/editChePiao");
		mv.addObject("xl", xl);
		return mv;
	}

	// 获取前台修改的车票的信息，传到数据库
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

	// 跳转到票务管理；
	@RequestMapping("piaoWuGuanLiShow")
	public ModelAndView piaoWuGuanLiShow(XianLu xl) {
		ModelAndView mv = new ModelAndView("admin/piaoWuGuanLi");
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxXianLu();
		mv.addObject("xls", xls);
		return mv;
	}

	// 跳转到增加用户界面；
	@RequestMapping("addUserShow")
	public ModelAndView addUser() {
		ModelAndView mv = new ModelAndView("admin/addAndEditUser");
		mv.addObject("type", "C");
		return mv;
	}

	// 获取注册的数据，插入到数据库
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

	// 跳转到展示全部用户的界面（修改）；
	@RequestMapping("editUserShow")
	public ModelAndView editUserShow() {
		ModelAndView mv = new ModelAndView("admin/userShow");
		List<User> users = new ArrayList<User>();
		users = usdao.cxUser();
		mv.addObject("users", users);
		return mv;
	}

	// 跳转到单个用户的修改界面；
	@RequestMapping("editUserShowMore")
	public ModelAndView editUserShowMore(String id) {
		int userId = Integer.parseInt(id);
		User us = usdao.getUser(userId);
		ModelAndView mv = new ModelAndView("admin/addAndEditUser");
		mv.addObject("user", us);
		mv.addObject("type", "U");
		return mv;
	}

	// 获取注册的数据，插入到数据库
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

	// 跳转到展示全部用户的界面(删除)；
	@RequestMapping("delUserShow")
	public ModelAndView delUserShow() {
		ModelAndView mv = new ModelAndView("admin/delUser");
		List<User> users = new ArrayList<User>();
		users = usdao.cxUser();
		mv.addObject("users", users);
		return mv;
	}

	// 删除用户；
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

	// 跳转到展示全部用户的界面(查看用户记录)；
	@RequestMapping("searchUserSignShow")
	public ModelAndView searchUserSignShow() {
		ModelAndView mv = new ModelAndView("admin/searchUserSign");
		List<User> users = new ArrayList<User>();
		users = usdao.cxUser();
		mv.addObject("users", users);
		return mv;
	}

	// 跳转查看某个用户每一个订单的页面
	@RequestMapping("searchUserOrdersSignShow")
	public ModelAndView searchUserSignShow(String username) {
		ModelAndView mv = new ModelAndView("admin/searchUserSignShow");
		List<XianLu> xls = new ArrayList<XianLu>();
		xls = usdao.cxOrder(username);
		mv.addObject("xls", xls);
		return mv;
	}
	/*
	 * // 订单查询界面
	 * 
	 * @RequestMapping("adminDingDanShow") public ModelAndView
	 * tuipiaoShow(HttpServletRequest request) { ModelAndView mv = new
	 * ModelAndView("admin/AdminIndex"); List<XianLu> xls = new ArrayList<XianLu>();
	 * xls = usdao.cxOrder(); mv.addObject("xls", xls); return mv; }
	 */

	// 删除订单的数据库操作
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

	// 跳转到增加公告的jsp页面
	@RequestMapping("addAdminGg")
	public ModelAndView addAdminGg() {
		ModelAndView mv = new ModelAndView("admin/AddGG");
		mv.addObject("type", "A");
		return mv;
	}

	// 增加公告的数据库操作
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
	 * // 后台公告查询界面
	 * 
	 * @RequestMapping("adminGongGaoShow") public ModelAndView
	 * adminGongGaoShow(HttpServletRequest request) { ModelAndView mv = new
	 * ModelAndView("admin/AdminIndex"); List<GongGao> ggs = new
	 * ArrayList<GongGao>(); ggs = usdao.cxGongGao(); mv.addObject("ggs", ggs);
	 * return mv; }
	 */
	// 删除公告数据库操作
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

	// 跳转到修改公告的jsp页面
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

	// 修改公告的数据库操作
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

	// 编辑线路的搜索控制，判断用户到底输入了起始地还是目的地，都没有输入就查询所有的线路
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

	// 删除线路的搜索控制，判断用户到底输入了起始地还是目的地，都没有输入就查询所有的线路
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
