package yuhan.mvc.teamproject.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.mvc.teamproject.dao.BoardDao;
import yuhan.mvc.teamproject.dto.BoardDto;

public class BoardDeleteService implements iBoardService {

	@Override
	public void execute(Model model) {
		

		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request"); 
		
		String b_no = request.getParameter("b_no");
		
		BoardDao dao = new BoardDao();
		
		dao.delete(b_no);
		
		
	}

	@Override
	public boolean BooleanExecute(Model model) {
		
		return false;
	}

}
