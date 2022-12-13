package sem3indiv.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sem3indiv.domain.LoginRequest;
import sem3indiv.domain.LoginResponse;
import sem3indiv.logic.LoginUseCase;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
public class LoginController {
    private final LoginUseCase loginUseCase;

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        LoginResponse loginResponse = loginUseCase.login(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }
}
