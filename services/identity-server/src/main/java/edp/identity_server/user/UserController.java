package edp.identity_server.user;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edp.identity_server.user.dto.CreateUserDto;
import edp.identity_server.user.dto.GetUserDto;
import edp.identity_server.user.dto.UpdateUserDto;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService service;

    @GetMapping
    public ResponseEntity<GetUserDto> findAll(
        @RequestParam(name = "id", required = false) Long id,
        @RequestParam(name = "name", required = false) String name,
        @RequestParam(name = "username", required = false) String username,
        @RequestParam(name = "email", required = false) String email,
        @RequestParam(name = "createdAt", required = false) LocalDateTime createdAt,
        @RequestParam(name = "deleted", required = false) Boolean deleted
    ) {
        User filters = new User(id, name, username, email, email, createdAt, deleted, null);
        return ResponseEntity.ok().body(service.findAll(filters));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok().body(service.findByEmail(email));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(service.findByUsername(username));
    }

    @PostMapping
    public ResponseEntity<User> save(@Valid @RequestBody CreateUserDto input) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(input));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable("id") Long id, @Valid @RequestBody UpdateUserDto input) {
        return ResponseEntity.ok().body(service.update(id, input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> remove(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.remove(id));
    }

}
