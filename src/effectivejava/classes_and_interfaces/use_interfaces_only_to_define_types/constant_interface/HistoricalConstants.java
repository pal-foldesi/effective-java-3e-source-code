package effectivejava.classes_and_interfaces.use_interfaces_only_to_define_types.constant_interface;

import java.time.LocalDate;
import java.time.Month;

//Not preferred! Dangerous, because it can be implemented
public interface HistoricalConstants {
    LocalDate BEGINNING_OF_WWII = LocalDate.of(1939, Month.SEPTEMBER, 1);
    LocalDate END_OF_WWII = LocalDate.of(1945, Month.SEPTEMBER, 2);
}
