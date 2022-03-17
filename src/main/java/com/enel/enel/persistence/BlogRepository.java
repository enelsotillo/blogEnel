package com.enel.enel.persistence;

import com.enel.enel.Autowire;
import com.enel.enel.domain.Blog;
import org.springframework.stereotype.Repository;

@Repository
public class BlogRepository {
    @Autowire
    private BlogCrudRepository blogCrudRepository;

    @Autowire // crea la instancia de BlogMapper
    private BlogMapper blogMapper;

    public String guardar(Blog blog){
        try {
            BlogEntity blogEntity = this.blogMapper.convertirBlogABlogEntity(blog);
            this.blogCrudRepository.save(blogEntity);

        } catch (Exception e){
            System.out.println("Error "+e.getLocalizedMessage());
            return "Todo salio Mal";
        }
        return "Se Guardo con exito";
    }
}
