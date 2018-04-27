package kr.co.bit.controller;


import kr.co.bit.dao.GuestBookDAO;
import kr.co.bit.service.GuestBookService;
import kr.co.bit.vo.GuestBookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/guestbook")
public class GuestBookController {

    @Autowired
    private GuestBookDAO guestBookDAO;
    @Autowired
    GuestBookService guestBookService;

    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public String list(Model model){
        System.out.println("게스트북 리스트 들어옴");
        List<GuestBookVO> list = guestBookService.getList();

        System.out.println("게스트북 서비스 겟리스트 끝나고 옴. 난 게스트북 컨트롤러에 있어");

        model.addAttribute("list",list);
        return "/guestbook/list.jsp";
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String write(@ModelAttribute GuestBookVO guestBookVO){
        System.out.println("게스트북 write 들어옴");
        guestBookService.write(guestBookVO);
        return "redirect:/guestbook/list";
    }

    @RequestMapping(value = "/deleteform", method = RequestMethod.GET)
    public String deleteform(@RequestParam("no") String no){

        return "/guestbook/deleteform.jsp";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute GuestBookVO guestBookVO){
        guestBookService.delete(guestBookVO);
        return "redirect:/guestbook/list";
    }
}
