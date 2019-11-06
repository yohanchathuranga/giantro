package appointment;



public class Appointment {
	public Appointment() {
    }


    private int Appointment_No;
    private String Physio_NIC;
    private String Customer_NIC;
    private String Date;
    private String Time;
    private String Status;
    
    public Appointment(int Appointment_No,String Physio_NIC,String Customer_NIC,String date,String time,String Status) {
        super();
        this.Appointment_No=Appointment_No;
        this.Physio_NIC=Physio_NIC;
        this.Customer_NIC=Customer_NIC;
        this.Date=date;
        this.Time=time;
        this.Status=Status;
    }
    
    public Appointment(int Appointment_No) {
    	this.Appointment_No=Appointment_No;
    }
    
	public Appointment(String Physio_NIC,String Customer_NIC,String date,String time,String Status) {
		this.Physio_NIC=Physio_NIC;
        this.Customer_NIC=Customer_NIC;
        this.Date=date;
        this.Time=time;
        this.Status=Status;	
	}

    /**
     * @return the Appointment_No
     */
    public int getAppointment_No() {
        return Appointment_No;
    }

    /**
     * @param Appointment_No the Appointment_No to set
     */
    public void setAppointment_No(int Appointment_No) {
        this.Appointment_No = Appointment_No;
    }

    /**
     * @return the Physio_NIC
     */
    public String getPhysio_NIC() {
        return Physio_NIC;
    }

    /**
     * @param Physio_NIC the Physio_NIC to set
     */
    public void setPhysio_NIC(String Physio_NIC) {
        this.Physio_NIC = Physio_NIC;
    }

    /**
     * @return the Customer_NIC
     */
    public String getCustomer_NIC() {
        return Customer_NIC;
    }

    /**
     * @param Customer_NIC the Customer_NIC to set
     */
    public void setCustomer_NIC(String Customer_NIC) {
        this.Customer_NIC = Customer_NIC;
    }

    /**
     * @return the Time
     */
    public String getTime() {
        return Time;
    }

    /**
     * @param Time the Time to set
     */
    public void setTime(String Time) {
        this.Time = Time;
    }

    /**
     * @return the Status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }

    /**
     * @return the Date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(String Date) {
        this.Date = Date;
    }

}
