package com.sourcepoint.cmplibrary.consent;

import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.model.exposed.CCPAConsentInternal;
import com.sourcepoint.cmplibrary.model.exposed.GDPRConsentInternal;
import com.sourcepoint.cmplibrary.model.exposed.SPConsents;
import com.sourcepoint.cmplibrary.model.exposed.UsNatConsentInternal;
import kotlin.Metadata;

/* compiled from: ConsentManagerUtils.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\b`\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/sourcepoint/cmplibrary/consent/ConsentManagerUtils;", "", "ccpaConsentOptimized", "Lcom/sourcepoint/cmplibrary/core/Either;", "Lcom/sourcepoint/cmplibrary/model/exposed/CCPAConsentInternal;", "getCcpaConsentOptimized", "()Lcom/sourcepoint/cmplibrary/core/Either;", "gdprConsentOptimized", "Lcom/sourcepoint/cmplibrary/model/exposed/GDPRConsentInternal;", "getGdprConsentOptimized", "spStoredConsent", "Lcom/sourcepoint/cmplibrary/model/exposed/SPConsents;", "getSpStoredConsent", "usNatConsent", "Lcom/sourcepoint/cmplibrary/model/exposed/UsNatConsentInternal;", "getUsNatConsent", "sample", "", "samplingRate", "", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ConsentManagerUtils {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final double DEFAULT_SAMPLE_RATE = 1.0d;

    Either<CCPAConsentInternal> getCcpaConsentOptimized();

    Either<GDPRConsentInternal> getGdprConsentOptimized();

    Either<SPConsents> getSpStoredConsent();

    Either<UsNatConsentInternal> getUsNatConsent();

    boolean sample(double samplingRate);

    /* compiled from: ConsentManagerUtils.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/sourcepoint/cmplibrary/consent/ConsentManagerUtils$Companion;", "", "()V", "DEFAULT_SAMPLE_RATE", "", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final double DEFAULT_SAMPLE_RATE = 1.0d;

        private Companion() {
        }
    }
}
