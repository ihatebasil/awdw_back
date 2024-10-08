package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Setter
public class Quiz extends BaseEntity{

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family")
    private Family family;

    @OneToMany(mappedBy = "quiz")
    private List<QuizAnswer> quizAnswers;

}
