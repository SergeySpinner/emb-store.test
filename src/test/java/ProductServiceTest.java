import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import projectFiles.dao.ProductDao;
import projectFiles.dao.exception.DaoException;
import projectFiles.entity.Product;
import projectFiles.service.ProductService;
import projectFiles.service.exception.ServiceException;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
    private ProductService productService;
    private ProductDao productDao;

    @Before
    public void before() {
        productService = new ProductService();
        productDao = mock(ProductDao.class);
    }

    @Test
    public void ProductServiceSumAllTest() throws DaoException {
        List<Product> productList = Arrays.asList(
                new Product(1, "T-shirt", 2241, 13, "Winter"),
                new Product(2, "Shirt", 2200, 5, "Summer type")
        );

        when(productDao.findAll()).thenReturn(productList);
        int sum = productService.sumAll(productList);
        assertEquals(4441, sum);
    }

    @Test
    public void getById() throws DaoException {
        Product product1 = new Product(1, "T-shirt", 2241, 13, "Winter");
        Product product2 = new Product(2, "Shirt", 2200, 5, "Summer type");

        when(productDao.getById(1)).thenReturn(product1);
        when(productDao.getById(2)).thenReturn(product2);

        Product actualProduct1 = productDao.getById(1);
        Product actualProduct2 = productDao.getById(2);

        assertEquals(product1, actualProduct1);
        assertEquals(product2, actualProduct2);
    }
}
