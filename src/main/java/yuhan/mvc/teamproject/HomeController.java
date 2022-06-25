package yuhan.mvc.teamproject;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yuhan.mvc.login.service.HomeService;
import yuhan.mvc.login.service.iLoginService;
import yuhan.mvc.teamproject.dao.BoardDao;
import yuhan.mvc.teamproject.dao.HardWareDao;
import yuhan.mvc.teamproject.dao.SoftWareDao;
import yuhan.mvc.teamproject.dto.BoardDto;
import yuhan.mvc.teamproject.dto.HardWareDto;
import yuhan.mvc.teamproject.dto.SoftWareDto;
import yuhan.mvc.teamproject.dto.UserInfo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		 HardWareDao hardDao = new HardWareDao();
	        SoftWareDao softDao = new SoftWareDao();
	        BoardDao boardDao = new BoardDao();
	        
	        ArrayList<SoftWareDto>softDtos = softDao.list("");        
	        ArrayList<HardWareDto>hardDtos = hardDao.list("");
	        ArrayList<BoardDto>boardDtos = boardDao.list();
	        
	        model.addAttribute("HardWarelist", hardDtos);
	        model.addAttribute("SoftWarelist", softDtos);
	        model.addAttribute("Boardlist", boardDtos);
		
		
		
		return "home";
	}
	
	
}
