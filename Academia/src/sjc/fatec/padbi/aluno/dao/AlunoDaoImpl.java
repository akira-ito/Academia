package sjc.fatec.padbi.aluno.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjc.fatec.padbi.aluno.model.Aluno;
import sjc.fatec.padbi.ator.model.Ator;
import sjc.fatec.padbi.ator.model.Login;

@Transactional
@Repository
public class AlunoDaoImpl implements AlunoDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Serializable cadastrar(Aluno aluno) {
		return getSession().save(aluno);
	}
	
	@Override
	public Boolean usuarioValido(String usuario) {
		Object ator = getCriteria(Ator.class).add(Restrictions.andeq("login.usuario", usuario)).setMaxResults(1).uniqueResult();
		return ator == null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aluno> listar() {
		return ((List<Aluno>) getCriteria(Aluno.class).list());
	}

	@Override
	public Aluno buscar(Long id) {
		return (Aluno) getCriteria(Aluno.class).add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public Aluno editar(Aluno aluno) {
		return (Aluno) getSession().merge(aluno);
	}

	@Override
	public void excluir(Long id) {
		Aluno aluno = (Aluno) getSession().load(Aluno.class, id);
		getSession().delete(aluno);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aluno> buscarPorNome(String nome, MatchMode mode) {
		List<Aluno> alunos = (List<Aluno>) getCriteria(Aluno.class).add(Restrictions.like("nome", nome, mode)).list();
		
		return alunos == null? new ArrayList<Aluno>(): alunos;
	}

	private Criteria getCriteria(Class<?> clazz) {
		return getSession().createCriteria(clazz);
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
