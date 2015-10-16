
package model;

public class Badminton {
  
    private int Member_ID;
    private String Official_Name;
    private String Prefer_Name;
    private String Email;
    private int Phone_Number;

    public Badminton() {
        this.Member_ID = 0;
        this.Official_Name = "";
        this.Prefer_Name = "";
        this.Email = "";
        this.Phone_Number = 0;
    }
    
    public Badminton(int Member_ID, String Official_Name, String Prefer_Name, String Email, int Phone_Number) {
        this.Member_ID = Member_ID;
        this.Official_Name = Official_Name;
        this.Prefer_Name = Prefer_Name;
        this.Email = Email;
        this.Phone_Number = Phone_Number;
    }

    public int getMember_ID() {
        return Member_ID;
    }

    public void setMember_ID(int Member_ID) {
        this.Member_ID = Member_ID;
    }

    public String getOfficial_Name() {
        return Official_Name;
    }

    public void setOfficial_Name(String Official_Name) {
        this.Official_Name = Official_Name;
    }

    public String getPrefer_Name() {
        return Prefer_Name;
    }

    public void setPrefer_Name(String Prefer_Name) {
        this.Prefer_Name = Prefer_Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(int Phone_Number) {
        this.Phone_Number = Phone_Number;
    }

    @Override
    public String toString() {
        return "Badminton{" + "Member_ID=" + Member_ID + ", Official_Name=" + Official_Name + ", Prefer_Name=" + Prefer_Name + ", Email=" + Email + ", Phone_Number=" + Phone_Number + '}';
    }
    
    
}
