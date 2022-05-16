package com.prateek.cni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.prateek.cni.model.Coupon;
import com.prateek.cni.util.ConnectionUtil;

public class CouponDAO {
	public void save(Coupon cop) {
		Connection con=ConnectionUtil.getConnection();
		try {
			PreparedStatement stmt=con.prepareStatement("insert into coupon(code,discount,exp_date) values (?,?,?)");
			stmt.setString(1, cop.getCode());
			stmt.setBigDecimal(2,cop.getDiscount());
			stmt.setString(3, cop.getExpDate());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public Coupon findCoupon(String code) {
		Coupon cop=new Coupon();
		
		Connection con=ConnectionUtil.getConnection();
		try {
			PreparedStatement stmt=con.prepareStatement("select * from coupon where code=?");
			stmt.setString(1, code);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				cop.setId(rs.getInt(1));
				cop.setCode(rs.getString(2));
				cop.setDiscount(rs.getBigDecimal(3));
				cop.setExpDate(rs.getString(4));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cop;
		
	}

}
