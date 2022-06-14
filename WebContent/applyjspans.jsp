<%@page import="java.sql.*"%>
<%@page import="Cred.*"%>
<%!
public static int add;
%>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="Responsive Admin &amp; Dashboard Template based on Bootstrap 5">
	<meta name="author" content="AdminKit">
	<meta name="keywords" content="adminkit, bootstrap, bootstrap 5, admin, dashboard, template, responsive, css, sass, html, theme, front-end, ui kit, web">

	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link rel="shortcut icon" href="img/icons/icon-48x48.png" />

	<link rel="canonical" href="https://demo-basic.adminkit.io/" />

	<title>Admin</title>

	<link href="css/app.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap" rel="stylesheet">
</head>
<body>
	<div class="wrapper">
		<nav id="sidebar" class="sidebar js-sidebar">
			<div class="sidebar-content js-simplebar">
				<a class="sidebar-brand" href="index.html">
          <span class="align-middle">Candidate Dashbord</span>
        </a>

				<ul class="sidebar-nav">
					<li class="sidebar-header">
						Pages
					</li>

					<li class="sidebar-item active">
						<a class="sidebar-link" href="Candidatedashbord.jsp">
              <i class="align-middle" data-feather="sliders"></i> <span class="align-middle">Dashboard</span>
            </a>
					</li>

					<li class="sidebar-item">
						<a class="sidebar-link" href="#">
              <i class="align-middle" data-feather="user"></i> <span class="align-middle">View Result</span>
            </a>
					</li>

		

		

					
				</ul>

				
			</div>
		</nav>
		 <div class="bs-example1" data-example-id="contextual-table">
<%
String a=request.getParameter("id");
String email=Abc.getEmail();
int b=Integer.parseInt(request.getParameter("radio"));
System.out.println(email);

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
		
		String s1="select * from regcad where email=?";
		try{
			
			
		PreparedStatement ps=con.prepareStatement(s1);
		ps.setString(1, email);
		ResultSet rt=ps.executeQuery();
		
		if(rt.next()){
			System.out.println("Alo");
			int val=rt.getInt(4);
			val=val+b;
			String f1="update regcad set marks=? where email=?";
			try{
				
				
				PreparedStatement pst=con.prepareStatement(f1);
				pst.setInt(1, val);
				pst.setString(2, email);
				int h=pst.executeUpdate();
					System.out.println("hello");
				if(h>0){
					String w=""+ID.getId();				
					%>
					<input type="hidden" name="id" value="<%=a%>">
					<%
					String r="applyjob.jsp?id="+w;
					response.sendRedirect(r);
					%>
			
				</div>
				
		<%	
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	add=add+b;
	System.out.println(b);
	System.out.println(a);
		%>
		
		
	
	
	
	
	