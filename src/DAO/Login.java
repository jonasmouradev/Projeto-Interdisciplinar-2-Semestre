package DAO;

public class Login {

    private int id;
    private String name;
    private String password;

    //Constructor Method
    public Login() {
        this.name = null;
        this.password = null;

    }
    public Login(String nome, String senha) {
        this.name = nome;
        this.password = senha;

    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
