package com.Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DataDao;
import com.POJO.Data;

/**
 * Servlet implementation class Save
 */
@WebServlet("/Save")
public class Save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Save() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
*/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("Text/Html");
		PrintWriter out=response.getWriter();  
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String contactno=request.getParameter("contactno");
		
		
		Data e=new Data();
		
		
			e.setFIRSTNAME(fname);	
			e.setLASTNAME(lname);
            e.setCONTACTNO(contactno);		
		
            
            int status=DataDao.save(e);  
            if(status>0){  
                out.print("<p>Record saved successfully!</p>");  
                request.getRequestDispatcher("StoreData.html").include(request, response);  
            }else{  
                out.println("Sorry! unable to save record");  
            }  
              
            out.close();  
        }  
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


