package edp.identity_server.permition;

import edp.identity_server.permition.dto.CreatePermitionDto;
import edp.identity_server.permition.dto.GetPermitionDto;


public interface IPermitionService {
    GetPermitionDto findAll();
    Permition findById(Long id);
    Permition save(CreatePermitionDto input);
    Permition remove(Long id);
}
