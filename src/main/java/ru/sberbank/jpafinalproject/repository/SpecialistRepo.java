package ru.sberbank.jpafinalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.jpafinalproject.entity.Order;
import ru.sberbank.jpafinalproject.entity.Specialist;

import java.util.List;

@Repository
public interface SpecialistRepo extends JpaRepository<Specialist, Long> {

    List<Specialist> findAll();

    Specialist findSpecialistByUserId(long id);

    Specialist findSpecialistById(long id);



}
