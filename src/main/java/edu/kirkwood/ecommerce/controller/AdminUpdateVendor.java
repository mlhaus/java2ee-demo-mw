package edu.kirkwood.ecommerce.controller;

import edu.kirkwood.ecommerce.model.Vendor;
import edu.kirkwood.ecommerce.model.VendorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value="/edit-vendor")
public class AdminUpdateVendor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String vend_id = req.getParameter("vend_id");
        Vendor vendor = VendorDAO.getVendor(vend_id);
        req.setAttribute("vendor", vendor);
        req.getRequestDispatcher("WEB-INF/ecommerce/admin-update-vendor.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/ecommerce/admin-update-vendor.jsp").forward(req, resp);
    }
}
