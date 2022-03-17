package com.enel.enel.domain;

import com.enel.enel.Autowire;
import com.enel.enel.domain.Blog;
import com.enel.enel.persistence.BlogRepository;
import org.springframework.stereotype.Service;


@Service
public class BlogService {
    @Autowire
    private BlogRepository blogRepository;
    public Blog optenerBlog(int id){
        Blog blog = new Blog( "Nuevo Pais", "Enel", "Nueva vida en Argentina", id );
        return blog;
    }

    public boolean guardarBlog(Blog blog){
        this.blogRepository.guardar(blog);
        return true;

    }


}
