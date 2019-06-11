package com.redhat.training;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ExchangePrinter implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		String fileTest = exchange.getIn().getBody(String.class);
		System.out.println("Processing... "+fileTest);
	}

}
