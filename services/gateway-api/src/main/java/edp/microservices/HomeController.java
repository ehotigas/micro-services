package edp.microservices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


record HelloWorld(
    String message
) {  }

@RestController
@RequestMapping
public class HomeController {
    @GetMapping("/public")
    public ResponseEntity<HelloWorld> helloWorld() {
        return ResponseEntity.ok().body(new HelloWorld("Hello world!"));
    }

    @GetMapping("/secure")
    public ResponseEntity<HelloWorld> secureHelloWorld() {
        return ResponseEntity.ok().body(new HelloWorld("Secure hello world!"));
    }
}
