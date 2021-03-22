package com.joepoccamel.camelmicroserviceb.routes.ActiveMqReceiver;

import com.joepoccamel.camelmicroserviceb.HairProducts;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class AmqXmlReceiver extends RouteBuilder {
    @Override
    public void configure() throws Exception {

		from("activemq:joepoc-camel-activemq-xml")
		.unmarshal()
		.jacksonxml(HairProducts.class)
		.to("log:received-message-from-active-mq");
    }
}

