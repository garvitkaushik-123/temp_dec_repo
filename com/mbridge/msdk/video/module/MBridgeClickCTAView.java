package com.mbridge.msdk.video.module;

import android.animation.ObjectAnimator;
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
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.tools.a1;
import com.mbridge.msdk.foundation.tools.h0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.video.dynview.listener.h;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class MBridgeClickCTAView extends MBridgeClickCTAViewDiff {
    public f ctaClickCallBack;
    private ViewGroup m;
    private ImageView n;
    private TextView o;
    private TextView p;
    private String q;
    private float r;
    private float s;
    private int t;
    private ObjectAnimator u;

    class b extends com.mbridge.msdk.widget.a {
        b() {
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            MBridgeClickCTAView.this.getClass();
            MBridgeClickCTAView.this.e();
        }
    }

    class c extends com.mbridge.msdk.widget.a {
        c() {
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            MBridgeClickCTAView.this.getClass();
            MBridgeClickCTAView.this.e();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    class e extends com.mbridge.msdk.video.module.listener.impl.e {
        e(ImageView imageView, CampaignEx campaignEx, String str) {
            super(imageView, campaignEx, str);
        }

        @Override // com.mbridge.msdk.video.module.listener.impl.e, com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            super.onFailedLoad(str, str2);
            MBridgeClickCTAView.this.g();
        }
    }

    public interface f {
    }

    public MBridgeClickCTAView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        JSONObject jSONObject;
        CampaignEx campaignEx = this.b;
        if (campaignEx != null && campaignEx.isDynamicView()) {
            try {
                CampaignEx.c rewardTemplateMode = this.b.getRewardTemplateMode();
                j.a(com.mbridge.msdk.foundation.controller.c.m().d(), "cta_click", this.b.getCampaignUnitId(), this.b.isBidCampaign(), this.b.getRequestId(), this.b.getRequestIdNotice(), this.b.getId(), rewardTemplateMode != null ? rewardTemplateMode.f() + "" : "");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(com.mbridge.msdk.foundation.same.a.j, a(0));
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
                this.b.setTriggerClickSource(1);
                this.b.setClickTempSource(1);
                this.notifyListener.a(105, jSONObject);
            }
        } catch (JSONException e4) {
            e = e4;
            jSONObject = null;
        }
        this.b.setTriggerClickSource(1);
        this.b.setClickTempSource(1);
        this.notifyListener.a(105, jSONObject);
    }

    private void f() {
        int findLayout = findLayout("mbridge_reward_clickable_cta");
        if (h0.a(findLayout)) {
            this.c.inflate(findLayout, this);
            this.e = h();
            d();
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        ImageView imageView = this.n;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        this.m = (ViewGroup) findViewById(findID("mbridge_viewgroup_ctaroot"));
        this.n = (ImageView) findViewById(findID("mbridge_iv_appicon"));
        this.o = (TextView) findViewById(findID("mbridge_tv_title"));
        TextView textView = (TextView) findViewById(findID("mbridge_tv_install"));
        this.ctaTv = textView;
        return isNotNULL(this.m, this.n, this.o, textView);
    }

    private void i() {
        setWrapContent();
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    protected void d() {
        super.d();
        if (this.e) {
            CampaignEx campaignEx = this.b;
            if (campaignEx != null && campaignEx.isDynamicView()) {
                a1.a(this, this.b.getLocalRequestId(), this.b.getLocalAllowTrackClick());
                setOnClickListener(new b());
            }
            CampaignEx campaignEx2 = this.b;
            if (campaignEx2 != null) {
                a1.a(this.ctaTv, campaignEx2.getLocalRequestId(), this.b.getLocalAllowTrackClick());
            }
            this.ctaTv.setOnClickListener(new c());
            ImageView imageView = this.n;
            if (imageView != null) {
                imageView.setOnClickListener(new d());
            }
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeClickCTAViewDiff, com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ObjectAnimator objectAnimator = this.u;
        if (objectAnimator != null) {
            try {
                objectAnimator.start();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.u;
        if (objectAnimator != null) {
            try {
                objectAnimator.cancel();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.r = motionEvent.getRawX();
        this.s = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.t = configuration.orientation;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeClickCTAViewDiff
    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        CampaignEx campaignEx = this.b;
        if (campaignEx != null) {
            if (campaignEx.isDynamicView()) {
                a(this, this.b);
            } else {
                f();
            }
            if (this.e) {
                if (com.mbridge.msdk.util.b.a()) {
                    setChinaCTAData();
                }
                this.ctaTv.setText(this.b.getAdCall());
                if (TextUtils.isEmpty(this.b.getIconUrl())) {
                    g();
                } else {
                    com.mbridge.msdk.foundation.same.image.b.a(this.f5088a.getApplicationContext()).a(this.b.getIconUrl(), new e(this.n, this.b, this.q));
                }
                if (this.o != null && !TextUtils.isEmpty(this.b.getAppName())) {
                    this.o.setText(this.b.getAppName());
                }
                if (this.p == null || TextUtils.isEmpty(this.b.getAppDesc())) {
                    return;
                }
                this.p.setText(this.b.getAppDesc());
            }
        }
    }

    public void setCtaClickCallBack(f fVar) {
    }

    public void setObjectAnimator(ObjectAnimator objectAnimator) {
        this.u = objectAnimator;
    }

    public void setUnitId(String str) {
        this.q = str;
    }

    public MBridgeClickCTAView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(ViewGroup viewGroup, CampaignEx campaignEx) {
        com.mbridge.msdk.video.dynview.b.a().a(new com.mbridge.msdk.video.dynview.wrapper.c().a(viewGroup, campaignEx), new a(viewGroup));
    }

    class a implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f5089a;

        a(ViewGroup viewGroup) {
            this.f5089a = viewGroup;
        }

        @Override // com.mbridge.msdk.video.dynview.listener.h
        public void a(com.mbridge.msdk.video.dynview.a aVar) {
            if (aVar != null) {
                this.f5089a.addView(aVar.b());
                MBridgeClickCTAView mBridgeClickCTAView = MBridgeClickCTAView.this;
                mBridgeClickCTAView.e = mBridgeClickCTAView.h();
                MBridgeClickCTAView mBridgeClickCTAView2 = MBridgeClickCTAView.this;
                mBridgeClickCTAView2.p = (TextView) mBridgeClickCTAView2.findViewById(mBridgeClickCTAView2.findID("mbridge_tv_desc"));
                MBridgeClickCTAView.this.d();
            }
        }

        @Override // com.mbridge.msdk.video.dynview.listener.h
        public void a(com.mbridge.msdk.video.dynview.error.a aVar) {
            p0.b(MBridgeBaseView.TAG, "errorMsg:" + aVar.b());
        }
    }
}
