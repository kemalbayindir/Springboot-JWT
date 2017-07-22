package tr.com.bayindir.jwtdemo.jwtdemo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tr.com.bayindir.jwtdemo.jwtdemo.model.Member;

/**
 * Created by kemalbayindir on 21/07/2017.
 */
@Repository
public interface MemberDao extends CrudRepository<Member, Integer> {

    Member findByEmail(String email);

}