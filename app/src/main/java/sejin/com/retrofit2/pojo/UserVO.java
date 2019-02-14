package sejin.com.retrofit2.pojo;

import com.google.gson.annotations.SerializedName;

public class UserVO {

    @SerializedName("uemail")
    public String uemail;
    @SerializedName("upw")
    public String upw;
    @SerializedName("uname")
    public String uname;
    @SerializedName("uphone")
    public String uphone;
    @SerializedName("uregion")
    public String uregion;

    public UserVO(String uemail, String upw) {
        this.uemail = uemail;
        this.upw = upw;
    }
}
