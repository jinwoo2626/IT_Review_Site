package yuhan.mvc.software.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import yuhan.mvc.teamproject.dao.SoftWareDao;
import yuhan.mvc.teamproject.dto.SoftWareDto;
import yuhan.mvc.teamproject.dto.UserInfo;

public class SoftWareContentService implements iSoftWareService {

	@Override
	public void execute(Model model) {
		
		Map<String, Object>map=model.asMap();
		
		HttpServletRequest request = (HttpServletRequest) map.get("request");
			
		String s_no = request.getParameter("s_no");
		
		SoftWareDao dao = new SoftWareDao(); 
		
		SoftWareDto dto = dao.contentView(s_no);
		
		model.addAttribute("SoftWarecontent_view", dto);
	}
	
	public Boolean BooleanExecute(Model model) {

        Map<String, Object>map=model.asMap();

        HttpServletRequest request = (HttpServletRequest) map.get("request");

        String s_no = request.getParameter("s_no");

        HttpSession session = request.getSession();
        UserInfo userInfo =  (UserInfo)session.getAttribute("userInfo");
        SoftWareDao dao = new SoftWareDao(); 

        SoftWareDto dto = dao.contentView(s_no);
        if(userInfo.getUser_id().equals(dto.getS_id())) {
        	model.addAttribute("SoftWarecontent_view", dto);
            return true;
        }



        model.addAttribute("SoftWarecontent_view", dto);
        return false;
    }

}
