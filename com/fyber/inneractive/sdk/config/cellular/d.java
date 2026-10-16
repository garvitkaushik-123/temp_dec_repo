package com.fyber.inneractive.sdk.config.cellular;

import android.content.Context;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.x0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes4.dex */
public abstract class d implements h {

    /* renamed from: a, reason: collision with root package name */
    public final TelephonyManager f1076a;
    public final ConnectivityManager b;
    public CopyOnWriteArrayList c = new CopyOnWriteArrayList();

    public d(Context context) {
        this.f1076a = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        this.b = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public abstract void a();

    public abstract void a(a aVar);

    public abstract void a(h hVar);

    @Override // com.fyber.inneractive.sdk.config.cellular.h
    public final void a(x0 x0Var) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.c;
        if (copyOnWriteArrayList == null) {
            IAlog.a("NetworkDetector: onNetworkUpdated: no update listeners", new Object[0]);
            return;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            if (hVar != null) {
                hVar.a(x0Var);
            }
        }
    }
}
