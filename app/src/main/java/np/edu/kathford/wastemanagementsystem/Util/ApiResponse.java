package np.edu.kathford.wastemanagementsystem.Util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ApiResponse {

    public ApiResponse(Object object, String message, boolean success) {
        this.object = object;
        this.message = message;
        this.success = success;
    }

    private Object object;

    private String message;

    private boolean success;

}
