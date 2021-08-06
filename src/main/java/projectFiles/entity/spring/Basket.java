package projectFiles.entity.spring;

import projectFiles.entity.BasketState;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Basket {
    @Id
    private Long id;
    @Column(name = "basketState")
    private BasketState basketState;
    private Integer priceOfBasket;
    private Integer buyerId;
//    @ManyToMany
//    private List<Integer> idList = new ArrayList<>();
    //    private List<Product> basketList = new ArrayList<>();
}
