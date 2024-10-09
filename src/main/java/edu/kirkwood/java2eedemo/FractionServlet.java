package edu.kirkwood.java2eedemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(value="/fraction")
public class FractionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("fraction.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String den1 = req.getParameter("den1");
        String num2 = req.getParameter("num2");
        String den2 = req.getParameter("den2");
        req.setAttribute("num1", num1);
        req.setAttribute("den1", den1);
        req.setAttribute("num2", num2);
        req.setAttribute("den2", den2);
        
        String error = "";
        Fraction f1 = new Fraction();
        try {
            f1.setNumerator(Integer.parseInt(num1));
        } catch(NumberFormatException e) {
            error += "<li>Numerator 1 not valid</li>";
        }
        try {
            f1.setDenominator(Integer.parseInt(den1));
        } catch(NumberFormatException e) {
            error += "<li>Denominator 1 not valid</li>";
        } catch(ArithmeticException e) {
            error += "<li>Denominator 1 cannot be 0</li>";
        }


        Fraction f2 = new Fraction();
        try {
            f2.setNumerator(Integer.parseInt(num2));
        } catch(NumberFormatException e) {
            error += "<li>Numerator 2 not valid</li>";
        }
        try {
            f2.setDenominator(Integer.parseInt(den2));
        } catch(NumberFormatException e) {
            error += "<li>Denominator 2 not valid</li>";
        } catch(ArithmeticException e) {
            error += "<li>Denominator 2 cannot be 0</li>";
        }
        
        if(!error.equals("")) {
            req.setAttribute("error", "<ul>" + error + "</ul>");
            req.getRequestDispatcher("fraction.jsp").forward(req, resp);
            return;
        }
        
        String result = f1.add(f2);
        req.setAttribute("result", result);
        req.getRequestDispatcher("fraction.jsp").forward(req, resp);
    }
}
