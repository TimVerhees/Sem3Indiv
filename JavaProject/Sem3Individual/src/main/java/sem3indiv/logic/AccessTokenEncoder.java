package sem3indiv.logic;

import sem3indiv.domain.AccessToken;

public interface AccessTokenEncoder {
    String encode(AccessToken accessToken);
}
