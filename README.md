[LINK](https://jongmin92.github.io/2018/01/29/Programming/android-retrofit2-okhttp3/#multipleresourcesjava)



`build.gradle (Module:app) Setting`

```
dependencies {
    implementation('com.squareup.retrofit2:retrofit:2.3.0') {
        exclude module: 'okhttp'
    }

    implementation 'com.squareup.retrofit2:retrofit:2.3.0'
    implementation 'com.google.code.gson:gson:2.8.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.1.0'
    implementation 'com.squareup.okhttp3:okhttp:3.9.1'
    
    implementation 'com.squareup.okhttp3:logging-interceptor:3.9.1'
}
```



##### 정보

```java
Call<UserVO> call = apiInterface.checkLogin(vo);
                call.enqueue(new Callback<UserVO>() {
                    @Override
                    public void onResponse(Call<UserVO> call, Response<UserVO> response) {
                        UserVO vo = response.body();
                        Log.i("value = ",vo.toString());
                    }

                    @Override
                    public void onFailure(Call<UserVO> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Response Fail(Network Error...etc)",Toast.LENGTH_LONG).show();
                    }
                });
```

> onResponse(Call<UserVO> call, Response<UserVO> response)  
> Server에서 return 하는 객체와 같게 해야 onResponse로 값을 처리할 수 있다.
> 그렇지 않으면, 정보들을 app으로 가져오지만 onFailure() 를 호출하여 값을 사용하지 못함.

