package bayon.fabien.englearny_app;

import com.google.gson.annotations.SerializedName;

public class Tests {
    @SerializedName("libelle")
    public String testName;

    public Tests(String testName) {
        this.testName = testName;
    }

    public String getTestName() {
        return testName;
    }


}
