package edu.kirkwood.ecommerce.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/vendors")
public class AdminVendors extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Week 9 assignment, call VendorDAO.getVendors to get a List<Vendor>
        // Set the List<Vendor> as an attribute
        req.getRequestDispatcher("WEB-INF/ecommerce/admin-vendors.jsp").forward(req, resp);
    }
}
