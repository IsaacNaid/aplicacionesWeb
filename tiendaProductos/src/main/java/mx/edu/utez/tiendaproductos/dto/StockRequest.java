package mx.edu.utez.tiendaproductos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record StockRequest (
    @NotNull
    @Positive
    Integer cantidad,
    @NotBlank(message = "Debe de tener algo, incorrecto")
    String operation
){

}
