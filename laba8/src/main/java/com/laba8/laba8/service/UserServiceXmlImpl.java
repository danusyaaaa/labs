package com.laba8.laba8.service;

import com.laba8.laba8.model.User;
import com.laba8.laba8.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceXmlImpl implements UserService {

    @Value("${file.xml}")
    private String fileString;

    private final UserRepo userRepo;
    private final Unmarshaller unmarshaller;
    private final Marshaller marshaller;


    @SneakyThrows
    @Override
    public User getUserById(int id) {
        User user = userRepo.getById(id);
        if (user == null) {
            return null;
        }
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(user, new File(user.getName() + ".xml"));
        return user;

    }

    @SneakyThrows
    @Override
    public User saveUser() {
        User user = (User) unmarshaller.unmarshal(new File(fileString));
        return userRepo.save(user);
    }

    @SneakyThrows
    @Override
    public User deleteUser() {
        User user = (User) unmarshaller.unmarshal(new File(fileString));
        userRepo.delete(user);
        return user;
    }

    @SneakyThrows
    @Override
    public User updateUser(User userUpdate) {
        User user = (User) unmarshaller.unmarshal(new File(fileString));
        if (user.getId() == userUpdate.getId()) {
            user = userUpdate;
        } else {
            return null;
        }
        return userRepo.save(user);
    }

}
