package com.sourcepoint.cmplibrary.model.exposed;

import kotlin.Metadata;

/* compiled from: Gpp.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/SpGppConfig;", "", "coveredTransaction", "Lcom/sourcepoint/cmplibrary/model/exposed/SpGppOptionBinary;", "optOutOptionMode", "Lcom/sourcepoint/cmplibrary/model/exposed/SpGppOptionTernary;", "serviceProviderMode", "(Lcom/sourcepoint/cmplibrary/model/exposed/SpGppOptionBinary;Lcom/sourcepoint/cmplibrary/model/exposed/SpGppOptionTernary;Lcom/sourcepoint/cmplibrary/model/exposed/SpGppOptionTernary;)V", "getCoveredTransaction", "()Lcom/sourcepoint/cmplibrary/model/exposed/SpGppOptionBinary;", "getOptOutOptionMode", "()Lcom/sourcepoint/cmplibrary/model/exposed/SpGppOptionTernary;", "getServiceProviderMode", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SpGppConfig {
    private final SpGppOptionBinary coveredTransaction;
    private final SpGppOptionTernary optOutOptionMode;
    private final SpGppOptionTernary serviceProviderMode;

    public static /* synthetic */ SpGppConfig copy$default(SpGppConfig spGppConfig, SpGppOptionBinary spGppOptionBinary, SpGppOptionTernary spGppOptionTernary, SpGppOptionTernary spGppOptionTernary2, int i, Object obj) {
        if ((i & 1) != 0) {
            spGppOptionBinary = spGppConfig.coveredTransaction;
        }
        if ((i & 2) != 0) {
            spGppOptionTernary = spGppConfig.optOutOptionMode;
        }
        if ((i & 4) != 0) {
            spGppOptionTernary2 = spGppConfig.serviceProviderMode;
        }
        return spGppConfig.copy(spGppOptionBinary, spGppOptionTernary, spGppOptionTernary2);
    }

    /* renamed from: component1, reason: from getter */
    public final SpGppOptionBinary getCoveredTransaction() {
        return this.coveredTransaction;
    }

    /* renamed from: component2, reason: from getter */
    public final SpGppOptionTernary getOptOutOptionMode() {
        return this.optOutOptionMode;
    }

    /* renamed from: component3, reason: from getter */
    public final SpGppOptionTernary getServiceProviderMode() {
        return this.serviceProviderMode;
    }

    public final SpGppConfig copy(SpGppOptionBinary coveredTransaction, SpGppOptionTernary optOutOptionMode, SpGppOptionTernary serviceProviderMode) {
        return new SpGppConfig(coveredTransaction, optOutOptionMode, serviceProviderMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpGppConfig)) {
            return false;
        }
        SpGppConfig spGppConfig = (SpGppConfig) other;
        return this.coveredTransaction == spGppConfig.coveredTransaction && this.optOutOptionMode == spGppConfig.optOutOptionMode && this.serviceProviderMode == spGppConfig.serviceProviderMode;
    }

    public int hashCode() {
        SpGppOptionBinary spGppOptionBinary = this.coveredTransaction;
        int hashCode = (spGppOptionBinary == null ? 0 : spGppOptionBinary.hashCode()) * 31;
        SpGppOptionTernary spGppOptionTernary = this.optOutOptionMode;
        int hashCode2 = (hashCode + (spGppOptionTernary == null ? 0 : spGppOptionTernary.hashCode())) * 31;
        SpGppOptionTernary spGppOptionTernary2 = this.serviceProviderMode;
        return hashCode2 + (spGppOptionTernary2 != null ? spGppOptionTernary2.hashCode() : 0);
    }

    public String toString() {
        return "SpGppConfig(coveredTransaction=" + this.coveredTransaction + ", optOutOptionMode=" + this.optOutOptionMode + ", serviceProviderMode=" + this.serviceProviderMode + ")";
    }

    public SpGppConfig(SpGppOptionBinary spGppOptionBinary, SpGppOptionTernary spGppOptionTernary, SpGppOptionTernary spGppOptionTernary2) {
        this.coveredTransaction = spGppOptionBinary;
        this.optOutOptionMode = spGppOptionTernary;
        this.serviceProviderMode = spGppOptionTernary2;
    }

    public final SpGppOptionBinary getCoveredTransaction() {
        return this.coveredTransaction;
    }

    public final SpGppOptionTernary getOptOutOptionMode() {
        return this.optOutOptionMode;
    }

    public final SpGppOptionTernary getServiceProviderMode() {
        return this.serviceProviderMode;
    }
}
