package pe.edu.proyecto.grupo05.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.proyecto.grupo05.dto.ZapatillaDetailDto;
import pe.edu.proyecto.grupo05.dto.ZapatillaDto;
import pe.edu.proyecto.grupo05.dto.ZapatillaEditDto;
import pe.edu.proyecto.grupo05.repository.ZapatillaRepository;
import pe.edu.proyecto.grupo05.response.*;
import pe.edu.proyecto.grupo05.service.MaintenanceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/maintenance-zapatilla")
public class ManageZapatillaApi {

    @Autowired
    MaintenanceService maintenanceService;
    @Autowired
    private ZapatillaRepository zapatillaRepository;

    @GetMapping("/all")
    public FindZapatillasResponse findZapatillas() {

        try {
            List<ZapatillaDto> zapatillas = maintenanceService.findAllZapatillas();
            if (!zapatillas.isEmpty())
                return new FindZapatillasResponse("01", null, zapatillas);
            else
                return new FindZapatillasResponse("02", "Users not found", null);

        } catch (Exception e) {
            e.printStackTrace();
            return new FindZapatillasResponse("99", "An error ocurred, please try again", null);
        }
    }

    @GetMapping("/detail")
    public FindZapatillaResponse findZapatilla(@RequestParam(value = "id", defaultValue = "0") String id) {

        try {
            Optional<ZapatillaDetailDto> optional = maintenanceService.findDetailById(Integer.parseInt(id));
            return optional.map(zapatilla ->
                    new FindZapatillaResponse("01", null, zapatilla)
            ).orElse(
                    new FindZapatillaResponse("02", "User not found", null)
            );

        } catch (Exception e) {
            e.printStackTrace();
            return new FindZapatillaResponse("99", "An error ocurred, please try again", null);

        }

    }

    @PutMapping("/update")
    public UpdateZapatillaResponse updateZaptilla(@RequestBody ZapatillaEditDto zapatillaEditDto) {

        try {
            if (maintenanceService.updateZapatilla(zapatillaEditDto))
                return new UpdateZapatillaResponse("01", null);
            else
                return new UpdateZapatillaResponse("02", "User not found");

        } catch (Exception e) {
            e.printStackTrace();
            return new UpdateZapatillaResponse("99", "An error ocurred, please try again");

        }

    }

    @DeleteMapping("/delete/{id}")
    public DeleteZapatillaResponse deleteUser(@PathVariable String id) {

        try {
            if (maintenanceService.deleteZapatilla(Integer.parseInt(id)))
                return new DeleteZapatillaResponse("01", null);
            else
                return new DeleteZapatillaResponse("02", "User not found");

        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteZapatillaResponse("99", "An error ocurred, please try again");

        }
    }

    @PostMapping("/create")
    public CreateZapatillaResponse createZapatilla(@RequestBody ZapatillaDetailDto zapatillaDetailDtoDetailDto) {

        try {
            if (maintenanceService.addZapatilla(zapatillaDetailDtoDetailDto))
                return new CreateZapatillaResponse("01", null);
            else
                return new CreateZapatillaResponse("02", "User already exists");

        } catch (Exception e) {
            e.printStackTrace();
            return new CreateZapatillaResponse("99", "An error ocurred, please try again");

        }

    }
}
