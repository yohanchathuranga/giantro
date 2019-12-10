package Schedule;

import java.sql.Blob;

public class Schedule {
	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int Schedule_No;
    private String Physio_NIC;
    private String Customer_NIC;
    private String Age;
    private String Height;
    private String Weight;
    private String Photos;
    
    public Schedule(int Schedule_No,String Physio_NIC,String Customer_NIC,String Age,String Height,String Weight,String Photos) {
        super();
        this.Schedule_No=Schedule_No;
        this.Physio_NIC=Physio_NIC;
        this.Customer_NIC=Customer_NIC;
        this.Age=Age;
        this.Height=Height;
        this.Weight=Weight;
        this.Photos=Photos;
    }
    
    public Schedule(int Schedule_No) {
        super();
        this.Schedule_No=Schedule_No;
    }

    public Schedule(String Physio_NIC,String Customer_NIC,String Age,String Height,String Weight,String Photo) {
        super();
        this.Physio_NIC=Physio_NIC;
        this.Customer_NIC=Customer_NIC;
        this.Age=Age;
        this.Height=Height;
        this.Weight=Weight;
        this.Photos=Photo;
    }
    
    
	public int getSchedule_No() {
		return Schedule_No;
	}
	public void setSchedule_No(int schedule_No) {
		Schedule_No = schedule_No;
	}
	public String getPhysio_NIC() {
		return Physio_NIC;
	}
	public void setPhysio_NIC(String physio_NIC) {
		Physio_NIC = physio_NIC;
	}
	public String getCustomer_NIC() {
		return Customer_NIC;
	}
	public void setCustomer_NIC(String customer_NIC) {
		Customer_NIC = customer_NIC;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getHeight() {
		return Height;
	}
	public void setHeight(String height) {
		Height = height;
	}
	public String getWeight() {
		return Weight;
	}
	public void setWeight(String weight) {
		Weight = weight;
	}
	public String getPhotos() {
		return Photos;
	}
	public void setPhotos(String photos) {
		Photos = photos;
	}
    
    

}
