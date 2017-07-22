package tr.com.bayindir.jwtdemo.jwtdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.bayindir.jwtdemo.jwtdemo.model.MemberInfo;
import tr.com.bayindir.jwtdemo.jwtdemo.service.MemberService;

import java.util.List;

/**
 * Created by kemalbayindir on 21/07/2017.
 */
@RestController
@RequestMapping("/api/home")
public class MemberController {

    @Autowired
    MemberService memberService;

    @RequestMapping("/members")
    public List<MemberInfo> index() {
        return memberService.findAll();
    }

}
