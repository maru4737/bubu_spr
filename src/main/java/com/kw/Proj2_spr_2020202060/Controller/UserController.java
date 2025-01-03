package com.kw.Proj2_spr_2020202060.Controller;

import com.kw.Proj2_spr_2020202060.Model.UserVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/userInfo")
    public ResponseEntity<String> login(
           ) throws IOException {
        System.out.print("userInfo enPoint");

        return ResponseEntity.ok("maru4737");
    }

}
