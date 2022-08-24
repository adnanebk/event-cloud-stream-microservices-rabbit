package com.eventstream.payement.events.processors;


import com.eventstream.payement.models.Order;
import com.eventstream.payement.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.function.Function;

@Configuration
@RequiredArgsConstructor
public class OrderProcessors {

private final AccountService accountService;

    private static Logger logger = LoggerFactory.getLogger(OrderProcessors.class);


    @Bean
    public Function<Flux<Order>,Flux<Order>>  processOrder(){

      return    order  -> order.doOnNext(receivedOrder ->{
                         accountService.payOrder(receivedOrder.getUserId(),receivedOrder.getTotalPrice());
          receivedOrder.setCreatedAt(LocalDateTime.now());
                         logger.info("order "+ receivedOrder.getId() +" has been payed");
        }).doOnError(er -> logger.info("-----"+er.getLocalizedMessage()));

}
}
