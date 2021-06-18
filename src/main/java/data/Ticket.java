package data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    public static final String HARD_SEAT = "Hard seat";
    public static final String SOFT_SEAT = "Soft seat";
    public static final String SOFT_SEAT_CONDITIONER = "Soft seat with air conditioner";
    public static final String HARD_BED = "Hard bed";
    public static final String SOFT_BED = "Soft bed";
    public static final String SOFT_BED_CONDITIONER = "Soft bed with air conditioner";

    public static final String IGNORE = "Ignore";
    public static final String EXPIRED_TICKET = "Expired";
    public static final String NEW_TICKET = "New";
    public static final String PAID_TICKET = "Paid";

    private String departDate;
    private String departFrom;
    private String arriveAt;
    private String seatType;
    private int amount;
    private String status;

}
