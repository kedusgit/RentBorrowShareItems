<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>edit Item</title>
</head>
<body>

<div id="centerDiv">
	<section>
		<div class="jumbotron">
			<div class="container">
				<h5>Item edit</h5>
			</div>
		</div>
		
		<section class="container">
        <form:form action="/item/editItem" method="post"  enctype="multipart/form-data">

         <form:hidden path="itemId" value="${item.itemId}" />

            <div class="form-group">
                <label for="name">Name</label>
                <form:errors path="name" cssStyle="color:#ff0000;" />
                <form:input path="itemName" id="itemName" class="form-Control" value="${item.itemName}"/>
            </div>

           
           <div class="form-group">
                <label for="description">itemPrice</label>
                <form:textarea path="description" id="description" class="form-Control" value="${item.itemPrice}"/>
            </div>
           
            <div class="form-group">
                <label for="description">Description</label>
                <form:textarea path="description" id="description" class="form-Control" value="${item.itemDescription}"/>
            </div>
		
		</form:form>
		
	</section>

            <br/><br/>

            <input type="submit" value="submit" class="btn btn-default">
            <a href="<c:url value="/item/add" />" class="btn btn-default">Update</a>

<div class="col-lg-offset-2 col-lg-10">
					<a href="<spring:url value="/home" />" class="btn btn-primary">
						HOME </a>
				</div>

</body>
</html>