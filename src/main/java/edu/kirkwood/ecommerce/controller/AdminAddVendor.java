package edu.kirkwood.ecommerce.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/add-vendor")
public class AdminAddVendor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/ecommerce/admin-add-vendor.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String vendorId = req.getParameter("vendorId");
        String vendorName = req.getParameter("vendorName");
        String streetAddress = req.getParameter("streetAddress");
        String zip = req.getParameter("zip");
        String city = req.getParameter("city");
        String state = req.getParameter("state");
        String country = req.getParameter("country");
        req.setAttribute("vendorId", vendorId);
        req.setAttribute("vendorName", vendorName);
        req.setAttribute("streetAddress", streetAddress);
        req.setAttribute("zip", zip);
        req.setAttribute("city", city);
        req.setAttribute("state", state);
        req.setAttribute("country", country);

        req.setAttribute("vendorIdError", "Invalid vendor id");
        req.setAttribute("vendorNameError", "Invalid vendor name");
        req.setAttribute("streetAddressError", "Invalid street address");
        req.setAttribute("zipError", "Invalid zip");
        req.setAttribute("cityError", "Invalid city");
        req.setAttribute("stateError", "Invalid state");
        req.setAttribute("countryError", "Invalid country");



        req.getRequestDispatcher("WEB-INF/ecommerce/admin-add-vendor.jsp").forward(req, resp);
    }
}
