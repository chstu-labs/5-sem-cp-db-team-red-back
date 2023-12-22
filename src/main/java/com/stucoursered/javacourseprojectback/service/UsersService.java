package com.stucoursered.javacourseprojectback.service;

import com.stucoursered.javacourseprojectback.model.Users;
import com.stucoursered.javacourseprojectback.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users getUserById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    public Users createUser(Users user) {
        return usersRepository.save(user);
    }

    public Users updateUser(Long id, Users user) {
        Users existingUser = usersRepository.findById(id).orElse(null);
        if (existingUser != null) {
            // Обновите необходимые поля
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setRoles(user.getRoles());

            return usersRepository.save(existingUser);
        } else {
            return null; // Или обработайте, как сочтете нужным
        }
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }
}
