package yuhan.mvc.teamproject.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import yuhan.mvc.teamproject.dao.BoardDao;
import yuhan.mvc.teamproject.dto.UserInfo;

public class BoardWriteService implements iBoardService  {

	@Override
	public void execute(Model model) {
		
		
		Map<String, Object>map=model.asMap();

		
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HttpSession session = request.getSession();
        UserInfo userinfo = (UserInfo)session.getAttribute("userInfo");
        String b_id = userinfo.getUser_id();

		String b_name = request.getParameter("b_name");
		String b_subject = request.getParameter("b_subject");
		String b_content = request.getParameter("b_content");

		
		if(b_name != null && b_name != "") {	
		
		BoardDao dao = new BoardDao();
		dao.write(b_name, b_subject, b_content, b_id); 
		
	}
	}

	@Override
	public boolean BooleanExecute(Model model) {
		
		return false;
	}

}
