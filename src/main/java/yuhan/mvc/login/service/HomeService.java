package yuhan.mvc.login.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import yuhan.mvc.teamproject.dao.BoardDao;
import yuhan.mvc.teamproject.dao.HardWareDao;
import yuhan.mvc.teamproject.dao.LoginDao;
import yuhan.mvc.teamproject.dao.SoftWareDao;
import yuhan.mvc.teamproject.dto.BoardDto;
import yuhan.mvc.teamproject.dto.HardWareDto;
import yuhan.mvc.teamproject.dto.LoginDto;
import yuhan.mvc.teamproject.dto.SoftWareDto;
import yuhan.mvc.teamproject.dto.UserInfo;

public class HomeService implements iLoginService {

	@Override
	public Boolean executeBoolean(Model model) {
		
		return null;
	}

	@Override
	public UserInfo GetUserInfo(Model model) {
		Map<String, Object>map=model.asMap();
        HttpServletRequest request = (HttpServletRequest) map.get("request");

        HttpSession session = request.getSession();

        UserInfo userInfo= (UserInfo) session.getAttribute("userInfo");
        
        HardWareDao hardDao = new HardWareDao();
        SoftWareDao softDao = new SoftWareDao();
        BoardDao boardDao = new BoardDao();
        
        ArrayList<SoftWareDto>softDtos = softDao.list("");        
        ArrayList<HardWareDto>hardDtos = hardDao.list("");
        ArrayList<BoardDto>boardDtos = boardDao.list();
        
        model.addAttribute("HardWarelist", hardDtos);
        model.addAttribute("SoftWarelist", softDtos);
        model.addAttribute("Boardlist", boardDtos);
        
        if(userInfo  != null) {
            LoginDao dao = new LoginDao();
            LoginDto dto = dao.userinfomation(userInfo.getUser_id());          
            return userInfo;
        }
        return null;
	}

}
