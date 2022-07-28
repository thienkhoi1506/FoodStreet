package com.streetfood.pojo;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "restaurant", schema = "streetfood")
public class Restaurant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private long id;
    @Basic
    @Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "Address")
    private String address;
    @Basic
    @Column(name = "Rating")
    private Integer rating;
    @Basic
    @Column(name = "Avatar")
    private String avatar;
    @Basic
    @Column(name = "Thumbnail_img")
    private String thumbnailImg;
    @Basic
    @Column(name = "TimeOpen")
    private Time timeOpen;
    @Basic
    @Column(name = "TimeClose")
    private Time timeClose;
    @Basic
    @Column(name = "CreationTime")
    private Timestamp creationTime;
    @Basic
    @Column(name = "LastModificationTime")
    private Timestamp lastModificationTime;
    @Basic
    @Column(name = "IsDeleted")
    private boolean isDeleted;
    @Basic
    @Column(name = "DeletionTime")
    private Timestamp deletionTime;
    @OneToMany(mappedBy = "restaurantByRestaurantId")
    private Set<OrderDetail> orderDetailsById;
    @OneToMany(mappedBy = "restaurantByRestaurantId")
    private Set<Product> productsById;
    @OneToMany(mappedBy = "restaurantByRestaurantId")
    private Set<Usercomment> usercommentsById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getThumbnailImg() {
        return thumbnailImg;
    }

    public void setThumbnailImg(String thumbnailImg) {
        this.thumbnailImg = thumbnailImg;
    }

    public Time getTimeOpen() {
        return timeOpen;
    }

    public void setTimeOpen(Time timeOpen) {
        this.timeOpen = timeOpen;
    }

    public Time getTimeClose() {
        return timeClose;
    }

    public void setTimeClose(Time timeClose) {
        this.timeClose = timeClose;
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

        Restaurant that = (Restaurant) o;

        if (id != that.id) return false;
        if (isDeleted != that.isDeleted) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;
        if (avatar != null ? !avatar.equals(that.avatar) : that.avatar != null) return false;
        if (thumbnailImg != null ? !thumbnailImg.equals(that.thumbnailImg) : that.thumbnailImg != null) return false;
        if (timeOpen != null ? !timeOpen.equals(that.timeOpen) : that.timeOpen != null) return false;
        if (timeClose != null ? !timeClose.equals(that.timeClose) : that.timeClose != null) return false;
        if (creationTime != null ? !creationTime.equals(that.creationTime) : that.creationTime != null) return false;
        if (lastModificationTime != null ? !lastModificationTime.equals(that.lastModificationTime) : that.lastModificationTime != null)
            return false;
        if (deletionTime != null ? !deletionTime.equals(that.deletionTime) : that.deletionTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (thumbnailImg != null ? thumbnailImg.hashCode() : 0);
        result = 31 * result + (timeOpen != null ? timeOpen.hashCode() : 0);
        result = 31 * result + (timeClose != null ? timeClose.hashCode() : 0);
        result = 31 * result + (creationTime != null ? creationTime.hashCode() : 0);
        result = 31 * result + (lastModificationTime != null ? lastModificationTime.hashCode() : 0);
        result = 31 * result + (isDeleted ? 1 : 0);
        result = 31 * result + (deletionTime != null ? deletionTime.hashCode() : 0);
        return result;
    }

    public Set<OrderDetail> getOrderDetailsById() {
        return orderDetailsById;
    }

    public void setOrderDetailsById(Set<OrderDetail> orderDetailsById) {
        this.orderDetailsById = orderDetailsById;
    }

    public Set<Product> getProductsById() {
        return productsById;
    }

    public void setProductsById(Set<Product> productsById) {
        this.productsById = productsById;
    }

    public Set<Usercomment> getUsercommentsById() {
        return usercommentsById;
    }

    public void setUsercommentsById(Set<Usercomment> usercommentsById) {
        this.usercommentsById = usercommentsById;
    }
}
