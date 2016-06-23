/*
 * Copyright (C) 2012 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.goodev.retrofitdemo.httputil;

import com.squareup.okhttp.OkHttpClient;

import org.goodev.retrofitdemo.bean.Contributor;
import org.goodev.retrofitdemo.httplist.RestApi;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class GitHubClient {
    /**
     * 完整的请求路径为
     * https://api.github.com/repos/square/retrofit/contributors
     */
    private static final String Base_URL = "https://api.github.com";

    private static Retrofit retrofit;
    private static RestApi restApi;

    //静态块初始化(仅一次)
    static {
        retrofit = new Retrofit.Builder()
                .baseUrl(Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();

        restApi = retrofit.create(RestApi.class);
    }

    public static void getListData(Callback<List<Contributor>> callback)
    {
        if (null != restApi)
        {
            Call<List<Contributor>> call = restApi.contributors("square", "retrofit");
            call.enqueue(callback);
        }
    }
}
