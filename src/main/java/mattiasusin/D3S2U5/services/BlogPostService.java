package mattiasusin.D2S2U5.services;

import mattiasusin.D2S2U5.entities.Autore;
import mattiasusin.D2S2U5.entities.BlogPost;
import mattiasusin.D2S2U5.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {
    private List<Autore> blogPostList = new ArrayList<>();

    // 3. CREA
    public static BlogPost saveBlogPost(BlogPost body) {
        Random rd = new Random();
        body.setId(rd.nextInt(1, 100));
        body.setTitolo(rd.toString());
        body.setCover(rd.toString());
        body.setTempoDiLettura(rd.nextInt());
        this.blogPostList.add((Autore) body);
        return body;
    }

    // 1. TROVA TUTTI
    public List<Autore> findAll() {
        return this.blogPostList;
    }

    // 2. TROVA CON ID
    public Autore findById(int blogPostId) throws ClassNotFoundException {
        Autore found = null;
        for (BlogPost blogPost : this.blogPostList) {
            if (blogPost.getId() == blogPostId) found = (Autore) blogPost;
        }
        if (found == null) throw new ClassNotFoundException();
        return found;

    }

    // 4. TROVA CON ID E MODIFICA
    public BlogPost findByIdAndUpdate(int blogPostId, BlogPost blogPostUpdate) {
        BlogPost found = null;
        for (BlogPost blogPost : this.blogPostList) {
            if (blogPost.getId() == blogPostId) {
                found = blogPost;
                found.setCategoria(blogPostUpdate.getCategoria());
                found.setTitolo(blogPostUpdate.getTitolo());
                found.setCover(blogPostUpdate.getCover());
                found.setTempoDiLettura(blogPostUpdate.getTempoDiLettura());
            }
        }
        if (found == null) throw new NotFoundException(blogPostId);
        return found;
    }

    // 5. DELETE
    public void findByIdAndDelete(int blogPostId) {
        BlogPost found = null;
        for (BlogPost blogPost : this.blogPostList) {
            if (blogPost.getId() == blogPostId) found = blogPost;
        }
        if (found == null) throw new NotFoundException(blogPostId);
        this.blogPostList.remove(found);
    }

}
