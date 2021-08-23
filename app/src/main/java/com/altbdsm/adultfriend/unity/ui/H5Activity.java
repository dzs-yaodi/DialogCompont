package com.altbdsm.adultfriend.unity.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.altbdsm.adultfriend.unity.UITools;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.DefaultWebClient;
import com.just.agentweb.WebViewClient;
import com.altbdsm.adultfriend.R;

public class H5Activity extends AppCompatActivity {

    private AgentWeb mAgentWeb;
    private String originalUrl;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h5);
        UITools.initTitleBar(this,findViewById(R.id.frame_container),"#F1B70B");
        ImageView imageBack = findViewById(R.id.image_back);
        TextView tvTitle = findViewById(R.id.title);
        FrameLayout frameLayout = findViewById(R.id.frameLayout_web);

        imageBack.setOnClickListener(view -> finish());
        title = getIntent().getStringExtra("title");
        String loadUrl = getIntent().getStringExtra("load_url");
        originalUrl = loadUrl;
        tvTitle.setText(title);

        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(frameLayout,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT))
                .useDefaultIndicator()
//                .setWebViewClient()
                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
                .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)
                .interceptUnkownUrl()
                .createAgentWeb()
                .ready()
                .go(loadUrl);
    }

    private WebViewClient webViewClient = new WebViewClient() {


    };

    @Override
    protected void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    protected void onResume() {
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
}