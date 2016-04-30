package com.example.satti.discuss;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;





public class discuss extends Activity {

    ProgressDialog dialog;
    public class WebViewController extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {

            try{
                if (dialog.isShowing()|| dialog != null) {
                    dialog.dismiss();
                    dialog= null; /*** Add ***/
                }

            }catch(Exception exception){
                exception.printStackTrace();
            }

        }
    }
    WebView mWebView;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return false;

    }


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        final Activity mActivity = this;
        super.onCreate(savedInstanceState);
        dialog = ProgressDialog.show(discuss.this, "",
                "Loading. Please wait...", true);

        // Adds Progrss bar Support
        this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_discuss);




        // Makes Progress bar Visible
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);

        mWebView = (WebView) findViewById( R.id.webview );
        mWebView.getSettings().setJavaScriptEnabled(true);

        // Initialize the WebView
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        mWebView.setScrollbarFadingEnabled(true);
        mWebView.getSettings().setLoadsImagesAutomatically(true);
        mWebView.loadUrl("https://discuss.fsmk.org/");




        mWebView.setWebViewClient(new WebViewController());


        mWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                //Make the bar disappear after URL is loaded, and changes string to Loading...
                mActivity.setTitle("Loading...");
                mActivity.setProgress(progress * 10); //Make the bar disappear after URL is loaded

                // Return the app name after finish loading
                if (progress == 10) {
                    Toast.makeText(discuss.this, "Network connection is slow", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
