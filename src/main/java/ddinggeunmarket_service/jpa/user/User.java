package ddinggeunmarket_service.jpa.user;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    public User(UserDTO userDTO) {
        this.setId(userDTO.getId());
        this.setName(userDTO.getName());
        this.setPassword(userDTO.getPassword());
        this.setPhoneNumb(userDTO.getPhoneNumb());
        this.setDob(userDTO.getDob());
        this.setAddress(userDTO.getAddress());
        this.setEmail(userDTO.getEmail());
    }

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "PHONENUMB")
    private String phoneNumb;
    @Column(name = "DOB")
    private String dob;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "NAME")
    private String name;
}
