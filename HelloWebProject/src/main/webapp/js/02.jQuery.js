/**
 * JavaScript Code를 작성해요!
 */
function myFunc() {
	//text()는 인자가 없으면 값을 알아내는 기능
	//만약 인자가 있으면 값을 변경
	
	console.log($("#apple").text()) //사과
	console.log($("#apple + li").text()) //파인애플
	console.log($("ul > li.myList").text()) //참외
	console.log($("#uId").val()) //입력상자 안 값을 찾음
	console.log($("ol > li:first").text()) //선택한 순서상 처음에 있는 엘리먼트
	console.log($("ol > li:last").text()) //순서상 마지막에 있는 엘리먼트
	console.log($("ol > li:nth-child(2)").text()) //지정한 순번을 이용해서 찾을 수 있음
	//nth-child()의 순번은 1부터 시작
}