package kr.co.bit.dao;

import kr.co.bit.vo.GuestBookVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Repository
public class GuestBookDAO {

    @Autowired
    private SqlSession sqlSession;

    public List<GuestBookVO> getList() {
        return sqlSession.selectList("guestbook.list");
    }

    public int delete(GuestBookVO guestBookVO) {
        return sqlSession.delete("guestbook.delete", guestBookVO);
    }

    public int write(GuestBookVO guestBookVO){
        System.out.println(guestBookVO.toString());
        return sqlSession.insert("guestbook.write", guestBookVO);
    }
}
