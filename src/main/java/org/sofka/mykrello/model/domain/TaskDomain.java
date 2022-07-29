package org.sofka.mykrello.model.domain;


import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;


@Entity /**/ @Table(name = "krl_task")
@Getter /**/ @Setter

public class TaskDomain implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @PreUpdate
    public void preUpdate() {
        if (this.updatedT == null)
            this.updatedT = Instant.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tsk_id", nullable = false)
    private Integer id;

    @Column(name = "tsk_name")
    private String name;

    @Column(name = "tsk_description")
    private String description;

    @Column(name = "clm_id_column")
    private Integer column;

    @Column(name ="brd_id_board")
    private Integer board;

    @Column(name = "tsk_delivery_date")
    private Instant delivery;

    @Column(name = "tsk_created_at")
    private Instant createdT = Instant.now();

    @Column(name = "tsk_updated_at")
    private Instant updatedT;

    @JsonManagedReference(value = "log-task")
    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY, targetEntity = LogDomain.class, cascade = CascadeType.ALL)
    private List<LogDomain> logs = new ArrayList<>();

    // Relaciones

    @JoinColumn(name = "clm_id_column", insertable = false, updatable = false)
    @JsonBackReference(value = "column-tasks")
    @ManyToOne(fetch = FetchType.LAZY)
    private ColumnDomain columnDomain;

    @JoinColumn(name = "brd_id_board", insertable = false, updatable = false)
    @JsonBackReference(value = "taskForBoard")
    @ManyToOne(fetch = FetchType.LAZY)
    private BoardDomain boardTask;

}