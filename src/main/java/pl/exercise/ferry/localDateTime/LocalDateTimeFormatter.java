package pl.exercise.ferry.localDateTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeFormatter {

public static String getDate() {
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH.mm.ss");
    String formatDateTime = currentDateTime.format(formatter);
    return formatDateTime;
    }
}
