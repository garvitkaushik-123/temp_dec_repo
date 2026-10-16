package com.fyber.inneractive.sdk.ignite;

import com.fyber.inneractive.sdk.network.e0;
import com.fyber.inneractive.sdk.network.i1;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class b implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f1253a;

    public b(h hVar) {
        this.f1253a = hVar;
    }

    @Override // com.fyber.inneractive.sdk.network.e0
    public final void a(Object obj, Exception exc, boolean z) {
        IgniteResponseOuterClass$IgniteResponse igniteResponseOuterClass$IgniteResponse = (IgniteResponseOuterClass$IgniteResponse) obj;
        this.f1253a.getClass();
        if (exc == null && igniteResponseOuterClass$IgniteResponse != null && igniteResponseOuterClass$IgniteResponse.hasClientId() && igniteResponseOuterClass$IgniteResponse.hasClientSecret()) {
            this.f1253a.onCredentialsRequestSuccess(igniteResponseOuterClass$IgniteResponse.getClientId(), igniteResponseOuterClass$IgniteResponse.getClientSecret());
            return;
        }
        String str = "";
        IAlog.a("Failed to fetch ignite client credentials with error: %s", exc != null ? exc.getMessage() : "");
        this.f1253a.getClass();
        if (!(exc instanceof i1) || ((i1) exc).f1324a != 204) {
            this.f1253a.a(j.FAILED_TO_RETRIEVE_CREDENTIALS, exc != null ? exc.getMessage() : null);
        }
        if (exc != null && exc.getMessage() != null) {
            str = exc.getMessage();
        }
        this.f1253a.onCredentialsRequestFailed(str);
    }
}
