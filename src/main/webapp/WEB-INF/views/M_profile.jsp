<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Users / Profile - NiceAdmin Bootstrap Template</title>
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

			<li class="nav-item"><a class="nav-link " href="index.html">
					<i class="bi bi-grid"></i> <span>Dashboard</span>
			</a></li>
			<!-- End Dashboard Nav -->

			<li class="nav-item"><a class="nav-link collapsed"
				data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
					<i class="bi bi-menu-button-wide"></i><span>????????? ??????</span><i
					class="bi bi-chevron-down ms-auto"></i>
			</a>
				<ul id="components-nav" class="nav-content collapse "
					data-bs-parent="#sidebar-nav">
					<li><a href="write"> <i class="bi bi-circle"></i><span>???????????????</span>
					</a></li>
					<li><a href="mProfile"> <i class="bi bi-circle"></i><span>???????????????</span>
					</a></li>
					<li><a href="components-badges.html"> <i
							class="bi bi-circle"></i><span></span>
					</a></li>

				</ul></li>
			<!-- End Components Nav -->









			<li class="nav-heading">Pages</li>

			<li class="nav-item"><a class="nav-link collapsed"
				href="mProfile"> <i class="bi bi-person"></i> <span>Profile</span>
			</a></li>
			<!-- End Profile Page Nav -->


			<li class="nav-item"><a class="nav-link collapsed"
				href="mJoinForm"> <i class="bi bi-card-list"></i> <span>Register</span>
			</a></li>
			<!-- End Register Page Nav -->

			<li class="nav-item"><a class="nav-link collapsed"
				href="M_Login"> <i class="bi bi-box-arrow-in-right"></i> <span>Login</span>
			</a></li>
			<!-- End Login Page Nav -->

		</ul>

	</aside>
	<!-- End Sidebar-->

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>Profile</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">Home</a></li>
					<li class="breadcrumb-item">Users</li>
					<li class="breadcrumb-item active">Profile</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section profile">
			<div class="row">
				<div class="col-xl-4">

					<div class="card">
						<div
							class="card-body profile-card pt-4 d-flex flex-column align-items-center">

							<img src="resources/profile/${memInfo.memProfileName }"
								alt="Profile" class="rounded-circle">
							<h2>${memInfo.memId}</h2>


						</div>
					</div>

				</div>

				<div class="col-xl-8">

					<div class="card">
						<div class="card-body pt-3">
							<!-- Bordered Tabs -->
							<ul class="nav nav-tabs nav-tabs-bordered">

								<li class="nav-item">
									<button class="nav-link active" data-bs-toggle="tab"
										data-bs-target="#profile-overview">????????? ??????</button>
								</li>

								<li class="nav-item">
									<button class="nav-link" data-bs-toggle="tab"
										data-bs-target="#profile-edit">????????? ??????</button>
								</li>

								<li class="nav-item">
									<button class="nav-link" data-bs-toggle="tab"
										data-bs-target="#profile-change-password">???????????? ??????</button>
								</li>

							</ul>
							<div class="tab-content pt-2">

								<div class="tab-pane fade show active profile-overview"
									id="profile-overview">
									<h5 class="card-title">??????</h5>
									<p class="small fst-italic">?????? ??????????????? ???????????? ?????? ????????????.</p>

									<h5 class="card-title">????????? ????????????</h5>

									<div class="row">
										<div class="col-lg-3 col-md-4 label ">??????</div>
										<div class="col-lg-9 col-md-8">${memInfo.memName}</div>
									</div>

									<div class="row">
										<div class="col-lg-3 col-md-4 label">????????????</div>
										<div class="col-lg-9 col-md-8">${memInfo.memPhone}</div>
									</div>

									<div class="row">
										<div class="col-lg-3 col-md-4 label">?????????</div>
										<div class="col-lg-9 col-md-8">${memInfo.memEmail}</div>
									</div>

									<div class="row">
										<div class="col-lg-3 col-md-4 label">??????</div>
										<div class="col-lg-9 col-md-8">${memInfo.memBirth}</div>
									</div>

									<div class="row">
										<div class="col-lg-3 col-md-4 label">??????</div>
										<div class="col-lg-9 col-md-8">${memInfo.memAddr}</div>
									</div>

								</div>

								<div class="tab-pane fade profile-edit pt-3" id="profile-edit">

									<!-- Profile Edit Form -->
									<form method="post" action="mModify"
										enctype="multipart/form-data" name="mModifyForm"
										onSubmit="return false;">
										
										
										<input type="hidden" value="${memInfo.memId}" name="memId">
										<div class="row mb-3">
											<label for="profileImage"
												class="col-md-4 col-lg-3 col-form-label">????????? ??????</label>
											<div class="col-md-8 col-lg-9">
												<img src="resources/profile/${memInfo.memProfileName }"
													alt="Profile">

												<div class="pt-2">
													<input class="form-control" type="file" name="memProfile">
												</div>
											</div>
										</div>

										<div class="row mb-3">
											<label for="fullName"
												class="col-md-4 col-lg-3 col-form-label">??????</label>
											<div class="col-md-8 col-lg-9">
												<input name="memName" type="text" class="form-control"
													id="fullName" value="${memInfo.memName}">
											</div>
										</div>

										<div class="row mb-3">
											<label for="company" class="col-md-4 col-lg-3 col-form-label">??????</label>
											<div class="col-md-8 col-lg-9">
												<input name="memBirth" type="text" class="form-control"
													id="company" value="${memInfo.memBirth}">
											</div>
										</div>

										<div class="row mb-3">
											<label for="Job" class="col-md-4 col-lg-3 col-form-label">?????????</label>
											<div class="col-md-8 col-lg-9">
												<input name="memEmail" type="email" class="form-control"
													id="Job" value="${memInfo.memEmail}">
											</div>
										</div>

										<div class="row mb-3">
											<label for="Country" class="col-md-4 col-lg-3 col-form-label">????????????</label>
											<div class="col-md-8 col-lg-9">
												<input name="memPhone" type="text" class="form-control"
													id="Country" value="${memInfo.memPhone}">
											</div>
										</div>

										<div class="row mb-3">
											<label for="Address" class="col-md-4 col-lg-3 col-form-label">??????</label>
											<div class="col-md-8 col-lg-9">
												<label for="yourName" class="form-label">??????</label> <input
													type="text" name="addr1" id="sample6_postcode"
													placeholder="????????????" class="form-control"> <input
													type="button" onclick="sample6_execDaumPostcode()"
													value="???????????? ??????" class="btn btn-primary w-40"><br>
												<input type="text" name="addr2" id="sample6_address"
													placeholder="??????" class="form-control"> <input
													type="text" name="addr3" id="sample6_detailAddress"
													class="form-control" placeholder="????????????">

											</div>
										</div>

										<div class="text-center">
											<button type="submit" class="btn btn-primary">????????????</button>
										</div>
									</form>
									<!-- End Profile Edit Form -->

								</div>



								<div class="tab-pane fade pt-3" id="profile-change-password">
									<!-- Change Password Form -->
									<form action="mChangePw" method="post">
										<input type="hidden" name="memId" value="${memInfo.memId }">


										<div class="row mb-3">
											<label for="yourEmail"
												class="col-md-4 col-lg-3 col-form-label">?????????</label>
											<div class="col-md-8 col-lg-9">
												<input type="email" name="memEmail" class="form-control"
													id="memEmail" value="${memInfo.memEmail}" disabled required>
												<span id="confEmail">
											</div>
											<div class="col-md-8 col-lg-9">
												<input class="btn btn-primary w-20" type="button"
													onclick="checkEmail()" value="?????????????????????" /> </span>
											</div>
										</div>

										<div class="row mb-3">
											<label for="yourPassword"
												class="col-md-4 col-lg-3 col-form-label">????????????</label>
											<div class="col-md-8 col-lg-9">
												<input type="password" name="memPw" class="form-control"
													id="memPw" onkeyup="pwRegexp()" required> <span
													id="pwResult1"></span>
											</div>
										</div>
										<div class="row mb-3">
											<label for="yourPassword"
												class="col-md-4 col-lg-3 col-form-label">???????????? ??????</label>
											<div class="col-md-8 col-lg-9">
												<input type="password" class="form-control" id="checkPw"
													onkeyup="pwCheck()" required> <span id="pwResult2"></span>
											</div>
										</div>

										<div class="text-center">
											<button type="submit" class="btn btn-primary" onclick="checkConfirm()">???????????? ??????</button>
										</div>
									</form>
									<!-- End Change Password Form -->

								</div>

							</div>
							<!-- End Bordered Tabs -->

						</div>
					</div>

				</div>
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

<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // ???????????? ???????????? ????????? ??????????????? ????????? ????????? ???????????? ??????.

                // ??? ????????? ?????? ????????? ?????? ????????? ????????????.
                // ???????????? ????????? ?????? ?????? ????????? ??????('')?????? ????????????, ?????? ???????????? ?????? ??????.
                var addr = ''; // ?????? ??????

                //???????????? ????????? ?????? ????????? ?????? ?????? ?????? ?????? ????????????.
                if (data.userSelectedType === 'R') { // ???????????? ????????? ????????? ???????????? ??????
                    addr = data.roadAddress;
                } else { // ???????????? ?????? ????????? ???????????? ??????(J)
                    addr = data.jibunAddress;
                }

                // ??????????????? ?????? ????????? ?????? ????????? ?????????.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // ????????? ???????????? ????????? ????????????.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>

<script src="https://code.jquery.com/jquery-3.6.1.js"
	integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
	crossorigin="anonymous"></script>
<script>

function pwRegexp(){
	let memPw = document.getElementById("memPw").value;
	let pwResult1 = document.getElementById("pwResult1");
	
	let num = memPw.search(/[0-9]/);
	let eng = memPw.search(/[a-z]/);
	let spe = memPw.search(/[`~!@#$%^&*|\\\'\":;\/?]/);
	let spc = memPw.search(/\s/);
	
	console.log("num : " + num + " , eng : " + eng + " , spe : " + spe);

	
	if(memPw.length < 8 || memPw.length > 16){
		pwResult1.style.color = "#ff0000";
		pwResult1.innerHTML = "??????????????? 8???????????? 16?????? ????????? ??????????????????.";
		return false;
		
	} else if(spc >= 0){
		pwResult1.style.color = "#ff0000";
		pwResult1.innerHTML = "??????????????? ???????????? ??????????????????.";
		return false;
	
	} else if(num < 0 || eng < 0 || spe < 0){
		pwResult1.style.color = "#ff0000";
		pwResult1.innerHTML = "??????, ??????, ??????????????? ???????????? ??????????????????.";
		return false;
	
	} else {
		pwResult1.style.color = "#0000ff";
		pwResult1.innerHTML = "??????????????? ???????????? ?????????.";
		return true;
	}
	

}

function pwCheck(){
	
	let memPw = document.getElementById("memPw").value;
	let checkPw = document.getElementById("checkPw").value;
	let pwResult2 = document.getElementById("pwResult2");
	
	if(memPw == checkPw){
		pwResult2.style.color = "#0000ff";
		pwResult2.innerHTML = "??????????????? ???????????????.";
		return true;
	} else {
		pwResult2.style.color = "#ff0000";
		pwResult2.innerHTML = "??????????????? ???????????? ????????????.";
		return false;
	}
	
	
}

function checkConfirm(){
	

	
	if(!pwRegexp() || !pwCheck()){
		
		alert('??????????????? ??????????????????!.');
		return false;
		
	} else if(!checkEmail2()){
		
		alert('????????? ????????? ??????????????????.');
		return false;
		
	} else {
		
		mModifyForm.submit();
	}
}

function checkId(){
	let memId = document.getElementById("memId").value;
	// location.href = "idCheck?memId=" + memId;
	
	let check1 = document.getElementById("check1");
	
	$.ajax({
		type : "POST",
		url : "idoverlap",
		data : {
			"memId" : memId
		}, 
		dataType : "text", 
		success : function(result){
			if(result=="OK"){
				// ????????? ??? ?????? ???????????? ?????? ??????
				check1.innerHTML = memId + "??? ??????????????? ?????????";
				check1.style.color = "#0000ff";
				
			} else {
				// ????????? ??? ?????? ???????????? ?????? ??????
				check1.innerHTML = memId + "??? ?????? ???????????? ?????????";
				check1.style.color = "#ff0000";
				
			}
		},
		error : function(){
			alert("idoverlap?????? ????????????!");
			
		}
		
	});

	
}

function checkEmail(){
	
	
	let memEmail = $("#memEmail").val();
	
	$.ajax({
		type : "POST",
		url : "mCheckEmail",
		data : { "memEmail" : memEmail },
		dataType : "text",
		success : function(uuid){
			console.log("????????? ????????????1 : " + uuid);
			$("#confEmail").html("<br/><input class='form-control' type='text' id='uuidCheck'/>"
					+" <input type='hidden' value='"+ uuid +"' id='uuid'/>"
					+" <input class='btn btn-primary w-20' type='button' value='??????' onclick=\"checkEmail2()\"/>");
		},
		error : function(){
			alert('????????? ?????? ?????? ??????!');
		}
	});
}


function checkEmail2(){
	let uuid = $("#uuid").val();
	console.log("????????? ????????????2 : " + uuid);
	
	let uuidCheck = $("#uuidCheck").val();
	console.log("????????? ???????????? : " + uuidCheck);
	
	let boolUUID = false;
	
	if(uuidCheck==null || uuidCheck==""){
		
	}else if(uuid == uuidCheck){
		alert('????????????!');
		boolUUID = true;
	} else {
		alert('????????????!');
	}
	
	return boolUUID;
}

</script>

</html>