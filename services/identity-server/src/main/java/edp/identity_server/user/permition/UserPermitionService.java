package edp.identity_server.user.permition;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edp.identity_server.global.exception.NotFoundException;
import edp.identity_server.permition.IPermitionService;
import edp.identity_server.permition.Permition;
import edp.identity_server.user.IUserService;
import edp.identity_server.user.User;
import edp.identity_server.user.permition.dto.CreateUserPermitionDto;
import edp.identity_server.user.permition.dto.GetUserPermitionDto;


@Service
public class UserPermitionService implements IUserPermitionService {
    @Autowired
    private IUserPermitionRepository repository;

    @Autowired
    private IUserService userService;

    @Autowired
    private IPermitionService permitionService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public GetUserPermitionDto findAllByUser(Long userId) {
        logger.info("Fetching all user permitions with user id: " + userId);
        User user = userService.findById(userId);
        List<UserPermition> userPermitions = repository.findAllByUser(user);
        return new GetUserPermitionDto(userPermitions);
    }

    @Override
    public UserPermition remove(Long id) {
        logger.info("Removing user permition with id: " + id);
        UserPermition permition = repository.findById(id).orElseThrow(() -> {
            logger.warn("Fail to remove user permition with id: " + id + ". Not found.");
            throw new NotFoundException("Fail to remove user permition with id: " + id + ". Not found.");
        });
        repository.delete(permition);
        return permition;
    }

    @Override
    public UserPermition save(CreateUserPermitionDto input) {
        logger.info("Saving user permition with: " + input);
        User user = userService.findById(input.getUser());
        Permition permition = permitionService.findById(input.getPermition());
        UserPermition userPermition = UserPermition.builder().user(user).permition(permition).build();
        return repository.save(userPermition);
    }
}
