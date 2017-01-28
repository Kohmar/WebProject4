package ua.training.entity;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */

/**
 * The entity of user
 */
public class User extends Entity {
    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = -4296812728878771179L;


    /**
     * id user.
     */
    private int id;
    /**
     * email of user.
     */
    private String email;
    /**
     * password of user.
     */
    private String password;
    /**
     * Login
     */
    private String login;
    /**
     * First name.
     */
    private String firstName;
    /**
     * last name.
     */
    private String  lastName;
    /**
     * role of user.
     */
    private String role;

    public User(){

    }

    /**
     * Getter for the id.
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for id.
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for email.
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for email.
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for password.
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for password.
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for first Name.
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for first name.
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**Getter for last name.
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for last name.
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for role.
     * @return
     */
    public String getRole() {
        return role;
    }

    /**
     * Setter for role.
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * getter for login.
     * @return
     */
    public String getLogin() {
        return login;
    }



    /**Setter for login.
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }



    @Override
    public String toString() {
        return "User [id=" + id + ", email=" + email + ", password=" + password + ", login=" + login + ", firstName="
                + firstName + ", lastName=" + lastName + ", role=" + role + "]";
    }

    /**
     * class for build class User
     */
    public static class Builder{

        private int id;
        private String email;
        private String password;
        private String login;
        private String firstName;
        private String  lastName;
        private String role;


        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public Builder setLogin(String login) {
            this.login = login;
            return this;
        }

        public User build() {
            User user = new User();
            user.setId(id);
            user.setEmail(email);
            user.setPassword(password);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setRole(role);
            user.setLogin(login);

            return user;
        }


    }

}
