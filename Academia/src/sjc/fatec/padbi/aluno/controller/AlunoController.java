package sjc.fatec.padbi.aluno.controller;

import static org.hibernate.criterion.MatchMode.ANYWHERE;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.criterion.MatchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.java.swing.plaf.motif.resources.motif;

import sjc.fatec.padbi.aluno.dao.AlunoDao;
import sjc.fatec.padbi.aluno.model.Aluno;

@Controller
public class AlunoController {

	@Autowired
	private AlunoDao dao;
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
		if (alunos == null || alunos.isEmpty()) {
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
	public String buscar(String nome, Model model) {
		List<Aluno> alunos = dao.buscarPorNome(nome, ANYWHERE);
		context.setAlunosBuscado(alunos);
		
		model.addAttribute("pagina", "listarAluno");
		return "redirect:/";
	}

}
