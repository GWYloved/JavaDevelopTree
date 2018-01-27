package reflace;

public class Person {
    String mName;
    String mSex;
    public int mAge;

    public Person(String mName, String mSex, int mAge) {
        this.mName = mName;
        this.mSex = mSex;
        this.mAge = mAge;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmSex() {
        return mSex;
    }

    public void setmSex(String mSex) {
        this.mSex = mSex;
    }

    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }
}
