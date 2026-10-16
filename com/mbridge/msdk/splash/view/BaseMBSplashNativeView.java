package com.mbridge.msdk.splash.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.a1;
import com.mbridge.msdk.foundation.tools.h0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.shake.MBShakeView;
import com.mbridge.msdk.splash.view.nativeview.MBNoRecycledCrashImageView;
import com.mbridge.msdk.splash.view.nativeview.MBSplashClickView;
import com.mbridge.msdk.widget.FeedBackButton;

/* loaded from: classes6.dex */
public class BaseMBSplashNativeView extends RelativeLayout {
    private int A;
    private int B;
    private int C;
    private float D;
    private float E;
    private boolean F;
    private boolean G;
    protected boolean H;
    protected boolean I;
    protected boolean J;
    protected String K;
    private String L;
    protected MBSplashView M;
    protected CampaignEx N;
    protected MBShakeView O;
    private String P;
    private String Q;
    private String R;
    protected com.mbridge.msdk.shake.b S;

    /* renamed from: a, reason: collision with root package name */
    private MBNoRecycledCrashImageView f4772a;
    private MBNoRecycledCrashImageView b;
    private RelativeLayout c;
    private ImageView d;
    private FeedBackButton e;
    protected TextView f;
    private RelativeLayout g;
    private MBNoRecycledCrashImageView h;
    private TextView i;
    private MBNoRecycledCrashImageView j;
    private TextView k;
    private TextView l;
    protected RelativeLayout m;
    protected TextView n;
    protected TextView o;
    protected TextView p;
    protected TextView q;
    protected MBSplashClickView r;
    protected int s;
    private int t;
    private int u;
    private int v;
    protected int w;
    protected int x;
    protected int y;
    protected int z;

    class a implements com.mbridge.msdk.foundation.same.image.c {
        a() {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            if (bitmap != null) {
                try {
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    if (bitmap.getWidth() < bitmap.getHeight()) {
                        BaseMBSplashNativeView.this.G = true;
                        BaseMBSplashNativeView.this.g.setVisibility(4);
                        BaseMBSplashNativeView.this.b.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        BaseMBSplashNativeView.this.b.setImageBitmap(bitmap);
                    } else if (BaseMBSplashNativeView.this.A == 1) {
                        BaseMBSplashNativeView.this.g.setVisibility(0);
                        try {
                            Bitmap a2 = o0.a(bitmap, 1, u0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 10.0f));
                            if (a2 != null && !a2.isRecycled()) {
                                BaseMBSplashNativeView.this.j.setScaleType(ImageView.ScaleType.FIT_XY);
                                BaseMBSplashNativeView.this.j.setImageBitmap(a2);
                            }
                        } catch (Throwable th) {
                            try {
                                p0.b("MBSplashNativeView", th.getMessage());
                                BaseMBSplashNativeView.this.j.setImageBitmap(bitmap);
                            } catch (Throwable th2) {
                                p0.b("MBSplashNativeView", th2.getMessage());
                            }
                        }
                        BaseMBSplashNativeView.this.i.setText(BaseMBSplashNativeView.this.N.getAppName());
                        BaseMBSplashNativeView.this.f();
                        try {
                            try {
                                Bitmap a3 = o0.a(bitmap);
                                if (a3 != null && !a3.isRecycled()) {
                                    BaseMBSplashNativeView.this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                    BaseMBSplashNativeView.this.b.setImageBitmap(a3);
                                }
                            } catch (Throwable th3) {
                                p0.b("MBSplashNativeView", th3.getMessage());
                            }
                        } catch (Throwable unused) {
                            BaseMBSplashNativeView.this.b.setImageBitmap(bitmap);
                        }
                    } else {
                        BaseMBSplashNativeView.this.g.setVisibility(4);
                        BaseMBSplashNativeView.this.b.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        BaseMBSplashNativeView.this.b.setImageBitmap(bitmap);
                    }
                    try {
                        Bitmap a4 = o0.a(bitmap);
                        if (a4 == null || a4.isRecycled()) {
                            return;
                        }
                        BaseMBSplashNativeView.this.f4772a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        BaseMBSplashNativeView.this.f4772a.setImageBitmap(a4);
                    } catch (Throwable unused2) {
                        BaseMBSplashNativeView.this.b.setImageBitmap(bitmap);
                    }
                } catch (Throwable th4) {
                    p0.b("MBSplashNativeView", th4.getMessage());
                }
            }
        }
    }

    class b implements com.mbridge.msdk.foundation.same.image.c {
        b() {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            BaseMBSplashNativeView.this.h.setVisibility(4);
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            Bitmap a2;
            if (bitmap != null) {
                try {
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    try {
                        if (BaseMBSplashNativeView.this.h == null || (a2 = o0.a(bitmap, 1, u0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 40.0f))) == null || a2.isRecycled()) {
                            return;
                        }
                        BaseMBSplashNativeView.this.h.setImageBitmap(a2);
                    } catch (Throwable th) {
                        p0.b("MBSplashNativeView", th.getMessage());
                        BaseMBSplashNativeView.this.h.setImageBitmap(bitmap);
                    }
                } catch (Throwable th2) {
                    p0.b("MBSplashNativeView", th2.getMessage());
                }
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseMBSplashNativeView.this.a(1);
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseMBSplashNativeView.this.a(0);
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseMBSplashNativeView baseMBSplashNativeView = BaseMBSplashNativeView.this;
            if (baseMBSplashNativeView.H) {
                if (baseMBSplashNativeView.M.getSplashSignalCommunicationImpl() != null && BaseMBSplashNativeView.this.M.getSplashSignalCommunicationImpl().a() != null) {
                    BaseMBSplashNativeView.this.M.getSplashSignalCommunicationImpl().a().close();
                }
                BaseMBSplashNativeView.this.f.setVisibility(4);
                BaseMBSplashNativeView.this.f.setEnabled(false);
            }
        }
    }

    public BaseMBSplashNativeView(Context context) {
        super(context);
        this.I = false;
        this.J = false;
    }

    private void i() {
        if (this.v == 1) {
            this.r.setVisibility(8);
        } else if (this.x == 1) {
            this.r.setVisibility(8);
        } else {
            this.r.initView(this.N.getAdCall());
        }
    }

    private void j() {
        com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
        eVar.a("adtp", 297);
        if (TextUtils.isEmpty(this.N.getBidToken())) {
            eVar.a(CampaignEx.JSON_KEY_HB, 0);
        } else {
            eVar.a(CampaignEx.JSON_KEY_HB, 1);
        }
        com.mbridge.msdk.foundation.same.report.metrics.c a2 = com.mbridge.msdk.foundation.same.report.metrics.d.b().a(true, this.N.getBidToken(), eVar, this.N, this.K);
        if (this.u == 1) {
            a1.a(this, a2.o(), this.N.getLocalAllowTrackClick());
            setOnClickListener(new d());
        } else {
            a1.a(this.r, a2.o(), this.N.getLocalAllowTrackClick());
            this.r.setOnClickListener(new e());
        }
        this.f.setOnClickListener(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCountDownStatus(boolean z) {
        if (this.M.getSplashSignalCommunicationImpl() == null || this.M.getSplashSignalCommunicationImpl().a() == null) {
            return;
        }
        this.M.getSplashSignalCommunicationImpl().a().a(z ? 2 : 1, this.t);
    }

    protected void b() {
    }

    protected void e() {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            if (this.x != 1 || this.O == null || this.S == null) {
                return;
            }
            com.mbridge.msdk.shake.a.a().a(this.S);
        } catch (Throwable th) {
            p0.b("MBSplashNativeView", th.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.D = motionEvent.getRawX();
        this.E = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void release() {
        try {
            if (this.S != null) {
                com.mbridge.msdk.shake.a.a().b(this.S);
                this.S = null;
            }
            com.mbridge.msdk.foundation.feedback.b.b().d(this.K);
            detachAllViewsFromParent();
        } catch (Exception e2) {
            p0.b("MBSplashNativeView", e2.getMessage());
        }
    }

    public void setIsPause(boolean z) {
        this.I = z;
    }

    public void setNotchPadding(int i, int i2, int i3, int i4) {
        try {
            RelativeLayout relativeLayout = this.c;
            if (relativeLayout == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            int i5 = this.C;
            layoutParams.leftMargin = i + i5;
            layoutParams.rightMargin = i2 + i5;
            layoutParams.topMargin = i3 + i5;
            layoutParams.bottomMargin = i5 + i4;
        } catch (Throwable th) {
            p0.b("MBSplashNativeView", th.getMessage());
        }
    }

    public void updateCountDown(int i) {
        if (this.f != null) {
            this.t = i;
            this.f.setText(this.H ? this.Q + " " + i + this.P : i + this.P + " " + this.R);
        }
    }

    class c implements com.mbridge.msdk.foundation.feedback.a {
        c() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            BaseMBSplashNativeView baseMBSplashNativeView = BaseMBSplashNativeView.this;
            baseMBSplashNativeView.J = true;
            baseMBSplashNativeView.setCountDownStatus(false);
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            BaseMBSplashNativeView baseMBSplashNativeView = BaseMBSplashNativeView.this;
            baseMBSplashNativeView.J = false;
            baseMBSplashNativeView.setCountDownStatus(true);
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            BaseMBSplashNativeView baseMBSplashNativeView = BaseMBSplashNativeView.this;
            baseMBSplashNativeView.J = false;
            baseMBSplashNativeView.setCountDownStatus(true);
        }
    }

    class g implements com.mbridge.msdk.foundation.feedback.a {
        g() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            BaseMBSplashNativeView baseMBSplashNativeView = BaseMBSplashNativeView.this;
            baseMBSplashNativeView.J = true;
            baseMBSplashNativeView.setCountDownStatus(false);
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            BaseMBSplashNativeView baseMBSplashNativeView = BaseMBSplashNativeView.this;
            baseMBSplashNativeView.J = false;
            baseMBSplashNativeView.setCountDownStatus(true);
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            BaseMBSplashNativeView baseMBSplashNativeView = BaseMBSplashNativeView.this;
            baseMBSplashNativeView.J = false;
            baseMBSplashNativeView.setCountDownStatus(true);
        }
    }

    private void c() {
        try {
            this.F = getContext().getResources().getConfiguration().locale.getLanguage().contains("zh");
        } catch (Throwable th) {
            p0.b("MBSplashNativeView", th.getMessage());
        }
        a();
        g();
        h();
        e();
        i();
        j();
        b();
        updateCountDown(this.s);
    }

    private void d() {
        try {
            View inflate = LayoutInflater.from(getContext()).inflate(this.A == 1 ? h0.a(getContext().getApplicationContext(), "mbridge_splash_portrait", "layout") : h0.a(getContext().getApplicationContext(), "mbridge_splash_landscape", "layout"), (ViewGroup) null);
            addView(inflate);
            this.f4772a = (MBNoRecycledCrashImageView) inflate.findViewById(h0.a(getContext().getApplicationContext(), "mbridge_splash_iv_image_bg", "id"));
            this.b = (MBNoRecycledCrashImageView) inflate.findViewById(h0.a(getContext().getApplicationContext(), "mbridge_splash_iv_image", "id"));
            this.c = (RelativeLayout) inflate.findViewById(h0.a(getContext().getApplicationContext(), "mbridge_splash_topcontroller", "id"));
            this.d = (ImageView) inflate.findViewById(h0.a(getContext().getApplicationContext(), "mbridge_splash_iv_link", "id"));
            this.e = (FeedBackButton) inflate.findViewById(h0.a(getContext().getApplicationContext(), "mbridge_splash_feedback", "id"));
            this.f = (TextView) inflate.findViewById(h0.a(getContext().getApplicationContext(), "mbridge_splash_tv_skip", "id"));
            this.g = (RelativeLayout) inflate.findViewById(h0.a(getContext().getApplicationContext(), "mbridge_splash_landscape_foreground", "id"));
            this.h = (MBNoRecycledCrashImageView) inflate.findViewById(h0.a(getContext().getApplicationContext(), "mbridge_splash_iv_icon", "id"));
            this.i = (TextView) inflate.findViewById(h0.a(getContext().getApplicationContext(), "mbridge_splash_tv_title", "id"));
            this.j = (MBNoRecycledCrashImageView) inflate.findViewById(h0.a(getContext().getApplicationContext(), "mbridge_splash_iv_foregroundimage", "id"));
            this.k = (TextView) inflate.findViewById(h0.a(getContext().getApplicationContext(), "mbridge_splash_tv_adrect", "id"));
            this.m = (RelativeLayout) inflate.findViewById(h0.a(getContext().getApplicationContext(), "mbridge_splash_layout_appinfo", "id"));
            this.n = (TextView) inflate.findViewById(h0.a(getContext().getApplicationContext(), "mbridge_splash_tv_appinfo", "id"));
            this.o = (TextView) inflate.findViewById(h0.a(getContext().getApplicationContext(), "mbridge_splash_tv_privacy", "id"));
            this.p = (TextView) inflate.findViewById(h0.a(getContext().getApplicationContext(), "mbridge_splash_tv_permission", "id"));
            this.q = (TextView) inflate.findViewById(h0.a(getContext().getApplicationContext(), "mbridge_splash_tv_app_desc", "id"));
            this.r = (MBSplashClickView) inflate.findViewById(h0.a(getContext().getApplicationContext(), "mbridge_splash_tv_click", "id"));
            this.l = (TextView) inflate.findViewById(h0.a(getContext().getApplicationContext(), "mbridge_splash_tv_adcircle", "id"));
            int a2 = h0.a(getContext().getApplicationContext(), "mbridge_splash_count_time_can_skip", "string");
            int a3 = h0.a(getContext().getApplicationContext(), "mbridge_splash_count_time_can_skip_not", "string");
            int a4 = h0.a(getContext().getApplicationContext(), "mbridge_splash_count_time_can_skip_s", "string");
            this.Q = getContext().getResources().getString(a2);
            this.R = getContext().getResources().getString(a3);
            this.P = getContext().getResources().getString(a4);
            this.C = u0.a(getContext(), 9.0f);
        } catch (Throwable th) {
            p0.b("MBSplashNativeView", th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (TextUtils.isEmpty(this.N.getIconUrl())) {
            this.h.setVisibility(4);
        } else {
            com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(this.N.getIconUrl(), new b());
        }
    }

    private void g() {
        if (TextUtils.isEmpty(this.N.getImageUrl())) {
            this.b.setVisibility(4);
        } else {
            com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(this.N.getImageUrl(), new a());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void h() {
        Drawable drawable;
        u0.a(3, this.d, this.N, getContext(), true, new c());
        try {
            drawable = getResources().getDrawable(h0.a(getContext().getApplicationContext(), "mbridge_splash_m_circle", "drawable"));
            try {
                drawable.setBounds(0, 0, u0.a(getContext(), 10.0f), u0.a(getContext(), 10.0f));
            } catch (Throwable th) {
                th = th;
                p0.b("MBSplashNativeView", th.getMessage());
                if (this.A == 1) {
                }
                if (this.B != 0) {
                    this.k.setCompoundDrawables(drawable, null, null, null);
                }
                this.k.setText(this.F ? "广告" : "AD");
                this.l.setVisibility(4);
                return;
            }
        } catch (Throwable th2) {
            th = th2;
            drawable = null;
        }
        if (this.A == 1 || !this.G) {
            if (this.B != 0 && drawable != null) {
                this.k.setCompoundDrawables(drawable, null, null, null);
            }
            this.k.setText(this.F ? "广告" : "AD");
            this.l.setVisibility(4);
            return;
        }
        if (this.B != 0 && drawable != null) {
            this.l.setCompoundDrawables(drawable, null, null, null);
        }
        this.l.setText(this.F ? "广告" : "AD");
        this.k.setVisibility(4);
    }

    protected void a(int i) {
        if (this.M.getSplashSignalCommunicationImpl() == null || this.M.getSplashSignalCommunicationImpl().a() == null) {
            return;
        }
        try {
            this.M.getSplashSignalCommunicationImpl().a().a(com.mbridge.msdk.splash.common.util.a.a(com.mbridge.msdk.splash.common.util.a.a(i, this.D, this.E), this.N));
        } catch (Throwable th) {
            p0.b("MBSplashNativeView", th.getMessage());
            this.M.getSplashSignalCommunicationImpl().a().a(this.N);
        }
    }

    public BaseMBSplashNativeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseMBSplashNativeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.I = false;
        this.J = false;
    }

    public BaseMBSplashNativeView(Context context, MBSplashView mBSplashView, com.mbridge.msdk.splash.common.c cVar) {
        super(context);
        this.I = false;
        this.J = false;
        if (cVar != null) {
            this.K = cVar.l();
            this.L = cVar.h();
            this.N = cVar.b();
            this.M = mBSplashView;
            this.s = cVar.d();
            this.v = cVar.c();
            this.u = cVar.f();
            this.w = cVar.a();
            this.x = cVar.i();
            this.y = cVar.j();
            this.z = cVar.k();
            this.A = cVar.g();
            this.H = cVar.m();
            this.B = cVar.e();
            d();
            c();
            return;
        }
        throw new IllegalArgumentException("Parameters is NULL, can't gen view.");
    }

    private void a() {
        CampaignEx campaignEx = this.N;
        if (campaignEx != null) {
            campaignEx.setCampaignUnitId(this.K);
            com.mbridge.msdk.foundation.feedback.b.b().a(this.K, 3);
            com.mbridge.msdk.foundation.feedback.b.b().a(this.K, this.N);
        }
        if (com.mbridge.msdk.foundation.feedback.b.b().a()) {
            com.mbridge.msdk.foundation.feedback.b.b().a(this.K, new g());
            com.mbridge.msdk.foundation.feedback.b.b().a(this.K, this.e);
            com.mbridge.msdk.foundation.feedback.b.b().a(this.K, 3);
            com.mbridge.msdk.foundation.feedback.b.b().a(this.K, this.N);
            return;
        }
        FeedBackButton feedBackButton = this.e;
        if (feedBackButton != null) {
            feedBackButton.setVisibility(8);
        }
    }
}
