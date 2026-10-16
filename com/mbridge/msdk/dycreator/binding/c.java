package com.mbridge.msdk.dycreator.binding;

import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.mbridge.msdk.dycreator.binding.base.BaseStrategy;
import com.mbridge.msdk.dycreator.binding.strategy.d;
import com.mbridge.msdk.dycreator.binding.strategy.e;
import com.mbridge.msdk.dycreator.binding.strategy.f;
import com.mbridge.msdk.dycreator.binding.strategy.g;
import com.vungle.ads.internal.presenter.NativeAdPresenter;

/* compiled from: ViewDataFactory.java */
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f4150a;

    private c() {
    }

    public static c a() {
        if (f4150a == null) {
            synchronized (c.class) {
                if (f4150a == null) {
                    f4150a = new c();
                }
            }
        }
        return f4150a;
    }

    public <T extends BaseStrategy> T a(String str) {
        T t = null;
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("close")) {
                t = new com.mbridge.msdk.dycreator.binding.strategy.c();
            } else if (str.equals(NativeAdPresenter.DOWNLOAD)) {
                t = new com.mbridge.msdk.dycreator.binding.strategy.b();
            } else if (!str.equals(Constants.DEEPLINK) && str.equals("activity")) {
                t = new com.mbridge.msdk.dycreator.binding.strategy.a();
            }
            if (str.equals("feedback")) {
                t = new d();
            }
            if (str.equals("notice")) {
                t = new e();
            }
            if (str.equals("permissionInfo")) {
                t = new f();
            }
            if (str.equals("privateAddress")) {
                return new g();
            }
        }
        return t;
    }
}
