package Physio_Beans;

//Schedule Bean

public class Schedule {
	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int Schedule_No;
    private String Physio_NIC;
    private String Customer_NIC;
    private String Age;					//Declare variables
    private String Height;
    private String Weight;
    private String Photos;
    private String Status;
    private String Exercise;
    private String Rep;
    private String Turn;
    private String[][] Steps;
    
    
//constructers
	public Schedule(int Schedule_No,String Physio_NIC,String Customer_NIC,String Age,String Height,String Weight,String Photos,String Status) {
        super();
        this.Schedule_No=Schedule_No;
        this.Physio_NIC=Physio_NIC;
        this.Customer_NIC=Customer_NIC;
        this.Age=Age;
        this.Height=Height;
        this.Weight=Weight;
        this.Photos=Photos;
        this.Status=Status;
    }
    
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
    
    public Schedule(int Schedule_No,String Exercise) {
        super();
        this.Schedule_No=Schedule_No;
        this.Exercise=Exercise;
    }
    
    public Schedule(int Schedule_No,String Exercise,String Rep,String Turn) {
        super();
        this.Schedule_No=Schedule_No;
        this.Exercise=Exercise;
        this.Rep=Rep;
        this.Turn=Turn;
    }
    public Schedule(int Schedule_No,String steps[][]) {
        super();
        this.Schedule_No=Schedule_No;
        this.setSteps(steps);
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
    
    
    //getters And Setters
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
	
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}



	public String getExercise() {
		return Exercise;
	}

	public void setExercise(String exercise) {
		Exercise = exercise;
	}

	public String getRep() {
		return Rep;
	}

	public void setRep(String rep) {
		Rep = rep;
	}

	public String getTurn() {
		return Turn;
	}

	public void setTurn(String turn) {
		Turn = turn;
	}

	public String[][] getSteps() {
		return Steps;
	}

	public void setSteps(String[][] steps) {
		Steps = steps;
	}
    

}
