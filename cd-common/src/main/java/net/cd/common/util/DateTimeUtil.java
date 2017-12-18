package net.cd.common.util;

import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.function.Supplier;

/**
 * Date time utils
 *
 * @author Igor_Zhukov
 */
public class DateTimeUtil {
    /**
     * ISO 8601 date format (yyyyMMdd)
     */
    public static final String ISO_8601_DATE_FORMAT = "yyyyMMdd";

    /**
     * ISO 8601 time format (HHmm)
     */
    public static final String ISO_8601_TIME_FORMAT = "HHmmss";

    /**
     *  time format (HHmm)
     */
    public static final String HHMM_TIME_FORMAT = "HH:mm";

    /**
     * AM/PM time format (h:mm a)
     */
    public static final String AM_PM_TIME_FORMAT = "h:mm a";


    /**
     * ISO 8601 date time format (yyyyMMddTHHmmss)
     */
    public static final String ISO_8601_DATE_TIME_FORMAT = ISO_8601_DATE_FORMAT + "'T'" + ISO_8601_TIME_FORMAT;

    /**
     * ISO 8601 date time format (yyyyMMddHHmmss)
     */
    public static final String ISO_8601_DATE_TIME_SECONDS_FORMAT = ISO_8601_DATE_FORMAT + ISO_8601_TIME_FORMAT;

    /**
     * yyyyMMddHHmmss date format
     */
    public static final String YYYYMMDDHHMMSS_DATE_TIME_FORMAT = "yyyyMMddHHmmss";

    /**
     * ISO 8601 date time formatter (yyyyMMdd)
     */
    private static final DateTimeFormatter ISO_8601_DATE_FORMATTER = DateTimeFormatter.ofPattern(ISO_8601_DATE_FORMAT);

    /**
     * ISO 8601 time format (HHmm)
     */
    private static final DateTimeFormatter ISO_8601_TIME_FORMATER = DateTimeFormatter.ofPattern(ISO_8601_TIME_FORMAT);

    /**
     * time format (HHmm)
     */
    private static final DateTimeFormatter HHMM_TIME_FORMATER = DateTimeFormatter.ofPattern(HHMM_TIME_FORMAT);

    /**
     * yyyyMMddHHmmss date formatter
     */
    private static final DateTimeFormatter YYYYMMDDHHMMSS_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(YYYYMMDDHHMMSS_DATE_TIME_FORMAT);

    /**
     * ISO 8601 date time format (yyyyMMddHHmm)
     */
    private static final DateTimeFormatter ISO_8601_DATE_TIME_FORMATER = DateTimeFormatter.ofPattern(ISO_8601_DATE_TIME_FORMAT);

    /**
     * AM/PM time format
     */
    private static final DateTimeFormatter AM_PM_TIME_FORMATER = DateTimeFormatter.ofPattern(AM_PM_TIME_FORMAT);

    /**
     * System zone id
     */
    private static final ZoneId ZONE_ID = ZoneId.systemDefault();

    /**
     * dd postfix (for adding to yyyyMM string)
     */
    private static final String FIRST_DAY_OF_MONTH_POSTFIX = "01";

    /**
     * @return system zone id
     */
    public static ZoneId getZoneId() {
        return ZONE_ID;
    }

    /**
     * Converts LocalDate to Date at system default time zone at the start of the day
     *
     * @param localDate date
     * @return instance of Date
     */
    public static Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(getZoneId()).toInstant());
    }

    /**
     * Converts LocalDateTime to Date at system default time zone
     *
     * @param localDateTime dateTime
     * @return instance of Date
     */
    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(getZoneId()).toInstant());
    }

    /**
     * Converts LocalDateTime to LocalDate at system default time zone
     *
     * @param localDateTime dateTime
     * @return instance of LocalDate
     */
    public static LocalDate toLocalDate(LocalDateTime localDateTime) {
        return LocalDate.from(localDateTime.atZone(getZoneId()).toLocalDate());
    }

    /**
     * Converts String to Date according to formatter at system default time zone
     *
     * @param dateStr date in a string format
     * @return instance of Date
     */
    public static Date toDate(String dateStr, DateTimeFormatter formatter) {
        return DateTimeUtil.toDate(LocalDate.parse(dateStr, formatter));
    }

    /**
     * Converts LocalDate to LocalDateTime at system default time zone at the start of the day
     *
     * @param localDate localDate to convert
     * @return instance of LocalDateTime
     */
    public static LocalDateTime toLocaleDateTime(LocalDate localDate){
        return localDate.atStartOfDay(getZoneId()).toLocalDateTime();
    }

    /**
     * Converts Date to LocalDateTime at system default time zone
     *
     * @param date date to convert
     * @return instance of LocalDateTime
     */
    public static LocalDateTime toLocaleDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), getZoneId());
    }

    /**
     * @return ISO 8601 date formatter (yyyyMMdd)
     */
    public static DateTimeFormatter getIso8601DateFormatter() {
        return ISO_8601_DATE_FORMATTER;
    }

    /**
     * @return ISO 8601  time formatter (HHmm)
     */
    public static DateTimeFormatter getIso8601TimeFormatter() {
        return ISO_8601_TIME_FORMATER;
    }

    /**
     * @return  time formatter (HHmm)
     */
    public static DateTimeFormatter getHHmmTimeFormatter() {
        return HHMM_TIME_FORMATER;
    }

    /**
     * @return ISO 8601 date time formatter (yyyyMMddHHmm)
     */
    public static DateTimeFormatter getIso8601DateTimeFormatter() {
        return ISO_8601_DATE_TIME_FORMATER;
    }

    /**
     * @return yyyyMMddHHmmss date time formatter
     */
    public static DateTimeFormatter getYyyymmddhhmmssDateTimeFormatter() {
        return YYYYMMDDHHMMSS_DATE_TIME_FORMATTER;
    }

    /**
     * @return AM/PM time formatter
     */
    public static DateTimeFormatter getAmPmTimeFormater() {
        return AM_PM_TIME_FORMATER;
    }

    /**
     * @return AM/PM time formatter by locale
     */
    public static DateTimeFormatter getAmPmTimeFormater(Locale locale) {
        return  DateTimeFormatter.ofPattern(AM_PM_TIME_FORMAT, locale);
    }

    /**
     * Obtains an instance of {@code LocalDate} from a text string using a specific formatter or LocalDate supplier (in case if text is null or empty).
     *
     * @param text            the text to parse
     * @param formatter       the formatter to use, not null
     * @param defaultSupplier supplier for LocalDate in case if text is null or empty
     * @return the parsed or supplied local date, not null
     * @throws java.time.format.DateTimeParseException if the text cannot be parsed
     */
    public static LocalDate parseLocalDate(String text, DateTimeFormatter formatter, Supplier<LocalDate> defaultSupplier) {
        if (StringUtils.isEmpty(text)) {
            return defaultSupplier.get();
        } else {
            return LocalDate.parse(text, formatter);
        }
    }

    public static LocalTime parseLocalTime(String text, DateTimeFormatter formatter, Supplier<LocalTime> defaultSupplier) {
        if (StringUtils.isEmpty(text)) {
            return defaultSupplier.get();
        } else {
            return LocalTime.parse(text, formatter);
        }
    }


    /**
     * now minus 1 month supplier
     */
    private static final Supplier<LocalDate> LOCAL_DATE_MONTH_BEFORE_SUPPLIER = () -> LocalDate.now().minusMonths(1);

    /**
     * @return now minus 1 month supplier
     */
    public static Supplier<LocalDate> getLocalDateMonthBeforeSupplier() {
        return LOCAL_DATE_MONTH_BEFORE_SUPPLIER;
    }

    /**
     * now supplier
     */
    private static final Supplier<LocalDate> LOCAL_DATE_NOW_SUPPLIER = LocalDate::now;

    /**
     * @return now supplier
     */
    public static Supplier<LocalDate> getLocalDateNowSupplier() {
        return LOCAL_DATE_NOW_SUPPLIER;
    }

    /**
     * now supplier
     */
    private static final Supplier<LocalTime> LOCAL_TIME_NOW_SUPPLIER = LocalTime::now;

    /**
     * @return now supplier
     */
    public static Supplier<LocalTime> getLocalTimeNowSupplier() {
        return LOCAL_TIME_NOW_SUPPLIER;
    }

    /**
     * Checks whether begin date is less or equals than end date
     *
     * @param begin begin date
     * @param end   end date
     * @return true if period is valid (begin <= end), false otherwise
     */
    public static boolean isValidPeriod(LocalDate begin, LocalDate end) {
        return begin.compareTo(end) <= 0;
    }

    /**
     * Epoch day date
     */
    public static final LocalDate EPOCH_DAY_DATE = LocalDate.ofEpochDay(0);

    /**
     * @param day date
     * @return the beginning of the day
     */
    public static Date getEndOfDay(Date day) {
        LocalDateTime endOfDayLocalDateTime = day.toInstant().atZone(TimeZone.getDefault().toZoneId()).toLocalDate().atTime(LocalTime.MAX);
        return Date.from(endOfDayLocalDateTime.atZone(TimeZone.getDefault().toZoneId()).toInstant());
    }

    /**
     * @param localDateTime date
     * @return the beginning of the day
     */
    public static LocalDateTime getEndOfDay(LocalDateTime localDateTime) {
        return localDateTime.toLocalDate().atTime(LocalTime.MAX);
    }

    /**
     * @param day date
     * @return the start of the day
     */
    public static Date getStartOfDay(Date day) {
        LocalDateTime startOfDayLocalDateTime = day.toInstant().atZone(TimeZone.getDefault().toZoneId()).toLocalDate().atStartOfDay();
        return Date.from(startOfDayLocalDateTime.atZone(TimeZone.getDefault().toZoneId()).toInstant());
    }

    /**
     * @param localDateTime date
     * @return the start of the day
     */
    public static LocalDateTime getStartOfDay(LocalDateTime localDateTime) {
        return localDateTime.toLocalDate().atStartOfDay();
    }

    /**
     * @param yearMonthString yyyyMM string
     * @return month's first day date
     */
    public static LocalDate parseDateFromYearMonthString(String yearMonthString) {
        return parseDateFromYearMonthDayString(yearMonthString + FIRST_DAY_OF_MONTH_POSTFIX);
    }

    /**
     * @param yearMonthDayString yyyyMM string
     * @return parsed date as a LocalDate object
     */
    public static LocalDate parseDateFromYearMonthDayString(String yearMonthDayString) {
        return DateTimeUtil.parseLocalDate(
                yearMonthDayString,
                DateTimeUtil.getIso8601DateFormatter(),
                DateTimeUtil.getLocalDateNowSupplier()
        );
    }

    /**
     * @param date
     * @param months months to add
     * @return last day or the month for @date with added @months
     */

    public static LocalDate addMonthsTillEndOfYear(LocalDate date, int months) {
        LocalDate plusDate = date.plusMonths(months).with(TemporalAdjusters.lastDayOfMonth());
        if (plusDate.getYear() > date.getYear()) {
            plusDate = date.with(TemporalAdjusters.lastDayOfYear());
        }

        return plusDate;
    }

    /**
     * @param date
     * @param years years to add
     * @return last day or the month for @date with added @months
     */
    public static LocalDate addYearsTillEndOfYear(LocalDate date, int years) {
        LocalDate plusDate = date.plusYears(years).with(TemporalAdjusters.lastDayOfMonth());
        /*if (plusDate.getYear() > date.getYear()) {
            plusDate = date.with(TemporalAdjusters.lastDayOfYear());
        }*/

        return plusDate;
    }

    public static LocalTime min(LocalTime date1, LocalTime date2) {
        return date1.isBefore(date2) ? date1 : date2;
    }

    public static LocalTime max(LocalTime date1, LocalTime date2) {
        return date1.isAfter(date2) ? date1 : date2;
    }

    public static String dateTimeFormatter(LocalDateTime dateTime,Locale locale){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd MMM,yyyy").withLocale(locale);
        return dateTime.format(formatter);
    }

}
