package com.mbridge.msdk.foundation.feedback;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.feedback.bean.a;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.dialog.MBFeedBackDialog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* compiled from: FeedbackManager.java */
/* loaded from: classes6.dex */
public class b {
    public static int d = -2;
    public static int e = -2;
    public static volatile boolean f = false;

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout.LayoutParams f4252a;
    private final ConcurrentHashMap<String, com.mbridge.msdk.foundation.feedback.bean.a> b;
    private g c;

    /* compiled from: FeedbackManager.java */
    /* renamed from: com.mbridge.msdk.foundation.feedback.b$b, reason: collision with other inner class name */
    static class C0333b {

        /* renamed from: a, reason: collision with root package name */
        private static final b f4253a = new b();
    }

    public static b b() {
        return C0333b.f4253a;
    }

    private com.mbridge.msdk.foundation.feedback.bean.a c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = c.m().b();
        }
        if (this.b.containsKey(str)) {
            return this.b.get(str);
        }
        return null;
    }

    public void a(String str, Context context, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, com.mbridge.msdk.foundation.feedback.a aVar) {
        if (a()) {
            com.mbridge.msdk.foundation.feedback.bean.a b = b(str);
            if (aVar != null) {
                b.a(new a.g(str, aVar));
            }
            FeedBackButton i = b.i();
            if (i != null) {
                if (layoutParams == null) {
                    int a2 = u0.a(c.m().d(), 10.0f);
                    this.f4252a.setMargins(a2, a2, a2, a2);
                    layoutParams = this.f4252a;
                }
                ViewGroup viewGroup2 = (ViewGroup) i.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(i);
                }
                Activity a3 = a(context);
                if (a3 != null && viewGroup == null) {
                    viewGroup = (ViewGroup) a3.findViewById(R.id.content);
                }
                if (viewGroup != null) {
                    viewGroup.removeView(i);
                    viewGroup.addView(i, layoutParams);
                }
            }
        }
    }

    public void d(String str) {
        try {
            com.mbridge.msdk.foundation.feedback.bean.a c = c(str);
            if (c != null) {
                c.f();
            }
            this.b.remove(str);
            f = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private b() {
        this.f4252a = new RelativeLayout.LayoutParams(e, d);
        this.b = new ConcurrentHashMap<>();
    }

    public com.mbridge.msdk.foundation.feedback.bean.a b(String str) {
        com.mbridge.msdk.foundation.feedback.bean.a aVar;
        if (TextUtils.isEmpty(str)) {
            str = c.m().b();
        }
        if (this.b.containsKey(str)) {
            aVar = this.b.get(str);
        } else {
            aVar = new com.mbridge.msdk.foundation.feedback.bean.a(str);
            this.b.put(str, aVar);
        }
        if (aVar != null) {
            return aVar;
        }
        com.mbridge.msdk.foundation.feedback.bean.a aVar2 = new com.mbridge.msdk.foundation.feedback.bean.a(str);
        this.b.put(str, aVar2);
        return aVar2;
    }

    public void b(String str, int i) {
        b(str).c(i);
    }

    public boolean a() {
        g d2 = h.b().d(c.m().b());
        this.c = d2;
        if (d2 != null) {
            return false;
        }
        this.c = h.b().a();
        return false;
    }

    public Activity a(Context context) {
        Activity activity;
        Activity activity2;
        Context f2 = c.m().f();
        Activity activity3 = null;
        try {
            activity = f2 instanceof Activity ? (Activity) f2 : null;
        } catch (Exception e2) {
            e = e2;
        }
        try {
            if ((context instanceof Activity) && !((Activity) context).isDestroyed()) {
                activity = (Activity) context;
            }
            WeakReference<Activity> a2 = c.m().a();
            if (a2 != null && (activity2 = a2.get()) != null && !activity2.isFinishing() && !activity2.isDestroyed()) {
                activity = activity2;
            }
            if (activity != null && !activity.isFinishing()) {
                if (!activity.isDestroyed()) {
                    return activity;
                }
            }
            return null;
        } catch (Exception e3) {
            e = e3;
            activity3 = activity;
            e.printStackTrace();
            return activity3;
        }
    }

    public void a(String str, int i, ViewGroup viewGroup) {
        com.mbridge.msdk.foundation.feedback.bean.a b = b(str);
        if (b.i() != null) {
            b.d(i);
            if (i == 0) {
                a(str, c.m().d(), viewGroup, (ViewGroup.LayoutParams) null, (com.mbridge.msdk.foundation.feedback.a) null);
            }
        }
    }

    public void a(String str, int i, int i2, int i3, float f2, float f3, float f4, String str2, String str3, float f5, JSONArray jSONArray) {
        com.mbridge.msdk.foundation.feedback.bean.a b = b(str);
        Context d2 = c.m().d();
        b.a(u0.a(d2, f2), u0.a(d2, f3), u0.a(d2, i), u0.a(d2, i2), u0.a(d2, i3), f4, str2, str3, f5, jSONArray);
    }

    public void a(String str, int i, com.mbridge.msdk.foundation.feedback.a aVar) {
        com.mbridge.msdk.foundation.feedback.bean.a b = b(str);
        b.a(new a.g(str, aVar));
        if (i == 1) {
            b.g();
        } else {
            b.p();
        }
    }

    public FeedBackButton a(String str) {
        return b(str).i();
    }

    public void a(String str, int i, int i2, String str2, String str3) {
        com.mbridge.msdk.foundation.feedback.bean.a c = c(str + "_1");
        if (c == null) {
            c = c(str + "_2");
            if (c == null && (c = c(str + "_3")) == null && (c = c(str + "_4")) == null) {
                c = b(str);
            } else {
                c.c(0);
            }
        }
        if (c != null) {
            CampaignEx h = c.h();
            j.a(h, h != null ? h.getCampaignUnitId() : "", c.k(), c.j(), !TextUtils.isEmpty(str2) ? str2 : "", i, h != null ? h.getAdType() : 0, i2, str3);
        }
    }

    public void a(String str, CampaignEx campaignEx) {
        b(str).a(campaignEx);
    }

    public void a(String str, String str2) {
        b(str).b(str2);
    }

    public void a(String str, FeedBackButton feedBackButton) {
        b(str).a(feedBackButton);
    }

    public void a(String str, com.mbridge.msdk.foundation.feedback.a aVar) {
        com.mbridge.msdk.foundation.feedback.bean.a b = b(str);
        if (aVar != null) {
            b.a(new a.g(str, aVar));
        }
    }

    public void a(String str, int i) {
        b(str).b(i);
    }

    public boolean a(String str, Context context, MBFeedBackDialog mBFeedBackDialog) {
        if (mBFeedBackDialog == null) {
            p0.c("", "mbAlertDialog  is null");
            return false;
        }
        return a(context, mBFeedBackDialog);
    }

    private boolean a(Context context, MBFeedBackDialog mBFeedBackDialog) {
        Activity a2 = a(context);
        if (a2 == null || mBFeedBackDialog == null || a2.isDestroyed()) {
            return false;
        }
        try {
            if (!mBFeedBackDialog.isShowing() && !a2.isFinishing()) {
                mBFeedBackDialog.show();
                return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }
}
