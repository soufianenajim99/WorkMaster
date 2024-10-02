package Models;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String post;
    private Departement departement;

    public Employee() {
    }

    public Employee(int id, String name, String email, String phone, String post, Departement departement) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.post = post;
        this.departement = departement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}
