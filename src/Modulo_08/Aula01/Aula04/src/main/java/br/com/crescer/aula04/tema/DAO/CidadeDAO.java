package br.com.crescer.aula04.tema.DAO;

import br.com.crescer.aula04.tema.Model.Cidade;
import br.com.crescer.aula04.tema.Model.IDAO;
import java.util.List;
import org.hibernate.Criteria;

public class CidadeDAO implements IDAO<Cidade>{

    @Override
    public void insert(Cidade entity) {
        Persistencia.session.save(entity);
    }

    @Override
    public void update(Cidade entity) {
        Persistencia.session.update(entity);
    }

    @Override
    public void delete(Cidade entity) {
        Persistencia.session.delete(entity);
    }

    @Override
    public List<Cidade> listAll() {
        Criteria criteria = Persistencia.session.createCriteria(Cidade.class);
        return criteria.list();
    }
    
}
