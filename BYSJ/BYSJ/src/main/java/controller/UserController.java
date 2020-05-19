package controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDao;
import entity.User;

@Controller
public class UserController {
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
				return mv;
			} else {
				ModelAndView mv = new ModelAndView("login");
				mv.addObject("DLresult", "fail");
				mv.addObject("operateType", "D");
				return mv;
			}
		}
	}

}
