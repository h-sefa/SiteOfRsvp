package com.example.SiteOfRsvp.service;

import com.example.SiteOfRsvp.dto.UserDto;
import com.example.SiteOfRsvp.dto.UserResponseDto;
import com.example.SiteOfRsvp.entity.Roles;
import com.example.SiteOfRsvp.entity.User;
import com.example.SiteOfRsvp.exception.ExistEmailException;
import com.example.SiteOfRsvp.exception.ExistPlatformOrderId;
import com.example.SiteOfRsvp.exception.ResourceNotFoundException;
import com.example.SiteOfRsvp.mappers.UserMapper;
import com.example.SiteOfRsvp.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDto registerUser(UserDto userDto) {
        if (existsByEmail(userDto.getEmail())) {
            throw new ExistEmailException("Email already exists: " + userDto.getEmail());
        }

        User user = userMapper.userDtoToUser(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(Roles.CUSTOMER); // Default role

        User savedUser = userRepository.save(user);
        return userMapper.userToUserResponseDto(savedUser);
    }

    @Override
    public User registerUserforOrderService(UserDto userDto) {
        if (existsByEmail(userDto.getEmail())) {
            throw new ExistEmailException("Email already exists: " + userDto.getEmail());
        }

        User user = userMapper.userDtoToUser(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(Roles.CUSTOMER); // Default role



        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponseDto findByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
        return userMapper.userToUserResponseDto(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponseDto findById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return userMapper.userToUserResponseDto(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponseDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.usersToUserResponseDtos(users);
    }

    @Override
    public UserResponseDto updateUser(UUID id, UserDto userDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        // Sadece değişen alanları güncelle
        userMapper.updateUserFromDto(userDto, existingUser);

        // Password güncellemesi
        if (userDto.getPassword() != null && !userDto.getPassword().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }

        User updatedUser = userRepository.save(existingUser);
        return userMapper.userToUserResponseDto(updatedUser);
    }

    @Override
    public void deleteUser(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public UserResponseDto credentialCheck(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Yanlış email ya da şifre"));
        if(passwordEncoder.matches(password, user.getPassword())){
            return userMapper.userToUserResponseDto(user);
        }

        throw new ResourceNotFoundException("Böyle bir kullanıcı bulunamadı"); // BURAYA AUTH İLE ALAKALI EXCEPTION KONULABİLİR.
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}