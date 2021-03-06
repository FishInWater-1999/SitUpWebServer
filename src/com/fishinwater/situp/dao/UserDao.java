package com.fishinwater.situp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fishinwater.situp.beans.UserBean;
import com.fishinwater.situp.dao.base.IBaseDAO;
import com.fishinwater.situp.utils.DaoEnum;
import com.fishinwater.situp.utils.JDBCUtils;

public class UserDao implements IBaseDAO<UserBean> {

	public int add(UserBean obj) {
		int result = 0;
		Connection con = null;
		PreparedStatement sta = null;
		UserBean user = obj;
		try {

			String name = user.getUser_name();
			String pswd = user.getUser_password();
			String sql = "insert into user () values(?,?,?,?,?) ";
			con = JDBCUtils.getInstance().getConnection();
			sta = con.prepareStatement(sql);
			sta.setString(1, UUID.randomUUID().toString());
			sta.setString(2, name);
			sta.setString(3, pswd);
			sta.setString(4, "��������㼣�ɣ�");
			sta.setString(5, "https://img-blog.csdnimg.cn/20191218205438766.jpg");
			result = sta.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			con = null;
			sta = null;
		}
		return result;
	}

	@Override
	public UserBean update(UserBean obj) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection con = null;
		Statement sta = null;
		System.out.println(obj.toString());
		try {
			String sql = "UPDATE user SET user_password = '" + obj.getUser_password() + "' WHERE user_id = '" + obj.getUser_id() + "'";
			System.out.println(sql);
			con = JDBCUtils.getInstance().getConnection();
			sta = con.createStatement();
			result = sta.executeUpdate(sql);
			System.out.println(obj.getUser_password());
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			JDBCUtils.close(con, sta);
		}
		if (result != 0) {
			return obj;
		}
		return null;
	}
	
	public UserBean updateIntroduction(UserBean obj) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection con = null;
		Statement sta = null;
		System.out.println(obj.toString());
		try {
			String sql = "UPDATE user SET user_introduction = '"+ obj.getUser_introduction() +"' WHERE user_id = '" + obj.getUser_id() + "'";
			System.out.println(sql);
			con = JDBCUtils.getInstance().getConnection();
			sta = con.createStatement();
			result = sta.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			JDBCUtils.close(con, sta);
		}
		if (result != 0) {
			return obj;
		}
		return null;
	}
	
	public UserBean updateHeadImg(UserBean obj) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection con = null;
		Statement sta = null;
		String sql = "";
		System.out.println(obj.toString());
		try {
			sql = "UPDATE user SET user_head_img = '"+ obj.getUser_head_img() +"' WHERE user_id = '" + obj.getUser_id() + "'";
			System.out.println(sql);
			con = JDBCUtils.getInstance().getConnection();
			sta = con.createStatement();
			result = sta.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			obj.setUser_password(result + "<>" + sql + "<>" + e.toString());
			return obj;
		} finally {
			JDBCUtils.close(con, sta);
		}
		if (result != 0) {
			return obj;
		}
		obj.setUser_password(result + "<>" + sql);
		return obj;
	}

	public int delete(String id) {
		int result = 0;

		return result;
	}

	@Override
	public UserBean getBy(DaoEnum flag, String where) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement sta = null;
		ResultSet rs = null;
		UserBean user = null;

		try {
			con =  JDBCUtils.getInstance().getConnection();
			sta = con.createStatement();
			String sql = "";
			switch (flag) {
				case ID:
					sql = "select * from user where user_id = '" + where + "'";
					break;
				case NAME:
					sql = "select * from user where user_name = '" + where + "'";
					break;
				case PASSWORD:
					sql = "select * from user where user_password = '" + where + "'";
					break;
	
				default:
					break;
			}
			rs = sta.executeQuery(sql);
			if (rs.next()) {
				user = new UserBean();
				user.setUser_id(rs.getString(1));
				user.setUser_name(rs.getString(2));
				user.setUser_password(rs.getString(3));
				user.setUser_introduction(rs.getString(4));
				user.setUser_head_img(rs.getString(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			con = null;
			sta = null;
			rs = null;
		}
		return user;
	}

	public List<UserBean> getAll() {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement sta = null;
		ResultSet rs = null;
		List<UserBean> list = new ArrayList<UserBean>();

		try {
			con = JDBCUtils.getInstance().getConnection();
			sta = con.createStatement();
			String sql = "select * from user";
			rs = sta.executeQuery(sql);
			while (rs.next()) {
				UserBean user = new UserBean();
				user.setUser_id(rs.getString(1));
				user.setUser_name(rs.getString(2));
				user.setUser_password(rs.getString(3));
				user.setUser_introduction(rs.getString(4));
				list.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			con = null;
			sta = null;
			rs = null;
		}

		return list;
	}

	public long getCount(String where) {
		// TODO Auto-generated method stub
		return 0;
	}

}
