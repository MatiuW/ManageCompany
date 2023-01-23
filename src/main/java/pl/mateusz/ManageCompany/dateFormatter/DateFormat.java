package pl.mateusz.ManageCompany.dateFormatter;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormat {

    public final static String DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";

    public String formatDate(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern(DATE_FORMAT));
    }
}
