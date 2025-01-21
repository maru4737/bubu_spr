package com.kw.Proj2_spr_2020202060.Login.Service;

import com.kw.Proj2_spr_2020202060.Login.Dto.User;
import com.kw.Proj2_spr_2020202060.Login.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User userLogin(User user) {
        System.out.println("gregre"+user.getId());
        System.out.println("gregr453e"+user.getPassword());

        // DB에서 유저 조회
        Optional<User> optionalUser = userRepository.findByUser(user);

        // 유저 존재 여부와 비밀번호 확인
        if (optionalUser.isPresent()) {
            User foundUser = optionalUser.get();
            return foundUser; // 로그인 성공
//            if (passwordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
//
//            }
        }
        return null; // 로그인 실패
    }
}
