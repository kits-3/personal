package maventest.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message", "common");
		String prefix = getServletContext().getInitParameter("prefix");
		String postfix = getServletContext().getInitParameter("postfix");
		String viewName = prefix + "/upload" + postfix;
		request.getRequestDispatcher(viewName).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadPath  = getServletContext().getInitParameter("uploadPath");
		File uploadFilePath = new File(uploadPath);//is directory
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(uploadFilePath);
		factory.setSizeThreshold(1024*1024);//max size each file (1MB)
		ServletFileUpload upload = new ServletFileUpload(factory);
		//use Servletfileupload class when file upload
		try {
			List<FileItem> items = upload.parseRequest(request); //Form data 
			for(int i = 0 ; i < items.size();++i){
				FileItem fileItem = (FileItem) items.get(i); //array file item
				if(fileItem.isFormField()) {
					// not type = "file" , so do not save       
					System.out.println(fileItem.getFieldName()+"="+fileItem.getName());
				}else {
					System.out.println("name: "+ fileItem.getFieldName());
					System.out.println("fname: "+ fileItem.getName());
					System.out.println("Size: "+ fileItem.getSize());
					if(fileItem.getSize() >0) { //String.isEmpty
						int idx = fileItem.getName().lastIndexOf(File.separator); // /a/b/d/mage.jpg  String.split
						String fileName = fileItem.getName().substring(idx+1);
						System.out.print(uploadPath);
						File uploadFile = new File(uploadFilePath+File.separator+fileName);
						fileItem.write(uploadFile);//save file
					}//end inner if
				}//end outer if	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





























