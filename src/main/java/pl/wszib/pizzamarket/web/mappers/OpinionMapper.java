package pl.wszib.pizzamarket.web.mappers;

import org.springframework.stereotype.Component;
import pl.wszib.pizzamarket.data.entity.OpinionEntity;
import pl.wszib.pizzamarket.web.models.OpinionModel;

@Component
public class OpinionMapper {

    public static OpinionEntity toEntity(OpinionModel opinionModel) {
        OpinionEntity opinionEntity = new OpinionEntity();
        opinionEntity.setName(opinionModel.getName());
        opinionEntity.setContent(opinionModel.getContent());
        return opinionEntity;
    }


    public static OpinionModel toModel(OpinionEntity opinionEntity) {
        OpinionModel opinionModel = new OpinionModel();
        opinionModel.setName(opinionEntity.getName());
        opinionModel.setContent(opinionEntity.getContent());
        return opinionModel;

    }

}
