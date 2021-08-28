package projectFiles.controller;

import projectFiles.entity.Product;
import projectFiles.service.BasketService;
import projectFiles.service.ProductService;
import projectFiles.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class DeleteBasketItemController implements Controller {
    private final BasketService basketService = new BasketService();
    private final ProductService productService = new ProductService();
    private final ShowBasketPageController sbpc = new ShowBasketPageController();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Integer basketProductId = Integer.parseInt(req.getParameter("productId"));
            basketService.deleteProductPosition(basketProductId);

            List<Product> products = productService.findAll();

            req.setAttribute("products", products);

            return sbpc.execute(req, resp);
        } catch (ServiceException e) {
            return new ControllerResultDto("error-500");
        }
    }
}
