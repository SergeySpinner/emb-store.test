package projectFiles.entity.spring;

import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@ToString
public class Product {
    @Id
    private Integer id;
    @Column(name = "prodname")
    private String name;
    @Column(name = "price")
    private Integer price;
    @Column(name = "prodquantity")
    private Integer prodQuantity;
    @Column(name = "prodinfo")
    private String prodInfo;
}
