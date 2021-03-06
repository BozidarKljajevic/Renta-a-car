package com.microservices.ordering.dto;


import com.microservices.ordering.model.AdCar;
import com.microservices.ordering.model.Agent;
import com.microservices.ordering.model.Order;
import com.microservices.ordering.model.Users;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDTO {

    private Long id;
    private String availableFrom;
    private String availableTo;

    private Boolean required;
    private boolean deleted;

    private long adCar;


    private Long userIzdavao;
    private Long agentIzdao;
    private Long userr;

    //private Users userIzdao;
    //private Agent agentIzdao;


    public OrderDTO(Order order) {
        this.id=order.getId();
        this.availableFrom=order.getAvailableFrom();
        this.availableTo=order.getAvailableTo();
        this.adCar=order.getAdCar();
        this.userr=order.getUserr();
        this.userIzdavao=order.getUserIzdavao();
        this.agentIzdao=order.getAgentIzdao();
    }
}
