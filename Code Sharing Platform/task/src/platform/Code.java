package platform;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="Code")
public class Code{

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(generator="system-uuid")
//    @GenericGenerator(name="system-uuid", strategy = "uuid")
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(
//            name = "UUID",
//            strategy = "org.hibernate.id.UUIDGenerator"
//    )
    @Column(name = "ID", updatable = false, nullable = false, length = 255)
//    @ColumnDefault("random_uuid()")
    @Getter
    @Setter
    private long id;


    public void setId(long id) {
        this.id = id;
    }

    @Column
    private String code;

    public long getId() {
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