package com.joepoccamel.camelmicroservicea.eip.channel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class ActiveMqP2PSender extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:point2point-timer?period=2000&repeatCount=10")
                .transform().constant("P2P Message sent to ActiveMQ")
                .log("${body}")
                .to("activemq:joepoc-camel-activemq-p2p");
    }


}
