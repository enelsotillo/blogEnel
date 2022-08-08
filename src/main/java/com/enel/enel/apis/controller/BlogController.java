package com.enel.enel.apis.controller;

import com.enel.enel.domain.Blog;
import com.enel.enel.domain.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:3000") // permiso. el unico que puede hacer peticiones el fromend
@RestController // el tipo de peticion controlador
@RequestMapping("/blog") // ruta de acceso
public class BlogController {
    @Autowired // instancia
    private BlogService blogService; //servicios de blog

    //consultar un solo blog
    @GetMapping("/")
    public ResponseEntity<Blog> optenerBlog(@RequestParam("id")  int id) {
        Optional<Blog> blog=this.blogService.optenerBlog(id);
        if(blog.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }
    // revisar este controller con la cantidad
    @GetMapping("/all")
    public ResponseEntity<List<Blog>> consultarTodo(
            @RequestParam (name="categoria", defaultValue = "") String categoria,
            @RequestParam (name="cantidad", defaultValue = "0") int cantidad

    ) {
        List<Blog> lista;
        if(categoria.length()>0){
             lista=this.blogService.todosLosBlogPorCategoria(categoria);
            return new ResponseEntity<List<Blog>>(lista, HttpStatus.OK);
        }
        if(cantidad > 0){
            lista=this.blogService.cantidadBlog(cantidad);
            return new ResponseEntity<List<Blog>>(lista, HttpStatus.OK);
        }
        //consultar todos los blog con blogServicio
        lista=this.blogService.todosBlog();
        System.out.println(lista.size());
        // retornar la lista de blog
        return new ResponseEntity<List<Blog>>(lista, HttpStatus.OK);
    }
    //crear blog
    // @RequestBody indica a la derecha
    @PostMapping("/")
    public ResponseEntity <Blog> crearBlog(@RequestBody() Blog blog)  {
       Blog repuesta=this.blogService.guardarBlog(blog);
        return new ResponseEntity<>(blog, HttpStatus.CREATED);
        //}else {
           // return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        //}
    }
    //actualizar blog
    @PutMapping("/")
    public ResponseEntity<Blog> actualizaBlog(@RequestBody() Blog blog){
       Blog actualizadoBlog = this.blogService.actualizarBlog(blog);
       return new ResponseEntity<>(actualizadoBlog, HttpStatus.OK);
    }

    //eliminar blog
    @DeleteMapping("/")
    public ResponseEntity<String> eliminaBlog(@RequestParam("id")  int id){
        this.blogService.eliminarBlog(id);
        return new ResponseEntity<>("Eliminado Blog "+id, HttpStatus.OK);
    }
}
