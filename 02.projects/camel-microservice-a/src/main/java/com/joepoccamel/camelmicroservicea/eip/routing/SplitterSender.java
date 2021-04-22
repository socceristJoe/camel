package com.joepoccamel.camelmicroservicea.eip.routing;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class SplitterSender extends RouteBuilder {

    @Autowired
    SplitterComponent splitter;

    @Override
    public void configure() throws Exception {
        from("file:files/send")
                .convertBodyTo(String.class)
                .split(method(splitter))
                .log("${body}")
                .to("activemq:joepoc-camel-activemq-splitter");
    }
}

@Component
class SplitterComponent {
    public List<String> split(String body) {
        String[] output = body.split(",");
        List<String> list = new ArrayList<>(output.length);
        Collections.addAll(list, output);
        return list;
    }
}


