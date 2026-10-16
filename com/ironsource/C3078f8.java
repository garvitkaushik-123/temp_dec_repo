package com.ironsource;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.ironsource.C3040d4;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ironsource.f8, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3078f8 extends FrameLayout implements F8 {
    private static final String b = "IronSourceAdContainer";

    /* renamed from: a, reason: collision with root package name */
    private C3162k8 f3295a;

    /* renamed from: com.ironsource.f8$a */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3296a;
        final /* synthetic */ String b;

        a(String str, String str2) {
            this.f3296a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3078f8 c3078f8 = C3078f8.this;
            c3078f8.removeView(c3078f8.f3295a.getPresentingView());
            C3078f8.this.f3295a.a(this.f3296a, this.b);
            C3078f8.this.f3295a = null;
        }
    }

    public C3078f8(Context context) {
        super(context);
    }

    private void b() throws Exception {
        JSONObject jSONObject;
        try {
            jSONObject = this.f3295a.b().a().getJSONObject(C3061e8.p).getJSONObject(C3061e8.s);
        } catch (Exception e) {
            C3260q4.d().a(e);
            jSONObject = new JSONObject();
        }
        jSONObject.put("adViewId", this.f3295a.a());
        this.f3295a.b().a(C3040d4.g.S, jSONObject);
    }

    public void a() throws Exception {
        C3162k8 c3162k8 = this.f3295a;
        if (c3162k8 == null || c3162k8.b() == null) {
            throw new Exception("mAdPresenter or mAdPresenter.getAdViewLogic() are null");
        }
        b();
    }

    @Override // com.ironsource.F8
    public void c(JSONObject jSONObject, String str, String str2) throws JSONException {
        this.f3295a.c(jSONObject, str, str2);
    }

    @Override // com.ironsource.F8
    public WebView getPresentingView() {
        return this.f3295a.getPresentingView();
    }

    public C3044d8 getSize() {
        C3162k8 c3162k8 = this.f3295a;
        return c3162k8 != null ? c3162k8.c() : new C3044d8();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        Logger.i(b, "onVisibilityChanged: " + i);
        C3162k8 c3162k8 = this.f3295a;
        if (c3162k8 == null) {
            return;
        }
        try {
            c3162k8.b().a(C3061e8.k, i, isShown());
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        Logger.i(b, "onWindowVisibilityChanged: " + i);
        C3162k8 c3162k8 = this.f3295a;
        if (c3162k8 == null) {
            return;
        }
        try {
            c3162k8.b().a(C3061e8.l, i, isShown());
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public C3078f8(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public C3078f8(C3162k8 c3162k8, Context context) {
        super(context);
        setLayoutParams(new FrameLayout.LayoutParams(c3162k8.c().c(), c3162k8.c().a()));
        this.f3295a = c3162k8;
        addView(c3162k8.getPresentingView());
    }

    @Override // com.ironsource.F8
    public void a(JSONObject jSONObject, String str, String str2) {
        this.f3295a.a(jSONObject, str, str2);
    }

    @Override // com.ironsource.F8
    public synchronized void a(String str, String str2) {
        C3162k8 c3162k8 = this.f3295a;
        if (c3162k8 != null && c3162k8.b() != null && this.f3295a.getPresentingView() != null) {
            this.f3295a.b().e();
            R7.f3025a.d(new a(str, str2));
        }
    }

    @Override // com.ironsource.F8
    public void a(String str, String str2, String str3) {
        C3162k8 c3162k8 = this.f3295a;
        if (c3162k8 == null) {
            return;
        }
        c3162k8.a(str, str2, str3);
    }

    @Override // com.ironsource.F8
    public void b(JSONObject jSONObject, String str, String str2) {
        this.f3295a.b(jSONObject, str, str2);
    }
}
