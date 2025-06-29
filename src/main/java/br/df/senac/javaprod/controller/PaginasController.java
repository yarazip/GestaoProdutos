package br.df.senac.javaprod.controller;

import br.df.senac.javaprod.dto.CategoriaDTO;
import br.df.senac.javaprod.dto.ProdutoDTO;
import br.df.senac.javaprod.service.CategoriaService;
import br.df.senac.javaprod.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import java.util.List;

@Controller
public class PaginasController {

    @GetMapping("/")
    public String mostrarPagina() {
        return "index";
    }
    @GetMapping("/dashboard")
    public String mostrarDashboard() {
        return "dashboard";  
    }

    
    @Autowired
    private ProdutoService produtoService;
    
    
    
    @GetMapping("/produto")
    public String exibirProdutos(Model model) {
        List<ProdutoDTO> produtos = produtoService.listarTodos();
        model.addAttribute("produtos", produtos);
        return "produto";
    }
    
    @GetMapping("/produto/formProduto")
    public String mostrarFormularioP(@RequestParam(value = "id", required = false) Long id, Model model) {
    	ProdutoDTO produtoDTO = new ProdutoDTO(); 
    	
        List<CategoriaDTO> categorias = categoriaService.ListarTodas();
        model.addAttribute("categorias", categorias); 

        if (id != null) {
        	ProdutoDTO existente = produtoService.buscarPorId(id);
            if (existente != null) {
            	produtoDTO = existente;
            } else {
                System.out.println("Categoria com ID " + id + " não encontrada para edição.");
            }
        }
        model.addAttribute("produto", produtoDTO);
        return "formProduto";
    }

    
    @PostMapping("/produto/salvar")
    public String salvarOuAtualizarProduto(@ModelAttribute("Produto") @Valid ProdutoDTO produtoDTO,
                                             BindingResult result, 
                                             Model model) {
        if (result.hasErrors()) {
            System.out.println("Erros de validação: " + result.getAllErrors());
            return "formProduto"; 
        }

        if (produtoDTO.getId() == null) {
        	produtoService.salvar(produtoDTO);
        } else {
        	produtoService.atualizar(produtoDTO.getId(), produtoDTO);
        }
        
        return "redirect:/produto"; 
    }
    
    @Autowired
    private CategoriaService categoriaService;

    
    @GetMapping("/categoria")
    public String exibirCategorias(Model model) {
        List<CategoriaDTO> categorias = categoriaService.ListarTodas();
        model.addAttribute("categorias", categorias);
        return "categoria";
    }
    
    @GetMapping("/categoria/formCategoria")
    public String mostrarFormulario(@RequestParam(value = "id", required = false) Long id, Model model) {
        CategoriaDTO categoriaDTO = new CategoriaDTO(); 

        if (id != null) {
            CategoriaDTO existente = categoriaService.buscarPorId(id);
            if (existente != null) {
                categoriaDTO = existente;
            } else {
                System.out.println("Categoria com ID " + id + " não encontrada para edição.");
            }
        }
        model.addAttribute("categoria", categoriaDTO);
        return "formCategoria";
    }

    @PostMapping("/categoria/salvar")
    public String salvarOuAtualizarCategoria(@ModelAttribute("categoria") @Valid CategoriaDTO categoriaDTO,
                                             BindingResult result, 
                                             Model model) {
        if (result.hasErrors()) {
            System.out.println("Erros de validação: " + result.getAllErrors());
            return "formCategoria"; 
        }

        if (categoriaDTO.getId() == null) {
            categoriaService.salvar(categoriaDTO);
        } else {
            categoriaService.atualizar(categoriaDTO.getId(), categoriaDTO);
        }
        
        return "redirect:/categoria"; 
    }
}