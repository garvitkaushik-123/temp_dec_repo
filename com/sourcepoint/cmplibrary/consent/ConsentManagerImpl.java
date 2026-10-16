package com.sourcepoint.cmplibrary.consent;

import androidx.core.app.NotificationCompat;
import com.ironsource.D5;
import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.core.ExecutorManager;
import com.sourcepoint.cmplibrary.data.Service;
import com.sourcepoint.cmplibrary.data.local.DataStorage;
import com.sourcepoint.cmplibrary.data.network.model.optimized.choice.ChoiceResp;
import com.sourcepoint.cmplibrary.data.network.util.Env;
import com.sourcepoint.cmplibrary.exception.Logger;
import com.sourcepoint.cmplibrary.model.ConsentActionImpl;
import com.sourcepoint.cmplibrary.model.ConsentActionImplKt;
import com.sourcepoint.cmplibrary.model.NativeConsentAction;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConsentManager.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0018H\u0016J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020#H\u0016J\b\u0010)\u001a\u00020\u0018H\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/sourcepoint/cmplibrary/consent/ConsentManagerImpl;", "Lcom/sourcepoint/cmplibrary/consent/ConsentManager;", NotificationCompat.CATEGORY_SERVICE, "Lcom/sourcepoint/cmplibrary/data/Service;", "consentManagerUtils", "Lcom/sourcepoint/cmplibrary/consent/ConsentManagerUtils;", "logger", "Lcom/sourcepoint/cmplibrary/exception/Logger;", D5.o, "Lcom/sourcepoint/cmplibrary/data/network/util/Env;", "dataStorage", "Lcom/sourcepoint/cmplibrary/data/local/DataStorage;", "executorManager", "Lcom/sourcepoint/cmplibrary/core/ExecutorManager;", "clientEventManager", "Lcom/sourcepoint/cmplibrary/consent/ClientEventManager;", "(Lcom/sourcepoint/cmplibrary/data/Service;Lcom/sourcepoint/cmplibrary/consent/ConsentManagerUtils;Lcom/sourcepoint/cmplibrary/exception/Logger;Lcom/sourcepoint/cmplibrary/data/network/util/Env;Lcom/sourcepoint/cmplibrary/data/local/DataStorage;Lcom/sourcepoint/cmplibrary/core/ExecutorManager;Lcom/sourcepoint/cmplibrary/consent/ClientEventManager;)V", "hasStoredConsent", "", "getHasStoredConsent", "()Z", "sPConsentsError", "Lkotlin/Function1;", "", "", "getSPConsentsError", "()Lkotlin/jvm/functions/Function1;", "setSPConsentsError", "(Lkotlin/jvm/functions/Function1;)V", "sPConsentsSuccess", "Lcom/sourcepoint/cmplibrary/model/exposed/SPConsents;", "getSPConsentsSuccess", "setSPConsentsSuccess", "enqueueConsent", "consentActionImpl", "Lcom/sourcepoint/cmplibrary/model/ConsentActionImpl;", "nativeConsentAction", "Lcom/sourcepoint/cmplibrary/model/NativeConsentAction;", "resetConsentCounter", "sendConsent", "actionImpl", "sendStoredConsentToClient", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
final class ConsentManagerImpl implements ConsentManager {
    private final ClientEventManager clientEventManager;
    private final ConsentManagerUtils consentManagerUtils;
    private final DataStorage dataStorage;
    private final Env env;
    private final ExecutorManager executorManager;
    private final Logger logger;
    private Function1<? super Throwable, Unit> sPConsentsError;
    private Function1<? super SPConsents, Unit> sPConsentsSuccess;
    private final Service service;

    public ConsentManagerImpl(Service service, ConsentManagerUtils consentManagerUtils, Logger logger, Env env, DataStorage dataStorage, ExecutorManager executorManager, ClientEventManager clientEventManager) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(consentManagerUtils, "consentManagerUtils");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(dataStorage, "dataStorage");
        Intrinsics.checkNotNullParameter(executorManager, "executorManager");
        Intrinsics.checkNotNullParameter(clientEventManager, "clientEventManager");
        this.service = service;
        this.consentManagerUtils = consentManagerUtils;
        this.logger = logger;
        this.env = env;
        this.dataStorage = dataStorage;
        this.executorManager = executorManager;
        this.clientEventManager = clientEventManager;
    }

    @Override // com.sourcepoint.cmplibrary.consent.ConsentManager
    public Function1<SPConsents, Unit> getSPConsentsSuccess() {
        return this.sPConsentsSuccess;
    }

    @Override // com.sourcepoint.cmplibrary.consent.ConsentManager
    public void setSPConsentsSuccess(Function1<? super SPConsents, Unit> function1) {
        this.sPConsentsSuccess = function1;
    }

    @Override // com.sourcepoint.cmplibrary.consent.ConsentManager
    public Function1<Throwable, Unit> getSPConsentsError() {
        return this.sPConsentsError;
    }

    @Override // com.sourcepoint.cmplibrary.consent.ConsentManager
    public void setSPConsentsError(Function1<? super Throwable, Unit> function1) {
        this.sPConsentsError = function1;
    }

    @Override // com.sourcepoint.cmplibrary.consent.ConsentManager
    public boolean getHasStoredConsent() {
        return (this.dataStorage.getCcpaConsentStatus() == null && this.dataStorage.getGdprConsentStatus() == null && this.dataStorage.getUsNatConsentData() == null) ? false : true;
    }

    @Override // com.sourcepoint.cmplibrary.consent.ConsentManager
    public void enqueueConsent(ConsentActionImpl consentActionImpl) {
        Intrinsics.checkNotNullParameter(consentActionImpl, "consentActionImpl");
        sendConsent(consentActionImpl);
    }

    @Override // com.sourcepoint.cmplibrary.consent.ConsentManager
    public void enqueueConsent(NativeConsentAction nativeConsentAction) {
        Intrinsics.checkNotNullParameter(nativeConsentAction, "nativeConsentAction");
        sendConsent(ConsentActionImplKt.toConsentAction(nativeConsentAction));
    }

    @Override // com.sourcepoint.cmplibrary.consent.ConsentManager
    public void resetConsentCounter() {
        this.clientEventManager.setCampaignsToProcess(0);
    }

    @Override // com.sourcepoint.cmplibrary.consent.ConsentManager
    public void sendStoredConsentToClient() {
        FunctionalUtilsKt.check(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.consent.ConsentManagerImpl$sendStoredConsentToClient$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                ConsentManagerUtils consentManagerUtils;
                Object obj;
                ConsentManagerUtils consentManagerUtils2;
                Object obj2;
                ConsentManagerUtils consentManagerUtils3;
                Object obj3;
                consentManagerUtils = ConsentManagerImpl.this.consentManagerUtils;
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
                consentManagerUtils2 = ConsentManagerImpl.this.consentManagerUtils;
                Either<GDPRConsentInternal> gdprConsentOptimized = consentManagerUtils2.getGdprConsentOptimized();
                if (gdprConsentOptimized instanceof Either.Right) {
                    obj2 = ((Either.Right) gdprConsentOptimized).getR();
                } else {
                    if (!(gdprConsentOptimized instanceof Either.Left)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    obj2 = null;
                }
                GDPRConsentInternal gDPRConsentInternal = (GDPRConsentInternal) obj2;
                consentManagerUtils3 = ConsentManagerImpl.this.consentManagerUtils;
                Either<UsNatConsentInternal> usNatConsent = consentManagerUtils3.getUsNatConsent();
                if (usNatConsent instanceof Either.Right) {
                    obj3 = ((Either.Right) usNatConsent).getR();
                } else {
                    if (!(usNatConsent instanceof Either.Left)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    obj3 = null;
                }
                UsNatConsentInternal usNatConsentInternal = (UsNatConsentInternal) obj3;
                SPConsents sPConsents = new SPConsents(gDPRConsentInternal != null ? new SPGDPRConsent(gDPRConsentInternal) : null, cCPAConsentInternal != null ? new SPCCPAConsent(cCPAConsentInternal) : null, usNatConsentInternal != null ? new SpUsNatConsent(usNatConsentInternal) : null);
                Function1<SPConsents, Unit> sPConsentsSuccess = ConsentManagerImpl.this.getSPConsentsSuccess();
                if (sPConsentsSuccess == null) {
                    return null;
                }
                sPConsentsSuccess.invoke(sPConsents);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.consent.ConsentManager
    public void sendConsent(final ConsentActionImpl actionImpl) {
        Intrinsics.checkNotNullParameter(actionImpl, "actionImpl");
        this.executorManager.executeOnSingleThread(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.consent.ConsentManagerImpl$sendConsent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Service service;
                Env env;
                ClientEventManager clientEventManager;
                service = ConsentManagerImpl.this.service;
                env = ConsentManagerImpl.this.env;
                Either<ChoiceResp> sendConsent = service.sendConsent(env, actionImpl, ConsentManagerImpl.this.getSPConsentsSuccess());
                ConsentManagerImpl consentManagerImpl = ConsentManagerImpl.this;
                boolean z = sendConsent instanceof Either.Right;
                if (z) {
                    clientEventManager = consentManagerImpl.clientEventManager;
                    clientEventManager.registerConsentResponse();
                } else {
                    boolean z2 = sendConsent instanceof Either.Left;
                }
                ConsentManagerImpl consentManagerImpl2 = ConsentManagerImpl.this;
                if (z || !(sendConsent instanceof Either.Left)) {
                    return;
                }
                Throwable t = ((Either.Left) sendConsent).getT();
                Function1<Throwable, Unit> sPConsentsError = consentManagerImpl2.getSPConsentsError();
                if (sPConsentsError != null) {
                    sPConsentsError.invoke(t);
                }
            }
        });
    }
}
