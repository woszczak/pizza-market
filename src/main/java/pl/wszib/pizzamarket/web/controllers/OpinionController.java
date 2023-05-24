package pl.wszib.pizzamarket.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wszib.pizzamarket.data.entity.OpinionEntity;
import pl.wszib.pizzamarket.services.OpinionService;
import pl.wszib.pizzamarket.web.mappers.OpinionMapper;
import pl.wszib.pizzamarket.web.models.OpinionModel;

@Controller
public class OpinionController {

private final OpinionService opinionService;
private final OpinionMapper opinionMapper;


    public OpinionController(OpinionService opinionService, OpinionMapper opinionMapper) {
        this.opinionService = opinionService;
        this.opinionMapper = opinionMapper;
    }

    @GetMapping("/opinions")
    public String showOpinions(Model model){
        model.addAttribute("opinions", opinionService.findAll());
        model.addAttribute("newOpinion", new OpinionModel());
        return "opinionPage";
    }


    @PostMapping("/opinions")
    public  String addOpinion(@ModelAttribute("newOpinion") OpinionModel opinionModel, Model model){
        opinionService.addOpinion(opinionModel);
        model.addAttribute("opinions", opinionService.findAll());
        model.addAttribute("newOpinion", new OpinionModel());

        return "opinionPage";

    }
}
