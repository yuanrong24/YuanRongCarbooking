package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDao;
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
	public String returnAdminIndex() {
		return "admin/AdminIndex";
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
}
