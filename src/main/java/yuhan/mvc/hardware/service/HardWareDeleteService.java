package yuhan.mvc.hardware.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.mvc.teamproject.dao.HardWareDao;


public class HardWareDeleteService implements iHardWareService {

	@Override
	public void execute(Model model) {

		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request"); 
		
		String h_no = request.getParameter("h_no");
		
		HardWareDao dao = new HardWareDao();
		
		dao.delete(h_no);

	}

}
