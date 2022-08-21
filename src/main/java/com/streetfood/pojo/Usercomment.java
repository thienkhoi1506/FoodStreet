package com.streetfood.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "usercomment", schema = "streetfood")
public class Usercomment implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private long id;
    @Basic
    @Column(name = "Comment")
    private String comment;
    @Basic
    @Column(name = "CreationTime")
    private Timestamp creationTime;
    @Basic
    @Column(name = "LastModificationTime")
    private Timestamp lastModificationTime;
    @Basic
    @Column(name = "IsDeleted")
    private byte isDeleted;
    @Basic
    @Column(name = "DeletionTime")
    private Timestamp deletionTime;
    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "Id", nullable = false)
    private User userByUserId;
    @ManyToOne
    @JoinColumn(name = "RestaurantId", referencedColumnName = "Id", nullable = false)
    private Restaurant restaurantByRestaurantId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(byte isDeleted) {
        this.isDeleted = isDeleted;
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

        Usercomment that = (Usercomment) o;

        if (id != that.id) return false;
        if (isDeleted != that.isDeleted) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (creationTime != null ? !creationTime.equals(that.creationTime) : that.creationTime != null) return false;
        if (lastModificationTime != null ? !lastModificationTime.equals(that.lastModificationTime) : that.lastModificationTime != null)
            return false;
        if (deletionTime != null ? !deletionTime.equals(that.deletionTime) : that.deletionTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (creationTime != null ? creationTime.hashCode() : 0);
        result = 31 * result + (lastModificationTime != null ? lastModificationTime.hashCode() : 0);
        result = 31 * result + (int) isDeleted;
        result = 31 * result + (deletionTime != null ? deletionTime.hashCode() : 0);
        return result;
    }

    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    public Restaurant getRestaurantByRestaurantId() {
        return restaurantByRestaurantId;
    }

    public void setRestaurantByRestaurantId(Restaurant restaurantByRestaurantId) {
        this.restaurantByRestaurantId = restaurantByRestaurantId;
    }
}
