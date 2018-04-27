package kr.co.bit.service;


import kr.co.bit.dao.UserDAO;
import kr.co.bit.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public int join(UserVO userVO) {
        return userDAO.insert(userVO);
    }

    public UserVO login(String email, String password){
         return userDAO.getUser(email, password);

    }

    public void modify(@ModelAttribute UserVO userVO){
        System.out.println("서비스입니다.(수정)");
        System.out.println("2222"+userVO.toString());
         userDAO.modify(userVO);

    }
}



