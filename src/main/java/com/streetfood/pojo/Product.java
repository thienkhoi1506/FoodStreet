package com.streetfood.pojo;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "product", schema = "streetfood")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private long id;
    @Basic
    @Column(name = "Name")
    @NotNull(message = "{product.name.err}")
    private String name;
    @Basic
    @Column(name = "Type")
    private String type;
    @Basic
    @Column(name = "Price")
    @Min(value = 10000, message = "{product.price.minErr}")
    @Max(value = 10000000, message = "{product.price.maxErr}")
    private BigDecimal price;
    @Basic
    @Column(name = "Image")
    private String image;
    @Basic
    @Column(name = "CreationTime")
    private Timestamp creationTime;
    @Basic
    @Column(name = "LastModificationTime")
    private Timestamp lastModificationTime;
    @Basic
    @Column(name = "IsDeleted")
    private Boolean isDeleted;
    @Basic
    @Column(name = "DeletionTime")
    private Timestamp deletionTime;
    @OneToMany(mappedBy = "productByProductId")
    private Set<OrderDetail> orderDetailsById;
    @ManyToOne
    @JoinColumn(name = "RestaurantId", referencedColumnName = "Id")
    private Restaurant restaurantByRestaurantId;
    @ManyToOne
    @JoinColumn(name = "CategoryId", referencedColumnName = "Id")
    private Category categoryByCategoryId;

    @Transient
    private MultipartFile img;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

        Product product = (Product) o;

        if (id != product.id) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (type != null ? !type.equals(product.type) : product.type != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (image != null ? !image.equals(product.image) : product.image != null) return false;
        if (creationTime != null ? !creationTime.equals(product.creationTime) : product.creationTime != null)
            return false;
        if (lastModificationTime != null ? !lastModificationTime.equals(product.lastModificationTime) : product.lastModificationTime != null)
            return false;
        if (isDeleted != null ? !isDeleted.equals(product.isDeleted) : product.isDeleted != null) return false;
        if (deletionTime != null ? !deletionTime.equals(product.deletionTime) : product.deletionTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (creationTime != null ? creationTime.hashCode() : 0);
        result = 31 * result + (lastModificationTime != null ? lastModificationTime.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (deletionTime != null ? deletionTime.hashCode() : 0);
        return result;
    }

    public Set<OrderDetail> getOrderDetailsById() {
        return orderDetailsById;
    }

    public void setOrderDetailsById(Set<OrderDetail> orderDetailsById) {
        this.orderDetailsById = orderDetailsById;
    }

    public Restaurant getRestaurantByRestaurantId() {
        return restaurantByRestaurantId;
    }

    public void setRestaurantByRestaurantId(Restaurant restaurantByRestaurantId) {
        this.restaurantByRestaurantId = restaurantByRestaurantId;
    }

    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }
}
