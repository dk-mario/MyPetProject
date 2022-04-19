package ru.sberbank.jpafinalproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sberbank.jpafinalproject.entity.Customer;
import ru.sberbank.jpafinalproject.entity.Order;
import ru.sberbank.jpafinalproject.repository.CustomerRepository;
import ru.sberbank.jpafinalproject.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;


    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }


    public List<Order> findAllOrdersByUserId(Long id) {
        Customer customer = customerRepository.findCustomerByUserId(id);
        List<Order> orders;
        try {
            orders = orderRepository.findAllByCustomerId(customer.getId());
        } catch (NullPointerException ex) {
            orders = new ArrayList<>();
        }
        return orders;
    }

    public Customer findCustomerByUserId(Long id) {
        return customerRepository.findCustomerByUserId(id);
    }

    public Order findOrderById(Long id) {
        return orderRepository.findOrderById(id);
    }

    public Customer findCustomerById(Long id) {
        return customerRepository.findCustomerById(id);
    }

}
