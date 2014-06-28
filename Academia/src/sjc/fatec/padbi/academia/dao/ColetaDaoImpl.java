package sjc.fatec.padbi.academia.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjc.fatec.padbi.academia.model.Perfil;
import sun.print.PeekGraphics;

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
		List list = getSession().createQuery("SELECT p FROM Perfil p, Objetivo o WHERE o.aluno = "+idAluno+" AND o.id=p.objetivo").list();
		return list;
	}

	private Criteria getCriteria(Class<?> clazz) {
		return getSession().createCriteria(clazz);
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
