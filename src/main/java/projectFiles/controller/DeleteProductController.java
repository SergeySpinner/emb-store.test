package projectFiles.controller;

import projectFiles.entity.Product;
import projectFiles.service.ProductService;
import projectFiles.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeleteProductController implements Controller{
    private final ShopController shopController = new ShopController();
    private final ProductService productService = new ProductService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, IOException {
        try {
            String productId = req.getParameter("productId");
            Product product = productService.findById(Integer.parseInt(productId));
            productService.delete(product);

            List<Product> products = productService.findAll();
            req.setAttribute("products", products);

            return shopController.execute(req, resp);
        } catch (ServiceException e) {
            return new ControllerResultDto("error-500");
        }
    }
}
