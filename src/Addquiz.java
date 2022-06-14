

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Addquiz
 */
public class Addquiz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addquiz() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=DbConnection.connect();
		String quz=request.getParameter("quz");
		String field=request.getParameter("field");
		System.out.println(field);
		int SA= Integer.parseInt(request.getParameter("SA"));
		int Ag= Integer.parseInt(request.getParameter("Ag"));
		int Ne= Integer.parseInt(request.getParameter("Ne"));
		int Dis= Integer.parseInt(request.getParameter("Dis"));
		int Sdis= Integer.parseInt(request.getParameter("Sdis"));
		int i=0;
		String s="insert into quiz values(?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement pst=con.prepareStatement(s);
			pst.setInt(1, i);
			pst.setString(2, quz);
			pst.setString(3,field );
			pst.setInt(4,SA);
			pst.setInt(5, Ag);
			pst.setInt(6, Ne);
			pst.setInt(7, Dis);
			pst.setInt(8, Sdis);
			int j=pst.executeUpdate();
			if(j>0){
				response.sendRedirect("HRdashbord.html");
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
