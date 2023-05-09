package np.edu.kathford.wastemanagementsystem.model;

import java.util.Date;

import lombok.Data;

@Data
public class Admin {

    private Long id;

    private String name;

    private String username;

    private String salt;

    private String password;

    private String email;

    private String address;

    private String role;

    private boolean blocked;

    private String phoneNo;

    private String mobileNo;

    private boolean status;

    private Date createdDate;

    private Date modifiedDate;
}
