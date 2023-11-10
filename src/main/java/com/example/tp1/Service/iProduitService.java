package com.example.tp1.Service;

import com.example.tp1.Model.Produit;

import java.util.List;

public interface iProduitService {
    Produit getById(Long id);
    List<Produit> getAll();
    void create(Produit produit);
    void update(Long id,Produit produit);
    void delete(Long id);
}
