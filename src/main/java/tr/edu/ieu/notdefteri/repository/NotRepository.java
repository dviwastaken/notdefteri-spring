package tr.edu.ieu.notdefteri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.edu.ieu.notdefteri.model.Not;

import java.util.List;

public interface NotRepository extends JpaRepository<Not, Long> {

    List<Not> findAllByOrderByOlusturmaZamaniDesc();
}
