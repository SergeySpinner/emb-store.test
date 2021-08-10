package projectFiles.entity.spring;

import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
public class Basket {
    @Id
    private Long id;
    @Column(name = "basketstate")
    private String basketState;
    @Column(name = "userid")
    private Integer userId;
    @Column(name = "productid")
    private Integer productId;
}
