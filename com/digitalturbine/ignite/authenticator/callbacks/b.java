package com.digitalturbine.ignite.authenticator.callbacks;

import android.text.TextUtils;
import com.digitalturbine.ignite.authenticator.IgniteManager;
import com.digitalturbine.ignite.authenticator.decorator.h;
import com.digitalturbine.ignite.authenticator.events.c;
import com.digitalturbine.ignite.authenticator.events.d;
import com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class b extends IIgniteServiceCallback.Stub {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f989a;

    public b(com.digitalturbine.ignite.authenticator.handlers.a aVar) {
        ArrayList arrayList = new ArrayList();
        this.f989a = arrayList;
        arrayList.add(aVar);
    }

    @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback
    public final void onError(String str) {
        com.digitalturbine.ignite.authenticator.logger.a.a("%s : unable to retrieve property: %s", "IgnitePropertyCallback", str);
        Iterator it = this.f989a.iterator();
        while (it.hasNext()) {
            h hVar = ((com.digitalturbine.ignite.authenticator.handlers.a) it.next()).f997a;
            if (hVar != null) {
                com.digitalturbine.ignite.authenticator.logger.a.a("%s : on one dt error", "OneDTAuthenticator");
                hVar.k.set(true);
                if (hVar.d != null) {
                    com.digitalturbine.ignite.authenticator.logger.a.b("%s : on one dt error : %s", "IgniteManager", str);
                }
            }
        }
    }

    @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback
    public final void onProgress(String str) {
    }

    @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback
    public final void onScheduled(String str) {
    }

    @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback
    public final void onStart(String str) {
    }

    @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback
    public final void onSuccess(String str) {
        com.digitalturbine.ignite.authenticator.logger.a.a("%s : property retrieved", "IgnitePropertyCallback");
        Iterator it = this.f989a.iterator();
        while (it.hasNext()) {
            h hVar = ((com.digitalturbine.ignite.authenticator.handlers.a) it.next()).f997a;
            if (hVar != null) {
                if (TextUtils.isEmpty(str)) {
                    com.digitalturbine.ignite.authenticator.logger.a.a("%s : on one dt error", "OneDTAuthenticator");
                    hVar.k.set(true);
                    if (hVar.d != null) {
                        com.digitalturbine.ignite.authenticator.logger.a.b("%s : on one dt error : %s", "IgniteManager", "One DT is empty");
                    }
                    com.digitalturbine.ignite.authenticator.events.b.a(d.RAW_ONE_DT_ERROR, AndroidBridgeConstants.ERROR_CODE, c.ONE_DT_EMPTY_ENTITY.a());
                } else {
                    hVar.e.a(str);
                    hVar.f.getClass();
                    com.digitalturbine.ignite.authenticator.b a2 = com.digitalturbine.ignite.authenticator.parsers.b.a(str);
                    hVar.g = a2;
                    IgniteManager igniteManager = hVar.d;
                    if (igniteManager != null) {
                        com.digitalturbine.ignite.authenticator.logger.a.a("%s : setting one dt entity", "IgniteManager");
                        igniteManager.b = a2;
                    }
                }
            }
        }
    }
}
