package com.mature.baselib.http;

import com.mature.baselib.bean.AppConfig;
import com.mature.baselib.bean.BlogDetails;
import com.mature.baselib.bean.Blogs;
import com.mature.baselib.bean.HomeDetails;
import com.mature.baselib.bean.HomeList;
import com.mature.baselib.bean.HomeTitle;
import com.mature.baselib.bean.SingleList;
import com.mature.baselib.bean.SugarData;
import com.mature.baselib.utils.ServerConfig;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {

    @GET(ServerConfig.HOST + "index")
    Observable<AppConfig> getAppConfig();

    /**
     * 获取标题
     */
    @GET(ServerConfig.HOST + "hometitle")
    Observable<HomeTitle> getHomeTitle();

    /**
     * 首页列表
     */
    @GET(ServerConfig.HOST + "homeapi")
    Observable<List<HomeList>> getHomeList();

    /**
     * 首页详情
     * @return
     */
    @GET()
    Observable<HomeDetails> getHomeDetails(@Url String url);

    /**
     * singles 列表
     * @return
     */
    @GET(ServerConfig.HOST + "male")
    Observable<List<SingleList>> getSingles();

    /**
     * 第三个页面数据
     * @return
     */
    @GET(ServerConfig.HOST + "blog")
    Observable<List<Blogs>> getBlog();

    @GET()
    Observable<BlogDetails> getBlogDetails(@Url String url);

    @GET(ServerConfig.HOST + "sugarapi")
    Observable<List<SugarData>> getSugarList();

    @GET()
    Observable<HomeDetails> getSugarDetails(@Url String url);

    @GET(ServerConfig.HOST + "lgbtapi")
    Observable<List<SugarData>> getLgbtList();

    @GET()
    Observable<HomeDetails> getLgbtDetails(@Url String url);

    @GET(ServerConfig.HOST + "fwb")
    Observable<List<SugarData>> getFwbList();

    @GET(ServerConfig.HOST + "senior")
    Observable<List<SugarData>> getSeniorList();

    @GET(ServerConfig.HOST + "std")
    Observable<List<SugarData>> getStdList();

    @GET(ServerConfig.HOST + "agegap")
    Observable<List<SugarData>> getAgegapList();
}
