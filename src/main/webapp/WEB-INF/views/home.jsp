<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
<head>
<head>
	
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script type="text/javascript" src="<spring:url value="/resources/js/common.js"/>"></script>
	<script type="text/javascript" src="<spring:url value="/resources/js/store.js"/>"></script>
</head>
<body>
	<div id="centerDiv">
	<h1>home</h1>
	</div>
	
	<div class="col-lg-offset-2 col-lg-10">
						<a href="<spring:url value="/item/all"/>"
							class="btn btn-primary"> Show Items</a>
					</div>
					
					
					
					
					
	<div class="col-lg-offset-2 col-lg-10">
						<a href="<spring:url value="/item/search"/>"
							class="btn btn-primary">SEARCH</a>
					</div>
		
	
	<p> 
					<a href="<spring:url value="/Add" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> Add Items
					</a>
					
					<a href="<spring:url value="/home" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> Home
					</a>
		</p>
	
</body>
</html>