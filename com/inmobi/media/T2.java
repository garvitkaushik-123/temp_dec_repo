package com.inmobi.media;

import android.os.Message;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class T2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final I2 f2434a;
    public final U2 b;
    public final U2 c;

    public T2(I2 callback, U2 request, U2 u2) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(request, "request");
        this.f2434a = callback;
        this.b = request;
        this.c = u2;
    }

    public final boolean a(U2 u2, int i, LinkedHashMap linkedHashMap) {
        if (i <= u2.z) {
            Thread.sleep(u2.A * 1000);
            return false;
        }
        Iterator it = u2.y.entrySet().iterator();
        while (it.hasNext()) {
            W2 response = (W2) linkedHashMap.get((String) ((Map.Entry) it.next()).getKey());
            if (response != null) {
                I2 i2 = this.f2434a;
                Intrinsics.checkNotNullParameter(response, "response");
                Message obtain = Message.obtain();
                obtain.what = 6;
                obtain.obj = response;
                i2.sendMessage(obtain);
            }
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (InterruptedException unused) {
            Intrinsics.checkNotNullExpressionValue("T2", "TAG");
        }
    }

    public final void a() {
        LinkedHashMap linkedHashMap;
        List list;
        String str;
        U2 mRequest;
        int i = 0;
        int i2 = 0;
        do {
            U2 mRequest2 = this.b;
            if (i2 > mRequest2.z) {
                break;
            }
            Intrinsics.checkNotNullParameter(mRequest2, "mRequest");
            C2556a3 c2556a3 = new C2556a3(mRequest2, mRequest2.b());
            linkedHashMap = c2556a3.c;
            if (c2556a3.a() && (mRequest = this.c) != null) {
                while (i <= mRequest.z) {
                    Intrinsics.checkNotNullParameter(mRequest, "mRequest");
                    C2556a3 c2556a32 = new C2556a3(mRequest, mRequest.b());
                    LinkedHashMap linkedHashMap2 = c2556a32.c;
                    if (!c2556a32.a()) {
                        a(mRequest, linkedHashMap2);
                        if (mRequest.y.isEmpty()) {
                            break;
                        }
                        i++;
                        if (a(mRequest, i, linkedHashMap2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                I2 i22 = this.f2434a;
                String accountId = mRequest.B;
                Intrinsics.checkNotNullParameter(accountId, "accountId");
                Message obtain = Message.obtain();
                obtain.what = 4;
                obtain.obj = accountId;
                i22.sendMessage(obtain);
                return;
            }
            if (this.b.C) {
                I2 i23 = this.f2434a;
                Map map = c2556a3.f2514a.f;
                Object ipAddress = (map == null || (list = (List) map.get("cip")) == null || (str = (String) CollectionsKt.firstOrNull(list)) == null) ? X2.f2477a : new Y2(str);
                Intrinsics.checkNotNullParameter(ipAddress, "ipAddress");
                Message obtain2 = Message.obtain();
                obtain2.what = 7;
                obtain2.obj = ipAddress;
                i23.sendMessage(obtain2);
            }
            a(this.b, linkedHashMap);
            if (this.b.y.isEmpty()) {
                break;
            } else {
                i2++;
            }
        } while (!a(this.b, i2, linkedHashMap));
        I2 i24 = this.f2434a;
        String accountId2 = this.b.B;
        Intrinsics.checkNotNullParameter(accountId2, "accountId");
        Message obtain3 = Message.obtain();
        obtain3.what = 4;
        obtain3.obj = accountId2;
        i24.sendMessage(obtain3);
    }

    public final void a(U2 u2, LinkedHashMap linkedHashMap) {
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            W2 response = (W2) entry.getValue();
            String configType = (String) entry.getKey();
            if (response.c == null) {
                I2 i2 = this.f2434a;
                Intrinsics.checkNotNullParameter(response, "response");
                Message obtain = Message.obtain();
                obtain.what = 6;
                obtain.obj = response;
                i2.sendMessage(obtain);
                u2.getClass();
                Intrinsics.checkNotNullParameter(configType, "configType");
                u2.y.remove(configType);
            }
        }
    }
}
