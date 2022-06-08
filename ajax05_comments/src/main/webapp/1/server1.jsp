<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    int num = Integer.parseInt(request.getParameter("num"));
    if(num==1){
%>
    <h1>전체 상영작</h1>
    <img src="${pageContext.request.contextPath}/images/001.jpg}">
    <img src="${pageContext.request.contextPath}/images/002.jpg}">
    <img src="${pageContext.request.contextPath}/images/003.jpg}">

<%
    }else{
%>
    <h1>인기 상영작</h1>
    <img src="${pageContext.request.contextPath}/images/004.jpg}">
    <img src="${pageContext.request.contextPath}/images/005.jpg}">
    <img src="${pageContext.request.contextPath}/images/006.jpg}">
<%
    }
%>