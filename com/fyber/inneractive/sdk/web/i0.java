package com.fyber.inneractive.sdk.web;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.ui.IAcloseButton;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.iab.omid.library.fyber.adsession.AdSession;
import com.iab.omid.library.fyber.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.fyber.adsession.Partner;
import com.ironsource.C3040d4;
import java.net.URI;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public abstract class i0 extends i1 {
    public static final String[] o0 = {"yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mmZZZZZ"};
    public com.fyber.inneractive.sdk.mraid.f0 N;
    public final z O;
    public final d0 P;
    public final c0 Q;
    public ViewGroup R;
    public m S;
    public boolean T;
    public int U;
    public e0 V;
    public IAcloseButton W;
    public boolean X;
    public float Y;
    public int Z;
    public int a0;
    public int b0;
    public int c0;
    public int d0;
    public int e0;
    public Orientation f0;
    public int g0;
    public FrameLayout h0;
    public FrameLayout i0;
    public FrameLayout j0;
    public int k0;
    public int l0;
    public t m0;
    public final p n0;

    public i0(boolean z, c0 c0Var, z zVar, d0 d0Var, com.fyber.inneractive.sdk.measurement.e eVar, com.fyber.inneractive.sdk.config.global.r rVar) {
        super(z, c0Var, rVar);
        this.N = com.fyber.inneractive.sdk.mraid.f0.HIDDEN;
        this.T = false;
        this.Z = -1;
        this.a0 = -1;
        this.b0 = -1;
        this.c0 = -1;
        this.d0 = -1;
        this.e0 = -1;
        this.f0 = Orientation.NONE;
        this.H = eVar;
        this.Q = c0Var;
        this.O = zVar;
        this.P = d0Var;
        this.n0 = new p(this);
    }

    @Override // com.fyber.inneractive.sdk.web.i, com.fyber.inneractive.sdk.web.l
    public void a(boolean z) {
        a(new com.fyber.inneractive.sdk.mraid.g0(z));
        super.a(z);
    }

    @Override // com.fyber.inneractive.sdk.web.l
    public final void b() {
        com.fyber.inneractive.sdk.util.r.b.post(new r(this));
    }

    @Override // com.fyber.inneractive.sdk.web.l
    public final void c() {
        m mVar = this.b;
        if (mVar != null && mVar.getViewTreeObserver() != null) {
            this.b.getViewTreeObserver().removeOnPreDrawListener(this.n0);
        }
        com.fyber.inneractive.sdk.util.r.b.post(new s(this));
    }

    public final void d(boolean z) {
        try {
            Activity activity = (Activity) com.fyber.inneractive.sdk.util.o.a(this.b);
            if (activity != null) {
                if (!z || activity.getResources() == null || activity.getResources().getConfiguration() == null) {
                    activity.setRequestedOrientation(this.U);
                } else {
                    activity.setRequestedOrientation(activity.getResources().getConfiguration().orientation);
                }
            }
        } catch (Exception unused) {
            IAlog.a("Failed to modify the device orientation.", new Object[0]);
        }
    }

    @Override // com.fyber.inneractive.sdk.web.i
    public final com.fyber.inneractive.sdk.util.e1 g() {
        m mVar;
        return (this.N != com.fyber.inneractive.sdk.mraid.f0.EXPANDED || (mVar = this.S) == null) ? super.g() : mVar.getLastClickedLocation();
    }

    @Override // com.fyber.inneractive.sdk.web.i
    public final void h() {
        super.h();
        this.N = com.fyber.inneractive.sdk.mraid.f0.LOADING;
        Context a2 = com.fyber.inneractive.sdk.util.o.a(this.b);
        this.U = a2 instanceof Activity ? ((Activity) a2).getRequestedOrientation() : -1;
        this.i0 = new FrameLayout(a2);
        this.j0 = new FrameLayout(a2);
        FrameLayout frameLayout = new FrameLayout(a2);
        frameLayout.setBackgroundColor(-858993460);
        this.h0 = frameLayout;
        a(a2, false);
        this.b.setOnKeyListener(new q(this));
    }

    @Override // com.fyber.inneractive.sdk.web.i1
    public final void j() {
        m mVar = this.b;
        if (mVar != null) {
            mVar.a("window.mraidbridge.fireReadyEvent();");
        }
    }

    @Override // com.fyber.inneractive.sdk.web.i1
    public void k() {
        ArrayList arrayList = new ArrayList();
        m mVar = this.b;
        if (mVar == null || mVar.getScaleX() == 1.0f || this.b.getScaleY() == 1.0f) {
            arrayList.add(new com.fyber.inneractive.sdk.mraid.c0(this.Z, this.a0));
            arrayList.add(new com.fyber.inneractive.sdk.mraid.a0(this.b0, this.c0));
        } else {
            arrayList.add(new com.fyber.inneractive.sdk.mraid.c0(this.b.getWidthDp(), this.b.getHeightDp()));
            arrayList.add(new com.fyber.inneractive.sdk.mraid.a0(this.b.getWidthDp(), this.b.getHeightDp()));
        }
        m mVar2 = this.b;
        int c = com.fyber.inneractive.sdk.util.o.c(mVar2 != null ? mVar2.getWidth() : this.b0);
        m mVar3 = this.b;
        arrayList.add(new com.fyber.inneractive.sdk.mraid.z(c, com.fyber.inneractive.sdk.util.o.c(mVar3 != null ? mVar3.getHeight() : this.c0)));
        a(arrayList);
        com.fyber.inneractive.sdk.mraid.f0 f0Var = com.fyber.inneractive.sdk.mraid.f0.DEFAULT;
        this.N = f0Var;
        a(new com.fyber.inneractive.sdk.mraid.d0(f0Var));
    }

    @Override // com.fyber.inneractive.sdk.web.i1
    public final boolean m() {
        c0 c0Var = this.Q;
        return c0Var != null && c0Var.equals(c0.INTERSTITIAL);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o() {
        ViewGroup viewGroup;
        m mVar;
        m mVar2;
        j1 j1Var;
        com.fyber.inneractive.sdk.mraid.f0 f0Var;
        ViewGroup viewGroup2 = this.R;
        ViewGroup viewGroup3 = null;
        if (viewGroup2 != null) {
            View findViewById = viewGroup2.findViewById(R.id.ia_identifier_overlay);
            if (findViewById instanceof ViewGroup) {
                viewGroup = (ViewGroup) findViewById;
                if (viewGroup != null) {
                    m mVar3 = this.b;
                    if (mVar3 != null) {
                        View findViewById2 = mVar3.findViewById(R.id.ia_identifier_overlay);
                        if (findViewById2 instanceof ViewGroup) {
                            viewGroup3 = (ViewGroup) findViewById2;
                        }
                    }
                } else {
                    viewGroup3 = viewGroup;
                }
                this.T = false;
                if (!p() || (f0Var = this.N) == com.fyber.inneractive.sdk.mraid.f0.RESIZED) {
                    c(false);
                    mVar = this.b;
                    if (mVar != null) {
                        com.fyber.inneractive.sdk.mraid.f0 f0Var2 = this.N;
                        if (f0Var2 == com.fyber.inneractive.sdk.mraid.f0.EXPANDED) {
                            FrameLayout frameLayout = this.i0;
                            if (frameLayout != null && this.j0 != null) {
                                frameLayout.removeAllViewsInLayout();
                                this.j0.removeAllViewsInLayout();
                                ViewGroup viewGroup4 = this.R;
                                if (viewGroup4 != null) {
                                    viewGroup4.removeView(this.j0);
                                }
                            }
                            ViewGroup viewGroup5 = (ViewGroup) this.h0.getParent();
                            if (viewGroup5 != null) {
                                viewGroup5.addView(this.b, this.g0);
                                m mVar4 = this.b;
                                int i = this.k0;
                                int i2 = this.l0;
                                ViewGroup.LayoutParams layoutParams = mVar4.getLayoutParams();
                                layoutParams.width = i;
                                layoutParams.height = i2;
                                mVar4.setLayoutParams(layoutParams);
                                com.fyber.inneractive.sdk.util.o.a(this.b, 17);
                                viewGroup5.removeView(this.h0);
                                viewGroup5.invalidate();
                                this.b.requestLayout();
                            }
                            this.d0 = this.k0;
                            this.e0 = this.l0;
                        } else if (f0Var2 == com.fyber.inneractive.sdk.mraid.f0.RESIZED) {
                            int i3 = this.k0;
                            this.d0 = i3;
                            int i4 = this.l0;
                            this.e0 = i4;
                            ViewGroup.LayoutParams layoutParams2 = mVar.getLayoutParams();
                            layoutParams2.width = i3;
                            layoutParams2.height = i4;
                            mVar.setLayoutParams(layoutParams2);
                            com.fyber.inneractive.sdk.util.o.a(this.b, 17);
                        }
                    }
                    if (viewGroup3 != null && (mVar2 = this.b) != null) {
                        viewGroup3.setLayoutParams(mVar2.getLayoutParams());
                        if (p()) {
                            com.fyber.inneractive.sdk.util.t.a(viewGroup3);
                            this.b.addView(viewGroup3);
                        }
                    }
                    this.N = com.fyber.inneractive.sdk.mraid.f0.DEFAULT;
                    d(false);
                    a(new com.fyber.inneractive.sdk.mraid.d0(this.N));
                } else if (f0Var == com.fyber.inneractive.sdk.mraid.f0.DEFAULT) {
                    com.fyber.inneractive.sdk.mraid.f0 f0Var3 = com.fyber.inneractive.sdk.mraid.f0.HIDDEN;
                    this.N = f0Var3;
                    a(new com.fyber.inneractive.sdk.mraid.d0(f0Var3));
                }
                if (viewGroup3 != null) {
                    viewGroup3.setPadding(0, 0, 0, 0);
                }
                j1Var = this.g;
                if (j1Var != null) {
                    ((b0) j1Var).onClose();
                }
                if (Build.VERSION.SDK_INT < 33) {
                    r();
                    return;
                }
                return;
            }
        }
        viewGroup = null;
        if (viewGroup != null) {
        }
        this.T = false;
        if (p()) {
        }
        c(false);
        mVar = this.b;
        if (mVar != null) {
        }
        if (viewGroup3 != null) {
            viewGroup3.setLayoutParams(mVar2.getLayoutParams());
            if (p()) {
            }
        }
        this.N = com.fyber.inneractive.sdk.mraid.f0.DEFAULT;
        d(false);
        a(new com.fyber.inneractive.sdk.mraid.d0(this.N));
        if (viewGroup3 != null) {
        }
        j1Var = this.g;
        if (j1Var != null) {
        }
        if (Build.VERSION.SDK_INT < 33) {
        }
    }

    public final boolean p() {
        return this.N == com.fyber.inneractive.sdk.mraid.f0.EXPANDED;
    }

    public final void q() {
        com.fyber.inneractive.sdk.measurement.tracker.e bVar;
        com.fyber.inneractive.sdk.measurement.e eVar = this.H;
        if (eVar != null) {
            m mVar = this.b;
            com.fyber.inneractive.sdk.flow.x xVar = this.s;
            boolean z = false;
            IAlog.a("omsdk initMraidSession", new Object[0]);
            if (eVar.e == null) {
                IAlog.a("omsdk partner is null", new Object[0]);
                bVar = null;
            } else {
                if (xVar != null && xVar.c() != null && xVar.c().J) {
                    z = true;
                }
                com.fyber.inneractive.sdk.measurement.tracker.f fVar = eVar.f;
                Partner partner = eVar.e;
                fVar.getClass();
                bVar = z ? new com.fyber.inneractive.sdk.measurement.tracker.b(partner, mVar) : new com.fyber.inneractive.sdk.measurement.tracker.a(partner, mVar);
                bVar.a(mVar);
            }
            this.I = bVar;
        }
        g gVar = this.f;
        if (gVar != null) {
            gVar.a(this);
        }
    }

    public final void r() {
        try {
            if (!(com.fyber.inneractive.sdk.util.o.a(this.b) instanceof Activity) || this.m0 == null) {
                return;
            }
            ((Activity) com.fyber.inneractive.sdk.util.o.a(this.b)).getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.m0);
            this.m0 = null;
        } catch (Exception e) {
            IAlog.f("failed to unregisterOnBackInvokedCallback with error: %s", e.getMessage());
        }
    }

    @Override // com.fyber.inneractive.sdk.web.i1
    public void setAdDefaultSize(int i, int i2) {
        this.k0 = i;
        this.l0 = i2;
        this.d0 = i;
        this.e0 = i2;
    }

    public void setOrientationProperties(boolean z, String str) {
        if (C3040d4.h.D.equals(str)) {
            this.f0 = Orientation.PORTRAIT;
        } else if (C3040d4.h.C.equals(str)) {
            this.f0 = Orientation.LANDSCAPE;
        } else {
            this.f0 = Orientation.NONE;
        }
        j1 j1Var = this.g;
        if (j1Var != null) {
            ((b0) j1Var).a(z, this.f0);
        }
    }

    public void setResizeProperties() {
    }

    @Override // com.fyber.inneractive.sdk.web.i
    public final void b(boolean z) {
        m mVar = this.b;
        if (mVar != null && mVar.getViewTreeObserver() != null) {
            this.b.getViewTreeObserver().removeOnPreDrawListener(this.n0);
        }
        com.fyber.inneractive.sdk.util.r.b.post(new s(this));
        m mVar2 = this.S;
        if (mVar2 != null && mVar2.getParent() != null && (this.S.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.S.getParent()).removeView(this.S);
            this.S = null;
        }
        FrameLayout frameLayout = this.i0;
        if (frameLayout != null && this.j0 != null) {
            frameLayout.removeAllViewsInLayout();
            this.j0.removeAllViewsInLayout();
            ViewGroup viewGroup = this.R;
            if (viewGroup != null) {
                viewGroup.removeView(this.j0);
            }
        }
        this.f1804a = false;
        if (Build.VERSION.SDK_INT >= 33) {
            r();
        }
        super.b(z);
    }

    @Override // com.fyber.inneractive.sdk.web.i, com.fyber.inneractive.sdk.web.j
    public boolean a(WebView webView, String str) {
        IAlog.a("%shandle url for: %s webView = %s", IAlog.a(this), str, webView);
        if (this.N == com.fyber.inneractive.sdk.mraid.f0.EXPANDED && !TextUtils.isEmpty(str) && webView.equals(this.S) && !this.T) {
            this.T = true;
            return false;
        }
        return super.a(webView, str);
    }

    public final void c(boolean z) {
        if (this.R == null) {
            return;
        }
        if (z) {
            int b = com.fyber.inneractive.sdk.util.o.b(35);
            if (this.W == null) {
                IAcloseButton iAcloseButton = new IAcloseButton(com.fyber.inneractive.sdk.util.o.a(this.b), b);
                this.W = iAcloseButton;
                iAcloseButton.setOnClickListener(new o(this));
            }
            com.fyber.inneractive.sdk.util.t.a(this.W);
            this.j0.addView(this.W);
            IAcloseButton iAcloseButton2 = this.W;
            ViewGroup.LayoutParams layoutParams = iAcloseButton2.getLayoutParams();
            layoutParams.width = b;
            layoutParams.height = b;
            iAcloseButton2.setLayoutParams(layoutParams);
            com.fyber.inneractive.sdk.util.o.a(this.W, 53);
            IAcloseButton iAcloseButton3 = this.W;
            int b2 = com.fyber.inneractive.sdk.util.o.b(10);
            int b3 = com.fyber.inneractive.sdk.util.o.b(10);
            ViewGroup.LayoutParams layoutParams2 = iAcloseButton3.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams.leftMargin = 0;
                marginLayoutParams.topMargin = b2;
                marginLayoutParams.rightMargin = b3;
                marginLayoutParams.bottomMargin = 0;
                iAcloseButton3.setLayoutParams(marginLayoutParams);
            }
        } else {
            this.j0.removeView(this.W);
        }
        j1 j1Var = this.g;
        if (j1Var != null) {
            ((b0) j1Var).b(z);
        }
        this.X = !z;
    }

    @Override // com.fyber.inneractive.sdk.web.i1
    public final void a(Context context, boolean z) {
        Window window;
        Window window2;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) IAConfigManager.O.v.a().getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        this.Y = displayMetrics.density;
        Rect rect = new Rect();
        boolean z2 = context instanceof Activity;
        if (z2 && (window2 = ((Activity) context).getWindow()) != null) {
            window2.getDecorView().getWindowVisibleDisplayFrame(rect);
        }
        int i = rect.top;
        View findViewById = (!z2 || (window = ((Activity) context).getWindow()) == null) ? null : window.findViewById(android.R.id.content);
        int top = findViewById != null ? findViewById.getTop() - i : 0;
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        double d = i2;
        double d2 = 160.0d / displayMetrics.densityDpi;
        int i4 = (int) (d2 * d);
        int i5 = (int) (d2 * i3);
        int i6 = (i3 - i) - top;
        m mVar = this.b;
        if (mVar != null && mVar.getScaleX() != 1.0f && this.b.getScaleY() != 1.0f) {
            i4 = this.b.getWidthDp();
            i5 = this.b.getHeightDp();
            int b = (com.fyber.inneractive.sdk.util.o.b(this.b.getHeightDp()) - i) - top;
            this.b0 = this.Z;
            this.c0 = (int) ((160.0d / displayMetrics.densityDpi) * b);
        } else {
            double d3 = 160.0d / displayMetrics.densityDpi;
            this.b0 = (int) (d * d3);
            this.c0 = (int) (d3 * i6);
        }
        if (this.Z == i4 && this.a0 == i5) {
            return;
        }
        this.Z = i4;
        this.a0 = i5;
        if (z) {
            a(new com.fyber.inneractive.sdk.mraid.c0(i4, i5));
            a(new com.fyber.inneractive.sdk.mraid.a0(this.b0, this.c0));
            a(new com.fyber.inneractive.sdk.mraid.z(this.b0, this.c0));
            int i7 = this.d0;
            if (i7 > 0 && this.e0 > 0) {
                a(new com.fyber.inneractive.sdk.mraid.x(com.fyber.inneractive.sdk.util.o.c(i7), com.fyber.inneractive.sdk.util.o.c(this.e0)));
                return;
            }
            m mVar2 = this.b;
            if (mVar2 == null || mVar2.getWidth() <= 0 || this.b.getHeight() <= 0) {
                return;
            }
            a(new com.fyber.inneractive.sdk.mraid.x(com.fyber.inneractive.sdk.util.o.c(this.b.getWidth()), com.fyber.inneractive.sdk.util.o.c(this.b.getHeight())));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(String str, int i, int i2, boolean z, boolean z2) {
        ViewGroup viewGroup;
        float f;
        int i3;
        d0 d0Var;
        int i4;
        j1 j1Var;
        if (this.b == null || this.O == z.DISABLED || this.N != com.fyber.inneractive.sdk.mraid.f0.DEFAULT) {
            return;
        }
        if (str != null && !URLUtil.isValidUrl(str)) {
            a(com.fyber.inneractive.sdk.mraid.k.EXPAND, "URL passed to expand() was invalid.");
            return;
        }
        try {
            ViewGroup viewGroup2 = (ViewGroup) this.b.getRootView().findViewById(android.R.id.content);
            this.R = viewGroup2;
            if (viewGroup2 == null) {
                IAlog.f("Couldn't find content in the view tree", new Object[0]);
                a(com.fyber.inneractive.sdk.mraid.k.RESIZE, "Ad can be resized only if it's state is default or resized.");
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                this.m0 = new t(this);
                if (com.fyber.inneractive.sdk.util.o.a(this.b) instanceof Activity) {
                    ((Activity) com.fyber.inneractive.sdk.util.o.a(this.b)).getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.m0);
                }
            }
            this.X = z;
            j1 j1Var2 = this.g;
            if (j1Var2 != null) {
                ((b0) j1Var2).b(z);
            }
            d(z2);
            if (this.e0 >= 0) {
                this.e0 = com.fyber.inneractive.sdk.util.o.b(i2);
            }
            if (this.d0 >= 0) {
                this.d0 = com.fyber.inneractive.sdk.util.o.b(i);
            }
            m mVar = this.b;
            ViewGroup viewGroup3 = (ViewGroup) mVar.getParent();
            if (viewGroup3 != null) {
                View findViewById = viewGroup3.findViewById(R.id.ia_identifier_overlay);
                if (findViewById instanceof ViewGroup) {
                    viewGroup = (ViewGroup) findViewById;
                    if (str == null) {
                        m mVar2 = new m();
                        this.S = mVar2;
                        mVar2.setId(R.id.ia_inneractive_webview_mraid);
                        this.S.loadUrl(str);
                        this.S.setWebChromeClient(this.c);
                        this.S.setWebViewClient(this.d);
                        mVar = this.S;
                        mVar.setOnKeyListener(new u(this));
                    } else {
                        ViewGroup viewGroup4 = (ViewGroup) this.b.getParent();
                        if (viewGroup4 != null) {
                            int childCount = viewGroup4.getChildCount();
                            int i5 = 0;
                            while (i5 < childCount && viewGroup4.getChildAt(i5) != this.b) {
                                i5++;
                            }
                            ViewGroup viewGroup5 = (ViewGroup) viewGroup4.findViewById(R.id.ia_identifier_overlay);
                            this.g0 = i5;
                            com.fyber.inneractive.sdk.util.t.a(viewGroup5);
                            com.fyber.inneractive.sdk.util.t.a(this.h0);
                            viewGroup4.addView(this.h0, i5);
                            FrameLayout frameLayout = this.h0;
                            int width = this.b.getWidth();
                            int height = this.b.getHeight();
                            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                            layoutParams.width = width;
                            layoutParams.height = height;
                            frameLayout.setLayoutParams(layoutParams);
                            com.fyber.inneractive.sdk.util.o.a(this.h0, 17);
                            viewGroup4.removeView(this.b);
                        }
                    }
                    f = this.Y;
                    i3 = (int) ((50.0f * f) + 0.5f);
                    if (i2 >= 0 && i >= 0) {
                        i = (int) (i * f);
                        i2 = (int) (i2 * f);
                        if (i < i3) {
                            i = i3;
                        }
                        if (i2 < i3) {
                            i2 = i3;
                        }
                    }
                    View view = new View(com.fyber.inneractive.sdk.util.o.a(this.b));
                    view.setBackgroundColor(com.fyber.inneractive.sdk.util.o.a(this.b).getResources().getColor(R.color.ia_mraid_expanded_dimmed_bk));
                    view.setOnTouchListener(new n());
                    this.j0.addView(view);
                    ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                    layoutParams2.width = -1;
                    layoutParams2.height = -1;
                    view.setLayoutParams(layoutParams2);
                    com.fyber.inneractive.sdk.util.t.a(mVar);
                    this.i0.addView(mVar);
                    ViewGroup.LayoutParams layoutParams3 = mVar.getLayoutParams();
                    layoutParams3.width = -1;
                    layoutParams3.height = -1;
                    mVar.setLayoutParams(layoutParams3);
                    com.fyber.inneractive.sdk.util.t.a(this.i0);
                    this.j0.addView(this.i0);
                    FrameLayout frameLayout2 = this.i0;
                    ViewGroup.LayoutParams layoutParams4 = frameLayout2.getLayoutParams();
                    layoutParams4.width = i;
                    layoutParams4.height = i2;
                    frameLayout2.setLayoutParams(layoutParams4);
                    com.fyber.inneractive.sdk.util.o.a(this.i0, 17);
                    com.fyber.inneractive.sdk.util.t.a(this.j0);
                    this.R.addView(this.j0);
                    FrameLayout frameLayout3 = this.j0;
                    ViewGroup.LayoutParams layoutParams5 = frameLayout3.getLayoutParams();
                    layoutParams5.width = -1;
                    layoutParams5.height = -1;
                    frameLayout3.setLayoutParams(layoutParams5);
                    if (!mVar.hasFocus()) {
                        mVar.requestFocus();
                    }
                    d0Var = this.P;
                    if (d0Var != d0.ALWAYS_VISIBLE || (!this.X && d0Var != d0.ALWAYS_HIDDEN)) {
                        c(true);
                    }
                    com.fyber.inneractive.sdk.mraid.f0 f0Var = com.fyber.inneractive.sdk.mraid.f0.EXPANDED;
                    this.N = f0Var;
                    a(new com.fyber.inneractive.sdk.mraid.d0(f0Var));
                    i4 = this.d0;
                    if (i4 != -1 && this.e0 != -1) {
                        a(new com.fyber.inneractive.sdk.mraid.x(com.fyber.inneractive.sdk.util.o.c(i4), com.fyber.inneractive.sdk.util.o.c(this.e0)));
                    }
                    a(com.fyber.inneractive.sdk.mraid.k.EXPAND);
                    if (viewGroup != null) {
                        int dimension = (int) viewGroup.getContext().getResources().getDimension(R.dimen.ia_identifier_padding);
                        viewGroup.setPadding(dimension, 0, 0, dimension);
                        viewGroup.setLayoutParams(this.R.getLayoutParams());
                        this.R.addView(viewGroup);
                    }
                    j1Var = this.g;
                    if (j1Var == null) {
                        ((b0) j1Var).c();
                        return;
                    }
                    return;
                }
            }
            viewGroup = null;
            if (str == null) {
            }
            f = this.Y;
            i3 = (int) ((50.0f * f) + 0.5f);
            if (i2 >= 0) {
                i = (int) (i * f);
                i2 = (int) (i2 * f);
                if (i < i3) {
                }
                if (i2 < i3) {
                }
            }
            View view2 = new View(com.fyber.inneractive.sdk.util.o.a(this.b));
            view2.setBackgroundColor(com.fyber.inneractive.sdk.util.o.a(this.b).getResources().getColor(R.color.ia_mraid_expanded_dimmed_bk));
            view2.setOnTouchListener(new n());
            this.j0.addView(view2);
            ViewGroup.LayoutParams layoutParams22 = view2.getLayoutParams();
            layoutParams22.width = -1;
            layoutParams22.height = -1;
            view2.setLayoutParams(layoutParams22);
            com.fyber.inneractive.sdk.util.t.a(mVar);
            this.i0.addView(mVar);
            ViewGroup.LayoutParams layoutParams32 = mVar.getLayoutParams();
            layoutParams32.width = -1;
            layoutParams32.height = -1;
            mVar.setLayoutParams(layoutParams32);
            com.fyber.inneractive.sdk.util.t.a(this.i0);
            this.j0.addView(this.i0);
            FrameLayout frameLayout22 = this.i0;
            ViewGroup.LayoutParams layoutParams42 = frameLayout22.getLayoutParams();
            layoutParams42.width = i;
            layoutParams42.height = i2;
            frameLayout22.setLayoutParams(layoutParams42);
            com.fyber.inneractive.sdk.util.o.a(this.i0, 17);
            com.fyber.inneractive.sdk.util.t.a(this.j0);
            this.R.addView(this.j0);
            FrameLayout frameLayout32 = this.j0;
            ViewGroup.LayoutParams layoutParams52 = frameLayout32.getLayoutParams();
            layoutParams52.width = -1;
            layoutParams52.height = -1;
            frameLayout32.setLayoutParams(layoutParams52);
            if (!mVar.hasFocus()) {
            }
            d0Var = this.P;
            if (d0Var != d0.ALWAYS_VISIBLE) {
            }
            c(true);
            com.fyber.inneractive.sdk.mraid.f0 f0Var2 = com.fyber.inneractive.sdk.mraid.f0.EXPANDED;
            this.N = f0Var2;
            a(new com.fyber.inneractive.sdk.mraid.d0(f0Var2));
            i4 = this.d0;
            if (i4 != -1) {
                a(new com.fyber.inneractive.sdk.mraid.x(com.fyber.inneractive.sdk.util.o.c(i4), com.fyber.inneractive.sdk.util.o.c(this.e0)));
            }
            a(com.fyber.inneractive.sdk.mraid.k.EXPAND);
            if (viewGroup != null) {
            }
            j1Var = this.g;
            if (j1Var == null) {
            }
        } catch (Exception unused) {
            IAlog.f("Couldn't find content in the view tree", new Object[0]);
            a(com.fyber.inneractive.sdk.mraid.k.RESIZE, "Ad can be resized only if it's state is default or resized.");
        }
    }

    public static HashMap a(Map map) {
        String str;
        HashMap hashMap = new HashMap();
        if (map.containsKey("description") && map.containsKey("start")) {
            hashMap.put("title", map.get("description"));
            if (map.containsKey("start") && map.get("start") != null) {
                Date a2 = a((String) map.get("start"));
                if (a2 != null) {
                    hashMap.put("beginTime", Long.valueOf(a2.getTime()));
                    if (map.containsKey("end") && map.get("end") != null) {
                        Date a3 = a((String) map.get("end"));
                        if (a3 != null) {
                            hashMap.put("endTime", Long.valueOf(a3.getTime()));
                        } else {
                            throw new IllegalArgumentException("Invalid calendar event: end time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
                        }
                    }
                    if (map.containsKey(FirebaseAnalytics.Param.LOCATION)) {
                        hashMap.put("eventLocation", map.get(FirebaseAnalytics.Param.LOCATION));
                    }
                    if (map.containsKey("summary")) {
                        hashMap.put("description", map.get("summary"));
                    }
                    if (map.containsKey("transparency")) {
                        hashMap.put("availability", Integer.valueOf(C3040d4.h.T.equals(map.get("transparency")) ? 1 : 0));
                    }
                    StringBuilder sb = new StringBuilder();
                    if (map.containsKey("frequency")) {
                        String str2 = (String) map.get("frequency");
                        int parseInt = map.containsKey("interval") ? Integer.parseInt((String) map.get("interval")) : -1;
                        if ("daily".equals(str2)) {
                            sb.append("FREQ=DAILY;");
                            if (parseInt != -1) {
                                sb.append("INTERVAL=" + parseInt + ";");
                            }
                        } else {
                            if ("weekly".equals(str2)) {
                                sb.append("FREQ=WEEKLY;");
                                if (parseInt != -1) {
                                    sb.append("INTERVAL=" + parseInt + ";");
                                }
                                if (map.containsKey("daysInWeek")) {
                                    String str3 = (String) map.get("daysInWeek");
                                    StringBuilder sb2 = new StringBuilder();
                                    boolean[] zArr = new boolean[7];
                                    String[] split = str3.split(",");
                                    for (String str4 : split) {
                                        int parseInt2 = Integer.parseInt(str4);
                                        if (parseInt2 == 7) {
                                            parseInt2 = 0;
                                        }
                                        if (!zArr[parseInt2]) {
                                            StringBuilder sb3 = new StringBuilder();
                                            switch (parseInt2) {
                                                case 0:
                                                    str = "SU";
                                                    break;
                                                case 1:
                                                    str = "MO";
                                                    break;
                                                case 2:
                                                    str = "TU";
                                                    break;
                                                case 3:
                                                    str = "WE";
                                                    break;
                                                case 4:
                                                    str = "TH";
                                                    break;
                                                case 5:
                                                    str = "FR";
                                                    break;
                                                case 6:
                                                    str = "SA";
                                                    break;
                                                default:
                                                    throw new IllegalArgumentException(com.fyber.inneractive.sdk.player.exoplayer2.m.a("invalid day of week ", parseInt2));
                                            }
                                            sb2.append(sb3.append(str).append(",").toString());
                                            zArr[parseInt2] = true;
                                        }
                                    }
                                    if (split.length != 0) {
                                        sb2.deleteCharAt(sb2.length() - 1);
                                        String sb4 = sb2.toString();
                                        if (sb4 != null) {
                                            sb.append("BYDAY=" + sb4 + ";");
                                        } else {
                                            throw new IllegalArgumentException("invalid ");
                                        }
                                    } else {
                                        throw new IllegalArgumentException("must have at least 1 day of the week if specifying repeating weekly");
                                    }
                                }
                            } else if ("monthly".equals(str2)) {
                                sb.append("FREQ=MONTHLY;");
                                if (parseInt != -1) {
                                    sb.append("INTERVAL=" + parseInt + ";");
                                }
                                if (map.containsKey("daysInMonth")) {
                                    String str5 = (String) map.get("daysInMonth");
                                    StringBuilder sb5 = new StringBuilder();
                                    boolean[] zArr2 = new boolean[63];
                                    String[] split2 = str5.split(",");
                                    for (String str6 : split2) {
                                        int parseInt3 = Integer.parseInt(str6);
                                        int i = parseInt3 + 31;
                                        if (!zArr2[i]) {
                                            StringBuilder sb6 = new StringBuilder();
                                            if (parseInt3 != 0 && parseInt3 >= -31 && parseInt3 <= 31) {
                                                sb5.append(sb6.append("" + parseInt3).append(",").toString());
                                                zArr2[i] = true;
                                            } else {
                                                throw new IllegalArgumentException(com.fyber.inneractive.sdk.player.exoplayer2.m.a("invalid day of month ", parseInt3));
                                            }
                                        }
                                    }
                                    if (split2.length != 0) {
                                        sb5.deleteCharAt(sb5.length() - 1);
                                        String sb7 = sb5.toString();
                                        if (sb7 != null) {
                                            sb.append("BYMONTHDAY=" + sb7 + ";");
                                        } else {
                                            throw new IllegalArgumentException();
                                        }
                                    } else {
                                        throw new IllegalArgumentException("must have at least 1 day of the month if specifying repeating weekly");
                                    }
                                }
                            } else {
                                throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
                            }
                        }
                    }
                    String sb8 = sb.toString();
                    if (!TextUtils.isEmpty(sb8)) {
                        hashMap.put("rrule", sb8);
                    }
                    return hashMap;
                }
                throw new IllegalArgumentException("Invalid calendar event: start time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
            }
            throw new IllegalArgumentException("Invalid calendar event: start is null.");
        }
        throw new IllegalArgumentException("Missing start and description fields");
    }

    public static Date a(String str) {
        Date date = null;
        int i = 0;
        while (true) {
            String[] strArr = o0;
            if (i >= 2) {
                break;
            }
            try {
                date = new SimpleDateFormat(strArr[i], Locale.getDefault()).parse(str);
            } catch (ParseException unused) {
            }
            if (date != null) {
                break;
            }
            i++;
        }
        return date;
    }

    public final void a(com.fyber.inneractive.sdk.mraid.k kVar, String str) {
        String a2 = kVar.a();
        m mVar = this.b;
        if (mVar != null) {
            mVar.a("window.mraidbridge.fireErrorEvent('" + a2 + "', '" + str + "');");
        }
    }

    public static LinkedHashMap a(URI uri) {
        int i;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null && rawQuery.length() > 0) {
            for (String str : rawQuery.split(C3040d4.i.c)) {
                int indexOf = str.indexOf(C3040d4.i.b);
                linkedHashMap.put(indexOf > 0 ? URLDecoder.decode(str.substring(0, indexOf), "UTF-8") : str, (indexOf <= 0 || str.length() <= (i = indexOf + 1)) ? null : URLDecoder.decode(str.substring(i), "UTF-8"));
            }
        }
        return linkedHashMap;
    }

    public final void a(View view, com.fyber.inneractive.sdk.measurement.tracker.d dVar) {
        com.fyber.inneractive.sdk.measurement.tracker.e eVar;
        if (view == null || (eVar = this.I) == null) {
            return;
        }
        eVar.getClass();
        try {
            AdSession adSession = eVar.f1273a;
            if (adSession != null) {
                if (dVar == com.fyber.inneractive.sdk.measurement.tracker.d.CloseButton) {
                    adSession.addFriendlyObstruction(view, FriendlyObstructionPurpose.CLOSE_AD, dVar.name());
                } else {
                    adSession.addFriendlyObstruction(view, FriendlyObstructionPurpose.OTHER, dVar.name());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(com.fyber.inneractive.sdk.mraid.k kVar) {
        com.fyber.inneractive.sdk.config.global.r rVar;
        com.fyber.inneractive.sdk.network.u uVar = com.fyber.inneractive.sdk.network.u.BANNER_RESIZE_EXPAND;
        InneractiveAdRequest inneractiveAdRequest = this.r;
        com.fyber.inneractive.sdk.flow.x xVar = this.s;
        com.fyber.inneractive.sdk.response.e c = xVar != null ? xVar.c() : null;
        com.fyber.inneractive.sdk.flow.x xVar2 = this.s;
        JSONArray b = (xVar2 == null || (rVar = xVar2.c) == null) ? null : rVar.b();
        com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(c);
        wVar.c = uVar;
        wVar.f1340a = inneractiveAdRequest;
        wVar.d = b;
        wVar.a("action", kVar.a()).a((String) null);
    }
}
