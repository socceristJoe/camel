package com.joepoccamel.camelmicroservicea.routes.transformer;

import com.joepoccamel.camelmicroservicea.bean.HairProducts;
import com.joepoccamel.camelmicroservicea.bean.HairProductsCore;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class ActiveMqFilterRouter extends RouteBuilder {

    @Autowired
    private HairProductsProcessor hairProductsProcessor;

    @Autowired
    private HairProductsFilter filter;

    @Override
    public void configure() throws Exception {
        from("file:files/json")
                .log("${body}")
                .to("activemq:joepoc-camel-activemq-json")
                .unmarshal()
                .json(JsonLibrary.Jackson, HairProducts.class)
                .bean(hairProductsProcessor)
                .bean(filter)
                .to("activemq:joepoc-camel-activemq-json-filtered")
                .to("log:filtered-message-from-active-mq");
    }
}

@Component
class HairProductsProcessor {
    Logger logger = LoggerFactory.getLogger(ActiveMqFilterRouter.class);

    public void processEnv(HairProducts hairProducts) {
        logger.info("This Hair Product name is {}", hairProducts.getSku());
    }
}

@Component
class HairProductsFilter {
    Logger logger = LoggerFactory.getLogger(ActiveMqFilterRouter.class);

    public HairProductsCore filter(HairProducts hairProducts) {
        HairProductsCore core = new HairProductsCore();
        core.setBrand(hairProducts.getBrand());
        core.setId(hairProducts.getId());
        core.setSku(hairProducts.getSku());
        return core;
    }
}


