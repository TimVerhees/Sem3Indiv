package sem3indiv.config.db;

//import sem3indiv.repository.impl.FakeCardRepositoryImpl;
import lombok.*;
import sem3indiv.repository.entity.CardEntity;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DatabaseDataInitializer{

    /*private FakeCardRepositoryImpl cardRepository;
    //private UserRepository userRepository;
    @EventListener(ApplicationReadyEvent.class)
    public void populateDatabaseInitialDummyData() {
        if (cardRepository.count() == 0) {
            cardRepository.save(CardEntity.builder().name("Testcard").type("Normal Monster").desc("This is a test card.")
                    .atk(500).def(250).level(3).race("Insect").attribute("EARTH").ogbanlist("TCG").build());
            cardRepository.save(CardEntity.builder().name("Dark Magician").type("Normal Monster").desc("The ultimate wizard in terms of attack and defense.")
                    .atk(2500).def(2100).level(7).race("Spellcaster").attribute("DARK").build());

        }
        /*if (userRepository.count() == 0){
            userRepository.save(UserEntity.builder().type("User").name("Timmy-boy").username("timmyboy1999").password("YuJin1965Tr1ck").build());
            userRepository.save(UserEntity.builder().type("Admin").name("Valky").username("SirValky1999").password("B00l3an558").build());
        }*/
    }
//}
