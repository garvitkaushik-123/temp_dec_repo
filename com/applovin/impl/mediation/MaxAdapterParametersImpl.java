package com.applovin.impl.mediation;

import android.os.Bundle;
import com.applovin.impl.b5;
import com.applovin.impl.h3;
import com.applovin.impl.v2;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import java.util.Map;

/* loaded from: classes2.dex */
public class MaxAdapterParametersImpl implements MaxAdapterResponseParameters, MaxAdapterSignalCollectionParameters, MaxAdapterInitializationParameters {

    /* renamed from: a, reason: collision with root package name */
    private String f553a;
    private Map b;
    private Bundle c;
    private Bundle d;
    private Boolean e;
    private Boolean f;
    private String g;
    private boolean h;
    private String i;
    private String j;
    private long k;
    private MaxAdFormat l;

    private MaxAdapterParametersImpl() {
    }

    static MaxAdapterParametersImpl a(v2 v2Var) {
        MaxAdapterParametersImpl a2 = a((h3) v2Var);
        a2.i = v2Var.Q();
        a2.j = v2Var.E();
        a2.k = v2Var.D();
        return a2;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters
    public MaxAdFormat getAdFormat() {
        return this.l;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public String getAdUnitId() {
        return this.f553a;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters
    public long getBidExpirationMillis() {
        return this.k;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters
    public String getBidResponse() {
        return this.j;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public String getConsentString() {
        return this.g;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Bundle getCustomParameters() {
        return this.d;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Map<String, Object> getLocalExtraParameters() {
        return this.b;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Bundle getServerParameters() {
        return this.c;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters
    public String getThirdPartyAdPlacementId() {
        return this.i;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Boolean hasUserConsent() {
        return this.e;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Boolean isAgeRestrictedUser() {
        return null;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Boolean isDoNotSell() {
        return this.f;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public boolean isTesting() {
        return this.h;
    }

    static MaxAdapterParametersImpl a(b5 b5Var, String str, MaxAdFormat maxAdFormat) {
        MaxAdapterParametersImpl a2 = a(b5Var);
        a2.f553a = str;
        a2.l = maxAdFormat;
        return a2;
    }

    static MaxAdapterParametersImpl a(h3 h3Var) {
        MaxAdapterParametersImpl maxAdapterParametersImpl = new MaxAdapterParametersImpl();
        maxAdapterParametersImpl.f553a = h3Var.getAdUnitId();
        maxAdapterParametersImpl.e = h3Var.n();
        maxAdapterParametersImpl.f = h3Var.o();
        maxAdapterParametersImpl.g = h3Var.d();
        maxAdapterParametersImpl.b = h3Var.i();
        maxAdapterParametersImpl.c = h3Var.l();
        maxAdapterParametersImpl.d = h3Var.f();
        maxAdapterParametersImpl.h = h3Var.p();
        return maxAdapterParametersImpl;
    }
}
