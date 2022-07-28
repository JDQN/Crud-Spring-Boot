package org.sofka.mykrello.model.domain;


import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Value;

@Data
@Entity
@Table(name = "krl_task")
public class TaskDomain implements Serializable {

    private static final long serialVersionUID = 1L;


    @PreUpdate
    public void preUpdate() {
        if (this.updated == null)
            this.updated = Instant.now();
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

    @Column(name = "brd_id_board")
    private Integer board;


    @Column(name = "tsk_delivery_date")
    private Instant delivery;

    @Column(name = "tsk_created_at")
    private Instant created = Instant.now();

    @Column(name = "tsk_updated_at")
    private Instant updated;


    /**
     * Aqui estamos haciendo una relacion de 1 a muchos,
     * esto es porque una tarea tiene muchos logs,
     * @return una lista de logs
     */
    @JsonManagedReference(value = "log-task")
    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY, targetEntity = LogDomain.class, cascade = CascadeType.ALL)
    private List<LogDomain> logs = new ArrayList<>();


    /**
     * Aqui estamos haciendo una relacion de 1 a muchos,
     * esto es porque una tarea tiene muchos logs,
     * @return
     */
    @JoinColumn(name = "clm_id_column", insertable = false, updatable = false)
    @JsonBackReference(value = "column-tasks")
    @ManyToOne(fetch = FetchType.LAZY)
    private ColumnDomain columnDomain;

    @JoinColumn(name = "brd_id_board", insertable = false, updatable = false)
    @JsonBackReference(value = "taskForBoard")
    @ManyToOne(fetch = FetchType.LAZY)
    private BoardDomain boardTask;

}