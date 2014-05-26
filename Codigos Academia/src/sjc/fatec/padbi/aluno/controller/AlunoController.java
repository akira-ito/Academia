package sjc.fatec.padbi.aluno.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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

	@RequestMapping("/cadastroAluno")
	public String cadastro(Model model, HttpServletRequest request) {
		if (request.getAttribute("aluno") == null)
			model.addAttribute(new Aluno());
		return "aluno/cadastrar";
	}

	@RequestMapping("/cadastrarAluno")
	public String cadastrar(@Valid Aluno aluno, BindingResult result, HttpServletRequest request, Model model) {
		if (result.hasErrors()) {
			return "forward:/?pagina=cadastroAluno";
		}
		
		dao.cadastrar(aluno);
		model.addAttribute("msg", "alunoCadastradoSucesso");
		return "redirect:/";
	}
	
	@RequestMapping("/listarAluno")
	public String listar(Model model){
		List<Aluno> alunos = dao.listar();
		model.addAttribute("alunos", alunos);
		return "aluno/listar";
	}
	
	@RequestMapping("/editaAluno")
	public String edita(Long id, Model model, HttpServletRequest request){
		if (request.getAttribute("aluno") == null){
			Aluno aluno = dao.buscar(id);
			model.addAttribute(aluno);
		}
		return "aluno/editar";
	}
	
	@RequestMapping("/editarAluno")
	public String editar(@Valid Aluno aluno, BindingResult result, Model model){
		if (result.hasErrors()) {
			return "forward:/?pagina=editaAluno&id=1";
		}
		
		dao.editar(aluno);
		model.addAttribute("msg", "alunoEditadoSucesso");
		model.addAttribute("pagina", "listarAluno");
		return "redirect:/";
	}

}
