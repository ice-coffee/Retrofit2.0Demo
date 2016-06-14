# Retrofit2.0Demo

关于Retrofit2.0版本的使用demo

* 引入依赖

```javascript
compile 'com.squareup.retrofit:retrofit:2.0.0-beta2'
//gson解析
compile 'com.squareup.retrofit:converter-gson:2.0.0-beta2'
```

* 配置Retrofit

```javascript
Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://www.exm.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient())
                    .build();
```

* 新建Model类 SearchResult来解析结果

* 新建请求接口
Retrofit使用注解来定义一个请求，在方法上面指定请求的方法等信息，在参数中指定参数等信息。

```javascript
public interface RestApi {
        @GET("/search.json")
        Call<List<SearchResult>> search(
            @Query("key") String key
             );

            //可以定义其它请求
           @GET("/something.json")
            Call<SomeThing> dosomething(
                   @Query("params") long params
                    .......
                    .......
              );
```
}
* 发送请求，我们可以发送同步请求(阻塞当前线程)和异步请求，并在回调中处理请求结果。

```javascript
  RestApi restApi = retrofit.create(RestApi.class);
  Call<List<SearchResult>> searchResultsCall = resetApi.search("retrofit");
  //Response<List<SearchResult> searchResults = searchResultsCall.execute();   同步方法
  searchResultsCall.enqueue(new Callback<List<SearchResult>>() {
                @Override
                public void onResponse(Response<List<SearchResult>> response, Retrofit retrofit) {
                    content.setText(response.body().toString());
                }

                @Override
                public void onFailure(Throwable t) {
                    content.setText("error");
                }
            });
```

参考资料

http://www.tuicool.com/articles/NnuIva

http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0915/3460.html

http://www.jianshu.com/p/07dac989272c
