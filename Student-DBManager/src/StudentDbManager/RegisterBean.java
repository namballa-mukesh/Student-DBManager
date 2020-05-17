package StudentDbManager;

public class RegisterBean {
    private String name, mail, phoneno, dob, batch, course, regno, rollno, cgpa, credits;
    
    public RegisterBean(String name,String mail,String phoneno,String dob,String batch,
            String course,String rollno,String regno,String cgpa,String credits)  {
        this.name=name;
        this.mail=mail;
        this.phoneno=phoneno;
        this.dob=dob;
        this.course=course;
        this.batch=batch;
        this.rollno=rollno;
        this.regno=regno;
        this.cgpa=cgpa;
        this.credits=credits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    
}
