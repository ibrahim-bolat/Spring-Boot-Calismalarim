package com.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "person")
@ApiModel(value = "Person Api model documentation", description = "Model")
public class Person {

    @Id
    @ApiModelProperty(value = "Unique id field of person object")
    private String id;

    @Field(value = "name")
    @ApiModelProperty(value = "name field of person object")
    private String name;

    @Field(value = "surname")
    @ApiModelProperty(value = "surname field of person object")
    private String surname;

    @Field(value = "salary")
    @ApiModelProperty(value = "salary field of person object")
    private int salary;

    @Field(value = "birthDate")
    @ApiModelProperty(value = "birthDate field of person object")
    private LocalDate birthDate;

    @Field(value = "credit")
    @ApiModelProperty(value = "credit field of person object")
    private BigDecimal credit;
}
