package com.sourcepoint.cmplibrary.data;

import com.ironsource.D5;
import com.sourcepoint.cmplibrary.campaign.CampaignManager;
import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.data.network.NetworkClient;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GdprCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.choice.ChoiceResp;
import com.sourcepoint.cmplibrary.data.network.util.Env;
import com.sourcepoint.cmplibrary.model.ConsentActionImpl;
import com.sourcepoint.cmplibrary.model.CustomConsentReq;
import com.sourcepoint.cmplibrary.model.exposed.SPConsents;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: Service.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eJ\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&JL\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000b0\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000b0\u0014H&J4\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000fH&J\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u001f"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/Service;", "Lcom/sourcepoint/cmplibrary/data/network/NetworkClient;", "Lcom/sourcepoint/cmplibrary/campaign/CampaignManager;", "deleteCustomConsentToServ", "Lcom/sourcepoint/cmplibrary/core/Either;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", "customConsentReq", "Lcom/sourcepoint/cmplibrary/model/CustomConsentReq;", D5.o, "Lcom/sourcepoint/cmplibrary/data/network/util/Env;", "getMessages", "", "messageReq", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesParamReq;", "onSuccess", "Lkotlin/Function1;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesResp;", "showConsent", "Lkotlin/Function0;", "onFailure", "Lkotlin/Function2;", "", "", "sendConsent", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceResp;", MRAIDPresenter.CONSENT_ACTION, "Lcom/sourcepoint/cmplibrary/model/ConsentActionImpl;", "onSpConsentsSuccess", "Lcom/sourcepoint/cmplibrary/model/exposed/SPConsents;", "sendCustomConsentServ", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface Service extends NetworkClient, CampaignManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    Either<GdprCS> deleteCustomConsentToServ(CustomConsentReq customConsentReq, Env env);

    void getMessages(MessagesParamReq messageReq, Function1<? super MessagesResp, Unit> onSuccess, Function0<Unit> showConsent, Function2<? super Throwable, ? super Boolean, Unit> onFailure);

    Either<ChoiceResp> sendConsent(Env env, ConsentActionImpl consentAction, Function1<? super SPConsents, Unit> onSpConsentsSuccess);

    Either<GdprCS> sendCustomConsentServ(CustomConsentReq customConsentReq, Env env);

    /* compiled from: Service.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/Service$Companion;", "", "()V", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
