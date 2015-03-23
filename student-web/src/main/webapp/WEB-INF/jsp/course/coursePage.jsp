<%@taglib prefix="student-web" tagdir="/WEB-INF/tags" %>
<html>
	<student-web:page-header pageTitle="Course management page" />
<body>
	<a href="${contextPath}">Go to home page</a>
	<br />
	<form id="courseForm">
		<div class="input-group date">
			<span>Date from:</span>
			<input id="datepicker-from" type="text" class="form-control" />
		</div>
		<div class="input-group date">
			<span>Date to:</span>
			<input id="datepicker-to" type="text" class="form-control" />
		</div>
		<div>
			<select id="order">
				<option value="asc" selected>Alphabetically ascending</option>
				<option value="desc">Alphabetically descending</option>
			</select>
		</div>
		<div>
			<select id="type">
				<option value="json" selected>Show in page (JSON)</option>
				<option value="csv">Download CSV file</option>
			</select>
		</div>
		<input type="submit" value="get courses" />
	</form>
	<br />
	<div id="courseList">
	</div>
	<br />
</body>
<script type="text/javascript">
$(document).ready(function(){
	$("#datepicker-from").datepicker({
		dateFormat: 'yy-mm-dd'
	});
	$("#datepicker-to").datepicker({
		dateFormat: 'yy-mm-dd'
	});
	
	$("#courseForm").submit(function( event ) {
		var courseUrl = "";
		var contentType = "";
		var acceptType = ""
		if ($("#type option:selected").val() == "csv") {
			courseUrl = "${contextPath}/courses/list/csv";
			contentType = "text/csv";
			acceptType = "text/csv; charset=utf-8";
		} else if ($("#type option:selected").val() == "json") {
			courseUrl = "${contextPath}/courses/list";
			contentType = "application/json; charset=utf-8";
			acceptType = "application/json";
		}
		event.preventDefault();
		$.ajax({
			url: courseUrl,
			type: "POST",
			data: JSON.stringify({ "dateFrom" : $("#datepicker-from").val(),
								   "dateTo"   : $("#datepicker-to").val(),
								   "order" 	  : $("#order option:selected").val(),
								   "type"	  : $("#type option:selected").val()
								 }),
			contentType: contentType,
			async: false,
			cache: false,
			processData: false,
			beforeSend: function(xhr) {
				xhr.setRequestHeader("Accept", acceptType);
			},
			success: function (data, textStatus, jqXHR) {
				var tableHTML = "<table>";
				$.each(data, function(index, item) {
					tableHTML += "<tr>" +
										"<td>"+item.coursename+"</td>" +
										"<td>"+item.location+"</td>" +
										"<td>"+item.startTimeFormatted+"</td>" +
										"<td>"+item.endTimeFormatted+"</td>" +
								 "</tr>";
				});
				tableHTML += "</table>";
				$("#courseList").html(tableHTML);
			},
			error: function (jqXHR, textStatus, errorThrown) {
				
			}
		});
	});
});
</script>
</html>