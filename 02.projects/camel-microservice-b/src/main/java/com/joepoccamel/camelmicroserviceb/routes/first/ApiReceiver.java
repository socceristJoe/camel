package com.joepoccamel.camelmicroserviceb.routes.first;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ApiReceiver extends RouteBuilder {

        @Override
        public void configure() throws Exception {
            from("activemq:joepoc-camel-activemq")
                    .to("http:www.baidu.com");
        }
    }
