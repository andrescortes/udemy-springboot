package com.springsimplespasos.universidad.universidadbackend.modelo.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//DTO = Data Transfer Object
//These class are used to represent the data that is going to be sent to the client.

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "CareerDTO", description = "Representation of a Career", parent = CareerDTO.class, reference = "Carrera", discriminator = "career")
public class CareerDTO {

    @ApiModelProperty(value = "Career id", required = true, name = "id", example = "1", dataType = "int")
    private Integer id;
    @NotNull(message = "The name no can't be null")
    @NotEmpty(message = "The name no can't be empty")
    @Size(min = 3, max = 50, message = "The name must be between 3 and 50 characters")
    @ApiModelProperty(value = "Career name", required = true, name = "name", example = "Ingeniería en Sistemas", dataType = "string")
    private String name;
    @Positive(message = "The quantity of years must be greater than 0")
    @ApiModelProperty(value = "Career quantity of years", required = true, name = "quantityOfYears", example = "4", dataType = "int")
    private Integer amountYears;
    @Positive(message = "The quantity of subjects must be greater than 0")
    @ApiModelProperty(value = "Career quantity of subjects", required = true, name = "quantityOfSubjects", example = "4", dataType = "int")
    private Integer amountSubjects;

}
