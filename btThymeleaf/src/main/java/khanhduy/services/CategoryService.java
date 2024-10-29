package khanhduy.services;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import khanhduy.entity.CategoryEntity;
import khanhduy.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Page listAll(String keyword, java.awt.print.Pageable pageable) {
        return keyword != null ? categoryRepository.findByNameContaining(keyword, pageable) 
                               : (Page) categoryRepository.findAll();
    }

    public void save(Category category) { categoryRepository.save(category); }
    public CategoryEntity get(Long id) { return categoryRepository.findById(id).orElse(null); }
    public void delete(Long id) { categoryRepository.deleteById(id); }
}

