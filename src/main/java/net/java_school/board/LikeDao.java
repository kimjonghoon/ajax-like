package net.java_school.board;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
@Component
public class LikeDao {
    private List<Like> likes = new ArrayList<>();

    public LikeDao() {
        Like like = new Like();
        like.setNo(1111);
        like.setUsername("John Doe");
        likes.add(like);
    }
    
    public void addLike(Like like) {
        likes.add(like);
    }
    
    public List<Like> getLikes() {
        return likes;
    }
    
    public void removeLike(int no) {
        for (Like like : likes) {
            if (like.getNo() == no) {
                likes.remove(like);
                break;
            }
        }
    }
    
    public Like getLike(int no) {
        Like ret = null;
        for (Like like : likes) {
            if (like.getNo() == no) {
                ret = like;
                break;
            }
        }
        
        return ret;
    }
    
}
