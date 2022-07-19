package bossbabies.com.a.dao.likes;

import bossbabies.com.a.dto.LikesDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LikesDaoImpl implements LikesDao{

    @Autowired
    SqlSession session;

    String namespace = "Likes.";

    public boolean addLikes(LikesDto likesDto){
        int result = session.insert(namespace+"addLikes", likesDto);
        if(result == 0){
            return false;
        }
        return true;
    }

    @Override
    public LikesDto getLikeByMIdAndRId(int member_id, int registered_book_id) {
        Map<String , Integer> map = new HashMap<>();
        map.put("member_id", member_id);
        map.put("registered_book_id", registered_book_id);

        return session.selectOne(namespace+"selectLikes", map);
    }

    @Override
    public boolean cancelLikes(int member_id, int registered_book_id) {
        Map<String, Integer> map = new HashMap<>();
        map.put("member_id", member_id);
        map.put("registered_book_id", registered_book_id);

        int cancelLikesResult = session.delete(namespace + "cancelLikes", map);
        if (cancelLikesResult == 0) {
            return false;
        }
        return true;
    }

    public void deleteLieks(int like_id) {
        session.delete(namespace + "deleteLikes", like_id);
    }
}
