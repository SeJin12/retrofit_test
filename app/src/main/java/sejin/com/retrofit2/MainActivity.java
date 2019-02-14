package sejin.com.retrofit2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sejin.com.retrofit2.pojo.UserVO;

public class MainActivity extends AppCompatActivity {

    TextView responseText;
    APIInterface apiInterface;
    EditText edit_uemail, edit_upw;
    Button btn_login;
    TextView result_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        responseText = (TextView) findViewById(R.id.responseText);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        result_login = (TextView) findViewById(R.id.result_login);
        edit_uemail = (EditText) findViewById(R.id.edit_uemail);
        edit_upw = (EditText) findViewById(R.id.edit_upw);
        btn_login = (Button) findViewById(R.id.btn_login);


        /* GET List Resource */
        Call<List<UserVO>> call = apiInterface.doGetUserList();
        call.enqueue(new Callback<List<UserVO>>() {
            @Override
            public void onResponse(Call<List<UserVO>> call, Response<List<UserVO>> response) {

                String displayResponse = "";

                List<UserVO> list = response.body();

                for(UserVO vo : list){
                    displayResponse += ( vo.uemail + " "+vo.upw + " "+vo.uname+" "+vo.uphone+" "+vo.uregion +"\n");
                }

                responseText.setText(displayResponse);


            }

            @Override
            public void onFailure(Call<List<UserVO>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Response Fail(Network Error...etc)",Toast.LENGTH_LONG).show();

                call.cancel();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String uemail = edit_uemail.getText().toString();
                final String upw = edit_upw.getText().toString();
                UserVO vo = new UserVO(uemail,upw);

                Call<UserVO> call1 = apiInterface.checkLogin(vo);
                call1.enqueue(new Callback<UserVO>() {
                    @Override
                    public void onResponse(Call<UserVO> call, Response<UserVO> response) {
                        Log.i("값",response.body().toString());
                        result_login.setText("IsUser : TRUE");

                    }

                    @Override
                    public void onFailure(Call<UserVO> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Response Fail(Network Error...etc)",Toast.LENGTH_LONG).show();
                        result_login.setText("IsUser : FALSE");
                    }
                });
            }
        });
    }
}
