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
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "ID", updatable = false, nullable = false)
    @ColumnDefault("random_uuid()")
    private UUID id;

    @Column
    private String code;

    @Column
    private LocalDate date;

    @Column
    private Integer views;

    @Column
    private Integer time;

    public Code() {
        date = LocalDate.now();
    }

    public Code(String code, String views, String time) {
        this.code = code;
        this.time = Integer.valueOf(time);
        this.views = Integer.valueOf(views);
        date = LocalDate.now();
    }

    public Code(CodeInput input) {
        this.code = input.getCode();
        this.time = Integer.parseInt(input.getTime());
        this.views = Integer.parseInt(input.getViews());
        date = LocalDate.now();
    }


    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
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

    public int getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = Integer.valueOf(views);
    }

    public int getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = Integer.valueOf(time);
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public void setViews(Integer views) {
        this.views = views;
    }
}