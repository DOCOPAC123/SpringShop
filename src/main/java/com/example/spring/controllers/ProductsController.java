/* Created by Rohit Chauhan */
package com.example.spring.controllers;
import com.example.spring.models.Product;
import com.example.spring.models.RemoveProduct;
import com.example.spring.models.User;
import com.example.spring.repo.UserRepo;
import com.example.spring.services.ProductService;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ProductsController {

    @Autowired
    ProductService productService;

    @Autowired
    private UserRepo userRepo;

    @PostMapping(value = "/add/{id}/{name}/{salary}",consumes = "application/json")
    void addItems(@RequestBody Product product,
                  @PathVariable("id") final String id,
                  @PathVariable("name") final String name,
                  @PathVariable("salary") final Long salary)
    {

        System.out.println("You Called the add item API");
        System.out.println(product.getProductDescription());
//        productService.addItem(product);
        User user = new User(id,name,salary);
        userRepo.save(user);
    }

    @PostMapping(value = "/remove",consumes = "application/json")
    void removeItem(@RequestBody RemoveProduct remove)
    {
        System.out.println("You called the Remove items API");
        System.out.println(remove.getProductId());
        productService.removeItem();
    }

    @PostMapping("/search")
    void search()
    {
        System.out.println("You called the Search Items API");
        productService.searchItems();
    }

    @PostMapping("/findAll")
    Map<String,User> findAll() {
        System.out.println("Find All method invoked");
        return userRepo.findAll();
    }

    @PostMapping("/findById/{id}")
    User findById(@PathVariable("id") final String id)
    {
        System.out.println("findById method invoked");
        return userRepo.findById(id);
    }

    @PostMapping("/deleteUser/{id}")
    void deleteUser(@PathVariable("id") final String id)
    {
        System.out.println("Delete User method invoked");
        userRepo.delete(id);
    }
}
