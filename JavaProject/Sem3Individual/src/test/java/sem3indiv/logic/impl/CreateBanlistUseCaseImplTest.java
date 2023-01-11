package sem3indiv.logic.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import sem3indiv.domain.CreateBanlistRequest;
import sem3indiv.domain.CreateBanlistResponse;
import sem3indiv.domain.CreateUserResponse;
import sem3indiv.repository.BanlistRepository;
import sem3indiv.repository.entity.BanlistEntity;
import sem3indiv.repository.entity.BanlistItemEntity;
import sem3indiv.repository.entity.CardEntity;
import sem3indiv.repository.entity.UserEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CreateBanlistUseCaseImplTest {

    @Mock
    private BanlistRepository banlistRepositoryMock;

    @InjectMocks
    private CreateBanlistUseCaseImpl createBanlistUseCase;


    @Test
    void createBanlist() {
        CardEntity card1 = CardEntity.builder().name("Testcard").type("Normal Monster").desc("This is a test card.")
                .atk(500).def(250).level(3).race("Insect").attribute("EARTH").ogbanlist("TCG").build();
        CardEntity card2 = CardEntity.builder().name("TestcardLimited").type("Normal Monster").desc("This is a test card.")
                .atk(500).def(250).level(3).race("Insect").attribute("EARTH").ogbanlist("TCG").build();
        CardEntity card3 = CardEntity.builder().name("TestcardSemiLimited").type("Normal Monster").desc("This is a test card.")
                .atk(500).def(250).level(3).race("Insect").attribute("EARTH").ogbanlist("TCG").build();
        UserEntity user1 = UserEntity.builder().username("TestUser").password("Bruh").type("User").build();
        List<CardEntity> cardlist1 = new ArrayList<>();
        List<CardEntity> cardlist2 = new ArrayList<>();
        List<CardEntity> cardlist3 = new ArrayList<>();
        cardlist1.add(card1);
        cardlist2.add(card2);
        cardlist3.add(card3);
        BanlistItemEntity itemOne = BanlistItemEntity.builder().id(1).bantype("Forbidden").cards(cardlist1).build();
        BanlistItemEntity itemTwo = BanlistItemEntity.builder().id(2).bantype("Limited").cards(cardlist2).build();
        BanlistItemEntity itemThree = BanlistItemEntity.builder().id(3).bantype("Semi-Limited").cards(cardlist3).build();
        List<BanlistItemEntity> itemList = new ArrayList<>();
        itemList.add(itemOne);
        itemList.add(itemTwo);
        itemList.add(itemThree);
        BanlistEntity banlistObj = BanlistEntity.builder().id(1L).banlistitems(itemList).user(user1).name("Banlist Number One").build();
        CreateBanlistRequest request = CreateBanlistRequest.builder().banlistItems(itemList).user(user1).name("Banlist Number One").build();
        doReturn(banlistObj).when(banlistRepositoryMock).save(any(BanlistEntity.class));

        CreateBanlistResponse actualResult = createBanlistUseCase.createBanlist(request);
        CreateBanlistResponse expectedResult = CreateBanlistResponse.builder().banlistId(1L).name("Banlist Number One").build();
        System.out.println(actualResult);
        assertEquals(expectedResult.getName(), actualResult.getName());
        verify((banlistRepositoryMock), atLeast(1)).save(any(BanlistEntity.class));
    }
}