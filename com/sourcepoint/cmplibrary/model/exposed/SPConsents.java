package com.sourcepoint.cmplibrary.model.exposed;

import com.inmobi.sdk.InMobiSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SPConsents.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/SPConsents;", "", InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES, "Lcom/sourcepoint/cmplibrary/model/exposed/SPGDPRConsent;", "ccpa", "Lcom/sourcepoint/cmplibrary/model/exposed/SPCCPAConsent;", "usNat", "Lcom/sourcepoint/cmplibrary/model/exposed/SpUsNatConsent;", "(Lcom/sourcepoint/cmplibrary/model/exposed/SPGDPRConsent;Lcom/sourcepoint/cmplibrary/model/exposed/SPCCPAConsent;Lcom/sourcepoint/cmplibrary/model/exposed/SpUsNatConsent;)V", "getCcpa", "()Lcom/sourcepoint/cmplibrary/model/exposed/SPCCPAConsent;", "getGdpr", "()Lcom/sourcepoint/cmplibrary/model/exposed/SPGDPRConsent;", "getUsNat", "()Lcom/sourcepoint/cmplibrary/model/exposed/SpUsNatConsent;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SPConsents {
    private final SPCCPAConsent ccpa;
    private final SPGDPRConsent gdpr;
    private final SpUsNatConsent usNat;

    public SPConsents() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ SPConsents copy$default(SPConsents sPConsents, SPGDPRConsent sPGDPRConsent, SPCCPAConsent sPCCPAConsent, SpUsNatConsent spUsNatConsent, int i, Object obj) {
        if ((i & 1) != 0) {
            sPGDPRConsent = sPConsents.gdpr;
        }
        if ((i & 2) != 0) {
            sPCCPAConsent = sPConsents.ccpa;
        }
        if ((i & 4) != 0) {
            spUsNatConsent = sPConsents.usNat;
        }
        return sPConsents.copy(sPGDPRConsent, sPCCPAConsent, spUsNatConsent);
    }

    /* renamed from: component1, reason: from getter */
    public final SPGDPRConsent getGdpr() {
        return this.gdpr;
    }

    /* renamed from: component2, reason: from getter */
    public final SPCCPAConsent getCcpa() {
        return this.ccpa;
    }

    /* renamed from: component3, reason: from getter */
    public final SpUsNatConsent getUsNat() {
        return this.usNat;
    }

    public final SPConsents copy(SPGDPRConsent gdpr, SPCCPAConsent ccpa, SpUsNatConsent usNat) {
        return new SPConsents(gdpr, ccpa, usNat);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SPConsents)) {
            return false;
        }
        SPConsents sPConsents = (SPConsents) other;
        return Intrinsics.areEqual(this.gdpr, sPConsents.gdpr) && Intrinsics.areEqual(this.ccpa, sPConsents.ccpa) && Intrinsics.areEqual(this.usNat, sPConsents.usNat);
    }

    public int hashCode() {
        SPGDPRConsent sPGDPRConsent = this.gdpr;
        int hashCode = (sPGDPRConsent == null ? 0 : sPGDPRConsent.hashCode()) * 31;
        SPCCPAConsent sPCCPAConsent = this.ccpa;
        int hashCode2 = (hashCode + (sPCCPAConsent == null ? 0 : sPCCPAConsent.hashCode())) * 31;
        SpUsNatConsent spUsNatConsent = this.usNat;
        return hashCode2 + (spUsNatConsent != null ? spUsNatConsent.hashCode() : 0);
    }

    public String toString() {
        return "SPConsents(gdpr=" + this.gdpr + ", ccpa=" + this.ccpa + ", usNat=" + this.usNat + ")";
    }

    public SPConsents(SPGDPRConsent sPGDPRConsent, SPCCPAConsent sPCCPAConsent, SpUsNatConsent spUsNatConsent) {
        this.gdpr = sPGDPRConsent;
        this.ccpa = sPCCPAConsent;
        this.usNat = spUsNatConsent;
    }

    public /* synthetic */ SPConsents(SPGDPRConsent sPGDPRConsent, SPCCPAConsent sPCCPAConsent, SpUsNatConsent spUsNatConsent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : sPGDPRConsent, (i & 2) != 0 ? null : sPCCPAConsent, (i & 4) != 0 ? null : spUsNatConsent);
    }

    public final SPGDPRConsent getGdpr() {
        return this.gdpr;
    }

    public final SPCCPAConsent getCcpa() {
        return this.ccpa;
    }

    public final SpUsNatConsent getUsNat() {
        return this.usNat;
    }
}
