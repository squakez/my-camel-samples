package org.apache.camel.training.route;

import org.apache.camel.builder.RouteBuilder;

public class FileRouteBuilderV2 extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		from("file:orders/incoming/?include=order.*")
		.to("log:stdout?level=INFO")
		.to("file:orders/outgoing/?fileExist=fail");
	}
}
