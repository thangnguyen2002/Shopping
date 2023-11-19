package com.groupb.r2sproject.controllers;

import com.groupb.r2sproject.dtos.CustomUserDetail;
import com.groupb.r2sproject.dtos.OrderDTO.CreateOrderResponse;
import com.groupb.r2sproject.dtos.UserDTO.GetProfile;
import com.groupb.r2sproject.dtos.UserDTO.UpdateProfile;
import com.groupb.r2sproject.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{user_id}")
    public ResponseEntity<?> getUserInfo(@PathVariable("user_id") Long user_id, @RequestAttribute("current_user") CustomUserDetail user) throws Exception {
        if(!Objects.equals(user.getUserId(), user_id)){
            return new ResponseEntity<String>("Forbiden",null, 403);
        }
        GetProfile profile = userService.getUserByUserId(user_id);
        return new ResponseEntity<GetProfile>(profile, HttpStatus.OK);
    }

    @PutMapping("/{user_id}")
    public ResponseEntity<?> updateUserInfo(@PathVariable("user_id") Long user_id, @RequestAttribute("current_user") CustomUserDetail user, @RequestBody UpdateProfile profile) throws Exception {
        if(!Objects.equals(user.getUserId(), user_id)){
            return new ResponseEntity<String>("Forbiden",null, 403);
        }
        Boolean result = userService.updateProfile(user_id, profile);
        if (result == false){
            return new ResponseEntity<String>("Cập nhật user thất bại", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("Cập nhật user thành công", HttpStatus.OK);
    }
}
