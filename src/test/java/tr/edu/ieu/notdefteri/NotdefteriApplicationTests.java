package tr.edu.ieu.notdefteri;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tr.edu.ieu.notdefteri.model.Not;
import tr.edu.ieu.notdefteri.service.NotService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = "spring.datasource.url=jdbc:h2:mem:test")
class NotdefteriApplicationTests {

    @Autowired
    NotService service;

    @Test
    void kaydedilenNotOkunabilir() {
        Not kayit = service.kaydet(new Not("Deneme", "Merhaba"));
        assertNotNull(kayit.getId());
        assertTrue(service.hepsiniGetir().stream().anyMatch(n -> n.getId().equals(kayit.getId())));
        assertTrue(service.sil(kayit.getId()));
    }
}
