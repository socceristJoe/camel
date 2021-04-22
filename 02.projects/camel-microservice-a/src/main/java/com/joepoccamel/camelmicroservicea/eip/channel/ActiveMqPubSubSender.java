package com.joepoccamel.camelmicroservicea.eip.channel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqPubSubSender extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:files/send")
                .log("${body}")
                .multicast()
                .to("activemq:joepoc-camel-activemq-pubsub01").log("File sent to Queue:joepoc-camel-activemq-pubsub01")
                .to("activemq:joepoc-camel-activemq-pubsub02").log("File sent to Queue:joepoc-camel-activemq-pubsub02")
                .to("activemq:joepoc-camel-activemq-pubsub03").log("File sent to Queue:joepoc-camel-activemq-pubsub03")
                .end();
    }


}
