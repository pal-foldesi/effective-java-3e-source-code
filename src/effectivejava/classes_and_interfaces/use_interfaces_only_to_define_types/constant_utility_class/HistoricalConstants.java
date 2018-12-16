package effectivejava.classes_and_interfaces.use_interfaces_only_to_define_types.constant_utility_class;

import java.time.LocalDate;
import java.time.Month;

public class HistoricalConstants {
    public static final LocalDate BEGINNING_OF_WWII = LocalDate.of(1939, Month.SEPTEMBER, 1);
    public static final LocalDate END_OF_WWII = LocalDate.of(1945, Month.SEPTEMBER, 2);

    private HistoricalConstants() { }
}
