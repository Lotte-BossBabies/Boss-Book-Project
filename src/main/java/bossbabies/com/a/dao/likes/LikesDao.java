package bossbabies.com.a.dao;

import bossbabies.com.a.dto.LikesDto;

public interface LikesDao {

    boolean addLikes(LikesDto likesDto);

    LikesDto getLikeByMIdAndRId(String member_id, String registered_book_id);
}
