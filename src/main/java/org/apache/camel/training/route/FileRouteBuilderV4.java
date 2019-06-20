package org.apache.camel.training.route;

import org.apache.camel.builder.RouteBuilder;

public class FileRouteBuilderV4 extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		from("file:orders/incoming/?include=order.*")
		.log("order content: ${body}")
		.process(new ExchangePrinter())
		.to("file:orders/outgoing/?fileExist=fail");
	}
}
