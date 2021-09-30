package projectFiles.entity;


public abstract class BaseEntity {
    private Integer id;

    public BaseEntity(Integer id) {
        this.id = id;
    }

    /**
     * Setter for private field id
     * @param id the id of class that extends BaseEntity
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for private field id
     * @return id of the class that extends BaseEntity
     */
    public Integer getId() {
        return id;
    }
}
