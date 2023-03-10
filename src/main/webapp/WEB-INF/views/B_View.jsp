<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Dashboard - NiceAdmin Bootstrap Template</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="resources/assets/img/favicon.png" rel="icon">
<link href="resources/assets/img/apple-touch-icon.png"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="resources/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="resources/assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="resources/assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="resources/assets/vendor/quill/quill.snow.css"
	rel="stylesheet">
<link href="resources/assets/vendor/quill/quill.bubble.css"
	rel="stylesheet">
<link href="resources/assets/vendor/remixicon/remixicon.css"
	rel="stylesheet">
<link href="resources/assets/vendor/simple-datatables/style.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="resources/assets/css/style.css" rel="stylesheet">

<!-- =======================================================
  * Template Name: NiceAdmin - v2.4.1
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

	<!-- ======= Header ======= -->
	<header id="header" class="header fixed-top d-flex align-items-center">

		<div class="d-flex align-items-center justify-content-between">
			<a href="bList" class="logo d-flex align-items-center"> <img
				src="resources/assets/img/logo.png" alt=""> <span
				class="d-none d-lg-block">NiceAdmin</span>
			</a> <i class="bi bi-list toggle-sidebar-btn"></i>
		</div>
		<!-- End Logo -->

		<div class="search-bar">
			<form class="search-form d-flex align-items-center" method="POST"
				action="#">
				<input type="text" name="query" placeholder="Search"
					title="Enter search keyword">
				<button type="submit" title="Search">
					<i class="bi bi-search"></i>
				</button>
			</form>
		</div>
		<!-- End Search Bar -->

		<nav class="header-nav ms-auto">
			<ul class="d-flex align-items-center">

				<li class="nav-item d-block d-lg-none"><a
					class="nav-link nav-icon search-bar-toggle " href="#"> <i
						class="bi bi-search"></i>
				</a></li>
				<!-- End Search Icon-->




				<li class="nav-item dropdown pe-3"><a
					class="nav-link nav-profile d-flex align-items-center pe-0"
					href="#" data-bs-toggle="dropdown"> <img
						src="resources/profile/${memInfo.memProfileName }" alt="Profile"
						class="rounded-circle"> <span
						class="d-none d-md-block dropdown-toggle ps-2">${memInfo.memName}</span>
				</a> <!-- End Profile Iamge Icon -->

					<ul
						class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
						<li class="dropdown-header">
							<h6>${memInfo.memName}</h6> <span>????????????</span>
						</li>
						<li>
							<hr class="dropdown-divider">
						</li>

						<li><a class="dropdown-item d-flex align-items-center"
							href="mProfile"> <i class="bi bi-person"></i> <span>My
									Profile</span>
						</a></li>
						<li>
							<hr class="dropdown-divider">
						</li>

						<li><a class="dropdown-item d-flex align-items-center"
							href="users-profile.html"> <i class="bi bi-gear"></i> <span>Account
									Settings</span>
						</a></li>
						<li>
							<hr class="dropdown-divider">
						</li>

						<li><a class="dropdown-item d-flex align-items-center"
							href="pages-faq.html"> <i class="bi bi-question-circle"></i>
								<span>Need Help?</span>
						</a></li>
						<li>
							<hr class="dropdown-divider">
						</li>

						<li><a class="dropdown-item d-flex align-items-center"
							href="#"> <i class="bi bi-box-arrow-right"></i> <span>Sign
									Out</span>
						</a></li>

					</ul> <!-- End Profile Dropdown Items --></li>
				<!-- End Profile Nav -->

			</ul>
		</nav>
		<!-- End Icons Navigation -->

	</header>
	<!-- End Header -->

	  <!-- ======= Sidebar ======= -->
  <aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

      <li class="nav-item">
        <a class="nav-link " href="index.html">
          <i class="bi bi-grid"></i>
          <span>Dashboard</span>
        </a>
      </li><!-- End Dashboard Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-menu-button-wide"></i><span>????????? ??????</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="components-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
          <li>
            <a href="write">
              <i class="bi bi-circle"></i><span>???????????????</span>
            </a>
          </li>
          <li>
            <a href="components-accordion.html">
              <i class="bi bi-circle"></i><span>?????????</span>
            </a>
          </li>
          <li>
            <a href="components-badges.html">
              <i class="bi bi-circle"></i><span>?????????</span>
            </a>
          </li>
          
        </ul>
      </li><!-- End Components Nav -->

      

     

      

      

      <li class="nav-heading">Pages</li>

      <li class="nav-item">
        <a class="nav-link collapsed" href="users-profile.html">
          <i class="bi bi-person"></i>
          <span>Profile</span>
        </a>
      </li><!-- End Profile Page Nav -->


      <li class="nav-item">
        <a class="nav-link collapsed" href="mJoinForm">
          <i class="bi bi-card-list"></i>
          <span>Register</span>
        </a>
      </li><!-- End Register Page Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" href="M_Login">
          <i class="bi bi-box-arrow-in-right"></i>
          <span>Login</span>
        </a>
      </li><!-- End Login Page Nav -->

    </ul>

  </aside><!-- End Sidebar-->

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>?????????</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index">???</a></li>
					<li class="breadcrumb-item active">?????????</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row">

				<!-- Left side columns -->
				<div class="col-lg-8">
					<div class="row">



						<!-- Recent Sales -->
						<div class="col-12">
							<div class="card recent-sales overflow-auto">

								<div class="filter">
									<a class="icon" href="#" data-bs-toggle="dropdown"><i
										class="bi bi-three-dots"></i></a>
									<ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
										<li class="dropdown-header text-start">
											<h6>Filter</h6>
										</li>

										<li><a class="dropdown-item" href="#">Today</a></li>
										<li><a class="dropdown-item" href="#">This Month</a></li>
										<li><a class="dropdown-item" href="#">This Year</a></li>
									</ul>
								</div>

								<div class="card-body">
									<h5 class="card-title">????????????</h5>

									<!-- ????????? ?????? -->



									<div class="col-12">
										<label for="yourName" class="form-label">????????? ?????? ${board.boNum }</label>

									</div>

									<div class="col-12">
										<label for="yourName" class="form-label">?????????</label> <input
											type="text" class="form-control" value="${board.boWriter}"
											disabled>
									</div>

									<div class="col-12">
										<label for="yourName" class="form-label">????????? ??????</label> <input
											type="text" class="form-control" value="${board.boTitle}"
											disabled>
									</div>

									<div class="col-12">
										<label for="yourName" class="form-label">????????? ??????</label>
										<textarea class="form-control" style="height: 400px"
											name="boContent" placeholder="${board.boContent}" disabled></textarea>
									</div>
									<br />
									<div class="col-12">
										<label for="yourName" class="form-label">??????</label> <img
											src="resources/fileUpload/${board.boFileName}" width="200px" />
									</div>

									<div class="col-12">
										<label for="yourName" class="form-label">?????????</label> <input
											type="text" class="form-control" value="${board.boDate}"
											disabled>
									</div>

									<div class="col-12">
										<label for="yourName" class="form-label">?????????</label> <input
											type="text" class="form-control" value="${board.boHit}"
											disabled>
									</div>
									<c:if test="${memInfo.memId eq board.boWriter}">
									<div class="col-12">
										<button class="btn btn-primary w-20"
										onclick="location.href='bModifyForm?boNum=${board.boNum}'"
										>??????</button> 
										<button class="btn btn-primary w-20"
										onclick="location.href='bDelete?boNum=${board.boNum}'"
										>??????</button>
									</div>
									</c:if>
									<br /> <br /> <br />
									<div class="col-12">
										<input type="hidden" value="${memInfo.memId}" id="cmtWriter" />
										<input type="hidden" value="${board.boNum}" id="cbNum" />
										<textarea rows="5" clos="20" id="cmtContent"
											onfocus="checkLogin()"></textarea>
										<button class="btn btn-primary w-20" onclick="cmtWrite()">??????
											??????</button>
									</div>


									<div id="cmtArea"></div>





									<div class="col-12"></div>






								</div>

							</div>
						</div>
						<!-- End Recent Sales -->



					</div>
				</div>
				<!-- End Left side columns -->

				<!-- Right side columns -->
				<div class="col-lg-4">

					<!-- Recent Activity -->
					<div class="card">
						<div class="filter">
							<a class="icon" href="#" data-bs-toggle="dropdown"><i
								class="bi bi-three-dots"></i></a>
							<ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
								<li class="dropdown-header text-start">
									<h6>Filter</h6>
								</li>

								<li><a class="dropdown-item" href="#">Today</a></li>
								<li><a class="dropdown-item" href="#">This Month</a></li>
								<li><a class="dropdown-item" href="#">This Year</a></li>
							</ul>
						</div>

						<div class="card-body">
							<h5 class="card-title">
								Recent Activity <span>| Today</span>
							</h5>

							<div class="activity">

								<div class="activity-item d-flex">
									<div class="activite-label">32 min</div>
									<i
										class='bi bi-circle-fill activity-badge text-success align-self-start'></i>
									<div class="activity-content">
										Quia quae rerum <a href="#" class="fw-bold text-dark">explicabo
											officiis</a> beatae
									</div>
								</div>
								<!-- End activity item-->

								<div class="activity-item d-flex">
									<div class="activite-label">56 min</div>
									<i
										class='bi bi-circle-fill activity-badge text-danger align-self-start'></i>
									<div class="activity-content">Voluptatem blanditiis
										blanditiis eveniet</div>
								</div>
								<!-- End activity item-->

								<div class="activity-item d-flex">
									<div class="activite-label">2 hrs</div>
									<i
										class='bi bi-circle-fill activity-badge text-primary align-self-start'></i>
									<div class="activity-content">Voluptates corrupti
										molestias voluptatem</div>
								</div>
								<!-- End activity item-->

								<div class="activity-item d-flex">
									<div class="activite-label">1 day</div>
									<i
										class='bi bi-circle-fill activity-badge text-info align-self-start'></i>
									<div class="activity-content">
										Tempore autem saepe <a href="#" class="fw-bold text-dark">occaecati
											voluptatem</a> tempore
									</div>
								</div>
								<!-- End activity item-->

								<div class="activity-item d-flex">
									<div class="activite-label">2 days</div>
									<i
										class='bi bi-circle-fill activity-badge text-warning align-self-start'></i>
									<div class="activity-content">Est sit eum reiciendis
										exercitationem</div>
								</div>
								<!-- End activity item-->

								<div class="activity-item d-flex">
									<div class="activite-label">4 weeks</div>
									<i
										class='bi bi-circle-fill activity-badge text-muted align-self-start'></i>
									<div class="activity-content">Dicta dolorem harum nulla
										eius. Ut quidem quidem sit quas</div>
								</div>
								<!-- End activity item-->

							</div>

						</div>
					</div>
					<!-- End Recent Activity -->

				</div>
				<!-- End Right side columns -->

			</div>
		</section>

	</main>
	<!-- End #main -->

	<!-- ======= Footer ======= -->
	<footer id="footer" class="footer">
		<div class="copyright">
			&copy; Copyright <strong><span>NiceAdmin</span></strong>. All Rights
			Reserved
		</div>
		<div class="credits">
			<!-- All the links in the footer should remain intact. -->
			<!-- You can delete the links only if you purchased the pro version. -->
			<!-- Licensing information: https://bootstrapmade.com/license/ -->
			<!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
			Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
		</div>
	</footer>
	<!-- End Footer -->

	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script src="resources/assets/vendor/apexcharts/apexcharts.min.js"></script>
	<script
		src="resources/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="resources/assets/vendor/chart.js/chart.min.js"></script>
	<script src="resources/assets/vendor/echarts/echarts.min.js"></script>
	<script src="resources/assets/vendor/quill/quill.min.js"></script>
	<script
		src="resources/assets/vendor/simple-datatables/simple-datatables.js"></script>
	<script src="resources/assets/vendor/tinymce/tinymce.min.js"></script>
	<script src="resources/assets/vendor/php-email-form/validate.js"></script>

	<!-- Template Main JS File -->
	<script src="resources/assets/js/main.js"></script>

</body>
<script src="https://code.jquery.com/jquery-3.6.1.js"
	integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
	crossorigin="anonymous"></script>
<script>
	$.ajax({
		type : "POST",
		url : "comment/cList",
		data : {
			"cbNum" : ${board.boNum}
		},
		dataType : "json",
		success : function(result) {
			commentList(result);
		},
		error : function() {
			alert("?????? ???????????? ?????? ??????!");
		}
	});

	// ?????? ???????????? ??????
	function commentList(list) {
		let output= "";
		
		output += "<table class='table table-borderless datatable'>";
		output += "<thead>";
		output += "<tr>";
		output += "<th scope='col'>?????????</th>";
		output += "<th scope='col' >??????</th>";
		output += "<th scope='col'>?????????</th>";
		output += "<th >??????</th>";
		output += "<th >??????</th>";
		output += "</tr>";
		output += "</thead>";
		
		for(let i in list){
			output += "<tr>";
			output += "<td>"+ list[i].cmtWriter+"</td>";
			output += "<td><span id='cmtModiContent"+list[i].cmtNum+"'>"+list[i].cmtContent+"<span></td>";
			output += "<td>"+list[i].cmtDate+"</td>";
			
			if('${memInfo.memId}' == list[i].cmtWriter || '${memInfo.memId}' == 'admin'){
			output += "<td><button class='btn btn-primary w-20' onclick='cmtCon("+list[i].cmtNum+","+list[i].cbNum+")'>??????</button></td>";
			output += "<td><button class='btn btn-primary w-20' onclick='cmtDelete("+list[i].cmtNum+","+list[i].cbNum+")'>??????</button></td>";
			}else{
				output += "<td></td><td></td>";		
			}
			output += "</tr>";			
		}
		output += "</table>";
		
		document.getElementById("cmtArea").innerHTML = output;
	}
	// ?????? ??????
	function cmtDelete(cmtNum, cbNum){
		console.log(cmtNum+","+cbNum)
		
		$.ajax({
			type : "POST",
			url : "comment/cmtDelete",
			data : {
				"cmtNum" : cmtNum,
				"cbNum" : cbNum,
			},
			dataType : "json",
			success : function(list){
				commentList(list);
				$('#cmtContent').val("");
			},
			error : function(){
				alert('?????? ?????? ?????? ??????!');
			}
		});
	}
	
	
	//?????? ??????
	function cmtWrite(){
		let cmtWriter = document.getElementById("cmtWriter").value;
		let cmtContent = $("#cmtContent").val();
		let cbNum = $("#cbNum").val();
		
		$.ajax({
			type : "POST",
			url : "comment/cmtWrite",
			data : {
				"cmtWriter" : cmtWriter,
				"cmtContent" : cmtContent,
				"cbNum" : cbNum
			},
			dataType : "json",
			success : function(list){
				commentList(list);
				$('#cmtContent').val("");
			},
			error : function(){
				alert('?????? ?????? ?????? ??????!');
			}
		});
		
		
	}
	// ?????? ????????? ????????? ??????
	function cmtCon(cmtNum,cbNum){
		console.log(cmtNum);
		console.log(cbNum);
		
		$("#cmtModiContent"+cmtNum).html("<input type='text' id='cContent'/> <button class='btn btn-primary w-20' onclick='cmtModify("+cmtNum+","+cbNum+")'>??????</button>");
		
	}
	
	// ?????? ??????
	function cmtModify(cmtNum, cbNum){
		let cmtContent = document.getElementById("cContent").value;
		
		$.ajax({
			type : "POST",
			url : "comment/cmtModify",
			data : {
				"cmtNum" : cmtNum,
				"cbNum" : cbNum,
				"cmtContent" : cmtContent
			},
			dataType : "json",
			success : function(list){
				commentList(list);
				$('#cmtContent').val("");
				// ?????? ?????????
			},
			error : function(){
				alert('?????? ?????? ?????? ??????!');
			}
		});
	}
	
	// ?????? ????????? ????????? ?????? ??????
	function checkLogin(){
		console.log("${memInfo.memId}")
		if(${memInfo.memId eq null} ){
			$("#cmtContent").blur();
			alert('????????? ??? ??????????????????.')
			location.href="mLoginForm";
		}
	}
</script>
</html>

</html>