package khanhduy.controller;

import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import khanhduy.services.Category;
import khanhduy.services.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listCategories(@RequestParam(value = "keyword", required = false) String keyword, 
                                 @PageableDefault(size = 5) Pageable pageable, Model model) {
        model.addAttribute("page", categoryService.listAll(keyword, pageable));
        model.addAttribute("keyword", keyword);
        return "categories/list";
    }

    @GetMapping("/new")
    public String newCategory(Model model) { model.addAttribute("category", new Category()); return "categories/form"; }

    @PostMapping("/save")
    public String saveCategory(Category category) { categoryService.save(category); return "redirect:/categories"; }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") Long id, Model model) {
        model.addAttribute("category", categoryService.get(id));
        return "categories/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryService.delete(id);
        return "redirect:/categories";
    }
}
