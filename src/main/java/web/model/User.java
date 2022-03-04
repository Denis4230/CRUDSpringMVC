package web.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(name = "name")
    @Size(min = 2, max = 30, message = "Имя должно быть не меньше двух симводов и не больше 30")
    public String name;

    @Column(name = "lastName")
    public String lastName;

    @Column(name = "age")
    @Min(value = 0, message = "Возраст человека не может быть отрицательным")
    public int age;

    @Column(name = "email")
    @Email(message = "Введите корректный Email")
    public String email;

    public User(String name, String lastName, int age, String email) {
        this.setLastName(name);
        this.setLastName(lastName);
        this.setAge(age);
        this.setEmail(email);
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User - " + "id = " + id + ", name = " + name + ", lastName = " + lastName + ", age = " + age + ", email = " + email;
    }
}
