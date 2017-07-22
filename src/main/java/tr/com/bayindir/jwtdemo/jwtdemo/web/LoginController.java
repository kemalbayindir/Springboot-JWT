package tr.com.bayindir.jwtdemo.jwtdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tr.com.bayindir.jwtdemo.jwtdemo.model.Member;
import tr.com.bayindir.jwtdemo.jwtdemo.model.UserLoginInfo;
import tr.com.bayindir.jwtdemo.jwtdemo.security.AuthUtils;
import tr.com.bayindir.jwtdemo.jwtdemo.service.MemberService;
import tr.com.bayindir.jwtdemo.jwtdemo.service.MemberServiceImpl;

import javax.servlet.ServletException;

/**
 * Created by kemalbayindir on 21/07/2017.
 */
@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody UserLoginInfo login) throws ServletException {

        String jwtToken = "";

        if (login.getEmail() == null || login.getPassword() == null) {
            throw new ServletException("Please fill in username and password");
        }

        String password = login.getPassword();

        Member member = memberService.findByEmail(login.getEmail());

        if (member == null) {
            throw new ServletException("User email not found.");
        }

        String pwd = member.getPassword();

        if (!password.equals(pwd)) {
            throw new ServletException("Invalid login. Please check your name and password.");
        }

        member.setPassword(null);
        jwtToken = AuthUtils.generateToken(login.getEmail(), MemberServiceImpl.map(member));

        return jwtToken;
    }
}
