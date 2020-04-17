package model;

import sun.security.util.Password;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "guest")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String first_name;
    private String last_name;
    @Size(min = 9,max = 9)
    private Date date_of_birth;
    @Email
    private String mail;
    private int phone;
    private String add_info;

    private Password password;
    private boolean verified;


    public Guest() {
    }

    public Guest(String first_name, String last_name, Date date_of_birth, String mail, int phone, String add_info, Password password, boolean verified) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.mail = mail;
        this.phone = phone;
        this.add_info = add_info;
        this.password = password;
        this.verified = verified;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
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
                ", password=" + password +
                ", verified=" + verified +
                '}';
    }
}
