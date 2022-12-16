package sem3indiv.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import sem3indiv.domain.UpdateCardImageRequest;
import sem3indiv.domain.UpdateCardRequest;
import sem3indiv.logic.GetCardUseCase;
import sem3indiv.logic.UpdateCardImageUseCase;
import sem3indiv.logic.impl.ImageGetter;

import javax.validation.Valid;
import java.io.File;
import java.util.Map;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
@RequestMapping("/cardimages")
public class ExternalController {
    public static Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dz6wz2wfd",
            "api_key", "417581682995282",
            "api_secret", "M2bMr5MPcG7WXzqsFPJii-lr-oo"));
    private final GetCardUseCase getCardUseCase;
    private final UpdateCardImageUseCase updateCardImageUseCase;
    @CrossOrigin
    @GetMapping("{name}")
    private String getCardExternal(@PathVariable(value = "name") String name){
        String url = "https://db.ygoprodeck.com/api/v7/cardinfo.php?name=" + name;
        RestTemplate restTemplate = new RestTemplate();
        var result = restTemplate.getForObject(url, String.class);
        return result;
    }

    @CrossOrigin
    @PutMapping("updateImage/{id}")
    private ResponseEntity<Void> updateCardImage(@PathVariable("id") long cardId,
                                                 @RequestBody @Valid UpdateCardImageRequest request) {
        request.setId(cardId);
        System.out.println(request.getCard_image());
        try {
            Map uploadResult = cloudinary.uploader().upload((request.getCard_image()),
                    ObjectUtils.asMap("public_id", request.getName()));
            request.setCard_image((String) uploadResult.get("secure_url"));
        }catch (Exception e) {
            System.out.println("Failed");
            return ResponseEntity.notFound().build();
        }
        updateCardImageUseCase.updateCardImage(request);
        return ResponseEntity.noContent().build();
    }
}
