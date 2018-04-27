package kr.co.bit.dao;


import kr.co.bit.vo.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDAO {

    @Autowired
    private SqlSession sqlSession;

    public int insert(UserVO userVO) {

        return sqlSession.insert("user.insert", userVO);

    }

    public UserVO getUser(String email, String password) {
        Map<String, String> userMap = new HashMap<String, String>();
        userMap.put("email", email);
        userMap.put("password", password);
        return sqlSession.selectOne("user.selectUserByEmailPw", userMap);
    }

    public void modify(@ModelAttribute UserVO userVO ) {
        System.out.println("33333"+userVO.toString());
        sqlSession.update("user.modify", userVO);

    }
}
