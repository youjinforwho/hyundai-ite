/**
 * 
 */
function delete_review(text) {
	var commentNum = document.getElementById("commentNum" + text).value;
	$("#commentBox"+text).remove()
	

    $.ajax({
		async : true,
		url : "http://localhost:8080/boardweb/deletecomment",
		type : "GET",
		data : {
			commentNum : commentNum,
		},
		timeout : 100000,
		success : function() {
			alert('성공적으로 삭제되었습니다.')
			$("#txtfield"+text).hide()
			$("#modifybtn"+text).hide()
			$("#deletebtn"+text).hide()
		}
	})
}
