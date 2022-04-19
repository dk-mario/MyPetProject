package ru.sberbank.jpafinalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.sberbank.jpafinalproject.entity.Role;
import ru.sberbank.jpafinalproject.entity.Specialist;
import ru.sberbank.jpafinalproject.entity.User;
import ru.sberbank.jpafinalproject.repository.RoleRepository;
import ru.sberbank.jpafinalproject.repository.SpecialistRepo;
import ru.sberbank.jpafinalproject.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private SpecialistRepo specialistRepo;
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;


    /**
     * Метод на получение всех пользователей из таблицы Users.
     */
    public List<User> getAll() {
        ArrayList<User> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            users.add(user);
        }
        return users;
    }

    /**
     * Метод на создание пользователя.
     */
    public void create(User user) {
        // Получаем у пользователя пароль и кодируем его с помощью bCryptPasswordEncoder.
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        roleRepository.saveAll(user.getRoles());
        userRepository.save(user);

    }

    public User findUserById(long id) {
        return userRepository.findUserById(id);
    }

    /**
     * Метод на изменение данных пользователя в таблице users.
     */
    public User update(User user) {
        return userRepository.save(user);
    }

    /**
     * Метод на удаление пользователя по полю login.
     */
    public void deleteByLogin(String login) {
        userRepository.deleteByLogin(login);
    }

    /**
     * Метод на проверку существования пользователя с данным login в таблице users.
     */
    public boolean findByLogin(String login) {
        return userRepository.findUserByLogin(login) != null;
    }

    public User findUserByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }
}