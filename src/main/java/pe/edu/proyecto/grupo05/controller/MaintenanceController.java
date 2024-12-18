package pe.edu.proyecto.grupo05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.proyecto.grupo05.dto.ZapatillaDetailDto;
import pe.edu.proyecto.grupo05.dto.ZapatillaDto;
import pe.edu.proyecto.grupo05.dto.ZapatillaEditDto;
import pe.edu.proyecto.grupo05.service.MaintenanceService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping("/start")
    public String start(Model model) {
        try {
            List<ZapatillaDto> zapatillas = maintenanceService.findAllZapatillas();
            model.addAttribute("zapatillaStart", zapatillas);
            model.addAttribute("error",null);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Ocurrió un error al obtener los datos");
        }

        return "maintenance";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) throws Exception {

        Optional<ZapatillaDetailDto> zapatillaDetailDto = maintenanceService.findDetailById(id);
        model.addAttribute("zapatillaDetail", zapatillaDetailDto);
        return "maintenance-detail";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) throws Exception {

        Optional<ZapatillaDetailDto> zapatillaDetailDto = maintenanceService.findDetailById(id);
        model.addAttribute("zapatillaEdit", zapatillaDetailDto);
        return "maintenance-edit";
    }

    @PostMapping("/edit-confirm")
    public String edit(@ModelAttribute ZapatillaEditDto zapatillaEditDto, Model model) throws Exception {

        maintenanceService.updateZapatilla(zapatillaEditDto);
        return "redirect:/maintenance/start";
    }



}


