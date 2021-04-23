package com.joepoccamel.camelmicroservicea.eip.routing;

import com.joepoccamel.camelmicroservicea.bean.HairProducts;
import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AggregatorSender extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:files/aggregator")
                .unmarshal().json(JsonLibrary.Jackson, HairProducts.class)
                .aggregate(simple("${body.brand}"), new AggregatorComponent())
                .completionSize(2)
                .marshal().json()
                .log("${body}")
                .to("activemq:joepoc-camel-activemq-aggregator");
    }
}

@Component
class AggregatorComponent implements AggregationStrategy {
    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        Object newBody = newExchange.getIn().getBody();
        ArrayList<Object> list = null;
        if (oldExchange == null) {
            list = new ArrayList<Object>();
            list.add(newBody);
            newExchange.getIn().setBody(list);
            return newExchange;
        } else {
            list = oldExchange.getIn().getBody(ArrayList.class);
            list.add(newBody);
            return oldExchange;
        }
    }
}