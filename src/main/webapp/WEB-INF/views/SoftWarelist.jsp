<%@page import="yuhan.mvc.teamproject.dto.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
      <link rel="stylesheet" type="text/css" href="css/style.css">
        <style>
           
            .menu1{
                width:100%;
                height:50px;       
           		
               
            }
          
            a{
                text-decoration:none;
                color:black;
                
            }
           	.menu1 ul{
           		padding:0;
           	}
            .menu1 ul li{
                float:left;
                width:25%;
                height:100%;
                line-height:50px;
                text-align:center;
                background:purple;   
                 list-style:none;   
                       
            }
           
            .Menu1 ul li a{
                display:block;
            }
            .Menu1 ul li a:hover {
                background:mediumpurple;
            }
            .middle_slider{
                width : 80%;
                height : 300px;
                background-color :red; 
                
                
            }
            .middle_and_right{
                width : 20%;
                
                height : 300px;
                background-color :aquamarine; 
               
                
            }
            .listDiv div{                
                float : left;            
            }
            .div_right{
                float : right;
            }
            .listDiv2 div{                
                float : left;
                margin-top: 20px;
                padding : 20px;
                
                
                
            }
            .bottom_div1{
                background-color : beige;
                width : 30%;
                height : 250px; 
                margin-right : 30px;
                
            
            }
            .bottom_div2{
                background-color : red;
                width : 20%;
                height : 150px;
                margin-right : 30px;
            }
            .bottom_div3{
                background-color : lightskyblue;
                width : 25%;
                height: 250px;
                margin-right : 30px;                
                
            }
           
            
            
            .top_1{
                width:100%; 
                height: 60px;
                vertical-align: center;
              	float:left;
              	margin-bottom:5px;
                
            }
          
            .table_width{
            	width:100%;
            }
            .container {
 			 padding-right: 15px;
 			 padding-left: 15px;
 			 margin-right: auto;
 			 margin-left: auto;
 			 width : 1050px;
 			 height : 700px;
 		
}	
		.nav{
			height:50px;
			align-content: center;
			background-color:red; 
		}
		.btn {
		
			width:80px;
			heigth:5px;
		    background-color: #aaaaaa;
		    border: none;
   			color:#fff;
   			padding: 10px 0;
   			text-align: center;
   			text-decoration: none;
   			display: inline-block;
   			font-size: 15px;
		   	margin: 4px;
 			cursor: pointer;

}
		.menu{
				float:left;
                width:100%;
                height:100%;
                line-height:50px;
                text-align:center;
                background:#cc99ff;   
                list-style:none;  
		}
		.menu a{ padding : 35px;
        }
		
		.top_1_right{
			float:right;
			text-align:right;
		}
		input{
		border-radius: 7px;
		}
		table {
   		 width: 100%;
    	 border-top: 1px solid #444444;
 	     border-collapse: collapse;
 		 }
 		 td {
  		  border-bottom: 1px solid #444444;
  		  padding: 10px;
  		}
        </style>
        
    </head>
    <body>
    
    <% 
    UserInfo userinfo = (UserInfo)session.getAttribute("userInfo");
    String id = (String)session.getAttribute("user_id");
    String nick = (String)session.getAttribute("user_name");

    if(userinfo==null){ %>
    <div class="container" >
    <!--맨위 배너 들어가고 길게 라인 있을곳-->
        <div class="top_1">
 			<input type="button" class="btn" value="메인" onclick="location.href='home'">
 			 <div class="top_1_right">
             <input type="button" class="btn" value="로그인" onclick="location.href='login'">
             <input type="button" class="btn" value="회원가입" onclick="location.href='join'">
           </div>
                
        
     </div><br><br>
    
    <%}
    else{ %>
    <div class="container" >
    <!--맨위 배너 들어가고 길게 라인 있을곳-->
        <div class="top_1">      
        <input type="button" class="btn" value="메인" onclick="location.href='home'">
            <div class="top_1_right"> <%= userinfo.getUser_name()   %>님 반갑습니다.<br><input type="button" value="회원정보" class="btn" onclick="location.href='userinfomation'">
            <input type ="button" value="로그아웃"  class="btn" onclick="location.href='logout'"></div>
        </div>  
       <br> <br>  
     <%} %>
   
    <!--메뉴-->
        <div class = "menu1">
        <ul>
            <a href="HardWarelist"><li>하드웨어</li></a>
            <a href="SoftWarelist"><li>소프트웨어</li></a>
            <a href="list"><li>자유게시판</li></a>
            <a href="#"><li>기타</li></a>
        </ul>
        </div>
        <br>
        <center>
        <div class="menu">
<a href="SoftWarelist?category=APP">APP</a> 
<a href="SoftWarelist?category=GAME">GAME</a> 
<a href="SoftWarelist?category=WEB">WEB</a> 
<a href="SoftWarelist?category=MEDIA">MEDIA</a> 
</div>
<br><br><br>
<table width="600" cellpadding="1" cellspacing="1" border="2">
<tr>
<td>번호</td>
<td>이름</td>
<td>제목</td>
<td>카테고리</td>
<td>날짜</td>
<td>추천</td>
<td>조회수</td>

</tr>
<c:forEach items="${SoftWarelist}" var="dto">
<tr>
<td>${dto.s_no}</td>
<td>${dto.s_name}</td>
<td>
<!--<c:forEach begin="1" end="${dto.s_no}">-</c:forEach>-->
<a href="SoftWarecontent_view?s_no=${dto.s_no}">${dto.s_subject}</a></td>
<td>${dto.s_code}</td><td>${dto.s_time}</td><td>${dto.s_suggest}</td><td>${dto.s_count}</td>
</tr>
</c:forEach>
<tr>  
<td colspan="7"> <a href="SoftWarewrite_view"><img src="resources/write_b.gif"></a></td>
<!-- <td colspan="7"> <a href="write_view">글작성</a></td> -->
</tr>
</table>
</center>

</body>
</html>
