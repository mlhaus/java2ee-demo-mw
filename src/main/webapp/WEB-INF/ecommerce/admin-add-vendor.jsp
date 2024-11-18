<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add New Vendor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%@include file="../../main-nav.jsp"%>
<div class="container py-4">
    <a href="vendors" class="btn btn-primary" role="button">View All Vendors</a>
    <h2>Add New Vendor</h2>
    <c:if test="${empty validationErrors}">
    <div class="alert <c:choose><c:when test="${vendorAdded}">alert-success</c:when><c:otherwise>alert-danger</c:otherwise></c:choose>" role="alert">
         ${vendorAddedMessage}
    </div>
    </c:if>
    <form class="row g-3" method="POST" action="add-vendor">
        <div class="col-md-3">
            <label for="vendorId" class="form-label">Vendor Id</label>
            <input type="text" class="form-control <c:choose><c:when test="${not empty vendorIdError}">is-invalid</c:when><c:otherwise>is-valid</c:otherwise></c:choose>" id="vendorId" name="vendorId" value="${vendorId}">
            <div id="vendor-id-feedback" class="<c:choose><c:when test="${not empty vendorIdError}">invalid-feedback</c:when><c:otherwise>valid-feedback</c:otherwise></c:choose>">
                <c:choose><c:when test="${not empty vendorIdError}">${vendorIdError}</c:when><c:otherwise>Looks good!</c:otherwise></c:choose>
            </div>
        </div>
        <div class="col-md-9">
            <label for="vendorName" class="form-label">Vendor name</label>
            <input type="text" class="form-control <c:choose><c:when test="${not empty vendorNameError}">is-invalid</c:when><c:otherwise>is-valid</c:otherwise></c:choose>" id="vendorName" name="vendorName" value="${vendorName}">
            <div id="vendor-name-feedback" class="<c:choose><c:when test="${not empty vendorNameError}">invalid-feedback</c:when><c:otherwise>valid-feedback</c:otherwise></c:choose>">
                <c:choose><c:when test="${not empty vendorNameError}">${vendorNameError}</c:when><c:otherwise>Looks good!</c:otherwise></c:choose>
            </div>
        </div>
        <div class="col-md-6">
            <label for="streetAddress" class="form-label">Street Address</label>
            <div class="input-group has-validation">
                <input type="text" class="form-control <c:choose><c:when test="${not empty streetAddressError}">is-invalid</c:when><c:otherwise>is-valid</c:otherwise></c:choose>" id="streetAddress" name="streetAddress" value="${streetAddress}">
                <div id="street-address-feedback" class="<c:choose><c:when test="${not empty streetAddressError}">invalid-feedback</c:when><c:otherwise>valid-feedback</c:otherwise></c:choose>">
                    <c:choose><c:when test="${not empty streetAddressError}">${streetAddressError}</c:when><c:otherwise>Looks good!</c:otherwise></c:choose>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <label for="zip" class="form-label">Zip</label>
            <input type="text" class="form-control <c:choose><c:when test="${not empty zipError}">is-invalid</c:when><c:otherwise>is-valid</c:otherwise></c:choose>" id="zip" name="zip" value="${zip}">
            <div id="zip-feedback" class="<c:choose><c:when test="${not empty zipError}">invalid-feedback</c:when><c:otherwise>valid-feedback</c:otherwise></c:choose>">
                <c:choose><c:when test="${not empty zipError}">${zipError}</c:when><c:otherwise>Looks good!</c:otherwise></c:choose>
            </div>
        </div>
        <div class="col-md-4">
            <label for="city" class="form-label">City</label>
            <input type="text" class="form-control <c:choose><c:when test="${not empty cityError}">is-invalid</c:when><c:otherwise>is-valid</c:otherwise></c:choose>" id="city" name="city" value="${city}">
            <div id="city-feedback" class="<c:choose><c:when test="${not empty cityError}">invalid-feedback</c:when><c:otherwise>valid-feedback</c:otherwise></c:choose>">
                <c:choose><c:when test="${not empty cityError}">${cityError}</c:when><c:otherwise>Looks good!</c:otherwise></c:choose>
            </div>
        </div>
        <div class="col-md-4">
            <label for="state" class="form-label">State</label>
            <%-- TODO: Replace input with a select menu to limit the options --%>
            <input type="text" class="form-control <c:choose><c:when test="${not empty stateError}">is-invalid</c:when><c:otherwise>is-valid</c:otherwise></c:choose>" id="state" name="state" value="${state}">
            <div id="state-feedback" class="<c:choose><c:when test="${not empty stateError}">invalid-feedback</c:when><c:otherwise>valid-feedback</c:otherwise></c:choose>">
                <c:choose><c:when test="${not empty stateError}">${stateError}</c:when><c:otherwise>Looks good!</c:otherwise></c:choose>
            </div>
        </div>
        <div class="col-md-4">
            <label for="country" class="form-label">Country</label>
            <%-- TODO: Replace input with a select menu to limit the options --%>
            <input type="text" class="form-control <c:choose><c:when test="${not empty countryError}">is-invalid</c:when><c:otherwise>is-valid</c:otherwise></c:choose>" id="country" name="country" value="${country}">
            <div id="country-feedback" class="<c:choose><c:when test="${not empty countryError}">invalid-feedback</c:when><c:otherwise>valid-feedback</c:otherwise></c:choose>">
                <c:choose><c:when test="${not empty countryError}">${countryError}</c:when><c:otherwise>Looks good!</c:otherwise></c:choose>
            </div>
        </div>
        <div class="col-12">
            <button class="btn btn-primary" type="submit">Submit form</button>
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
