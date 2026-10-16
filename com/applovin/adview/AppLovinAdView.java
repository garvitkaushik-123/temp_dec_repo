package com.applovin.adview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.applovin.impl.adview.a;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.vungle.ads.internal.protos.Sdk;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes2.dex */
public class AppLovinAdView extends RelativeLayout {
    public static final String NAMESPACE = "http://schemas.applovin.com/android/1.0";

    /* renamed from: a, reason: collision with root package name */
    private a f348a;

    public AppLovinAdView(AppLovinAdSize appLovinAdSize) {
        this(appLovinAdSize, (String) null);
    }

    private void a(AppLovinAdSize appLovinAdSize, String str, AppLovinSdk appLovinSdk, Context context, AttributeSet attributeSet) {
        if (isInEditMode()) {
            a(attributeSet, context);
            return;
        }
        a aVar = new a();
        this.f348a = aVar;
        aVar.a(this, context, appLovinAdSize, str, appLovinSdk, attributeSet);
    }

    public void destroy() {
        a aVar = this.f348a;
        if (aVar != null) {
            aVar.b();
        }
    }

    public a getController() {
        return this.f348a;
    }

    public AppLovinAdSize getSize() {
        a aVar = this.f348a;
        if (aVar != null) {
            return aVar.k();
        }
        return null;
    }

    public String getZoneId() {
        a aVar = this.f348a;
        if (aVar != null) {
            return aVar.l();
        }
        return null;
    }

    public void loadNextAd() {
        a aVar = this.f348a;
        if (aVar != null) {
            aVar.u();
        } else {
            o.i("AppLovinSdk", "Unable to load next ad: AppLovinAdView is not initialized.");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f348a;
        if (aVar != null) {
            aVar.B();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        a aVar = this.f348a;
        if (aVar != null) {
            aVar.C();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        a aVar = this.f348a;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        a aVar = this.f348a;
        if (aVar != null) {
            aVar.c(i);
        }
    }

    public void pause() {
        a aVar = this.f348a;
        if (aVar != null) {
            aVar.D();
        }
    }

    public void renderAd(AppLovinAd appLovinAd) {
        a aVar = this.f348a;
        if (aVar != null) {
            aVar.c(appLovinAd);
        }
    }

    public void resume() {
        a aVar = this.f348a;
        if (aVar != null) {
            aVar.F();
        }
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        a aVar = this.f348a;
        if (aVar != null) {
            aVar.a(appLovinAdClickListener);
        }
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        a aVar = this.f348a;
        if (aVar != null) {
            aVar.a(appLovinAdDisplayListener);
        }
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        a aVar = this.f348a;
        if (aVar != null) {
            aVar.a(appLovinAdLoadListener);
        }
    }

    public void setAdViewEventListener(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        a aVar = this.f348a;
        if (aVar != null) {
            aVar.a(appLovinAdViewEventListener);
        }
    }

    public void setExtraInfo(String str, Object obj) {
        if (str == null) {
            throw new IllegalArgumentException("No key specified");
        }
        a aVar = this.f348a;
        if (aVar != null) {
            aVar.a(str, obj);
        }
    }

    @Override // android.view.View
    public String toString() {
        return "AppLovinAdView{zoneId='" + getZoneId() + "\", size=" + getSize() + AbstractJsonLexerKt.END_OBJ;
    }

    public AppLovinAdView(AppLovinAdSize appLovinAdSize, String str) {
        super(k.o());
        a(appLovinAdSize, str, AppLovinSdk.getInstance(k.o()), k.o(), null);
    }

    public AppLovinAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppLovinAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(null, null, null, context, attributeSet);
    }

    @Deprecated
    public AppLovinAdView(AppLovinAdSize appLovinAdSize, Context context) {
        this(appLovinAdSize, (String) null, context);
    }

    @Deprecated
    public AppLovinAdView(AppLovinAdSize appLovinAdSize, String str, Context context) {
        super(context);
        a(appLovinAdSize, str, null, context, null);
    }

    private void a(AttributeSet attributeSet, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int applyDimension = (int) TypedValue.applyDimension(1, 50.0f, displayMetrics);
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.rgb(Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE));
        textView.setTextColor(-16777216);
        textView.setText("AppLovin Ad");
        textView.setGravity(17);
        addView(textView, i, applyDimension);
    }

    @Deprecated
    public AppLovinAdView(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, Context context) {
        this(appLovinSdk, appLovinAdSize, null, context);
    }

    @Deprecated
    public AppLovinAdView(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, String str, Context context) {
        super(context.getApplicationContext());
        a(appLovinAdSize, str, appLovinSdk, context, null);
    }
}
