package br.com.filmesCadastroApi.controller;

import br.com.filmesCadastroApi.model.FormDTO;
import br.com.filmesCadastroApi.service.AutorService;
import br.com.filmesCadastroApi.service.DiretorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("perfil")
public class PerfilController {
    private final AutorService autorService;
    private final DiretorService diretorService;

    public PerfilController(AutorService autorService, DiretorService diretorService) {
        this.autorService = autorService;
        this.diretorService = diretorService;
    }

    @GetMapping("/perfil/autor{id}")
    public String cadastroAutor(@RequestParam(required = false)
                               @PathVariable("id") Long id, Model model){

        model.addAttribute("add", true);
        FormDTO formDTO = new FormDTO();
        formDTO.setId(id);
        model.addAttribute("pessoa", formDTO);
        return "perfil/perfil";
    }

    @PostMapping("/perfil/autor")
    public String salveAutor(@ModelAttribute("pessoa") FormDTO formDTO, Model model){
        model.addAttribute("add", true);
        autorService.saveAutorFilme(formDTO.getId(), formDTO.getNome(), formDTO.getSobrenome());
        return "perfil/perfil";
    }

    @GetMapping("/perfil/diretor{id}")
    public String cadastroDiretor(@RequestParam(required = false)
                           @PathVariable Long id, Model model){
        model.addAttribute("add", false);
        FormDTO formDTO = new FormDTO();
        formDTO.setId(id);
        model.addAttribute("pessoa", formDTO);
        return "perfil/perfil";
    }

    @PostMapping("/perfil/diretor")
    public String salveDiretor(@ModelAttribute("pessoa")
                               FormDTO formDTO, Model model){
        model.addAttribute("add",false);
        diretorService.saveDiretorFilme(formDTO.getId(), formDTO.getNome(), formDTO.getSobrenome());
        return "perfil/perfil";
    }
}
