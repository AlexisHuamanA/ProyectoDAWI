package pe.edu.proyecto.grupo05.response;
import pe.edu.proyecto.grupo05.dto.ZapatillaDetailDto;

public record FindZapatillaResponse(String code,
                                    String error,
                                    ZapatillaDetailDto zapatilla) {

}
