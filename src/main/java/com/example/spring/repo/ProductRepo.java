package com.example.spring.repo;
import com.example.spring.DAO.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

//    @Query("insert P")
//    void addItem(Prod);
}
