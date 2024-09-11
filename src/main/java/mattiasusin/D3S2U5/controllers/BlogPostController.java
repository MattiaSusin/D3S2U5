package mattiasusin.D2S2U5.controllers;

import mattiasusin.D2S2U5.entities.Autore;
import mattiasusin.D2S2U5.entities.BlogPost;
import mattiasusin.D2S2U5.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {
    @Autowired
    private BlogPost blogPost;

    // 1. GET TUTTI --> http://localhost:3001/blogPosts
    @GetMapping
    private List<BlogPost> getAllBlogPosts() {
        return BlogPostService.findAll();
    }

    // 2. GET SINGOLO AUTORI (findById) --> http://localhost:3001/blogPosts/{blogPostId}
    @GetMapping("/{autoreId}")
    private Autore getAutoreById(@PathVariable int autoreId)
            throws ClassNotFoundException {
        return autoreService.findById(autoreId);
    }

    // 3. POST CREA UN NUOVO AUTORE -->  http://localhost:3001/blogPosts (+ body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201 CREATED
    private Autore createAutore(@RequestBody Autore body) {
        return (Autore) BlogPostService.saveBlogPost(body);
    }

    // 4. PUT MODIFICA LO SPECIFICO AUTORE --> http://localhost:3001/blogPosts/{blogPostId} (+ body)

    @PutMapping("/{autoreId}")
    private Autore findAutoreByIdAndUpdate(@PathVariable int autoreId, @RequestBody Autore body) {
        return autoreService.findByIdAndUpdate(autoreId, body);
    }

    // 5. DELETE CANCELLA LO SPECIFICO AUTORE --> http://localhost:3001/blogPosts/{blogPostId}

    @DeleteMapping("/{autoreId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findAutoreByIdAndDelete(@PathVariable int autoreId) {
        autoreService.findByIdAndDelete(autoreId);
    }


}
