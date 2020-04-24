package hotel.model;



import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "guests")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;

    private String last_name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_of_birth;


    private String mail;

    private int phone;

    private String add_info;

    private String password;

    private boolean verified;

    @ManyToMany(mappedBy = "guest",fetch = FetchType.EAGER)
    private List<Reservation> reservation;

    @Max(1)
    private int online;


    public Guest() {
    }

    public Guest(String first_name, String last_name, Date date_of_birth, String mail, int phone, String add_info, String password, boolean verified) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.mail = mail;
        this.phone = phone;
        this.add_info = add_info;
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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAdd_info() {
        return add_info;
    }

    public void setAdd_info(String add_info) {
        this.add_info = add_info;
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

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", mail='" + mail + '\'' +
                ", phone=" + phone +
                ", add_info='" + add_info + '\'' +
                ", password='" + password + '\'' +
                ", verified=" + verified +
                ", reservation=" + reservation +
                ", online=" + online +
                '}';
    }
}
