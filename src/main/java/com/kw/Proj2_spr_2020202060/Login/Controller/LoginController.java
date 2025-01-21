package com.kw.Proj2_spr_2020202060.Login.Controller;

import com.kw.Proj2_spr_2020202060.Login.Dto.User;
import com.kw.Proj2_spr_2020202060.Login.Service.LoginService;
import com.kw.Proj2_spr_2020202060.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final LoginService loginService;

    public LoginController(JwtUtil jwtUtil, PasswordEncoder passwordEncoder, LoginService loginService) {
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.loginService = loginService;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/userLogin")
    public ResponseEntity<String> login(
            @RequestBody User user) throws IOException {

        User pinUser = new User();
        pinUser = loginService.userLogin(user);

        System.out.print("R$#@$#@pinUser : " + pinUser);
        // 비밀번호 확인 (DB에서 조회한 비밀번호와 입력한 비밀번호 비교)
        if (pinUser != null) {

            // 비밀번호가 일치하면 JWT 토큰 생성
            String token = jwtUtil.generateJwtToken(pinUser);
            return ResponseEntity.ok(token); // JWT 토큰 반환
        } else {
            //return ResponseEntity.status(401).body("Invalid credentials");
            return ResponseEntity.ok("비밀번호 다름");

        }

    }

}
