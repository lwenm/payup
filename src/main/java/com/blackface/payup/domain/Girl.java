package com.blackface.payup.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Author:lwenm
 * Description:
 * Date:2019/4/9
 * Time:21:44
 **/
@Entity
@Data
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "这个字段必传")
    private String cupSize;

    @Min(value = 18, message = "未成年少女禁止入门")
    private Integer age;

    @NotNull(message = "金额必传")
    private Double money;

    public Girl() {
    }

}

