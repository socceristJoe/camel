package com.joepoccamel.camelmicroserviceb.routes.ActiveMqReceiver;

import com.joepoccamel.camelmicroserviceb.HairProducts;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

//@Component
public class AmqJsonToBean extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("activemq:joepoc-camel-activemq-json")
                .unmarshal()
                .json(JsonLibrary.Jackson, HairProducts.class)
                .to("log:received-message-from-active-mq");

    }
}

