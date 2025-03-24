package com.metacoding.bankv1.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public void 회원가입(UserRequest.JoinDTO joinDTO) {
//1. 동일 유저네임 있는지 검사
        User user = userRepository.findByUsername(joinDTO.getUsername());
        //2. 있으면, exception 터트리기
        //오류는 바로 터뜨려야 한다.
        if (user != null) {throw new RuntimeException("동일한 username이 존재합니다.");}
        //3. 없으면 회원가입하기
//        String encPassword = 해시암호화라이브러리(joinDTO.getPassword());

        userRepository.save(joinDTO.getUsername(), joinDTO.getPassword(), joinDTO.getFullname());
    }
}
