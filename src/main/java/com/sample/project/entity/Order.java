package com.sample.project.entity;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class Order {

    @NotNull
    String orderName;

    @NotNull
    Long epochTime;

    public Order(String orderName, Long epochTime) {
        this.orderName = orderName;
        this.epochTime = epochTime;
    }
}
