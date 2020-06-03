package com.jianyb.jsjiaohu;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.jianyb.tree.BinaryTree;
import com.jianyb.tree.Search;
import com.jianyb.tree.TreeNode;

import java.util.Map;

public class MainActivity extends Activity {

    private WebView mWebView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mWebView = findViewById(R.id.webview);
//
//        WebSettings settings = mWebView.getSettings();
//        settings.setBlockNetworkImage(false);//解决图片不显示
//        settings.setJavaScriptCanOpenWindowsAutomatically(true);
//        settings.setLoadsImagesAutomatically(true);
//
//        settings.setJavaScriptEnabled(true);
//        settings.setDomStorageEnabled(true);
//        //设置在APP内部打开网址链接
//        mWebView.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//            }
//        });
//        //settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
//        } else {
//            mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
//        }
//        settings.setUseWideViewPort(true);//设定支持viewport
//        settings.setLoadWithOverviewMode(true);
//        settings.setBuiltInZoomControls(true);
//        settings.setSupportZoom(true);//
//        settings.setDomStorageEnabled(true);//主要是这句
//        mWebView.setWebChromeClient(new WebChromeClient());
//        mWebView.addJavascriptInterface(this, "JSObject");
//
//        mWebView.loadUrl("file:///android_asset/index.html");

    }

    @android.webkit.JavascriptInterface
    public void toRaceHandle(String map) {
//        int size = map.size();
        Toast.makeText(this, "size=" + map, Toast.LENGTH_SHORT).show();
    }

    public void jump(View view) {
//        startActivity(new Intent(this, SecondActivity.class));
        int[] array = {12,76,35,22,16,48,90,46,9,40};
        BinaryTree tree = new BinaryTree(array[0]);
        for (int i = 1; i < array.length; i++) {
            tree.insert(tree, array[i]);
        }

        System.out.println("先根遍历");
        BinaryTree.preOrder(tree);
        System.out.println();

        System.out.println("中根遍历");
        BinaryTree.inOrder(tree);
        System.out.println();

        System.out.println("后根遍历");
        BinaryTree.posOrder(tree);
        System.out.println();
    }

    public void dfs(View view) {
        int[] array = {12,76,35,22,16,48,90,46,9,40};
        TreeNode root = new TreeNode(array[0]);
        for (int i = 1; i < array.length; i++) {
            root.insert(root, array[i]);
        }
        System.out.println("dfs遍历");
        Search.dfs(root);
        System.out.println();

        System.out.println("bfs遍历");
        Search.bfs(root);
        System.out.println();
    }
}
