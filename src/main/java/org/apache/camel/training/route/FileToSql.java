package org.apache.camel.training.route;

import org.apache.camel.Exchange;
import org.apache.camel.Expression;
import org.apache.camel.builder.RouteBuilder;

public class FileToSql extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		from("file:orders/incoming/")
		.log("order content: ${body}")
		.transform(new Expression() {

            @Override
            public <T> T evaluate(Exchange exchange, Class<T> type) {
                String body = exchange.getIn().getBody(String.class);
                return (T) body;
            }
		    
		})
		.to("sql:select * from projects where license = #?dataSource=myDS")
	    .log("query content: ${body}");
	}
}
