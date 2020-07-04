package supplement_shop_model;

public class supplement_shop_viewd_count {
	
	private String jan;
	private String feb;
	private String march;
	private String aprail;
	private String may;
	private String june;
	private String july;
	private String aggust;
	private String september;
	private String october;
	private String november;
	private String december;
	public int jan_feb;
	public int mar_apr;
	public int may_june;
	public int july_agu;
	public int sep_oct;
	public int nov_dec;
	public String getJan() {
		return jan;
	}
	public void setJan(String jan) {
		this.jan = jan;
	}
	public String getFeb() {
		return feb;
	}
	public void setFeb(String feb) {
		this.feb = feb;
	}
	public String getMarch() {
		return march;
	}
	public void setMarch(String march) {
		this.march = march;
	}
	public String getAprail() {
		return aprail;
	}
	public void setAprail(String aprail) {
		this.aprail = aprail;
	}
	public String getMay() {
		return may;
	}
	public void setMay(String may) {
		this.may = may;
	}
	public String getJune() {
		return june;
	}
	public void setJune(String june) {
		this.june = june;
	}
	public String getJuly() {
		return july;
	}
	public void setJuly(String july) {
		this.july = july;
	}
	public String getAggust() {
		return aggust;
	}
	public void setAggust(String aggust) {
		this.aggust = aggust;
	}
	public String getSeptember() {
		return september;
	}
	public void setSeptember(String september) {
		this.september = september;
	}
	public String getOctober() {
		return october;
	}
	public void setOctober(String october) {
		this.october = october;
	}
	public String getNovember() {
		return november;
	}
	public void setNovember(String november) {
		this.november = november;
	}
	public String getDecember() {
		return december;
	}
	public void setDecember(String december) {
		this.december = december;
	}
	public void set_prec() {
		this.jan_feb= (Integer.parseInt(getJan())+Integer.parseInt(getFeb()))/10;
		this.mar_apr =(Integer.parseInt(getMarch())+Integer.parseInt(getAprail()))/10;
		this.may_june=(Integer.parseInt(getMay())+Integer.parseInt(getJune()))/10;
		this.july_agu=(Integer.parseInt(getJuly())+Integer.parseInt(getAggust()))/10;
		this.sep_oct=(Integer.parseInt(getSeptember())+Integer.parseInt(getOctober()))/10;
		this.nov_dec=(Integer.parseInt(getNovember())+Integer.parseInt(getDecember()))/10;
	}
		

}
