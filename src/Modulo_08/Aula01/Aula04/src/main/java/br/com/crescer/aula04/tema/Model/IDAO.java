package br.com.crescer.aula04.tema.Model;

import java.util.List;

public interface IDAO<T> {
    
   void insert(T entity);

   void update(T entity);

   void delete(T entity);

   List<T> listAll();    
}
