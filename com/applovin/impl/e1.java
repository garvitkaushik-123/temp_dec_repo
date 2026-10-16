package com.applovin.impl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.sdk.R;
import com.ironsource.C3040d4;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class e1 {

    /* renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f441a;
    private CustomTabsClient b;

    class a extends CustomTabsServiceConnection {
        a() {
        }

        @Override // androidx.browser.customtabs.CustomTabsServiceConnection
        public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            e1.this.f441a.O();
            if (com.applovin.impl.sdk.o.a()) {
                e1.this.f441a.O().a("CustomTabsManager", "Connection successful: " + componentName);
            }
            e1.this.b = customTabsClient;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            e1.this.f441a.O();
            if (com.applovin.impl.sdk.o.a()) {
                e1.this.f441a.O().a("CustomTabsManager", "Service disconnected: " + componentName);
            }
            e1.this.b = null;
        }
    }

    private class b extends CustomTabsCallback {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference f443a;

        public b(com.applovin.impl.adview.a aVar) {
            this.f443a = new WeakReference(aVar);
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void onNavigationEvent(int i, Bundle bundle) {
            com.applovin.impl.adview.a aVar = (com.applovin.impl.adview.a) this.f443a.get();
            if (aVar == null) {
                e1.this.f441a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    e1.this.f441a.O().b("CustomTabsManager", "Unable to track navigation event (" + i + "). Controller is null.");
                }
                return;
            }
            com.applovin.impl.sdk.ad.b g = aVar.g();
            if (g == null) {
                e1.this.f441a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    e1.this.f441a.O().b("CustomTabsManager", "Unable to track navigation event (" + i + "). No ad specified.");
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    if (g.Y0()) {
                        e1.this.f441a.k().trackCustomTabsNavigationStarted(g);
                        break;
                    }
                    break;
                case 2:
                    if (g.Y0()) {
                        e1.this.f441a.k().trackCustomTabsNavigationFinished(g);
                        break;
                    }
                    break;
                case 3:
                    if (g.Y0()) {
                        e1.this.f441a.k().trackCustomTabsNavigationFailed(g);
                        break;
                    }
                    break;
                case 4:
                    if (g.Y0()) {
                        e1.this.f441a.k().trackCustomTabsNavigationAborted(g);
                        break;
                    }
                    break;
                case 5:
                    if (g.Y0()) {
                        e1.this.f441a.k().trackCustomTabsTabShown(g);
                    }
                    AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.custom_tabs_shown"), null);
                    q2.c(aVar.e(), g, aVar.i());
                    break;
                case 6:
                    if (g.Y0()) {
                        e1.this.f441a.k().trackCustomTabsTabHidden(g);
                    }
                    AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.custom_tabs_hidden"), null);
                    q2.a(aVar.e(), g, aVar.i());
                    break;
                default:
                    e1.this.f441a.O();
                    if (com.applovin.impl.sdk.o.a()) {
                        e1.this.f441a.O().a("CustomTabsManager", "Unknown navigation event: " + i);
                        break;
                    }
                    break;
            }
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
            e1.this.f441a.O();
            if (com.applovin.impl.sdk.o.a()) {
                e1.this.f441a.O().a("CustomTabsManager", "Validation " + (z ? "succeeded" : C3040d4.h.t) + " for session-URL relation(" + i + "), requestedOrigin(" + uri + ")");
            }
        }
    }

    public e1(com.applovin.impl.sdk.k kVar) {
        this.f441a = kVar;
    }

    public void b(final List list, final CustomTabsSession customTabsSession) {
        if (list.isEmpty()) {
            return;
        }
        if (customTabsSession != null) {
            a("warmup urls", new Runnable() { // from class: com.applovin.impl.e1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    e1.this.a(list, customTabsSession);
                }
            });
            return;
        }
        this.f441a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f441a.O().a("CustomTabsManager", "Custom Tabs session is null, cannot warmup urls");
        }
    }

    public void a() {
        if (((Boolean) this.f441a.a(v4.Q6)).booleanValue() && this.b == null) {
            String packageName = CustomTabsClient.getPackageName(com.applovin.impl.sdk.k.o(), this.f441a.c(v4.R6), true);
            String packageName2 = CustomTabsClient.getPackageName(com.applovin.impl.sdk.k.o(), null);
            LinkedList linkedList = new LinkedList();
            if (((Boolean) this.f441a.a(v4.S6)).booleanValue()) {
                CollectionUtils.addUniqueObjectIfExists(packageName2, linkedList);
                CollectionUtils.addUniqueObjectIfExists(packageName, linkedList);
            } else {
                CollectionUtils.addUniqueObjectIfExists(packageName, linkedList);
                CollectionUtils.addUniqueObjectIfExists(packageName2, linkedList);
            }
            if (linkedList.isEmpty()) {
                this.f441a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f441a.O().b("CustomTabsManager", "Unable to find a supported Custom Tabs package name");
                    return;
                }
                return;
            }
            a(linkedList);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
    
        if (com.applovin.impl.sdk.o.a() != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x007a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(LinkedList linkedList) {
        boolean z = false;
        try {
            z = CustomTabsClient.bindCustomTabsService(com.applovin.impl.sdk.k.o(), (String) linkedList.poll(), new a());
            if (!z) {
                this.f441a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f441a.O().b("CustomTabsManager", "Custom Tabs service not available");
                }
            }
            if (z || linkedList.isEmpty()) {
            } else {
                this.f441a.O();
            }
        } catch (Throwable th) {
            try {
                this.f441a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f441a.O().a("CustomTabsManager", "Failed to bind to service", th);
                }
            } finally {
                if (!z && !linkedList.isEmpty()) {
                    this.f441a.O();
                    if (com.applovin.impl.sdk.o.a()) {
                        this.f441a.O().a("CustomTabsManager", "Retrying with next package name...");
                    }
                    a(linkedList);
                }
            }
        }
    }

    public CustomTabsSession a(com.applovin.impl.adview.a aVar) {
        if (this.b == null) {
            this.f441a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f441a.O().a("CustomTabsManager", "Custom Tabs service is not connected, cannot start session");
            }
            return null;
        }
        this.f441a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f441a.O().a("CustomTabsManager", "Starting Custom Tabs session");
        }
        try {
            CustomTabsSession newSession = this.b.newSession(new b(aVar));
            a(newSession, aVar.g());
            return newSession;
        } catch (Exception e) {
            this.f441a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f441a.O().a("CustomTabsManager", "Failed to create Custom Tabs session", e);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list, CustomTabsSession customTabsSession) {
        this.f441a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f441a.O().a("CustomTabsManager", "Warming up URLs: " + list);
        }
        String str = (String) list.remove(0);
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            Bundle bundle = new Bundle();
            bundle.putParcelable(CustomTabsService.KEY_URL, Uri.parse(str2));
            arrayList.add(bundle);
        }
        boolean mayLaunchUrl = customTabsSession.mayLaunchUrl(Uri.parse(str), null, arrayList);
        this.f441a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f441a.O().a("CustomTabsManager", "Warmup for URLs ".concat(mayLaunchUrl ? "succeeded" : C3040d4.h.t));
        }
    }

    public void a(final String str, final com.applovin.impl.adview.a aVar, final Activity activity) {
        if (a("launch url", new Runnable() { // from class: com.applovin.impl.e1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                e1.this.a(aVar, activity, str);
            }
        })) {
            this.f441a.n0().pauseForClick();
        } else {
            AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.custom_tabs_failure"), CollectionUtils.map("url", str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.adview.a aVar, Activity activity, String str) {
        a(aVar, activity).launchUrl(activity, Uri.parse(str));
    }

    private void a(final CustomTabsSession customTabsSession, final com.applovin.impl.sdk.ad.b bVar) {
        if (bVar == null || !bVar.F0()) {
            return;
        }
        a("client warmup", new Runnable() { // from class: com.applovin.impl.e1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                e1.this.a(bVar, customTabsSession);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.sdk.ad.b bVar, CustomTabsSession customTabsSession) {
        this.b.warmup(0L);
        f1 A = bVar.A();
        if (A == null) {
            return;
        }
        Integer e = A.e();
        String b2 = A.b();
        if (e == null || TextUtils.isEmpty(b2)) {
            return;
        }
        if (customTabsSession == null) {
            this.f441a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f441a.O().b("CustomTabsManager", "Cannot validate session-URL relation because the session is null");
                return;
            }
            return;
        }
        this.f441a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f441a.O().a("CustomTabsManager", "Validating session-URL relation: " + e + " with digital asset link: " + b2);
        }
        customTabsSession.validateRelationship(e.intValue(), Uri.parse(b2), null);
    }

    private CustomTabsIntent a(com.applovin.impl.adview.a aVar, Activity activity) {
        this.f441a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f441a.O().a("CustomTabsManager", "Creating Custom Tabs intent");
        }
        com.applovin.impl.sdk.ad.b g = aVar.g();
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(aVar.h());
        f1 A = g != null ? g.A() : null;
        if (((Boolean) this.f441a.a(v4.T6)).booleanValue()) {
            builder.setStartAnimations(activity, R.anim.applovin_slide_up_animation, R.anim.applovin_slide_down_animation);
            builder.setExitAnimations(activity, R.anim.applovin_slide_up_animation, R.anim.applovin_slide_down_animation);
        }
        if (A != null) {
            Integer h = A.h();
            if (h != null) {
                builder.setDefaultColorSchemeParams(new CustomTabColorSchemeParams.Builder().setToolbarColor(h.intValue()).build());
            }
            Integer a2 = A.a();
            if (a2 != null) {
                builder.setColorSchemeParams(2, new CustomTabColorSchemeParams.Builder().setToolbarColor(a2.intValue()).build());
            }
            Boolean i = A.i();
            if (i != null) {
                builder.setUrlBarHidingEnabled(i.booleanValue());
            }
            Boolean g2 = A.g();
            if (g2 != null) {
                builder.setShowTitle(g2.booleanValue());
            }
            Boolean c = A.c();
            if (c != null) {
                builder.setInstantAppsEnabled(c.booleanValue());
            }
            Integer f = A.f();
            if (f != null) {
                builder.setShareState(f.intValue());
            }
        }
        CustomTabsIntent build = builder.build();
        if (A != null) {
            String d = A.d();
            if (d != null) {
                build.intent.putExtra("android.intent.extra.REFERRER", Uri.parse(d));
            }
            Bundle v = g.v();
            if (!v.isEmpty()) {
                build.intent.putExtra("com.android.browser.headers", v);
            }
        }
        return build;
    }

    private boolean a(String str, Runnable runnable) {
        try {
            this.f441a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f441a.O().a("CustomTabsManager", "Running operation: " + str);
            }
            runnable.run();
            this.f441a.O();
            if (!com.applovin.impl.sdk.o.a()) {
                return true;
            }
            this.f441a.O().a("CustomTabsManager", "Finished operation: " + str);
            return true;
        } catch (Throwable th) {
            this.f441a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f441a.O().a("CustomTabsManager", "Failed to run operation: " + str, th);
            }
            this.f441a.E().a("CustomTabsManager", str, th);
            return false;
        }
    }
}
