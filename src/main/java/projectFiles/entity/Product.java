package projectFiles.entity;

public class Product extends BaseEntity {
    private String name;
    private Integer price;
    private Integer prodQuantity;
    private String prodInfo;
    private Integer creatorId;

    public Product(Integer id, String name, Integer price, Integer prodQuantity, String prodInfo, Integer creatorId) {
        super(id);
        this.name = name;
        this.price = price;
        this.prodQuantity = prodQuantity;
        this.prodInfo = prodInfo;
        this.creatorId = creatorId;
    }

    public Integer getProdQuantity() {
        return prodQuantity;
    }

    public void setProdQuantity(Integer prodQuantity) {
        this.prodQuantity = prodQuantity;
    }

    public String getProdInfo() {
        return prodInfo;
    }

    public void setProdInfo(String prodInfo) {
        this.prodInfo = prodInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", prodQuantity=" + prodQuantity +
                ", prodInfo='" + prodInfo + '\'' +
                ", creatorId=" + creatorId +
                '}';
    }
}
