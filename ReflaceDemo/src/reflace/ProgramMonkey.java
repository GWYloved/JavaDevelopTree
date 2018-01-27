package reflace;

public class ProgramMonkey extends Person implements ICompany {
    String mLanguage = "C#";
    String mCompany = "BBK";

    public ProgramMonkey(String mName, String mSex, int mAge) {
        super(mName, mSex, mAge);
    }

    public ProgramMonkey(String mName, String mSex, int mAge, String mLanguage, String mCompany) {
        super(mName, mSex, mAge);
        this.mLanguage = mLanguage;
        this.mCompany = mCompany;
    }

    public String getmLanguage() {
        return mLanguage;
    }

    public void setmLanguage(String mLanguage) {
        this.mLanguage = mLanguage;
    }

    public String getmCompany() {
        return mCompany;
    }

    public void setmCompany(String mCompany) {
        this.mCompany = mCompany;
    }
    private int getSalaryPerMonth(){
        return 12306;
    }
    @Override
    public String getCompany() {
        return mCompany;
    }
}
