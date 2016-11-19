<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<div id="headerCellLeft">
</div>

<div id="headerCellRight">

		<spring:url value="/products" var="products" />
		<a href="${products}">products</a>
		|
		<spring:url value="/category" var="category" />
		<a href="${category}">category</a>
		|
		<spring:url value="/stores" var="stores" />
		<a href="${stores}">stores</a>
		|
		<spring:url value="/locations" var="locations" />
		<a href="${locations}">locations</a>
		|
		<spring:url value="/receivings" var="receivings" />
		<a href="${receivings}">receivings</a>
		|

		<spring:url value="/sales" var="sales" />
		<a href="${sales}">sales</a>
		|

		<spring:url value="/logout" var="logout" />
		<a href="${logout}">logout</a>
		
		<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
			<sec:authentication property="principal" var="authentication" />
			<spring:message code="header.account" text="Username" />: ${authentication.username}
		</sec:authorize>
</div>