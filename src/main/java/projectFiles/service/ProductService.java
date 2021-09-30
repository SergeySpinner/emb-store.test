package projectFiles.service;

import projectFiles.entity.Product;
import projectFiles.service.exception.ServiceException;

import java.util.List;

public interface ProductService {
    /**
     * Function that gets all existed products
     *
     * @return list of all products
     */
    List<Product> findAll() throws ServiceException;

    /**
     * Function that receives product from DataBase by id
     *
     * @param productId product id
     * @return product according to id
     */
    Product findById(Integer productId) throws ServiceException;

    /**
     * Function that deletes product from DataBase
     *
     * @param product prepared object of Product class
     */
    void delete(Product product) throws ServiceException;
}
