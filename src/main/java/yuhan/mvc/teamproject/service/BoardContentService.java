package yuhan.mvc.teamproject.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import yuhan.mvc.teamproject.dao.BoardDao;
import yuhan.mvc.teamproject.dao.SoftWareDao;
import yuhan.mvc.teamproject.dto.BoardDto;
import yuhan.mvc.teamproject.dto.SoftWareDto;
import yuhan.mvc.teamproject.dto.UserInfo;

public class BoardContentService implements iBoardService {

	@Override
	public void execute(Model model) {
		
		Map<String, Object>map=model.asMap();

		
		HttpServletRequest request = (HttpServletRequest) map.get("request");
			

		String b_no = request.getParameter("b_no");
		
		BoardDao dao = new BoardDao();

		BoardDto dto = dao.contentView(b_no);
		
		model.addAttribute("content_view", dto);
		
	}
	
	public boolean BooleanExecute(Model model) {

        Map<String, Object>map=model.asMap();

        HttpServletRequest request = (HttpServletRequest) map.get("request");

        String b_no = request.getParameter("b_no");

        HttpSession session = request.getSession();
        UserInfo userInfo =  (UserInfo)session.getAttribute("userInfo");
        BoardDao dao = new BoardDao(); 

        BoardDto dto = dao.contentView(b_no);
        System.out.println(userInfo.getUser_id());
        System.out.println(dto.getB_id());
        if(userInfo.getUser_id().equals(dto.getB_id())) {
        	System.out.println(userInfo.getUser_id());
            System.out.println(dto.getB_id());
        	model.addAttribute("content_view", dto);
            return true;
        }



        model.addAttribute("content_view", dto);
        return false;
    }
	

	
}
