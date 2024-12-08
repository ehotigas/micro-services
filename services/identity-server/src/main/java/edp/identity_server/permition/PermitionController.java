package edp.identity_server.permition;

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

import edp.identity_server.permition.dto.CreatePermitionDto;
import edp.identity_server.permition.dto.GetPermitionDto;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/permition")
public class PermitionController {
    @Autowired
    private IPermitionService service;

    @GetMapping
    public ResponseEntity<GetPermitionDto> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Permition> save(@Valid @RequestBody CreatePermitionDto input) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Permition> remove(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.remove(id));
    }
}
