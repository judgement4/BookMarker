package actions;

import java.io.File;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import models.Book;
import models.BookModel;
import models.UserModel;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class BookAction extends ActionSupport 
							{
	private BookModel uploadForm = new BookModel();
//	private Map<String, Object>session;
	
    // 封装上传文件域的属性
    private File bookFile;
    // 封装上传文件类型的属性
    private String contentType;
    // 封装上传文件名的属性
    private String fileName;
    // 接受依赖注入的属性
    private String savePath;
	
    
    
	public File getBookFile() {
		return bookFile;
	}

	public void setBookFile(File bookFile) {
		this.bookFile = bookFile;
	}

	public String getContentType() {
		return contentType;
	}

	public void setBookFileContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setBookFileFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public BookAction(){
		System.out.println("enter the BookAction");
	}
	
	public BookModel getModel(){
		return uploadForm;
	}
	
/*	public void setSession(Map<String, Object>session) {
		// TODO Auto-generated method stub
		this.session = session;
	}*/
	
	
	public String execute(){
		
		 ServletContext svct = ServletActionContext.getServletContext();
	     System.out.println(fileName);
	     if(bookFile != null)
	     {
	     String dataDir = svct.getRealPath("/");
	     System.out.println(dataDir);
	     File saveFile = new File(dataDir,fileName);
	     bookFile.renameTo(saveFile);
	     }
	        return SUCCESS;
	}
	
	
	/*public String upload(BookModel uploadForm){
		
		int uid = 0;
		
		BookModel bookInfo = new BookModel();
		Book book = new Book();
		UserModel user = new UserModel();
		
		user = (UserModel)session.get("user");
		uid = user.getUid();
		book.upload(bookInfo, uid);
		System.out.println(fileName);
		
		return "success";
		
	}*/
}
