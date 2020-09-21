package com.zy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.zy.model.House;
import com.zy.model.User;
import com.zy.util.DBUtil;

/**
 * @author 2768278679@qq.com Dao:Data Access Object 该类的功能就是操作数据库
 *         将查询到的数据,封装金java对象中 java对象要与数据库表一致 ==>类属性和表字段一致
 *         ==>类的对象的属性值，和表中的字段的数据一致
 *
 *         findByUsername findByUsernameAndPassword
 */
public class UserDao {
	
	//定义以用户名密码查询数据库的方法
	 
	public User findUserByUsernameAndPassword(String uname, String upassword) {
		// 获得连接对象
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 声明User对象
		User user = null;
		try {
			// 通过将sql语句中的岁数设置成?,利用prepareStatement预处理该sql语句
			ps = conn.prepareStatement("select*from user where uname=? and upassword=?");
			// 将处理过的sql语句向?处设置参数
			ps.setString(1, uname);
			ps.setString(2, upassword);
			// 执行该sql
			rs = ps.executeQuery();
			while (rs.next()) {
				// 查到了,创建对象
				user = new User();
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setUpassword(rs.getString("upassword"));
				user.setUrealname(rs.getString("urealname"));
				user.setUaddTime(rs.getDate("uaddTime"));
				user.setUstatus(rs.getInt("ustatus"));
		
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		return user;
	}

		
		//查询全部的
	public ArrayList<User> findAll() {
		Connection conn = null;
		Statement s = null;
		ResultSet rs = null;
		User user = null;
		
	
		ArrayList<User> list = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			s = conn.createStatement();
			rs = s.executeQuery("select * from user");

			while (rs.next()) {
				// 创建java对象,将结果集中的数据封装进对象
				user = new User();
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setUpassword(rs.getString("upassword"));
				user.setUrealname(rs.getString("urealname"));
				user.setUaddTime(rs.getDate("uaddTime"));
				user.setUstatus(rs.getInt("ustatus"));
				// 将数据添加进集合
				list.add(user);
			}
		} catch (SQLException e) {
			System.out.println("sql异常");
		} finally {
			DBUtil.closeAll(rs, s, conn);
		}
		return list;
	}		 
		

		//通过uid查找对应用户信息
		public User findInfoById(int uid) {
			Connection conn = null;
			PreparedStatement s = null;
			ResultSet rs = null;
			User user= null;
			try {
				conn = DBUtil.getConnection();
				s = conn.prepareStatement("select * from user where uid=?");
				s.setInt(1, uid);
				rs = s.executeQuery();
				
				while (rs.next()) {
					// 创建java对象,将结果集中的数据封装进对象
					user = new User();
					user.setUid(rs.getInt("uid"));
					user.setUname(rs.getString("uname"));
					user.setUpassword(rs.getString("upassword"));
					user.setUrealname(rs.getString("urealname"));
					user.setUaddTime(rs.getDate("uaddTime"));
					user.setUstatus(rs.getInt("ustatus"));
									
				}
			} catch (SQLException e) {
				System.out.println("sql异常");
			} finally {
				DBUtil.closeAll(rs, s, conn);
			}
			return user;
		}

		//增添用户
		public int add(User user) {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps=null;
			int num=0;
			try {
				ps = conn.prepareStatement("insert into user (uname,upassword,urealname,uaddTime,ustatus) values(?,?,?,?,?)");
				ps.setString(1, user.getUname());
				ps.setString(2, user.getUpassword());
				ps.setString(3, user.getUrealname());
				ps.setString(4, new SimpleDateFormat("yyyy-MM-dd").format(user.getUaddTime()));
				ps.setInt(5, user.getUstatus());
				
				num = ps.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				DBUtil.closeAll(null, ps, conn);
			}
			return num;
			
		}

		//
		public User findUserById(int uid) {
			Connection conn = null;
			PreparedStatement s = null;
			ResultSet rs = null;
			User user = null;
			try {
				conn = DBUtil.getConnection();
				s = conn.prepareStatement("select * from user where uid=?");
				s.setInt(1, uid);
				rs = s.executeQuery();
				
				while (rs.next()) {
					// 创建java对象,将结果集中的数据封装进对象
					user = new User();
					user.setUid(rs.getInt("uid"));
					user.setUname(rs.getString("uname"));
					user.setUpassword(rs.getString("upassword"));
					user.setUrealname(rs.getString("urealname"));
					user.setUaddTime(rs.getDate("uaddTime"));
					user.setUstatus(rs.getInt("ustatus"));
				}
			} catch (SQLException e) {
				System.out.println("sql异常");
			} finally {
				DBUtil.closeAll(rs, s, conn);
			}
			return user;
		}

		//修改单个用户
		public void updateUser(User user) {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps=null;
			
			try {
				ps = conn.prepareStatement("update user set uname=?,upassword=?,urealname=?,uaddTime=?,ustatus=? where uid=?");
				
				ps.setString(1, user.getUname());
				ps.setString(2, user.getUpassword());
				ps.setString(3, user.getUrealname());
				ps.setString(4, new SimpleDateFormat("yyyy-MM-dd").format(user.getUaddTime()));
				ps.setInt(5, user.getUstatus());
				ps.setInt(6, user.getUid());
				
				ps.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				DBUtil.closeAll(null, ps, conn);
			}
		}


		public void delUserById(int uid) {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps=null;
			
			try {
				ps = conn.prepareStatement("delete from user where uid=?");
				
				ps.setInt(1, uid);
				ps.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				DBUtil.closeAll(null, ps, conn);
			}		
		}


		public ArrayList<User> findUserAndWords(String field,String keywords) {
			System.out.println("接收"+keywords);
			Connection conn = null;
			Statement s = null;
			ResultSet rs = null;
			User user = null;
			ArrayList<User> list = new ArrayList<>();
			String sql = "select * from user where "+field+" like '%"+keywords+"%'";
			try {
				conn = DBUtil.getConnection();
				s = conn.createStatement();
				rs = s.executeQuery(sql);
				
				while (rs.next()) {
					// 创建java对象,将结果集中的数据封装进对象
					user = new User();
					user.setUid(rs.getInt("uid"));
					user.setUname(rs.getString("uname"));
					user.setUpassword(rs.getString("upassword"));
					user.setUrealname(rs.getString("urealname"));
					user.setUaddTime(rs.getDate("uaddTime"));
					user.setUstatus(rs.getInt("ustatus"));
					// 将数据添加进集合
					list.add(user);
					System.out.println("aaaaaaaaaa"+list);
				}
			} catch (SQLException e) {
				System.out.println("sql异常");
			} finally {
				DBUtil.closeAll(rs, s, conn);
			}
			return list;
		}
		//分页
		public ArrayList<User> findAll(int start,int end) {
			Connection conn = null;
			Statement s = null;
			ResultSet rs = null;
			User user = null;
			String sql="select * from user limit "+start+","+end+"";
			System.out.println("拼接好:"+sql);
			ArrayList<User> list = new ArrayList<>();
			try {
				conn = DBUtil.getConnection();
				s = conn.createStatement();
				rs = s.executeQuery(sql);
	
				while (rs.next()) {
					// 创建java对象,将结果集中的数据封装进对象
					user = new User();
					user.setUid(rs.getInt("uid"));
					user.setUname(rs.getString("uname"));
					user.setUpassword(rs.getString("upassword"));
					user.setUrealname(rs.getString("urealname"));
					user.setUaddTime(rs.getDate("uaddTime"));
					user.setUstatus(rs.getInt("ustatus"));
					// 将数据添加进集合
					list.add(user);
				}
			} catch (SQLException e) {
				System.out.println("sql异常");
			} finally {
				DBUtil.closeAll(rs, s, conn);
			}
			return list;
		}

		
}
