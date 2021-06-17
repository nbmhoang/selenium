package data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordInfo {

    private String currentPassword;
    private String newPassword;
    private String confirmPassword;

}
