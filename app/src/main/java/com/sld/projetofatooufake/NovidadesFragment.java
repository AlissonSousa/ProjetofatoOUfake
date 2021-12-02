package com.sld.projetofatooufake;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NovidadesFragment extends Fragment {

    private WebView webView;
    View myFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment =  inflater.inflate(R.layout.fragment_novidades, container, false);

        webView = (WebView) myFragment.findViewById( R.id.idWebView);
        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("https://g1.globo.com/tudo-sobre/ministerio-da-saude/");




        return myFragment;
    }
}
