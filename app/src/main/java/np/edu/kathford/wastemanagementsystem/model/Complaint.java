package np.edu.kathford.wastemanagementsystem.model;

import lombok.Data;

@Data
public class Complaint extends BaseModel {

    private String heading;

    private String complaint;

    private String status;

}