package ddinggeunmarket_service.jpa;


import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDTO {

    private String id;
    private String name;
    private String password;
    private String phoneNumb;
    private String dob;
}
