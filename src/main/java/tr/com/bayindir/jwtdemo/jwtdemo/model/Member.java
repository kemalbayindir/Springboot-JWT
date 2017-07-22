package tr.com.bayindir.jwtdemo.jwtdemo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by kemalbayindir on 21/07/2017.
 */
@Data
@Entity
@Getter
@Setter
@Table(name = "MEMBERS")
public class Member implements Serializable {
    @Id
    private Integer id;
    private String email;
    private String password;
    private String roles;

    public Member() { }

    public Member(Integer id, String email, String password, String roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
