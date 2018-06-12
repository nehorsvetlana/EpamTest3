package entities;

import com.epam.commons.DataClass;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User extends DataClass {
    public String name = "epam";
    public String password = "1234";

    public User() {

    }
}