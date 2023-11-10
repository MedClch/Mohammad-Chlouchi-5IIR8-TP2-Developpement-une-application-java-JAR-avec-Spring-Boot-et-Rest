package com.example.tp1.Service;

import com.example.tp1.Model.Produit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProduitServiceImp implements iProduitService{
    private static List<Produit> produitList = new ArrayList<>();
    static {
        produitList.add(new Produit(1L,"PC PORTABLE HP"));
        produitList.add(new Produit(2L,"TV LG 32P"));
        produitList.add(new Produit(3L,"TV SONY 49P"));
        produitList.add(new Produit(4L,"CAMERA SONY"));
    }
    @Override
    public Produit getById(Long id) {
        if(produitList==null||produitList.isEmpty())
            return null;
        for (Produit p : produitList)
            if(id.equals(p.getId()))
                return p;
        return null;
    }

    @Override
    public List<Produit> getAll() {
        return produitList;
    }

    @Override
    public void create(Produit produit) {
        produitList.add(produit);
    }

    @Override
    public void update(Long id, Produit produit) {
        Produit produit1 = getById(id);
        if(produit1==null)
            return;
        produitList.remove(produit1);
        produit.setId(id);
        produitList.add(produit);
    }

    @Override
    public void delete(Long id) {
        Produit produit1 = getById(id);
        if(produit1==null)
            return;
        produitList.remove(produit1);
    }
}
