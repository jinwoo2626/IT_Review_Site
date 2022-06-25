<%@page import="yuhan.mvc.teamproject.dto.UserInfo"%>
<%@ page language="java"
contentType = "text/html;charset=UTF-8"
pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
	
<html>    
    <head>
    
         <meta charset="utf-8">
 	
       <title></title>
      <link rel="stylesheet" type="text/css" href="css/style.css">
        <style>
 	body{
	background-color:FdFfFf;}          
            .menu1{
                width:100%;
                height:50px;       
            }
            a{
                text-decoration:none;
                color:white;
                
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
            .middle_Ad{
                margin: 30px 100px 2px 100px;
                height : 150px;
                background-color :white; 

                
                
            }
            .middle_and_right{
                width : 20%;
                
                height : 300px;
                background-color :aquamarine; 
            }
            .Ad_list div{                
                          
            }

            .bottom_div1{
                background-color : beige;
                width : 30%;
                height : 250px; 
                margin-right : 30px;
            }
	.center_board{
	   background-color : f4f4f4;
                width : 30%;
                height : 250px; 
                border-radius : 10px;
	   padding:10px;
	}
	.center_board a{
	color: black;
	}

	.bottom_tag{
	width: 100%;
	background-color :ffffff;
	}
	 .table_width{
            	width:100%;
	border-spacing:7px;
          		  }
            .board_btn{
	float: right;
	border: 0;
	outline:0;
	}
	.board_btn:hover{
	background-color:d3d3d3;
	}
	.midle_board{
	width:100%;
	border-spacing:7px;
	}

            .top_1{
              width:100%; 
              height: 60px;
              vertical-align: center;
              float:left;
              margin-bottom:5px;
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
		
	.top_1_right{
			float:right;
			text-align:right;
		  }

	input{
		border-radius: 7px;
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
        
       <div class="Ad_list">
           <div class = "middle_Ad">
                	<img src="resources/Prog-languages.png" width="100%" height="100%">
            </div>
        </div>
   		<table class = "table_width">
   			<tr>
   				<td class = "center_board" width="50%" height="500px" valign = "top">
				 <input type="button" value="더보기+" class="board_btn" onClick="location.href='HardWarelist'">
				 
				하드웨어 게시판 <br>
				<hr>
				<jsp:include page="HardWarelist2.jsp" flush="false"/>			
				
   				</td>
   				<td  class = "center_board" width="50%" height="500px" valign = "top">
				 <input type="button" value="더보기+" class="board_btn" onClick="location.href='SoftWarelist'">
				소프트웨어 게시판 <br>
				<hr>
				<jsp:include page="SoftWarelist2.jsp" flush="false"/>
				  
   				</td>
   			</tr>
			<tr>
				<td class = "center_board" valign = "top"> <input type="button" value="더보기+" class="board_btn" onClick="location.href='list'">
				자유게시판<br>
			  	<hr>
			  	<jsp:include page="list2.jsp" flush="false"/>
			  
			  </td>
				<td class = "center_board" valign = "top"> 
				기타 <br>
				  <hr>
				</td>
			</tr>
   		</table>
			
        <div class="row">
          
        </div>

  <table>
   <tr>
	<td class ="bottom_tag">
	 Java Spring Project<br>
	후기사이트 제작팀<br>
	제출일 : 2021.12.13
	</td>
  </tr>
 </table>
      </div>
</div>
     </div>
    </body>
</html>