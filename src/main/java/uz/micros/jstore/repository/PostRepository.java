package uz.micros.jstore.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.accept.MappingMediaTypeFileExtensionResolver;
import uz.micros.jstore.entity.blog.Post;
import uz.micros.jstore.util.DBManager;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by java on 09.06.14.
 */

@Repository
public class PostRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void addPost(Post post){


    }

    public Post getPost(int id){

        return null;

    }

    public void savePost(Post post){

    }

    public void deletePost(int id){

    }

    @Transactional
    public List<Post> getPosts() {
        List<Post> res = new ArrayList<>();

        Session session = sessionFactory.getCurrentSession();
        res = session.createQuery("from Post").list();


       /* List<Map<String, Object>> list = DBManager.runQuery("select * from posts");

        for(Map<String, Object> items: list) {
            *//*Post p = new Post();
            p.setId((Integer)items.get("id"));
            p.setSubject((String) items.get("Subject"));
            p.setDate((Date) items.get("Date"));
            p.setText((String) items.get("Text"));*//*

            Post p = new PostMapper().map(items);

            res.add(p);
        }*/

        return res;
    }

    private class PostMapper extends Mapper<Post> {}
}
