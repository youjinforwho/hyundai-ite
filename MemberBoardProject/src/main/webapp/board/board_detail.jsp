<%@ page import="member.vo.MemberVO, board.vo.BoardVO" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="comment.vo.CommentVO" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<!-- jQuery에 대한 CDN -->
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<script src="resources/js/comment-update.js"></script>
	<script src="resources/js/comment-delete.js"></script>
	
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Tables</title>

    <!-- Custom fonts for this template -->
    <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body id="page-top">
	<%
		MemberVO memberInfo = (MemberVO)session.getAttribute("memberInfo");
    	BoardVO boardDetail = (BoardVO)request.getAttribute("boardDetail");
    	List<CommentVO> commentList = (List<CommentVO>)request.getAttribute("commentList");
	%>
    <!-- Page Wrapper -->
    <div id="wrapper">
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Topbar Search -->


                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small"
                                            placeholder="Search for..." aria-label="Search"
                                            aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>

                        
                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=memberInfo.getMember_id() %>님, 환영합니다!</span>
                                <img class="img-profile rounded-circle"
                                    src="resources/img/undraw_profile.jpg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="http://localhost:8080/boardweb/profile?param1=<%=memberInfo.getMember_id()%>">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    내 프로필
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="http://localhost:8080/boardweb/logout" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    로그아웃
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">게시판</h1>
					<a href="http://localhost:8080/boardweb/list">게시글 목록으로 가기</a>			
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                        <%
                        
                        if (memberInfo.getMember_id().equals(boardDetail.getBoard_id())) { %>
                            <a href="http://localhost:8080/boardweb/check?param1=<%=boardDetail.getBoard_id()%>&param2=<%=boardDetail.getBoard_num() %>">수정</a>
                            <a href="http://localhost:8080/boardweb/delete?param1=<%=boardDetail.getBoard_id()%>&param2=<%=boardDetail.getBoard_num() %>">삭제</a>
                        <%}%>    
                        <%
                        String boardId = boardDetail.getBoard_id();
                        if (boardDetail.getBoard_quit().equals("Y")) boardId = "(알수없음)";
                        %>
                            <a style="padding: 1.25rem; text-align: right">
                            아이디: <%=boardId %>&ensp;&ensp;&ensp; 마지막으로 수정한 날짜: <%=boardDetail.getBoard_date() %>&ensp;
                            </a>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <h6 class="m-0 font-weight-bold text-primary">제목</h6>
                                <%=boardDetail.getBoard_subject() %>
                                <br><br><br><br><br>
                                <h6 class="m-0 font-weight-bold text-primary">내용</h6>
                                <%=boardDetail.getBoard_content() %>
                                <br><br><br><br><br>
                            </div>
                        </div>
                    </div>

					<form action ="http://localhost:8080/boardweb/comment" method="post">
					<div class="card shadow mb-4">
                        <!-- Card Header - Accordion -->
                        <input type="hidden" name="boardNum" value="<%=boardDetail.getBoard_num() %>">
                        <a href="#collapseCardExample" class="d-block card-header py-3" data-toggle="collapse"
                            role="button" aria-expanded="true" aria-controls="collapseCardExample">
                            <h6 class="m-0 font-weight-bold text-primary">댓글 쓰기</h6>
                        </a>
                        <!-- Card Content - Collapse -->
                        <div class="collapse show" id="collapseCardExample">
                            <div class="card-body">
                                <textarea id="comment" name="commentContent" rows="4" cols="50" placeholder="댓글을 입력하세요" style="border:none; outline:none"></textarea><br>
                            </div>
                            <button type="submit" style="border:0; margin:10px;padding:10px;">댓글 작성</button>
                        </div>
                    </div>
                    </form>
					<%
				    int idx = 1;
                   	if (commentList != null) {
                   		for (CommentVO o : commentList) {
                   			String commentNum = o.getComment_num() +"";
                   			System.out.println(commentNum);
                   			String commentId = o.getComment_id();
                   			if (o.getComment_quit().equals("Y")) commentId = "(알수없음)";
                   			String commentContent = o.getComment_content();
                   			String commentDate = o.getComment_date();
					%>
					<div class="card shadow mb-4" id="commentBox<%=idx %>">
                        <div class="card-header py-3">
                        	<input type="hidden" id="commentNum<%=idx %>" value="<%=commentNum %>">
                        	<%if (commentId.equals(memberInfo.getMember_id())) {%>
                            <button type="button" id="modifybtn<%=idx %>" onclick="modify_review(<%=idx %>)" style="border:0; margin:5px;padding:5px;">수정</button>
                            <button type="button" id="deletebtn<%=idx %>" onClick="delete_review(<%=idx %>)" style="border:0; margin:5px;padding:5px;">삭제</button>
                            <%} %>
                            
                            &ensp;&ensp;&ensp; 마지막으로 수정한 날짜: <%=boardDetail.getBoard_date() %>&ensp;
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <h6 class="m-0 font-weight-bold text-primary">id: <%=commentId%></h6>
                                <br><br>
                                <textarea type="text" id="txtfield<%=idx%>" disabled="true" value="<%=commentContent %>" style="border:none; outline:none; width : 1000px"><%=commentContent %></textarea>
                                <br>
                            </div>
                            <p><button type="button" id="btn-confirm<%=idx%>" class="btnmodify" onclick="modify_confirm(<%=idx%>)" style="border:0; margin:5px;padding:5px;">confirm</button></p>
							<script>
								$('.btnmodify').hide()
								function modify_review(text) {
								    console.log(text)
								 	$("#txtfield"+text).attr("disabled", false)
								    $("#btn-confirm"+text).show()
								    $("#modifybtn"+text).hide()
								    $("#deletebtn"+text).hide()
								}
								

							</script>
                        </div>
                    </div>
                    <%
                        	idx+=1;
                     	}
                     }
                     %>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2020</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">로그아웃 하시겠습니까?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">현재 세션을 종료할 준비가 된 경우 아래 "로그아웃"을 선택합니다.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>
                    <a class="btn btn-primary" href="../member/login.jsp">로그아웃</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="resources/vendor/jquery/jquery.min.js"></script>
    <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="resources/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="resources/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="reosurces/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="resources/js/demo/datatables-demo.js"></script>

</body>

</html>