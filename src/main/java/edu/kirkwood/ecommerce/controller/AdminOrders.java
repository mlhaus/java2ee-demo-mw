package edu.kirkwood.ecommerce.controller;

import edu.kirkwood.ecommerce.model.Order;
import edu.kirkwood.ecommerce.model.OrderDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value="/orders")
public class AdminOrders extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = OrderDAO.getOrdersAdmin();
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("WEB-INF/ecommerce/admin-orders.jsp").forward(req, resp);
    }
}