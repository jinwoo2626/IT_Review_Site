package yuhan.mvc.software.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.mvc.teamproject.dao.SoftWareDao;


public class SoftWareDeleteService implements iSoftWareService {

	@Override
	public void execute(Model model) {

		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request"); 
		
		String s_no = request.getParameter("s_no");
		
		SoftWareDao dao = new SoftWareDao();
		
		dao.delete(s_no);

	}

}
