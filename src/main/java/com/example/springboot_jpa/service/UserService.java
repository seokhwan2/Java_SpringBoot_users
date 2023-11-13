package com.example.springboot_jpa.service;

import com.example.springboot_jpa.entity.Users;
import com.example.springboot_jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<Users> getUserService(String name){
        if(name.isBlank())  // name 파라미터가 Null이면 전체 user를 리턴
            return userRepository.findAll();
        else    //name이 존재를 하면, like 쿼리로 2개만 리턴
            return userRepository.findFirst2ByUsernameLikeOrderByIDDesc(name);
    }

    public String createUserService(Users user){
        userRepository.save(user);   //User Insert 쿼리 수행
        return "등록 완료";
    }
}
