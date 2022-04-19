package ru.sberbank.jpafinalproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.jpafinalproject.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    void deleteByLogin(String login);

    User findUserByLogin(String login);

    User findUserById(Long id);

    User findUserByName(String name);
}
