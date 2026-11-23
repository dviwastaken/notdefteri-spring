package tr.edu.ieu.notdefteri.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import tr.edu.ieu.notdefteri.model.Not;
import tr.edu.ieu.notdefteri.service.NotService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/notlar")
public class NotController {

    private final NotService service;

    public NotController(NotService service) {
        this.service = service;
    }

    @GetMapping
    public List<Not> listele() {
        return service.hepsiniGetir();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Not ekle(@Valid @RequestBody Not not) {
        return service.kaydet(not);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> sil(@PathVariable Long id) {
        return service.sil(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> dogrulamaHatasi(MethodArgumentNotValidException e) {
        return e.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage, (a, b) -> a));
    }
}
