package ddinggeunmarket_service.jpa.user;


import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDTO {

    public UserDTO(String id, String password, String phoneNumb, String dob, String email, String address, String name) {
        this.setId(id);
        this.setPassword(password);
        this.setPhoneNumb(phoneNumb);
        this.setDob(dob);
        this.setEmail(email);
        this.setAddress(address);
        this.setName(name);
    }

    private String id;
    private String phoneNumb;
    private String password;
    private String dob;
    private String email;
    private String address;
    private String name;
}
