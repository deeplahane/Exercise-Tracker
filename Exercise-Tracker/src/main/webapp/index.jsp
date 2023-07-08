<%@page import="com.entities.Message"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="all_css.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<%
	Message m = (Message) session.getAttribute("msg");
	if (m != null) {
	%>
	<div class="mb-0 alert <%=m.getCssClass()%>">
		<%=m.getContent()%></div>
	<%
	}
	session.removeAttribute("msg");
	%>
	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active ">
				<img class="d-block w-100" src="img/ex1.jpg" alt="First slide"
					height="560px">
				<div class="carousel-caption d-none d-md-block">

					<div class="text-light p-2 ">
						<h3>"Once you are exercising regularly, the hardest thing is to stop it."</h3>
					</div>
				</div>
			</div>
			<div class="carousel-item ">
				<img class="d-block w-100" src="img/ex3.jpg" alt="Second slide"
					height="560px">
				<div class="carousel-caption d-none d-md-block">

					<div class="text-light p-2 ">
						<h3>"What seems impossible today will one day become your warm-up."</h3>
					</div>
				</div>
			</div>
			<div class="carousel-item ">
				<img class="d-block w-100" src="img/ex2.jpg" alt="Third slide"
					height="560px">
				<div class="carousel-caption d-none d-md-block">
					<div class="text-light p-2 ">
						<h3>"You can either suffer the pain of discipline or the pain of regret."</h3>
					</div>
				</div>
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
</body>
</html>