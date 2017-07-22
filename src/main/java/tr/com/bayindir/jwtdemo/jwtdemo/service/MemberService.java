package tr.com.bayindir.jwtdemo.jwtdemo.service;

import tr.com.bayindir.jwtdemo.jwtdemo.model.Member;
import tr.com.bayindir.jwtdemo.jwtdemo.model.MemberInfo;

import java.util.List;

/**
 * Created by kemalbayindir on 21/07/2017.
 */
public interface MemberService {
    List<MemberInfo> findAll();
    Member findByEmail(String email);
}
