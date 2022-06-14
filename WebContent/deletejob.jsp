<%@page import="java.sql.*"%>
<%
int id=Integer.parseInt(request.getParameter("id"));
Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded...");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ocean", "root","");
			System.out.println("Connection Established.......");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
	String s1="delete from jobs where jid=?";
	PreparedStatement pstmt=con.prepareStatement(s1);
	pstmt.setInt(1, id);
	int j=pstmt.executeUpdate();
	if(j>0){
		response.sendRedirect("Viewjob.jsp");
	}
	
	
	
%>