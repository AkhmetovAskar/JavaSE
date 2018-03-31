package samples.date_time_api;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class TestDateTime {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now);
        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalDate myBirthday = LocalDate.of(1991, Month.JANUARY,19);
        System.out.println(myBirthday);
        Period myAge = Period.between(myBirthday, today);
        System.out.println("years : " + myAge.getYears());
        System.out.println("months : " + myAge.getMonths());
        System.out.println("days : " + myAge.getDays());
        System.out.println("months total : " + ChronoUnit.MONTHS.between(myBirthday, today));
        System.out.println("days total : " + ChronoUnit.DAYS.between(myBirthday, today));
        System.out.println("days total 2 : " + myBirthday.until(today, ChronoUnit.DAYS));
    }
}
