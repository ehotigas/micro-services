package edp.identity_server.user.permition;

import edp.identity_server.user.permition.dto.CreateUserPermitionDto;
import edp.identity_server.user.permition.dto.GetUserPermitionDto;

public interface IUserPermitionService {
    GetUserPermitionDto findAllByUser(Long userId);
    UserPermition save(CreateUserPermitionDto input);
    UserPermition remove(Long id);
}
