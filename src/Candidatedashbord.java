

import java.io.IOException;

import Cred.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Candidatedashbord
 */
public class Candidatedashbord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Candidatedashbord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
          Connection con=DbConnection.connect();
          String s="select * from regcad where email=?";
          String r="select * from jobs where jid=?";
          
  		
		try {
			PreparedStatement pt1 = con.prepareStatement(s);
			pt1.setString(1,Abc.getEmail());
	  		
	  		ResultSet rt=pt1.executeQuery();
	  		while(rt.next()){
	  			int get=rt.getInt("marks");
	  			System.out.println(rt.getInt("marks"));
	  			PreparedStatement pts=con.prepareStatement(r);
	  			System.out.println(ID.getId());
	  			pts.setInt(1,ID.getId());
	  			ResultSet rtst =pts.executeQuery();
	  			
	  			
	  			if(rtst.next()){
	  				int req=rtst.getInt("markes");
	  				
	  				if(req<= get){
	  				String t="Selected";
	  				 String s1="update regcad set status=?  where email=?";
	  				PreparedStatement pst;
	  				try {
	  					pst = con.prepareStatement(s1);
	  					pst.setString(1,t );
	  					pst.setString(2,Abc.getEmail() );
	  					int y=pst.executeUpdate();
	  					if(y>0){
	  						response.sendRedirect("Candidatedashbord.jsp");
	  					}
	  					else{
	  						response.sendRedirect("Candidatedashbord.jsp");
	  					}
	  					
	  					
	  				 
	  			}catch (SQLException e) {
	  				// TODO Auto-generated catch block
	  				e.printStackTrace();
	  			}
	  			
	  		}
	  		}
		}
		}
		 catch (SQLException e) {
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
