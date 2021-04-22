package com.joepoccamel.camelmicroservicea.eip.event;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class ActiveMqEventSender extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("file:files/send")
                .log("${body}")
                .to("activemq:joepoc-camel-activemq-event")
                .transform().constant("Event Notification for Receiver")
                .log("${body}")
                .to("activemq:joepoc-camel-activemq-notification");
    }


}
