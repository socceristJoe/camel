package com.joepoccamel.camelmicroserviceb.eip.event;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqEventReceiver extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("activemq:joepoc-camel-activemq-event")
                .to("log:received-message-from-active-mq")
                .to("file:files/output");
    }
}
