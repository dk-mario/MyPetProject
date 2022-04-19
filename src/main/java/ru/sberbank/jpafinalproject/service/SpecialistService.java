package ru.sberbank.jpafinalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.sberbank.jpafinalproject.entity.Specialist;
import ru.sberbank.jpafinalproject.repository.SpecialistRepo;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SpecialistService {

    @Autowired
    private SpecialistRepo specialistRepo;

    public void save(Specialist specialist) {
        specialistRepo.save(specialist);
    }

    public List<Specialist> findSpecialistByBioContains(String subject) {
        List<Specialist> allSpecialist = specialistRepo.findAll();

        System.out.println(allSpecialist);

        List<Specialist> specialists = new ArrayList<>();

        for (Specialist sp : allSpecialist) {
            if (sp.getUser().getBio().contains(subject)) {
                specialists.add(sp);
            }
        }

        System.out.println(specialists);

        return specialists;
    }

    public Specialist getSpecialistByUserId(long id) {
        return specialistRepo.findSpecialistByUserId(id);
    }

    public Specialist findSpecialistById(long id) {
        return specialistRepo.findSpecialistById(id);
    }

}
