<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<jsp:include page="user-header.jsp"></jsp:include>
<%
	Object currentVideo = session.getAttribute("current_video");
	Object videoCount = session.getAttribute("video_count");
	int currentVideo_int = Integer.parseInt(currentVideo.toString());
	int videoCount_int = Integer.parseInt(videoCount.toString());
	if (currentVideo_int == videoCount_int + 1) {
		System.out.println("Generate certificate");
	}
	int progress = ((currentVideo_int - 1) * 100) / videoCount_int;

	System.out.println(
			"current :" + currentVideo_int + " videoCount_int :" + videoCount_int + "progress: " + progress);
	int next_video = currentVideo_int + 1;
	int prev_video = currentVideo_int - 1;
	int course_id = Integer.parseInt(session.getAttribute("course_id").toString());
%>

<c:out value="${videoCount_int}"></c:out>
<%-- ${(videoCount > 0) ? "some text when true" : "some text when false"} --%>
<div class="container-fluid course-container">
	<div class="row h3">
		<div class="col-sm-8 title ">
			<%=currentVideo + ". " + session.getAttribute("subcourse_title")%>
		</div>

		<div class="col-sm-4 p-bar">
			<div class="progress">
				<div class="progress-bar" role="progressbar"
					style="max-width:<%=progress%>%">
					<span class="p-title"><%=progress%>%</span>
				</div>
			</div>

		</div>
	</div>
	<hr>
	<!-- working code -->
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-8 video">
				<div class="col-md-12">
					<div class="row">
						<div class="container-fluid">
							<video id="myVideo" class="center"
								ontimeupdate="currentVideoTime(this)" width="90%" height="90%"
								controls>
								<source
									src='<%=request.getContextPath() +"/"+ session.getAttribute("subcourse_url")%>'
									type='video/mp4' />
								Your browser does not support HTML5 video.
							</video>
						</div>
					</div>
					<div class="row">
						<div class="container-fluid d-flex justify-content-between">
							<!-- <a href="#" class="btn btn-primary">Prev</a> -->
							<a
								href="<%=request.getContextPath()%>/UserController/start-course?vid=<%=prev_video%>&amp;id=<%=course_id%>"
								class="btn btn-dark videobuttons <%=prev_video < 1 ? "disabled" : ""%>">PREV</a>
							<a
								href="<%=request.getContextPath()%>/UserController/start-course?vid=<%=next_video%>&amp;id=<%=course_id%>"
								class="btn btn-dark nextvideo videobuttons <%=next_video > videoCount_int ? "disabled" : ""%>">NEXT</a>
							<%-- <a
								href="<%=request.getContextPath()%>/UserController/start-course?vid=<%=prev_video%>&amp;id=<%=request.getAttribute("course_id") %>"
								class='btn <%=prev_video < 1 ? "disabled" : ""%>'>prev</a>  --%>
							<%-- <a
								href="https://google.co.in/"
								class='btn nextvideo <%=next_video > videoCount_int ? "disabled" : ""%>'>Next</a> --%>

							<a class="btn btn-warning videobuttons certficate-btn" href="#">
								Get certificate</a>
						</div>

					</div>
				</div>
			</div>
			<div class="col-sm-1"></div>
			<div class="col-sm-3 description">
				<div class="col-md-12">
					<br />
					<blockquote
						class="blockquote blockquote-custom bg-#C39EAO p-5 shadow rounded">
						<div class="blockquote-custom-icon bg-info shadow-sm">
							<i class="fa fa-quote-left text-white"></i>
						</div>
						<p id="underline">Course Description</p> <br />
						<p class="mb-0 mt-2 font-italic "><%=session.getAttribute("subcourse_desc")%></p>
				</div>
			</div>
			<%-- <div class="col-sm-1"></div>
			<div class="col-sm-3 description">
				<div class="col-md-12">
					Course Description <br />:<%=session.getAttribute("subcourse_desc")%>
				</div>
			</div> --%>
		</div>
	</div>
</div>

<jsp:include page="../footer.jsp"></jsp:include>
