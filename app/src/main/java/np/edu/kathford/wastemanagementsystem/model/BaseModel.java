package np.edu.kathford.wastemanagementsystem.model;

import java.util.Date;

import lombok.Data;

@Data
public class BaseModel {

    private Long id;

    private User createdBy;

    private User modifiedBy;

    private Date createdDate;

    private Date modifiedDate;

}