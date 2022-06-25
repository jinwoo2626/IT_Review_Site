package yuhan.mvc.login.service;

import org.springframework.ui.Model;

import yuhan.mvc.teamproject.dto.UserInfo;

public interface iLoginService {

    public Boolean executeBoolean(Model model);
    public UserInfo GetUserInfo(Model model);
}