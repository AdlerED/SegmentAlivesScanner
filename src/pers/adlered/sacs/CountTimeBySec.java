package pers.adlered.sacs;

public class CountTimeBySec {
    public String CountBySec(long sec) {
        if (sec == 0) {
            return "Just a moment";
        }
        long day = 0;
        long hour = 0;
        long minute = 0;
        if (sec >= 86400) {
            day = sec / 86400;
            sec = sec - (day * 86400);
        }
        if (sec >= 3600) {
            hour = sec / 3600;
            sec = sec - (hour * 3600);
        }
        if (sec >= 60) {
            minute = sec / 60;
            sec = sec - (minute * 60);
        }
        String result = "";
        boolean canSplit = false;
        if (canSplit == true) {
            result = day + ":" + hour + ":" + minute + ":" + sec;
        } else {
            boolean inChinese = false;
            if (inChinese == true) {
                if (day != 0) {
                    result += day + " 天 ";
                }
                if (hour != 0) {
                    result += hour + " 时 ";
                }
                if (minute != 0) {
                    result += minute + " 分 ";
                }
                if (sec != 0) {
                    result += sec + " 秒";
                }
            } else {
                if (day != 0) {
                    result += day + " Day ";
                }
                if (hour != 0) {
                    result += hour + " Hour ";
                }
                if (minute != 0) {
                    result += minute + " Min ";
                }
                if (sec != 0) {
                    result += sec + " Sec";
                }
            }
        }
        return "About " + result;
    }
}