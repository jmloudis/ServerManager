package io.JordanDev.server.model;

import io.JordanDev.server.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author JordanDev
 * @version 1.0.0
 * @since 5/7/2022
 * */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Server implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "IP Address cannot be empty or null")
    private String ipAddress;
    private String name;
    private String memory;
    private String type;
    private String imageUrl;

    //enum
    private Status status;


}
