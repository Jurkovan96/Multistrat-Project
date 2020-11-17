package tradeIt.com.tarde.it.dao;
import tradeIt.com.tarde.it.model.User;
import tradeIt.com.tarde.it.repository.UserRepository;

public class UserDao {

    private static final String TAG = UserDao.class.getName();

    private UserRepository userRepository;

    public User getUserByEmail(String userEmail) {
        User user = new User();
        user = userRepository.getUserByEmail(userEmail).get();
        System.out.println(TAG + "User name" + user.getEmail());
        return user;
    }


}
