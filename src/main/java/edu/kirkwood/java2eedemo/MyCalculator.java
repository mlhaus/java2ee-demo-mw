package edu.kirkwood.java2eedemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static edu.kirkwood.shared.Helpers.round;
import static edu.kirkwood.shared.Validators.isANumber;

@WebServlet(name="myCalculator", value="/my-calculator")
public class MyCalculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("my-calculator.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        req.setAttribute("num1", num1);
        req.setAttribute("num2", num2);
        
        boolean errorFound = false;
        if(!isANumber(num1)) {
            req.setAttribute("num1Error", "Number 1 is not valid");
            errorFound = true;
        }
        if(!isANumber(num2)) {
            req.setAttribute("num2Error", "Number 2 is not valid");
            errorFound = true;
        }
        if(errorFound) {
            req.getRequestDispatcher("my-calculator.jsp").forward(req, resp);
            return;
        }
        
        double sum = getSum(num1, num2);
        req.setAttribute("result", String.format("%s + %s = %s", num1, num2, round(sum,10)));
        req.getRequestDispatcher("my-calculator.jsp").forward(req, resp);
    }


    private static double getSum(String num1, String num2) {
        double n1 = Double.parseDouble(num1);
        double n2 = Double.parseDouble(num2);
        return n1 + n2;
    }
}
