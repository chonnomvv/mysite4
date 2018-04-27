package kr.co.bit.dao;


import kr.co.bit.vo.BoardVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.List;

@Repository
public class BoardDAO {
    @Autowired
    private SqlSession sqlSession;

    public List<BoardVO> getList() {

        return sqlSession.selectList("board.getList");
    }

    public int write(HashMap<String,Object> map){
//        System.out.println(title+"'"+content+"'"+authUser.getNo());
        return sqlSession.insert("board.write",map);
    }

    public BoardVO view(int no){
        return sqlSession.selectOne("board.view",no);
    }

    public int view_cnt(int no){
       return sqlSession.update("board.view_cnt",no);
    }

    public int modify(@ModelAttribute BoardVO boardVO){
        return sqlSession.update("board.modify",boardVO);
    }
    public int delete(int no){
        return sqlSession.delete("board.delete",no);
    }
    public List<BoardVO> find(String kwd){
        return sqlSession.selectOne("board.find");
    }
}
