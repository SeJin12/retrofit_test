package sejin.com.retrofit2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import sejin.com.retrofit2.pojo.UserVO;

public interface APIInterface {

    @GET("user/read.do")
    Call<List<UserVO>> doGetUserList();

    @POST("user/check.do")
    Call<UserVO> checkLogin(@Body UserVO vo);

}
