package yuhan.mvc.software.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import yuhan.mvc.teamproject.dao.SoftWareDao;
import yuhan.mvc.teamproject.dto.UserInfo;

public class SoftWareModifyService implements iSoftWareService {

	@Override
	public void execute(Model model) {

		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		
		String s_no = request.getParameter("s_no");
		String s_subject = request.getParameter("s_subject");
		String s_name = request.getParameter("s_name");
		String s_code = request.getParameter("s_code");
		String s_content = request.getParameter("s_content");
		String s_price = request.getParameter("s_price");
		String s_score = request.getParameter("s_score");
		
		SoftWareDao dao = new SoftWareDao();
		
		dao.modify(s_no, s_subject, s_name, s_code, s_content, s_price, s_score);

	}

}
