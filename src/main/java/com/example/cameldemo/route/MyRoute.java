package com.example.cameldemo.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

/**
 * ClassName: MyRoute <br/>
 * Description: <br/>
 * date: 2021/11/22 10:24 上午<br/>
 *
 * @author tooru<br />DefaultMyService
 */
@Component
public class MyRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // call the embedded rest service from the PetController
        restConfiguration().host("localhost").port(8897);
        getContext().getTypeConverterRegistry().addTypeConverters(new MapConvert());

//        from("timer:hello?period={{timer.period}}")
        from("timer:hello")
                .setHeader("id", simple("${random(1,3)}"))
                .to("rest:get:pets/{id}")
                .log("${body}");

        from("timer:hello?period=1000")
                .transform(simple("Random number ${random(0,100)}"))
                .to("rabbitmq:camel-ex?routingKey=mykey&declare=false&autoDelete=false");

        from("timer:hello?period=2000")
                .transform(simple("Bigger random number ${random(100,200)}"))
                .to("rabbitmq:camel-ex?routingKey=mykey&declare=false&autoDelete=false");

        from("rabbitmq:camel-ex?queue=camel-queue&routingKey=mykey&declare=false&autoDelete=false")
                .log("From RabbitMQ: ${body}")
                .bean(RabbitmqBean.class, "invoke")
                .to("stream:out");
    }

}