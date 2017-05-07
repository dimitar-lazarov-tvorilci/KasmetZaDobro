package com.tvorilci.mitko.kasmetzadobro.data;

import android.support.annotation.NonNull;

/**
 * TODO: Documentation to be created
 */
public final class LittleLuck {

    @NonNull
    private String goodThought;

    @NonNull
    private String goodDeed;

    @NonNull
    private int timesShown;

    public LittleLuck(@NonNull String goodThought,
                      @NonNull String goodDeed, @NonNull int timesShown) {
        this.goodThought = goodThought;
        this.goodDeed = goodDeed;
        this.timesShown = timesShown;
    }

    public LittleLuck(@NonNull String goodThought, @NonNull String goodDeed) {
        this(goodThought, goodDeed, 0);
    }

    public String getGoodThought() {
        return goodThought;
    }

    public String getGoodDeed() {
        return goodThought;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LittleLuck luck = (LittleLuck) o;
        return goodThought.equals(luck.goodThought) &&
                goodDeed.equals(luck.goodDeed);
    }

    @NonNull
    public int getTimesShown() {
        return timesShown;
    }

    public void setTimesShown(@NonNull int timesShown) {
        this.timesShown = timesShown;
    }
}
