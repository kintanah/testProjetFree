package com.example.myProjetSpringBoot.Controller;

import com.example.myProjetSpringBoot.Entity.Product;
import com.example.myProjetSpringBoot.Exception.ResourceNotFoundException;
import com.example.myProjetSpringBoot.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/product/V1")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/liste")
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product){
        if(productRepository.findByName(product.getName())==null){
            return productRepository.save(product);
        }
        return null;
    }

    @GetMapping("/Name/{name}")
    public ResponseEntity<Map<String,Boolean>> getProductByName(@PathVariable String name){
        Map<String,Boolean> response=new HashMap<>();
        if(productRepository.findByName(name)!=null){
            response.put("Existed",Boolean.TRUE);
            return ResponseEntity.ok(response);
        }
        response.put("Not existed",Boolean.FALSE);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id){
        Product product=productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product not exist with id :"+id));
        return ResponseEntity.ok().body(product);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id,@RequestBody Product product){
        Product product1=productRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Product not exist with id :"+id));
        if(product1.getName().equals(product.getName())){
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            product1.setDescription(product.getDescription());

            Product updatedProduct=productRepository.save(product1);
            return ResponseEntity.ok(updatedProduct);
        }
        else{
            if(productRepository.findByName(product.getName())==null){
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                product1.setDescription(product.getDescription());

                Product updatedProduct=productRepository.save(product1);
                return ResponseEntity.ok(updatedProduct);
            }
            else {
                return ResponseEntity.ok(null);
            }
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteProduct(@PathVariable String id){
        Product product=productRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Product not exist with id :"+id));
        productRepository.delete(product);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
