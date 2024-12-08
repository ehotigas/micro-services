package edp.identity_server.user;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import edp.identity_server.global.exception.BadRequestException;
import edp.identity_server.global.exception.NotFoundException;
import edp.identity_server.user.dto.CreateUserDto;
import edp.identity_server.user.dto.GetUserDto;
import edp.identity_server.user.dto.UpdateUserDto;


@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository repository;

    @Autowired
    private UserMapper mapper;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public GetUserDto findAll(User filters) {
        logger.info("Fetching all users with: " + filters);
        List<User> userList = repository.findAll(
            Example.of(filters, ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING))
        );
        return new GetUserDto(userList);
    }

    @Override
    public User findById(Long id) {
        logger.info("Fetching user with id: " + id);
        User user = repository.findById(id).orElseThrow(() -> {
            logger.warn("Fail to fetch user with id" + id + ". Not found.");
            throw new NotFoundException("Fail to fetch user with id" + id + ". Not found.");
        });
        return user;
    }

    @Override
    public User findByEmail(String email) {
        logger.info("Fetching user with email: " + email);
        User user = repository.findByEmail(email).orElseThrow(() -> {
            logger.warn("Fail to fetch user with email " + email + ". Not found.");
            throw new NotFoundException("Fail to fetch user with email " + email + ". Not found.");
        });
        return user;
    }

    @Override
    public User findByUsername(String username) {
        logger.info("Fetching user with username: " + username);
        User user = repository.findByUsername(username).orElseThrow(() -> {
            logger.warn("Fail to fetch user with username " + username + ". Not found.");
            throw new NotFoundException("Fail to fetch user with username " + username + ". Not found.");
        });
        return user;
    }

    @Override
    public User remove(Long id) {
        logger.info("Removing user with id: " + id);
        User user = repository.findById(id).orElseThrow(() -> {
            logger.warn("Fail to remove user with id " + id + ". Not found.");
            throw new NotFoundException("Fail to remove user with id " + id + ". Not found.");
        });
        repository.delete(user);
        return user;
    }

    @Override
    public User save(CreateUserDto input) {
        logger.info("Saving new user with: " + input);
        Optional<User> user = repository.findByEmail(input.getEmail());
        if (user.isPresent()) {
            throw new BadRequestException("Fail to create user. Email " + input.getEmail() + " already exists");
        }

        Optional<User> userByUsername = repository.findByUsername(input.getUsername());
        if (userByUsername.isPresent()) {
            throw new BadRequestException("Fail to create user. Username " + input.getEmail() + " already exists");
        }

        User persistUser = mapper.toEntity(input);
        persistUser.setCreatedAt(LocalDateTime.now());
        persistUser.setDeleted(false);
        User returnUser = repository.save(persistUser);
        return returnUser;
    }

    @Override
    public User update(Long id, UpdateUserDto input) {
        logger.info("Updating user with id: " + id);
        User user = repository.findById(id).orElseThrow(() -> {
            logger.warn("Fail to update user with id" + id + ". Not found.");
            throw new NotFoundException("Fail to update user with id" + id + ". Not found.");
        });

        user = mapper.partialUpdate(user, input);
        user = repository.save(user);
        return user;
    }
}
