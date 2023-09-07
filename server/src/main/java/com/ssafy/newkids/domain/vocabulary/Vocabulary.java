package com.ssafy.newkids.domain.vocabulary;

import com.ssafy.newkids.domain.TimeBaseEntity;
import com.ssafy.newkids.domain.member.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 단어장 entity
 *
 * @author 임우택
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Vocabulary extends TimeBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vocabulary_id")
    private Long id;

    @Column(nullable = false, name = "`check`")
    private Boolean check;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "word_id")
    private Word word;

    @Builder
    public Vocabulary(Boolean check, Member member, Word word) {
        this.check = check;
        this.member = member;
        this.word = word;
    }
}
