package edp.identity_server.user;

import edp.identity_server.user.dto.CreateUserDto;
import edp.identity_server.user.dto.GetUserDto;
import edp.identity_server.user.dto.UpdateUserDto;


public interface IUserService {
    GetUserDto findAll(User filters);
    User findById(Long id);
    User findByEmail(String email);
    User findByUsername(String username);
    User save(CreateUserDto input);
    User update(Long id, UpdateUserDto input);
    User remove(Long id);
}
