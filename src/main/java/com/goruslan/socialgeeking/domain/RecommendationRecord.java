package com.goruslan.socialgeeking.domain;

import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
public class RecommendationRecord implements Comparable<RecommendationRecord> {
    private double score;
    private String attributeName;

    public int compareTo(RecommendationRecord other) {
        if (this.score > other.score)
            return -1;
        if (this.score < other.score)
            return 1;
        return 0;
    }

    public String toString() {
        return attributeName + ": " + score;
    }
}
