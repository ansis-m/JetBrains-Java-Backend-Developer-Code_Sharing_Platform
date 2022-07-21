package platform;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Code")
public class Code{

    @Id
    @JsonIgnore
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    String id;


    public void setId(String id) {
        this.id = id;
    }

    @Column
    private String code;

    public String getId() {
        return id;
    }

    @Column
    private LocalDate date;

    public Code() {
        date = LocalDate.now();
    }

    public Code(String code) {
        this.code = code;
        date = LocalDate.now();
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Code{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", date=" + date +
                '}';
    }
}