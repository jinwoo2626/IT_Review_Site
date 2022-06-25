package yuhan.mvc.teamproject.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import yuhan.mvc.teamproject.dao.BoardDao;
import yuhan.mvc.teamproject.dto.BoardDto;

public class BoardListService implements iBoardService {

	@Override
	public void execute(Model model) {
		

		
		BoardDao dao = new BoardDao();
		
		ArrayList<BoardDto>dtos = dao.list();
		model.addAttribute("list", dtos);
		
	}

	@Override
	public boolean BooleanExecute(Model model) {
		
		return false;
	}

}
