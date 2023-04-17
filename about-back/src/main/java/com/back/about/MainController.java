package com.back.about;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@ResponseBody
	@RequestMapping(value = {"/", "/main.do", ""})
	public String main() {

		return "Main Page";
	}

}
