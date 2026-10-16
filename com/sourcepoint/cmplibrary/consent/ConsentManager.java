package com.sourcepoint.cmplibrary.consent;

import com.inmobi.sdk.InMobiSdk;
import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.data.network.model.optimized.CcpaCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatusApiModelExtKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GdprCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentData;
import com.sourcepoint.cmplibrary.model.ConsentActionImpl;
import com.sourcepoint.cmplibrary.model.NativeConsentAction;
import com.sourcepoint.cmplibrary.model.exposed.CCPAConsentInternal;
import com.sourcepoint.cmplibrary.model.exposed.GDPRConsentInternal;
import com.sourcepoint.cmplibrary.model.exposed.SPCCPAConsent;
import com.sourcepoint.cmplibrary.model.exposed.SPConsents;
import com.sourcepoint.cmplibrary.model.exposed.SPGDPRConsent;
import com.sourcepoint.cmplibrary.model.exposed.SpUsNatConsent;
import com.sourcepoint.cmplibrary.model.exposed.UsNatConsentInternal;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConsentManager.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bJ\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\tH&J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0014H&J\b\u0010\u001a\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R&\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/sourcepoint/cmplibrary/consent/ConsentManager;", "", "hasStoredConsent", "", "getHasStoredConsent", "()Z", "sPConsentsError", "Lkotlin/Function1;", "", "", "getSPConsentsError", "()Lkotlin/jvm/functions/Function1;", "setSPConsentsError", "(Lkotlin/jvm/functions/Function1;)V", "sPConsentsSuccess", "Lcom/sourcepoint/cmplibrary/model/exposed/SPConsents;", "getSPConsentsSuccess", "setSPConsentsSuccess", "enqueueConsent", "consentActionImpl", "Lcom/sourcepoint/cmplibrary/model/ConsentActionImpl;", "nativeConsentAction", "Lcom/sourcepoint/cmplibrary/model/NativeConsentAction;", "resetConsentCounter", "sendConsent", "actionImpl", "sendStoredConsentToClient", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ConsentManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void enqueueConsent(ConsentActionImpl consentActionImpl);

    void enqueueConsent(NativeConsentAction nativeConsentAction);

    boolean getHasStoredConsent();

    Function1<Throwable, Unit> getSPConsentsError();

    Function1<SPConsents, Unit> getSPConsentsSuccess();

    void resetConsentCounter();

    void sendConsent(ConsentActionImpl actionImpl);

    void sendStoredConsentToClient();

    void setSPConsentsError(Function1<? super Throwable, Unit> function1);

    void setSPConsentsSuccess(Function1<? super SPConsents, Unit> function1);

    /* compiled from: ConsentManager.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tJ\u001f\u0010\u0003\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tJ\u001f\u0010\u0003\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\t¨\u0006\u000e"}, d2 = {"Lcom/sourcepoint/cmplibrary/consent/ConsentManager$Companion;", "", "()V", "responseConsentHandler", "Lcom/sourcepoint/cmplibrary/model/exposed/SPConsents;", "ccpa", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", "consentManagerUtils", "Lcom/sourcepoint/cmplibrary/consent/ConsentManagerUtils;", "responseConsentHandler$cmplibrary_release", InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES, "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", "usNat", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final SPConsents responseConsentHandler$cmplibrary_release(GdprCS gdpr, ConsentManagerUtils consentManagerUtils) {
            Object obj;
            Object obj2;
            Intrinsics.checkNotNullParameter(consentManagerUtils, "consentManagerUtils");
            Either<CCPAConsentInternal> ccpaConsentOptimized = consentManagerUtils.getCcpaConsentOptimized();
            if (ccpaConsentOptimized instanceof Either.Right) {
                obj = ((Either.Right) ccpaConsentOptimized).getR();
            } else {
                if (!(ccpaConsentOptimized instanceof Either.Left)) {
                    throw new NoWhenBranchMatchedException();
                }
                obj = null;
            }
            CCPAConsentInternal cCPAConsentInternal = (CCPAConsentInternal) obj;
            Either<UsNatConsentInternal> usNatConsent = consentManagerUtils.getUsNatConsent();
            if (usNatConsent instanceof Either.Right) {
                obj2 = ((Either.Right) usNatConsent).getR();
            } else {
                if (!(usNatConsent instanceof Either.Left)) {
                    throw new NoWhenBranchMatchedException();
                }
                obj2 = null;
            }
            UsNatConsentInternal usNatConsentInternal = (UsNatConsentInternal) obj2;
            return new SPConsents(gdpr != null ? new SPGDPRConsent(ConsentStatusApiModelExtKt.toGDPRUserConsent(gdpr)) : null, cCPAConsentInternal != null ? new SPCCPAConsent(cCPAConsentInternal) : null, usNatConsentInternal != null ? new SpUsNatConsent(usNatConsentInternal) : null);
        }

        public final SPConsents responseConsentHandler$cmplibrary_release(CcpaCS ccpa, ConsentManagerUtils consentManagerUtils) {
            Object obj;
            Object obj2;
            Intrinsics.checkNotNullParameter(consentManagerUtils, "consentManagerUtils");
            Either<GDPRConsentInternal> gdprConsentOptimized = consentManagerUtils.getGdprConsentOptimized();
            if (gdprConsentOptimized instanceof Either.Right) {
                obj = ((Either.Right) gdprConsentOptimized).getR();
            } else {
                if (!(gdprConsentOptimized instanceof Either.Left)) {
                    throw new NoWhenBranchMatchedException();
                }
                obj = null;
            }
            GDPRConsentInternal gDPRConsentInternal = (GDPRConsentInternal) obj;
            Either<UsNatConsentInternal> usNatConsent = consentManagerUtils.getUsNatConsent();
            if (usNatConsent instanceof Either.Right) {
                obj2 = ((Either.Right) usNatConsent).getR();
            } else {
                if (!(usNatConsent instanceof Either.Left)) {
                    throw new NoWhenBranchMatchedException();
                }
                obj2 = null;
            }
            UsNatConsentInternal usNatConsentInternal = (UsNatConsentInternal) obj2;
            return new SPConsents(gDPRConsentInternal != null ? new SPGDPRConsent(gDPRConsentInternal) : null, ccpa != null ? new SPCCPAConsent(ConsentStatusApiModelExtKt.toCCPAConsentInternal(ccpa)) : null, usNatConsentInternal != null ? new SpUsNatConsent(usNatConsentInternal) : null);
        }

        public final SPConsents responseConsentHandler$cmplibrary_release(USNatConsentData usNat, ConsentManagerUtils consentManagerUtils) {
            Object obj;
            Object obj2;
            Intrinsics.checkNotNullParameter(consentManagerUtils, "consentManagerUtils");
            Either<GDPRConsentInternal> gdprConsentOptimized = consentManagerUtils.getGdprConsentOptimized();
            if (gdprConsentOptimized instanceof Either.Right) {
                obj = ((Either.Right) gdprConsentOptimized).getR();
            } else {
                if (!(gdprConsentOptimized instanceof Either.Left)) {
                    throw new NoWhenBranchMatchedException();
                }
                obj = null;
            }
            GDPRConsentInternal gDPRConsentInternal = (GDPRConsentInternal) obj;
            Either<CCPAConsentInternal> ccpaConsentOptimized = consentManagerUtils.getCcpaConsentOptimized();
            if (ccpaConsentOptimized instanceof Either.Right) {
                obj2 = ((Either.Right) ccpaConsentOptimized).getR();
            } else {
                if (!(ccpaConsentOptimized instanceof Either.Left)) {
                    throw new NoWhenBranchMatchedException();
                }
                obj2 = null;
            }
            CCPAConsentInternal cCPAConsentInternal = (CCPAConsentInternal) obj2;
            return new SPConsents(gDPRConsentInternal != null ? new SPGDPRConsent(gDPRConsentInternal) : null, cCPAConsentInternal != null ? new SPCCPAConsent(cCPAConsentInternal) : null, usNat != null ? new SpUsNatConsent(ConsentStatusApiModelExtKt.toUsNatConsentInternal(usNat)) : null);
        }
    }
}
