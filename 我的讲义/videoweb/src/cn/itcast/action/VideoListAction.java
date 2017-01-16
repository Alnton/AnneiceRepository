package cn.itcast.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.itcast.domain.Video;
import cn.itcast.formbean.VideoForm;
import cn.itcast.service.VideoService;
import cn.itcast.service.impl.VideoServiceBean;

public class VideoListAction extends Action {
	private VideoService service = new VideoServiceBean();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		VideoForm formbean = (VideoForm)form;
		List<Video> videos = service.getLastVides();		
		if("json".equals(formbean.getFormat())){
		//[{id:32,title:"¿¦ÂóÂ¡VSºÉÀ¼",timelength:40},{id:32,title:"¿¦ÂóÂ¡VSºÉÀ¼",timelength:40}]
			StringBuilder json = new StringBuilder();
			json.append('[');
			for(Video video : videos){
				json.append('{');
				json.append("id:").append(video.getId()).append(',');
				json.append("title:\"").append(video.getTitle()).append("\",");
				json.append("timelength:").append(video.getTimelength());
				json.append('}');
				json.append(',');
			}
			json.deleteCharAt(json.length()-1);
			json.append(']');
			request.setAttribute("json", json);
			return mapping.findForward("json");
			
		}else{			
			request.setAttribute("videos", videos);
			return mapping.findForward("video");
		}
	}

}
