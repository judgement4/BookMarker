package common;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class Pcs {
	
	private String url = "https://pcs.baidu.com/rest/2.0/pcs/file";
	
	private String token="23.602b4347dd6c5e1433702e668c14ffca.2592000.1441441319.891701231-1641135";
	
//	private Map<String, Object>fileInfo = new HashMap();
	private String respResult;
	
    protected static String buildParams(List<NameValuePair> urlParams){		
        String ret = null;		
        if(null != urlParams && urlParams.size() > 0){			
            try {
                // 指定HTTP.UTF_8为charset参数以保证中文文件路径的正确
                HttpEntity paramsEntity = new UrlEncodedFormEntity(urlParams, HTTP.UTF_8);
                ret = EntityUtils.toString(paramsEntity);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }		
        return ret;
    }
    
	public Map<String, Object> upload(String localPath, String fileName) throws UnsupportedEncodingException{
		
		Map<String, Object>fileInfo = new HashMap();
		
		File fileUpload = new File(localPath+fileName);
		String destPath = "/apps/wp2pcs/"+fileName;
		
		if(!(fileUpload).isFile()){
			System.out.println("no file");
			return null;
		}
		
		ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("method", "upload"));
		params.add(new BasicNameValuePair("access_token", token));
		params.add(new BasicNameValuePair("path", destPath));
		params.add(new BasicNameValuePair("ondup", "overwrite"));

		String postUrl = url+"?"+ buildParams(params);
		
		HttpPost put = new HttpPost(postUrl);
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		FileBody fileBody = new FileBody(fileUpload);
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		builder.addPart("upfile", fileBody);
		
		HttpEntity entity = builder.build();
		put.setEntity(entity);
        HttpClient client = new DefaultHttpClient();
		try {
			HttpResponse response = client.execute(put);
			System.out.println(response.getStatusLine().getStatusCode());
            this.respResult = EntityUtils.toString(response.getEntity());
            System.out.println(respResult);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//解析json数据有问题
		JSONObject json = JSONObject.fromObject(respResult);
		System.out.println("json:"+json);

		System.out.println("path:"+json.getString("path"));
		fileInfo.put("path", json.getString("path"));
		fileInfo.put("size", json.getString("size"));
		fileInfo.put("ctime",json.getString("ctime"));
		fileInfo.put("mtime", json.getString("mtime"));

		return fileInfo;
	}
}
