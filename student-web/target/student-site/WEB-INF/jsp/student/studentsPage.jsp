<%@taglib prefix="student-web" tagdir="/WEB-INF/tags" %>
<html>
	<student-web:page-header pageTitle="Student management page" />
<body>
	<a href="${contextPath}">Go to home page</a>
	<br />
	<form id="studentsForm">
		<input id="searchEntry" type="hidden" value="all" />
		<input type="submit" value="get all students" />
	</form>
	<br />
	<div id="studentsList">
	</div>
	<br />
</body>
<script type="text/javascript">
$(document).ready(function(){
	$("#studentsForm").submit(function( event ) {
		event.preventDefault();
		$.ajax({
			url: "${contextPath}/students/list",
			type: "POST",
			data: JSON.stringify({ "quantity" : $("#searchEntry").val() }),
			contentType: "application/json; charset=utf-8",
			async: false,
			cache: false,
			processData: false,
			beforeSend: function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json")
			},
			success: function (data, textStatus, jqXHR) {
				var tableHTML = "<table>";
				$.each(data, function(index, item) {
					tableHTML += "<tr>" +
										"<td>"+item.name+"</td>" +
										"<td>"+item.surname+"</td>" +
								 "</tr>";
				});
				tableHTML += "</table>";
				$("#studentsList").html(tableHTML);
			},
			error: function (jqXHR, textStatus, errorThrown) {
				
			}
		});
	});
});
</script>
</html>