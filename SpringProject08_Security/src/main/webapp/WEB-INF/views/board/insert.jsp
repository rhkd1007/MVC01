<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<div class = "container">
<form action="insert" method="post">
        <div class="form-group">
      <label for="title">제목:</label>
      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
    </div>
    
    <div class="form-group">
      <label for="writer">글쓴이:</label>
      <input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer">
    </div>

        <div class="form-group">
      <label for="content">내용:</label>
      <textarea class="form-control" row="5" id="content" name="content"></textarea>
    </div>
    
    <div align="right">
    	<button type="submit" class="btn btn-primary">글쓰기</button>
    	<a href="list"><button type="button" class="btn btn-primary">전체보기</button></a>
    	</div>
    	
</form>   	
</div>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>