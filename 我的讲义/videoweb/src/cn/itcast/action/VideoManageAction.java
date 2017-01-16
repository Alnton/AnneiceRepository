package cn.itcast.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.itcast.formbean.VideoForm;
import cn.itcast.utils.StreamTool;

public class VideoManageAction extends DispatchAction {

	public ActionForward getSMS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		VideoForm formbean = (VideoForm)form;
		System.out.println("发送时间："+ formbean.getTime());
		System.out.println("谁给她发的短信："+ formbean.getSender());
		System.out.println("内容："+ formbean.getContent());
		return mapping.findForward("result");
	}
	
	public ActionForward getXML(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		InputStream inStream = request.getInputStream();
		byte[] data = StreamTool.readInputStream(inStream);
		String xml = new String(data, "UTF-8");
		System.out.println(xml);
		return mapping.findForward("result");
	}
	
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		VideoForm formbean = (VideoForm)form;
		if("GET".equals(request.getMethod())){
			String name = new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
			System.out.println("视频名称: "+ name);
			System.out.println("时长: "+formbean.getTimelength());
		}else{
			System.out.println("视频名称: "+formbean.getName());
			System.out.println("时长: "+formbean.getTimelength());
		}
		if(formbean.getVideo()!=null && formbean.getVideo().getFileSize()>0){
			String realpath = request.getSession().getServletContext().getRealPath("/video");
			System.out.println(realpath);
			File dir = new File(realpath);
			if(!dir.exists()) dir.mkdirs();
			File saveFile = new File(dir, formbean.getVideo().getFileName());
			FileOutputStream outStream = new FileOutputStream(saveFile);
			outStream.write(formbean.getVideo().getFileData());
			outStream.close();
		}
		return mapping.findForward("result");
	}
	
}
