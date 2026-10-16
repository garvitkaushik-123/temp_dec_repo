package com.fyber.inneractive.sdk.activities;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.fyber.inneractive.sdk.config.global.features.q;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.flow.a0;
import com.fyber.inneractive.sdk.flow.v;
import com.fyber.inneractive.sdk.network.u;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.web.t0;
import com.fyber.inneractive.sdk.web.v0;
import io.bidmachine.protobuf.EventTypeExtended;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class InternalStoreWebpageActivity extends InneractiveBaseActivity {
    public static final String EXTRA_KEY_SPOT_ID = "spotId";
    public ViewGroup b;
    public v0 c;
    public com.fyber.inneractive.sdk.config.global.features.p d = com.fyber.inneractive.sdk.config.global.features.p.FullScreen;

    public static void startActivity(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) InternalStoreWebpageActivity.class);
        intent.putExtra("spotId", str);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        v0 v0Var = this.c;
        if (v0Var != null) {
            v0Var.C = false;
            t0 t0Var = v0Var.i;
            if (t0Var != null) {
                a0 a0Var = (a0) t0Var;
                IAlog.a("onInternalStoreWebpageDismissed callback called", new Object[0]);
                if (a0Var.c != null) {
                    IAlog.a("%sCalling external interface onAdWillCloseInternalBrowser", IAlog.a(a0Var));
                    a0Var.c.onAdWillCloseInternalBrowser(a0Var.f1175a);
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        v0 v0Var = this.c;
        if (v0Var != null) {
            if (v0Var.x) {
                return;
            }
            if (v0Var.w) {
                v0Var.d("navigateBack();");
                return;
            }
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (attributes.width == com.fyber.inneractive.sdk.util.o.e() || this.d != com.fyber.inneractive.sdk.config.global.features.p.Modal) {
            return;
        }
        attributes.gravity = 83;
        attributes.height = (int) (com.fyber.inneractive.sdk.util.o.d() * 0.8f);
        attributes.width = com.fyber.inneractive.sdk.util.o.e();
        getWindow().setAttributes(attributes);
    }

    @Override // com.fyber.inneractive.sdk.activities.InneractiveBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        InneractiveAdSpot spot;
        String stringExtra = getIntent().getStringExtra("spotId");
        if (TextUtils.isEmpty(stringExtra)) {
            IAlog.f("%sSpot id is empty", IAlog.a(this));
            spot = null;
        } else {
            spot = InneractiveAdSpotManager.get().getSpot(stringExtra);
        }
        if (spot == null || spot.getAdContent() == null) {
            super.onCreate(bundle);
            finish();
            return;
        }
        q qVar = (q) spot.getAdContent().c.a(q.class);
        com.fyber.inneractive.sdk.config.global.features.p c = qVar != null ? qVar.c() : com.fyber.inneractive.sdk.config.global.features.p.FullScreen;
        this.d = c;
        if (c == com.fyber.inneractive.sdk.config.global.features.p.Modal) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.gravity = 83;
            attributes.height = (int) (com.fyber.inneractive.sdk.util.o.d() * 0.8f);
            attributes.width = com.fyber.inneractive.sdk.util.o.e();
            attributes.dimAmount = 0.3f;
            getWindow().setAttributes(attributes);
            getWindow().getDecorView().setBackgroundColor(0);
            getWindow().addFlags(EventTypeExtended.EVENT_TYPE_EXTENDED_IMPRESSION_OPPORTUNITY_VALUE);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        } else {
            setTheme(R.style.Theme.NoTitleBar.Fullscreen);
        }
        super.onCreate(bundle);
        setContentView(com.fyber.inneractive.sdk.R.layout.ia_layout_activity_internal_store_webpage);
        this.b = (ViewGroup) findViewById(com.fyber.inneractive.sdk.R.id.internal_store_content);
        v0 b = spot.getAdContent().b();
        this.c = b;
        if (b != null) {
            b.q = new WeakReference(this);
            v0 v0Var = this.c;
            v vVar = v0Var.h;
            if (vVar != null) {
                vVar.a(u.IGNITE_FLOW_STORE_PAGE_OPENED, v0Var.B ? com.fyber.inneractive.sdk.ignite.m.TRUE_SINGLE_TAP : com.fyber.inneractive.sdk.ignite.m.SINGLE_TAP);
            }
            this.c.t.set(0);
        }
    }

    @Override // com.fyber.inneractive.sdk.activities.InneractiveBaseActivity, android.app.Activity
    public void onDestroy() {
        InneractiveAdSpot spot;
        v0 v0Var;
        super.onDestroy();
        String stringExtra = getIntent().getStringExtra("spotId");
        if (TextUtils.isEmpty(stringExtra)) {
            IAlog.f("%sSpot id is empty", IAlog.a(this));
            spot = null;
        } else {
            spot = InneractiveAdSpotManager.get().getSpot(stringExtra);
        }
        if (spot == null || spot.getAdContent() == null || spot.getAdContent().d() || (v0Var = this.c) == null) {
            return;
        }
        v0Var.y = true;
        v0Var.D = false;
        v0Var.b.h.remove(v0Var);
        v0Var.i = null;
        IAlog.a("destroy internalStoreWebpageController", new Object[0]);
        this.c = null;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        v0 v0Var = this.c;
        if (v0Var != null) {
            this.b.addView(v0Var.f1826a, new ViewGroup.LayoutParams(-1, -1));
        }
    }
}
