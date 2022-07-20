package bossbabies.com.a.dao.likes;

import bossbabies.com.a.dto.LikesDto;

public interface LikesDao {

    boolean addLikes(LikesDto likesDto);

    LikesDto getLikeByMIdAndRId(int member_id, int registered_book_id);

    boolean cancelLikes(int member_id, int registered_book_id);

    void deleteLieks(int like_id);
}
