package sem3indiv.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import sem3indiv.logic.GetCardUseCase;

@RestController
@AllArgsConstructor
@RequestMapping("/cardimages")
public class ExternalController {

    private final GetCardUseCase getCardUseCase;

    @CrossOrigin
    @GetMapping("{name}")
    private String getCardExternal(@PathVariable(value = "name") String name){
        String url = "https://db.ygoprodeck.com/api/v7/cardinfo.php?name=" + name;
        RestTemplate restTemplate = new RestTemplate();
        var result = restTemplate.getForObject(url, String.class);
        return result;
    }
}
