<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">



<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<head>

<meta charset="UTF-8">
<title>Youtube Downloader</title>
<link rel="stylesheet" href="/resources/style.css">
<body>
<body class="align">

      <h2>YOUTUBE VIDEO DOWNLOADER</h2>
	<div class="grid">

		<form:form action="/getvideo" method="POST" class="form login" modelAttribute="urlBean">
           <form:errors path="url"  cssClass="error"  /><br>
			<div class="form__field">
             
				<form:input  type="text"   path="url"
					class="form__input" placeholder="Enter youtube link here" />
			</div>




			<div class="form__field">
				<input type="submit" value="DOWNLOAD">
			</div>

		</form:form>

	</div>


</body>
</body>


</html>
