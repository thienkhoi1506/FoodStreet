package com.streetfood.service.implementations;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.streetfood.pojo.Product;
import com.streetfood.repository.interfaces.ProductRepository;
import com.streetfood.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProduct(Map<String, String> params, int page) {
        return this.productRepository.getProduct(params, page);
    }

    @Override
    public int countProduct() {
        return this.productRepository.countProduct();
    }

    @Override
    public Product getProductById(int id) {
        return this.productRepository.getProductById(id);
    }

    @Override
    public boolean addProduct(Product product) {
        try {
            //Upload img
            Map r = this.cloudinary.uploader().upload(product.getImg().getBytes(),
                    ObjectUtils.asMap("resouce_type", "auto"));

            //Lấy img lưu xuống csdl
            product.setImage((String) r.get("secure_url"));
            //Lưu vào repos
            return this.productRepository.addProduct(product);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        return this.productRepository.deleteProduct(id);
    }


}
