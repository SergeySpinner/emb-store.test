package projectFiles.controller;

import projectFiles.entity.Basket;
import projectFiles.entity.Product;
import projectFiles.service.impl.BasketServiceImpl;
import projectFiles.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;

public class ShowBasketPageController implements Controller {

    private BasketServiceImpl basketServiceImpl = new BasketServiceImpl();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        try {
            Integer userId = (Integer) req.getSession().getAttribute("userId");

            Basket basket = basketServiceImpl.getUsersBasket(userId);

            Iterator<Product> productIterator = basket.getBasketList().iterator();
            Iterator<Integer> idIterator = basket.getIdList().iterator();
            HashMap<Integer, Product> productMap = new HashMap<>();

            while (productIterator.hasNext() && idIterator.hasNext())
                productMap.put(idIterator.next(), productIterator.next());

            req.setAttribute("map", productMap);

            return new ControllerResultDto("basket");
        } catch (ServiceException e) {
            e.printStackTrace();
            return new ControllerResultDto("error-500");
        }
    }
}
