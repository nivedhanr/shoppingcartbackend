package com.example.shoppingcart_backend.controller;

import com.example.shoppingcart_backend.dao.ProductDao;
import com.example.shoppingcart_backend.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class ShopController {
    @Autowired
    private ProductDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path="/add",consumes = "application/json",produces = "application/json")
public Map<String,String> Addproduct(@RequestBody Products p){
        System.out.println(p.getProductname().toString());
        System.out.println(p.getImg().toString());
        System.out.println(p.getCategory().toString());
        System.out.println(p.getDes().toString());
        System.out.println(p.getPrice().toString());
        dao.save(p);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Products> Viewproduct(){
        return (List<Products>) dao.findAll();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path ="/search",consumes = "application/json",produces = "application/json")
    public List<Products> SearchProduct(@RequestBody Products p){
        String productname=p.getProductname();
        System.out.println(productname);
        return (List<Products>) dao.SearchProduct((p.getProductname()));
    }

}
