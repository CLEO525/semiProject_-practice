<%@page import="java.io.PrintWriter"%>
<%@page import="test.db.ConnectionPool"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Connection con =null;
    PreparedStatement pstmt = null;
    ResultSet rs =null;
    String id="";
    String pwd="";
    String email="";
    try{
        con= ConnectionPool.getConn();
        String sql = "select * from member2";
        pstmt=con.prepareStatement(sql);
        rs=pstmt.executeQuery();
        response.setContentType("text/xml;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        pw.print("<result>");
        while(rs.next()){
            id = rs.getString("id");
            pwd = rs.getString("pwd");
            email = rs.getString("email");
            pw.print("<id>"+id+"</id>");
            pw.print("<pwd>"+pwd+"</pwd>");
            pw.print("<email>"+email+"</email>");
        }
        pw.print("</result>");
    }catch (SQLException se){
        se.printStackTrace();
    }finally {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }catch (SQLException s){
            s.printStackTrace();
        }
    }
%>