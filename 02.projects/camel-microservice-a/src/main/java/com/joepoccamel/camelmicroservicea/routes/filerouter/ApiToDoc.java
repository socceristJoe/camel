package com.joepoccamel.camelmicroservicea.routes.filerouter;

import org.apache.camel.Body;
import org.apache.camel.ExchangeProperties;
import org.apache.camel.Headers;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ApiToDoc extends RouteBuilder{


	@Override
	public void configure() throws Exception {

		//Pipeline

		from("file:files/send")
		.convertBodyTo(String.class)
		.split(body().tokenize("\n"))

		.to("activemq:split-queue");
		



	}

}

