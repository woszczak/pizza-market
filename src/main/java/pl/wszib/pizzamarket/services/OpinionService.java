package pl.wszib.pizzamarket.services;


import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.wszib.pizzamarket.data.entity.OpinionEntity;
import pl.wszib.pizzamarket.data.entity.PizzaEntity;
import pl.wszib.pizzamarket.data.repositories.OpinionRepository;
import pl.wszib.pizzamarket.web.mappers.OpinionMapper;
import pl.wszib.pizzamarket.web.mappers.PizzaMapper;
import pl.wszib.pizzamarket.web.models.OpinionModel;
import pl.wszib.pizzamarket.web.models.PizzaModel;

import java.util.List;

@Service
public class OpinionService {

    private final OpinionRepository opinionRepository;
    private final OpinionMapper opinionMapper;


    public OpinionService(OpinionRepository opinionRepository, OpinionMapper opinionMapper) {
        this.opinionRepository = opinionRepository;
        this.opinionMapper = opinionMapper;
    }


    public List<OpinionModel> findAll(){
        List<OpinionEntity>  entities = opinionRepository.findAll();

        return entities.stream()
                .map(OpinionMapper::toModel)
                .toList();
    }


    @Transactional
    public void addOpinion(OpinionModel opinionModel) {

        OpinionEntity opinionEntity = opinionMapper.toEntity(opinionModel);
        opinionRepository.save(opinionEntity);

}

    public OpinionModel getById(Long opinionId) {
        OpinionEntity opinionEntity = opinionRepository.findById(opinionId).orElseThrow(EntityNotFoundException::new);
        return OpinionMapper.toModel(opinionEntity);
    }
}
