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

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping("/start")
    public String start(Model model) {
            List<ZapatillaDto> zapatillas = maintenanceService.findAllZapatillas();
            model.addAttribute("zapatillaStart", zapatillas);
            return "maintenance";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {

        ZapatillaDetailDto zapatillaDetailDto = maintenanceService.findDetailById(id);
        model.addAttribute("zapatillaDetail", zapatillaDetailDto);
        return "maintenance-detail";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {

        ZapatillaDetailDto zapatillaDetailDto = maintenanceService.findDetailById(id);
        model.addAttribute("zapatillaEdit", zapatillaDetailDto);
        return "maintenance-edit";
    }

    @PostMapping("/edit-confirm")
    public String edit(@ModelAttribute ZapatillaEditDto zapatillaEditDto, Model model) {

        maintenanceService.updateZapatilla(zapatillaEditDto);
        return "redirect:/maintenance/start";
    }



}


