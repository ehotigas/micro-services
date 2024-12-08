package edp.identity_server.user.permition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edp.identity_server.user.permition.dto.CreateUserPermitionDto;
import edp.identity_server.user.permition.dto.GetUserPermitionDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user-permition")
public class UserPermitionController {
    @Autowired
    private IUserPermitionService service;

    @GetMapping("/{userId}")
    public ResponseEntity<GetUserPermitionDto> findAllByUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok().body(service.findAllByUser(userId));
    }

    @PostMapping
    public ResponseEntity<UserPermition> save(@Valid @RequestBody CreateUserPermitionDto input) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserPermition> remove(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.remove(id));
    }

}
