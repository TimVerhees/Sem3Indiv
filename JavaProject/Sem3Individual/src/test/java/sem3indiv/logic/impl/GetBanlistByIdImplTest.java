package sem3indiv.logic.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sem3indiv.domain.Banlist;
import sem3indiv.domain.BanlistItem;
import sem3indiv.domain.Card;
import sem3indiv.domain.User;
import sem3indiv.repository.BanlistRepository;
import sem3indiv.repository.entity.BanlistEntity;
import sem3indiv.repository.entity.BanlistItemEntity;
import sem3indiv.repository.entity.CardEntity;
import sem3indiv.repository.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class GetBanlistByIdImplTest {

    @Mock
    private BanlistRepository banlistRepositoryMock;

    @Test
    void getBanlist() {
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
        BanlistItemEntity itemFour = BanlistItemEntity.builder().id(4).bantype("Forbidden").cards(cardlist2).build();
        BanlistItemEntity itemFive = BanlistItemEntity.builder().id(5).bantype("Limited").cards(cardlist3).build();
        BanlistItemEntity itemSix = BanlistItemEntity.builder().id(6).bantype("Semi-Limited").cards(cardlist1).build();
        List<BanlistItemEntity> itemList1 = new ArrayList<>();
        itemList1.add(itemOne);
        itemList1.add(itemTwo);
        itemList1.add(itemThree);
        List<BanlistItemEntity> itemList2 = new ArrayList<>();
        itemList2.add(itemFour);
        itemList2.add(itemFive);
        itemList2.add(itemSix);
        BanlistEntity banlistObj1 = BanlistEntity.builder().id(1L).banlistitems(itemList1).user(user1).name("Banlist Number One").build();
        BanlistEntity banlistObj2 = BanlistEntity.builder().id(2L).banlistitems(itemList2).user(user1).name("Banlist Number Two").build();
            when(banlistRepositoryMock.findById(1L)).thenReturn(Optional.ofNullable(banlistObj1));

        Card cardB1 = Card.builder().name("Testcard").type("Normal Monster").desc("This is a test card.")
                .atk(500).def(250).level(3).race("Insect").attribute("EARTH").ogbanlist("TCG").build();
        Card cardB2 = Card.builder().name("TestcardLimited").type("Normal Monster").desc("This is a test card.")
                .atk(500).def(250).level(3).race("Insect").attribute("EARTH").ogbanlist("TCG").build();
        Card cardB3 = Card.builder().name("TestcardSemiLimited").type("Normal Monster").desc("This is a test card.")
                .atk(500).def(250).level(3).race("Insect").attribute("EARTH").ogbanlist("TCG").build();
        List<Card> cardlistB1 = new ArrayList<>();
        List<Card> cardlistB2 = new ArrayList<>();
        List<Card> cardlistB3 = new ArrayList<>();
        cardlistB1.add(cardB1);
        cardlistB2.add(cardB2);
        cardlistB3.add(cardB3);
        BanlistItem itemBOne = BanlistItem.builder().id(1).bantype("Forbidden").cards(cardlistB1).build();
        BanlistItem itemBTwo = BanlistItem.builder().id(2).bantype("Limited").cards(cardlistB2).build();
        BanlistItem itemBThree = BanlistItem.builder().id(3).bantype("Semi-Limited").cards(cardlistB3).build();
        BanlistItem itemBFour = BanlistItem.builder().id(4).bantype("Forbidden").cards(cardlistB2).build();
        BanlistItem itemBFive = BanlistItem.builder().id(5).bantype("Limited").cards(cardlistB3).build();
        BanlistItem itemBSix = BanlistItem.builder().id(6).bantype("Semi-Limited").cards(cardlistB1).build();
        List<BanlistItem> itemListBase1 = new ArrayList<>();
        itemListBase1.add(itemBOne);
        itemListBase1.add(itemBTwo);
        itemListBase1.add(itemBThree);
        List<BanlistItem> itemListBase2 = new ArrayList<>();
        itemListBase2.add(itemBFour);
        itemListBase2.add(itemBFive);
        itemListBase2.add(itemBSix);
        User user = User.builder().username("TestUser").password("Bruh").type("User").build();
        Banlist banlist1 = Banlist.builder().id(1L).banlistItems(itemListBase1).user(user).name("Banlist Number One").build();
        Banlist banlist2 = Banlist.builder().id(2L).banlistItems(itemListBase2).user(user).name("Banlist Number Two").build();

            GetBanlistByIdImpl getBanlistById = new GetBanlistByIdImpl(banlistRepositoryMock);
            Optional<Banlist> actualResult = getBanlistById.getBanlist(1);

            verify(banlistRepositoryMock).findById(anyLong());
    }
}