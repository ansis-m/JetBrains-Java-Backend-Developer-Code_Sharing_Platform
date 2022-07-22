package platform;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="Code")
@Setter
@Getter
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
    @JsonIgnore
    private LocalDateTime dateTime;

    @Column
    private Integer views;

    @Column
    private Integer time;

    @Column
    @JsonIgnore
    private boolean limitTime;

    @Column
    @JsonIgnore
    private boolean limitViews;

    public Code() {
        date = LocalDate.now();
    }


    public Code(CodeInput input) {
        this.code = input.getCode();
        this.time = Integer.parseInt(input.getTime());
        this.views = Integer.parseInt(input.getViews());
        date = LocalDate.now();
        dateTime = LocalDateTime.now();
        this.limitViews = this.views > 0;
        this.limitTime = this.time > 0;
    }

    public void setViews(String views) {
        this.views = Integer.valueOf(views);
    }

    public void setTime(String time) {
        this.time = Integer.valueOf(time);
    }

    public void view(){
        this.views--;
    }

    public boolean limitedViews(){
        return limitViews;
    }

    public boolean limitedTime(){
        return limitTime;
    }
}