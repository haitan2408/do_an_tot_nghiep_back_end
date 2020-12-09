package com.goruslan.socialgeeking.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.goruslan.socialgeeking.service.BeanUtil;
import lombok.*;
import org.ocpsoft.prettytime.PrettyTime;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comment extends Auditable implements  Comparable<Comment>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String body;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @NonNull
    @JsonBackReference
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public String getPrettyTime() {
        PrettyTime pt = BeanUtil.getBean(PrettyTime.class);
        return pt.format(convertToDateViaInstant(getCreationDate()));
    }

    private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public int compareTo(Comment o) {
        return o.getCreationDate().compareTo(this.getCreationDate());
    }
}
