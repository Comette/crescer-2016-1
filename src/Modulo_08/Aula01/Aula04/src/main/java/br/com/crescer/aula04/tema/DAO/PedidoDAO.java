package br.com.crescer.aula04.tema.DAO;

import br.com.crescer.aula04.tema.Model.IDAO;
import br.com.crescer.aula04.tema.Model.Pedido;
import java.util.List;
import org.hibernate.Criteria;

public class PedidoDAO implements IDAO<Pedido> {

    @Override
    public void insert(Pedido entity) {
        Persistencia.session.save(entity);
    }

    @Override
    public void update(Pedido entity) {
        Persistencia.session.update(entity);
    }

    @Override
    public void delete(Pedido entity) {
        Persistencia.session.delete(entity);
    }

    @Override
    public List<Pedido> listAll() {
        Criteria criteria = Persistencia.session.createCriteria(Pedido.class);
        return criteria.list();
    }
    
}
