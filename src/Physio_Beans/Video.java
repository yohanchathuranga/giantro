package Physio_Beans;

public class Video {
	
	
		public Video() {
			super();
			// TODO Auto-generated constructor stub
		}
		private int Video_ID;
		private String User_NIC;
		private String Topic;
	    private String Video;
	    private String Category;					//Declare variables
	    private String Status;
	    private int View_Count;
	 
	    
	    
	//constructers
		public Video(int Video_ID,String Topic,String User_NIC,String Video,String Category,String Status) {
	        super();
	        this.Video_ID=Video_ID;
	        this.Topic=Topic;
	        this.User_NIC=User_NIC;
	        this.Video=Video;
	        this.Category=Category;
	        this.Status=Status;
	    }
		
		public Video(int Video_ID,String Topic,String User_NIC,String Video,String Category) {
	        super();
	        this.Video_ID=Video_ID;
	        this.Topic =Topic;
	        this.User_NIC=User_NIC;
	        this.Video=Video;
	        this.Category=Category;
	        
	    }
		
		public Video(String Topic,String User_NIC,String Video,String Category) {
	        super();
	        
	        this.Topic =Topic;
	        this.User_NIC=User_NIC;
	        this.Video=Video;
	        this.Category=Category;
	        
	    }
	    
		public Video(int Video_ID) {
	        super();
	        this.Video_ID=Video_ID;
	    }
	    
	    public int getVideo_ID() {
			return Video_ID;
		}

		public void setVideo_ID(int video_ID) {
			Video_ID = video_ID;
		}

		public String getUser_NIC() {
			return User_NIC;
		}

		public void setUser_NIC(String user_NIC) {
			User_NIC = user_NIC;
		}

		public String getVideo() {
			return Video;
		}

		public void setVideo(String video) {
			Video = video;
		}

		public String getCategory() {
			return Category;
		}

		public void setCategory(String category) {
			Category = category;
		}

		public String getStatus() {
			return Status;
		}

		public void setStatus(String status) {
			Status = status;
		}

		public String getTopic() {
			return Topic;
		}

		public void setTopic(String topic) {
			Topic = topic;
		} 
	    
	    
	   

}
