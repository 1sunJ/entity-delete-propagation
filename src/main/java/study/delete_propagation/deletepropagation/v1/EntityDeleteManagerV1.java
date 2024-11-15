package study.delete_propagation.deletepropagation.v1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.JpaRepository;
import study.delete_propagation.deletepropagation.EntityDeleteManager;
import study.delete_propagation.deletepropagation.EntityRelationManager;
import study.delete_propagation.entity.club.deletedclub.DeletedClub;

import java.util.Map;

@Slf4j
//@Component
@RequiredArgsConstructor
public class EntityDeleteManagerV1 implements EntityDeleteManager {

    private final Map<String, JpaRepository> repositoryMap;
    private final EntityRelationManager entityRelationManager;


    @Override
    public void deleteEntity(Object entity) {

    }

    private String resolveMapKey(Object entity) {
        String simpleName = entity.getClass().getSimpleName();
        String entityName = String.valueOf(simpleName.charAt(0)).toLowerCase() + simpleName.substring(1);
        return entityName + "Repository";
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        log.info(" ===== start ===== ");
        for (String key : repositoryMap.keySet()) {
            log.info("key : {}, value : {}", key, repositoryMap.get(key));
        }
        log.info(" ====== end ====== ");

        String key = resolveMapKey(new DeletedClub());
        log.info("resolved key : {}", key);
    }

}
