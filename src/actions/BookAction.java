package actions;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import models.Book;
import models.BookModel;
import models.UserModel;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import common.Pcs;


public class BookAction extends ActionSupport 
							{
	private BookModel uploadForm = new BookModel();
//	private Map<String, Object>session;
	
    // ��װ�ϴ��ļ��������
    private File bookFile;
    // ��װ�ϴ��ļ����͵�����
    private String contentType;
    // ��װ�ϴ��ļ���������
    private String fileName;
    // ��������ע�������
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
	     String dataDir;
	     
	     Map<String, Object>fileInfo = new HashMap();
	     if(bookFile != null)
	     {
	     dataDir = svct.getRealPath("/");
	     System.out.println(dataDir);
	     File saveFile = new File(dataDir,fileName);
	     bookFile.renameTo(saveFile);
	     Pcs pcs = new Pcs();
	     	try {
	     		fileInfo = pcs.upload(dataDir, fileName);
	     	} catch (UnsupportedEncodingException e) {
	     		// TODO Auto-generated catch block
	     		e.printStackTrace();
	     	}
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
