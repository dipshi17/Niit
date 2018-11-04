package form.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hospital
 */
@WebServlet("/insert")
public class Hospital extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Statement Statement;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	/**
	 * @see Servlet#destroy()
	 */
	public Hospital() {
		// TODO Auto-generated method stub
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //response.setContentType("text/html");
    
    //{
	//S	Driver d;
    	final String JDBC_DRIVER ="com.mysql.cj.jdbc.Driver";
    	final String DB_URL ="jdbc:mysql:@localhost/lbd";
    	final String USER ="root";
    	final String PASS ="root";
    	String name,id,phn;
    	
    	try {  Class.forName(JDBC_DRIVER);
    	System.out.println("Connected");
    	
    	     Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
    	
    	System.out.println("Loading...");
    	
    	name=request.getParameter("patientname");
    	id=request.getParameter("pid");
    	phn=request.getParameter("pnumber");
    	String que="insert into details(name,id,ph) values("+name+","+id+"," +phn+")";
    	PreparedStatement ps=con.prepareStatement(que);
    	ps.setString(1,name);
    	ps.setString(2,id);
    	ps.setString(3,phn);
    	ps.executeQuery();
    	System.out.println(que);
    	}
    	catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	    }
    	catch(SQLException e) {
    		e.printStackTrace();
    		
    	}
    	
    	
    	
    	
    }
		
	}


