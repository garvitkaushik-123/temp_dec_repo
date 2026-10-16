package com.ironsource.mediationsdk.testSuite;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.ironsource.C3338uf;
import com.ironsource.C3423zf;
import com.ironsource.Cif;
import com.ironsource.Q8;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class TestSuiteActivity extends Activity implements Q8 {

    /* renamed from: a, reason: collision with root package name */
    private RelativeLayout f3577a;
    private C3423zf b;
    private C3338uf c;

    private final String a() {
        Bundle extras;
        if (getIntent() == null || getIntent().getExtras() == null || (extras = getIntent().getExtras()) == null) {
            return null;
        }
        return extras.getString("controllerUrl");
    }

    private final JSONObject b() {
        String b = new Cif().b(this);
        if (b != null) {
            try {
                if (b.length() != 0) {
                    return new JSONObject(b);
                }
            } catch (Exception unused) {
                return new JSONObject();
            }
        }
        return new JSONObject();
    }

    private final RelativeLayout.LayoutParams c() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    public final RelativeLayout getContainer() {
        RelativeLayout relativeLayout = this.f3577a;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        return null;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // com.ironsource.Q8
    public void onClosed() {
        runOnUiThread(new Runnable() { // from class: com.ironsource.mediationsdk.testSuite.TestSuiteActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                TestSuiteActivity.a(TestSuiteActivity.this);
            }
        });
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.f3577a = relativeLayout;
        setContentView(relativeLayout, c());
        C3423zf c3423zf = new C3423zf(this, this, b(), a());
        this.b = c3423zf;
        C3338uf c3338uf = new C3338uf(c3423zf);
        this.c = c3338uf;
        c3338uf.d();
        RelativeLayout relativeLayout2 = this.f3577a;
        C3423zf c3423zf2 = null;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            relativeLayout2 = null;
        }
        C3423zf c3423zf3 = this.b;
        if (c3423zf3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWebViewWrapper");
        } else {
            c3423zf2 = c3423zf3;
        }
        relativeLayout2.addView(c3423zf2.d(), c());
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C3338uf c3338uf = this.c;
        C3423zf c3423zf = null;
        if (c3338uf == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNativeBridge");
            c3338uf = null;
        }
        c3338uf.a();
        RelativeLayout relativeLayout = this.f3577a;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            relativeLayout = null;
        }
        relativeLayout.removeAllViews();
        C3423zf c3423zf2 = this.b;
        if (c3423zf2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWebViewWrapper");
        } else {
            c3423zf = c3423zf2;
        }
        c3423zf.a();
        super.onDestroy();
    }

    @Override // com.ironsource.Q8
    public void onUIReady() {
        runOnUiThread(new Runnable() { // from class: com.ironsource.mediationsdk.testSuite.TestSuiteActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                TestSuiteActivity.b(TestSuiteActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TestSuiteActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TestSuiteActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C3423zf c3423zf = this$0.b;
        C3423zf c3423zf2 = null;
        if (c3423zf == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWebViewWrapper");
            c3423zf = null;
        }
        if (c3423zf.c().getParent() == null) {
            RelativeLayout relativeLayout = this$0.f3577a;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                relativeLayout = null;
            }
            C3423zf c3423zf3 = this$0.b;
            if (c3423zf3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWebViewWrapper");
                c3423zf3 = null;
            }
            relativeLayout.removeView(c3423zf3.d());
            RelativeLayout relativeLayout2 = this$0.f3577a;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                relativeLayout2 = null;
            }
            C3423zf c3423zf4 = this$0.b;
            if (c3423zf4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWebViewWrapper");
                c3423zf4 = null;
            }
            relativeLayout2.addView(c3423zf4.c(), this$0.c());
            C3423zf c3423zf5 = this$0.b;
            if (c3423zf5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWebViewWrapper");
            } else {
                c3423zf2 = c3423zf5;
            }
            c3423zf2.b();
        }
    }
}
