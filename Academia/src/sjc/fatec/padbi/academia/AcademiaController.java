package sjc.fatec.padbi.academia;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class AcademiaController {
	
	@RequestMapping(method= {RequestMethod.GET, RequestMethod.POST})
	public String index(){
		return "site/index";
	}
	
	@RequestMapping("/index")
	public String indexJsp(){
		return index();
	}
	
}
