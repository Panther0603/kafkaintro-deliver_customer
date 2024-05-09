package com.deliveryboy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.data.jpa.repository.JpaRepository;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliverAddress  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String currentAddress;

    @Column(nullable = false)
    private String deliverBoyName;

}
