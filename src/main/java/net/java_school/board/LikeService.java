package net.java_school.board;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    
    @Autowired
    private LikeDao dao;
    
    public void addLike(Like like) {
        dao.addLike(like);
    }
    
    public List<Like> getLikes() {
        return dao.getLikes();
    }
    
    public Like getLike(int no) {
        return dao.getLike(no);
    }
    
    public void removeLike(int no) {
        dao.removeLike(no);
    }
    
}
