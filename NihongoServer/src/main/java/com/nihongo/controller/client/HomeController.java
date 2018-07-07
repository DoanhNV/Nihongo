package com.nihongo.controller.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author DoanhNV
 * Jul 7, 2018 10:37:45 AM
 */
@RestController
public class HomeController {
	
	@RequestMapping(value = "/")
	public String loadRoot() {
		return "Nihongo";
	}
}
