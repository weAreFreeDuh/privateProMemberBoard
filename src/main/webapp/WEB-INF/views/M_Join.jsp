<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Pages / Register - NiceAdmin Bootstrap Template</title>
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

	<main>
		<div class="container">

			<section
				class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
				<div class="container">
					<div class="row justify-content-center">
						<div
							class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

							<div class="d-flex justify-content-center py-4">
								<a href="bList"
									class="logo d-flex align-items-center w-auto"> <img
									src="resources/assets/img/logo.png" alt=""> <span
									class="d-none d-lg-block">NiceAdmin</span>
								</a>
							</div>
							<!-- End Logo -->

							<div class="card mb-3">

								<div class="card-body">

									<div class="pt-4 pb-2">
										<h5 class="card-title text-center pb-0 fs-4">회원가입</h5>
										<p class="text-center small">당신의 정보를 자세히 기입해주세요</p>
									</div>

									<form action="mJoin" method="post" name="joinForm"
										enctype="multipart/form-data" class="row g-3 needs-validation"
										novalidate>

										<div class="col-12">
											<label for="yourName" class="form-label">이름</label> <input
												type="text" name="memName" class="form-control" id="memName"
												required>

											<div class="invalid-feedback">이름을 입력하시오</div>
										</div>

										<div class="col-12">
											<label for="yourEmail" class="form-label">이메일</label> <input
												type="email" name="memEmail" class="form-control"
												id="memEmail" required> <span id="confEmail"><input
												class="btn btn-primary w-20" type="button"
												onclick="checkEmail()" value="인증" /></span>
											<div class="invalid-feedback">이메일을 입력하시오</div>
										</div>

										<div class="col-12">
											<label for="yourUsername" class="form-label">아이디</label>
											<div class="input-group has-validation">
												<input type="text" name="memId" class="form-control"
													id="memId" onkeyup="checkId()" required>
											</div>
											<br />
											<span id="check1"></span>
										</div>

										<div class="col-12">
											<label for="yourPassword" class="form-label">비밀번호</label> <input
												type="password" name="memPw" class="form-control" id="memPw"
												onkeyup="pwRegexp()" required> <span id="pwResult1"></span>
										</div>
										<div class="col-12">
											<label for="yourPassword" class="form-label">비밀번호 확인</label>
											<input type="password" class="form-control" id="checkPw"
												onkeyup="pwCheck()" required> <span id="pwResult2"></span>
										</div>

										<div class="col-12">
											<label for="yourName" class="form-label">프로필사진</label> <input
												type="file" name="memProfile" class="form-control" required>

											<div class="invalid-feedback">프로필사진을 넣으시오</div>
										</div>

										<div class="col-12">
											<label for="yourName" class="form-label">생년월일</label> <input
												type="date" name="memBirth" class="form-control" required>

											<div class="invalid-feedback">생일을 입력하시오</div>
										</div>
										
										<div class="col-12">
											<label for="yourName" class="form-label">연락처</label> <input
												type="text" name="memPhone" class="form-control" required>

											<div class="invalid-feedback">연락처를 입력하시오</div>
										</div>
										<div class="col-12">
											<label for="yourName" class="form-label">주소</label>
											<input type="text" name="addr1"
												id="sample6_postcode" placeholder="우편번호" class="form-control"> 
												<input type="button" onclick="sample6_execDaumPostcode()"
												value="우편번호 찾기"  class="btn btn-primary w-40" ><br> 
												<input type="text" name="addr2" id="sample6_address" placeholder="주소" class="form-control">
												<input type="text" name="addr3" id="sample6_detailAddress" class="form-control"
												placeholder="상세주소" value="상세주소">
										</div>
										


										<div class="col-12">
											<div class="form-check">
												<input class="form-check-input" name="terms" type="checkbox"
													value="" id="acceptTerms" required> <label
													class="form-check-label" for="acceptTerms">I agree
													and accept the <a href="#">terms and conditions</a>
												</label>
												<div class="invalid-feedback">You must agree before
													submitting.</div>
											</div>
										</div>
										<div class="col-12">
											<button class="btn btn-primary w-100" type="submit" onclick="checkConfirm()">회원가입</button>
										</div>
										<div class="col-12">
											<p class="small mb-0">
												Already have an account? <a href="pages-login.html">Log
													in</a>
											</p>
										</div>
									</form>

								</div>
							</div>

							<div class="credits">
								<!-- All the links in the footer should remain intact. -->
								<!-- You can delete the links only if you purchased the pro version. -->
								<!-- Licensing information: https://bootstrapmade.com/license/ -->
								<!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
								Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
							</div>

						</div>
					</div>
				</div>

			</section>

		</div>
	</main>
	<!-- End #main -->

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
		pwResult1.innerHTML = "비밀번호는 8자리에서 16자리 이내로 입력해주세요.";
		return false;
		
	} else if(spc >= 0){
		pwResult1.style.color = "#ff0000";
		pwResult1.innerHTML = "비밀번호는 공백없이 입력해주세요.";
		return false;
	
	} else if(num < 0 || eng < 0 || spe < 0){
		pwResult1.style.color = "#ff0000";
		pwResult1.innerHTML = "영문, 숫자, 특수문자를 혼합하여 입력해주세요.";
		return false;
	
	} else {
		pwResult1.style.color = "#0000ff";
		pwResult1.innerHTML = "사용가능한 비밀번호 입니다.";
		return true;
	}
	

}

function pwCheck(){
	
	let memPw = document.getElementById("memPw").value;
	let checkPw = document.getElementById("checkPw").value;
	let pwResult2 = document.getElementById("pwResult2");
	
	if(memPw == checkPw){
		pwResult2.style.color = "#0000ff";
		pwResult2.innerHTML = "비밀번호가 일치합니다.";
		return true;
	} else {
		pwResult2.style.color = "#ff0000";
		pwResult2.innerHTML = "비밀번호가 일치하지 않습니다.";
		return false;
	}
	
	
}

function checkConfirm(){
	

	
	if(!pwRegexp() || !pwCheck()){
		
		alert('비밀번호를 확인해주세요!.');
		
	} else if(!checkEmail2()){
		
		alert('이메일 인증을 진행해주세요.');
		
	} else {
		
		joinForm.submit();
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
				// 사용할 수 있는 아이디일 경우 실행
				check1.innerHTML = memId + "는 사용가능한 아이디";
				check1.style.color = "#0000ff";
				
			} else {
				// 사용할 수 없는 아이디일 경우 실행
				check1.innerHTML = memId + "는 이미 사용중인 아이디";
				check1.style.color = "#ff0000";
				
			}
		},
		error : function(){
			alert("idoverlap함수 통신실패!");
			
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
			console.log("이메일 인증번호1 : " + uuid);
			$("#confEmail").html("<br/><input class='form-control' type='text' id='uuidCheck'/>"
					+" <input type='hidden' value='"+ uuid +"' id='uuid'/>"
					+" <input class='btn btn-primary w-20' type='button' value='인증' onclick=\"checkEmail2()\"/>");
		},
		error : function(){
			alert('이메일 인증 통신 실패!');
		}
	});
}


function checkEmail2(){
	let uuid = $("#uuid").val();
	console.log("이메일 인증번호2 : " + uuid);
	
	let uuidCheck = $("#uuidCheck").val();
	console.log("입력한 인증번호 : " + uuidCheck);
	
	let boolUUID = false;
	
	if(uuidCheck==null || uuidCheck==""){
		
	}else if(uuid == uuidCheck){
		alert('인증성공!');
		boolUUID = true;
	} else {
		alert('인증실패!');
	}
	
	return boolUUID;
}

</script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>



</html>