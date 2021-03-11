package com.joepoccamel.camelmicroserviceb.routes.ActiveMqReceiver;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class AmqJsonToBeanTrans extends RouteBuilder {

    @Autowired
    private ApimEnvProcessor apimEnvProcessor;

    @Autowired
    private ApimEnvTransformer apimEnvTransformer;

    @Override
    public void configure() throws Exception {
        from("activemq:joepoc-camel-activemq-json")
                .unmarshal()
                .json(JsonLibrary.Jackson, ApimEnvBean.class)
                .bean(apimEnvProcessor)
                .bean(apimEnvTransformer)
                .to("log:received-message-from-active-mq");
    }
}

@Component
class ApimEnvProcessor {
    Logger logger = LoggerFactory.getLogger(AmqJsonToBeanTrans.class);
    public void processEnv(ApimEnvBean apimEnvBean) {
        logger.info("NonProd APIM resource name is {}", apimEnvBean.getNonprod());
    }
}

@Component
class ApimEnvTransformer {
    Logger logger = LoggerFactory.getLogger(AmqJsonToBeanTrans.class);
    public ApimEnvBean processEnv(ApimEnvBean apimEnvBean) {
        apimEnvBean.setNonprod("AZ-RG-NA-GLB-EAI-NonProd-02-APIM");
        return apimEnvBean;
    }
}

