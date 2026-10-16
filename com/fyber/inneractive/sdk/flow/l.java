package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;

/* loaded from: classes4.dex */
public final class l implements IAConfigManager.OnConfigurationReadyAndValidListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveAdRequest f1209a;
    public final /* synthetic */ m b;

    public l(m mVar, InneractiveAdRequest inneractiveAdRequest) {
        this.b = mVar;
        this.f1209a = inneractiveAdRequest;
    }

    @Override // com.fyber.inneractive.sdk.config.IAConfigManager.OnConfigurationReadyAndValidListener
    public final void onConfigurationReadyAndValid(IAConfigManager iAConfigManager, boolean z, Exception exc) {
        IAConfigManager.removeListener(this);
        if (z) {
            this.b.c(this.f1209a);
            return;
        }
        InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(exc instanceof com.fyber.inneractive.sdk.network.b ? InneractiveErrorCode.CONNECTION_ERROR : InneractiveErrorCode.SDK_NOT_INITIALIZED_OR_CONFIG_ERROR, i.NO_APP_CONFIG_AVAILABLE, exc);
        m mVar = this.b;
        mVar.a(this.f1209a, mVar.c(), inneractiveInfrastructureError);
    }
}
