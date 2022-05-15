package com.enel.enel.domain;

import com.enel.enel.domain.Blog;
import com.enel.enel.persistence.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;
    public Optional<Blog> optenerBlog(int id){
        return this.blogRepository.buscarUnBlogPorId(id);
    }

    public Blog guardarBlog(Blog blog){
        return blogRepository.guardar(blog);

    }
    public List<Blog> todosBlog(){
        return this.blogRepository.todoLosBlog();
    }

    public Blog actualizarBlog(Blog blog ){
        return this.blogRepository.actualizarBlog(blog);

    }
    public boolean eliminarBlog(int id){
        return this.blogRepository.eliminarBlog(id);
    }


}
