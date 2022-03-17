package com.enel.enel.apis;

import com.enel.enel.domain.Blog;
import com.enel.enel.domain.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired // instancia
    private BlogService blogService; //servicios de blog

    @GetMapping("/")
    public Blog optenerBlog(@RequestParam("id")  int id) {
        Blog blog=this.blogService.optenerBlog(id);
        return blog;
    }

    @PostMapping("/")
    public String crearBlog(@RequestBody() Blog blog)  {
       boolean repuesta=this.blogService.guardarBlog(blog);
        if(repuesta==true){
            return "Guardado";
        }else {
            return "no se guardo";
        }
    }
    @PutMapping("/")
    public String actualizaBlog(){
        return "Blog actualizado";
    }
    @DeleteMapping("/")
    public String eliminaBlog(){
        return "Blog eliminado";
    }
}
