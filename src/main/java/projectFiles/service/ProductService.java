package projectFiles.service;

import projectFiles.dao.exception.DaoException;
import projectFiles.dao.impl.ProductDaoImpl;
import projectFiles.entity.Product;
import projectFiles.service.exception.ServiceException;

import java.util.List;

public class ProductService {

    private ProductDaoImpl productDaoImpl = new ProductDaoImpl();

    public List<Product> findAll() throws ServiceException {
        try {
            List<Product> products = productDaoImpl.findAll();
            return products;
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    public Product findById(Integer productId) throws ServiceException {
        try {
            return productDaoImpl.getById(productId);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    public void delete(Product product) throws ServiceException {
        try{
            productDaoImpl.delete(product);
        } catch (DaoException e){
            throw new ServiceException();
        }
    }

    public int sumAll(List<Product> products) {
        Integer result = 0;
        for (Product product : products)
            result += product.getPrice();
        return result;
    }
}
