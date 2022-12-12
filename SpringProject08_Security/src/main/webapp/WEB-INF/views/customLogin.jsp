<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="/WEB-INF/views/includes/header.jsp"%>
    
    <div class="container">
<form action="/app08/login" method="post">
<!--action="/app08/login"은 정해져있음 다른것을 하려면 security-context.xml에서 <security:http></security:http>사이에 login을 대신할 것을 등록해야함.-->
    <div class="form-group">
      <label for="username">아이디:</label>
      <input type="text"  id="username" name="username" class="form-control"  placeholder="Enter ID"/>
      <!-- name="username"은 정해져있음 다른것을 하려면 security-context.xml에서<security:http></security:http>사이에 username-parameter를 이용해야함.-->
    </div>
      
    <div class="form-group">
      <label for="pass">비밀번호:</label>
      <input type="password" class="form-control" id="pass" placeholder="Enter pass" name="password" >
       <!-- name="password"은 정해져있음 다른것을 하려면 security-context.xml에서 <security:http></security:http>사이에 password-parameter를 이용해야함.-->
    </div>

    <button class="btn btn-primary">로그인</button>
    </form>
</div>

    <%@ include file="/WEB-INF/views/includes/footer.jsp"%>