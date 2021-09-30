package projectFiles.entity;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private BasketState basketState;
    private List<Integer> idList = new ArrayList<>();
    private List<Product> basketList = new ArrayList<>();
    private Integer priceOfBasket;
    private Integer buyerId;

    /**
     * Constructor that takes state of basket, array list of products and user's id
     *
     * @param basketState the state of basket that can be ON_AGREEMENT or CONFIRMED
     * @param basketList  the user's list of products
     * @param buyerId     products owner id
     */
    public Basket(String basketState, List<Product> basketList, Integer buyerId) {
        this.setBasketState(basketState);
        this.basketList = basketList;
        this.setPriceOfBasket(basketList);
        this.buyerId = buyerId;
    }

    /**
     * Constructor that takes state of basket, one product and user's id
     *
     * @param basketState the state of basket that can be ON_AGREEMENT or CONFIRMED
     * @param product     the user's product
     * @param buyerId     product owner id
     */
    public Basket(String basketState, Product product, Integer buyerId) {
        this.setBasketState(basketState);
        this.buyerId = buyerId;
        this.addToBasketList(product);
    }

    public Basket() {
    }

    /**
     * Function for adding a new product to basket list
     *
     * @param product the product that should be added to the basketList
     */
    public void addToBasketList(Product product) {
        this.basketList.add(product);
    }

    /**
     * Function for adding a new product by his id
     *
     * @param productId the id of product that should be added to the basketList
     */
    public void addToIdList(Integer productId) {
        this.idList.add(productId);
    }

    /**
     * Getter for private field basketState
     *
     * @return the state of basket that can be ON_AGREEMENT or CONFIRMED
     */
    public BasketState getBasketState() {
        return basketState;
    }

    /**
     * Setter for private field basketState
     *
     * @param basketState the state of user's basket
     */
    public void setBasketState(String basketState) {
        if (basketState.equals(BasketState.CONFIRMED.toString()))
            this.basketState = BasketState.CONFIRMED;
        else this.basketState = BasketState.ON_AGREEMENT;
    }

    /**
     * Getter for private field basketList
     *
     * @return the list of products in basket
     */
    public List<Product> getBasketList() {
        return basketList;
    }

    /**
     * Setter for private field basketList
     *
     * @param basketList the prepared list of products
     */
    public void setBasketList(List<Product> basketList) {
        this.basketList = basketList;
    }

    /**
     * Getter for private field priceOfBasket
     *
     * @return the actual price of basket
     */
    public Integer getPriceOfBasket() {
        return priceOfBasket;
    }

    /**
     * Function for calculation of baskets actual price
     *
     * @param basketList the prepared list of products
     */
    private void setPriceOfBasket(List<Product> basketList) {
        Integer sum = 0;
        for (Product product : basketList)
            sum += product.getPrice();
        this.priceOfBasket = sum;
    }

    /**
     * Function for calculation of basket's actual price
     */
    public void setPriceOfBasket() {
        Integer sum = 0;
        for (Product product : this.basketList)
            sum += product.getPrice();
        this.priceOfBasket = sum;
    }

    /**
     * Getter for private field buyerId
     *
     * @return user's id
     */
    public Integer getBuyerId() {
        return buyerId;
    }

    /**
     * Setter for private field buyerId
     *
     * @param buyerId user's id
     */
    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    /**
     * Getter for private field idList
     *
     * @return id list of products
     */
    public List<Integer> getIdList() {
        return idList;
    }

    /**
     * Function for interpreting a class object as a string
     *
     * @return the information string about the object
     */
    @Override
    public String toString() {
        return "Basket{" +
                "basketState=" + basketState +
                ", basketList=" + basketList.toString() +
                ", priceOfBasket=" + priceOfBasket +
                ", buyerId=" + buyerId +
                '}';
    }
}
