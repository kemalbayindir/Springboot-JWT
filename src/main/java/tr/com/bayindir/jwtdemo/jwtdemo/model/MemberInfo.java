package tr.com.bayindir.jwtdemo.jwtdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by kemalbayindir on 21/07/2017.
 */
@Data
@Getter
@Setter
@AllArgsConstructor
public class MemberInfo {
    private Integer id;
    private String email;
    private String roles;
}
