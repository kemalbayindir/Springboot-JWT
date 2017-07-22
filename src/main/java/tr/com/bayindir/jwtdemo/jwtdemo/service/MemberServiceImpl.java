package tr.com.bayindir.jwtdemo.jwtdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.bayindir.jwtdemo.jwtdemo.dao.MemberDao;
import tr.com.bayindir.jwtdemo.jwtdemo.model.Member;
import tr.com.bayindir.jwtdemo.jwtdemo.model.MemberInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kemalbayindir on 21/07/2017.
 */
@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberDao dao;

    public List<MemberInfo> findAll() {
        Iterable<Member> members = dao.findAll();
        List<MemberInfo> result = new ArrayList<>();
        for (Member member : members) {
            result.add(map(member));
        }
        return result;
    }

    public Member findByEmail(String email) {
        return dao.findByEmail(email);
    }

    public static MemberInfo map(Member member) {
        return new MemberInfo(Integer.valueOf(member.getId()), member.getEmail(), member.getRoles());
    }
}
