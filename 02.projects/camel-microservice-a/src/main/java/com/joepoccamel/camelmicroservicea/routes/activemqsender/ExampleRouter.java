package com.joepoccamel.camelmicroservicea.routes.activemqsender;

import org.apache.camel.builder.EndpointProducerBuilder;
import org.apache.camel.builder.RouteBuilder;

//@Component
public class ExampleRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		/*restConfiguration().host("localhost").port(8000);

		from("sftp:host:port/directoryName")
		.to("azure-storage-blob:/joepoc/camelcontainer" +
				"?blobName=joepoc&operation=uploadBlockBlob" +
				"&serviceClient=#client")
		.log("${body}");


		from("file:files/json")
				.to("activemq:joepoc-camel-activemq-json");*/


	/*	from("direct:start")
				.to("graphql://https://crm.pg.com.cn/graphql" +
						"?query={customer{id name}}");*/

		from("file:///home/camel/library")
				.to("salesforce:createSObject");

		
	}

}
