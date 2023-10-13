package laz.dimboba.mapserver.user;

import laz.dimboba.mapserver.exceptions.ConflictException;
import laz.dimboba.mapserver.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    @Override
    public User loadUserByUsername(String number) {
        return getUserByNumber(number);
    }

    public User getUserByNumber(String number) {
        return repository.findUserByNumber(number)
                .orElseThrow(() -> new NotFoundException("There is no user with number: " + number));
    }

    public User saveUser(User user) {
        if(repository.findUserByNumber(user.getNumber()).isPresent()){
            throw new ConflictException("There is user with nuber = " + user.getNumber());
        }
        return repository.save(user);
    }
}
