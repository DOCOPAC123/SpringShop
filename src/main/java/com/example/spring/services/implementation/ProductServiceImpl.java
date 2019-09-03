package com.example.spring.services.implementation;

import com.example.spring.DAO.models.Product;
import com.example.spring.repo.ProductRepo;
import com.example.spring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo repo;
    @Override
    public void addItem(com.example.spring.models.Product productDTO) {

        System.out.println("Add Item method called in Service Class");
        Product productDAO = new Product();
        productDAO.setProductName(productDTO.getProductName());
        productDAO.setProductPrice(productDTO.getProductPrice());
        productDAO.setProductDescription(productDTO.getProductDescription());
        System.out.println(productDAO.getProductDescription());
        repo.save(productDAO);
    }

    @Override
    public void removeItem() {
        System.out.println("Remove Item method called in Service Class");
    }

    @Override
    public void searchItems() {
        System.out.println("Search Item method called in Search Class");
    }
}
