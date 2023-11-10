package com.groupb.r2sproject.controllers;

import com.groupb.r2sproject.dtos.CartDTO.AddNewProduct;
import com.groupb.r2sproject.services.interfaces.CartLineItemService;
import com.groupb.r2sproject.services.interfaces.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CartLineItemService cartLineItemService;

    @GetMapping("/{cart_id}")
    public ResponseEntity<?> getCartById(@PathVariable("cart_id") Long cart_id){
        return null;
    }
    
    @GetMapping("/{user_id}")
    public ResponseEntity<?> getCartByUserId(@PathVariable("user_id") Long user_id){
        return null;
    }

    @PostMapping("/{cart_id}/{variantP_id}")
    public ResponseEntity<?> addNewProductToCart(@PathVariable("cart_id") Long cart_id,@PathVariable("variantP_id") Long variantP_id,@RequestBody() AddNewProduct newProduct){
        //direct to cart-line item service

        //get response
        
        return null;
    }
}
