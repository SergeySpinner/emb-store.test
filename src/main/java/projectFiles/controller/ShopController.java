package projectFiles.controller;

import projectFiles.entity.Product;
import projectFiles.entity.User;
import projectFiles.entity.UserRole;
import projectFiles.service.ProductService;
import projectFiles.service.UserService;
import projectFiles.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShopController implements Controller {

    private final ProductService productService = new ProductService();
    private final UserService userService = new UserService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {

        Integer userId = (Integer) req.getSession().getAttribute("userId");
        User user = userService.getById(userId);

        if(user.getRole() == UserRole.ADMIN) {
            List<Product> products = productService.findAll();
            req.setAttribute("products", products);

            return new ControllerResultDto("modification-shop");
        }
        else if(user.getRole() == UserRole.USER) {
            List<Product> products = productService.findAll();
            req.setAttribute("products", products);
            return new ControllerResultDto("shop-page");
        }
        else
            return new ControllerResultDto("error-403");
    }
}
