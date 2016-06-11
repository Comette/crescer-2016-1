package br.com.crescer.aula04.tema.DAO;

import br.com.crescer.aula04.tema.Model.IDAO;
import br.com.crescer.aula04.tema.Model.Produto;
import java.util.List;
import org.hibernate.Criteria;

public class ProdutoDAO implements IDAO<Produto> {

    @Override
    public void insert(Produto entity) {
          Persistencia.session.save(entity);
    }

    @Override
    public void update(Produto entity) {
        Persistencia.session.update(entity);
    }

    @Override
    public void delete(Produto entity) {
        Persistencia.session.delete(entity);
    }

    @Override
    public List<Produto> listAll() {
        Criteria criteria = Persistencia.session.createCriteria(Produto.class);
        return criteria.list();
    }
    
}
