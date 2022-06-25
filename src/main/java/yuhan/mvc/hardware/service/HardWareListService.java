package yuhan.mvc.hardware.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.mvc.teamproject.dao.HardWareDao;
import yuhan.mvc.teamproject.dto.HardWareDto;


public class HardWareListService implements iHardWareService {

	@Override
	public void execute(Model model) {
		Map<String, Object>map=model.asMap();
        HttpServletRequest request = (HttpServletRequest) map.get("request");

        String category = request.getParameter("category");


        HardWareDao dao = new HardWareDao();

        ArrayList<HardWareDto>dtos = dao.list(category);
        model.addAttribute("HardWarelist", dtos);
	}
	

}
