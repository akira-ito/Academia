package sjc.fatec.padbi.academia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sjc.fatec.padbi.academia.dao.ColetaDao;
import sjc.fatec.padbi.academia.dao.ModalidadeDao;
import sjc.fatec.padbi.academia.dao.ObjetivoDao;
import sjc.fatec.padbi.academia.dao.SerieDao;
import sjc.fatec.padbi.academia.model.Modalidade;
import sjc.fatec.padbi.academia.model.Objetivo;
import sjc.fatec.padbi.academia.model.Ombro;
import sjc.fatec.padbi.academia.model.Peito;
import sjc.fatec.padbi.academia.model.Perfil;
import sjc.fatec.padbi.academia.model.Perna;
import sjc.fatec.padbi.academia.model.Semana;
import sjc.fatec.padbi.academia.model.Serie;
import sjc.fatec.padbi.aluno.controller.AlunoContext;

@Controller
@RequestMapping("/")
public class AcademiaController {

	@Autowired
	private AlunoContext alunoContext;
	@Autowired
	private ObjetivoDao objetivoDao;
	@Autowired
	private ModalidadeDao modalidadeDao;
	@Autowired
	private SerieDao serieDao;
	@Autowired
	private ColetaDao coletaDao;

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

	@RequestMapping("/cadastroSerie")
	public String cadastroSerie(Model model, HttpServletRequest request) {
		if (request.getAttribute("serie") == null) {
			Serie serie = new Serie();
			model.addAttribute(serie);
		}

		List<Modalidade> tipoModalidade = new ArrayList<Modalidade>(Arrays.asList(new Ombro(),
				new Perna(), new Peito()));
		List<Semana> semanas = new ArrayList<Semana>(Arrays.asList(Semana
				.values()));
		List<Serie> series = alunoContext.getObjetivo().getSeries();
		if (series != null)
			for (Serie serie : series){
				semanas.removeAll(serie.getSemanas());
				for (int x = 0; x<tipoModalidade.size(); x++) {
					if (tipoModalidade.get(x).getTipoModalidade().equals(serie.getModalidade().getTipoModalidade())){
						tipoModalidade.remove(x);
						x--;
					}
				}
			}
		model.addAttribute("tipoModalidade", tipoModalidade);
		model.addAttribute("semanas", semanas);

		return "serie/cadastrar";
	}

	@RequestMapping("/cadastrarSerie")
	public String cadastrarSerie(@Valid Serie serie, BindingResult result,
			@RequestParam String tipoModalidade, Model model) {
		if (result.hasErrors()) {
			return "forward:/?pagina=cadastroSerie";
		}

		Modalidade modalidade = null;
		if (tipoModalidade.equals("Ombro")) {
			modalidade = new Ombro();
		} else if (tipoModalidade.equals("Perna")) {
			modalidade = new Perna();
		} else {
			modalidade = new Peito();
		}

		modalidade = serie.getModalidade().clone(modalidade);
		modalidade.setSerie(serie);
		serie.setModalidade(modalidade);
		serie.setObjetivo(alunoContext.getObjetivo());

		serieDao.cadastrar(serie);

		model.addAttribute("id", alunoContext.getObjetivo().getId());
		model.addAttribute("pagina", "avaliarAluno/2");
		model.addAttribute("msg", "serieCadastradoSucesso");
		return "redirect:/";
	}

	@RequestMapping("/cadastroColeta")
	public String cadastroColeta(Model model, HttpServletRequest request) {
		if (request.getAttribute("perfil") == null) {
			model.addAttribute(new Perfil());
		}
		return "coleta/cadastrar";
	}

	@RequestMapping("/cadastrarColeta")
	public String cadastrarColeta(@Valid Perfil perfil, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "forward:/?pagina=cadastroColeta";
		}

		perfil.setDataColeta(new Date());
		perfil.setObjetivo(alunoContext.getObjetivo());
		coletaDao.cadastrar(perfil);

		model.addAttribute("id", alunoContext.getObjetivo().getId());
		model.addAttribute("pagina", "avaliarAluno/2");
		model.addAttribute("msg", "coletaCadastradoSucesso");
		return "redirect:/";
	}

}
