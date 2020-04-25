package hotel.model;



import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "guests")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Prosze podac nazwisko")
    @NotBlank
    private String firstName;
    @NotNull(message = "Prosze podac nazwisko")
    @NotBlank
    private String lastName;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @Email
    private String mail;

    @Pattern(regexp="^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$")
    private String phone;

    private String addInfo;
    @NotNull
    @NotBlank
    private String password;

    private boolean verified;

    @ManyToMany(mappedBy = "guest",fetch = FetchType.EAGER)
    private List<Reservation> reservation;

    @Max(1)
    private int online;


    public Guest() {
    }

    public Guest(String first_name, String lastName, Date dateOfBirth, String mail, String phone, String addInfo, String password, boolean verified) {
        this.firstName = first_name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.mail = mail;
        this.phone = phone;
        this.addInfo = addInfo;
        this.password = password;
        this.verified = verified;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date date_of_birth) {
        this.dateOfBirth = date_of_birth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String  getPhone() {
        return phone;
    }

    public void setPhone(String  phone) {
        this.phone = phone;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String add_info) {
        this.addInfo = add_info;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }



}
