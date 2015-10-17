
package model;

public class Members {

    private int MemberID;
    private String OfficialName;
    private String PreferName;
    private String Email;
    private int PhoneNumber;

       public Members() {
        this.MemberID = 0;
        this.OfficialName = "";
        this.PreferName = "";
        this.Email = "";
        this.PhoneNumber = 0;
    }
    
    
    
    public Members(int MemberID, String OfficialName, String PreferName, String Email, int PhoneNumber) {
        this.MemberID = MemberID;
        this.OfficialName = OfficialName;
        this.PreferName = PreferName;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
    }

    public int getMemberID() {
        return MemberID;
    }

    public void setMemberID(int MemberID) {
        this.MemberID = MemberID;
    }

    public String getOfficialName() {
        return OfficialName;
    }

    public void setOfficialName(String OfficialName) {
        this.OfficialName = OfficialName;
    }

    public String getPreferName() {
        return PreferName;
    }

    public void setPreferName(String PreferName) {
        this.PreferName = PreferName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    @Override
    public String toString() {
        return "Members{" + "MemberID=" + MemberID + ", OfficialName=" + OfficialName + ", PreferName=" + PreferName + ", Email=" + Email + ", PhoneNumber=" + PhoneNumber + '}';
    }
    
    
    
    
    
}
