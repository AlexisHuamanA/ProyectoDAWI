package pe.edu.proyecto.grupo05.dto;

import pe.edu.proyecto.grupo05.entity.Categoria;
import pe.edu.proyecto.grupo05.entity.Marca;

public record ZapatillaEditDto(
    Integer zapatillaId,
    String modelo,
    Marca marca,
    Categoria categoria,
    String descripcion,
    Double precio,
    Integer stock,
    String urlimg
) {
    }