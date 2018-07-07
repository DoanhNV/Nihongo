package com.nihongo.controller.backend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author DoanhNV
 * Jul 7, 2018 10:33:20 AM
 */
@RestController
public class HomeController {
	
	@RequestMapping(value = "/")
	public String loadRoot() {
		return "Nihongo";
	}
}
