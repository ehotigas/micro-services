package edp.identity_server.permition;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edp.identity_server.global.exception.NotFoundException;
import edp.identity_server.permition.dto.CreatePermitionDto;
import edp.identity_server.permition.dto.GetPermitionDto;


@Service
public class PermitionService implements IPermitionService {
    @Autowired
    private IPermitionRepository repository;

    @Autowired
    private PermitionMapper mapper;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    

    @Override
    public GetPermitionDto findAll() {
        logger.info("Fetching all permitions");
        List<Permition> permitions = repository.findAll();
        return new GetPermitionDto(permitions);
    }

    @Override
    public Permition findById(Long id) {
        logger.info("Fetching permition with id: " + id);
        return repository.findById(id).orElseThrow(() -> {
            logger.warn("Fail to fetch permition with id: " + id + ". Not found.");
            throw new NotFoundException("Fail to fetch permition with id: " + id + ". Not found.");
        });
    }

    @Override
    public Permition remove(Long id) {
        logger.info("Removing permition with id: " + id);
        Permition permition = repository.findById(id).orElseThrow(() -> {
            logger.warn("Fail to remove permition with id: " + id + ". Not found.");
            throw new NotFoundException("Fail to remove permition with id: " + id + ". Not found.");
        });
        repository.delete(permition);
        return permition;
    }

    @Override
    public Permition save(CreatePermitionDto input) {
        logger.info("Saving new permition with: " + input);
        Permition persistPermition = mapper.toEntity(input);
        persistPermition.setCreatedAt(LocalDateTime.now());
        
        return repository.save(persistPermition);
    }
}
