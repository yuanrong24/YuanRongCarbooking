package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import entity.XianLu;

public class UserDao {
	// 连接数据库的方法
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/bysj?useUnicode=true&characterEncoding=utf-8", "root", "");
		return conn;
	}

	// 关闭数据库的链接
	private void closeAll(Connection conn, Statement stat, ResultSet res) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (res != null) {
				res.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (stat != null) {
				stat.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 插入新用户
	public boolean addUser(User user) {
		Connection conn = null;
		Statement stat = null;
		int res = 0;
		try {
			conn = getConnection();
			String sql = "insert into user(username,password,phone) values(?,?,?)";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, user.getUsername());
			pstat.setString(2, user.getPassword());
			pstat.setString(3, user.getPhone());
			res = pstat.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return res > 0;
	}

	// 修改用户信息
	public boolean editUser(User us) {
		Connection conn = null;
		// PreparedStatement pstat = null;
		Statement stat = null;
		int res = 0;
		try {
			conn = getConnection();
			String sql = "update user set username=?,password=?,phone=? where id =?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, us.getUsername());
			pstat.setString(2, us.getPassword());
			pstat.setString(3, us.getPhone());
			pstat.setInt(4, us.getId());
			res = pstat.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return res > 0;
	}

	// 登录查询,判断用户账号和密码是否正确
	public boolean searchUser(User user) {
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		try {
			conn = getConnection();
			String sql = "select * from user where username ='" + user.getUsername() + "' and password='"
					+ user.getPassword() + "'";
			stat = conn.prepareStatement(sql);
			ResultSet rs = stat.executeQuery(sql);
			if (rs.next()) {
				flag = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return flag;
	}

	// 插入新线路
	public boolean addXianLu(XianLu xl) {
		Connection conn = null;
		Statement stat = null;
		int res = 0;
		try {
			conn = getConnection();
			String sql = "insert into xianlu(qsdsj,qsdxj,mddsj,mddxj,lcs,cx,sc) values(?,?,?,?,?,?,?)";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, xl.getQsdsj());
			pstat.setString(2, xl.getQsdxj());
			pstat.setString(3, xl.getMddsj());
			pstat.setString(4, xl.getMddxj());
			pstat.setString(5, xl.getLcs());
			pstat.setString(6, xl.getCx());
			pstat.setString(7, xl.getSc());
			res = pstat.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return res > 0;
	}

	// 删除线路
	public boolean delXianLu(int id) {
		Connection conn = null;
		Statement stat = null;
		int res = 0;
		try {
			conn = getConnection();
			stat = conn.createStatement();
			String sql = "delete from xianlu where id=" + id;
			res = stat.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return res > 0;
	}

	// 修改线路
	public boolean editXianLu(XianLu xl) {
		Connection conn = null;
		// PreparedStatement pstat = null;
		Statement stat = null;
		int res = 0;
		try {
			conn = getConnection();
			String sql = "update xianlu set qsdsj=?,qsdxj=?,mddsj=?,mddxj=?,lcs=?,cx=?,sc=? where id =?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, xl.getQsdsj());
			pstat.setString(2, xl.getQsdxj());
			pstat.setString(3, xl.getMddsj());
			pstat.setString(4, xl.getMddxj());
			pstat.setString(5, xl.getLcs());
			pstat.setString(6, xl.getCx());
			pstat.setString(7, xl.getSc());
			pstat.setInt(8, xl.getId());
			res = pstat.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return res > 0;
	}

	// 后台查询线路，编辑线路和删除线路可以使用
	public List<XianLu> cxXianLu() {
		List<XianLu> xls = new ArrayList<XianLu>();
		Connection conn = null;
		Statement stat = null;
		try {
			conn = getConnection();
			String sql = "select * from xianlu order by qsdsj desc";
			stat = conn.prepareStatement(sql);
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				XianLu xl = new XianLu();
				xl.setQsdsj(rs.getString("qsdsj"));
				xl.setQsdxj(rs.getString("qsdxj"));
				xl.setMddsj(rs.getString("mddsj"));
				xl.setMddxj(rs.getString("mddxj"));
				xl.setLcs(rs.getString("lcs"));
				xl.setSc(rs.getString("sc"));
				xl.setCx(rs.getString("cx"));
				xl.setId(rs.getInt("id"));
				xl.setFcsj(rs.getString("fcsj"));
				xl.setJg(rs.getString("jg"));
				xl.setSfkq(rs.getString("sfkq"));
				xls.add(xl);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return xls;
	}

	// 获取单个线路的信息
	public XianLu getXianLu(int idXianlu) {
		Statement stat = null;
		Connection conn = null;
		XianLu xl = new XianLu();
		try {
			conn = getConnection();
			String sql = "select * from xianlu where id = " + idXianlu + "";
			stat = conn.prepareStatement(sql);
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				xl.setQsdsj(rs.getString("qsdsj"));
				xl.setQsdxj(rs.getString("qsdxj"));
				xl.setMddsj(rs.getString("mddsj"));
				xl.setMddxj(rs.getString("mddxj"));
				xl.setLcs(rs.getString("lcs"));
				xl.setSc(rs.getString("sc"));
				xl.setCx(rs.getString("cx"));
				xl.setId(rs.getInt("id"));
				xl.setJg(rs.getString("jg"));
				xl.setFcsj(rs.getString("fcsj"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return xl;
	}

	// 开启车票状态，用户界面显示此车票
	public boolean jyChePiao(int id, String sfkqzt) {
		Connection conn = null;
		// PreparedStatement pstat = null;
		Statement stat = null;
		int res = 0;
		try {
			conn = getConnection();
			String sql = "update xianlu set sfkq=? where id =?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, sfkqzt);
			pstat.setInt(2, id);
			res = pstat.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return res > 0;
	}

	// 开启车票状态，用户界面显示此车票
	public boolean editChePiao(XianLu xl) {
		Connection conn = null;
		// PreparedStatement pstat = null;
		Statement stat = null;
		int res = 0;
		try {
			conn = getConnection();
			String sql = "update xianlu set fcsj=?,sc=?,jg=? where id =?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, xl.getFcsj());
			pstat.setString(2, xl.getSc());
			pstat.setString(3, xl.getJg());
			pstat.setInt(4, xl.getId());
			res = pstat.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return res > 0;
	}

	// 查询所有用户
	public List<User> cxUser() {
		List<User> users = new ArrayList<User>();
		Connection conn = null;
		Statement stat = null;
		try {
			conn = getConnection();
			String sql = "select * from user where id !=4 order by id asc";
			stat = conn.prepareStatement(sql);
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				User us = new User();
				us.setId(rs.getInt("id"));
				us.setUsername(rs.getString("username"));
				us.setPhone(rs.getString("phone"));
				users.add(us);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return users;
	}

	// 获取单个用户的信息
	public User getUser(int userId) {
		Statement stat = null;
		Connection conn = null;
		User us = new User();
		try {
			conn = getConnection();
			String sql = "select * from user where id = " + userId + "";
			stat = conn.prepareStatement(sql);
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				us.setId(rs.getInt("id"));
				us.setUsername(rs.getString("username"));
				us.setPhone(rs.getString("phone"));
				us.setPassword(rs.getString("password"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return us;
	}

	// 删除用户
	public boolean delUser(int id) {
		Connection conn = null;
		Statement stat = null;
		int res = 0;
		try {
			conn = getConnection();
			stat = conn.createStatement();
			String sql = "delete from user where id=" + id;
			res = stat.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return res > 0;
	}
}
