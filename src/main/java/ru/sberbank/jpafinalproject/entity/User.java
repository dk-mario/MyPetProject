package ru.sberbank.jpafinalproject.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "city")
    private String city;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "bio")
    private String bio;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE})
    private Set<Role> roles = new HashSet<>();

    @OneToOne(mappedBy = "user")
    private Customer customer;

    @Transient
    private String role;


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {

        this.role = role;

        roles.add(new Role(role, this));
    }

    public User() {
    }

    public User(Long id, String name, String login, int age, String city, String password, String role) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.age = age;
        this.city = city;
        this.password = password;
        setRole(role);
    }

    public User(String name, int age, String city, String password) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.password = password;

    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User(Long id, String name, String login, int age, String city, String password, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.age = age;
        this.city = city;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && id.equals(user.id) && name.equals(user.name) && login.equals(user.login) && Objects.equals(city, user.city) && password.equals(user.password) && Objects.equals(roles, user.roles);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, age, city, password, bio);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
