package pl.korwel.service;

import pl.korwel.model.UserInfo;
import pl.korwel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<UserInfo, Long> {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        super(userRepository);
    }
}
