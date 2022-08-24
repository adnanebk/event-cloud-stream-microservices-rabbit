package com.eventstream.payement.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;


@Getter
@Setter
@Builder
public class Account implements Serializable {

    private UUID id = UUID.randomUUID();
    private int userId;
    private  double  balance;
}
