package com.microservices.ordering.model;

import com.microservices.ordering.dto.AgentDTO2;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="AgentOrder")
public class Agent {

    @Id
    @SequenceGenerator(name = "agent_id_seq", sequenceName = "agent_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agent_id_seq")
    private Long id;

    private String name;

    private String address;

    private String pib;

    /*
    @OneToMany(fetch = FetchType.EAGER)
    public List<Order> orders;*/

}
