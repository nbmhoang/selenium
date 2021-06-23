package data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filter {

    private String departStation;
    private String arriveStation;
    private String departDate;
    private String ticketStatus;

}
