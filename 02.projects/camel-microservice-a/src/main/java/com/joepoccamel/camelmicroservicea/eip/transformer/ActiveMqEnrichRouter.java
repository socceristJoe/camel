package com.joepoccamel.camelmicroservicea.eip.transformer;

import com.joepoccamel.camelmicroservicea.bean.HairProducts;
import com.joepoccamel.camelmicroservicea.bean.HairProductsExtension;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqEnrichRouter extends RouteBuilder {

    @Autowired
    private HairProductsProcessor hairProductsProcessor;

    @Autowired
    private HairProductsEnricher enricher;

    @Override
    public void configure() throws Exception {
        from("file:files/json")
                .log("${body}")
                .to("activemq:joepoc-camel-activemq-json?selector=bu='hairs'")
                .unmarshal()
                .json(JsonLibrary.Jackson, HairProducts.class)
                .bean(hairProductsProcessor)
                .bean(enricher)
                .to("activemq:joepoc-camel-activemq-json-enriched")
                .to("log:filtered-message-from-active-mq");
    }
}

@Component
class HairProductsEnricher {
    Logger logger = LoggerFactory.getLogger(ActiveMqFilterRouter.class);

    public HairProductsExtension enricher(HairProducts hairProducts) {
        HairProductsExtension extension = new HairProductsExtension();
        extension.setSku(hairProducts.getSku());
        extension.setBrand(hairProducts.getBrand());
        extension.setId(hairProducts.getId());
        extension.setDiscount(hairProducts.getDiscount());
        extension.setPrice(hairProducts.getPrice());

        //enrich
        if (extension.getBrand().equals("Pantene")) {
            extension.setTier("Premium");
            extension.setChannel("Walmart");
        } else {
            extension.setTier("Medium");
            extension.setChannel("Amazon");
        }

        return extension;
    }
}


