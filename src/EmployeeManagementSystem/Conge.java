package EmployeeManagementSystem;

import java.security.Timestamp;
import java.sql.Date;
   
public class Conge {
    private int id;
    private Date startDate;
    private Date endDate;
    private String description;
    private String status;
    private int userId;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Conge(int id, Date startDate, Date endDate, String description, String status, int userId, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.status = status;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // getters and setters for all fields

    public Conge(Date startDate, Date endDate, String description, int userId) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.userId = userId;
	}

	 

	public Conge(int id, Date startDate, Date endDate, String description, String status, int userId) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.status = status;
		this.userId = userId;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
