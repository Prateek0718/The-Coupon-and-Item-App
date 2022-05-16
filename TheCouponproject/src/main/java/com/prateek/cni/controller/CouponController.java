package com.prateek.cni.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prateek.cni.dao.CouponDAO;
import com.prateek.cni.model.Coupon;

/**
 * Servlet implementation class CouponController
 */
@WebServlet("/coupons")
public class CouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CouponDAO dao=new CouponDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CouponController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action.equals("create")) {
		createCoupon(request, response);
		}
		else if(action.equals("find")) {
			findCoupon(request,response);
		}
		
	}

	private void createCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String couponCode=request.getParameter("couponCode");
		String discount=request.getParameter("discount");
		String expiryDate=request.getParameter("expiryDate");
		Coupon cop=new Coupon();
		cop.setCode(couponCode);
		cop.setDiscount(new BigDecimal(discount));
		cop.setExpDate(expiryDate);
		dao.save(cop);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>Coupon created!!!</b>");
		out.print("<br/><a href='index.html'>HOME<a>");
	}
	public void findCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String couponcode=request.getParameter("couponCode");
		Coupon cop=dao.findCoupon(couponcode);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>Coupon Details</b>");
		out.print(cop);
		out.print("<br/><a href='index.html'>HOME<a>");
	}

}
