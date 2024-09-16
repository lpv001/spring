<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/portal" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<t:baseLayout title="Register">
	<jsp:attribute name="content"> 
   
            <div class="container p-4">
                <div class="row justify-content-center">
                    <div class="col-md-6">
                        <form:form action="/signin" method='POST' modelAttribute="loginVo">
                            <div class="mb-3"> 
                                <label for="username" class="form-label">Username</label>
                                <form:input type="text" class="form-control" id="username" path="username" placeholder="Enter username" />
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">Password</label>
                                <form:input type="password" class="form-control" id="password" path="password" placeholder="Password" />
                            </div>
                            <div class="d-flex flex-row justify-content-between">
                                <button type="submit" class="btn btn-primary">Login</button>
                                <p class="m-2">
                                    <span>Don't have an account? </span>
                                    <a href="/register">register</a>
                                </p>
                            </div>
                        </form:form>
                    </div>
                </div> 
            </div>
        
     </jsp:attribute>
</t:baseLayout>