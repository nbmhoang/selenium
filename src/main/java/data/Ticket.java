package data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    private String departDate;
    private String departStation;
    private String arriveStation;
    private String seatType;
    private int amount;

}
