package com.kw.Proj2_spr_2020202060.Controller;

import com.kw.Proj2_spr_2020202060.Model.Image;
import com.kw.Proj2_spr_2020202060.Model.UserVo;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

@RestController
@RequestMapping("/login")
public class LoginController {

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/userLogin")
    public ResponseEntity<String> login(
            @RequestBody UserVo user) throws IOException {
        System.out.print(user.getId());
        System.out.print(user.getPw());
        
        return ResponseEntity.ok("123");
    }

}
