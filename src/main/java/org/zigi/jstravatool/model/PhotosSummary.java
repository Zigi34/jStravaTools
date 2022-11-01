package org.zigi.jstravatool.model;

public class PhotosSummary {
    private Integer count;
    private PhotosSummaryPrimary primary;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public PhotosSummaryPrimary getPrimary() {
        return primary;
    }

    public void setPrimary(PhotosSummaryPrimary primary) {
        this.primary = primary;
    }

    @Override
    public String toString() {
        return "PhotosSummary{" +
                "count=" + count +
                ", primary=" + primary +
                '}';
    }
}
