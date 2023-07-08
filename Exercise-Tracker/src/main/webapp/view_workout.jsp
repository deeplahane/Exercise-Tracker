<%@page import="java.util.List"%>
<%@page import="javax.persistence.TypedQuery"%>
<%@page import="com.db.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.entities.Message"%>
<%@page import="com.entities.Exercise"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="all_css.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Expenses</title>
</head>
<body style="background-color: #f2f3f5;">
	<%
	Message m = (Message) session.getAttribute("msg");
	if (m != null) {
	%>
	<div class="alert <%=m.getCssClass()%>" role="alert">
		<%=m.getContent()%>
	</div>
	<%
	session.removeAttribute("msg");
	}
	%>
	<c:if test="${empty userobj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<div class="container">
		<div class="text-center mt-4 mb-4" style="color: #54626F;">
			<h3>All Exercises's</h3>
		</div>
		<table class="table" style="background-color: white">
			<thead style="background-color: #dcdcdc;">
				<tr style="color: #3E424B;">
					<th scope="col" style="width: 250px;">Exercises</th>
					<th scope="col" style="width: 650px;">Note</th>
					<th scope="col" style="width: 100px;">Sets</th>
					<th scope="col" style="width: 150px;">Weight (kg)</th>
					<th scope="col" style="width: 100px;">Reps</th>
					<th scope="col" style="width: 100px;">Status</th>
					<th scope="col" style="width: 150px;">Actions</th>
				</tr>
			</thead>
			<tbody>
				 <%
				Session s = FactoryProvider.getFactory().openSession();
				@SuppressWarnings("unchecked")
				TypedQuery<Exercise> q = s.createQuery("from Exercise order by id");
				List<Exercise> exercise = q.getResultList();

				for (Exercise t : exercise) {
				%>
				<tr>
					<th scope="row"><%=t.getExercise()%></th>
					<td><%=t.getNote()%></td>
					<td><%=t.getSets()%></td>
					<td><%=t.getWeight()%></td>
					<td><%=t.getReps()%></td>
					<td><%=t.getStatus()%></td>
					<td><a class="btn-sm btn-primary mr-2 "
						style="text-decoration: none;"
						href="edit_exercise.jsp?id=<%=t.getId()%>" role="button">Edit</a><a
						class="btn-sm btn-danger" style="text-decoration: none;"
						href="delete?id=<%=t.getId()%>" role="button">Delete</a></td>
				</tr>
				 <%
				}
				s.close();
				%>

			</tbody>
		</table>
	</div>
</body>
</html>