package kr.co.bit.controller;


import kr.co.bit.service.BoardService;
import kr.co.bit.vo.BoardVO;
import kr.co.bit.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "board")
public class BoardController {

    @Autowired
    BoardService boardService;
    BoardVO boardVO;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        System.out.println("보드 리스트");
        List<BoardVO> list = boardService.getList();
        model.addAttribute("list", list);
        System.out.println("다 다녀오고 jsp 부리기 직전");
        System.out.println(list.toString());
        return "/board/list.jsp";
    }

    @RequestMapping(value = "/writeform", method = RequestMethod.GET)
    public String writeForm() {

        return "/board/write.jsp";
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String write(@RequestParam("content") String content, @RequestParam("title") String title, HttpSession session, Model model) {
        System.out.println("board_write" + content + "==" + title);
        UserVO authUser = (UserVO) session.getAttribute("authUser");
        model.addAttribute("authUser", authUser);
        int no = authUser.getNo();
        HashMap<String, Object> map = new HashMap<>();
        map.put("content", content);
        map.put("title", title);
        map.put("no", no);
        boardService.write(map);
        return "redirect:/board/list";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(@RequestParam("no") int no, Model model) {
        System.out.println((no + "번 글 읽기 위한 view 컨트롤러 들어옴"));
        model.addAttribute("list", boardService.view(no));
        return "/board/view.jsp";
    }

    @RequestMapping(value = "/modifyform", method = RequestMethod.GET)
    public String modifyform(@RequestParam("no") int no,Model model) {
        BoardVO vo = boardService.view(no);
        System.out.println(no + "글번호입니다. 나 일단 나와야해요");
        model.addAttribute("vo",vo);
        return "/board/modify.jsp";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modify(@ModelAttribute BoardVO boardVO,@RequestParam("title") String title, @RequestParam("content") String content){
        boardService.modify(boardVO);
        return "redirect:/board/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@ModelAttribute BoardVO boardVO, @RequestParam("user_no") int user_no, HttpSession session,@RequestParam("no")int no){
        UserVO userVO = (UserVO) session.getAttribute("authUser");
        System.out.println("세션값" + userVO.getNo());
        System.out.println("VO값"+boardVO.getUser_no());
        System.out.println(user_no+"글의 유저번호");
        if(user_no==userVO.getNo()){
            boardService.delete(no);
        }
        return "redirect:/board/list";
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public String find(@ModelAttribute BoardVO boardVO, @RequestParam("kwd") String kwd){
        boardService.find(kwd);
        return "/board/list.jsp";
    }
}
