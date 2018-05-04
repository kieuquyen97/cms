package io.phat.cms.web.controller;

import io.phat.cms.core.domain.post.CrudPostTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

    private final CrudPostTypeService crudPostTypeService;

    @Autowired
    public AdminController(CrudPostTypeService crudPostTypeService) {
        this.crudPostTypeService = crudPostTypeService;
    }

    @GetMapping
    public String dashboard(Model model) {
        model.addAttribute("postTypes", crudPostTypeService.findAll());
        return "admin/dashboard";
    }
}
