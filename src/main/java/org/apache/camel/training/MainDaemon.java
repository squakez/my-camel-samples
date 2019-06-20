package org.apache.camel.training;

public class MainDaemon {

    public static void main(String[] args) throws Exception {
        org.apache.camel.spring.Main main = new org.apache.camel.spring.Main();
        main.setApplicationContextUri("META-INF/spring/camel-context.xml");
        main.run();
    }

}
