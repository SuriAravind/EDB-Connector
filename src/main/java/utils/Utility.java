package utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Suriyanarayanan K
 * on 08/03/21 11:49 AM.
 */
public class Utility {

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String timeDiff(LocalDateTime startTime,LocalDateTime endTime){
        Duration duration=Duration.between(startTime, endTime);
        return duration.toHours()+"hrs"+","+duration.toMinutes()+"mins,"+duration.getSeconds()+"secs,"+duration.toMillis()+"millis";
    }
    public static String currentTimeString(){
        return LocalDateTime.now().format(formatter);
    }
}
