<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%
  request.setCharacterEncoding("UTF-8");
%>   
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  /> 
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>결합</title>
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <script>
  var arr1 = [];
  var all_answer = [];
  var count = 0;
  var all_cot = 0;
  var cl_tmp = "";
  const all_count = ${answer}.length;
  const equals = (a, b) => a.length === b.length && a.every((v, i) => v === b[i]); 
  function fn_btk(c_id){
	  var cl_id = c_id.substr(1, 1);  
	  var strint = Number(cl_id);
	  arr1.push(strint);
	  count = count + 1;
	  cl_tmp += cl_id+" "
	  var scoremom = document.getElementById("moms");
	  scoremom.innerText = cl_tmp;
		  if (count == 3){
			  arr1.sort();
			  for(i=0; i < ${answer}.length; i++){
				  var arr2 = ${answer}[i];
				  arr2.sort();
				  if(all_answer.length > 0){
					  for(j=0; j < all_answer.length; j++){
						  var tmp = all_answer[j];
						  if(equals(arr1, tmp)){
							  arr1 = [];	
							  alert("오답(중복)");
							  count = 0;
							  cl_tmp = "";
							  scoremom.innerText = cl_tmp;
							  return;
						  }
					  }
				  }
				  	
				  if (all_cot != all_count){
					    
						if (equals(arr1, arr2)){
							alert("합");
							all_cot = all_cot + 1;
							count = 0;
							all_answer.push(arr1);
							var tmparr1 = arr1.join(" ");		
							var scoreboard = document.getElementById("scoreboard");
							scoreboard.innerHTML += "<p class='scob'>"+tmparr1+"</p>";
							cl_tmp = "";
							scoremom.innerText = cl_tmp;
							arr1 = [];
							return;
						}
			  
				  	}
			  }
			  arr1 = [];	
			  cl_tmp = "";
			  scoremom.innerText = cl_tmp;
			  alert("오답");
			  count = 0;
		  	}
		
	   
	}
  function fn_nodap(){
	  if (all_cot == all_count){
		  alert("결 성공! +3");
		  location.href = location.href;
	  }else{
		  alert("결 실패.. -1");
	  }
  }
  
  </script>
  <style>
.main_title{
	text-align: center;
}

.main_list {
    width: 700px;
    margin: 0 auto;
}

.list_start {
    text-align: center;
}



.list_detail {
    display: inline-block;
    width: 220px;
    height: 220px;
	border: 0px ;
    margin-bottom: 5px;
}

.paging_start{
	text-align: center;
}
#nodap{
	width: 150px;
	height: 70px;
}
#scoremom{
	float:right;
	text-align: center;
	display: block;
  	
  	background-color : bisque;
  	width : 150px;
  	height : 700px;
  	
}
.scob{
	display : block;
	
	clear:right;
	margin : 0 auto;
	border : 3px solid #d0eb5c;
	background : #d0fc5c;
	font-size : 20px;
}
#moms{
	float:right;
	text-align: center;
	display : block;	
	width: 150px;
	margin : 0 auto;
	border : 0px solid;
	background : #d0fc5c;
	font-size : 25px;
}
  </style>
 </head>
 <body>
 	<!-- 리스트 불러오기  -->
 	<div id="scoremom">
	 	<div id="scoreboard">
			
		</div>
		<p id="moms"></p>
	</div>
	
	<div class="main_list">
		<!-- 상단 제목 -->
		<div class="main_title">
			<p>결 합</p>
		</div>
		<!-- 리스트 -->
		
		<div class="list_start">
			<div class="list_detail"><button id="b1" class="btns" type="button" onclick="fn_btk(this.id)"><img src="${contextPath}/resources/img/${a1}.png"></button></div>
			<div class="list_detail"><button id="b2" class="btns" type="button" onclick="fn_btk(this.id)"><img src="${contextPath}/resources/img/${a2}.png"></button></div>
			<div class="list_detail"><button id="b3" class="btns" type="button" onclick="fn_btk(this.id)"><img src="${contextPath}/resources/img/${a3}.png"></button></div>
			<div class="list_detail"><button id="b4" class="btns" type="button" onclick="fn_btk(this.id)"><img src="${contextPath}/resources/img/${a4}.png"></button></div>
			<div class="list_detail"><button id="b5" class="btns" type="button" onclick="fn_btk(this.id)"><img src="${contextPath}/resources/img/${a5}.png"></button></div>
			<div class="list_detail"><button id="b6" class="btns" type="button" onclick="fn_btk(this.id)"><img src="${contextPath}/resources/img/${a6}.png"></button></div>
			<div class="list_detail"><button id="b7" class="btns" type="button" onclick="fn_btk(this.id)"><img src="${contextPath}/resources/img/${a7}.png"></button></div>
			<div class="list_detail"><button id="b8" class="btns" type="button" onclick="fn_btk(this.id)"><img src="${contextPath}/resources/img/${a8}.png"></button></div>
			<div class="list_detail"><button id="b9" class="btns" type="button" onclick="fn_btk(this.id)"><img src="${contextPath}/resources/img/${a9}.png"></button></div>
		</div>
		
		<div class="paging_start">
			<button id="nodap" type="button" onclick="fn_nodap()"><p>결</p></button>
		</div>
	</div>
 </body>
</html>
