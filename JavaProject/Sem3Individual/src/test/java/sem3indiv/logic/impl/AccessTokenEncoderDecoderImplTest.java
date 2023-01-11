package sem3indiv.logic.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import sem3indiv.domain.AccessToken;
import sem3indiv.logic.AccessTokenDecoder;
import sem3indiv.logic.AccessTokenEncoder;

import java.security.Key;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AccessTokenEncoderDecoderImplTest {

    @Mock
    private Key keyMock;


    /*@Test
    void encode() {
        String secretKey = "E91E158E4C6656F68B1B5D1C316766DE98D2AD6EF3BFB44F78E9CFCDF5";
        AccessToken accessToken = AccessToken.builder().subject("Test").userId(1).role("User").build();
        AccessTokenEncoder accessTokenEncoder = new AccessTokenEncoderDecoderImpl(secretKey);
        AccessTokenDecoder accessTokenDecoder = new AccessTokenEncoderDecoderImpl(secretKey);
        String encodedAccess = accessTokenEncoder.encode(accessToken);
        doReturn(1L).when(accessTokenDecoder.decode(any()));
        String actualResult = String.valueOf(accessTokenDecoder.decode(encodedAccess));
        System.out.println(actualResult);
        String expectedResult = "User";
        assertEquals(actualResult,expectedResult);
        verify((keyMock), atLeast(1)).getEncoded();
    }*/
}