package com.joepoccamel.camelmicroservicea.routes.activemqsender;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.crypto.CryptoDataFormat;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

//@Component
public class ActiveMqSenderRouterXml extends RouteBuilder {

    @Override
    public void configure() throws Exception {
		from("file:files/xml")
		.log("${body}")
		.to("activemq:joepoc-camel-activemq-xml");
    }
}
