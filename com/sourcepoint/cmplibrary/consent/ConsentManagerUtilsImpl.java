package com.sourcepoint.cmplibrary.consent;

import com.sourcepoint.cmplibrary.campaign.CampaignManager;
import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.data.local.DataStorage;
import com.sourcepoint.cmplibrary.data.network.model.optimized.CcpaCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatusApiModelExtKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GdprCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentData;
import com.sourcepoint.cmplibrary.exception.InvalidConsentResponse;
import com.sourcepoint.cmplibrary.model.exposed.CCPAConsentInternal;
import com.sourcepoint.cmplibrary.model.exposed.GDPRConsentInternal;
import com.sourcepoint.cmplibrary.model.exposed.SPCCPAConsent;
import com.sourcepoint.cmplibrary.model.exposed.SPConsents;
import com.sourcepoint.cmplibrary.model.exposed.SPGDPRConsent;
import com.sourcepoint.cmplibrary.model.exposed.SpUsNatConsent;
import com.sourcepoint.cmplibrary.model.exposed.UsNatConsentInternal;
import com.sourcepoint.cmplibrary.util.FunctionalUtilsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: ConsentManagerUtils.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000bR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000bR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/sourcepoint/cmplibrary/consent/ConsentManagerUtilsImpl;", "Lcom/sourcepoint/cmplibrary/consent/ConsentManagerUtils;", "cm", "Lcom/sourcepoint/cmplibrary/campaign/CampaignManager;", "ds", "Lcom/sourcepoint/cmplibrary/data/local/DataStorage;", "(Lcom/sourcepoint/cmplibrary/campaign/CampaignManager;Lcom/sourcepoint/cmplibrary/data/local/DataStorage;)V", "ccpaConsentOptimized", "Lcom/sourcepoint/cmplibrary/core/Either;", "Lcom/sourcepoint/cmplibrary/model/exposed/CCPAConsentInternal;", "getCcpaConsentOptimized", "()Lcom/sourcepoint/cmplibrary/core/Either;", "getCm", "()Lcom/sourcepoint/cmplibrary/campaign/CampaignManager;", "getDs", "()Lcom/sourcepoint/cmplibrary/data/local/DataStorage;", "gdprConsentOptimized", "Lcom/sourcepoint/cmplibrary/model/exposed/GDPRConsentInternal;", "getGdprConsentOptimized", "spStoredConsent", "Lcom/sourcepoint/cmplibrary/model/exposed/SPConsents;", "getSpStoredConsent", "usNatConsent", "Lcom/sourcepoint/cmplibrary/model/exposed/UsNatConsentInternal;", "getUsNatConsent", "sample", "", "samplingRate", "", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
final class ConsentManagerUtilsImpl implements ConsentManagerUtils {
    private final CampaignManager cm;
    private final DataStorage ds;

    public ConsentManagerUtilsImpl(CampaignManager cm, DataStorage ds) {
        Intrinsics.checkNotNullParameter(cm, "cm");
        Intrinsics.checkNotNullParameter(ds, "ds");
        this.cm = cm;
        this.ds = ds;
    }

    public final CampaignManager getCm() {
        return this.cm;
    }

    public final DataStorage getDs() {
        return this.ds;
    }

    @Override // com.sourcepoint.cmplibrary.consent.ConsentManagerUtils
    public Either<GDPRConsentInternal> getGdprConsentOptimized() {
        return FunctionalUtilsKt.check(new Function0<GDPRConsentInternal>() { // from class: com.sourcepoint.cmplibrary.consent.ConsentManagerUtilsImpl$gdprConsentOptimized$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GDPRConsentInternal invoke() {
                GDPRConsentInternal gDPRUserConsent;
                GdprCS gdprConsentStatus = ConsentManagerUtilsImpl.this.getCm().getGdprConsentStatus();
                if (gdprConsentStatus == null || (gDPRUserConsent = ConsentStatusApiModelExtKt.toGDPRUserConsent(gdprConsentStatus)) == null) {
                    throw new InvalidConsentResponse(null, "The GDPR consent is null!!!", false, 4, null);
                }
                return gDPRUserConsent;
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.consent.ConsentManagerUtils
    public Either<CCPAConsentInternal> getCcpaConsentOptimized() {
        return FunctionalUtilsKt.check(new Function0<CCPAConsentInternal>() { // from class: com.sourcepoint.cmplibrary.consent.ConsentManagerUtilsImpl$ccpaConsentOptimized$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CCPAConsentInternal invoke() {
                CCPAConsentInternal cCPAConsentInternal;
                CcpaCS ccpaConsentStatus = ConsentManagerUtilsImpl.this.getCm().getCcpaConsentStatus();
                if (ccpaConsentStatus == null || (cCPAConsentInternal = ConsentStatusApiModelExtKt.toCCPAConsentInternal(ccpaConsentStatus)) == null) {
                    throw new InvalidConsentResponse(null, "The CCPA consent is null!!!", false, 4, null);
                }
                return cCPAConsentInternal;
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.consent.ConsentManagerUtils
    public Either<UsNatConsentInternal> getUsNatConsent() {
        return FunctionalUtilsKt.check(new Function0<UsNatConsentInternal>() { // from class: com.sourcepoint.cmplibrary.consent.ConsentManagerUtilsImpl$usNatConsent$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UsNatConsentInternal invoke() {
                UsNatConsentInternal usNatConsentInternal;
                USNatConsentData usNatConsentData = ConsentManagerUtilsImpl.this.getCm().getUsNatConsentData();
                if (usNatConsentData == null || (usNatConsentInternal = ConsentStatusApiModelExtKt.toUsNatConsentInternal(usNatConsentData)) == null) {
                    throw new InvalidConsentResponse(null, "The UsNat consent is null!!!", false, 4, null);
                }
                return usNatConsentInternal;
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.consent.ConsentManagerUtils
    public Either<SPConsents> getSpStoredConsent() {
        return FunctionalUtilsKt.check(new Function0<SPConsents>() { // from class: com.sourcepoint.cmplibrary.consent.ConsentManagerUtilsImpl$spStoredConsent$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SPConsents invoke() {
                Object obj;
                Object obj2;
                Object obj3;
                Either<CCPAConsentInternal> ccpaConsentOptimized = ConsentManagerUtilsImpl.this.getCcpaConsentOptimized();
                if (ccpaConsentOptimized instanceof Either.Right) {
                    obj = ((Either.Right) ccpaConsentOptimized).getR();
                } else {
                    if (!(ccpaConsentOptimized instanceof Either.Left)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    obj = null;
                }
                CCPAConsentInternal cCPAConsentInternal = (CCPAConsentInternal) obj;
                Either<UsNatConsentInternal> usNatConsent = ConsentManagerUtilsImpl.this.getUsNatConsent();
                if (usNatConsent instanceof Either.Right) {
                    obj2 = ((Either.Right) usNatConsent).getR();
                } else {
                    if (!(usNatConsent instanceof Either.Left)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    obj2 = null;
                }
                UsNatConsentInternal usNatConsentInternal = (UsNatConsentInternal) obj2;
                Either<GDPRConsentInternal> gdprConsentOptimized = ConsentManagerUtilsImpl.this.getGdprConsentOptimized();
                if (gdprConsentOptimized instanceof Either.Right) {
                    obj3 = ((Either.Right) gdprConsentOptimized).getR();
                } else {
                    if (!(gdprConsentOptimized instanceof Either.Left)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    obj3 = null;
                }
                GDPRConsentInternal gDPRConsentInternal = (GDPRConsentInternal) obj3;
                return new SPConsents(gDPRConsentInternal != null ? new SPGDPRConsent(gDPRConsentInternal) : null, cCPAConsentInternal != null ? new SPCCPAConsent(cCPAConsentInternal) : null, usNatConsentInternal != null ? new SpUsNatConsent(usNatConsentInternal) : null);
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.consent.ConsentManagerUtils
    public boolean sample(double samplingRate) {
        int i = (int) (samplingRate * 100);
        int random = RangesKt.random(new IntRange(1, 100), Random.INSTANCE);
        return 1 <= random && random <= i;
    }
}
