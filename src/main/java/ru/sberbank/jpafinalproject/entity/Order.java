package ru.sberbank.jpafinalproject.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "theme", nullable = false)
    private String theme;
    @Column(name = "subject", nullable = false)
    private String subject;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = true)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "specialist_id", nullable = true)
    private Specialist inWork;

    @ManyToMany(mappedBy = "offered")
    private Set<Specialist> offeredSpecialist;

    @Column(name = "price", nullable = false)
    private double price;


    @Transient
    private Chat chat;

    public Order() {
    }

    public void addOfferedSpecialist(Specialist specialist) {
        offeredSpecialist.add(specialist);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Specialist getInWork() {
        return inWork;
    }

    public void setInWork(Specialist inWork) {
        this.inWork = inWork;
    }

    public Set<Specialist> getOfferedSpecialist() {
        return offeredSpecialist;
    }

    public void setOfferedSpecialist(Set<Specialist> offeredSpecialist) {
        this.offeredSpecialist = offeredSpecialist;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.price, price) == 0 && id.equals(order.id) && theme.equals(order.theme) && subject.equals(order.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, theme, subject, price);
    }

    @Override
    public String toString() {
        return "Order{" +
                "theme='" + theme + '\'' +
                ", subject='" + subject + '\'' +
                ", price=" + price +
                '}';
    }
}
