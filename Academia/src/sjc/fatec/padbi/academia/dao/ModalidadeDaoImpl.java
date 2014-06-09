package sjc.fatec.padbi.academia.dao;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjc.fatec.padbi.academia.model.Modalidade;

@Transactional
@Repository
public class ModalidadeDaoImpl implements ModalidadeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Serializable cadastrar(Modalidade modalidade) {
		return getSession().save(modalidade);
	}

	private Criteria getCriteria(Class<?> clazz) {
		return getSession().createCriteria(clazz);
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
