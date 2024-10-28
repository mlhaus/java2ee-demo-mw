<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setLocale value="en-US" />
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin - All Products</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%@ include file="../../main-nav.jsp"%>
<div class="container py-4">
    <h2>Admin - All Products</h2>
    <div class="table-responsive small">
        <table class="table table-striped table-sm">
            <thead>
            <tr>
                <th scope="col">Edit/Delete</th>
                <th scope="col">Name</th>
                <th scope="col">Price</th>
                <th scope="col">Description</th>
                <th scope="col">Vendor</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="product">
            <tr>
                <td>
                    <a href="edit-product?prod_id=${product.prod_id}" class="btn btn-sm btn-outline-primary">Edit</a>
                    <a href="delete-product?prod_id=${product.prod_id}" class="btn btn-sm btn-outline-danger">Delete</a>
                </td>
                <td>${product.prod_name}</td>
                <td class="text-end"><fmt:formatNumber value="${product.prod_price}" type="currency" /></td>
                <td>${product.prod_desc}</td>
                <td><a href="view-vendor?vend_id=${product.vend_id}">${product.vend_name}</a></td>
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
