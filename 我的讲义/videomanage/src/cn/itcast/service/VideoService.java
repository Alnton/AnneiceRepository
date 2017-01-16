package cn.itcast.service;

import java.io.File;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import cn.itcast.utils.FormFile;
import cn.itcast.utils.SocketHttpRequester;

public class VideoService {
	
	/**
	 * 保存视频资讯及视频文件
	 * @param name 视频名称
	 * @param timelength 时长
	 * @return
	 * @throws Exception
	 */
	public static boolean saveVideo(String name, String timelength, File file) throws Exception{
		String path = "http://192.168.1.10:8080/videoweb/video/manage.do";
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", name);
		params.put("timelength", timelength);
		params.put("method", "save"); 
		FormFile formfile = new FormFile(file.getName(), file, "video", "application/octet-stream");
		return SocketHttpRequester.post(path, params, formfile);
	}
	/**
	 * 保存视频资讯
	 * @param name 视频名称
	 * @param timelength 时长
	 * @return
	 * @throws Exception
	 */
	public static boolean save(String name, String timelength) throws Exception{
		String path = "http://192.168.1.10:8080/videoweb/video/manage.do";
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", name);
		params.put("timelength", timelength);
		params.put("method", "save");
		return sendPostRequestHttpClient(path, params,"UTF-8");
	}
	/**
	 * 发出一个GET请求
	 * @param path 请求的路径，不带参数
	 * @param params 参数
	 * @return
	 * @throws Exception
	 */
	private static boolean sendGetRequest(String path, Map<String, String> params, String encoding) throws Exception{
		// http://192.168.1.10:8080/videoweb/video/manage.do?method=save&name=xxx&timelength=90
		StringBuilder pathBuilder = new StringBuilder(path);
		pathBuilder.append('?');
		for(Map.Entry<String, String> entry : params.entrySet()){
			pathBuilder.append(entry.getKey()).append('=')
			.append(URLEncoder.encode(entry.getValue(), encoding)).append('&');
		}
		pathBuilder.deleteCharAt(pathBuilder.length() - 1);
		URL url = new URL(pathBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(5*1000);
		if(conn.getResponseCode()==200){
			return true;
		}
		return false;
	}
	
	/**
	 * 发出一个POST请求
	 * @param path 请求的路径，不带参数
	 * @param params 参数
	 * @return
	 * @throws Exception
	 */
	private static boolean sendPostRequest(String path, Map<String, String> params, String encoding) throws Exception{
		// method=save&name=liming&timelength=78
		StringBuilder sb = new StringBuilder("");
		if(params!=null && !params.isEmpty()){
			for(Map.Entry<String, String> entry : params.entrySet()){
				sb.append(entry.getKey()).append('=')
				.append(URLEncoder.encode(entry.getValue(), encoding)).append('&');
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		byte[] data = sb.toString().getBytes();//得到实体数据
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("POST");
		conn.setConnectTimeout(5*1000);
		conn.setDoOutput(true);//能过post方式提交数据，必须要允许输出
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("Content-Length", String.valueOf(data.length));
		OutputStream outStream = conn.getOutputStream();
		outStream.write(data);
		outStream.flush();
		outStream.close();
		if(conn.getResponseCode()==200){
			return true;
		}
		return false;
	}
	// HTTPS SSL  COOKIE
	private static boolean sendPostRequestHttpClient(String path, Map<String, String> params, String encoding) throws Exception{
		List<NameValuePair> paramPairs = new ArrayList<NameValuePair>();
		if(params!=null && !params.isEmpty()){
			for(Map.Entry<String, String> entry : params.entrySet()){
				BasicNameValuePair param = new BasicNameValuePair(entry.getKey(), entry.getValue());
				paramPairs.add(param);
			}
		}
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramPairs, encoding);
		HttpPost post = new HttpPost(path);
		post.setEntity(entity);
		DefaultHttpClient client = new DefaultHttpClient();//浏览器
		HttpResponse response = client.execute(post);		
		if(response.getStatusLine().getStatusCode()==200){
			return true;
		}
		return false;
	}
}
