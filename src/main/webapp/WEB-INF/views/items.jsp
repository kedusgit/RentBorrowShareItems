<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Item List</title>
</head>
<body>


<section class="container" id="items">
				<div class="row">
					<c:forEach items="${items}" var="item">

						<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
							<div class="thumbnail">
								<%-- <img
									src="<c:url value="/resource/images/${item.itemId}.png"></c:url>"
									alt="image" style="width: 100px"> --%>
								<div class="caption">
									<h3>${item.itemName}</h3>
									<p>${item.itemDescription}</p>
									<p>${item.itemDescription}</p>

									<p>
										<spring:url value="/item/{itemId}" var="detail">
											<spring:param name="itemId" value="${item.itemId}" />
										</spring:url>

										<a href="${detail}" class="btn btn-default"> <span
											class="glyphicon-hand-left glyphicon"></span> Detail
										</a>
									</p>

								</div>
							</div>
						</div>
					</c:forEach>
				</div>


</body>
</html>