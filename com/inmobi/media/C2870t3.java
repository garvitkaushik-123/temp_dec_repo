package com.inmobi.media;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.t3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2870t3 extends CustomTabsServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2902v3 f2708a;

    public C2870t3(C2902v3 c2902v3) {
        this.f2708a = c2902v3;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f2708a.f2729a = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onCustomTabsServiceConnected(ComponentName name, CustomTabsClient client) {
        int i;
        R6 r6;
        InterfaceC2624e2 interfaceC2624e2;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(client, "client");
        C2902v3 c2902v3 = this.f2708a;
        c2902v3.f2729a = client;
        C2724k2 c2724k2 = c2902v3.c;
        if (c2724k2 == null) {
            return;
        }
        try {
            C2902v3 c2902v32 = c2724k2.e;
            CustomTabsSession customTabsSession = c2902v32.d;
            if (customTabsSession == null) {
                CustomTabsClient customTabsClient = c2902v32.f2729a;
                customTabsSession = customTabsClient != null ? customTabsClient.newSession(new C2886u3(c2902v32)) : null;
                c2902v32.d = customTabsSession;
            }
            if (customTabsSession != null) {
                Bundle bundle = Bundle.EMPTY;
                if (customTabsSession.isEngagementSignalsApiAvailable(bundle)) {
                    customTabsSession.setEngagementSignalsCallback(new C2708j2(c2724k2), bundle);
                }
            }
        } catch (RemoteException | Error unused) {
        }
        try {
            try {
                Uri parse = Uri.parse(c2724k2.f2619a);
                Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                c2724k2.a(parse);
            } catch (Error unused2) {
                Context context = c2724k2.f;
                String str = c2724k2.f2619a;
                Object obj = c2724k2.j.get();
                Intrinsics.checkNotNull(obj);
                i = AbstractC2968z2.a(context, str, (InterfaceC2961yb) obj, c2724k2.d);
                r6 = c2724k2.c;
                if (r6 != null) {
                    r6.g = "EX_NATIVE";
                }
                if (i != 0 || i == 1) {
                    interfaceC2624e2 = (InterfaceC2624e2) c2724k2.i.get();
                    if (interfaceC2624e2 == null) {
                        interfaceC2624e2.a(F6.f, c2724k2.c, (Integer) null);
                        return;
                    }
                    return;
                }
                InterfaceC2624e2 interfaceC2624e22 = (InterfaceC2624e2) c2724k2.i.get();
                if (interfaceC2624e22 != null) {
                    interfaceC2624e22.a(F6.g, c2724k2.c, Integer.valueOf(i));
                }
            }
        } catch (Exception unused3) {
            i = 9;
            r6 = c2724k2.c;
            if (r6 != null) {
            }
            if (i != 0) {
            }
            interfaceC2624e2 = (InterfaceC2624e2) c2724k2.i.get();
            if (interfaceC2624e2 == null) {
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onNullBinding(ComponentName componentName) {
        C2902v3 c2902v3 = this.f2708a;
        c2902v3.f2729a = null;
        C2724k2 c2724k2 = c2902v3.c;
        if (c2724k2 != null) {
            R6 r6 = c2724k2.c;
            if (r6 != null) {
                r6.g = "IN_NATIVE";
            }
            InterfaceC2624e2 interfaceC2624e2 = (InterfaceC2624e2) c2724k2.i.get();
            if (interfaceC2624e2 != null) {
                interfaceC2624e2.a(F6.g, c2724k2.c, Integer.valueOf(ConnectionsStatusCodes.STATUS_OUT_OF_ORDER_API_CALL));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f2708a.f2729a = null;
    }
}
