

package cn.linc.DateRefer;


public enum DateZoneEnum {
    Beijing("GMT+08:00",480);

    /**
     * 区域类型值
     */
    private String gmt;
    /**
     * 时间值
     */
    private int timeValue;


    public String getGmt() {
        return gmt;
    }

    public void setGmt(String gmt) {
        this.gmt = gmt;
    }

    public int getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(int timeValue) {
        this.timeValue = timeValue;
    }

    DateZoneEnum(String gmt, int timeValue) {
        this.gmt = gmt;
        this.timeValue = timeValue;
    }
}
