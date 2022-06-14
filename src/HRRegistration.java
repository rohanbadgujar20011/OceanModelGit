

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HRRegistration
 */
public class HRRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HRRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=DbConnection.connect();
		int id=0;
		String Name=request.getParameter("Name");
		String email=request.getParameter("email");
		String mo=request.getParameter("mo");
		String pass=request.getParameter("pass");
		String desig=request.getParameter("desig");
		String s="insert into hr values(?,?,?,?,?,?)";
		try{
			PreparedStatement pst=con.prepareStatement(s);
			pst.setInt(1, id);
			pst.setString(2, Name);
			pst.setString(3, email);
			pst.setString(4, mo);
			pst.setString(5, pass);
			pst.setString(6, desig);
			int i=pst.executeUpdate();
			if(i>0){
				response.sendRedirect("Admindashbord.html");
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
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
