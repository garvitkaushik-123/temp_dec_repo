package com.fyber.inneractive.sdk.click;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.activities.InternalStoreWebpageActivity;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.network.f1;
import com.fyber.inneractive.sdk.util.b0;
import com.fyber.inneractive.sdk.util.e0;
import com.fyber.inneractive.sdk.util.e1;
import com.fyber.inneractive.sdk.web.v0;
import java.util.List;

/* loaded from: classes4.dex */
public final class g implements a {

    /* renamed from: a, reason: collision with root package name */
    public v0 f1060a;
    public boolean b;
    public f c;
    public final e1 d;
    public final com.fyber.inneractive.sdk.util.g e;
    public boolean f = false;

    public g(f fVar, e1 e1Var, com.fyber.inneractive.sdk.util.g gVar) {
        this.c = fVar;
        this.d = e1Var;
        this.e = gVar;
    }

    @Override // com.fyber.inneractive.sdk.click.a
    public final boolean a(Uri uri, r rVar) {
        com.fyber.inneractive.sdk.ignite.m mVar;
        v0 v0Var;
        com.fyber.inneractive.sdk.ignite.m mVar2 = com.fyber.inneractive.sdk.ignite.m.NONE;
        if (rVar != null) {
            mVar = rVar.l;
            this.b = rVar.k;
            this.f1060a = rVar.j;
        } else {
            mVar = mVar2;
        }
        return mVar != mVar2 && IAConfigManager.O.E.n() && (v0Var = this.f1060a) != null && v0Var.l;
    }

    @Override // com.fyber.inneractive.sdk.click.a
    public final void cancel() {
        this.f = true;
        this.c = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x006a  */
    @Override // com.fyber.inneractive.sdk.click.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final b a(Context context, Uri uri, List list) {
        PackageInfo packageInfo;
        b0 b0Var;
        v0 v0Var = this.f1060a;
        if (v0Var != null) {
            boolean z = this.b;
            if (v0Var.C) {
                e0 e0Var = e0.FAILED;
                IllegalStateException illegalStateException = new IllegalStateException("Store controller is already open");
                context.getClass();
                b0Var = new b0(e0Var, illegalStateException);
            } else {
                v0Var.C = true;
                try {
                    context.getClass();
                } catch (Throwable unused) {
                }
                v0Var.D = true;
                if (v0Var.j.equals("invalid_task_id") && !v0Var.z) {
                    v0Var.d = z ? com.fyber.inneractive.sdk.ignite.m.TRUE_SINGLE_TAP : com.fyber.inneractive.sdk.ignite.m.SINGLE_TAP;
                }
                v0Var.B = z;
                if (v0Var.A) {
                    v0Var.d("onInstallationSuccess();");
                } else if (!v0Var.z) {
                    String str = v0Var.c;
                    if (!TextUtils.isEmpty(str)) {
                        packageInfo = com.fyber.inneractive.sdk.util.o.f1770a.getPackageManager().getPackageInfo(str, 0);
                        if (packageInfo == null) {
                            v0Var.d("onInstallationSuccess();");
                        } else if (z) {
                            v0Var.b.a(v0Var.c, new com.fyber.inneractive.sdk.ignite.g(v0Var.f, v0Var.d, v0Var.h.f1242a));
                            v0Var.d("onShowInstallStarted();");
                        }
                    }
                    packageInfo = null;
                    if (packageInfo == null) {
                    }
                }
                try {
                    InternalStoreWebpageActivity.startActivity(context, v0Var.e);
                    b0Var = new b0(e0.OPENED_INTERNAL_STORE, null);
                } catch (ActivityNotFoundException e) {
                    b0Var = new b0(e0.FAILED, e);
                }
            }
            Throwable th = b0Var.b;
            if (th == null) {
                IAConfigManager.O.s.b(new f1(new e(this, list, uri), uri.toString()));
                return new b(uri.toString(), q.OPEN_INTERNAL_STORE, "IgniteGooglePlay", null);
            }
            if (list != null) {
                list.add(new j(this.f1060a.k, false, q.OPEN_INTERNAL_STORE, th.toString()));
            }
            return r.a(uri.toString(), "IgniteGooglePlay", "mInternalStoreWebpageController.show has failed");
        }
        return r.a(uri.toString(), "IgniteGooglePlay", "mInternalStoreWebpageController is null");
    }
}
