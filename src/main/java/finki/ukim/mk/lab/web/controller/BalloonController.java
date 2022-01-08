package finki.ukim.mk.lab.web.controller;

import finki.ukim.mk.lab.model.Balloon;
import finki.ukim.mk.lab.service.BalloonService;
import finki.ukim.mk.lab.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/balloons")
public class BalloonController {

    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("balloons", balloonService.listAll());
        return "listBalloons";
    }

    @PostMapping("/add")
    public String saveBalloon(@RequestParam(required = false) Long id, @RequestParam String name, @RequestParam String description, @RequestParam Long manufacturerId) {
        try {
            balloonService.save(id, name, description, manufacturerId);
            return "redirect:/balloons";
        }
        catch (Exception e) {
            return "redirect:/balloons?error=ManufacturerNotFound";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id){
        balloonService.delete(id);
        return "redirect:/balloons";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditBalloonPage(@RequestParam(required = false) String error, @PathVariable Long id, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        try {
            Balloon balloonToEdit = balloonService.getBalloonById(id);
            model.addAttribute("balloon", balloonToEdit);
            model.addAttribute("manufacturers", manufacturerService.listAll());
        }
        catch (Exception e) {
            return "redirect:/balloons?error=BalloonNotFound";
        }
        return "add-balloon";
    }

    @GetMapping("/add-form")
    public String getAddBalloonPage(Model model) {
        model.addAttribute("manufacturers", manufacturerService.listAll());
        return "add-balloon";
    }
}
