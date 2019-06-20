package org.apache.camel.training.route;

import org.apache.camel.builder.RouteBuilder;

public class FileRouteBuilder extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		from("file:orders/incoming").to("file:orders/outgoing");
	}
}
