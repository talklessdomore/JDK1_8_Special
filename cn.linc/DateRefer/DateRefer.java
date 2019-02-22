package cn.linc.DateRefer;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * 描述:
 * 日期引用
 *
 * @author xiechenglin
 * @create 2019-02-22 15:50
 */
public class DateRefer {

    @Test
    public void testLocaleTime(){
        String time = defaultDateToGMT(DateZoneEnum.Beijing,"yyyyMMdd");
        System.out.println(time);
    }

    //国际化时区操作
    public String defaultDateToGMT(DateZoneEnum dateZoneEnum, String dateFormat) {
        Instant timestamp = Instant.now();
        ZoneId zoneId = ZoneId.of("GMT");
        LocalDateTime datetime = LocalDateTime.ofInstant(timestamp,zoneId);
        long timeValue = dateZoneEnum.getTimeValue();
        datetime = datetime.plusMinutes(timeValue);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat, Locale.ENGLISH);
        String time = datetime.format(dateTimeFormatter);
        return time;
    }
}
