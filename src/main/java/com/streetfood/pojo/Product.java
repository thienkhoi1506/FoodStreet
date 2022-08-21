package com.streetfood.pojo;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "product", schema = "streetfood")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
        @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p where p.id = :id"),
        @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p where p.name = :name"),
        @NamedQuery(name = "Product.findByType", query = "SELECT p FROM Product p where p.type = :type"),
        @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p where p.price = :price"),
})
public class Product implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private long id;
    @Basic
    @NotNull
    @Column(name = "Name")
    private String name;
    @Basic
    @Null
    @Column(name = "Type")
    private String type;
    @Basic
    @Null
    @Column(name = "Price")
    private BigDecimal price;
    @Basic
    @Null
    @Column(name = "Image")
    private String image;
    @Basic
    @Null
    @Column(name = "CreationTime")
    private Timestamp creationTime;
    @Basic
    @Null
    @Column(name = "LastModificationTime")
    private Timestamp lastModificationTime;
    @Basic
    @Null
    @Column(name = "IsDeleted")
    private boolean isDeleted;
    @Basic
    @Null
    @Column(name = "DeletionTime")
    private Timestamp deletionTime;
    @OneToMany(mappedBy = "productByProductId")
    private Set<OrderDetail> orderDetailsById;
    @ManyToOne
    @JoinColumn(name = "RestaurantId", referencedColumnName = "Id", nullable = true)
    private Restaurant restaurantByRestaurantId;
    @ManyToOne
    @JoinColumn(name = "CategoryId", referencedColumnName = "Id", nullable = true)
    private Category categoryByCategoryId;

    @Transient
    private MultipartFile Img;

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

        Product product = (Product) o;

        if (id != product.id) return false;
        if (isDeleted != product.isDeleted) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (type != null ? !type.equals(product.type) : product.type != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (image != null ? !image.equals(product.image) : product.image != null) return false;
        if (creationTime != null ? !creationTime.equals(product.creationTime) : product.creationTime != null)
            return false;
        if (lastModificationTime != null ? !lastModificationTime.equals(product.lastModificationTime) : product.lastModificationTime != null)
            return false;
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
        return Img;
    }

    public void setImg(MultipartFile img) {
        Img = img;
    }
}
