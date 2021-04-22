package com.joepoccamel.camelmicroservicea.eip.endpoint;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqFileSender extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("file:files/send")
//        from("file:files/send?include=.*.json")
                .log("${body}")
                .to("activemq:joepoc-camel-activemq-selector");

    }


}
