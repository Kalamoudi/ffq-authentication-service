package edu.fiu.ffqr.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.fiu.ffqr.models.User;
import edu.fiu.ffqr.models.Clinician;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="parents")
public class Parent implements Serializable{

	@JsonProperty("parentId")
	private int parentId; 
	@JsonProperty("username")
	private String username;
	@JsonProperty("userpassword")
    private String userpassword;
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("assignedClinic")
	private int assignedClinic;
	@JsonProperty("assignedClinician")
    private String assignedClinician;

	public Parent() {}
	
	public Parent(int parentId, String username, String userpassword, String firstname, String lastname, int assignedClinic, String assignedClinician){
        this.parentId = parentId;
		this.username = username;
		this.userpassword = userpassword;
        this.firstname = firstname;
        this.lastname = lastname;
        this.assignedClinic = assignedClinic;
        this.assignedClinician = assignedClinician;

    }
	
	public int getParentId() {
		return this.parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getUsername() {
		return this.username;
    }
    
    public String getFullname() {
        return (this.firstname + " " + this.lastname);
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getAssignedClinician() {
        return this.assignedClinician;
    }
    public void setAssignedClinician(String assignedClinician) {
        this.assignedClinician = assignedClinician;
            
    }

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String userpassword){
		this.userpassword = userpassword;
	}

    public int getAssignedClinic() {
        return this.assignedClinic;
    }

    public void setAssignedClinic(int assignedClinic) {
		this.assignedClinic = assignedClinic;
	}

}
