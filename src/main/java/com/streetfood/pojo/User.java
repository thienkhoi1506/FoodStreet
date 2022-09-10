package com.streetfood.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "user", schema = "streetfood")
public class User {
    public static final String Admin = "Admin";
    public static final String User = "User";
    public static final String Owner = "Owner";
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private long id;
    @Basic
    @Column(name = "FirstName")
    private String firstName;
    @Basic
    @Column(name = "LastName")
    private String lastName;
    @Basic
    @Column(name = "UserName")
    private String username;
    @Basic
    @Column(name = "Password")
    @JsonIgnore
    private String password;
    @Basic
    @Column(name = "AvatarUrl")
    private String avatarUrl;
    @Basic
    @Column(name = "EmailAddress")
    @UniqueElements
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")
    private String emailAddress;
    @Basic
    @Column(name = "Role")
    private String role;
    @Basic
    @Column(name = "CreationTime")
    @JsonIgnore
    private Timestamp creationTime;
    @Basic
    @Column(name = "LastModificationTime")
    @JsonIgnore
    private Timestamp lastModificationTime;
    @Basic
    @Column(name = "IsDeleted")
    @JsonIgnore
    private boolean isDeleted;
    @Basic
    @Column(name = "DeletionTime")
    @JsonIgnore
    private Timestamp deletionTime;
    @OneToMany(mappedBy = "userByUserId")
    private Set<Order> ordersById;
    @OneToMany(mappedBy = "userByUserId")
    private Set<Usercomment> usercommentsById;

    @Transient
    private String confirmPassword;

    @Transient
    private MultipartFile avtarImg;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Timestamp getLastModificationTime() {
        return lastModificationTime;
    }

    public void setLastModificationTime(Timestamp lastModificationTime) {
        this.lastModificationTime = lastModificationTime;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Timestamp getDeletionTime() {
        return deletionTime;
    }

    public void setDeletionTime(Timestamp deletionTime) {
        this.deletionTime = deletionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (isDeleted != user.isDeleted) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (avatarUrl != null ? !avatarUrl.equals(user.avatarUrl) : user.avatarUrl != null) return false;
        if (emailAddress != null ? !emailAddress.equals(user.emailAddress) : user.emailAddress != null) return false;
        if (role != null ? !role.equals(user.role) : user.role != null) return false;
        if (creationTime != null ? !creationTime.equals(user.creationTime) : user.creationTime != null) return false;
        if (lastModificationTime != null ? !lastModificationTime.equals(user.lastModificationTime) : user.lastModificationTime != null)
            return false;
        if (deletionTime != null ? !deletionTime.equals(user.deletionTime) : user.deletionTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (avatarUrl != null ? avatarUrl.hashCode() : 0);
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (creationTime != null ? creationTime.hashCode() : 0);
        result = 31 * result + (lastModificationTime != null ? lastModificationTime.hashCode() : 0);
        result = 31 * result + (isDeleted ? 1 : 0);
        result = 31 * result + (deletionTime != null ? deletionTime.hashCode() : 0);
        return result;
    }

    public Set<Order> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Set<Order> ordersById) {
        this.ordersById = ordersById;
    }

    public Set<Usercomment> getUsercommentsById() {
        return usercommentsById;
    }

    public void setUsercommentsById(Set<Usercomment> usercommentsById) {
        this.usercommentsById = usercommentsById;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public MultipartFile getAvtarImg() {
        return avtarImg;
    }

    public void setAvtarImg(MultipartFile avtarImg) {
        this.avtarImg = avtarImg;
    }
}
