package yuhan.mvc.login.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import yuhan.mvc.teamproject.dao.LoginDao;
import yuhan.mvc.teamproject.dto.LoginDto;
import yuhan.mvc.teamproject.dto.UserInfo;

public class UpdateBeforeService implements iLoginService {

	@Override
	public Boolean executeBoolean(Model model) {
		
		Map<String, Object>map=model.asMap();
		
		HttpServletRequest request = (HttpServletRequest) map.get("request");
				
		//String user_id = request.getParameter("user_id");
		HttpSession session = request.getSession();
        UserInfo userinfo = (UserInfo)session.getAttribute("userInfo");
        String user_id = userinfo.getUser_id();		
		
		LoginDao dao = new LoginDao();
		LoginDto dto = dao.userinfomation(user_id);
		
		model.addAttribute("updatebeforeservice", dto);
		
		return null;
	}

	@Override
	public UserInfo GetUserInfo(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

}
