package com.mature.baselib.http;

public class Api {

    public ApiService apiService;

    private static class SingletonHolder {
        private static final Api INSTANCE = new Api();
    }

    private Api(){
        apiService = HttpManager.getInstance().creatApi(ApiService.class);
    }

    public static Api getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
