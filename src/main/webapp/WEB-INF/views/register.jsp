<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="content">
	<c:if test="${not empty success}">
  		<c:out value="${success}" />
  	</c:if>
	<!-- BEGIN REGISTRATION FORM -->
	<form:form method="POST" class="register-form" action="register"  modelAttribute="loginUser">
		<h3>Sign Up</h3>
		<p class="hint">
			 Enter your personal details below:
		</p>
		<div class="form-group">
			<form:label path="firstName" class="control-label visible-ie8 visible-ie9">First Name</form:label>
			<form:input path="firstName" class="form-control placeholder-no-fix" type="text" placeholder="First Name"  name="firstName" />
			<form:errors path="firstName" cssClass="text-danger"/>
		</div>
		<div class="form-group">
			<form:label path="lastName" class="control-label visible-ie8 visible-ie9">Last Name</form:label>
			<form:input path="lastName" class="form-control placeholder-no-fix" type="text" placeholder="Last Name"  name="lastName" />
			<form:errors path="lastName" cssClass="text-danger"/>
		</div>
		<div class="form-group">
		    <form:label path="gender" class="control-label visible-ie8 visible-ie9">Gender</form:label>
			<form:select path="gender" name="gender" class="form-control">
				<option value="1">Male</option>
				<option value="0">Female</option>
			</form:select>
		</div>
		
		<div class="form-group">
			<form:label path="email" class="control-label visible-ie8 visible-ie9">Email</form:label>
			<form:input path="email" class="form-control placeholder-no-fix" type="text" placeholder="Email" name="email"/>
			<form:errors path="email" cssClass="text-danger"/>
		</div>
		
		<p class="hint">
			 Enter your account details below:
		</p>
		<div class="form-group">
			<form:label path="username" class="control-label visible-ie8 visible-ie9">UserName</form:label>
			<form:input path="username" class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="Username" name="username"/>
			<form:errors path="username" cssClass="text-danger"/>
		</div>
		
		
		<div class="form-group">
			<form:label path="password" class="control-label visible-ie8 visible-ie9">Password</form:label>
			<form:input path="password" class="form-control placeholder-no-fix" id="register_password" type="password" autocomplete="off" placeholder="Password" name="password"/>
			<form:errors path="password" cssClass="text-danger"/>
			
		</div>
		
		<div class="form-group">
			<form:label path="verifyPassword" class="control-label visible-ie8 visible-ie9">verifyPassword</form:label>
			<form:input path="verifyPassword" class="form-control placeholder-no-fix" id="register_password" type="password" autocomplete="off" placeholder="Password" name="verifyPassword"/>
			<form:errors path="verifyPassword" cssClass="text-danger"/>
			
		</div>
		
		<div class="form-group">
			<label class="control-label col-lg-2" for="authority">Role</label>
			<form:input class="form-control placeholder-no-fix" name="authoritieses[0].authority" path="authoritieses[0].authority" type="text" value="ROLE_USER" />
			<form:errors path="authoritieses[0].authority" cssClass="text-danger"/>
		</div>
		<form:hidden path="enabled" value="TRUE"  />
		<div class="form-actions">
			<button type="submit" id="register-submit-btn" class="btn btn-success uppercase pull-right">Submit</button>
		</div>
	</form:form>

</div>
