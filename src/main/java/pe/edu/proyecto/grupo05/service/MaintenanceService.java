package pe.edu.proyecto.grupo05.service;

import pe.edu.proyecto.grupo05.dto.ZapatillaDetailDto;
import pe.edu.proyecto.grupo05.dto.ZapatillaDto;
import pe.edu.proyecto.grupo05.dto.ZapatillaEditDto;

import java.util.List;

public interface MaintenanceService {

    List<ZapatillaDto> findAllZapatillas();

    ZapatillaDetailDto findDetailById(Integer id);

    Boolean updateZapatilla(ZapatillaEditDto zapatillaEditDto);
}
