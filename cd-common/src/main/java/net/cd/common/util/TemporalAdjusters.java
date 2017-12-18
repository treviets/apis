package net.cd.common.util;

import java.time.temporal.TemporalAdjuster;

import static java.time.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH;
import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoUnit.WEEKS;

public final class TemporalAdjusters {

    private TemporalAdjusters() {
    }

    public static TemporalAdjuster firstDayOfWeekInMonth() {
        return (temporal) -> temporal.with(ALIGNED_DAY_OF_WEEK_IN_MONTH, 1);
    }

    public static TemporalAdjuster lastDayOfWeekInMonth() {
        return (temporal) -> temporal.with(ALIGNED_DAY_OF_WEEK_IN_MONTH, temporal.range(ALIGNED_DAY_OF_WEEK_IN_MONTH).getMaximum());
    }

    public static TemporalAdjuster firstDayOfNextWeekInMonth() {
        return (temporal) -> temporal.with(ALIGNED_DAY_OF_WEEK_IN_MONTH, 1).plus(1, WEEKS);
    }

    public static TemporalAdjuster lastDayOfNextWeekInMonth() {
        return (temporal) -> temporal
                .with(
                        ALIGNED_DAY_OF_WEEK_IN_MONTH,
                        temporal.range(ALIGNED_DAY_OF_WEEK_IN_MONTH).getMaximum())
                .plus(1, WEEKS);
    }

    public static TemporalAdjuster lastDayOfLastWeekInMonth() {
        return (temporal) -> temporal
                .with(DAY_OF_MONTH, temporal.range(DAY_OF_MONTH).getMaximum())
                .with(ALIGNED_DAY_OF_WEEK_IN_MONTH, temporal.range(ALIGNED_DAY_OF_WEEK_IN_MONTH).getMaximum());
    }

    public static TemporalAdjuster firstDayOfFirstWeekInMonth() {
        return (temporal) -> temporal.with(DAY_OF_MONTH, 1);
    }
}
