package org.example.metabox.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final HttpSession session;
    private final UserService userService;

    @GetMapping("/")
    public String mainForm(HttpServletRequest request) {
        return "index";
    }

    @GetMapping("/login-form")
    public String loginForm(HttpServletRequest request) {
        return "user/login-form";
    }

    @GetMapping("/non-member")
    public String nonMember(HttpServletRequest request) {
        return "user/non-member";
    }

    @GetMapping("/mypage/home")
    public String mypageHome(HttpServletRequest request) {
        return "user/mypage-home";
    }

    @GetMapping("/mypage/detail-book")
    public String myBookDetail(HttpServletRequest request) {
        return "user/mypage-detail-book";
    }

    @GetMapping("/mypage/detail-saw")
    public String mySawDetail(HttpServletRequest request) {
        return "user/mypage-detail-saw";
    }

//     kakao, naver 공통
//    @GetMapping("/oauth/callback")
//    public String oauthCallback(HttpServletRequest request) {
//        String code = request.getParameter("code");
//        String provider = request.getParameter("provider");
//
//        if ("kakao".equals(provider)) {
////        User sessionUser = userService.loginKakao(code);
//
//        } else if ("naver".equals(provider)) {
////            User sessionUser = userService.loginNaver(code);
//        }
////        session.setAttribute("sessionUser", sessionUser);
//        return "redirect:/";
//    }

    // 일단 카카오만
    @GetMapping("/oauth/callback/kakao")
    public String oauthCallback(String code) {
        System.out.println("코드 받나요 : " + code);
//        User sessionUser = userService.loginKakao(code);
//        session.setAttribute("sessionUser", sessionUser);
        return "redirect:/";
    }

}
