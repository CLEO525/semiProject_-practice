<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String num1 = request.getParameter("num1");
  String num2 = request.getParameter("num2");
  String oper = request.getParameter("oper");
  int n1 = Integer.parseInt(num1);
  int n2 = Integer.parseInt(num2);
  int n3 = 0;
  String op = "";
  switch (oper){
      case "1" : n3=n1+n2;op="+"; break;
      case "2" : n3=n1-n2;op="-"; break;
      case "3" : n3=n1*n2;op="*"; break;
      case "4" : n3=n1/n2;op="/"; break;
  }
  response.setContentType("text/xml;charset=utf-8");
  PrintWriter pw = response.getWriter();
    pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    pw.print("<result>");
    pw.print("<num1>"+num1+"</num1>");
    pw.print("<num2>"+num2+"</num2>");
    pw.print("<num3>"+n3+"</num3>");
    pw.print("<oper>"+oper+"</oper>");
    pw.print("</result>");
%>
