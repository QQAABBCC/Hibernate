package tw.hibernatedemo.model;

public class CompanyBean {

	private int companyId;
	private String companyName;
	
	public CompanyBean(int companyId, String companyName) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
}

	public String getCompanyName() {return companyName;}

	public void setCompanyName(String companyName) {this.companyName = companyName;}

	public CompanyBean() {}

	public int getCompanyId() {return companyId;}

	public void setCompanyId(int companyId) {this.companyId = companyId;}

	

}
