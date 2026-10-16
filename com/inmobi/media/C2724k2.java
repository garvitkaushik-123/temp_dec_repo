package com.inmobi.media;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.core.content.ContextCompat;
import com.inmobi.ads.R;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.k2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2724k2 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final String f2619a;
    public final C2691i2 b;
    public final R6 c;
    public final String d;
    public final C2902v3 e;
    public final Context f;
    public final C2918w3 g;
    public boolean h;
    public final WeakReference i;
    public final WeakReference j;

    public C2724k2(String urlToLoad, C2691i2 c2691i2, Context context, InterfaceC2624e2 interfaceC2624e2, InterfaceC2961yb redirectionValidator, R6 r6, String api) {
        Intrinsics.checkNotNullParameter(urlToLoad, "urlToLoad");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(redirectionValidator, "redirectionValidator");
        Intrinsics.checkNotNullParameter(api, "api");
        this.f2619a = urlToLoad;
        this.b = c2691i2;
        this.c = r6;
        this.d = api;
        C2902v3 c2902v3 = new C2902v3();
        this.e = c2902v3;
        this.g = new C2918w3(interfaceC2624e2, r6);
        this.i = new WeakReference(interfaceC2624e2);
        this.j = new WeakReference(redirectionValidator);
        Intrinsics.checkNotNullParameter(this, "connectionCallback");
        c2902v3.c = this;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.f = applicationContext;
        Uc.a(context, this);
    }

    public final void a() {
        String a2;
        C2902v3 c2902v3 = this.e;
        Context context = this.f;
        if (c2902v3.f2729a != null || context == null || (a2 = AbstractC2934x3.a(context)) == null) {
            return;
        }
        C2870t3 c2870t3 = new C2870t3(c2902v3);
        c2902v3.b = c2870t3;
        CustomTabsClient.bindCustomTabsService(context, a2, c2870t3);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        C2902v3 c2902v3 = this.e;
        Context context = this.f;
        c2902v3.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        C2870t3 c2870t3 = c2902v3.b;
        if (c2870t3 != null) {
            context.unbindService(c2870t3);
            c2902v3.f2729a = null;
        }
        c2902v3.b = null;
        activity.getApplication().unregisterActivityLifecycleCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public final void a(Uri uri) {
        CustomTabsIntent.Builder builder;
        CustomTabsSession newSession;
        C2691i2 c2691i2 = this.b;
        if (c2691i2 != null) {
            try {
                builder = a(c2691i2);
            } catch (Error unused) {
                C2902v3 c2902v3 = this.e;
                CustomTabsSession customTabsSession = c2902v3.d;
                if (customTabsSession == null) {
                    CustomTabsClient customTabsClient = c2902v3.f2729a;
                    newSession = customTabsClient != null ? customTabsClient.newSession(new C2886u3(c2902v3)) : null;
                    c2902v3.d = newSession;
                    customTabsSession = newSession;
                }
                builder = new CustomTabsIntent.Builder(customTabsSession);
                builder.setUrlBarHidingEnabled(true);
            }
        } else {
            C2902v3 c2902v32 = this.e;
            CustomTabsSession customTabsSession2 = c2902v32.d;
            if (customTabsSession2 == null) {
                CustomTabsClient customTabsClient2 = c2902v32.f2729a;
                newSession = customTabsClient2 != null ? customTabsClient2.newSession(new C2886u3(c2902v32)) : null;
                c2902v32.d = newSession;
                customTabsSession2 = newSession;
            }
            builder = new CustomTabsIntent.Builder(customTabsSession2);
            builder.setUrlBarHidingEnabled(true);
        }
        Context context = this.f;
        CustomTabsIntent build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        AbstractC2853s3.a(context, build, uri, (InterfaceC2624e2) this.i.get(), this.c, (InterfaceC2961yb) this.j.get(), this.d);
    }

    public final CustomTabsIntent.Builder a(C2691i2 c2691i2) {
        Bitmap bitmap;
        C2902v3 c2902v3 = this.e;
        CustomTabsSession customTabsSession = c2902v3.d;
        if (customTabsSession == null) {
            CustomTabsClient customTabsClient = c2902v3.f2729a;
            customTabsSession = customTabsClient != null ? customTabsClient.newSession(new C2886u3(c2902v3)) : null;
            c2902v3.d = customTabsSession;
        }
        CustomTabsIntent.Builder closeButtonPosition = new CustomTabsIntent.Builder(customTabsSession).setCloseButtonPosition(2);
        Intrinsics.checkNotNullExpressionValue(closeButtonPosition, "setCloseButtonPosition(...)");
        try {
            closeButtonPosition.setShareState(2);
            closeButtonPosition.setShowTitle(false);
            closeButtonPosition.setDownloadButtonEnabled(false);
            closeButtonPosition.setBookmarksButtonEnabled(false);
        } catch (Error unused) {
        }
        if (c2691i2.b) {
            Context context = this.f;
            int i = R.drawable.im_close_transparent;
            Intrinsics.checkNotNullParameter(context, "<this>");
            Drawable drawable = ContextCompat.getDrawable(context, i);
            if (drawable instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
                Intrinsics.checkNotNullExpressionValue(bitmap, "getBitmap(...)");
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(drawable != null ? drawable.getIntrinsicWidth() : 24, drawable != null ? drawable.getIntrinsicHeight() : 24, Bitmap.Config.ARGB_8888);
                Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(width, height, config)");
                Canvas canvas = new Canvas(createBitmap);
                if (drawable != null) {
                    drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                }
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                bitmap = createBitmap;
            }
            closeButtonPosition.setCloseButtonIcon(bitmap);
        }
        V3 h = U3.h();
        EnumC2813pa a2 = AbstractC2829qa.a(U3.g());
        if (a2 != EnumC2813pa.b && a2 != EnumC2813pa.d) {
            closeButtonPosition.setInitialActivityHeightPx((int) (((int) (h.b * c2691i2.f2593a)) * h.c), 2);
        } else {
            int i2 = (int) (h.f2459a * c2691i2.f2593a);
            closeButtonPosition.setInitialActivityWidthPx((int) (i2 * h.c));
            closeButtonPosition.setActivitySideSheetBreakpointDp(i2);
        }
        closeButtonPosition.setUrlBarHidingEnabled(true);
        return closeButtonPosition;
    }
}
