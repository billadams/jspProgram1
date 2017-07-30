package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Bill
 */
public class DateUtil {
    
    public static LocalDate getDateToday() {
        
        LocalDate today = LocalDate.now();
        
        return today;
    }
    
    public static String formatDateToString(LocalDate date) {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateFormatted = dtf.format(date);
        
        return dateFormatted;
    }
}
