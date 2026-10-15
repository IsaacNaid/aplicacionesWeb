package mx.edu.utez.tiendaproductos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record ProductRequest(
        @NotBlank(message = "Debe de tener algo, incorrecto")
        String name,
        @Positive
        Double price,
        @NotNull
        @PositiveOrZero
        Integer stock,
        @NotNull
        Long categoryId
) {


}
