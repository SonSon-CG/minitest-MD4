package com.example.computer.controller;


import com.example.computer.model.DTO.ITypeDTO;
import com.example.computer.model.Type;
import com.example.computer.service.IComputerService;
import com.example.computer.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/types")
public class TypeController {
    @Autowired
    private ITypeService typeService;
    @Autowired
    private IComputerService computerService;

    @GetMapping
    public ModelAndView listType() {
        ModelAndView mv = new ModelAndView("/type/list");
        Iterable<Type> types = typeService.findAll();
        mv.addObject("types", types);
        return mv;
    }

@GetMapping("/dto")
    public String dto(Model model) {
Iterable<ITypeDTO> types = typeService.getAllTypes();
model.addAttribute("types", types);
return "/type/dto";
    }


    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/type/create");
        modelAndView.addObject("type", new Type());
        return modelAndView;
    }


    @PostMapping("/create")
    public String create(@ModelAttribute("type") Type type,
                         RedirectAttributes redirectAttributes) {
        typeService.save(type);
        redirectAttributes.addFlashAttribute("message", "Create new type successfully");
        return "redirect:/types";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable Long id) {
        Optional<Type> type = typeService.findById(id);
        if (type.isPresent()) {
            typeService.remove(id);
            return "redirect:/types";
        }
        return "redirect:/error_404";
    }

}
