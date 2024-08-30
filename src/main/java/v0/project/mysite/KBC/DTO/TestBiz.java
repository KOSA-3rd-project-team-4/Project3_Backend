package v0.project.mysite.KBC.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Data
@Getter
@Setter

public class TestBiz {
    private int id;
    private String username;
    private String password;
}