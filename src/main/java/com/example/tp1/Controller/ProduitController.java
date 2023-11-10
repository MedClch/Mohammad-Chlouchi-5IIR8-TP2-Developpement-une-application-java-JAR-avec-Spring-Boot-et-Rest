package com.example.tp1.Controller;

import com.example.tp1.Model.Produit;
import com.example.tp1.Service.iProduitService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
public class ProduitController {
    @Autowired
    private iProduitService iProduitService;

    @GetMapping("/produits")
    public List<Produit> getAll(){
        return iProduitService.getAll();
    }

    @GetMapping("/produits/{id}")
    public Produit getProdById(@PathVariable(value = "id") Long prod_id){
        return iProduitService.getById(prod_id);
    }

    @PostMapping(value = "/produits")
    public ResponseEntity<Object> createProdut(@Validated @RequestBody Produit produit) {
        iProduitService.create(produit);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @PutMapping(value = "/produits/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(name = "id") Long productId,
                                                @RequestBody Produit product) {
        Produit productFound = iProduitService.getById(productId);
        if (productFound == null)
            return ResponseEntity.notFound().build();
        iProduitService.update(productId, product);
        return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/produits/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(name = "id") Long
                                                        productId) {
        Produit productFound = iProduitService.getById(productId);
        if (productFound == null)
            return ResponseEntity.notFound().build();
        iProduitService.delete(productId);
        return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
    }
}
