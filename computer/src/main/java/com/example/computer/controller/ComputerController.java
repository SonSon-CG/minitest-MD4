package com.example.computer.controller;

import com.example.computer.model.Computer;
import com.example.computer.model.Type;
import com.example.computer.service.IComputerService;
import com.example.computer.service.ITypeService;
import com.example.computer.service.impl.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/computers")
public class ComputerController {

    @Autowired
    private IComputerService computerService;

    @Autowired
    private ITypeService typeService;

    @ModelAttribute("types")
    public Iterable<Type> listTypes() {
        return typeService.findAll();
    }

    @GetMapping
    public ModelAndView listComputer() {
        ModelAndView mv = new ModelAndView("/computer/list");
        Iterable<Computer> computers = computerService.findAll();
        mv.addObject("computers", computers);
        return mv;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/computer/create");
        modelAndView.addObject("computers", new Computer());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("computer") Computer computer,
                         RedirectAttributes redirectAttributes) {
        computerService.save(computer);
        redirectAttributes.addFlashAttribute("message", "Create new computer successfully");
        return "redirect:/computers";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateForm(@PathVariable Long id) {
        Optional<Computer> computer = computerService.findById(id);

        if (computer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/computer/update");
            modelAndView.addObject("computer", computer.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("computer") Computer computer,
                         RedirectAttributes redirect) {
        computerService.save(computer);
        redirect.addFlashAttribute("message", "Update computer successfully");
        return "redirect:/computers";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,
                         RedirectAttributes redirect) {
        computerService.remove(id);
        redirect.addFlashAttribute("message", "Delete computer successfully");
        return "redirect:/computers";
    }
}