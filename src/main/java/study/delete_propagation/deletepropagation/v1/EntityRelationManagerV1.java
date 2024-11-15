package study.delete_propagation.deletepropagation.v1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import study.delete_propagation.deletepropagation.EntityRelationManager;

import java.util.List;

@Slf4j
//@Component
@RequiredArgsConstructor
public class EntityRelationManagerV1 implements EntityRelationManager {

    @Override
    public List<Class<?>> getChildClasses(Object entity) {
        return null;
    }

}
