package com.example.spring.services;

import com.example.spring.models.Product;

public interface ProductService {
    void addItem(Product product);
    void removeItem();
    void searchItems();
}
