package yuhan.mvc.software.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.mvc.teamproject.dao.SoftWareDao;
import yuhan.mvc.teamproject.dto.SoftWareDto;


public class SoftWareListService implements iSoftWareService {

	@Override
	public void execute(Model model) {
		Map<String, Object>map=model.asMap();
        HttpServletRequest request = (HttpServletRequest) map.get("request");

        String category = request.getParameter("category");


        SoftWareDao dao = new SoftWareDao();

        ArrayList<SoftWareDto>dtos = dao.list(category);
        model.addAttribute("SoftWarelist", dtos);
	}

}
