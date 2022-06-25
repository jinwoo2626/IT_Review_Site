package yuhan.mvc.teamproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import yuhan.mvc.hardware.service.HardWareContentService;
import yuhan.mvc.hardware.service.HardWareDeleteService;
import yuhan.mvc.hardware.service.HardWareListService;
import yuhan.mvc.hardware.service.HardWareModifyService;
import yuhan.mvc.hardware.service.HardWareWriteService;
import yuhan.mvc.hardware.service.iHardWareService;
import yuhan.mvc.login.service.DeleteLaterService;
import yuhan.mvc.login.service.HomeService;
import yuhan.mvc.login.service.JoinLaterService;
import yuhan.mvc.login.service.LoginLaterService;
import yuhan.mvc.login.service.UpdateBeforeService;
import yuhan.mvc.login.service.UpdateLaterService;
import yuhan.mvc.login.service.UserInfomationService;
import yuhan.mvc.login.service.iLoginService;
import yuhan.mvc.software.service.SoftWareContentService;
import yuhan.mvc.software.service.SoftWareDeleteService;
import yuhan.mvc.software.service.SoftWareListService;
import yuhan.mvc.software.service.SoftWareModifyService;
import yuhan.mvc.software.service.SoftWareWriteService;
import yuhan.mvc.software.service.iSoftWareService;
import yuhan.mvc.teamproject.dto.UserInfo;
import yuhan.mvc.teamproject.service.BoardContentService;
import yuhan.mvc.teamproject.service.BoardDeleteService;
import yuhan.mvc.teamproject.service.BoardListService;
import yuhan.mvc.teamproject.service.BoardModifyService;
import yuhan.mvc.teamproject.service.BoardWriteService;
import yuhan.mvc.teamproject.service.iBoardService;
import yuhan.mvc.util.ConstantTemplate;

@Controller
public class BoardController {
	
public JdbcTemplate template;
	
	iBoardService service;	
	iHardWareService h_service;
	iSoftWareService s_service;
	iLoginService i_service;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		ConstantTemplate.template = this.template;
	}
	
	@RequestMapping("/home")
    public String home(HttpServletRequest request, Model model) {
		
	     model.addAttribute("request", request);
	     i_service = new HomeService();
	     UserInfo userinfo= i_service.GetUserInfo(model);
	     if(i_service.GetUserInfo(model) != null) {
	         HttpSession session = request.getSession();
	         session.setAttribute("userInfo", userinfo);
	     }
	     return "home";
    }

	
	@RequestMapping("/join")
	public String join(HttpServletRequest request, Model model) {
		
		return "join";
	}	
	
	@RequestMapping(method= RequestMethod.POST, value ="/joinlater")
	public String joinlater(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		i_service = new JoinLaterService();	
		if(i_service.executeBoolean(model)) {
			return "redirect:home";
		}
		else {		
			return "redirect:join";
		}	
	}	
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		
		return "login";
	}	

	@RequestMapping("/loginlater")
    public String loginlater(HttpServletRequest request, Model model) {

        model.addAttribute("request", request);
        i_service = new LoginLaterService();
        UserInfo userinfo= i_service.GetUserInfo(model);
        if(i_service.GetUserInfo(model) != null) {
            HttpSession session = request.getSession();
            session.setAttribute("userInfo", userinfo);
            return "redirect:home";
        }
        else {
        	return "redirect:login";
        }
    }
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
        session.removeAttribute("userInfo");
        
		return "redirect:home";
	}
	
	@RequestMapping("/userinfomation")
	public String userinfomation(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		i_service = new UserInfomationService();
		i_service.executeBoolean(model);
		
		return "userinfomation";
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		i_service = new UpdateBeforeService();
		i_service.executeBoolean(model);
		
		return "update";
	}
	
	@RequestMapping(method= RequestMethod.POST, value ="/updatelater")
	public String updatelater(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
        model.addAttribute("request", request);
        i_service = new UpdateLaterService();
        UserInfo userinfo = i_service.GetUserInfo(model);
        session.setAttribute("userInfo", userinfo);
        
        return "redirect:home";
	}
	
	@RequestMapping("/userdelete")
	public String userdelete(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		i_service = new DeleteLaterService();
		i_service.executeBoolean(model);
		HttpSession session = request.getSession();
        session.removeAttribute("userInfo");
        
		return "redirect:home";
	}
	@RequestMapping("/list")
	public String list(Model model) {
		
		service = new BoardListService();
		service.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(HttpServletRequest request, Model model) {
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);		
		service = new BoardWriteService();
		service.execute(model);
		
		return "redirect:list";	
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
				
		 model.addAttribute("request", request);
	       service = new BoardContentService();
	        if(service.BooleanExecute(model)) {
	            return "content_view2";
	        }
	        return "content_view";
	}
	
	@RequestMapping("/content_modify")
	public String content_modify(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		service = new BoardContentService();		
	    service.execute(model);		
		
		return "content_modify";		
	}
	
	@RequestMapping(method= RequestMethod.POST, value ="/modify")
	public String modify(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		service = new BoardModifyService();
		service.execute(model);
		
		return "redirect:list";		
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {	
		
		model.addAttribute("request", request);
		service = new BoardDeleteService();
		service.execute(model);
		
		return "redirect:list";		
	}
	
	@RequestMapping(method= RequestMethod.GET, value ="/HardWarelist")
    public String list2(HttpServletRequest request, Model model) {

        model.addAttribute("request", request);
        h_service = new HardWareListService();
        h_service.execute(model);

        return "HardWarelist";
    }
	
	@RequestMapping("/HardWarewrite_view")
	public String write_view2(HttpServletRequest request, Model model) {
		
		return "HardWarewrite_view";
	}
	
	@RequestMapping("/HardWarewrite")
	public String write2(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);		
		h_service = new HardWareWriteService();	
		h_service.execute(model);
		
		return "redirect:HardWarelist";	
	}
	
	@RequestMapping("/HardWarecontent_view")
	public String content_view2(HttpServletRequest request, Model model) {
		
        model.addAttribute("request", request);
        HardWareContentService h_service = new HardWareContentService();
        if(!h_service.BooleanExecute(model)) {
            return "HardWarecontent_view2";
        }
        return "HardWarecontent_view";		
	}
	
	@RequestMapping("/HardWarecontent_modify")
	public String content_modify2(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		h_service = new HardWareContentService();		
		h_service.execute(model);		
		
		return "HardWarecontent_modify";	
	}
	
	@RequestMapping(method= RequestMethod.POST, value ="/HardWaremodify")
	public String modify2(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		h_service = new HardWareModifyService();
		h_service.execute(model);
		
		return "redirect:HardWarelist";
	}
	
	@RequestMapping("/HardWaredelete")
	public String delete2(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		h_service = new HardWareDeleteService();
		h_service.execute(model);
		
		return "redirect:HardWarelist";	
	}
	
	@RequestMapping(method= RequestMethod.GET, value ="/SoftWarelist")
    public String list3(HttpServletRequest request, Model model) {

        model.addAttribute("request", request);
        s_service = new SoftWareListService();
        s_service.execute(model);

        return "SoftWarelist";
    }
	
	@RequestMapping("/SoftWarewrite_view")
	public String write_view3(HttpServletRequest request, Model model) {
		
		return "SoftWarewrite_view";
	}
	
	@RequestMapping("/SoftWarewrite")
	public String write3(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);		
		s_service = new SoftWareWriteService();	
		s_service.execute(model);
		
		return "redirect:SoftWarelist";	
	}
	
	@RequestMapping("/SoftWarecontent_view")
	public String content_view3(HttpServletRequest request, Model model) {
				
		 model.addAttribute("request", request);
	     SoftWareContentService s_service = new SoftWareContentService();
	     if(!s_service.BooleanExecute(model)) {
	         return "SoftWarecontent_view2";
	     }
	        return "SoftWarecontent_view";	
	}
	
	@RequestMapping("/SoftWarecontent_modify")
	public String content_modify3(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		s_service = new SoftWareContentService();		
		s_service.execute(model);		
		
		return "SoftWarecontent_modify";		
	}
	
	@RequestMapping(method= RequestMethod.POST, value ="/SoftWaremodify")
	public String modify3(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		s_service = new SoftWareModifyService();
		s_service.execute(model);
		
		return "redirect:SoftWarelist";		
	}
	
	@RequestMapping("/SoftWaredelete")
	public String delete3(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		s_service = new SoftWareDeleteService();
		s_service.execute(model);
		
		return "redirect:SoftWarelist";		
	}
}
