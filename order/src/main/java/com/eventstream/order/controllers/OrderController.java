package com.eventstream.order.controllers;


import com.eventstream.order.models.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class OrderController {

    private static Logger logger = LoggerFactory.getLogger(OrderController.class);
    private StreamBridge streamBridge;

    public OrderController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }



    @RequestMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody Order order){
        logger.info("create a new order "+order.getId());
        streamBridge.send("createOrder-out-0",order);
    }


}
