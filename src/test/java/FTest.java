//import org.junit.*;
//import projectFiles.entity.Product;
//import projectFiles.service.ProductService;
//import projectFiles.service.exception.ServiceException;
//
//import static org.junit.Assert.assertEquals;
//
//public class FTest {
//    private ProductService productService;
//    @Before
//    public void before(){
//        productService = new ProductService();
//    }
//    @Test
//    public void ProductService_FindById_Test() throws ServiceException {
//        Product product = productService.findById(2);
//        Product comparableProduct = new Product(2,"Shirt",2200,5,"Summer type");
//
//        assertEquals(product.getName(),comparableProduct.getName());
//        assertEquals(product.getPrice(), comparableProduct.getPrice());
//        assertEquals(product.getProdInfo(),comparableProduct.getProdInfo());
//        assertEquals(product.getProdQuantity(), comparableProduct.getProdQuantity());
//    }
//}
