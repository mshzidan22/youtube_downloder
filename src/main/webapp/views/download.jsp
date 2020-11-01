<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title>YOUTUBE DOWNLOADER</title>
<link rel="stylesheet" href="/resources/style2.css">
</head>
<body>
	<div class="container">
		<div class="item">
			<h2>YOUTUBE DOWNLOADER</h2>
		</div>
		<div class="item"></div>
		<div class="item">
			<button type="button" name="button">
						      <a href="/"> Download another video</a>
					</button>
		</div>
		<div class="item"></div>
		<div class="download">
			<img src="${video.thumbnail}" alt="notfound">
			<div class="t">
				<h2>${video.title}   ||| ${video.duration}</h2>
			</div>
			<div class="download-buttons">

				<h3>extenstion</h3>
				<h3>download</h3>

				<!-- for loop -->
				<c:forEach var="video" items="${video.videoStreams}">
					<p> ${video.format_note } | ${video.extension }</p>
					<button type="button" name="button">
						<a href="${video.url}"  download> ${video.filesize_pretty } </a>
					</button>
				</c:forEach>


			</div>



		</div>
		<div class="item"></div>








		<p>by mohammed shabban © 2020 for YAT</p>

	</div>
</body>
</html>




