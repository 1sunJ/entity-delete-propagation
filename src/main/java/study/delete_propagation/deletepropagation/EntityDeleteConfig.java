package study.delete_propagation.deletepropagation;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import study.delete_propagation.deletepropagation.v1.EntityDeleteManagerV1;
import study.delete_propagation.deletepropagation.v1.EntityRelationManagerV1;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class EntityDeleteConfig {

    private final Map<String, JpaRepository> repositoryMap;

    public EntityRelationManager entityRelations() {
        return new EntityRelationManagerV1();
    }

    public EntityDeleteManager entityDeleteManager() {
        return new EntityDeleteManagerV1(
                repositoryMap,
                entityRelations());
    }

}
