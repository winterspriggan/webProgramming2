package ddinggeunmarket_service.jpa;


import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDTO {

    private int id;
    private String phoneNumb;
    private String password;
    private String dob;
    private String email;
    private String address;
    private String name;
}
