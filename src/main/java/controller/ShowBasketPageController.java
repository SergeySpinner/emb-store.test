package controller;

import entity.Basket;
import service.BasketService;
import service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowBasketPageController implements Controller{

    private BasketService basketService = new BasketService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        Integer userId = (Integer) req.getSession().getAttribute("userId");

        Basket basket = basketService.getUsersBasket(userId);

        req.setAttribute("basket", basket.getBasketList());
        req.setAttribute("productIds",basket.getProductIdList());

        return new ControllerResultDto("basket");
    }
}
