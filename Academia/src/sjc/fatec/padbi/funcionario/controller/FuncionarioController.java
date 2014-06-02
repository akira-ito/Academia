package sjc.fatec.padbi.funcionario.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import sjc.fatec.padbi.funcionario.dao.FuncionarioDao;
import sjc.fatec.padbi.funcionario.model.Funcionario;

@Controller
public class FuncionarioController {
	
	@Autowired
	private FuncionarioDao dao;

	@RequestMapping("/cadastroFuncionario")
	public String cadastro(Model model, HttpServletRequest request){
		if (request.getAttribute("funcionario") == null){
			model.addAttribute(new Funcionario());
		}
		return "funcionario/cadastrar";
	}
	
	@RequestMapping("/cadastrarFuncionario")
	public String cadastrarFuncionario(@Valid Funcionario funcionario, BindingResult result){
		if (result.hasErrors()){
			return "funcionario/cadastrar";
		}
		
		dao.cadastrar(funcionario);
		
		return null;
	}
}
