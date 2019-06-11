package com.redhat.training;

import org.apache.camel.builder.RouteBuilder;

public class FileRouteBuilderV3 extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		from("file:orders/incoming/?include=order.*")
		.log("order content: ${body}")
		.log("order meta: ${headers}")
		.to("file:orders/outgoing/?fileExist=fail");
	}
}
