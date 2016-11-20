<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />

<title>Add Item</title>
</head>
<body>

<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Item</h1>
				<p>Add Item</p>
			</div>
			</div>
	</section>

<section class="container">
		<form:form commandName="newItem"  action="/item/add" class="form-horizontal"
			enctype="multipart/form-data" method = "post">
			<fieldset>
				<div><legend>Add New Item</legend>
				<div class="pull-right" style="padding-right: 20px">
				<a href="?language=en">English</a>|<a href="?language=fr">French</a>
			</div>
		</div>
			
	
				
				<form:errors path="*" cssClass="alert alert-danger" element="div" />
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="itemId"><spring:message
							code="additem.form.itemId.label" /></label>
					<div class="col-lg-10">
						<form:input id="itemId" path="itemId" type="text"
							class="form:input-large" />
						<form:errors path="itemId" cssClass="text-danger" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="itemName"><spring:message
							code="additem.form.name.label" /></label>
					<div class="col-lg-10">
						<form:input id="itemName" path="itemName" type="text"
							class="form:input-large" />
						<form:errors path="itemName" cssClass="text-danger" />
					</div>
				</div>
				
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="itemDescription"><spring:message
							code="additem.form.description.label" /></label>
					<div class="col-lg-10">
						<form:textarea id="itemDescription" path="itemDescription" rows="2" />
					</div>
				</div>
				
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="itemDescription"><spring:message
							code="additem.form.description.label" /></label>
					<div class="col-lg-10">
						<form:textarea id="itemDescription" path="itemDescription" rows="2" />
					</div>
				</div>
				
				
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="itemCategory"><spring:message
							code="additem.form.category.label" /></label>
					<div class="col-lg-10">

						<form:select path="itemCategory">
							<form:option value="-"> Select Category </form:option>
							<c:forEach items="${itemCategory}" var="itemCategory">
								<form:option value="${itemCategory}"> ${itemCategory} </form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="itemImage"><spring:message
							code="additem.form.itemImage.label" /></label>
					<div class="col-lg-10">
						<form:input id="itemImage" path="itemImage" type="file"
							class="form:input-large" />
					</div>
				</div>
				
				
				
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Add" />
					</div>



					<div class="col-lg-offset-2 col-lg-10">
						<a href="<spring:url value="/home" />"
							class="btn btn-primary"> HOME </a>
					</div>

				</div>
				
				
</fieldset>
</form:form>
</section>

</body>
</html>