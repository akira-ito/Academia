package sjc.fatec.padbi.aluno.controller;

import static java.lang.Boolean.TRUE;
import static org.hibernate.criterion.MatchMode.ANYWHERE;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sjc.fatec.padbi.academia.dao.ObjetivoDao;
import sjc.fatec.padbi.academia.model.Objetivo;
import sjc.fatec.padbi.aluno.dao.AlunoDao;
import sjc.fatec.padbi.aluno.model.Aluno;

@Controller
public class AlunoController {

	@Autowired
	private AlunoDao dao;
	@Autowired
	private ObjetivoDao objetivoDao;
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
		if (result.hasErrors()) {
			return "forward:/?pagina=editaAluno";
		}

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
	
	@RequestMapping(value = "/avaliarAluno/{passo}")
	public String avaliar(@PathVariable Integer passo, @RequestParam(required = false) Long id, Model model){
		switch (passo) {
		case 0:
			model.addAttribute("avaliar", TRUE);
			model.addAttribute("pagina", "listarAluno");
			return listar(model);
		case 1:
			Aluno aluno = dao.buscar(id);
			if (id == null)
				return avaliar(Integer.valueOf(0), Long.valueOf(0), model);
			
			context.setAluno(aluno);
			List<Objetivo> objetivos = objetivoDao.buscarPorAluno(aluno.getId());
			model.addAttribute(objetivos);
			return "academia/objetivo";
		default:
			return null;
		}
	}

}
