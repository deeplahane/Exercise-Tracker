<%@page import="com.entities.Exercise"%>
<%@page import="com.dao.ExerciseDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@page import="com.entities.Message"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="all_css.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Exercise</title>
</head>
<body style="background-color: #f2f3f5">
	<%
	Message m = (Message) session.getAttribute("msg");
	if (m != null) {
	%>
	<div class="alert <%=m.getCssClass()%>">
		<%=m.getContent()%></div>
	<%
	}
	session.removeAttribute("msg");
	%>
	<c:if test="${empty userobj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card mt-4 pb-0 "
					style="box-shadow: rgba(0, 0, 0, 0.16) 0px 1px 4px;">
					<div class="card-header text-center">
						<h3>
							<i class="fa-solid fa-pen-to-square"></i> Edit Exercise
						</h3>
					</div>
					<%
						int id=Integer.parseInt(request.getParameter("id"));
						Exercise ex=ExerciseDao.getExercise(id);
					%>
					<div class="card-body">
						<form action="updateExercise" method="post">
						<input type="hidden" value="<%=ex.getId()%>" name="id">
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Exercise</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Barbell curls" name="exercise" value="<%=ex.getExercise()%>">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Enter Note</label>
								<textarea rows="3" class="form-control"
									id="exampleInputPassword1" placeholder="Slow and steady motion is must."
									name="note"><%=ex.getNote() %></textarea>
							</div>
							<div class=""
								style="display: flex; align-items: center; justify-content: flex-start;">
								<div class="form-group col-md-4">
									<label for="exampleInputPassword1">Enter Sets</label> <input
										type="number" class="form-control" id="exampleInputPassword1"
										placeholder="4" name="sets" value="<%=ex.getSets()%>">
								</div>
								<div class="form-group col-md-4">
									<label for="exampleInputPassword1">Enter Weight (kg)</label> <input
										type="number" class="form-control" id="exampleInputPassword1"
										name="weight" placeholder="20 kg" value="<%=ex.getWeight()%>">
								</div>
								<div class="form-group col-md-4">
									<label for="exampleInputPassword1">Enter Reps</label> <input
										type="number" class="form-control" id="exampleInputPassword1"
										name="reps" placeholder="15" value="<%=ex.getReps()%>">
								</div>
							</div>
							<div class="form-group">
								<label>Status</label>
								<select class="form-control" name="status">
								<option selected value="<%=ex.getStatus()%>">---Select---</option>
								<option value="pending">Pending</option>
								<option value="completed">Completed</option>
								</select>
							</div>
							<button type="submit" class="btn btn-primary col-md-12">Update
								Exercise</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>