package sjc.fatec.padbi.academia.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjc.fatec.padbi.academia.model.Perfil;

@Transactional
@Repository
public class ColetaDaoImpl implements ColetaDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Serializable cadastrar(Perfil perfil) {
		return getSession().save(perfil);
	}
	
	@Override
	public List<Perfil> listar(Long idAluno) {
//		getCriteria(Perfil.class).add(Restrictions.conjunction))
		return null;
	}

	private Criteria getCriteria(Class<?> clazz) {
		return getSession().createCriteria(clazz);
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
