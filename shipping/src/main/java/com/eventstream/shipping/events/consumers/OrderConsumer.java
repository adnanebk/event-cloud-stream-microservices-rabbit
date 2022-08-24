package com.eventstream.shipping.events.consumers;


import com.eventstream.shipping.models.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;

@Configuration
public class OrderConsumer {
    private static Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    @Bean
    public Consumer<Flux<Order>> orderPayed(){
        return (order) -> {
            order.subscribe(payedOrder->{
                        logger.info("order "+payedOrder.getId()+" will be shipped to user "+payedOrder.getUserId());
                    }, err-> logger.error("error----"+err.getMessage())
            );

        };
    }

}
