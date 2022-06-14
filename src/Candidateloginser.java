

import java.io.IOException;
import Cred.*;
import java.sql.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Candidateloginser
 */
public class Candidateloginser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Candidateloginser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cname=request.getParameter("email");
		String cpass=request.getParameter("password");
		String s="select * from candidate where email=? and pass=?";
		
		Connection con=DbConnection.connect();
		try{
			PreparedStatement ps=con.prepareStatement(s);
			ps.setString(1, cname);
			ps.setString(2, cpass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				Abc.setEmail(cname);
				
				String s1="insert into regcad values(?,?,?,?,?)";
				try{
					int ca=0;
					int marks=0;
					String s2="pending";
					PreparedStatement pstmt=con.prepareStatement(s1);
					pstmt.setInt(1, 0);
					pstmt.setString(2, rs.getString(2));
					pstmt.setString(3, cname);
					pstmt.setInt(4, marks);
					pstmt.setString(5, s2);
					int d=pstmt.executeUpdate();
					if(d>0){
						
						response.sendRedirect("Candidatedashbord.jsp");
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}
				
				
			}
			else{
				response.sendRedirect("index.html");
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
