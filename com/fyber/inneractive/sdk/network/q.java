package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.FileNotFoundException;

/* loaded from: classes4.dex */
public final class q implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f1333a;

    public q(s sVar) {
        this.f1333a = sVar;
    }

    @Override // com.fyber.inneractive.sdk.network.e0
    public final void a(Object obj, Exception exc, boolean z) {
        com.fyber.inneractive.sdk.flow.o oVar;
        com.fyber.inneractive.sdk.response.e eVar = (com.fyber.inneractive.sdk.response.e) obj;
        if (exc == null) {
            s sVar = this.f1333a;
            sVar.a(sVar.e, eVar);
            return;
        }
        this.f1333a.getClass();
        InneractiveErrorCode inneractiveErrorCode = exc instanceof i1 ? ((i1) exc).f1324a == 204 ? InneractiveErrorCode.NO_FILL : InneractiveErrorCode.SERVER_INTERNAL_ERROR : exc instanceof FileNotFoundException ? InneractiveErrorCode.CONNECTION_ERROR : exc instanceof m0 ? InneractiveErrorCode.SERVER_INVALID_RESPONSE : InneractiveErrorCode.CONNECTION_ERROR;
        s sVar2 = this.f1333a;
        InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(inneractiveErrorCode, com.fyber.inneractive.sdk.flow.i.NETWORK_ERROR, exc);
        InneractiveAdRequest inneractiveAdRequest = sVar2.e;
        if (sVar2.f1330a == null) {
            return;
        }
        if (sVar2.b) {
            IAlog.e("IARemoteAdFetcher: ignoring response. Previous request was cancelled", new Object[0]);
        } else {
            if (sVar2.b || (oVar = sVar2.f1330a) == null) {
                return;
            }
            oVar.a(inneractiveAdRequest, eVar, inneractiveInfrastructureError);
        }
    }
}
