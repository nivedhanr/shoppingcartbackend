package com.example.shoppingcart_backend.controller;

import com.example.shoppingcart_backend.dao.ProductDao;
import com.example.shoppingcart_backend.dao.UserregistrationDao;
import com.example.shoppingcart_backend.model.Products;
import com.example.shoppingcart_backend.model.Userregistration;
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

    @Autowired
    private UserregistrationDao dao1;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userregistration",consumes = "application/json",produces = "application/json")
    public Map<String,String> Userregistration(@RequestBody Userregistration u){
        System.out.println(u.getName().toString());
        System.out.println(u.getAddress().toString());
        System.out.println(u.getPhn().toString());
        System.out.println(u.getEmail().toString());
        dao1.save(u);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;



    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userlogin", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> userLogin(@RequestBody Userregistration r){
        System.out.println(r.getEmail());
        List<Userregistration> result=(List<Userregistration>) dao1.userLogin(r.getEmail(),r.getPassword());
        HashMap<String,String> st=new HashMap<>();
        if (result.size()==0){
            st.put("status","failed");
            st.put("message","user doesn't exist");

        }
        else{
            int id =result.get(0).getId();
            st.put("userid",String.valueOf(id));
            st.put("message","user login success");
        }
        return st;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/getUserById", consumes = "application/json", produces = "application/json")
    public List<Userregistration> GetUserById(@RequestBody Userregistration f){
        return (List<Userregistration>) dao1.FindUser(f.getId());
    }



}
