package maventest.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/download.do")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String filePath = getServletContext().getInitParameter("uploadPath");
		String fileName = (String)request.getParameter("fname");
		//Open stream for binary (file is not string)
		OutputStream out = response.getOutputStream();
		File sendFile = new File(filePath+File.separator+fileName);
		//add file data in header
		response.setHeader("Cache-Control", "no-cache"); // Chu y viet dung quy uoc
		response.addHeader("Content-disposition", "attachment; fileName= " + fileName);
		//to ready by browser
		//read file from Disk
		FileInputStream in = new FileInputStream(sendFile);
		byte[] buffer  = new byte[1024*8];//byte stream is binnary
		while (true) {
			int count = in.read(buffer);
			//count is bytes from file
			if (count == -1) { //end of file
				break;
			}
			out.write(buffer , 0 , count);//send to client
		}
		in.close();
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


























