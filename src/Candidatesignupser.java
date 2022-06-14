

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Candidatesignupser
 */
public class Candidatesignupser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Candidatesignupser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int o=0;
		int u=0;
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String Phone=request.getParameter("Phone");
		String Age=request.getParameter("Age");
		String City=request.getParameter("City");
		String dist=request.getParameter("District");
		String Tal=request.getParameter("Taluka");
		String pin=request.getParameter("Pincode");
		String Qual=request.getParameter("Qual");
		String work=request.getParameter("Work");
		String pass =request.getParameter("password");
		Connection con=DbConnection.connect();
		String s1="select * from candidate ";
		try {
			Statement st=con.createStatement();
			ResultSet rt=st.executeQuery(s1);
			while(rt.next()){
				if(rt.getString("email").equals(email)){
					u=1;
				}
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(u==0){
			
		
		String s="insert into candidate values(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, o);
			pstmt.setString(2,name );
			pstmt.setString(3,email );
			pstmt.setString(4,Phone );
			pstmt.setString(5,Age );
			pstmt.setString(6,City );
			pstmt.setString(7,dist );
			pstmt.setString(8,Tal );
			pstmt.setString(9,pin );
			pstmt.setString(10,Qual );
			pstmt.setString(11,work );
			pstmt.setString(12,pass );
			int i=pstmt.executeUpdate();
			if(i>0){
				response.sendRedirect("index.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else{
			response.sendRedirect("CandidateRegistration.html");
			
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
