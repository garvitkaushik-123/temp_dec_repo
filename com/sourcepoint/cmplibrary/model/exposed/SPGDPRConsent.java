package com.sourcepoint.cmplibrary.model.exposed;

import com.ironsource.C3040d4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SPConsents.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/SPGDPRConsent;", "", C3040d4.i.b0, "Lcom/sourcepoint/cmplibrary/model/exposed/GDPRConsent;", "(Lcom/sourcepoint/cmplibrary/model/exposed/GDPRConsent;)V", "getConsent", "()Lcom/sourcepoint/cmplibrary/model/exposed/GDPRConsent;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SPGDPRConsent {
    private final GDPRConsent consent;

    public static /* synthetic */ SPGDPRConsent copy$default(SPGDPRConsent sPGDPRConsent, GDPRConsent gDPRConsent, int i, Object obj) {
        if ((i & 1) != 0) {
            gDPRConsent = sPGDPRConsent.consent;
        }
        return sPGDPRConsent.copy(gDPRConsent);
    }

    /* renamed from: component1, reason: from getter */
    public final GDPRConsent getConsent() {
        return this.consent;
    }

    public final SPGDPRConsent copy(GDPRConsent consent) {
        Intrinsics.checkNotNullParameter(consent, "consent");
        return new SPGDPRConsent(consent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SPGDPRConsent) && Intrinsics.areEqual(this.consent, ((SPGDPRConsent) other).consent);
    }

    public int hashCode() {
        return this.consent.hashCode();
    }

    public String toString() {
        return "SPGDPRConsent(consent=" + this.consent + ")";
    }

    public SPGDPRConsent(GDPRConsent consent) {
        Intrinsics.checkNotNullParameter(consent, "consent");
        this.consent = consent;
    }

    public final GDPRConsent getConsent() {
        return this.consent;
    }
}
