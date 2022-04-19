package ru.sberbank.jpafinalproject.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Specialist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "specialist_user",
            joinColumns = {@JoinColumn(name = "specialist_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    private User user;

    @OneToMany(mappedBy = "inWork")
    private Set<Order> inWork = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "offered_order",
            joinColumns = {@JoinColumn(name = "specialist_id")},
            inverseJoinColumns = {@JoinColumn(name = "order_id")}
    )
    private Set<Order> offered = new HashSet<>();


    public Specialist() {
    }

    public void addOffer(Order order) {
        offered.add(order);
    }

    public Specialist(User user) {
        this.user = user;
    }

    public Set<Order> getOffered() {
        return offered;
    }

    public void setOffered(Set<Order> offered) {
        this.offered = offered;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Order> getInWork() {
        return inWork;
    }

    public void setInWork(Set<Order> inWork) {
        this.inWork = inWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialist that = (Specialist) o;
        return id.equals(that.id) && user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user);
    }

    @Override
    public String toString() {
        return "Specialist{" +
                "id=" + id +
                ", user=" + user +
                ", in work =" + inWork + '\'' +
                '}';
    }
}
