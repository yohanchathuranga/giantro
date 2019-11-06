package User;

public class User {

    private String NIC;
    private String Name;
    private String Email;
    private String Certificate_ID;
    private String Address;
    private String Exp;
    private String Place_Name;
    private String Contact_No;
    private String Status;
    private String PF;
    private String CF;
    private String GF;
    private String SF;
    private String AF;

    public User(String NIC, String Name,String Email,String Certificate_ID,String Address,String Exp,String Place_Name,String Contact_No,String Status,String PF,String CF,String GF,String SF,String AF) {
        super();
        this.NIC=NIC;
        this.Name=Name;
        this.Email=Email;
        this.Certificate_ID=Certificate_ID;
        this.Address=Address;
        this.Exp=Exp;
        this.Place_Name=Place_Name;
        this.Contact_No=Contact_No;
        this.Status=Status;
        this.PF=PF;
        this.CF=CF;
        this.GF=GF;
        this.SF=SF;
        this.AF=AF;
    }
    
    public User(String NIC, String Name,String Email,String Certificate_ID,String Address,String Exp,String Place_Name,String Contact_No,String Status) {
        super();
        this.NIC=NIC;
        this.Name=Name;
        this.Email=Email;
        this.Certificate_ID=Certificate_ID;
        this.Address=Address;
        this.Exp=Exp;
        this.Place_Name=Place_Name;
        this.Contact_No=Contact_No;
        this.Status=Status;
      
    }
    
    public User(String Name,String Email,String Certificate_ID,String Address,String Exp,String Place_Name,String Contact_No,String Status,String PF,String CF,String GF,String SF,String AF) {
        this.Name=Name;
        this.Email=Email;
        this.Certificate_ID=Certificate_ID;
        this.Address=Address;
        this.Exp=Exp;
        this.Place_Name=Place_Name;
        this.Contact_No=Contact_No;
        this.Status=Status;
        this.PF=PF;
        this.CF=CF;
        this.GF=GF;
        this.SF=SF;
        this.AF=AF;
    }
    
    public User(String Name,String Email,String Certificate_ID,String Address,String Exp,String Place_Name,String Contact_No,String Status) {
        this.Name=Name;
        this.Email=Email;
        this.Certificate_ID=Certificate_ID;
        this.Address=Address;
        this.Exp=Exp;
        this.Place_Name=Place_Name;
        this.Contact_No=Contact_No;
        this.Status=Status;
      
    }
    
    public User(String NIC) {
        
        this.NIC=NIC;
    }

    /**
     * @return the NIC
     */
    public String getNIC() {
        return NIC;
    }

    /**
     * @param NIC the NIC to set
     */
    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Certificate_ID
     */
    public String getCertificate_ID() {
        return Certificate_ID;
    }

    /**
     * @param Certificate_ID the Certificate_ID to set
     */
    public void setCertificate_ID(String Certificate_ID) {
        this.Certificate_ID = Certificate_ID;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the Exp
     */
    public String getExp() {
        return Exp;
    }

    /**
     * @param Exp the Exp to set
     */
    public void setExp(String Exp) {
        this.Exp = Exp;
    }

    /**
     * @return the Place_Name
     */
    public String getPlace_Name() {
        return Place_Name;
    }

    /**
     * @param Place_Name the Place_Name to set
     */
    public void setPlace_Name(String Place_Name) {
        this.Place_Name = Place_Name;
    }

    /**
     * @return the Contact_No
     */
    public String getContact_No() {
        return Contact_No;
    }

    /**
     * @param Contact_No the Contact_No to set
     */
    public void setContact_No(String Contact_No) {
        this.Contact_No = Contact_No;
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
     * @return the PF
     */
    public String getPF() {
        return PF;
    }

    /**
     * @param PF the PF to set
     */
    public void setPF(String PF) {
        this.PF = PF;
    }

    /**
     * @return the CF
     */
    public String getCF() {
        return CF;
    }

    /**
     * @param CF the CF to set
     */
    public void setCF(String CF) {
        this.CF = CF;
    }

    /**
     * @return the GF
     */
    public String getGF() {
        return GF;
    }

    /**
     * @param GF the GF to set
     */
    public void setGF(String GF) {
        this.GF = GF;
    }

    /**
     * @return the SF
     */
    public String getSF() {
        return SF;
    }

    /**
     * @param SF the SF to set
     */
    public void setSF(String SF) {
        this.SF = SF;
    }

    /**
     * @return the AF
     */
    public String getAF() {
        return AF;
    }

    /**
     * @param AF the AF to set
     */
    public void setAF(String AF) {
        this.AF = AF;
    }

}
