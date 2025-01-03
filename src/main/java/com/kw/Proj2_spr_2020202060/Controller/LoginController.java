package com.kw.Proj2_spr_2020202060.Controller;

import com.kw.Proj2_spr_2020202060.Model.Image;
import com.kw.Proj2_spr_2020202060.Model.UserVo;
import com.kw.Proj2_spr_2020202060.util.JwtUtil;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public LoginController(JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/userLogin")
    public ResponseEntity<String> login(
            @RequestBody UserVo user) throws IOException {


        System.out.print(user.getId());
        System.out.print(user.getPw());

        String storedPassword = "storedPassword";

        // 비밀번호 확인 (DB에서 조회한 비밀번호와 입력한 비밀번호 비교)
        if (storedPassword.equals("storedPassword")) {
            System.out.println("여기탐");
            // 비밀번호가 일치하면 JWT 토큰 생성
            String token = jwtUtil.generateJwtToken(user);
            return ResponseEntity.ok(token); // JWT 토큰 반환
        } else {
            System.out.println("여기탐2");
            return ResponseEntity.status(401).body("Invalid credentials");
        }

    }

}
