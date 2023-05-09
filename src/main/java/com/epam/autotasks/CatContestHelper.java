package com.epam.autotasks;

import java.util.List;
import java.util.function.Predicate;

public class CatContestHelper {

    public static final Integer CARRIER_THRESHOLD = 30;

    public Integer getCarrierNumber(List<Cat> cats) {
        int weightSum = cats.stream().map(cat -> cat.getWeight() <= 0.5 ? 1 : cat.getWeight()).reduce(0, Integer::sum);
        if (weightSum % 30 == 0) {
            return weightSum / 30;
        } else {
            return weightSum / 30 + 1;
        }
    }

    public String getCarrierId(List<Cat> cats) {
        final Predicate<Cat> valueNotNullOrEmpty
                = e -> e.getName() != null && !e.getName().isEmpty() &&
                e.getBreed() != null;

        return cats.stream()
                .filter(valueNotNullOrEmpty)
                .map(cat -> cat.getName().substring(0, 3).toUpperCase() + cat.getBreed().toString().substring(0, 3))
                .reduce("CF", String::concat);
    }

    public Integer countTeamAwards(List<Cat> cats) {
        return cats.stream()
                .map(Cat::getAwards)
                .reduce(0, Integer::sum);
    }
}