package com.redhat.training;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelStandalone {

	public static void main(String[] args)throws Exception{
        // create a new CamelContext
        CamelContext camelContext = new DefaultCamelContext();

        // add routes to Camel
        camelContext.addRoutes(new FileRouteBuilderV4());

        // start Camel
        camelContext.start();

        // just run for 10 seconds and stop
        System.out.println("Running as standalone application. Terminate with CTRL+C.");
        //Thread.sleep(10000);

        // stop and shutdown Camel
        //camelContext.stop();
	}

}
