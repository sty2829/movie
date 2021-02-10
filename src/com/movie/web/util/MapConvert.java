package com.movie.web.util;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class MapConvert {
	
	private static final String UPLOAD_PATH = "C:\\study\\workspace\\movies\\WebContent\\upload";
	
	public static String getCmd(String uri) {
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx+1);
		return uri;
	}

	public static Map<String,String> getMap(Map<String,String[]> paramMap){
		Map<String,String> param = new HashMap<>();
		Iterator<String> iterator = paramMap.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			String[] values = paramMap.get(key);
			String value = "";
			for(String val : values){
				value += val + ",";
			}
			value = value.substring(0,value.length()-1);
			param.put(key, value);
		}
		return param;
	}
	public static Map<String,String> getMapFromList(HttpServletRequest request){
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		List<FileItem> fileList;
		try {
			fileList = servletFileUpload.parseRequest(request);
			Map<String,String> param = new HashMap<>();
			for(FileItem fileItem : fileList ) {
				String key = fileItem.getFieldName();
				String value = "";
				if(fileItem.isFormField()) {
					value = fileItem.getString("UTF-8");
				}else {
					long size = fileItem.getSize();
					if(size != 0) { 
						value = fileItem.getName();
						int idx = value.lastIndexOf(".");
						if(idx==-1) {
							throw new ServletException("인식할 수 없는 확장자입니다.");
						}
						String ext = value.substring(idx);
						value += System.nanoTime() + ext;
 						File saveFile = new File(UPLOAD_PATH + File.separator + value);
						fileItem.write(saveFile);
					}
				}
				if(!"".equals(value)) {
					if(param.containsKey(key)) {
						value = param.get(key) + "," + value;
						param.put(key, value);
					}
					param.put(key, value);
				}
			}
			return param;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public static Map<String,String> getMap(HttpServletRequest request){
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart) {
			return getMapFromList(request);
		}else {
			return getMap(request.getParameterMap());
		}
	}
}
