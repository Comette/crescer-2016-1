
package br.com.crescer.aula04.tema.DAO;

import br.com.crescer.aula04.tema.Model.IDAO;
import br.com.crescer.aula04.tema.Model.Material;
import java.util.List;
import org.hibernate.Criteria;

public class MaterialDAO implements IDAO<Material> {

    @Override
    public void insert(Material entity) {
        Persistencia.session.save(entity);
    }

    @Override
    public void update(Material entity) {
        Persistencia.session.update(entity);
    }

    @Override
    public void delete(Material entity) {
        Persistencia.session.delete(entity);
    }

    @Override
    public List<Material> listAll() {
        Criteria criteria = Persistencia.session.createCriteria(Material.class);
        return criteria.list();
    }

}
