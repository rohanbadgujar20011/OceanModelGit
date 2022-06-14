<%@page import="java.sql.*"%>
<%@page import="Cred.*"%>

<%

String id=request.getParameter("id");
ID.setId(Integer.parseInt(id));







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
		Statement st=null;
	
	ResultSet rt=null;

%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/h1.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js  rel="stylesheet">
</head>
<body>

<div class="container mt-sm-5 my-1">
    <div class="question ml-sm-5 pl-sm-5 pt-2">
    
      <%       
	try{ 
		st=con.createStatement();
		String s="select quiz.*  from quiz,jobs where jobs.Title=quiz.field and jobs.jid="+id;
	    int c=1;
		rt=st.executeQuery(s);
		while(rt.next()){
			
			
	
			
			
			%>
			<form action="applyjspans.jsp" method="post">

			
			
			<div class="py-2 h5"><b><%=c%></b></div>
			<div class="py-2 h5"><b><%=rt.getString(2)%></b></div>
			   <div class="ml-md-3 ml-sm-3 pl-md-5 pt-sm-0 pt-3" id="options"> 
			   <label class="options">Strongly Agree <input type="radio" value="<%=rt.getInt(4) %>" name="radio"> <span class="checkmark"></span> </label>
			    <label class="options">Agree <input type="radio" value="<%=rt.getInt(5) %>" name="radio"> <span class="checkmark"></span> </label> 
			    <label class="options">Neutral<input type="radio" value="<%=rt.getInt(6) %>" name="radio"> <span class="checkmark"></span> </label> 
			    <label class="options">Disagree <input type="radio"value="<%=rt.getInt(7) %>" name="radio"> <span class="checkmark"></span> </label> 
			 <label class="options">Strongly Disagree <input type="radio" value="<%=rt.getInt(8) %>" name="radio"> <span class="checkmark"></span> </label></div> 
			
	
    <div class="d-flex align-items-center pt-3">
       <input type="hidden" name="id" value="<%=rt.getInt(1)%>">  
         <input type="hidden" name="id" value="<%=id%>">  
        <div class="ml-auto mr-sm-5"> <button class="btn btn-success" type="submit">Next</button> </div>
        </form>
      </div>
   
	<%
	c++;
		}
		%>
</div>
			
   
   

		
			<form action="Candidatedashbord">
			
			<button class="btn btn-success" type="submit">SUBMIT</button>
			
			</form>
		
		
		<% 
		con.close();
	}catch(Exception e){
		e.printStackTrace();
	}
			
			%>
    
    
    
  
        
        


</body>



</html>