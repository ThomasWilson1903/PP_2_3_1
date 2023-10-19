package services;

import models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SevicesUser {
    List<User> cars = new ArrayList<>();

    public SevicesUser() {
        cars.add(new User(23L, "testFirstName", "testLastName", "testEmail"));
    }

    public List<User> getUser(int count) {
        if (count >= cars.size()) {
            return cars;
        } else {
            return cars.subList(0, count);
        }
    }

}
