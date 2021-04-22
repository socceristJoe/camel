package com.joepoccamel.camelmicroserviceb.eip;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class FileReceiver extends RouteBuilder {

    @Override
    public void configure() throws Exception {
//        from("activemq:joepoc-camel-activemq")
        from("activemq:joepoc-camel-activemq-json")
                .to("log:received-message-from-active-mq")
        .to("file:files/output")
        ;
    }
}
