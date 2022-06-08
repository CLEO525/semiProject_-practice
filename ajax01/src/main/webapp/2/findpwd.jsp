<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String id = request.getParameter("id");
    String pwd = null;
    if(id!=null && id.equals("song")){
        pwd="1234";
    }
    /////////////응답을 XML로 하기 //////////
    response.setContentType("text/xml;charset=utf-8");
    PrintWriter pw = response.getWriter();
    pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    pw.print("<result>");
    if(pwd==null){
        pw.print("<code>fail</code>");
    }else{
        pw.print("<code>success</code>");
        pw.print("<pwd>"+pwd+"</pwd>");
    }
    pw.print("</result>");
    pw.close();
%>