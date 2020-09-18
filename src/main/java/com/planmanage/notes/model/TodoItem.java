package com.planmanage.notes.model;

import java.util.Date;
import java.util.UUID;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "todo_item")
public class TodoItem {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="itemId")
    private Long itemId;

    @Column(name="listId")
    @Type(type="pg-uuid")
    private UUID listId;

    @Column(name="taskName")
    @NotEmpty( message="* Enter Task Name")
    private String taskName;

    @Column(name="isDone")
    private Boolean isDone = false;

    @Column(name="createdAt")
    private Date createdAt = new Date();
}
