package com.joepoccamel.camelmicroserviceb.eip.selector;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqSelectiveReceiver extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("activemq:joepoc-camel-activemq-selector?selector=CamelFileName Like '%.json'")
                .to("log:received-message-from-active-mq")
                .to("file:files/output");
    }
}
