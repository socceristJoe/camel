package com.joepoccamel.camelmicroserviceb.routes.ActiveMqReceiver;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

//@Component
public class AmqXmlToBean extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("activemq:joepoc-camel-activemq-json")

                .unmarshal()
                .json(JsonLibrary.Jackson, ApimEnvBean.class)
                .to("log:received-message-from-active-mq");

//		from("activemq:my-activemq-xml-queue")
//		.unmarshal()
//		.jacksonxml(CurrencyExchange.class)
//		.to("log:received-message-from-active-mq");

//		from("activemq:split-queue")
//		.to("log:received-message-from-active-mq");

    }
}

