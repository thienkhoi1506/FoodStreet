package com.streetfood.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "order_detail", schema = "streetfood", catalog = "")
public class OrderDetail implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private long id;
    @Basic
    @Column(name = "OrderId")
    private long orderId;
    @Basic
    @Column(name = "TotalPrice")
    private BigDecimal totalPrice;
    @Basic
    @Column(name = "CreationTime")
    private Timestamp creationTime;
    @Basic
    @Column(name = "IsDeleted")
    private Boolean isDeleted;
    @Basic
    @Column(name = "DeletionTime")
    private Timestamp deletionTime;
    @ManyToOne
    @JoinColumn(name = "RestaurantId", referencedColumnName = "Id", nullable = false)
    private Restaurant restaurantByRestaurantId;
    @ManyToOne
    @JoinColumn(name = "ProductId", referencedColumnName = "Id", nullable = false)
    private Product productByProductId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
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

        OrderDetail that = (OrderDetail) o;

        if (id != that.id) return false;
        if (orderId != that.orderId) return false;
        if (totalPrice != null ? !totalPrice.equals(that.totalPrice) : that.totalPrice != null) return false;
        if (creationTime != null ? !creationTime.equals(that.creationTime) : that.creationTime != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (deletionTime != null ? !deletionTime.equals(that.deletionTime) : that.deletionTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (creationTime != null ? creationTime.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (deletionTime != null ? deletionTime.hashCode() : 0);
        return result;
    }

    public Restaurant getRestaurantByRestaurantId() {
        return restaurantByRestaurantId;
    }

    public void setRestaurantByRestaurantId(Restaurant restaurantByRestaurantId) {
        this.restaurantByRestaurantId = restaurantByRestaurantId;
    }

    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }
}
