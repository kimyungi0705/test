<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num1=Integer.parseInt(request.getParameter("num1"));
	int num2=Integer.parseInt(request.getParameter("num2"));
	String oper=request.getParameter("oper");
	double num3=0;
	response.setContentType("text/xml;charset=utf-8");
	PrintWriter pw=response.getWriter();
	pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	pw.println("<result>");
	if(num1==0 || num2==0){
		pw.println("<code>fail</code>");
	}else{
		if(oper.equals("1")){
			num3=num1+num2;
		}else if(oper.equals("2")){
			num3=num1-num2;
		}else if(oper.equals("3")){
			num3=num1*num2;
		}else{
			num3=(double)num1/num2;
		}	
		pw.println("<code>success</code>");
		pw.println("<num3>" + num3+ "</num3>");
	}
	pw.println("</result>");
%>
