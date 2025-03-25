package com.metacoding.bankv1.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void 회원가입(UserRequest.JoinDTO joinDTO) {
//1. 동일 유저네임 있는지 검사
        User user = userRepository.findByUsername(joinDTO.getUsername());
        //2. 있으면, exception 터트리기
        //오류는 바로 터뜨려야 한다.
        if (user != null) {
            throw new RuntimeException("동일한 username이 존재합니다.");
        }
        //3. 없으면 회원가입하기
//        String encPassword = 해시암호화라이브러리(joinDTO.getPassword());

        userRepository.save(joinDTO.getUsername(), joinDTO.getPassword(), joinDTO.getFullname());
    }

   // Commit(insert update)rk 필요하지 않으므로 @Transactional 불필요
    public User 로그인(UserRequest.LoginDTO loginDTO) {
        // 1. 해당 username이 조회됨?
        User user = userRepository.findByUsername(loginDTO.getUsername());
        // 2. 필터일(유저네임, 패스워드가 불일치하는 것들을
        if (user == null) {
            throw new RuntimeException("해당 username이 없습니다.");
        }
        //비밀번호가 같은지 확인한다.
        if (!(user.getPassword().equals(loginDTO.getPassword()))){
            throw new RuntimeException("해당 password가 틀렸습니다.");
        }

        //3. 인증
        return user;  //세션에 저장 세션에 저장하면 id를 준다.
    }
}
