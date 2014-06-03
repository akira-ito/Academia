package sjc.fatec.padbi.academia;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sjc.fatec.padbi.academia.dao.ObjetivoDao;
import sjc.fatec.padbi.academia.model.Objetivo;
import sjc.fatec.padbi.aluno.controller.AlunoContext;

@Controller
@RequestMapping("/")
public class AcademiaController {

	@Autowired
	private AlunoContext alunoContext;
	@Autowired
	private ObjetivoDao objetivoDao;

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String index() {
		return "academia/index";
	}

	@RequestMapping("/index")
	public String indexJsp() {
		return index();
	}

	@RequestMapping("/cadastroObjetivo")
	public String cadastroObjetivo(Model model, HttpServletRequest request) {
		if (request.getAttribute("objetivo") == null)
			model.addAttribute(new Objetivo());
		return "objetivo/cadastrar";
	}

	@RequestMapping("/cadastrarObjetivo")
	public String cadastrarObjetivo(@Valid Objetivo objetivo,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "forward:/?pagina=cadastroObjetivo";
		}

		objetivo.setAluno(alunoContext.getAluno());
		objetivo.setInicio(new Date());
		objetivoDao.cadastrar(objetivo);

		model.addAttribute("id", alunoContext.getAluno().getId());
		model.addAttribute("pagina", "avaliarAluno/1");
		model.addAttribute("msg", "objetivoCadastradoSucesso");
		return "redirect:/";
	}

}
