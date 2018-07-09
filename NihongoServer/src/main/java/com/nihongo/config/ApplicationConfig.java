package com.nihongo.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfig  implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>  {

	@Override
	public void customize(ConfigurableServletWebServerFactory factory) {
		factory.setPort(8282);
		InetAddress address = null;
		try {
			address = InetAddress.getByName("0.0.0.0");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		factory.setAddress(address);
	}

}