package edp.identity_server.permission;

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

import edp.identity_server.permission.dto.CreatePermissionDto;
import edp.identity_server.permission.dto.GetPermissionDto;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private IPermissionService service;

    @GetMapping
    public ResponseEntity<GetPermissionDto> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Permission> save(@Valid @RequestBody CreatePermissionDto input) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Permission> remove(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.remove(id));
    }
}
