package com.ACB.SubRA.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.io.Serializable;
import java.util.Set;

/**
 * @author ThucCD
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "work")
public class Work implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_id")
    private Integer workId;

    @Column(name = "work_name")
    private String workName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_flow_id", nullable = false)
    private WorkFlow workFlow;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_previous_id", nullable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Work workPrevious ;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_next_id", nullable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Work workNext;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "work")
    private Set<Incident> incidents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_type_id", nullable = false)
    private WorkType workType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "work")
    private Set<SharedWork> sharedWorks;

    @Column(name = "server_process")
    private int serverProcess;
}
