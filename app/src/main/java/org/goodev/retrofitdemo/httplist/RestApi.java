package org.goodev.retrofitdemo.httplist;

import org.goodev.retrofitdemo.bean.Contributor;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Author:  ice_coffee
 * Email:   ice_coffee_mzp@163.com
 * Date:    2016/6/23
 * Description:
 */
public interface RestApi
{
    @GET("/repos/{owner}/{repo}/contributors")
    Call<List<Contributor>> contributors(@Path("owner") String owner, @Path("repo") String repo);
}
