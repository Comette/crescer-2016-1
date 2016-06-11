package br.com.crescer.aula04.tema.DAO;

import br.com.crescer.aula04.tema.Model.Cliente;
import br.com.crescer.aula04.tema.Model.IDAO;
import java.util.List;
import org.hibernate.Criteria;

public class ClienteDAO implements IDAO<Cliente>{

    @Override
    public void insert(Cliente entity) {
        Persistencia.session.save(entity);
    }

    @Override
    public void update(Cliente entity) {
        Persistencia.session.update(entity);
    }

    @Override
    public void delete(Cliente entity) {
        Persistencia.session.delete(entity);
    }

    @Override
    public List<Cliente> listAll() {
        Criteria criteria = Persistencia.session.createCriteria(Cliente.class);
        return criteria.list();
    }
    
}
