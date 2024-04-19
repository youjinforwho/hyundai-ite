/**
 * JavaScript Code를 작성해요!
 */
function myFunc() {
    var formattedDate = new Date(document.getElementById("selectedDate").value).toISOString().slice(0,10).replace(/-/g,"");
	console.log(formattedDate)
	$("tbody").empty();
	//서버쪽 프로그램(Open API)을 호출하는 코드 작성
	//영화진흥위원회의 일일 박스오피스 순위를 알아오는 OpenAPI 이용
	//jQuery로 AJAX를 어떻게 이용할 수 있나요?
	
	//실행시에 여러가지 정보를 줘야 실행이 가능하겠죠?
	//실행시 필요한 정보를 자바스크립트 객체로 표현(literal)해서
	//ajax()의 인자로 넣어주면 돼요
	// AJAX 호출
	$.ajax({
		//비동기로 호출하라는 의미 기본값은 true
		//동기 처리 시 서버에서 처리가 끝날 때까지 프로그램이 중지됨
		async: true,
		//url은 AJAX로 호출할 서버 쪽 프로그램의 url을 문자열로 명시
		url: "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json",
		//서버쪽 프로그램 호출 방식
		type: "GET", 
		//서버쪽 프로그램 호출 시 전달해야 하는 데이터
		data: {
			key: "061038ef9990b0d92361a5d7dc084971",
			targetDt: formattedDate
		},
		//서버쪽 프로그램의 수행을 기다리는 시간 -> 설정 시간이 지나면 실패로 간주
		timeout: 3000,
		
		//서버로부터 전달되는 데이터는 JSON 문자열로 설정
		//원래는 이 문자열을 적절히 parsing해서 프로그램에서 사용해야 함
		//우리는 지금 JavaScript를 사용하고 있음 -> JSON 문자열을 아주 간편하게 JS 객체로 변환이 가능
		//이 작업을 당연히 프로그램 작성하는 사람이 해줘야 함
		//그런데 jQuery는 이 작업을 자동으로 진행해줌
		dataType: "json",
		success : function(result) {
			//새로운 Element를 만들려면 어떻게 해야 하나요?

			//성공시 해당 함수가 호출 -> 성공했다는 말은 서버로부터 JSON을 가져와서 객체로 변환시켰다는 의미
			//결과 객체가 함수의 인자로 전달됨 -> result로 받아옴
			result.boxOfficeResult.dailyBoxOfficeList.forEach(function(movie) {
	        var rank = movie.rank;
	        var title = movie.movieNm;
	        var openDt = movie.openDt;
	        var audiCnt = movie.audiCnt;
	        
	        $.ajax({
                // 두 번째 API 요청 설정
                // 여기에 이미지 검색을 위한 API 요청 설정을 작성합니다.
                // 필요한 매개변수는 첫 번째 API에서 받아온 영화 제목을 사용합니다.
                // ...
				async: false,
				url: "https://dapi.kakao.com/v2/search/image",
				type: "GET",
				headers: {
					"Authorization": "KakaoAK d82c5ae8faf539512e69dacd626bd4bf"
        		},
				data : {
					query: title,
					page : 1,
					size: 1
				},
				timeout : 5000,
				dataType: "json",
                success: function(imageResult) {
                    // 두 번째 API의 성공 콜백 함수
                    // 이미지 검색 결과를 받아온 후 화면에 표시
                    var imageUrl = imageResult.documents[0].thumbnail_url;
                    var imageCell = $("<td>");
                    var image = $("<img>").attr("src", imageUrl);
                    imageCell.append(image);
                   
                    // 각각의 영화 정보를 새로운 행으로 추가
			        var $row = $("<tr></tr>");
			        $row.append($("<td></td>").text(rank));
			        $row.append(imageCell);
			        $row.append($("<td></td>").text(title));
			        $row.append($("<td></td>").text(openDt));
			        $row.append($("<td></td>").text(audiCnt));
			        
			        // 표에 행 추가
			        $("tbody").append($row);
                },
                error: function() {
                    alert('이미지 검색에 실패했습니다.');
                }
            });
           
	    });
		},
		error: function() {
			alert('뭔가 잘못됐어요')
		}
		
	});
	
}