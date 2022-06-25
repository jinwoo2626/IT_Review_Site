package yuhan.mvc.login.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import yuhan.mvc.teamproject.dao.LoginDao;
import yuhan.mvc.teamproject.dto.LoginDto;
import yuhan.mvc.teamproject.dto.UserInfo;

public class UpdateLaterService implements iLoginService {

	@Override
	public Boolean executeBoolean(Model model) {

		return null;
	}

	@Override
	public UserInfo GetUserInfo(Model model) {
		
		Map<String, Object>map=model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HttpSession session = request.getSession();
        UserInfo userinfo = (UserInfo)session.getAttribute("userInfo");
        String user_id = userinfo.getUser_id();
		
	//	String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		String user_name = request.getParameter("user_name");
		String user_email = request.getParameter("user_email");
		String user_phone = request.getParameter("user_phone");
	 
		LoginDao dao = new LoginDao();
		LoginDto dto = dao.update(user_id, user_pwd, user_name, user_email, user_phone);
		
		
		UserInfo userInfo = new UserInfo(dto.getUser_id(), dto.getUser_name(), dto.getUser_email(), dto.getUser_phone());
		
		model.addAttribute("userinfomation",dto);
		
		return userinfo;
	}

}
