package projectFiles.entity.spring;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private Long id;
    private String name;
    private Integer price;
    @Column(name = "prodquantity")
    private Integer prodQuantity;
    @Column(name = "prodinfo")
    private String prodInfo;
}
