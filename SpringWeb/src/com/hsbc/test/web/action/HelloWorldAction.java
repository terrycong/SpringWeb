package com.hsbc.test.web.action;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.util.Locale;

import org.springframework.asm.commons.Method;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldAction {
	@RequestMapping("helloWorld")
	public String helloWorld(Model model) {
		model.addAttribute("message", "Common get Hello World!");
		return "helloWorld";
	}

	@RequestMapping(value = "postAction", method = RequestMethod.POST)
	public String postAction(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("message", "Post Hello World!");
		return "helloWorld";
	}

	@RequestMapping(value = "/owners/{ownerId}", method = RequestMethod.GET)
	public String viewOwners(Model model, @PathVariable String ownerId) {
		model.addAttribute("message", "get Owner Id:" + ownerId);
		return "helloWorld";
	}

	@RequestMapping("showInjections")
	public String showInjections(Model model, Locale locale,
			InputStream inputStream,Principal principal  ) {
		model.addAttribute("message", "Locale:" + locale + " <br>InputStream "
				+ inputStream 
				+ 
				" <br>principal " + principal
				);
		return "helloWorld";

	}
}
