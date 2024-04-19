/**
 * JavaScript code를 작성하자!
 */

function myFunc() {
   // 선택된 날짜를 가져옴
    var selectedDate = $("#selectedDate").val();
    var formattedDate = selectedDate.replaceAll("-","");
    // 카카오 API이미지 검색
    
   // 서버쪽 프로그램을 호출하는 코드가 나오면된다!
   // 영화진흥위원회의 일일 박스오피스 순위를 알아오는 Open API를 이용할거다!
   // jQuery로 AJAX를 어떻게 이용할 수 있을까?
   // 실행시에 여러가지 정보를 줘야 실행시킬수 있다
   // 실행시 필요한 정보를 자바스크립트 객체로 표현(literal)해서
   // ajax()의 인자로 넣어주면 된다!
   $.ajax({
      //key: vlaue
      async: true, // 비동기로 호출해라!(default) => 서버에서 끝날때까지 작동을 멈추지 말아라!
      // url은 AJAX로 호출할 서버쪽 프로그램의 url을 문자열로 명시
      url: "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json",
      // 서버쪽 프로그램 호출 방식
      type: "GET", 
      // 서버 쪽 프로그램 호출할때 전달해야 하는 데이터
      data: {
         key: "12be2fad1ba7b18371ec94620883dab8",
         targetDt: formattedDate
      },
      // 서버쪽 프로그램의 수행을 기다리는 시간
      // 만약 이 시간안에 서버로부터 응답이 오지 않으면 
      // 이 호출은 실패한 것으로 간주
      timeout: 10000, 
      // dataType: "json"은
      // 서버로부터 전달되는 데이터는 JSON 문자열이다
      // 이 문자열을 적절히 parsing해서 프로그램에서 사용해야한다!
      // 우리는 지금 javascript를 사용하고 있다 
      // JSON문자열을 아주 간편하게 javascript객체로 변환이 가능
      // 이 작업을 당연히 프로그램 작성하는 사람이 해줘야 한다!
      // 그런데 jQuery는 이 작업을 자동으로 진행해준다!
      dataType: "json", 
      
      success: function(result) {
         
          // 성공 시 결과 표시
            var boxOfficeList = result.boxOfficeResult.dailyBoxOfficeList;

            // 기존의 데이터 삭제
            $("tbody").empty();
         
            // 각 영화 정보를 테이블에 추가
            $.each(boxOfficeList, function(movie) {
                var rank = $("<td></td>").text(movie.rank);
                var title = $("<td></td>").text(movie.movieNm);
                var openDt = $("<td></td>").text(movie.openDt);
                var audiCnt = $("<td></td>").text(movie.audiCnt);
                
                
                var kakaoUrl = "https://dapi.kakao.com/v2/search/image";
                var headers = {
               "Authorization":"KakaoAK 710f8f001f154d16a0cb853eafa845dc"
            };
                
                // 이미지 검색 요청
                $.ajax({
               async: true,
               type: "GET", 
               url: kakaoUrl,
                    headers: headers,
                    data: {
                    	query: "안녕하세요", // 영화 제목으로 이미지 검색,
                    	page : 1,
                    	size : 1
                	},
                    dataType: "json",
                    timeout : 50000,
                    success: function(response) {
                        // 이미지 검색 요청 성공 시
                        var imageInfo = response.documents[0]; // 첫 번째 이미지 정보 사용
                        var imageUrl = imageInfo.image_url;

                        // 이미지를 화면에 표시
                        var image = $("<img>").attr("src", imageUrl).attr("alt", "영화 포스터");
                        
                        // 테이블에 새로운 행 추가
                        var newRow = $("<tr></tr>");
                        newRow.append(rank, image, title, openDt, audiCnt);
                        $("tbody").append(newRow);
                    },error: function(error) {
                        // 이미지 검색 요청 실패 시
                        console.error("이미지 가져오기 실패:", error);
                    }
                });
            });
        },
      
      error: function() {
         alert("AJAX Call 실패!!")
      }
   });
   
}