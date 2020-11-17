package tradeIt.com.tarde.it.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tradeIt.com.tarde.it.model.User;
import tradeIt.com.tarde.it.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByEmail(String email) {
        if (!userRepository.getUserByEmail(email).isPresent()) {
            System.out.println("No user found!");
        }
        return userRepository.getUserByEmail(email).get();
    }


    public boolean performLogin(String userEmail, String password) {
        boolean isCheckedUser = false;
        User user = getUserByEmail(userEmail);
        if (user == null) {
            System.out.println("No way!");
        }
        assert user != null;
        if (user.getPassword().equals(password)) {
            isCheckedUser = true;
        }
        return isCheckedUser;
    }
}
