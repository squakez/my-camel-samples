package org.apache.camel.training;

import javax.sql.DataSource;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.spi.Registry;
import org.apache.camel.training.route.FileToSql;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class FileToSqlMain {

	public static void main(String[] args)throws Exception{
	    DataSource db = new EmbeddedDatabaseBuilder()
	            .setType(EmbeddedDatabaseType.DERBY).addScript("sql/createAndPopulateDatabase.sql").build();
	    // create a new CamelContext
	    SimpleRegistry registry = new SimpleRegistry();
	    registry.put("myDS", db);
        CamelContext camelContext = new DefaultCamelContext(registry);
        
        // add routes to Camel
        camelContext.addRoutes(new FileToSql());

        // start Camel
        camelContext.start();

        // just run for 10 seconds and stop
        System.out.println("Running as standalone application. Terminate with CTRL+C.");
        Thread.sleep(2000);

        // stop and shutdown Camel
        camelContext.stop();
	}
}
