package Sem3Indiv.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maja")
public class MajaTemp {

    @GetMapping("/hello")
    public ResponseEntity<String> getHello() {

        return ResponseEntity.ok().body("Hello");
    }
}
