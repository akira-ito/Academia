package sjc.fatec.padbi.academia.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjc.fatec.padbi.academia.model.Objetivo;

@Transactional
@Repository
public class ObjetivoDaoImpl implements ObjetivoDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Objetivo> buscarPorAluno(Long id) {
		List<Objetivo> objetivos = (List<Objetivo>) getCriteria(Objetivo.class).add(Restrictions.eq("aluno.id", id)).addOrder(Order.desc("inicio")).list();
		return objetivos == null ? new ArrayList<Objetivo>(): objetivos;
	}
	
	@Override
	public Serializable cadastrar(Objetivo objetivo) {
		return getSession().save(objetivo);
	}
	
	@Override
	public Objetivo buscar(Long id) {
		Objetivo objetivo = (Objetivo) getCriteria(Objetivo.class).add(Restrictions.eq("id", id)).setMaxResults(1).uniqueResult();
		return objetivo;
	}

	private Criteria getCriteria(Class<?> clazz) {
		return getSession().createCriteria(clazz);
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
