package com.ACB.SubRA.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;

/**
 * @author ThucCD
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "menu")
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Integer menuId;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "action_name")
    private String actionName;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "created_time")
    private Date createdTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_parent_id", nullable = false)
    private Menu parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "menu")
    private Set<EmployeeMenu> employeeMenus;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "menus")
    private Set<Employee> employees;

    // Các thuộc tính này để tạo interceptor check danh sách menu mà user được phép sử dụng.
    @Transient
    private List<Menu> childrenMenu = new ArrayList<>();
    @Transient
    private Set<String> allowMenuLink = new HashSet<>(0);
}
