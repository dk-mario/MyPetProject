package ru.sberbank.jpafinalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.jpafinalproject.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerByUserId(Long id);

    Customer findCustomerById(Long id);

}
