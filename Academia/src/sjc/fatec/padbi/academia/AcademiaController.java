package sjc.fatec.padbi.academia;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sjc.fatec.padbi.academia.model.Objetivo;

@Controller
@RequestMapping("/")
public class AcademiaController {

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String index() {
		return "academia/index";
	}

	@RequestMapping("/index")
	public String indexJsp() {
		return index();
	}
	
	@RequestMapping("/cadastroObjetivo")
	public String cadastroObjetivo(Model model){
		model.addAttribute(new Objetivo());
		return "objetivo/cadastrar";
	}

}
