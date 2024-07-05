package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.model.AuthenticationResponse;
import com.example.demo.model.Item;
import com.example.demo.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ItemController {

    private final ItemService itemService;
    @PostMapping("/additem")
    public String addItem(
            @RequestBody Item request
    ){
//        System.out.println("request isssssssss  " + request.getAppUser().getId());
         return  itemService.addItem(request);
    }


    @GetMapping("/getitems/{userId}")
    public List<Item> getItems(
            @PathVariable Integer userId
    ){
        return itemService.getItems(userId);
    }


}
