package Mabayahomeexam.dao;

import Mabayahomeexam.model.Product;

import java.util.List;
import java.util.UUID;

public interface SellerDao {
    int addSeller(UUID id);

    default int addSeller(){
        UUID id = UUID.randomUUID();
        return addSeller(id);
    }

    List<Product> getSellerProducts(UUID id);

    List<String> getSellerProductsCategories(UUID id);

    int removeSellerProduct(UUID sellerId, UUID productId);

}
