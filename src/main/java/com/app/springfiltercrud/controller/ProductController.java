package com.app.springfiltercrud.controller;

import com.app.springfiltercrud.entity.Product;
import com.app.springfiltercrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/","/productsweb"})
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String productosTot(Model model, @Param("keyword") String keyword){
        model.addAttribute("keyword",keyword);
        model.addAttribute("products",productService.getAllProducts(keyword));
        return "webproduct";
    }

    @GetMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("formTitle", "New product");
        model.addAttribute("productNew",new Product());
        return "formnew";
    }
    @PostMapping("/new")
    public String createProductNew(@ModelAttribute("productNew") @Validated Product product, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("formTitle", "New product");
            model.addAttribute("productNew", product);
            return "formnew";
        }
        productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model) {
        model.addAttribute("productNew", productService.getProductById(id));
        return "formupdate";
    }

    @PostMapping("/edit/{id}")
    public String updateProduct(@ModelAttribute("productNew") @Validated Product product, BindingResult bindingResult, @PathVariable Long id,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("productNew",product);
            return "formupdate";
        }
        productService.updateProduct(id,product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
