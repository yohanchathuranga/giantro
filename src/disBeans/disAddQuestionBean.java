package disBeans;

public class disAddQuestionBean {
	private String nic;
	private String topic;
	private String category;
	private String Question;
	
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	@Override
	public String toString() {
		return "disAddQuestionBean [nic=" + nic + ", topic=" + topic + ", category=" + category + ", Question="
				+ Question + "]";
	}
	public disAddQuestionBean(String nic, String topic, String category, String question) {
		super();
		this.nic = nic;
		this.topic = topic;
		this.category = category;
		Question = question;
	}
	
	
}
