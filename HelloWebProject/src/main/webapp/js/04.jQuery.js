/**
 * JavaScript Code를 작성해요!
 */
function myFunc() {
	
	//새로운 Element를 만들려면 어떻게 해야 하나요?
	var li = $("<li></li>"); //엘리먼트를 새로 생성
	li.text("맨 마지막에") //li 태그 안에 들어갈 내용 생성
	li.attr("id", "myId") //Id의 값을 임의로 변경
	//<li id="myId">맨 마지막에</li>
	
	//Element를 생성했으면 이제 원하는 위치에 가져다가 붙이면 됨
	//총 4개의 메서드가 있음
	//1. 맨 마지막 자식으로 붙이는 방법
	$("ul").append(li)
	//2. 맨 처음 자식으로 붙이는 방법
	$("ul").prepend($("<li></li>").text("맨 앞에"))
	//3. 바로 앞 형제로 붙이는 방법
	$("ul > li:last").before($("<li></li>").text("맨 마지막 앞에"))
	//4. 바로 뒤 형제로 붙이는 방법
	//after
}