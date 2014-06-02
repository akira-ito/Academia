package sjc.fatec.padbi.ator.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjc.fatec.padbi.ator.model.Ator;
import sjc.fatec.padbi.ator.model.Login;

@Transactional
@Repository
public class AtorDaoImpl implements AtorDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Ator logar(Login login) {
		return (Ator) getCriteria(Ator.class)
				.add(Restrictions.eq("login.usuario", login.getUsuario()))
				.add(Restrictions.eq("login.senha", login.getSenha())).setMaxResults(1).uniqueResult();
	}
	
	private Criteria getCriteria(Class<?> clazz){
		return sessionFactory.getCurrentSession().createCriteria(clazz);
	}
}
