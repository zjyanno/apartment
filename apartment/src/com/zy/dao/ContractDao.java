package com.zy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.zy.model.Contract;
import com.zy.model.User;
import com.zy.util.DBUtil;

public class ContractDao {

	public ArrayList<Contract> findAll() {
		Connection conn = null;
		Statement s = null;
		ResultSet rs = null;
		Contract contract = null;
		ArrayList<Contract> list = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			s = conn.createStatement();
			rs = s.executeQuery("select * from contract");

			while (rs.next()) {
				// 创建java对象,将结果集中的数据封装进对象
				contract = new Contract();
				contract.setCid(rs.getInt("cid"));
				contract.setCnum(rs.getString("cnum"));
				contract.setChid(rs.getInt("chid"));
				contract.setClid(rs.getInt("clid"));
				contract.setCtime(rs.getDate("ctime"));
				contract.setCstartTime(rs.getDate("cstartTime"));
				contract.setCendTime(rs.getDate("cendTime"));
				contract.setCtotalMoney(rs.getDouble("ctotalMoney"));
				contract.setCpayType(rs.getInt("cpayType"));
				
				// 将数据添加进集合
				list.add(contract);
			}
		} catch (SQLException e) {
			System.out.println("sql异常");
		} finally {
			DBUtil.closeAll(rs, s, conn);
		}
		return list;
	}

	public Contract dindInfoById(int cid) {
		Connection conn = null;
		PreparedStatement s = null;
		ResultSet rs = null;
		Contract contract= null;
		try {
			conn = DBUtil.getConnection();
			s = conn.prepareStatement("select * from contract where cid=?");
			s.setInt(1, cid);
			rs = s.executeQuery();
			
			while (rs.next()) {
				// 创建java对象,将结果集中的数据封装进对象
				contract = new Contract();
				contract.setCid(rs.getInt("cid"));
				contract.setCnum(rs.getString("cnum"));
				contract.setChid(rs.getInt("chid"));
				contract.setClid(rs.getInt("clid"));
				contract.setCtime(rs.getDate("ctime"));
				contract.setCstartTime(rs.getDate("cstartTime"));
				contract.setCendTime(rs.getDate("cendTime"));
				contract.setCtotalMoney(rs.getDouble("ctotalMoney"));
				contract.setCpayType(rs.getInt("cpayType"));
								
			}
		} catch (SQLException e) {
			System.out.println("sql异常");
		} finally {
			DBUtil.closeAll(rs, s, conn);
		}
		return contract;
	}

	public int add(Contract contract) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps=null;
		int num=0;
		try {
			ps = conn.prepareStatement("insert into contract (cnum,chid,clid,ctime,cstartTime,cendTime,ctotalMoney,cpayType) values(?,?,?,?,?,?,?,?)");
			ps.setString(1, contract.getCnum());
			ps.setInt(2, contract.getChid());
			ps.setInt(3, contract.getClid());
			
			ps.setString(4, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(contract.getCtime()));
			ps.setString(5, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(contract.getCstartTime()));
			ps.setString(6, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(contract.getCendTime()));
			ps.setDouble(7, contract.getCtotalMoney());
			ps.setInt(8, contract.getCpayType());
			
			num = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(null, ps, conn);
		}
		return num;
	}

	public Contract findContractById(int cid) {
		Connection conn = null;
		PreparedStatement s = null;
		ResultSet rs = null;
		Contract contract= null;
		try {
			conn = DBUtil.getConnection();
			s = conn.prepareStatement("select * from contract where cid=?");
			s.setInt(1, cid);
			rs = s.executeQuery();
			
			while (rs.next()) {
				// 创建java对象,将结果集中的数据封装进对象
				contract = new Contract();
				contract.setCid(rs.getInt("cid"));
				contract.setCnum(rs.getString("cnum"));
				contract.setChid(rs.getInt("chid"));
				contract.setClid(rs.getInt("clid"));
				contract.setCtime(rs.getDate("ctime"));
				contract.setCstartTime(rs.getDate("cstartTime"));
				contract.setCendTime(rs.getDate("cendTime"));
				contract.setCtotalMoney(rs.getDouble("ctotalMoney"));
				contract.setCpayType(rs.getInt("cpayType"));
								
			}
		} catch (SQLException e) {
			System.out.println("sql异常");
		} finally {
			DBUtil.closeAll(rs, s, conn);
		}
		return contract;
	}

	public void updateContract(Contract contract) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps=null;
		
		try {
			ps = conn.prepareStatement("update contract set cnum=?,chid=?,clid=?,ctime=?,cstartTime=?,cendTime=?,ctotalMoney=?,cpayType=? where cid=?");
			
			ps.setString(1, contract.getCnum());
			ps.setInt(2, contract.getChid());
			ps.setInt(3, contract.getClid());
			ps.setString(4, new SimpleDateFormat("yyyy-MM-dd").format(contract.getCtime()));
			ps.setString(5, new SimpleDateFormat("yyyy-MM-dd").format(contract.getCstartTime()));
			ps.setString(6, new SimpleDateFormat("yyyy-MM-dd").format(contract.getCendTime()));
			ps.setDouble(7, contract.getCtotalMoney());
			ps.setInt(8, contract.getCpayType());
			ps.setInt(9, contract.getCid());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(null, ps, conn);
		}
	}

	public void delContractById(int cid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps=null;
		
		try {
			ps = conn.prepareStatement("delete from contract where cid=?");
			
			ps.setInt(1, cid);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(null, ps, conn);
		}		
	}

	public ArrayList<Contract> findContractAndWords(String field, String keywords) {
		Connection conn = null;
		Statement s = null;
		ResultSet rs = null;
		Contract contract = null;
		ArrayList<Contract> list = new ArrayList<>();
		String sql="select * from contract where "+field+" like '%"+keywords+"%'";
		try {
			conn = DBUtil.getConnection();
			s = conn.createStatement();
			rs=s.executeQuery(sql);

			while (rs.next()) {
				// 创建java对象,将结果集中的数据封装进对象
				contract = new Contract();
				contract.setCid(rs.getInt("cid"));
				contract.setCnum(rs.getString("cnum"));
				contract.setChid(rs.getInt("chid"));
				contract.setClid(rs.getInt("clid"));
				contract.setCtime(rs.getDate("ctime"));
				contract.setCstartTime(rs.getDate("cstartTime"));
				contract.setCendTime(rs.getDate("cendTime"));
				contract.setCtotalMoney(rs.getDouble("ctotalMoney"));
				contract.setCpayType(rs.getInt("cpayType"));
				
				// 将数据添加进集合
				list.add(contract);
			}
		} catch (SQLException e) {
			System.out.println("sql异常");
		} finally {
			DBUtil.closeAll(rs, s, conn);
		}
		return list;
	}		
}
