<%@page import="java.sql.*"%>
<%@page import="Cred.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%   
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
		String cname=request.getParameter("email");
		String cpass=request.getParameter("password");
		String s="select * from candidate where email=? and pass=?";
		
		
		try{
			PreparedStatement ps=con.prepareStatement(s);
			ps.setString(1, cname);
			ps.setString(2, cpass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				String s1="insert into regcad values(?,?,?,?,?)";
				try{
					int ca=0;
					int marks=0;
					String s2="pending";
					PreparedStatement pstmt=con.prepareStatement(s1);
					pstmt.setInt(1,ca);
					pstmt.setString(2,rs.getString("Name"));
					pstmt.setString(3, cname);
					pstmt.setInt(4, marks);
					pstmt.setString(5, s2);
					int d=pstmt.executeUpdate();
					if(d>0){
						Abc.setEmail(cname);
						
						
						%>
						
						<% 
						
						response.sendRedirect("Candidatedashbord.jsp");
					}
					else{
						response.sendRedirect("index.html");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		%>
