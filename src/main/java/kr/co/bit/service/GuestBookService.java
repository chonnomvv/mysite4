package kr.co.bit.service;

import kr.co.bit.dao.GuestBookDAO;
import kr.co.bit.vo.GuestBookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class GuestBookService {

    @Autowired
    GuestBookDAO guestBookDAO;

    public List<GuestBookVO> getList(){
        System.out.println("get List 서비스");
        return guestBookDAO.getList();
    }

    public int write(GuestBookVO guestBookVO){
        System.out.println("guestBook service. write 들어옴");

        return guestBookDAO.write(guestBookVO);
    }

    public int delete(GuestBookVO guestBookVO){
        System.out.println("guestBookService.delete");

        return guestBookDAO.delete(guestBookVO);
    }
}
