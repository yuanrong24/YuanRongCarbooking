package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.GongGao;
import entity.User;
import entity.XianLu;

public class UserDao {
	// �������ݿ�ķ���
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/bysj?useUnicode=true&characterEncoding=utf-8", "root", "123456");
		return conn;
	}

	// �ر����ݿ������
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

	// �������û�
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

	// �޸��û���Ϣ
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

	// ��¼��ѯ,�ж��û��˺ź������Ƿ���ȷ
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

	// ��ѯ�û��ĸ�����Ϣ
	public User searchUser(String username) {
		User us = new User();
		Connection conn = null;
		Statement stat = null;
		try {
			conn = getConnection();
			String sql = "select * from user where username ='" + username + "'";
			stat = conn.prepareStatement(sql);
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				us.setXm(rs.getString("xm"));
				us.setXb(rs.getString("xb"));
				us.setPhone(rs.getString("phone"));
				us.setSfzh(rs.getString("sfzh"));
				us.setAge(rs.getString("age"));
				us.setId(rs.getInt("id"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return us;
	}

	// ��������·
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

	// ɾ����·
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

	// �޸���·
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

	// ��̨��ѯ��·���༭��·��ɾ����·����ʹ��
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

	// ��ȡ������·����Ϣ
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

	// ������Ʊ״̬���û�������ʾ�˳�Ʊ
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

	// ������Ʊ״̬���û�������ʾ�˳�Ʊ
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

	// ��ѯ�����û�
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

	// ��ȡ�����û�����Ϣ
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

	// ɾ���û�
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

	// ǰ̨��ѯ��·�������õĳ�Ʊ����ʾ
	public List<XianLu> cxUserXianLu() {
		List<XianLu> xls = new ArrayList<XianLu>();
		Connection conn = null;
		Statement stat = null;
		try {
			conn = getConnection();
			String sql = "select * from xianlu where sfkq='1' and jg is not null order by qsdsj desc";
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

	// �����û�Ԥ������Ϣ
	public boolean insertOrders(int id, String username) {
		Connection conn = null;
		Statement stat = null;
		int res = 0;
		try {
			conn = getConnection();
			String sql = "insert into orderCP(xlId,username) values(?,?)";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, id);
			pstat.setString(2, username);
			res = pstat.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return res > 0;
	}

	// ��ѯ�û����е�Ԥ����Ϣ
	public List<XianLu> cxOrder(String username) {
		List<XianLu> xls = new ArrayList<XianLu>();
		Connection conn = null;
		Statement stat = null;
		try {
			conn = getConnection();
			String sql = "select x.* from ordercp o inner join xianlu x on o.xlId=x.id where o.username='" + username
					+ "'";
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

	// ��Ʊ
	public boolean tuipiao(int id, String username) {
		Connection conn = null;
		Statement stat = null;
		int res = 0;
		try {
			conn = getConnection();
			stat = conn.createStatement();
			String sql = "delete from ordercp where username='" + username + "' and xlId=" + id;
			res = stat.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return res > 0;
	}

	// ǰ̨��ѯ��·���û���ǩ��ѡ��
	public List<XianLu> cxGaiQianXianLu(String qsdsj, String mddsj) {
		List<XianLu> xls = new ArrayList<XianLu>();
		Connection conn = null;
		Statement stat = null;
		try {
			conn = getConnection();
			String sql = "select * from xianlu where sfkq='1' and jg is not null and qsdsj='" + qsdsj + "' and mddsj='"
					+ mddsj + "' order by qsdsj desc";
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

	// ǰ̨��ѯ��·(��ѯר��)
	public List<XianLu> cxSearchChePiaoQsd(String qsdxj) {
		List<XianLu> xls = new ArrayList<XianLu>();
		Connection conn = null;
		Statement stat = null;
		try {
			conn = getConnection();
			String sql = "select * from xianlu where sfkq='1' and jg is not null and qsdxj like'%" + qsdxj
					+ "%' order by qsdsj desc";
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

	// ǰ̨��ѯ��·(��ѯר��)
	public List<XianLu> cxSearchChePiaoMdd(String mddxj) {
		List<XianLu> xls = new ArrayList<XianLu>();
		Connection conn = null;
		Statement stat = null;
		try {
			conn = getConnection();
			String sql = "select * from xianlu where sfkq='1' and jg is not null and mddxj like'%" + mddxj
					+ "%' order by qsdsj desc";
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

	// ��ѯ�û����е�Ԥ����Ϣ
	public List<XianLu> cxOrder() {
		List<XianLu> xls = new ArrayList<XianLu>();
		Connection conn = null;
		Statement stat = null;
		try {
			conn = getConnection();
			String sql = "select x.*,o.username from ordercp o inner join xianlu x on o.xlId=x.id  ";
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
				xl.setUsername(rs.getString("username"));
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

	// �����¹���
	public boolean addGongGao(GongGao gg) {
		Connection conn = null;
		Statement stat = null;
		int res = 0;
		try {
			conn = getConnection();
			String sql = "insert into ggb(ggbt,cjsj,ggnr) values(?,?,?)";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, gg.getGgbt());
			pstat.setString(2, gg.getCjsj());
			pstat.setString(3, gg.getGgnr());
			res = pstat.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return res > 0;
	}

	// ��ѯ���еĹ���
	public List<GongGao> cxGongGao() {
		List<GongGao> ggs = new ArrayList<GongGao>();
		Connection conn = null;
		Statement stat = null;
		try {
			conn = getConnection();
			String sql = "select * from ggb order by cjsj desc";
			stat = conn.prepareStatement(sql);
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				GongGao gg = new GongGao();
				gg.setGgbt(rs.getString("ggbt"));
				gg.setCjsj(rs.getString("cjsj"));
				gg.setGgnr(rs.getString("ggnr"));
				gg.setId(rs.getInt("id"));
				ggs.add(gg);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return ggs;
	}

	// ɾ������
	public boolean delGongGao(int id) {
		Connection conn = null;
		Statement stat = null;
		int res = 0;
		try {
			conn = getConnection();
			stat = conn.createStatement();
			String sql = "delete from ggb where id=" + id;
			res = stat.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return res > 0;
	}

	// ��ѯ�������棬���ڱ༭
	public GongGao cxGongGao(int id) {
		GongGao gg = new GongGao();
		Connection conn = null;
		Statement stat = null;
		try {
			conn = getConnection();
			String sql = "select * from ggb where id =" + id;
			stat = conn.prepareStatement(sql);
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				gg.setGgbt(rs.getString("ggbt"));
				gg.setCjsj(rs.getString("cjsj"));
				gg.setGgnr(rs.getString("ggnr"));
				gg.setId(rs.getInt("id"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return gg;
	}

	// �޸Ĺ�����Ϣ
	public boolean editGonggao(GongGao gg) {
		Connection conn = null;
		// PreparedStatement pstat = null;
		Statement stat = null;
		int res = 0;
		try {
			conn = getConnection();
			String sql = "update ggb set ggbt=?,cjsj=?,ggnr=? where id =?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, gg.getGgbt());
			pstat.setString(2, gg.getCjsj());
			pstat.setString(3, gg.getGgnr());
			pstat.setInt(4, gg.getId());
			res = pstat.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return res > 0;
	}

	// �޸��û���Ϣ
	public boolean editUserGrxx(User us) {
		Connection conn = null;
		// PreparedStatement pstat = null;
		Statement stat = null;
		int res = 0;
		try {
			conn = getConnection();
			String sql = "update user set xm=?,xb=?,age=?,phone=?,sfzh=? where id =?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, us.getXm());
			pstat.setString(2, us.getXb());
			pstat.setString(3, us.getAge());
			pstat.setString(4, us.getPhone());
			pstat.setString(5, us.getSfzh());
			pstat.setInt(6, us.getId());
			res = pstat.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return res > 0;
	}
}
