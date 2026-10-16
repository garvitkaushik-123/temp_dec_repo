package com.applovin.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.applovin.impl.privacy.cmp.CmpServiceImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.t0;
import com.applovin.impl.u0;
import com.applovin.impl.w0;
import com.applovin.sdk.AppLovinCmpError;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.applovin.sdk.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class y0 {

    /* renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f788a;
    private final int b;
    private List c;
    private String d;
    private u0 e;
    private t0.c f;
    private u0 g;
    private Dialog h;
    private t0.b i = new t0.b();
    private final com.applovin.impl.b j = new a();

    class a extends com.applovin.impl.b {
        a() {
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            super.onActivityResumed(activity);
            if ((activity instanceof AppLovinWebViewActivity) || y0.this.g == null) {
                return;
            }
            if (y0.this.h != null) {
                y0 y0Var = y0.this;
                if (!com.applovin.impl.d.d(y0Var.a(y0Var.h))) {
                    y0.this.h.dismiss();
                }
                y0.this.h = null;
            }
            u0 u0Var = y0.this.g;
            y0.this.g = null;
            y0 y0Var2 = y0.this;
            y0Var2.a(y0Var2.e, u0Var, activity);
        }
    }

    class b implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ w0 f790a;
        final /* synthetic */ u0 b;
        final /* synthetic */ Activity c;

        b(w0 w0Var, u0 u0Var, Activity activity) {
            this.f790a = w0Var;
            this.b = u0Var;
            this.c = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            y0.this.g = null;
            y0.this.h = null;
            u0 a2 = y0.this.a(this.f790a.a());
            if (a2 == null) {
                y0.this.a("Destination state for TOS/PP alert is null");
                return;
            }
            y0.this.a(this.b, a2, this.c);
            if (a2.c() != u0.b.ALERT) {
                dialogInterface.dismiss();
            }
        }
    }

    class c extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Uri f791a;
        final /* synthetic */ Activity b;

        c(Uri uri, Activity activity) {
            this.f791a = uri;
            this.b = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            k7.a(this.f791a, this.b, y0.this.f788a);
        }
    }

    class d extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Uri f792a;
        final /* synthetic */ Activity b;

        d(Uri uri, Activity activity) {
            this.f792a = uri;
            this.b = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            k7.a(this.f792a, this.b, y0.this.f788a);
        }
    }

    class e implements CmpServiceImpl.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ u0 f793a;
        final /* synthetic */ Activity b;

        e(u0 u0Var, Activity activity) {
            this.f793a = u0Var;
            this.b = activity;
        }

        @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.e
        public void a(AppLovinCmpError appLovinCmpError) {
            y0.this.i.a(appLovinCmpError);
            y0.this.a(this.f793a, this.b, Boolean.valueOf(appLovinCmpError == null));
        }
    }

    class f implements CmpServiceImpl.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ u0 f794a;
        final /* synthetic */ Activity b;

        f(u0 u0Var, Activity activity) {
            this.f794a = u0Var;
            this.b = activity;
        }

        @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.e
        public void a(AppLovinCmpError appLovinCmpError) {
            y0.this.i.a(appLovinCmpError);
            y0.this.a(this.f794a, this.b, Boolean.valueOf(appLovinCmpError == null));
        }
    }

    class g implements CmpServiceImpl.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ u0 f795a;
        final /* synthetic */ Activity b;

        g(u0 u0Var, Activity activity) {
            this.f795a = u0Var;
            this.b = activity;
        }

        @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.f
        public void a(AppLovinCmpError appLovinCmpError) {
            if (appLovinCmpError != null) {
                y0.this.i.a(appLovinCmpError);
            } else {
                y0.this.i.c();
            }
            y0.this.b(this.f795a, this.b);
        }
    }

    class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ u0 f796a;

        h(u0 u0Var) {
            this.f796a = u0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            y0 y0Var = y0.this;
            y0Var.a(y0Var.e, this.f796a, y0.this.f788a.v0());
        }
    }

    public y0(com.applovin.impl.sdk.k kVar) {
        this.f788a = kVar;
        this.b = ((Integer) kVar.a(v4.N6)).intValue();
    }

    private void c(final u0 u0Var, final Activity activity) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.y0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                y0.this.a(u0Var, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(u0 u0Var, Activity activity) {
        a(u0Var, activity, (Boolean) null);
    }

    private void b() {
        this.c = null;
        this.e = null;
        this.f788a.e().b(this.j);
        t0.c cVar = this.f;
        if (cVar != null) {
            cVar.a(this.i);
            this.f = null;
        }
        this.i = new t0.b();
    }

    public void a(Activity activity, t0.c cVar) {
        a(u0.a.IS_AL_GDPR.b(), activity, cVar);
    }

    public void a(int i, Activity activity, t0.c cVar) {
        if (this.c != null) {
            this.f788a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f788a.O().a("ConsentFlowStateMachine", "Unable to start states: " + this.c);
            }
            this.f788a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f788a.O().a("ConsentFlowStateMachine", "Consent flow already in progress for states: " + this.c);
            }
            cVar.a(new t0.b(new s0(s0.d, "Consent flow is already in progress.")));
            return;
        }
        List a2 = z0.a(this.f788a);
        this.c = a2;
        this.d = String.valueOf(a2);
        this.f = cVar;
        u0 a3 = a(i);
        this.f788a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f788a.O().a("ConsentFlowStateMachine", "Starting consent flow with states: " + this.c + "\nInitial state: " + a3);
        }
        com.applovin.impl.sdk.k.a(activity).a(this.j);
        a((u0) null, a3, activity);
    }

    public boolean a() {
        return this.c != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(u0 u0Var, Activity activity, Boolean bool) {
        a(u0Var, a(u0Var.a(bool)), activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(u0 u0Var, u0 u0Var2, Activity activity) {
        this.e = u0Var;
        c(u0Var2, activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(u0 u0Var, final Activity activity) {
        SpannableString spannableString;
        if (u0Var == null) {
            a("Consent flow state is null");
            return;
        }
        this.f788a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f788a.O().a("ConsentFlowStateMachine", "Transitioning to state: " + u0Var);
        }
        if (u0Var.c() == u0.b.ALERT) {
            if (com.applovin.impl.d.d(activity)) {
                a(u0Var);
                return;
            }
            this.f788a.G().trackEvent("cf_start");
            v0 v0Var = (v0) u0Var;
            this.g = v0Var;
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setCancelable(false);
            for (w0 w0Var : v0Var.d()) {
                b bVar = new b(w0Var, u0Var, activity);
                if (w0Var.c() == w0.a.POSITIVE) {
                    builder.setPositiveButton(w0Var.d(), bVar);
                } else if (w0Var.c() == w0.a.NEGATIVE) {
                    builder.setNegativeButton(w0Var.d(), bVar);
                } else {
                    builder.setNeutralButton(w0Var.d(), bVar);
                }
            }
            String f2 = v0Var.f();
            if (StringUtils.isValidString(f2)) {
                spannableString = new SpannableString(f2);
                String a2 = com.applovin.impl.sdk.k.a(R.string.applovin_terms_of_service_text);
                String a3 = com.applovin.impl.sdk.k.a(R.string.applovin_privacy_policy_text);
                if (StringUtils.containsAtLeastOneSubstring(f2, Arrays.asList(a2, a3))) {
                    Uri h2 = this.f788a.y().h();
                    if (h2 != null) {
                        StringUtils.addLinks(spannableString, Pattern.compile(a2), new c(h2, activity), true);
                    }
                    StringUtils.addLinks(spannableString, Pattern.compile(a3), new d(this.f788a.y().f(), activity), true);
                }
            } else {
                spannableString = null;
            }
            final AlertDialog create = builder.setTitle(spannableString).setMessage(v0Var.e()).create();
            create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.applovin.impl.y0$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    y0.this.a(create, activity, dialogInterface);
                }
            });
            this.h = create;
            create.show();
            this.i.d();
            return;
        }
        if (u0Var.c() == u0.b.POST_ALERT) {
            if (this.f788a.y().k() && this.f788a.y().m()) {
                if (com.applovin.impl.d.d(activity)) {
                    a(u0Var);
                    return;
                } else {
                    this.f788a.t().loadCmp(activity, new e(u0Var, activity));
                    return;
                }
            }
            a(u0Var, activity, Boolean.FALSE);
            return;
        }
        if (u0Var.c() == u0.b.EVENT) {
            x0 x0Var = (x0) u0Var;
            String e2 = x0Var.e();
            Map<String, ?> d2 = x0Var.d();
            if (d2 == null) {
                d2 = new HashMap<>(1);
            }
            d2.put("flow_type", "unified");
            this.f788a.G().trackEvent(e2, d2);
            b(x0Var, activity);
            return;
        }
        if (u0Var.c() == u0.b.CMP_LOAD) {
            if (com.applovin.impl.d.d(activity)) {
                a(u0Var);
                return;
            } else if (this.f788a.y().m()) {
                this.f788a.t().preloadCmp(activity);
                a(u0Var, activity, Boolean.FALSE);
                return;
            } else {
                this.f788a.t().loadCmp(activity, new f(u0Var, activity));
                return;
            }
        }
        if (u0Var.c() == u0.b.CMP_SHOW) {
            if (com.applovin.impl.d.d(activity)) {
                a(u0Var);
                return;
            }
            if (!this.f788a.y().m()) {
                this.f788a.G().trackEvent("cf_start");
            }
            this.f788a.t().showCmp(activity, new g(u0Var, activity));
            return;
        }
        if (u0Var.c() == u0.b.DECISION) {
            u0.a a4 = u0Var.a();
            if (a4 == u0.a.IS_AL_GDPR) {
                a(u0Var, activity, Boolean.valueOf(this.f788a.y().k()));
                return;
            }
            if (a4 == u0.a.IS_ELIGIBLE_FOR_TERMS_AND_PRIVACY_POLICY_ALERT) {
                a(u0Var, activity, Boolean.valueOf(!this.f788a.A0() || ((Boolean) this.f788a.a(x4.s, Boolean.FALSE)).booleanValue()));
                return;
            } else if (a4 == u0.a.HAS_TERMS_OF_SERVICE_URI) {
                a(u0Var, activity, Boolean.valueOf(this.f788a.y().h() != null));
                return;
            } else {
                a("Invalid consent flow decision type: " + a4);
                return;
            }
        }
        if (u0Var.c() == u0.b.REINIT) {
            b();
        } else {
            a("Invalid consent flow destination state: " + u0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AlertDialog alertDialog, Activity activity, DialogInterface dialogInterface) {
        TextView textView = (TextView) alertDialog.findViewById(alertDialog.getContext().getResources().getIdentifier("android:id/alertTitle", null, null));
        textView.setLinkTextColor(textView.getCurrentTextColor());
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setMaxLines(this.b);
        textView.setMinHeight(AppLovinSdkUtils.dpToPx(activity, 48));
    }

    private void a(u0 u0Var) {
        AppLovinSdkUtils.runOnUiThreadDelayed(new h(u0Var), TimeUnit.SECONDS.toMillis(1L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        k1.a(str, new Object[0]);
        this.f788a.E().a(c2.B0, str, CollectionUtils.hashMap("details", "Last started states: " + this.d + "\nLast successful state: " + this.e));
        t0.b bVar = this.i;
        if (bVar != null) {
            bVar.a(new s0(s0.e, str));
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public u0 a(int i) {
        List<u0> list = this.c;
        if (list == null) {
            return null;
        }
        for (u0 u0Var : list) {
            if (i == u0Var.b()) {
                return u0Var;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity a(Dialog dialog) {
        Context context = dialog.getContext();
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext = ((ContextWrapper) context).getBaseContext();
        if (baseContext instanceof Activity) {
            return (Activity) baseContext;
        }
        return null;
    }
}
