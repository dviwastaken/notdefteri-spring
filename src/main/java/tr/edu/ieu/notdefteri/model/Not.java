package tr.edu.ieu.notdefteri.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "notlar") // "not" H2'de ayrilmis sozcuk oldugu icin tablo adi acikca verildi
public class Not {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Baslik bos olamaz")
    @Size(max = 100, message = "Baslik en fazla 100 karakter olabilir")
    private String baslik;

    @Size(max = 1000, message = "Icerik en fazla 1000 karakter olabilir")
    @Column(length = 1000)
    private String icerik;

    private LocalDateTime olusturmaZamani = LocalDateTime.now();

    public Not() {
    }

    public Not(String baslik, String icerik) {
        this.baslik = baslik;
        this.icerik = icerik;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBaslik() { return baslik; }
    public void setBaslik(String baslik) { this.baslik = baslik; }

    public String getIcerik() { return icerik; }
    public void setIcerik(String icerik) { this.icerik = icerik; }

    public LocalDateTime getOlusturmaZamani() { return olusturmaZamani; }
    public void setOlusturmaZamani(LocalDateTime olusturmaZamani) { this.olusturmaZamani = olusturmaZamani; }
}
