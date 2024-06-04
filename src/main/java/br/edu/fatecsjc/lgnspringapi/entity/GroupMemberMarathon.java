package br.edu.fatecsjc.lgnspringapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "group_member_marathon")
public class GroupMemberMarathon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_member_id")
    private GroupMember groupMember;

    @ManyToOne
    @JoinColumn(name = "marathon_id")
    private Marathon marathon;

    // Getters and setters
}