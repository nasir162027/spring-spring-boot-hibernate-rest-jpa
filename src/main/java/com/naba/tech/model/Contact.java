package com.naba.tech.model;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class Contact extends BaseEntity {

   private int contactId;

   @NotBlank(message="Name must not be blank")
   @Size(min=3, message="Name must be at least 3 characters long")
   private String name;

   @NotBlank(message="Mobile number must not be blank")
   @Pattern(regexp="(^$|[0-9]{11})",message = "Mobile number must be 11 digits")
   private String mobileNum;

   @NotBlank(message="Email must not be blank")
   @Email(message = "Please provide a valid email address" )
   private String email;

   @NotBlank(message="Subject must not be blank")
   @Size(min=5, message="Subject must be at least 5 characters long")
   private String subject;

   @NotBlank(message="Message must not be blank")
   @Size(min=10, message="Message must be at least 10 characters long")
   private String message;

   private String status;
}
