package com.joepoccamel.camelmicroservicea.routes.activemqsender;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.crypto.CryptoDataFormat;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

//@Component
public class ActiveMqSenderRouterJson extends RouteBuilder {

    @Override
    public void configure() throws Exception {
/*        {
            "dev":"AZ-RG-NA-GLB-EAI-Dev-01-APIM",
                "nonprod":"AZ-RG-NA-GLB-EAI-NonProd-01-APIM",
                "prod":"AZ-RG-NA-GLB-EAI-Prod-01-APIM"
        }*/

		from("file:files/json")
		.log("${body}")
		.to("activemq:joepoc-camel-activemq-json");

    }


}
