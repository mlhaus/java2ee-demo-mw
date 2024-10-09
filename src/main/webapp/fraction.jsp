<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String num1 = (String)request.getAttribute("num1");
    num1 = num1 == null ? "" : num1;
    String den1 = (String)request.getAttribute("den1");
    den1 = den1 == null ? "" : den1;
    String num2 = (String)request.getAttribute("num2");
    num2 = num2 == null ? "" : num2;
    String den2 = (String)request.getAttribute("den2");
    den2 = den2 == null ? "" : den2;

    String result = (String)request.getAttribute("result");
    result = result == null ? "" : result;

    String error = (String)request.getAttribute("error");
    error = error == null ? "" : error;
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Fraction Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<div class="container my-4">
    <h1>Fraction Calculator</h1>
    <p class="lead">Enter two fractions and press submit to calculate the sum.</p>
    <form method="post" action="fraction">
        <div class="row">
            <div class="col-1">
                <div class="form-group mb-2 pb-2 border-bottom border-5">
                    <input type="text" class="form-control" name="num1" value="<%= num1 %>">
                </div>
                <div class="form-group mb-2">
                    <input type="text" class="form-control" name="den1" value="<%= den1 %>">
                </div>
            </div>
            <div class="col-1 d-flex justify-content-center display-3">
                <span>+</span>
            </div>
            <div class="col-1">
                <div class="form-group mb-2 pb-2 border-bottom border-5">
                    <input type="text" class="form-control" name="num2" value="<%= num2 %>">
                </div>
                <div class="form-group mb-2">
                    <input type="text" class="form-control" name="den2" value="<%= den2 %>">
                </div>
            </div>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <div style="color: red;"><%= error %></div>
    <div style="color: green; font-size: 32px;"><%= result %></div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>