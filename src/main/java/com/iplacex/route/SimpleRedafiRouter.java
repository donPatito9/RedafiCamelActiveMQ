package com.iplacex.route;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRedafiRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:C:/Entrada").split().tokenize("\n").to("direct:testExamen");

        from("direct:testExamen").
                choice().
                when(body().contains("Mensaje empresa Uno"))
                .to("jms:queue:EMPRESA1.QUEUE").
                when(body().contains("Mensaje empresa Dos"))
                .to("jms:queue:EMPRESA2.QUEUE")
                .when(body().contains("Mensaje empresa Tres"))
                .to("jms:queue:EMPRESA3.QUEUE")
                .when(body().contains("Mensaje empresa Cuatro"))
                .to("jms:queue:EMPRESA4.QUEUE")
                 .when(body().contains("Mensaje empresa Cinco"))
                .to("jms:queue:EMPRESA5.QUEUE").
                otherwise().
                to("jms:queue:otros");
    }
}
