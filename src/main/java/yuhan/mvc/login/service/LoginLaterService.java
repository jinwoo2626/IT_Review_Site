package yuhan.mvc.login.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.mvc.teamproject.dao.LoginDao;
import yuhan.mvc.teamproject.dto.LoginDto;
import yuhan.mvc.teamproject.dto.UserInfo;

public class LoginLaterService implements iLoginService {

	
	public Boolean executeBoolean(Model model) {

        Map<String, Object>map=model.asMap();
        HttpServletRequest request = (HttpServletRequest) map.get("request");

        String user_id = request.getParameter("user_id");
        String user_pwd = request.getParameter("user_pwd");

        LoginDao dao = new LoginDao();

        LoginDto dto = dao.login(user_id);

        if(dto == null) {
            return false;
        }
        if(!user_pwd.equals( dto.getUser_pwd()))
        {
            return false;
        }
        model.addAttribute("loginlater", dto);
        return true;
    }
	public UserInfo GetUserInfo(Model model) {
        UserInfo userInfo = null;
        Map<String, Object>map=model.asMap();
        HttpServletRequest request = (HttpServletRequest) map.get("request");

        String user_id = request.getParameter("user_id");
        String user_pwd = request.getParameter("user_pwd");

        LoginDao dao = new LoginDao();

        LoginDto dto = dao.login(user_id);

        if(dto == null) {

            return null;
        }

        if(!user_pwd.equals(dto.getUser_pwd())) {

            return null;
        }
        userInfo = new UserInfo(dto.getUser_id(), dto.getUser_name(), dto.getUser_email(), dto.getUser_phone());

        model.addAttribute("loginlater", userInfo);
        return userInfo;
    }


}