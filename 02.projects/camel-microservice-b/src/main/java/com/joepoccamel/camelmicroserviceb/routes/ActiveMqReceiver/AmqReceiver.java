package com.joepoccamel.camelmicroserviceb.routes.ActiveMqReceiver;

import com.joepoccamel.camelmicroserviceb.CurrencyExchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AmqReceiver extends RouteBuilder {

        @Override
        public void configure() throws Exception {
            from("activemq:joepoc-camel-activemq")
                    .to("log:received-message-from-active-mq");
        }
    }
