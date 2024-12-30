package edp.identity_server.user.permission;

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

import edp.identity_server.user.permission.dto.CreateUserPermissionDto;
import edp.identity_server.user.permission.dto.GetUserPermissionDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user-permission")
public class UserPermissionController {
    @Autowired
    private IUserPermissionService service;

    @GetMapping("/{userId}")
    public ResponseEntity<GetUserPermissionDto> findAllByUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok().body(service.findAllByUser(userId));
    }

    @PostMapping
    public ResponseEntity<UserPermission> save(@Valid @RequestBody CreateUserPermissionDto input) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserPermission> remove(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.remove(id));
    }

}
