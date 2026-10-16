package com.sourcepoint.cmplibrary.consent;

import com.sourcepoint.cmplibrary.SpClient;
import com.sourcepoint.cmplibrary.UnitySpClient;
import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.core.ExecutorManager;
import com.sourcepoint.cmplibrary.data.network.connection.ConnectionManager;
import com.sourcepoint.cmplibrary.exception.Logger;
import com.sourcepoint.cmplibrary.model.ConsentActionImpl;
import com.sourcepoint.cmplibrary.model.exposed.ActionType;
import com.sourcepoint.cmplibrary.model.exposed.CCPAConsentInternal;
import com.sourcepoint.cmplibrary.model.exposed.GDPRConsentInternal;
import com.sourcepoint.cmplibrary.model.exposed.NativeMessageActionType;
import com.sourcepoint.cmplibrary.model.exposed.SPCCPAConsent;
import com.sourcepoint.cmplibrary.model.exposed.SPConsents;
import com.sourcepoint.cmplibrary.model.exposed.SPConsentsKt;
import com.sourcepoint.cmplibrary.model.exposed.SPGDPRConsent;
import com.sourcepoint.cmplibrary.model.exposed.SpUsNatConsent;
import com.sourcepoint.cmplibrary.model.exposed.UsNatConsentInternal;
import com.sourcepoint.cmplibrary.util.FunctionalUtilsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClientEventManager.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002J\b\u0010 \u001a\u00020\u001cH\u0016J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u000eH\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/sourcepoint/cmplibrary/consent/ClientEventManagerImpl;", "Lcom/sourcepoint/cmplibrary/consent/ClientEventManager;", "logger", "Lcom/sourcepoint/cmplibrary/exception/Logger;", "executor", "Lcom/sourcepoint/cmplibrary/core/ExecutorManager;", "spClient", "Lcom/sourcepoint/cmplibrary/SpClient;", "consentManagerUtils", "Lcom/sourcepoint/cmplibrary/consent/ConsentManagerUtils;", "connectionManager", "Lcom/sourcepoint/cmplibrary/data/network/connection/ConnectionManager;", "(Lcom/sourcepoint/cmplibrary/exception/Logger;Lcom/sourcepoint/cmplibrary/core/ExecutorManager;Lcom/sourcepoint/cmplibrary/SpClient;Lcom/sourcepoint/cmplibrary/consent/ConsentManagerUtils;Lcom/sourcepoint/cmplibrary/data/network/connection/ConnectionManager;)V", "campaignsToProcess", "", "getConnectionManager", "()Lcom/sourcepoint/cmplibrary/data/network/connection/ConnectionManager;", "getConsentManagerUtils", "()Lcom/sourcepoint/cmplibrary/consent/ConsentManagerUtils;", "getExecutor", "()Lcom/sourcepoint/cmplibrary/core/ExecutorManager;", "isFirstLayerMessage", "", "getLogger", "()Lcom/sourcepoint/cmplibrary/exception/Logger;", "getSpClient", "()Lcom/sourcepoint/cmplibrary/SpClient;", "checkIfAllCampaignsWereProcessed", "", "getSPConsents", "Lcom/sourcepoint/cmplibrary/core/Either;", "Lcom/sourcepoint/cmplibrary/model/exposed/SPConsents;", "registerConsentResponse", "setAction", "action", "Lcom/sourcepoint/cmplibrary/model/ConsentActionImpl;", "Lcom/sourcepoint/cmplibrary/model/exposed/NativeMessageActionType;", "setCampaignsToProcess", "numberOfCampaigns", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
final class ClientEventManagerImpl implements ClientEventManager {
    private int campaignsToProcess;
    private final ConnectionManager connectionManager;
    private final ConsentManagerUtils consentManagerUtils;
    private final ExecutorManager executor;
    private boolean isFirstLayerMessage;
    private final Logger logger;
    private final SpClient spClient;

    public ClientEventManagerImpl(Logger logger, ExecutorManager executor, SpClient spClient, ConsentManagerUtils consentManagerUtils, ConnectionManager connectionManager) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(spClient, "spClient");
        Intrinsics.checkNotNullParameter(consentManagerUtils, "consentManagerUtils");
        Intrinsics.checkNotNullParameter(connectionManager, "connectionManager");
        this.logger = logger;
        this.executor = executor;
        this.spClient = spClient;
        this.consentManagerUtils = consentManagerUtils;
        this.connectionManager = connectionManager;
        this.campaignsToProcess = Integer.MAX_VALUE;
        this.isFirstLayerMessage = true;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final ExecutorManager getExecutor() {
        return this.executor;
    }

    public final SpClient getSpClient() {
        return this.spClient;
    }

    public final ConsentManagerUtils getConsentManagerUtils() {
        return this.consentManagerUtils;
    }

    public final ConnectionManager getConnectionManager() {
        return this.connectionManager;
    }

    @Override // com.sourcepoint.cmplibrary.consent.ClientEventManager
    public void setCampaignsToProcess(int numberOfCampaigns) {
        this.campaignsToProcess = numberOfCampaigns;
    }

    @Override // com.sourcepoint.cmplibrary.consent.ClientEventManager
    public void setAction(final ConsentActionImpl action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.executor.executeOnSingleThread(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.consent.ClientEventManagerImpl$setAction$1

            /* compiled from: ClientEventManager.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ActionType.values().length];
                    try {
                        iArr[ActionType.SHOW_OPTIONS.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ActionType.CUSTOM.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[ActionType.MSG_CANCEL.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[ActionType.PM_DISMISS.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[ActionType.GET_MSG_ERROR.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[ActionType.GET_MSG_NOT_CALLED.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

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
                boolean z;
                int i;
                switch (WhenMappings.$EnumSwitchMapping$0[ConsentActionImpl.this.getActionType().ordinal()]) {
                    case 1:
                        this.isFirstLayerMessage = false;
                        break;
                    case 2:
                    case 3:
                    case 4:
                        z = this.isFirstLayerMessage;
                        if (z) {
                            ClientEventManagerImpl clientEventManagerImpl = this;
                            i = clientEventManagerImpl.campaignsToProcess;
                            clientEventManagerImpl.campaignsToProcess = i - 1;
                        }
                        this.isFirstLayerMessage = true;
                        break;
                    case 5:
                    case 6:
                        this.campaignsToProcess = 0;
                        break;
                }
                this.checkIfAllCampaignsWereProcessed();
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.consent.ClientEventManager
    public void setAction(final NativeMessageActionType action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.executor.executeOnSingleThread(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.consent.ClientEventManagerImpl$setAction$2

            /* compiled from: ClientEventManager.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[NativeMessageActionType.values().length];
                    try {
                        iArr[NativeMessageActionType.ACCEPT_ALL.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[NativeMessageActionType.REJECT_ALL.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[NativeMessageActionType.SHOW_OPTIONS.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[NativeMessageActionType.UNKNOWN.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[NativeMessageActionType.MSG_CANCEL.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[NativeMessageActionType.GET_MSG_ERROR.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    try {
                        iArr[NativeMessageActionType.GET_MSG_NOT_CALLED.ordinal()] = 7;
                    } catch (NoSuchFieldError unused7) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

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
                int i;
                int i2;
                int i3 = WhenMappings.$EnumSwitchMapping$0[NativeMessageActionType.this.ordinal()];
                if (i3 == 5) {
                    i = this.campaignsToProcess;
                    if (i > 0) {
                        ClientEventManagerImpl clientEventManagerImpl = this;
                        i2 = clientEventManagerImpl.campaignsToProcess;
                        clientEventManagerImpl.campaignsToProcess = i2 - 1;
                    }
                } else if (i3 == 6 || i3 == 7) {
                    this.campaignsToProcess = 0;
                }
                this.checkIfAllCampaignsWereProcessed();
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
    
        if (r0 != null) goto L21;
     */
    @Override // com.sourcepoint.cmplibrary.consent.ClientEventManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void checkIfAllCampaignsWereProcessed() {
        Object obj;
        String str;
        if (this.campaignsToProcess <= 0) {
            this.campaignsToProcess = Integer.MAX_VALUE;
            Either<SPConsents> sPConsents = getSPConsents();
            if (sPConsents instanceof Either.Right) {
                obj = ((Either.Right) sPConsents).getR();
            } else {
                if (!(sPConsents instanceof Either.Left)) {
                    throw new NoWhenBranchMatchedException();
                }
                obj = null;
            }
            SPConsents sPConsents2 = (SPConsents) obj;
            if (sPConsents2 != null) {
                this.spClient.onSpFinished(sPConsents2);
                SpClient spClient = this.spClient;
                UnitySpClient unitySpClient = spClient instanceof UnitySpClient ? (UnitySpClient) spClient : null;
                if (unitySpClient != null) {
                    String jSONObject = SPConsentsKt.toJsonObject(sPConsents2).toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
                    unitySpClient.onSpFinished(jSONObject);
                }
                str = SPConsentsKt.toJsonObject(sPConsents2).toString();
            }
            this.spClient.onError(new Throwable("Something went wrong during the consent fetching process."));
            str = "{}";
            this.logger.clientEvent("onSpFinish", "All campaigns have been processed.", str);
        }
    }

    @Override // com.sourcepoint.cmplibrary.consent.ClientEventManager
    public void registerConsentResponse() {
        boolean isConnected = this.connectionManager.isConnected();
        if (isConnected) {
            this.campaignsToProcess--;
        } else {
            if (isConnected) {
                return;
            }
            this.campaignsToProcess = 0;
            checkIfAllCampaignsWereProcessed();
        }
    }

    private final Either<SPConsents> getSPConsents() {
        return FunctionalUtilsKt.check(new Function0<SPConsents>() { // from class: com.sourcepoint.cmplibrary.consent.ClientEventManagerImpl$getSPConsents$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SPConsents invoke() {
                Object obj;
                Object obj2;
                Object obj3;
                Either<GDPRConsentInternal> gdprConsentOptimized = ClientEventManagerImpl.this.getConsentManagerUtils().getGdprConsentOptimized();
                if (gdprConsentOptimized instanceof Either.Right) {
                    obj = ((Either.Right) gdprConsentOptimized).getR();
                } else {
                    if (!(gdprConsentOptimized instanceof Either.Left)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    obj = null;
                }
                GDPRConsentInternal gDPRConsentInternal = (GDPRConsentInternal) obj;
                Either<CCPAConsentInternal> ccpaConsentOptimized = ClientEventManagerImpl.this.getConsentManagerUtils().getCcpaConsentOptimized();
                if (ccpaConsentOptimized instanceof Either.Right) {
                    obj2 = ((Either.Right) ccpaConsentOptimized).getR();
                } else {
                    if (!(ccpaConsentOptimized instanceof Either.Left)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    obj2 = null;
                }
                CCPAConsentInternal cCPAConsentInternal = (CCPAConsentInternal) obj2;
                Either<UsNatConsentInternal> usNatConsent = ClientEventManagerImpl.this.getConsentManagerUtils().getUsNatConsent();
                if (usNatConsent instanceof Either.Right) {
                    obj3 = ((Either.Right) usNatConsent).getR();
                } else {
                    if (!(usNatConsent instanceof Either.Left)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    obj3 = null;
                }
                UsNatConsentInternal usNatConsentInternal = (UsNatConsentInternal) obj3;
                return new SPConsents(gDPRConsentInternal != null ? new SPGDPRConsent(gDPRConsentInternal) : null, cCPAConsentInternal != null ? new SPCCPAConsent(cCPAConsentInternal) : null, usNatConsentInternal != null ? new SpUsNatConsent(usNatConsentInternal) : null);
            }
        });
    }
}
