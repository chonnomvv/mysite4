package kr.co.bit.controller;


import kr.co.bit.service.UserService;
import kr.co.bit.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/joinform", method = RequestMethod.GET)
    public String joinform(){
        System.out.println("joinform");
        return "/user/joinform.jsp";
    }
    @RequestMapping(value = "/join",method = RequestMethod.GET)
    public String join(@ModelAttribute UserVO userVO){
        userService.join(userVO);
        System.out.println("this is user-join");
        System.out.println(userVO.toString());
        return "redirect:/main";
    }
    @RequestMapping(value = "/loginform",method = RequestMethod.GET)
    public String loginform(){
        System.out.println("loginform");
        return "/user/loginform.jsp";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        HttpSession session){

        UserVO authUser =userService.login(email, password);
        System.out.println("로그인 서비스 다녀와서 다시 컨트롤러");

        if(authUser !=null){
            session.setAttribute("authUser", authUser);
            System.out.println(authUser.toString());
            return "redirect:/main";
        }else{
            return "redirect:/user/loginform";
        }

    }
    @RequestMapping(value = "/modifyform", method = RequestMethod.GET)
    public String modifyform(@ModelAttribute UserVO userVO,Model model,HttpSession session){
        System.out.println("modifyform");

        userVO = (UserVO) session.getAttribute("authUser");
        System.out.println(userVO.toString());
        return "/user/modifyform.jsp";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modify(@ModelAttribute UserVO userVO,@RequestParam("name") String name,HttpSession session ){
        System.out.println("userService.modify 가기전");
        System.out.println(userVO.toString());
        userService.modify(userVO);

        System.out.println("수정 값들 입력 받고 서비스로 넘김");
        return "redirect:/main";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session){
        System.out.println("log-out 하러 오셨습네까");

        session.invalidate();
        return "redirect:/main";
    }
}
