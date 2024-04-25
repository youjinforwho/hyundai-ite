/**
 * 
 */
function modify_confirm(text) {
	var commentNum = document.getElementById("commentNum" + text).value;
	var commentContent = document.getElementById("txtfield" + text).value;
	

    $("#txtfield"+text).attr("disabled", true)
    $("#btn-confirm"+text).hide()
    $("#modifybtn"+text).show()
    $("#deletebtn"+text).show()
    $.ajax({
		async : true,
		url : "http://localhost:8080/boardweb/updatecomment",
		type : "POST",
		data : {
			commentNum : commentNum,
			commentContent : commentContent
		},
		timeout : 3000,
		dataType : "json",
		success : function(result) {
			console.log(result)
		}
	})
}

