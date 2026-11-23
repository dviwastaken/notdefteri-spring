package tr.edu.ieu.notdefteri.service;

import org.springframework.stereotype.Service;
import tr.edu.ieu.notdefteri.model.Not;
import tr.edu.ieu.notdefteri.repository.NotRepository;

import java.util.List;

@Service
public class NotService {

    private final NotRepository repository;

    public NotService(NotRepository repository) {
        this.repository = repository;
    }

    public List<Not> hepsiniGetir() {
        return repository.findAllByOrderByOlusturmaZamaniDesc();
    }

    public Not kaydet(Not not) {
        not.setId(null); // yeni kayit: kimligi veritabani uretsin
        return repository.save(not);
    }

    public boolean sil(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
