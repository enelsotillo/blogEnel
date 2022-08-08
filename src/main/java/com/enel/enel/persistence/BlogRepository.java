package com.enel.enel.persistence;

import com.enel.enel.domain.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepository {
    @Autowired
    private BlogCrudRepository blogCrudRepository;

    @Autowired // crea la instancia de BlogMapper
    private BlogMapper blogMapper;

    public Blog guardar(Blog blog){
        try {
            BlogEntity blogEntity = this.blogMapper.convertirBlogABlogEntity(blog);
            return this.blogMapper.convertirBlogEntityABlog( this.blogCrudRepository.save(blogEntity));

        } catch (Exception e){
            System.out.println("Error "+e.getLocalizedMessage());
            return blog;
        }
    }
    public List<Blog> todoLosBlog() {
        List<BlogEntity> listaEntity;
        listaEntity = (List<BlogEntity>) this.blogCrudRepository.findAll();
        return this.blogMapper.convertirAListaBlog(listaEntity);
    }
    public Optional<Blog> buscarUnBlogPorId(int id){
       Optional<BlogEntity> entityUnBlog = this.blogCrudRepository.findById(id);
        if (entityUnBlog.isEmpty()) { //de vuelve un booleano tru o farse
            return Optional.empty();
        }
        //es una caja, puede contenido datos o estar vacia
        //
        return Optional.of(this.blogMapper.convertirBlogEntityABlog(entityUnBlog.get())); // returna el contenido de la caja
    }
    public Blog actualizarBlog(Blog blog){
      Optional<BlogEntity> entityUnBlogOptional= this.blogCrudRepository.findById(blog.getId());
      if(entityUnBlogOptional.isEmpty()){
          // excepcion no fue encontrada

      }
      BlogEntity blogEntity=entityUnBlogOptional.get();
      blogEntity.setContenido(blog.getContenido());
      blogEntity.setTitulo(blog.getTitulo());
        blogEntity.setCategoria(blog.getCategoria());
      return this.blogMapper.convertirBlogEntityABlog(this.blogCrudRepository.save(blogEntity));

    }
    public boolean eliminarBlog(int id){
        try {
            this.blogCrudRepository.deleteById(id);
            return true;
        }catch (Exception e){
          System.out.println(e);
        }
        return false;
    }
    //optener Blog por categoria modificado 11-06-2022 linea 67
    public List<Blog> OptenerBlogPorCategoria(String categoria) {
        List<BlogEntity> listaEntity;
        listaEntity = (List<BlogEntity>) this.blogCrudRepository.findByCategoriaOrderByBlogIdDesc(categoria);
        return this.blogMapper.convertirAListaBlog(listaEntity);
    }
    public List<Blog> OptenerPublicacionHomeBlog(int cantidad) {
    //     cantidad=4;
        List<BlogEntity> listaEntity;
        listaEntity = (List<BlogEntity>) this.blogCrudRepository.findByCantidadOrderByBlogIdDescByLimit(cantidad);
        return this.blogMapper.convertirAListaBlog(listaEntity);
    }
}
