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
package org.goodev.retrofitdemo;

import com.squareup.okhttp.OkHttpClient;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;

public class GitHubClient {
    private static final String API_URL = "https://api.github.com";

    static class Contributor {
        String login;
        int contributions;

        @Override
        public String toString() {
            return login + ", " + contributions;
        }
    }

    public interface RestApi
    {
        @GET("/repos/{owner}/{repo}/contributors")
        Call<List<Contributor>> contributors(@Path("owner") String owner, @Path("repo") String repo);
    }

    public static void getListData(Callback<List<Contributor>> callback)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();

        RestApi restApi = retrofit.create(RestApi.class);
        Call<List<Contributor>> call = restApi.contributors("square", "retrofit");
        call.enqueue(callback);
    }
}
