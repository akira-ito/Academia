package sjc.fatec.padbi.aluno.controller;

import static java.lang.Boolean.TRUE;
import static org.hibernate.criterion.MatchMode.ANYWHERE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sjc.fatec.padbi.academia.dao.ObjetivoDao;
import sjc.fatec.padbi.academia.model.Objetivo;
import sjc.fatec.padbi.academia.model.Semana;
import sjc.fatec.padbi.academia.model.Serie;
import sjc.fatec.padbi.aluno.dao.AlunoDao;
import sjc.fatec.padbi.aluno.model.Aluno;
import sjc.fatec.padbi.ator.dao.AtorDao;
import sjc.fatec.padbi.ator.model.Login;

@Controller
@Scope("request")
public class AlunoController {

	@Autowired
	private AlunoDao dao;
	@Autowired
	private ObjetivoDao objetivoDao;
	@Autowired
	private AtorDao atorDao;
	@Autowired
	private AlunoContext context;

	@RequestMapping("/cadastroAluno")
	public String cadastro(Model model, HttpServletRequest request) {
		if (request.getAttribute("aluno") == null)
			model.addAttribute(new Aluno());
		return "aluno/cadastrar";
	}

	@RequestMapping("/cadastrarAluno")
	public String cadastrar(@Valid Aluno aluno, BindingResult result,
			HttpServletRequest request, Model model) {
		if (result.hasErrors()) {
			return "forward:/?pagina=cadastroAluno";
		}

		dao.cadastrar(aluno);
		model.addAttribute("msg", "alunoCadastradoSucesso");
		return "redirect:/";
	}

	@RequestMapping("/listarAluno")
	public String listar(Model model) {
		List<Aluno> alunos = context.getAlunosBuscado();
		if (alunos == null) {
			alunos = dao.listar();
		}
		model.addAttribute("alunos", alunos);
		context.setAlunosBuscado(null);
		return "aluno/listar";
	}

	@RequestMapping("/editaAluno")
	public String edita(Long id, Model model, HttpServletRequest request) {
		if (request.getAttribute("aluno") == null) {
			Aluno aluno = dao.buscar(id);
			model.addAttribute(aluno);
		}
		return "aluno/editar";
	}

	@RequestMapping("/editarAluno")
	public String editar(@Valid Aluno aluno, BindingResult result, Model model) {
		if (result.hasErrors() && !(result.hasFieldErrors("login.senha") || result.hasFieldErrors("login.usuario"))) {
			return "forward:/?pagina=editaAluno";
		}
		
		Login login = atorDao.buscarLogin(aluno.getId());
		aluno.setLogin(login);
		dao.editar(aluno);
		model.addAttribute("msg", "alunoEditadoSucesso");
		model.addAttribute("pagina", "listarAluno");
		return "redirect:/";
	}

	@RequestMapping("/excluirAluno")
	public String excluir(Long id, Model model) {
		dao.excluir(id);

		model.addAttribute("msg", "alunoExcluidoSucesso");
		model.addAttribute("pagina", "listarAluno");
		return "redirect:/";
	}

	@RequestMapping("/buscarAluno")
	public String buscar(String nome, String pagina, Model model) {
		List<Aluno> alunos = dao.buscarPorNome(nome, ANYWHERE);
		context.setAlunosBuscado(alunos);
		
		model.addAttribute("pagina", pagina);
		return "redirect:/";
	}
	
	@RequestMapping("/listarPerfils")
	public String listarPerfils(Long id, Model model){
		
		
		return "perfil/listar";
	}
	
	@RequestMapping(value = "/avaliarAluno/{passo}")
	public String avaliar(@PathVariable Integer passo, @RequestParam(required = false) Long id, Model model){
		switch (passo) {
		case 0:
			model.addAttribute("avaliar", TRUE);
			model.addAttribute("pagina", "listarAluno");
			return listar(model);
		case 1:
			if (id == null)
				return avaliar(0, 0L, model);
			Aluno aluno = dao.buscar(id);
			
			context.setAluno(aluno);
			List<Objetivo> objetivos = objetivoDao.buscarPorAluno(aluno.getId());
			model.addAttribute("objetivos", objetivos);
			return "academia/objetivo";
		case 2:
			if (id == null)
				return avaliar(1, context.getAluno().getId(), model);
			Objetivo objetivo = objetivoDao.buscar(id);
			
			List<Semana> semanas = new ArrayList<Semana>(Arrays.asList(Semana
					.values()));
			Boolean tipoModalidade = false;
			if (objetivo.getSeries() != null){
				for (Serie serie : objetivo.getSeries()){
					semanas.removeAll(serie.getSemanas());
				}
				tipoModalidade = objetivo.getSeries().size()==3;
			}
			model.addAttribute("addSerie", !(tipoModalidade || semanas.isEmpty()));
			model.addAttribute("perfils", objetivo.getPerfils());
			model.addAttribute("series", objetivo.getSeries());
			context.setObjetivo(objetivo);
			return "avaliar/avaliar";
		default:
			return null;
		}
	}

}
