package com.affcompany.datingapps.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.affcompany.datingapps.MediaUtility;
import com.affcompany.datingapps.OpenFileWebChromeClient;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.DefaultWebClient;
import com.just.agentweb.WebViewClient;
import com.affcompany.datingapps.R;

import java.io.File;

public class WebViewActivity extends BaseActivity {

    private AgentWeb mAgentWeb;
    private String loadUrl = "";
    private OpenFileWebChromeClient mOpenFileWebChromeClient;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        FrameLayout frameLayout = findViewById(R.id.frameLayout_web);

        setPermission();
        loadUrl = getIntent().getStringExtra("load_url");

        if (TextUtils.isEmpty(loadUrl)) {
            Toast.makeText(this, "参数为空", Toast.LENGTH_SHORT).show();
            finish();
        }
        mOpenFileWebChromeClient = new OpenFileWebChromeClient(this);
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent((ViewGroup) frameLayout, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT))
                .useDefaultIndicator()
                .setWebViewClient(webViewClient)
                .setWebChromeClient(mOpenFileWebChromeClient)
                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
                .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.DISALLOW)//打开其他应用时，弹窗咨询用户是否前往其他应用
                .interceptUnkownUrl()
                .createAgentWeb()
                .ready()
                .go(loadUrl);

        WebSettings webSettings = mAgentWeb.getAgentWebSettings().getWebSettings();
        webSettings.setLoadWithOverviewMode(true);
        //下面这些
        webSettings.setSupportZoom(true);//设置可以支持缩放
        webSettings.setBuiltInZoomControls(true);//设置出现缩放工具
        webSettings.setUseWideViewPort(true);//扩大比例的缩放
        webSettings.setDisplayZoomControls(false);//隐藏缩放控件
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setTextZoom(100);
        webSettings.setJavaScriptEnabled(true);

    }

    private WebViewClient webViewClient = new WebViewClient(){

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            Log.e("info","======跳转url1=====" + url);
            view.loadUrl(url);
            return true;
        }

        @Override
        public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
            super.doUpdateVisitedHistory(view, url, isReload);
//            Log.e("info","======跳转url2=====" + url);
        }
    };

    @Override
    public void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();
    }

    @Override
    public void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mAgentWeb.handleKeyEvent(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == OpenFileWebChromeClient.REQUEST_FILE_PICKER) {
            if (mOpenFileWebChromeClient.mFilePathCallback != null) {
                Uri result = data == null || resultCode != Activity.RESULT_OK ? null
                        : data.getData();
                if (result != null) {
                    String path = MediaUtility.getPath(getApplicationContext(),
                            result);
                    Uri uri = Uri.fromFile(new File(path));
                    mOpenFileWebChromeClient.mFilePathCallback
                            .onReceiveValue(uri);
                } else {
                    mOpenFileWebChromeClient.mFilePathCallback
                            .onReceiveValue(null);
                }
            }
            if (mOpenFileWebChromeClient.mFilePathCallbacks != null) {
                Uri result = data == null || resultCode != Activity.RESULT_OK ? null
                        : data.getData();
                if (result != null) {
                    String path = MediaUtility.getPath(getApplicationContext(),
                            result);
                    Uri uri = Uri.fromFile(new File(path));
                    mOpenFileWebChromeClient.mFilePathCallbacks
                            .onReceiveValue(new Uri[] { uri });
                } else {
                    mOpenFileWebChromeClient.mFilePathCallbacks
                            .onReceiveValue(null);
                }
            }

            mOpenFileWebChromeClient.mFilePathCallback = null;
            mOpenFileWebChromeClient.mFilePathCallbacks = null;
        }
    }
}