package com.app.springfiltercrud.controller;

import com.app.springfiltercrud.entity.Product;
import com.app.springfiltercrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"/","productsweb"})
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String productosTot(Model model){
        model.addAttribute("products",productService.getAllProducts());
        return "webproduct";
    }

    @GetMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("productNew",new Product());
        return "formnew";
    }
    @PostMapping("/new")
    public String createProductNew(@ModelAttribute("productNew") @Validated Product product, BindingResult bindingResult, RedirectAttributes redirect, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("producNew", product);
            return "formnew";
        }
        productService.saveProduct(product);
        return "redirect:/";
    }
}
