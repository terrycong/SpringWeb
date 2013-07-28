package com.hsbc.test.web.action;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hsbc.test.web.domain.User;
import com.hsbc.test.web.domain.UserRegValidator;

@Controller
public class UserAction {
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new UserRegValidator());
	}

	@RequestMapping(value = "goCreateUser")
	public String goCreateUser(ModelAndView mav) {

		return "createUser";
	}

	@RequestMapping(value = "createUser")
	public ModelAndView createUser(@Valid User user, BindingResult result) {
		ModelAndView mav = new ModelAndView("helloWorld");
		if (result.hasErrors()) {
			mav.addObject("user",user);
		}
		System.out.println(user);
		System.out.println(result);
		return mav;
	}
}
