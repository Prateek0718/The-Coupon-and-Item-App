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
import com.prateek.cni.dao.ItemDAO;
import com.prateek.cni.model.Coupon;
import com.prateek.cni.model.Item;

/**
 * Servlet implementation class ItemController
 */
@WebServlet("/items")
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CouponDAO cdao=new CouponDAO();
       ItemDAO idao=new ItemDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		String price=request.getParameter("price");
		String couponCode=request.getParameter("couponCode");
		Coupon cop=cdao.findCoupon(couponCode);
		Item it=new Item();
		it.setDescription(description);
		it.setName(name);
		it.setPrice(new BigDecimal(price).subtract(cop.getDiscount()));
		idao.save(it);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>Item Created!!!</b>");
		out.print("<br/><a href='index.html'>HOME<a>");
		
		
	}

}
