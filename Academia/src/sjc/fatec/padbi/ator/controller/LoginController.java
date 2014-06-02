package sjc.fatec.padbi.ator.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import sjc.fatec.padbi.ator.dao.AtorDao;
import sjc.fatec.padbi.ator.model.Ator;
import sjc.fatec.padbi.ator.model.Login;

@Controller
public class LoginController {
	
	@Autowired
	private AtorDao dao;

	@RequestMapping("/login")
	public String login(Model model, HttpServletRequest request){
		if (request.getAttribute("login") == null){
			model.addAttribute(new Login());
		}
		return "logar/logar";
	}
	
	@RequestMapping("/logado")
	public String logado(){
		return "logar/logado";
	}
	
	@RequestMapping("/logar")
	public String logar(Login login, Model model, HttpSession session){
		
		Ator ator = dao.logar(login);
		if (ator == null){
			model.addAttribute("loginInvalido", Boolean.TRUE);
			return "forward:index";
		}
		
		session.setAttribute("atorLogado", ator);
		return "redirect:/";
	}
	
	@RequestMapping("/sair")
	public String sair(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
}
