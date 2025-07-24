package com.atg.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "payDTO")
public class PayDTO implements Serializable {

    private Integer id;

    private String orderNo;

    private String payNo;

    private Integer userId;

    private BigDecimal amount;

}
