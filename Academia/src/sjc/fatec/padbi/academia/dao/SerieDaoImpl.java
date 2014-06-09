package sjc.fatec.padbi.academia.dao;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjc.fatec.padbi.academia.model.Serie;

@Transactional
@Repository
public class SerieDaoImpl implements SerieDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Serializable cadastrar(Serie serie) {
		return getSession().save(serie);
	}
	
	private Criteria getCriteria(Class<?> clazz) {
		return getSession().createCriteria(clazz);
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
