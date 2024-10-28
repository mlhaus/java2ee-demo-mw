<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setLocale value="en-US" />
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin - All Orders</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%@ include file="../../main-nav.jsp"%>
<div class="container py-4">
    <h2>Admin - All Orders</h2>
    <div class="table-responsive small">
        <table class="table table-striped table-sm" style="max-width: 500px">
            <thead>
            <tr>
                <th scope="col">Edit/Delete</th>
                <th scope="col">Order Date</th>
                <th scope="col">Customer</th>
                <th scope="col">Total Sale</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td>
                        <a href="edit-order?order_id=${order.order_num}" class="btn btn-sm btn-outline-primary">Edit</a>
                        <a href="delete-order?order_id=${order.order_num}" class="btn btn-sm btn-outline-danger">Delete</a>
                    </td>
                    <td class="text-end">${order.order_date}</td>
                    <td><a href="view-customer?cust_id=${order.cust_id}">${order.cust_name}</a></td>
                    <td></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
