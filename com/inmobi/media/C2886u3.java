package com.inmobi.media;

import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.u3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2886u3 extends CustomTabsCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2902v3 f2718a;

    public C2886u3(C2902v3 c2902v3) {
        this.f2718a = c2902v3;
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final void onActivityLayout(int i, int i2, int i3, int i4, int i5, Bundle extras) {
        InterfaceC2624e2 interfaceC2624e2;
        Intrinsics.checkNotNullParameter(extras, "extras");
        super.onActivityLayout(i, i2, i3, i4, i5, extras);
        Intrinsics.checkNotNullExpressionValue("v3", "access$getLOG_TAG$cp(...)");
        C2724k2 c2724k2 = this.f2718a.c;
        if (c2724k2 == null || (interfaceC2624e2 = (InterfaceC2624e2) c2724k2.i.get()) == null) {
            return;
        }
        interfaceC2624e2.a(i, i2, i3, i4, i5);
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final void onNavigationEvent(int i, Bundle bundle) {
        super.onNavigationEvent(i, bundle);
        Intrinsics.checkNotNullExpressionValue("v3", "access$getLOG_TAG$cp(...)");
        C2724k2 c2724k2 = this.f2718a.c;
        if (c2724k2 != null) {
            C2918w3 c2918w3 = c2724k2.g;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 6 && c2918w3.c == null) {
                            if (c2918w3.d == 4) {
                                c2918w3.c = Boolean.TRUE;
                            } else {
                                c2918w3.c = Boolean.FALSE;
                            }
                            if (Intrinsics.areEqual(c2918w3.c, Boolean.TRUE)) {
                                InterfaceC2624e2 interfaceC2624e2 = (InterfaceC2624e2) c2918w3.e.get();
                                if (interfaceC2624e2 != null) {
                                    interfaceC2624e2.a(F6.i, c2918w3.f2739a, Integer.valueOf(ConnectionsStatusCodes.STATUS_ALREADY_CONNECTED_TO_ENDPOINT));
                                }
                                InterfaceC2624e2 interfaceC2624e22 = (InterfaceC2624e2) c2918w3.e.get();
                                if (interfaceC2624e22 != null) {
                                    interfaceC2624e22.c();
                                }
                            } else {
                                InterfaceC2624e2 interfaceC2624e23 = (InterfaceC2624e2) c2918w3.e.get();
                                if (interfaceC2624e23 != null) {
                                    interfaceC2624e23.a(F6.j, c2918w3.f2739a, Integer.valueOf(ConnectionsStatusCodes.STATUS_NOT_CONNECTED_TO_ENDPOINT));
                                }
                            }
                        }
                    } else if (c2918w3.c == null) {
                        c2918w3.c = Boolean.FALSE;
                        InterfaceC2624e2 interfaceC2624e24 = (InterfaceC2624e2) c2918w3.e.get();
                        if (interfaceC2624e24 != null) {
                            interfaceC2624e24.a(F6.j, c2918w3.f2739a, Integer.valueOf(ConnectionsStatusCodes.STATUS_CONNECTION_REJECTED));
                        }
                    }
                } else if (c2918w3.c == null) {
                    c2918w3.c = Boolean.TRUE;
                    InterfaceC2624e2 interfaceC2624e25 = (InterfaceC2624e2) c2918w3.e.get();
                    if (interfaceC2624e25 != null) {
                        interfaceC2624e25.a(F6.i, c2918w3.f2739a, (Integer) null);
                    }
                    InterfaceC2624e2 interfaceC2624e26 = (InterfaceC2624e2) c2918w3.e.get();
                    if (interfaceC2624e26 != null) {
                        interfaceC2624e26.c();
                    }
                }
            } else if (!c2918w3.b) {
                c2918w3.b = true;
                InterfaceC2624e2 interfaceC2624e27 = (InterfaceC2624e2) c2918w3.e.get();
                if (interfaceC2624e27 != null) {
                    interfaceC2624e27.a(F6.h, c2918w3.f2739a, (Integer) null);
                }
            }
            c2918w3.d = i;
            if (i == 1) {
                InterfaceC2624e2 interfaceC2624e28 = (InterfaceC2624e2) c2724k2.i.get();
                if (interfaceC2624e28 != null) {
                    GestureDetectorOnGestureListenerC2634ec.Y0.getClass();
                    interfaceC2624e28.a(Gb.a("IN_NATIVE_BROWSER", "onPageStart"));
                    return;
                }
                return;
            }
            if (i == 4) {
                InterfaceC2624e2 interfaceC2624e29 = (InterfaceC2624e2) c2724k2.i.get();
                if (interfaceC2624e29 != null) {
                    GestureDetectorOnGestureListenerC2634ec.Y0.getClass();
                    interfaceC2624e29.a(Gb.a("IN_NATIVE_BROWSER", "onNavigatingAway"));
                    return;
                }
                return;
            }
            if (i == 5) {
                InterfaceC2624e2 interfaceC2624e210 = (InterfaceC2624e2) c2724k2.i.get();
                if (interfaceC2624e210 != null) {
                    GestureDetectorOnGestureListenerC2634ec.Y0.getClass();
                    interfaceC2624e210.a(Gb.a("IN_NATIVE_BROWSER", "onVisible"));
                }
                InterfaceC2624e2 interfaceC2624e211 = (InterfaceC2624e2) c2724k2.i.get();
                if (interfaceC2624e211 != null) {
                    interfaceC2624e211.b();
                    return;
                }
                return;
            }
            if (i != 6) {
                return;
            }
            InterfaceC2624e2 interfaceC2624e212 = (InterfaceC2624e2) c2724k2.i.get();
            if (interfaceC2624e212 != null) {
                GestureDetectorOnGestureListenerC2634ec.Y0.getClass();
                interfaceC2624e212.a(Gb.a("IN_NATIVE_BROWSER", "onHidden"));
            }
            InterfaceC2624e2 interfaceC2624e213 = (InterfaceC2624e2) c2724k2.i.get();
            if (interfaceC2624e213 != null) {
                interfaceC2624e213.a();
            }
        }
    }
}
