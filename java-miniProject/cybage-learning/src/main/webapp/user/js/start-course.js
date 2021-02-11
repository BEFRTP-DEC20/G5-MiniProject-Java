var vid = document.getElementById("myVideo");
var isVideoCompleted = false;
$(document).ready(function() {
	$(".search").hide();
	$(".certficate-btn").hide();
	$(".nextvideo").on("click", function(e) {
		if (isVideoCompleted === false)
			e.preventDefault();
	});
});

function currentVideoTime(event) {
	if (event.currentTime / vid.duration > 0.9 && isVideoCompleted === false) {
		console.log("Course completed");
		isVideoCompleted = true;
	}
	if (event.currentTime / vid.duration > 0.9 && isVideoCompleted === true
			&& $(".nextvideo").hasClass("disabled")) {
		$(".progress-bar").css("max-width","100%");
		$(".certficate-btn").show();

	}
}