package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.a1;
import com.mbridge.msdk.foundation.tools.h0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.video.module.listener.impl.j;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class MBridgeVideoEndCoverView extends MBridgeBaseView {
    private final String m;
    private View n;
    private ImageView o;
    private ImageView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private com.mbridge.msdk.video.signal.factory.b t;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MBridgeVideoEndCoverView.this.notifyListener.a(104, "");
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MBridgeVideoEndCoverView.this.g();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MBridgeVideoEndCoverView.this.g();
        }
    }

    public MBridgeVideoEndCoverView(Context context) {
        super(context);
        this.m = "MBridgeVideoEndCoverView";
    }

    private boolean a(View view) {
        if (view == null) {
            return true;
        }
        try {
            this.o = (ImageView) view.findViewById(findID("mbridge_vec_iv_icon"));
            this.p = (ImageView) view.findViewById(findID("mbridge_vec_iv_close"));
            this.q = (TextView) view.findViewById(findID("mbridge_vec_tv_title"));
            this.r = (TextView) view.findViewById(findID("mbridge_vec_tv_desc"));
            this.s = (TextView) view.findViewById(findID("mbridge_vec_btn"));
            return true;
        } catch (Throwable th) {
            p0.b("MBridgeVideoEndCoverView", th.getMessage());
            return false;
        }
    }

    private void e() {
        ImageView imageView;
        CampaignEx campaignEx = this.b;
        if (campaignEx != null) {
            if (!TextUtils.isEmpty(campaignEx.getIconUrl()) && (imageView = this.o) != null) {
                a1.a(imageView, this.b.getLocalRequestId(), this.b.getLocalAllowTrackClick());
                com.mbridge.msdk.foundation.same.image.b.a(this.f5088a.getApplicationContext()).a(this.b.getIconUrl(), new j(this.o, u0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 8.0f)));
            }
            TextView textView = this.q;
            if (textView != null) {
                textView.setText(this.b.getAppName());
            }
            TextView textView2 = this.s;
            if (textView2 != null) {
                a1.a(textView2, this.b.getLocalRequestId(), this.b.getLocalAllowTrackClick());
                this.s.setText(this.b.getAdCall());
            }
            TextView textView3 = this.r;
            if (textView3 != null) {
                textView3.setText(this.b.getAppDesc());
            }
        }
    }

    private void f() {
        View view = this.n;
        if (view == null) {
            init(this.f5088a);
            preLoadData(this.t);
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.n.getParent()).removeView(this.n);
        }
        addView(this.n);
        a(this.n);
        d();
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    protected void d() {
        super.d();
        this.p.setOnClickListener(new a());
        this.o.setOnClickListener(new b());
        this.s.setOnClickListener(new c());
    }

    protected void g() {
        JSONException e;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONException e2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(com.mbridge.msdk.foundation.same.a.h, u0.b(com.mbridge.msdk.foundation.controller.c.m().d(), this.f));
                    jSONObject2.put(com.mbridge.msdk.foundation.same.a.i, u0.b(com.mbridge.msdk.foundation.controller.c.m().d(), this.g));
                    jSONObject2.put(com.mbridge.msdk.foundation.same.a.m, 0);
                    try {
                        this.d = getContext().getResources().getConfiguration().orientation;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    jSONObject2.put(com.mbridge.msdk.foundation.same.a.k, this.d);
                    jSONObject2.put(com.mbridge.msdk.foundation.same.a.l, u0.d(getContext()));
                } catch (JSONException e4) {
                    e2 = e4;
                    p0.b("MBridgeVideoEndCoverView", e2.getMessage());
                    jSONObject = new JSONObject();
                    jSONObject.put(com.mbridge.msdk.foundation.same.a.j, jSONObject2);
                    this.notifyListener.a(105, jSONObject);
                }
            } catch (JSONException e5) {
                jSONObject2 = jSONObject3;
                e2 = e5;
            }
            jSONObject = new JSONObject();
            try {
                jSONObject.put(com.mbridge.msdk.foundation.same.a.j, jSONObject2);
            } catch (JSONException e6) {
                e = e6;
                e.printStackTrace();
                this.notifyListener.a(105, jSONObject);
            }
        } catch (JSONException e7) {
            e = e7;
            jSONObject = null;
        }
        this.notifyListener.a(105, jSONObject);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
        int findLayout = findLayout("mbridge_reward_videoend_cover");
        if (h0.a(findLayout)) {
            View inflate = this.c.inflate(findLayout, (ViewGroup) null);
            this.n = inflate;
            if (inflate != null) {
                this.e = a(inflate);
                addView(this.n, -1, -1);
                d();
            }
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f = motionEvent.getRawX();
        this.g = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.d = configuration.orientation;
        removeView(this.n);
        f();
    }

    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.t = bVar;
        try {
            if (this.b == null || !this.e) {
                return;
            }
            e();
        } catch (Throwable th) {
            p0.a("MBridgeVideoEndCoverView", th.getMessage());
        }
    }

    public MBridgeVideoEndCoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = "MBridgeVideoEndCoverView";
    }
}
