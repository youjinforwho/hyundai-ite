/**
 * JavaScript Code를 작성해요!
 */
function myFunc() {
	//text()는 tag 사이에 있는 글자를 하나의 문자열로 만들어서 추출하는 함수
	//console.log($("[type=checkbox]:checked + span").text()) //현재 체크되어 있는 박스를 모두 선택
	//each안에는 method를 임시로 만들어서 실행(일회성이라 익명함수라 부름)
	//반복되는 span 태그를 나눠서 처리할 수 있음
	console.log($("[type=checkbox]:checked + span").each(function(idx, item) {
		//함수가 하는 일을 적어주면 됨 -> 콜백 함수
		//idx: 반복되는 index의 값 -> for문의 i값과 같은 동작
		//item: 앞쪽에서 나오는 반복대상이 되는 문서객체(selector가 아니라 문서 객체)
		console.log($(item).text());
	}))
}