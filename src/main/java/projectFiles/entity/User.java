package projectFiles.entity;

import projectFiles.entity.spring.UserRole;

public class User extends BaseEntity {
    private String userName;
    private UserRole role;
    private String mailContact;
    private String login;
    private String password;

    /**
     * Constructor that takes user's id, user's name, user's role, mail address of user, user's login and password
     *
     * @param id          user's id
     * @param userName    the name of user
     * @param role        user's role
     * @param mailContact user's mail address
     * @param login       user's login
     * @param password    the password of user
     */
    public User(Integer id, String userName, String role, String mailContact, String login, String password) {
        super(id);
        this.userName = userName;
        this.setRole(role);
        this.mailContact = mailContact;
        this.login = login;
        this.password = password;
    }

    /**
     * Getter for private field login
     *
     * @return user's login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Setter for private field login
     *
     * @param login user's login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Getter for private field password
     *
     * @return the password of user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for private field password
     *
     * @param password the password of user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for private field userName
     *
     * @return the name of user
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter for private field userName
     *
     * @param userName the name of user
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Getter for private field role
     *
     * @return the user's role
     */
    public UserRole getRole() {
        return role;
    }

    /**
     * Setter for private field role
     *
     * @param role user's role
     */
    public void setRole(String role) {
        if (role.equals(UserRole.ADMIN.toString()))
            this.role = UserRole.ADMIN;
        else if (role.equals(UserRole.MANUFACTURER.toString()))
            this.role = UserRole.MANUFACTURER;
        else this.role = UserRole.USER;
    }

    /**
     * Getter for private field mailContact
     *
     * @return the user's mail address
     */
    public String getMailContact() {
        return mailContact;
    }

    /**
     * Setter for private field mailContact
     *
     * @param mailContact the user's mail address
     */
    public void setMailContact(String mailContact) {
        this.mailContact = mailContact;
    }

    /**
     * Function for interpreting a class object as a string
     *
     * @return the information string about the object
     */
    @Override
    public String toString() {
        return "User{id=" + getId() +
                ",username=" + getUserName() +
                ",role=" + getRole() +
                ",mailcontact=" + getMailContact() +
                ",login=" + getLogin() +
                ",password=" + getPassword() + '}';
    }

}