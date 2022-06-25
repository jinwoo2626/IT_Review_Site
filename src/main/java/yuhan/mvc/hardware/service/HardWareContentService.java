package yuhan.mvc.hardware.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import yuhan.mvc.teamproject.dao.HardWareDao;
import yuhan.mvc.teamproject.dto.HardWareDto;
import yuhan.mvc.teamproject.dto.UserInfo;

public class HardWareContentService implements iHardWareService {

	@Override
	public void execute(Model model) {
		
		Map<String, Object>map=model.asMap();
		
		HttpServletRequest request = (HttpServletRequest) map.get("request");
			
		String h_no = request.getParameter("h_no");
		
		HardWareDao dao = new HardWareDao(); 
		
		HardWareDto dto = dao.contentView(h_no);
		
		model.addAttribute("HardWarecontent_view", dto);
	}
	
	public Boolean BooleanExecute(Model model) {

        Map<String, Object>map=model.asMap();

        HttpServletRequest request = (HttpServletRequest) map.get("request");

        String h_no = request.getParameter("h_no");

        HttpSession session = request.getSession();
        UserInfo userInfo =  (UserInfo)session.getAttribute("userInfo");
        HardWareDao dao = new HardWareDao(); 

        HardWareDto dto = dao.contentView(h_no);
        if(userInfo.getUser_id().equals(dto.getH_id())) {
        	model.addAttribute("HardWarecontent_view", dto);
            return true;
        }



        model.addAttribute("HardWarecontent_view", dto);
        return false;
    }

}
