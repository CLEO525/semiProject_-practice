<%@page import="java.io.PrintWriter"%>
<%@page import="test.db.ConnectionPool"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String email = request.getParameter("email");
    String id="";
    boolean exist = false;
    Connection con =null;
    PreparedStatement pstmt = null;
    ResultSet rs =null;
    try{
        con= ConnectionPool.getConn();
        String sql = "select id from member2 where email=?";
        pstmt=con.prepareStatement(sql);
        pstmt.setString(1,email);
        rs=pstmt.executeQuery();
        if(rs.next()){
        	exist=true;
           id = rs.getString("id");
        }
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
    response.setContentType("text/xml;charset=utf-8");
    PrintWriter pw = response.getWriter();
    pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    pw.print("<result>");
    pw.print("<exist>"+exist+"</exist>");
    pw.print("<id>"+id+"</id>");
    pw.print("</result>");
%>