<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/resources/css/main.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link href="/resources/css/bootstrap.min.css" type="text/css"
	rel="stylesheet">
<link href="/resources/css/bootstrap.css" type="text/css"
	rel="stylesheet">
<link href="/resources/css/font-awesome.css" type="text/css"
	rel="stylesheet">
<link href="/resources/css/font-awesome.min.css" type="text/css"
	rel="stylesheet">
<title>Item List</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<h2>Item List</h2>
				<form action="/item/search" method="POST">
					<select name="category">
						<c:forEach items="${itemCategories}" var="categItem">
							<option value="${categItem}"> ${categItem} </option>
						</c:forEach>
					</select>
					<div id="custom-search-input">
						<div class="input-group col-md-12">
							<input style="width: 700px; height: 40px;" type="text"
								id="searchText" class="form-control input-lg"
								placeholder="Search" name="searchText" /> <span class="input-group-btn">
								<input type="submit"
									value = "search" />
							</span>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<br />
	<br />
	<fieldset>
		<section class="container" id="items">
		<div class="row">
			<c:forEach items="${items}" var="item">

				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<spring:url value="/item/image/{itemId}" var="imagePath">
							<spring:param name="itemId" value="${item.itemId}" />
						</spring:url>
						<img src="<spring:url value='${imagePath}'/>" alt="image"
							style="width: 200px" />
						<div class="caption">
							<h3>Name : ${item.itemName}</h3>
							<p>Description : ${item.itemDescription}</p>
							<p>Category : ${item.itemCategory}</p>
							<p>Quantity : ${item.itemQuantity}</p>

							<p>
							<div class="btn btn-info">
								<span class="fa fa-dollar"></span> <strong>${item.itemPrice}</strong>
							</div>

							<spring:url value="/item/{itemId}" var="detail">
								<spring:param name="itemId" value="${item.itemId}" />
							</spring:url>
							<a href="<c:url value="/item/get/${item.itemId}" />"
								class="btn btn-default"> <span
								class="glyphicon glyphicon-briefcase"></span> <strong>${item.itemStatus}</strong>
							</a>
							</p>
						</div>
					</div>

				</div>
			</c:forEach>
		</div>
	</fieldset>
</body>
</html>