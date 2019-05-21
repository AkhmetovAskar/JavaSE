package datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class TestDateTime {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println("Instant : " + now);
        LocalDate today = LocalDate.now();
        System.out.println("LocalDate : " + today);
        LocalTime todayTime = LocalTime.now();
        System.out.println("LocalTime : " + todayTime);
        LocalDate myBirthday = LocalDate.of(1991, Month.JANUARY,19);
        System.out.println(myBirthday);
        Period myAge = Period.between(myBirthday, today);
        System.out.println("years : " + myAge.getYears());
        System.out.println("months : " + myAge.getMonths());
        System.out.println("days : " + myAge.getDays());
        System.out.println("months total : " + ChronoUnit.MONTHS.between(myBirthday, today));
        System.out.println("days total : " + ChronoUnit.DAYS.between(myBirthday, today));
        System.out.println("days total 2 : " + myBirthday.until(today, ChronoUnit.DAYS));
        TemporalAdjuster tommorowAdjuster = t -> t.plus(1, ChronoUnit.DAYS);
        LocalDate tommorow = today.with(tommorowAdjuster);
        System.out.println(tommorow);
        ZonedDateTime nowZoned = ZonedDateTime.now();
        System.out.println("ZonedDateTime : " + nowZoned);
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println("Formatter : " + formatter.withLocale(Locale.getDefault()).format(nowZoned));
        Date date = new Date();
        System.out.println("java.util.Date to Instant : " + date.toInstant());
        System.out.println("Instant to java.util.Date : " + Date.from(now));
        GregorianCalendar calendar = (GregorianCalendar) Calendar.getInstance();
        System.out.println("GregorianCalendar to ZonedDateTime : " + calendar.toZonedDateTime());
        System.out.println("ZonedDateTime to GregorianCalendar : " + GregorianCalendar.from(nowZoned));
    }
}
