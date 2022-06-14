

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class JobRegister
 */
public class JobRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int a=0;
		String ti=request.getParameter("tit");
		String des=request.getParameter("des");
		String sal=request.getParameter("sala");
		String qual=request.getParameter("qul");
		String exp =request.getParameter("exp");
		String marks =request.getParameter("marks");
		Connection con=(Connection) DbConnection.connect();
		String s="insert into jobs values(?,?,?,?,?,?,?)";
		try{
			PreparedStatement st=con.prepareStatement(s);
			st.setInt(1, a);
			st.setString(2, ti);
			st.setString(3, des);
			st.setString(4, sal);
			st.setString(5, qual);
			st.setString(6, exp);
			st.setString(7, marks);
			int i=st.executeUpdate();
			if(i>0){
				response.sendRedirect("HRdashbord.html");
			}
		}catch(Exception e){
			response.sendRedirect("Addjob.html");
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
