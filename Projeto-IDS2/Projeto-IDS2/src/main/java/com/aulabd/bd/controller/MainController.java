package com.aulabd.bd.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aulabd.bd.model.Cliente;
import com.aulabd.bd.model.ClienteService;
import com.aulabd.bd.model.Fornecedor;
import com.aulabd.bd.model.Obra;


@Controller
public class MainController {

    @Autowired
    ClienteService clienteServico;

    @Autowired
    ApplicationContext context;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/editarObra")
    public String editarobra(){
        return "editarObra";
    }

    @GetMapping("/listarClientes")
    public String listarclientes(Model model){
        ClienteService cs = context.getBean(ClienteService.class);
        List<Map<String,Object>> lr = cs.puxarTodosClientes();
        List<Cliente> lc = Cliente.converternClientes(lr);
        model.addAttribute("clientes",lc);
        return "listarClientes";
    }

    @GetMapping("/listarObras")
    public String listarobras(Model model){
        ClienteService ob = context.getBean(ClienteService.class);
        List<Map<String,Object>> lgeral = ob.puxarTodasObras();
        List<Obra> lo = Obra.converterTodasObras(lgeral);
        model.addAttribute("obras",lo);
        model.addAttribute("nomeCliente", "Todas as Obras");
        return "listarObras";
    }

    @GetMapping("/listarFornecedores")
    public String listarFornecedor(Model model){
        ClienteService fs = context.getBean(ClienteService.class);
        List<Map<String,Object>> forn = fs.puxarTodosFornecedores();
        List<Fornecedor> lf = Fornecedor.converterTodosFornecedores(forn);
        model.addAttribute("fornecedores",lf);
        return "listarFornecedores";
    }

    @GetMapping("/cadastroCliente")
    public String cadastroCliente(Model model){
        model.addAttribute("dadoscliente", new Cliente());
        model.addAttribute("link", "/formulariocliente");
        return "cadastroCliente";
    }

    @GetMapping("/cadastroFornecedor")
    public String cadastroFornecedor(Model model){
        model.addAttribute("dadosfornecedor", new Fornecedor());
        model.addAttribute("linkFornecedor", "/formularioFornecedor");
        return "cadastroFornecedor";
    }

    @GetMapping("/cadastroObra")
    public String cadastroObra(Model model){
        model.addAttribute("dadosObra", new Obra());
        model.addAttribute("lincar", "/formularioObra");
        return "cadastroObra";
    }
    
    @GetMapping("/editarCliente/{idCliente}")
    public String editarCliente(Model model, @PathVariable int idCliente){
        ClienteService cs = context.getBean(ClienteService.class);
        Map<String,Object> reg = cs.puxarCliente(idCliente);
        Cliente cli = Cliente.converterUmCliente(reg);
        model.addAttribute("dadoscliente", cli);
        model.addAttribute("formulariocliente", "/editarCliente/" + idCliente);
        model.addAttribute("link", "/editarCliente/" + idCliente);
        return "cadastroCliente";
    }


    @GetMapping("/editarObra/{idObra}")
    public String editarObra(Model model, @PathVariable int idObra){
        Map<String, Object> regObra = clienteServico.puxarObra(idObra);
        Obra obra = Obra.converterUmaObra(regObra);
        model.addAttribute("dadosObra", obra);
        model.addAttribute("lincar", "/editarObra/" + idObra);
        return "cadastroObra";
    }

    @GetMapping("/editarFornecedor/{idFornecedor}")
    public String editarForncecedor(Model model, @PathVariable int idFornecedor){
        Map<String, Object> regForc = clienteServico.puxarFornecedor(idFornecedor);
        Fornecedor forn = Fornecedor.converterUmFornecedor(regForc);
        model.addAttribute("dadosfornecedor", forn);
        model.addAttribute("linkFornecedor", "/editarFornecedor/" + idFornecedor);
        return "cadastroFornecedor";
    }
    

    
    
// === Posts \/

    @PostMapping("/formularioObra")
    public String cadastrarObra(Model model, @ModelAttribute Obra infoObra){
        clienteServico.inserirObra(infoObra);
        return "redirect:/listarObras";
    }

    @PostMapping("/formulariocliente")
    public String cadastrarcliente(Model model, @ModelAttribute Cliente infoCliente){
        clienteServico.inserirCliente(infoCliente);
        return "redirect:cadastroCliente";
    }

    @PostMapping("/formularioFornecedor")
    public String cadastrarfornecedor(Model model, @ModelAttribute Fornecedor infoFornecedor){
        clienteServico.inserirFornecedor(infoFornecedor);
        return "redirect:cadastroFornecedor";
    }

    @PostMapping("/deletarCliente/{idCliente}")
    public String deletarCliente(@PathVariable int idCliente){
        ClienteService cs = context.getBean(ClienteService.class);
        cs.deletar(idCliente);
        return "redirect:/listarClientes";
    }

    @PostMapping("/editarCliente/{idCliente}")
    public String editarCliente(@ModelAttribute Cliente cli, @PathVariable int idCliente){
        ClienteService cs = context.getBean(ClienteService.class);
        cs.atualizarCliente(cli,idCliente);
        return "redirect:/listarClientes";
    }

    @PostMapping("/deletarObra/{idObra}")
    public String deletarObra(@PathVariable int idObra){
        clienteServico.deletarObra(idObra);
        return "redirect:/listarObras";
    }

    @PostMapping("/editarObra/{idObra}")
    public String atualizarObra(@ModelAttribute Obra obra, @PathVariable int idObra){
    clienteServico.atualizarObra(obra, idObra);
    return "redirect:/listarObras";
    }

    @PostMapping("/deletarFornecedor/{idFornecedor}")
    public String atualizarFornecedor(@PathVariable int idFornecedor){
        clienteServico.deletarFornecedor(idFornecedor);
        return "redirect:/listarFornecedores";
    }

    @PostMapping("/editarFornecedor/{idFornecedor}")
    public String atualizarFornecedor(@ModelAttribute Fornecedor forn, @PathVariable int idFornecedor){
    clienteServico.atualizarFornecedor(forn, idFornecedor);
    return "redirect:/listarFornecedores";
    }

// === JOIN \/ testando

    @GetMapping("/obrasDoCliente/{idCliente}")
    public String listarObrasDoCliente(Model model, @PathVariable int idCliente){
        ClienteService cs = context.getBean(ClienteService.class);
        List<Map<String,Object>> listaRegistrosObras = cs.puxarObrasPorIdCliente(idCliente);
        List<Obra> listaObjetosObras = Obra.converterTodasObras(listaRegistrosObras);
        Map<String, Object> regCliente = cs.puxarCliente(idCliente);
        Cliente cliente = Cliente.converterUmCliente(regCliente);
        model.addAttribute("nomeCliente", cliente.getNomeEmpresa());
        model.addAttribute("obras", listaObjetosObras);
        return "listarObras";
    }
}
