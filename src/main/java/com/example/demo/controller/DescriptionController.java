package com.example.demo.controller;

import com.example.demo.service.DescriptionService;
import com.example.demo.model.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class DescriptionController {

    private final DescriptionService descriptionService;

    @Autowired
    public DescriptionController(DescriptionService descriptionService) {
        this.descriptionService = descriptionService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/base")
    public String showBase(Model model) {
        List<Description> descriptions = descriptionService.getAllDescriptionsSortedByNumber();
        model.addAttribute("descriptions", descriptions);
        return "base";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("description", new Description());
        return "form";
    }
    @GetMapping("/look/{id}")
    public String showLook(@PathVariable String id, Model model) {
        Description description = descriptionService.getDescriptionById(id);
        if (description != null) {
            model.addAttribute("description", description);
            return "look"; // Страница для просмотра деталей
        } else {
            return "redirect:/base"; // Перенаправление в случае ошибки
        }
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute Description description, RedirectAttributes redirectAttributes) {
        descriptionService.saveDescription(description);
        redirectAttributes.addFlashAttribute("message", "Техническое задание успешно сохранено.");
        return "redirect:/success";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Description description = descriptionService.getDescriptionById(id);
        model.addAttribute("description", description);
        return "form";
    }

    @PostMapping("/edit/{id}")
    public String updateDescription(@PathVariable String id, @ModelAttribute Description description, RedirectAttributes redirectAttributes) {
        description.setId(id);
        descriptionService.updateDescription(id, description);
        redirectAttributes.addFlashAttribute("message", "Техническое задание успешно обновлено.");
        return "redirect:/success";
    }

    @GetMapping("/delete/{id}")
    public String deleteDescription(@PathVariable String id, RedirectAttributes redirectAttributes) {
        descriptionService.deleteDescription(id);
        redirectAttributes.addFlashAttribute("message", "Техническое задание успешно удалено.");
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String showSuccess() {
        return "success";
    }
}