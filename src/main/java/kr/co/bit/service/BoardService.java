package kr.co.bit.service;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import kr.co.bit.dao.BoardDAO;
import kr.co.bit.vo.BoardVO;
import kr.co.bit.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardDAO boardDAO;
    public List<BoardVO> getList(){
        return boardDAO.getList();
    }

    public int write(HashMap<String,Object> map){
        return boardDAO.write(map);
    }

    public BoardVO view(int no){
        System.out.println(boardDAO.view(no).toString());
        boardDAO.view_cnt(no);
        return boardDAO.view(no);
    }

    public int modify(@ModelAttribute BoardVO boardVO){
        System.out.println("모디파이 서비스");
        System.out.println(boardVO.toString());
        return boardDAO.modify(boardVO);
    }

    public int delete(int no){
        return boardDAO.delete(no);
    }

    public List<BoardVO> find(String kwd){
        return boardDAO.find(kwd);
    }
}
