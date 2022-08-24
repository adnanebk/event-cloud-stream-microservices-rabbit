package com.eventstream.order.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Order implements Serializable {

    private UUID id = UUID.randomUUID();

    private int userId ;

    private LocalDateTime createdAt;

    private Double totalPrice;

}
