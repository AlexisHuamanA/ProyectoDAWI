package pe.edu.proyecto.grupo05.service;

import pe.edu.proyecto.grupo05.dto.ZapatillaDetailDto;
import pe.edu.proyecto.grupo05.dto.ZapatillaDto;
import pe.edu.proyecto.grupo05.dto.ZapatillaEditDto;

import java.util.List;
import java.util.Optional;

public interface MaintenanceService {

    List<ZapatillaDto> findAllZapatillas() throws Exception;

    Optional<ZapatillaDetailDto> findDetailById(int id) throws Exception ;

    Boolean updateZapatilla(ZapatillaEditDto zapatillaEditDto) throws Exception;

    Boolean deleteZapatilla(int id) throws Exception;

    Boolean addZapatilla(ZapatillaDetailDto zapatillaDetailDto) throws Exception;
}
