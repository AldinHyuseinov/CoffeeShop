package bg.softuni.coffeeshop.services;

import bg.softuni.coffeeshop.models.dto.LoginUserDTO;
import bg.softuni.coffeeshop.models.dto.RegisterUserDTO;
import bg.softuni.coffeeshop.models.entities.User;
import bg.softuni.coffeeshop.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class UserService {
    private final UserRepository userRepository;

    private final ModelMapper mapper;

    public void registerUser(RegisterUserDTO userDTO) {
        userRepository.saveAndFlush(mapper.map(userDTO, User.class));
    }

    public Optional<User> loginUser(LoginUserDTO userDTO) {
        return userRepository.findByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
    }

    public Map<String, Integer> ordersByEmployee() {
        return userRepository.findAll().stream()
                .collect(Collectors.toMap(User::getUsername, user -> user.getOrders().size()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
