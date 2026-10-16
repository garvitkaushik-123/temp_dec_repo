package com.sourcepoint.cmplibrary;

import android.content.Context;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.ironsource.D5;
import com.mbridge.msdk.MBridgeConstans;
import com.sourcepoint.cmplibrary.SpConsentLibImpl;
import com.sourcepoint.cmplibrary.SpConsentLibImpl.JSReceiverDelegate;
import com.sourcepoint.cmplibrary.campaign.CampaignManager;
import com.sourcepoint.cmplibrary.consent.ClientEventManager;
import com.sourcepoint.cmplibrary.consent.ConsentManager;
import com.sourcepoint.cmplibrary.consent.CustomConsentClient;
import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.core.ExecutorManager;
import com.sourcepoint.cmplibrary.core.nativemessage.MessageStructure;
import com.sourcepoint.cmplibrary.core.nativemessage.NativeMessageExtKt;
import com.sourcepoint.cmplibrary.core.web.CampaignModel;
import com.sourcepoint.cmplibrary.core.web.IConsentWebView;
import com.sourcepoint.cmplibrary.core.web.JSClientLib;
import com.sourcepoint.cmplibrary.data.Service;
import com.sourcepoint.cmplibrary.data.local.DataStorage;
import com.sourcepoint.cmplibrary.data.network.connection.ConnectionManager;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverter;
import com.sourcepoint.cmplibrary.data.network.model.optimized.CampaignMessage;
import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatusApiModelExtKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GdprCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MessageMetaData;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentData;
import com.sourcepoint.cmplibrary.data.network.util.Env;
import com.sourcepoint.cmplibrary.data.network.util.HttpUrlManager;
import com.sourcepoint.cmplibrary.data.network.util.HttpUrlManagerSingleton;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.exception.ConsentLibExceptionK;
import com.sourcepoint.cmplibrary.exception.Logger;
import com.sourcepoint.cmplibrary.exception.LoggerType;
import com.sourcepoint.cmplibrary.exception.NoInternetConnectionException;
import com.sourcepoint.cmplibrary.exception.RenderingAppException;
import com.sourcepoint.cmplibrary.model.ConsentAction;
import com.sourcepoint.cmplibrary.model.ConsentActionImpl;
import com.sourcepoint.cmplibrary.model.ConsentActionImplKt;
import com.sourcepoint.cmplibrary.model.CustomConsentReq;
import com.sourcepoint.cmplibrary.model.NativeConsentAction;
import com.sourcepoint.cmplibrary.model.PMTab;
import com.sourcepoint.cmplibrary.model.PmUrlConfig;
import com.sourcepoint.cmplibrary.model.exposed.ActionType;
import com.sourcepoint.cmplibrary.model.exposed.MessageSubCategory;
import com.sourcepoint.cmplibrary.model.exposed.MessageType;
import com.sourcepoint.cmplibrary.model.exposed.NativeMessageActionType;
import com.sourcepoint.cmplibrary.model.exposed.SPConsents;
import com.sourcepoint.cmplibrary.model.exposed.SPConsentsKt;
import com.sourcepoint.cmplibrary.model.exposed.SpConfigKt;
import com.sourcepoint.cmplibrary.util.FunctionalUtilsKt;
import com.sourcepoint.cmplibrary.util.SpBackPressOttDelegate;
import com.sourcepoint.cmplibrary.util.SpUtils;
import com.sourcepoint.cmplibrary.util.ThreadUtilsKt;
import com.sourcepoint.cmplibrary.util.ViewsManager;
import com.sourcepoint.cmplibrary.util.extensions.OTTExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import org.json.JSONObject;

/* compiled from: SpConsentLibImpl.kt */
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0002mnBy\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ?\u00103\u001a\u00020*2\f\u00104\u001a\b\u0012\u0004\u0012\u000206052\f\u00107\u001a\b\u0012\u0004\u0012\u000206052\f\u00108\u001a\b\u0012\u0004\u0012\u000206052\u0006\u00109\u001a\u00020:H\u0016¢\u0006\u0002\u0010;JH\u00103\u001a\u00020*2\f\u00104\u001a\b\u0012\u0004\u0012\u0002060<2\f\u00107\u001a\b\u0012\u0004\u0012\u0002060<2\f\u00108\u001a\b\u0012\u0004\u0012\u0002060<2\u0014\u0010=\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010?\u0012\u0004\u0012\u00020*0>H\u0016J?\u0010@\u001a\u00020*2\f\u00104\u001a\b\u0012\u0004\u0012\u000206052\f\u00107\u001a\b\u0012\u0004\u0012\u000206052\f\u00108\u001a\b\u0012\u0004\u0012\u000206052\u0006\u00109\u001a\u00020:H\u0016¢\u0006\u0002\u0010;JH\u0010@\u001a\u00020*2\f\u00104\u001a\b\u0012\u0004\u0012\u0002060<2\f\u00107\u001a\b\u0012\u0004\u0012\u0002060<2\f\u00108\u001a\b\u0012\u0004\u0012\u0002060<2\u0014\u0010=\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010?\u0012\u0004\u0012\u00020*0>H\u0016J\b\u0010A\u001a\u00020*H\u0016J\u001e\u0010B\u001a\u00020*2\u0006\u0010&\u001a\u00020'2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020*0)H\u0016J\u0018\u0010B\u001a\u00020*2\u0006\u0010&\u001a\u00020'2\u0006\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020*H\u0016J\u0010\u0010F\u001a\u00020*2\u0006\u0010G\u001a\u00020HH\u0016J\u0012\u0010F\u001a\u00020*2\b\u0010I\u001a\u0004\u0018\u000106H\u0016J+\u0010F\u001a\u00020*2\b\u0010I\u001a\u0004\u0018\u0001062\b\u0010J\u001a\u0004\u0018\u00010K2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016¢\u0006\u0002\u0010LJ\u0012\u0010F\u001a\u00020*2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J0\u0010M\u001a\u00020*2\u0006\u0010N\u001a\u0002062\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020'H\u0002J\u0018\u0010V\u001a\u00020*2\u0006\u0010N\u001a\u0002062\u0006\u0010Q\u001a\u00020RH\u0016J \u0010V\u001a\u00020*2\u0006\u0010N\u001a\u0002062\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020TH\u0016J \u0010V\u001a\u00020*2\u0006\u0010N\u001a\u0002062\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH\u0016J(\u0010V\u001a\u00020*2\u0006\u0010N\u001a\u0002062\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020TH\u0016J(\u0010V\u001a\u00020*2\u0006\u0010N\u001a\u0002062\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010U\u001a\u00020'H\u0016J0\u0010V\u001a\u00020*2\u0006\u0010N\u001a\u0002062\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010U\u001a\u00020'2\u0006\u0010S\u001a\u00020TH\u0016J+\u0010W\u001a\u00020*2\b\u0010I\u001a\u0004\u0018\u0001062\b\u0010J\u001a\u0004\u0018\u00010K2\b\u0010G\u001a\u0004\u0018\u00010HH\u0002¢\u0006\u0002\u0010LJ&\u0010X\u001a\u00020*2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020#002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010Y\u001a\u00020*2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]H\u0002J\u001f\u0010^\u001a\u00020*2\u0006\u0010_\u001a\u00020`2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0000¢\u0006\u0002\baJ\u0010\u0010b\u001a\u00020*2\u0006\u0010Q\u001a\u00020RH\u0016J\u0010\u0010c\u001a\u00020*2\u0006\u0010d\u001a\u00020eH\u0016J\u0010\u0010f\u001a\u00020*2\u0006\u0010d\u001a\u00020eH\u0016J\u0018\u0010g\u001a\u00020*2\u0006\u0010Z\u001a\u00020h2\u0006\u0010Q\u001a\u00020RH\u0016J\u0010\u0010i\u001a\u00020*2\u0006\u0010d\u001a\u00020eH\u0016J\u0018\u0010j\u001a\u00020*2\u0006\u0010_\u001a\u00020`2\u0006\u0010\\\u001a\u00020]H\u0002J\u0018\u0010k\u001a\u00020*2\u0006\u0010Q\u001a\u00020R2\u0006\u0010N\u001a\u000206H\u0016J\u0010\u0010l\u001a\u00020*2\u0006\u0010d\u001a\u00020eH\u0016R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020#00X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006o"}, d2 = {"Lcom/sourcepoint/cmplibrary/SpConsentLibImpl;", "Lcom/sourcepoint/cmplibrary/SpConsentLib;", "Lcom/sourcepoint/cmplibrary/NativeMessageController;", "context", "Landroid/content/Context;", "pLogger", "Lcom/sourcepoint/cmplibrary/exception/Logger;", "pJsonConverter", "Lcom/sourcepoint/cmplibrary/data/network/converter/JsonConverter;", NotificationCompat.CATEGORY_SERVICE, "Lcom/sourcepoint/cmplibrary/data/Service;", "executor", "Lcom/sourcepoint/cmplibrary/core/ExecutorManager;", "viewManager", "Lcom/sourcepoint/cmplibrary/util/ViewsManager;", "campaignManager", "Lcom/sourcepoint/cmplibrary/campaign/CampaignManager;", "consentManager", "Lcom/sourcepoint/cmplibrary/consent/ConsentManager;", "dataStorage", "Lcom/sourcepoint/cmplibrary/data/local/DataStorage;", "spClient", "Lcom/sourcepoint/cmplibrary/SpClient;", "clientEventManager", "Lcom/sourcepoint/cmplibrary/consent/ClientEventManager;", "urlManager", "Lcom/sourcepoint/cmplibrary/data/network/util/HttpUrlManager;", D5.o, "Lcom/sourcepoint/cmplibrary/data/network/util/Env;", "connectionManager", "Lcom/sourcepoint/cmplibrary/data/network/connection/ConnectionManager;", "(Landroid/content/Context;Lcom/sourcepoint/cmplibrary/exception/Logger;Lcom/sourcepoint/cmplibrary/data/network/converter/JsonConverter;Lcom/sourcepoint/cmplibrary/data/Service;Lcom/sourcepoint/cmplibrary/core/ExecutorManager;Lcom/sourcepoint/cmplibrary/util/ViewsManager;Lcom/sourcepoint/cmplibrary/campaign/CampaignManager;Lcom/sourcepoint/cmplibrary/consent/ConsentManager;Lcom/sourcepoint/cmplibrary/data/local/DataStorage;Lcom/sourcepoint/cmplibrary/SpClient;Lcom/sourcepoint/cmplibrary/consent/ClientEventManager;Lcom/sourcepoint/cmplibrary/data/network/util/HttpUrlManager;Lcom/sourcepoint/cmplibrary/data/network/util/Env;Lcom/sourcepoint/cmplibrary/data/network/connection/ConnectionManager;)V", "getContext$cmplibrary_release", "()Landroid/content/Context;", "currentNativeMessageCampaign", "Lcom/sourcepoint/cmplibrary/core/web/CampaignModel;", "getExecutor$cmplibrary_release", "()Lcom/sourcepoint/cmplibrary/core/ExecutorManager;", "isMessageDismissible", "", "onHomeCallback", "Lkotlin/Function0;", "", "getPJsonConverter$cmplibrary_release", "()Lcom/sourcepoint/cmplibrary/data/network/converter/JsonConverter;", "getPLogger$cmplibrary_release", "()Lcom/sourcepoint/cmplibrary/exception/Logger;", "remainingCampaigns", "Ljava/util/Queue;", "getService$cmplibrary_release", "()Lcom/sourcepoint/cmplibrary/data/Service;", "customConsentGDPR", "vendors", "", "", "categories", "legIntCategories", "successCallback", "Lcom/sourcepoint/cmplibrary/consent/CustomConsentClient;", "([Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;Lcom/sourcepoint/cmplibrary/consent/CustomConsentClient;)V", "", "success", "Lkotlin/Function1;", "Lcom/sourcepoint/cmplibrary/model/exposed/SPConsents;", "deleteCustomConsentTo", "dispose", "handleOnBackPress", "onHomePage", "ottDelegate", "Lcom/sourcepoint/cmplibrary/util/SpBackPressOttDelegate;", "loadMessage", "cmpViewId", "", "authId", "pubData", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/Integer;)V", "loadPm", "pmId", "pmTab", "Lcom/sourcepoint/cmplibrary/model/PMTab;", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "messageType", "Lcom/sourcepoint/cmplibrary/model/exposed/MessageType;", "useGroupPmIfAvailable", "loadPrivacyManager", "localLoadMessage", "moveToNextCampaign", "nativeMessageShowOption", "action", "Lcom/sourcepoint/cmplibrary/model/NativeConsentAction;", "iConsentWebView", "Lcom/sourcepoint/cmplibrary/core/web/IConsentWebView;", "onActionFromWebViewClient", "actionImpl", "Lcom/sourcepoint/cmplibrary/model/ConsentActionImpl;", "onActionFromWebViewClient$cmplibrary_release", "rejectAll", "removeNativeView", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/view/View;", "removeView", "sendConsent", "Lcom/sourcepoint/cmplibrary/model/exposed/NativeMessageActionType;", "showNativeView", "showOption", "showOptionNativeMessage", "showView", "Companion", "JSReceiverDelegate", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SpConsentLibImpl implements SpConsentLib, NativeMessageController {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CampaignManager campaignManager;
    private final ClientEventManager clientEventManager;
    private final ConnectionManager connectionManager;
    private final ConsentManager consentManager;
    private final Context context;
    private CampaignModel currentNativeMessageCampaign;
    private final DataStorage dataStorage;
    private final Env env;
    private final ExecutorManager executor;
    private boolean isMessageDismissible;
    private Function0<Unit> onHomeCallback;
    private final JsonConverter pJsonConverter;
    private final Logger pLogger;
    private final Queue<CampaignModel> remainingCampaigns;
    private final Service service;
    private final SpClient spClient;
    private final HttpUrlManager urlManager;
    private final ViewsManager viewManager;

    /* compiled from: SpConsentLibImpl.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[CampaignType.values().length];
            try {
                iArr[CampaignType.GDPR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CampaignType.CCPA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CampaignType.USNAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ActionType.values().length];
            try {
                iArr2[ActionType.ACCEPT_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ActionType.SAVE_AND_EXIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ActionType.REJECT_ALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ActionType.SHOW_OPTIONS.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ActionType.CUSTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[ActionType.MSG_CANCEL.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[ActionType.PM_DISMISS.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[NativeMessageActionType.values().length];
            try {
                iArr3[NativeMessageActionType.SHOW_OPTIONS.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[NativeMessageActionType.UNKNOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[NativeMessageActionType.MSG_CANCEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[NativeMessageActionType.ACCEPT_ALL.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr3[NativeMessageActionType.REJECT_ALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[MessageSubCategory.values().length];
            try {
                iArr4[MessageSubCategory.NATIVE_IN_APP.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr4[MessageSubCategory.TCFv2.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr4[MessageSubCategory.OTT.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr4[MessageSubCategory.NATIVE_OTT.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    public SpConsentLibImpl(Context context, Logger pLogger, JsonConverter pJsonConverter, Service service, ExecutorManager executor, ViewsManager viewManager, CampaignManager campaignManager, ConsentManager consentManager, DataStorage dataStorage, SpClient spClient, ClientEventManager clientEventManager, HttpUrlManager urlManager, Env env, ConnectionManager connectionManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pLogger, "pLogger");
        Intrinsics.checkNotNullParameter(pJsonConverter, "pJsonConverter");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        Intrinsics.checkNotNullParameter(campaignManager, "campaignManager");
        Intrinsics.checkNotNullParameter(consentManager, "consentManager");
        Intrinsics.checkNotNullParameter(dataStorage, "dataStorage");
        Intrinsics.checkNotNullParameter(spClient, "spClient");
        Intrinsics.checkNotNullParameter(clientEventManager, "clientEventManager");
        Intrinsics.checkNotNullParameter(urlManager, "urlManager");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(connectionManager, "connectionManager");
        this.context = context;
        this.pLogger = pLogger;
        this.pJsonConverter = pJsonConverter;
        this.service = service;
        this.executor = executor;
        this.viewManager = viewManager;
        this.campaignManager = campaignManager;
        this.consentManager = consentManager;
        this.dataStorage = dataStorage;
        this.spClient = spClient;
        this.clientEventManager = clientEventManager;
        this.urlManager = urlManager;
        this.env = env;
        this.connectionManager = connectionManager;
        this.remainingCampaigns = new LinkedList();
        consentManager.setSPConsentsSuccess(new Function1<SPConsents, Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SPConsents sPConsents) {
                invoke2(sPConsents);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final SPConsents spConsents) {
                Intrinsics.checkNotNullParameter(spConsents, "spConsents");
                final String jSONObject = SPConsentsKt.toJsonObject(spConsents).toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
                ExecutorManager executor2 = SpConsentLibImpl.this.getExecutor();
                final SpConsentLibImpl spConsentLibImpl = SpConsentLibImpl.this;
                executor2.executeOnMain(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl.1.1
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
                        SpConsentLibImpl.this.getPLogger().clientEvent("onConsentReady", "onConsentReady", jSONObject);
                        SpConsentLibImpl.this.spClient.onConsentReady(spConsents);
                        SpClient spClient2 = SpConsentLibImpl.this.spClient;
                        UnitySpClient unitySpClient = spClient2 instanceof UnitySpClient ? (UnitySpClient) spClient2 : null;
                        if (unitySpClient != null) {
                            unitySpClient.onConsentReady(jSONObject);
                        }
                        ExecutorManager executor3 = SpConsentLibImpl.this.getExecutor();
                        final SpConsentLibImpl spConsentLibImpl2 = SpConsentLibImpl.this;
                        executor3.executeOnSingleThread(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl.1.1.1
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
                                SpConsentLibImpl.this.clientEventManager.checkIfAllCampaignsWereProcessed();
                            }
                        });
                    }
                });
            }
        });
        consentManager.setSPConsentsError(new Function1<Throwable, Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final Throwable throwable) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                throwable.printStackTrace();
                ExecutorManager executor2 = SpConsentLibImpl.this.getExecutor();
                final SpConsentLibImpl spConsentLibImpl = SpConsentLibImpl.this;
                executor2.executeOnMain(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl.2.1
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
                        SpConsentLibImpl.this.spClient.onError(throwable);
                        SpConsentLibImpl.this.getPLogger().clientEvent("onError", String.valueOf(throwable.getMessage()), String.valueOf(throwable.getMessage()));
                    }
                });
            }
        });
    }

    /* renamed from: getContext$cmplibrary_release, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    /* renamed from: getPLogger$cmplibrary_release, reason: from getter */
    public final Logger getPLogger() {
        return this.pLogger;
    }

    /* renamed from: getPJsonConverter$cmplibrary_release, reason: from getter */
    public final JsonConverter getPJsonConverter() {
        return this.pJsonConverter;
    }

    /* renamed from: getService$cmplibrary_release, reason: from getter */
    public final Service getService() {
        return this.service;
    }

    /* renamed from: getExecutor$cmplibrary_release, reason: from getter */
    public final ExecutorManager getExecutor() {
        return this.executor;
    }

    public /* synthetic */ SpConsentLibImpl(Context context, Logger logger, JsonConverter jsonConverter, Service service, ExecutorManager executorManager, ViewsManager viewsManager, CampaignManager campaignManager, ConsentManager consentManager, DataStorage dataStorage, SpClient spClient, ClientEventManager clientEventManager, HttpUrlManager httpUrlManager, Env env, ConnectionManager connectionManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, logger, jsonConverter, service, executorManager, viewsManager, campaignManager, consentManager, dataStorage, spClient, clientEventManager, (i & 2048) != 0 ? HttpUrlManagerSingleton.INSTANCE : httpUrlManager, (i & 4096) != 0 ? Env.PROD : env, connectionManager);
    }

    /* compiled from: SpConsentLibImpl.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/sourcepoint/cmplibrary/SpConsentLibImpl$Companion;", "", "()V", "toCampaignModelList", "", "Lcom/sourcepoint/cmplibrary/core/web/CampaignModel;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesResp;", "logger", "Lcom/sourcepoint/cmplibrary/exception/Logger;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<CampaignModel> toCampaignModelList(MessagesResp messagesResp, Logger logger) {
            Intrinsics.checkNotNullParameter(messagesResp, "<this>");
            Intrinsics.checkNotNullParameter(logger, "logger");
            List<CampaignMessage> campaignList = messagesResp.getCampaignList();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = campaignList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                CampaignMessage campaignMessage = (CampaignMessage) next;
                if (campaignMessage.getMessage() != null && campaignMessage.getUrl() != null) {
                    MessageMetaData messageMetaData = campaignMessage.getMessageMetaData();
                    if ((messageMetaData != null ? messageMetaData.getSubCategoryId() : null) != null) {
                        arrayList.add(next);
                    }
                }
                arrayList2.add(next);
            }
            Pair pair = new Pair(arrayList, arrayList2);
            logger.computation("toCampaignModelList", "parsed campaigns" + LoggerType.NL.getT() + ((List) pair.getSecond()).size() + " Null messages" + LoggerType.NL.getT() + ((List) pair.getFirst()).size() + " Not Null message");
            if (campaignList.isEmpty()) {
                return CollectionsKt.emptyList();
            }
            Iterable<CampaignMessage> iterable = (Iterable) pair.getFirst();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (CampaignMessage campaignMessage2 : iterable) {
                JSONObject jSONObject = new JSONObject(String.valueOf(campaignMessage2.getMessage()));
                JSONObject jSONObject2 = new JSONObject(String.valueOf(campaignMessage2.getMessageMetaData()));
                CampaignType type = campaignMessage2.getType();
                HttpUrl.Companion companion = HttpUrl.INSTANCE;
                String url = campaignMessage2.getUrl();
                Intrinsics.checkNotNull(url);
                HttpUrl httpUrl = companion.get(url);
                MessageMetaData messageMetaData2 = campaignMessage2.getMessageMetaData();
                MessageSubCategory subCategoryId = messageMetaData2 != null ? messageMetaData2.getSubCategoryId() : null;
                Intrinsics.checkNotNull(subCategoryId);
                arrayList3.add(new CampaignModel(jSONObject, jSONObject2, type, httpUrl, subCategoryId));
            }
            return arrayList3;
        }
    }

    @Override // com.sourcepoint.cmplibrary.SpConsentLib
    public void loadMessage() {
        localLoadMessage(null, null, null);
    }

    @Override // com.sourcepoint.cmplibrary.SpConsentLib
    public void loadMessage(int cmpViewId) {
        localLoadMessage(null, null, Integer.valueOf(cmpViewId));
    }

    @Override // com.sourcepoint.cmplibrary.SpConsentLib
    public void loadMessage(String authId, JSONObject pubData, Integer cmpViewId) {
        localLoadMessage(authId, pubData, cmpViewId);
    }

    @Override // com.sourcepoint.cmplibrary.SpConsentLib
    public void loadMessage(JSONObject pubData) {
        localLoadMessage(null, pubData, null);
    }

    @Override // com.sourcepoint.cmplibrary.SpConsentLib
    public void loadMessage(String authId) {
        localLoadMessage(authId, null, null);
    }

    private final void localLoadMessage(final String authId, final JSONObject pubData, final Integer cmpViewId) {
        Object obj;
        Either check = FunctionalUtilsKt.check(new Function0<MessagesParamReq>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl$localLoadMessage$param$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MessagesParamReq invoke() {
                CampaignManager campaignManager;
                campaignManager = SpConsentLibImpl.this.campaignManager;
                return campaignManager.getMessageOptimizedReq(authId, pubData);
            }
        });
        boolean z = check instanceof Either.Right;
        if (!z && (check instanceof Either.Left)) {
            Throwable t = ((Either.Left) check).getT();
            Logger logger = this.pLogger;
            String simpleName = getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            String message = t.getMessage();
            if (message == null) {
                message = ExceptionsKt.stackTraceToString(t);
            }
            logger.e(simpleName, message);
            this.spClient.onError(t);
        }
        if (z) {
            obj = ((Either.Right) check).getR();
        } else {
            if (!(check instanceof Either.Left)) {
                throw new NoWhenBranchMatchedException();
            }
            obj = null;
        }
        MessagesParamReq messagesParamReq = (MessagesParamReq) obj;
        if (messagesParamReq == null) {
            return;
        }
        this.service.getMessages(messagesParamReq, new Function1<MessagesResp, Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl$localLoadMessage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MessagesResp messagesResp) {
                invoke2(messagesResp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MessagesResp it) {
                Queue queue;
                ConsentManager consentManager;
                Intrinsics.checkNotNullParameter(it, "it");
                List<CampaignModel> campaignModelList = SpConsentLibImpl.INSTANCE.toCampaignModelList(it, SpConsentLibImpl.this.getPLogger());
                SpConsentLibImpl.this.clientEventManager.setCampaignsToProcess(campaignModelList.size());
                if (campaignModelList.isEmpty()) {
                    consentManager = SpConsentLibImpl.this.consentManager;
                    consentManager.sendStoredConsentToClient();
                    return;
                }
                final CampaignModel campaignModel = (CampaignModel) CollectionsKt.first((List) campaignModelList);
                queue = SpConsentLibImpl.this.remainingCampaigns;
                queue.clear();
                queue.addAll(new LinkedList(CollectionsKt.drop(campaignModelList, 1)));
                ExecutorManager executor = SpConsentLibImpl.this.getExecutor();
                final SpConsentLibImpl spConsentLibImpl = SpConsentLibImpl.this;
                final Integer num = cmpViewId;
                executor.executeOnMain(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl$localLoadMessage$1.2

                    /* compiled from: SpConsentLibImpl.kt */
                    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                    /* renamed from: com.sourcepoint.cmplibrary.SpConsentLibImpl$localLoadMessage$1$2$WhenMappings */
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[MessageSubCategory.values().length];
                            try {
                                iArr[MessageSubCategory.TCFv2.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[MessageSubCategory.OTT.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            try {
                                iArr[MessageSubCategory.NATIVE_OTT.ordinal()] = 3;
                            } catch (NoSuchFieldError unused3) {
                            }
                            try {
                                iArr[MessageSubCategory.NATIVE_IN_APP.ordinal()] = 4;
                            } catch (NoSuchFieldError unused4) {
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
                        Queue<CampaignModel> queue2;
                        Object obj2;
                        DataStorage dataStorage;
                        CampaignType type = CampaignModel.this.getType();
                        int i = WhenMappings.$EnumSwitchMapping$0[CampaignModel.this.getMessageSubCategory().ordinal()];
                        if (i != 1 && i != 2 && i != 3) {
                            if (i != 4) {
                                return;
                            }
                            JSONObject message2 = CampaignModel.this.getMessage();
                            dataStorage = spConsentLibImpl.dataStorage;
                            MessageStructure nativeMessageDTO = NativeMessageExtKt.toNativeMessageDTO(message2, type, dataStorage);
                            spConsentLibImpl.currentNativeMessageCampaign = CampaignModel.this;
                            spConsentLibImpl.spClient.onNativeMessageReady(nativeMessageDTO, spConsentLibImpl);
                            spConsentLibImpl.getPLogger().nativeMessageAction("onNativeMessageReady", "onNativeMessageReady", CampaignModel.this.getMessage());
                            return;
                        }
                        ViewsManager viewsManager = spConsentLibImpl.viewManager;
                        SpConsentLibImpl spConsentLibImpl2 = spConsentLibImpl;
                        SpConsentLibImpl.JSReceiverDelegate jSReceiverDelegate = spConsentLibImpl.new JSReceiverDelegate();
                        queue2 = spConsentLibImpl.remainingCampaigns;
                        Either<IConsentWebView> createWebView = viewsManager.createWebView(spConsentLibImpl2, jSReceiverDelegate, queue2, SpConfigKt.toMessageType(CampaignModel.this.getMessageSubCategory()), num);
                        SpConsentLibImpl spConsentLibImpl3 = spConsentLibImpl;
                        boolean z2 = createWebView instanceof Either.Right;
                        if (!z2 && (createWebView instanceof Either.Left)) {
                            spConsentLibImpl3.spClient.onError(((Either.Left) createWebView).getT());
                        }
                        if (z2) {
                            obj2 = ((Either.Right) createWebView).getR();
                        } else {
                            if (!(createWebView instanceof Either.Left)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            obj2 = null;
                        }
                        IConsentWebView iConsentWebView = (IConsentWebView) obj2;
                        HttpUrl url = CampaignModel.this.getUrl();
                        if (iConsentWebView != null) {
                            iConsentWebView.loadConsentUI(CampaignModel.this, url, type);
                        }
                    }
                });
            }
        }, new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl$localLoadMessage$2
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
                ConsentManager consentManager;
                consentManager = SpConsentLibImpl.this.consentManager;
                consentManager.sendStoredConsentToClient();
                SpConsentLibImpl.this.clientEventManager.setAction(NativeMessageActionType.GET_MSG_NOT_CALLED);
            }
        }, new Function2<Throwable, Boolean, Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl$localLoadMessage$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th, Boolean bool) {
                invoke(th, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable error, boolean z2) {
                ConsentManager consentManager;
                Intrinsics.checkNotNullParameter(error, "error");
                consentManager = SpConsentLibImpl.this.consentManager;
                if (consentManager.getHasStoredConsent()) {
                    ExecutorManager executor = SpConsentLibImpl.this.getExecutor();
                    final SpConsentLibImpl spConsentLibImpl = SpConsentLibImpl.this;
                    executor.executeOnSingleThread(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl$localLoadMessage$3.1
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
                            ConsentManager consentManager2;
                            consentManager2 = SpConsentLibImpl.this.consentManager;
                            consentManager2.sendStoredConsentToClient();
                            SpConsentLibImpl.this.clientEventManager.setAction(NativeMessageActionType.GET_MSG_ERROR);
                        }
                    });
                    return;
                }
                ConsentLibExceptionK consentLibExceptionK = error instanceof ConsentLibExceptionK ? (ConsentLibExceptionK) error : null;
                if (consentLibExceptionK != null) {
                    SpConsentLibImpl.this.getPLogger().error(consentLibExceptionK);
                }
                ConsentLibExceptionK consentLibException$default = FunctionalUtilsKt.toConsentLibException$default(error, null, 1, null);
                if (z2) {
                    SpConsentLibImpl.this.spClient.onError(consentLibException$default);
                }
                SpConsentLibImpl.this.getPLogger().clientEvent("onError", consentLibException$default.getCode(), String.valueOf(error.getMessage()));
                SpConsentLibImpl.this.getPLogger().e("SpConsentLib", StringsKt.trimIndent("\n                            onError\n                            " + error.getMessage() + "\n                        "));
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.SpConsentLib
    public void customConsentGDPR(List<String> vendors, List<String> categories, List<String> legIntCategories, final Function1<? super SPConsents, Unit> success) {
        Intrinsics.checkNotNullParameter(vendors, "vendors");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(legIntCategories, "legIntCategories");
        Intrinsics.checkNotNullParameter(success, "success");
        String gdprUuid = this.campaignManager.getGdprUuid();
        if (gdprUuid == null) {
            gdprUuid = "";
        }
        final CustomConsentReq customConsentReq = new CustomConsentReq(gdprUuid, this.campaignManager.getSpConfig().propertyId, vendors, categories, legIntCategories);
        final ExecutorManager executorManager = this.executor;
        executorManager.executeOnWorkerThread(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl$customConsentGDPR$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                Env env;
                Service service = SpConsentLibImpl.this.getService();
                CustomConsentReq customConsentReq2 = customConsentReq;
                env = SpConsentLibImpl.this.env;
                final Either<GdprCS> sendCustomConsentServ = service.sendCustomConsentServ(customConsentReq2, env);
                ExecutorManager executorManager2 = executorManager;
                final Function1<SPConsents, Unit> function1 = success;
                final SpConsentLibImpl spConsentLibImpl = SpConsentLibImpl.this;
                executorManager2.executeOnMain(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl$customConsentGDPR$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        Either<GdprCS> either = sendCustomConsentServ;
                        if (either instanceof Either.Right) {
                            function1.invoke(SpUtils.userConsents(spConsentLibImpl.getContext()));
                        } else if (either instanceof Either.Left) {
                            spConsentLibImpl.spClient.onError(((Either.Left) sendCustomConsentServ).getT());
                            spConsentLibImpl.getPLogger().clientEvent("onError", String.valueOf(((Either.Left) sendCustomConsentServ).getT().getMessage()), String.valueOf(((Either.Left) sendCustomConsentServ).getT()));
                        }
                    }
                });
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.SpConsentLib
    public void deleteCustomConsentTo(List<String> vendors, List<String> categories, List<String> legIntCategories, final Function1<? super SPConsents, Unit> success) {
        Intrinsics.checkNotNullParameter(vendors, "vendors");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(legIntCategories, "legIntCategories");
        Intrinsics.checkNotNullParameter(success, "success");
        String gdprUuid = this.campaignManager.getGdprUuid();
        if (gdprUuid == null) {
            gdprUuid = "";
        }
        final CustomConsentReq customConsentReq = new CustomConsentReq(gdprUuid, this.campaignManager.getSpConfig().propertyId, vendors, categories, legIntCategories);
        final ExecutorManager executorManager = this.executor;
        executorManager.executeOnWorkerThread(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl$deleteCustomConsentTo$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                Env env;
                Service service = SpConsentLibImpl.this.getService();
                CustomConsentReq customConsentReq2 = customConsentReq;
                env = SpConsentLibImpl.this.env;
                final Either<GdprCS> deleteCustomConsentToServ = service.deleteCustomConsentToServ(customConsentReq2, env);
                ExecutorManager executorManager2 = executorManager;
                final Function1<SPConsents, Unit> function1 = success;
                final SpConsentLibImpl spConsentLibImpl = SpConsentLibImpl.this;
                executorManager2.executeOnMain(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl$deleteCustomConsentTo$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        Either<GdprCS> either = deleteCustomConsentToServ;
                        if (either instanceof Either.Right) {
                            function1.invoke(SpUtils.userConsents(spConsentLibImpl.getContext()));
                        } else if (either instanceof Either.Left) {
                            spConsentLibImpl.spClient.onError(((Either.Left) deleteCustomConsentToServ).getT());
                            spConsentLibImpl.getPLogger().clientEvent("onError", String.valueOf(((Either.Left) deleteCustomConsentToServ).getT().getMessage()), String.valueOf(((Either.Left) deleteCustomConsentToServ).getT()));
                        }
                    }
                });
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.SpConsentLib
    public void customConsentGDPR(String[] vendors, String[] categories, String[] legIntCategories, final CustomConsentClient successCallback) {
        Intrinsics.checkNotNullParameter(vendors, "vendors");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(legIntCategories, "legIntCategories");
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        customConsentGDPR(ArraysKt.toList(vendors), ArraysKt.toList(categories), ArraysKt.toList(legIntCategories), new Function1<SPConsents, Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl$customConsentGDPR$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SPConsents sPConsents) {
                invoke2(sPConsents);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final SPConsents sPConsents) {
                if (sPConsents != null) {
                    CustomConsentClient customConsentClient = successCallback;
                    Either.Right check = FunctionalUtilsKt.check(new Function0<String>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl$customConsentGDPR$2$1$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return SPConsentsKt.toJsonObject(SPConsents.this).toString();
                        }
                    });
                    if (check instanceof Either.Right) {
                        String str = (String) ((Either.Right) check).getR();
                        Intrinsics.checkNotNull(str);
                        customConsentClient.transferCustomConsentToUnity(str);
                        check = new Either.Right(Unit.INSTANCE);
                    } else if (!(check instanceof Either.Left)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (check != null) {
                        return;
                    }
                }
                SpConsentLibImpl spConsentLibImpl = SpConsentLibImpl.this;
                spConsentLibImpl.spClient.onError(new RuntimeException("An error occurred during the custom consent request"));
                spConsentLibImpl.getPLogger().clientEvent("onError", "An error occurred during the custom consent request", "An error occurred during the custom consent request");
                Unit unit = Unit.INSTANCE;
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.SpConsentLib
    public void deleteCustomConsentTo(String[] vendors, String[] categories, String[] legIntCategories, final CustomConsentClient successCallback) {
        Intrinsics.checkNotNullParameter(vendors, "vendors");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(legIntCategories, "legIntCategories");
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        deleteCustomConsentTo(ArraysKt.toList(vendors), ArraysKt.toList(categories), ArraysKt.toList(legIntCategories), new Function1<SPConsents, Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl$deleteCustomConsentTo$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SPConsents sPConsents) {
                invoke2(sPConsents);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final SPConsents sPConsents) {
                if (sPConsents != null) {
                    CustomConsentClient customConsentClient = successCallback;
                    Either.Right check = FunctionalUtilsKt.check(new Function0<String>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl$deleteCustomConsentTo$2$1$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return SPConsentsKt.toJsonObject(SPConsents.this).toString();
                        }
                    });
                    if (check instanceof Either.Right) {
                        String str = (String) ((Either.Right) check).getR();
                        Intrinsics.checkNotNull(str);
                        customConsentClient.transferCustomConsentToUnity(str);
                        check = new Either.Right(Unit.INSTANCE);
                    } else if (!(check instanceof Either.Left)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (check != null) {
                        return;
                    }
                }
                SpConsentLibImpl spConsentLibImpl = SpConsentLibImpl.this;
                spConsentLibImpl.spClient.onError(new RuntimeException("An error occurred during delete custom consent request"));
                spConsentLibImpl.getPLogger().clientEvent("onError", "An error occurred during delete custom consent request", "An error occurred during delete custom consent request");
                Unit unit = Unit.INSTANCE;
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.SpConsentLib
    public void loadPrivacyManager(String pmId, PMTab pmTab, CampaignType campaignType, MessageType messageType) {
        Intrinsics.checkNotNullParameter(pmId, "pmId");
        Intrinsics.checkNotNullParameter(pmTab, "pmTab");
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        loadPm(pmId, pmTab, campaignType, messageType, false);
    }

    @Override // com.sourcepoint.cmplibrary.SpConsentLib
    public void loadPrivacyManager(String pmId, PMTab pmTab, CampaignType campaignType) {
        Intrinsics.checkNotNullParameter(pmId, "pmId");
        Intrinsics.checkNotNullParameter(pmTab, "pmTab");
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        loadPm(pmId, pmTab, campaignType, OTTExtKt.toMessageType(this.context), false);
    }

    @Override // com.sourcepoint.cmplibrary.SpConsentLib
    public void loadPrivacyManager(String pmId, PMTab pmTab, CampaignType campaignType, boolean useGroupPmIfAvailable, MessageType messageType) {
        Intrinsics.checkNotNullParameter(pmId, "pmId");
        Intrinsics.checkNotNullParameter(pmTab, "pmTab");
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        loadPm(pmId, pmTab, campaignType, messageType, useGroupPmIfAvailable);
    }

    @Override // com.sourcepoint.cmplibrary.SpConsentLib
    public void loadPrivacyManager(String pmId, PMTab pmTab, CampaignType campaignType, boolean useGroupPmIfAvailable) {
        Intrinsics.checkNotNullParameter(pmId, "pmId");
        Intrinsics.checkNotNullParameter(pmTab, "pmTab");
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        loadPm(pmId, pmTab, campaignType, OTTExtKt.toMessageType(this.context), useGroupPmIfAvailable);
    }

    @Override // com.sourcepoint.cmplibrary.SpConsentLib
    public void loadPrivacyManager(String pmId, CampaignType campaignType, MessageType messageType) {
        Intrinsics.checkNotNullParameter(pmId, "pmId");
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        loadPm(pmId, PMTab.DEFAULT, campaignType, messageType, false);
    }

    @Override // com.sourcepoint.cmplibrary.SpConsentLib
    public void loadPrivacyManager(String pmId, CampaignType campaignType) {
        Intrinsics.checkNotNullParameter(pmId, "pmId");
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        loadPm(pmId, PMTab.DEFAULT, campaignType, OTTExtKt.toMessageType(this.context), false);
    }

    private final void loadPm(String pmId, PMTab pmTab, CampaignType campaignType, MessageType messageType, boolean useGroupPmIfAvailable) {
        Object obj;
        String gdprConsentStatus;
        if (!this.connectionManager.isConnected()) {
            this.spClient.onError(new NoInternetConnectionException(null, null, false, 7, null));
            return;
        }
        ThreadUtilsKt.checkMainThread("loadPrivacyManager");
        this.clientEventManager.setCampaignsToProcess(1);
        String groupId = this.campaignManager.getGroupId(campaignType);
        this.pLogger.i("loadPm - messSubCat: ", messageType.name());
        Either.Right pmConfig = this.campaignManager.getPmConfig(campaignType, pmId, pmTab, useGroupPmIfAvailable, groupId);
        if (pmConfig instanceof Either.Right) {
            PmUrlConfig pmUrlConfig = (PmUrlConfig) ((Either.Right) pmConfig).getR();
            Either<IConsentWebView> createWebView = this.viewManager.createWebView(this, new JSReceiverDelegate(), messageType, null);
            boolean z = createWebView instanceof Either.Right;
            if (!z && (createWebView instanceof Either.Left)) {
                this.spClient.onError(((Either.Left) createWebView).getT());
            }
            if (z) {
                obj = ((Either.Right) createWebView).getR();
            } else {
                if (!(createWebView instanceof Either.Left)) {
                    throw new NoWhenBranchMatchedException();
                }
                obj = null;
            }
            IConsentWebView iConsentWebView = (IConsentWebView) obj;
            HttpUrl pmUrl = this.urlManager.pmUrl(this.env, campaignType, pmUrlConfig, messageType);
            this.pLogger.pm(campaignType.name() + " Privacy Manager", pmUrl.getUrl(), "GET", StringsKt.trimIndent("\n                        pmId [" + pmUrlConfig.getMessageId() + "]\n                        consentLanguage [" + pmUrlConfig.getConsentLanguage() + "]\n                        pmTab [" + pmUrlConfig.getPmTab() + "]\n                        siteId [" + pmUrlConfig.getSiteId() + "]\n                    "));
            int i = WhenMappings.$EnumSwitchMapping$0[campaignType.ordinal()];
            if (i == 1) {
                gdprConsentStatus = this.dataStorage.getGdprConsentStatus();
            } else if (i == 2) {
                gdprConsentStatus = this.dataStorage.getCcpaConsentStatus();
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                USNatConsentData usNatConsentData = this.campaignManager.getUsNatConsentData();
                gdprConsentStatus = usNatConsentData != null ? ConsentStatusApiModelExtKt.stringify(usNatConsentData) : null;
            }
            pmConfig = new Either.Right(iConsentWebView != null ? iConsentWebView.loadConsentUIFromUrlPreloadingOption(pmUrl, campaignType, pmUrlConfig.getMessageId(), gdprConsentStatus) : null);
        } else if (!(pmConfig instanceof Either.Left)) {
            throw new NoWhenBranchMatchedException();
        }
        if ((pmConfig instanceof Either.Right) || !(pmConfig instanceof Either.Left)) {
            return;
        }
        ((Either.Left) pmConfig).getT();
        Logger logger = this.pLogger;
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        logger.d(simpleName, "PmUrlConfig is null");
    }

    @Override // com.sourcepoint.cmplibrary.SpConsentLib
    public void rejectAll(CampaignType campaignType) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        sendConsent(NativeMessageActionType.REJECT_ALL, campaignType);
    }

    @Override // com.sourcepoint.cmplibrary.SpConsentLib
    public void showView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ThreadUtilsKt.checkMainThread("showView");
        this.viewManager.showView(view);
    }

    @Override // com.sourcepoint.cmplibrary.SpConsentLib
    public void removeView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ThreadUtilsKt.checkMainThread("removeView");
        this.viewManager.removeView(view);
    }

    @Override // com.sourcepoint.cmplibrary.SpConsentLib
    public void dispose() {
        this.executor.dispose();
        this.viewManager.removeAllViews();
    }

    @Override // com.sourcepoint.cmplibrary.SpConsentLib
    public void handleOnBackPress(boolean isMessageDismissible, final SpBackPressOttDelegate ottDelegate) {
        Intrinsics.checkNotNullParameter(ottDelegate, "ottDelegate");
        handleOnBackPress(isMessageDismissible, new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl$handleOnBackPress$1
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
                SpBackPressOttDelegate.this.onHomePage();
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.SpConsentLib
    public void handleOnBackPress(boolean isMessageDismissible, Function0<Unit> onHomePage) {
        Intrinsics.checkNotNullParameter(onHomePage, "onHomePage");
        this.onHomeCallback = onHomePage;
        this.isMessageDismissible = isMessageDismissible;
        if (this.viewManager.isViewInLayout()) {
            this.viewManager.handleOnBackPress();
        } else {
            onHomePage.invoke();
        }
    }

    /* compiled from: SpConsentLibImpl.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J$\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\tH\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\tH\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\tH\u0016¨\u0006\u0019"}, d2 = {"Lcom/sourcepoint/cmplibrary/SpConsentLibImpl$JSReceiverDelegate;", "Lcom/sourcepoint/cmplibrary/core/web/JSClientLib;", "(Lcom/sourcepoint/cmplibrary/SpConsentLibImpl;)V", "dismiss", "", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/view/View;", "log", NotificationCompat.CATEGORY_MESSAGE, "", "tag", "onAction", "actionData", "Lcom/sourcepoint/cmplibrary/core/web/IConsentWebView;", "nextCampaign", "Lcom/sourcepoint/cmplibrary/core/web/CampaignModel;", "onConsentUIReady", "isFromPM", "", "onError", "errorMessage", "error", "", "onNoIntentActivitiesFoundFor", "url", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class JSReceiverDelegate implements JSClientLib {

        /* compiled from: SpConsentLibImpl.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[MessageSubCategory.values().length];
                try {
                    iArr[MessageSubCategory.TCFv2.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[MessageSubCategory.OTT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[MessageSubCategory.NATIVE_OTT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[MessageSubCategory.NATIVE_IN_APP.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @Override // com.sourcepoint.cmplibrary.core.web.JSClientLib
        public void log(View view, String msg) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // com.sourcepoint.cmplibrary.core.web.JSClientLib
        public void log(View view, String tag, String msg) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public JSReceiverDelegate() {
        }

        @Override // com.sourcepoint.cmplibrary.core.web.JSClientLib
        public void onConsentUIReady(final View view, boolean isFromPM) {
            Intrinsics.checkNotNullParameter(view, "view");
            ExecutorManager executor = SpConsentLibImpl.this.getExecutor();
            final SpConsentLibImpl spConsentLibImpl = SpConsentLibImpl.this;
            executor.executeOnMain(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl$JSReceiverDelegate$onConsentUIReady$1
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
                    SpConsentLibImpl.this.spClient.onUIReady(view);
                }
            });
        }

        @Override // com.sourcepoint.cmplibrary.core.web.JSClientLib
        public void onError(View view, String errorMessage) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            RenderingAppException renderingAppException = new RenderingAppException(null, errorMessage, false, 5, null);
            SpConsentLibImpl.this.spClient.onError(renderingAppException);
            SpConsentLibImpl.this.getPLogger().error(renderingAppException);
            SpConsentLibImpl.this.getPLogger().clientEvent("onError", renderingAppException.getCode(), "");
        }

        @Override // com.sourcepoint.cmplibrary.core.web.JSClientLib
        public void dismiss(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            SpConsentLibImpl.this.viewManager.removeView(view);
        }

        @Override // com.sourcepoint.cmplibrary.core.web.JSClientLib
        public void onNoIntentActivitiesFoundFor(View view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            SpConsentLibImpl.this.spClient.onNoIntentActivitiesFound(url);
            Logger pLogger = SpConsentLibImpl.this.getPLogger();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", url);
            Unit unit = Unit.INSTANCE;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
            pLogger.clientEvent("log", "onNoIntentActivitiesFound", jSONObject2);
        }

        @Override // com.sourcepoint.cmplibrary.core.web.JSClientLib
        public void onError(View view, Throwable error) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(error, "error");
            SpConsentLibImpl.this.spClient.onError(error);
            ConsentLibExceptionK consentLibException$default = FunctionalUtilsKt.toConsentLibException$default(error, null, 1, null);
            SpConsentLibImpl.this.getPLogger().error(consentLibException$default);
            SpConsentLibImpl.this.getPLogger().clientEvent("onError", consentLibException$default.getCode(), String.valueOf(error));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.sourcepoint.cmplibrary.core.web.JSClientLib
        public void onAction(final IConsentWebView view, String actionData, final CampaignModel nextCampaign) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(actionData, "actionData");
            Intrinsics.checkNotNullParameter(nextCampaign, "nextCampaign");
            if ((view instanceof View ? (View) view : null) != null) {
                final SpConsentLibImpl spConsentLibImpl = SpConsentLibImpl.this;
                Either.Right consentAction = spConsentLibImpl.getPJsonConverter().toConsentAction(actionData);
                if (consentAction instanceof Either.Right) {
                    ConsentActionImpl consentActionImpl = (ConsentActionImpl) ((Either.Right) consentAction).getR();
                    spConsentLibImpl.onActionFromWebViewClient$cmplibrary_release(consentActionImpl, view);
                    if (consentActionImpl.getActionType() != ActionType.SHOW_OPTIONS) {
                        final CampaignType type = nextCampaign.getType();
                        final HttpUrl url = nextCampaign.getUrl();
                        int i = WhenMappings.$EnumSwitchMapping$0[nextCampaign.getMessageSubCategory().ordinal()];
                        if (i == 1 || i == 2 || i == 3) {
                            spConsentLibImpl.getExecutor().executeOnMain(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl$JSReceiverDelegate$onAction$1$1$1
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
                                    IConsentWebView.this.loadConsentUI(nextCampaign, url, type);
                                }
                            });
                        } else if (i == 4) {
                            spConsentLibImpl.getExecutor().executeOnMain(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl$JSReceiverDelegate$onAction$1$1$2
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
                                    DataStorage dataStorage;
                                    SpConsentLibImpl.this.viewManager.removeView((View) view);
                                    SpConsentLibImpl.this.currentNativeMessageCampaign = nextCampaign;
                                    SpClient spClient = SpConsentLibImpl.this.spClient;
                                    JSONObject message = nextCampaign.getMessage();
                                    dataStorage = SpConsentLibImpl.this.dataStorage;
                                    spClient.onNativeMessageReady(NativeMessageExtKt.toNativeMessageDTO(message, type, dataStorage), SpConsentLibImpl.this);
                                    SpConsentLibImpl.this.getPLogger().nativeMessageAction("onNativeMessageReady", "onNativeMessageReady", nextCampaign.getMessage());
                                }
                            });
                        }
                    }
                    consentAction = new Either.Right(Unit.INSTANCE);
                } else if (!(consentAction instanceof Either.Left)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (!(consentAction instanceof Either.Right) && (consentAction instanceof Either.Left)) {
                    throw ((Either.Left) consentAction).getT();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.sourcepoint.cmplibrary.core.web.JSClientLib
        public void onAction(final View view, String actionData) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(actionData, "actionData");
            IConsentWebView iConsentWebView = view instanceof IConsentWebView ? (IConsentWebView) view : null;
            if (iConsentWebView == null) {
                return;
            }
            Either.Right consentAction = SpConsentLibImpl.this.getPJsonConverter().toConsentAction(actionData);
            SpConsentLibImpl spConsentLibImpl = SpConsentLibImpl.this;
            if (consentAction instanceof Either.Right) {
                spConsentLibImpl.onActionFromWebViewClient$cmplibrary_release((ConsentActionImpl) ((Either.Right) consentAction).getR(), iConsentWebView);
                consentAction = new Either.Right(Unit.INSTANCE);
            } else if (!(consentAction instanceof Either.Left)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!(consentAction instanceof Either.Right) && (consentAction instanceof Either.Left)) {
                throw ((Either.Left) consentAction).getT();
            }
            ExecutorManager executor = SpConsentLibImpl.this.getExecutor();
            final SpConsentLibImpl spConsentLibImpl2 = SpConsentLibImpl.this;
            executor.executeOnMain(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl$JSReceiverDelegate$onAction$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:3:0x001b, code lost:
                
                    r0 = r1.onHomeCallback;
                 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2() {
                    boolean z;
                    Function0 function0;
                    View view2 = view;
                    SpConsentLibImpl spConsentLibImpl3 = spConsentLibImpl2;
                    spConsentLibImpl3.spClient.onUIFinished(view2);
                    spConsentLibImpl3.getPLogger().webAppAction("onUIFinished", "onUIFinished", null);
                    z = spConsentLibImpl3.isMessageDismissible;
                    if (z || function0 == null) {
                        return;
                    }
                    function0.invoke();
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onActionFromWebViewClient$cmplibrary_release(final ConsentActionImpl actionImpl, final IConsentWebView iConsentWebView) {
        Intrinsics.checkNotNullParameter(actionImpl, "actionImpl");
        final View view = iConsentWebView instanceof View ? (View) iConsentWebView : null;
        if (view == null) {
            return;
        }
        this.pLogger.webAppAction("Action from the RenderingApp", actionImpl.getActionType().name(), actionImpl.getThisContent());
        switch (WhenMappings.$EnumSwitchMapping$1[actionImpl.getActionType().ordinal()]) {
            case 1:
            case 2:
            case 3:
                this.executor.executeOnSingleThread(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl$onActionFromWebViewClient$1
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
                        ConsentManager consentManager;
                        ConsentAction onAction = SpConsentLibImpl.this.spClient.onAction(view, actionImpl);
                        ConsentActionImpl consentActionImpl = onAction instanceof ConsentActionImpl ? (ConsentActionImpl) onAction : null;
                        if (consentActionImpl != null) {
                            consentManager = SpConsentLibImpl.this.consentManager;
                            consentManager.enqueueConsent(consentActionImpl);
                        }
                    }
                });
                break;
            case 4:
                this.executor.executeOnMain(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl$onActionFromWebViewClient$2
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
                        SpConsentLibImpl.this.showOption(actionImpl, iConsentWebView);
                    }
                });
                this.executor.executeOnSingleThread(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl$onActionFromWebViewClient$3
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
                        ConsentAction onAction = SpConsentLibImpl.this.spClient.onAction(view, actionImpl);
                        if (onAction instanceof ConsentActionImpl) {
                        }
                    }
                });
                break;
            case 5:
                this.executor.executeOnSingleThread(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl$onActionFromWebViewClient$4
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
                        ConsentAction onAction = SpConsentLibImpl.this.spClient.onAction(view, actionImpl);
                        if (onAction instanceof ConsentActionImpl) {
                        }
                    }
                });
                break;
            case 6:
            case 7:
                this.executor.executeOnSingleThread(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.SpConsentLibImpl$onActionFromWebViewClient$5
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
                        ConsentAction onAction = SpConsentLibImpl.this.spClient.onAction(view, actionImpl);
                        if (onAction instanceof ConsentActionImpl) {
                        }
                    }
                });
                break;
        }
        this.clientEventManager.setAction(actionImpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showOption(ConsentActionImpl actionImpl, IConsentWebView iConsentWebView) {
        if (!this.connectionManager.isConnected()) {
            ConsentManager consentManager = this.consentManager;
            consentManager.resetConsentCounter();
            consentManager.sendStoredConsentToClient();
            return;
        }
        View view = iConsentWebView instanceof View ? (View) iConsentWebView : null;
        if (view == null) {
            return;
        }
        CampaignType campaignType = actionImpl.getCampaignType();
        int i = WhenMappings.$EnumSwitchMapping$0[campaignType.ordinal()];
        if (i == 1) {
            this.viewManager.removeView(view);
            Either.Right pmConfig = this.campaignManager.getPmConfig(campaignType, actionImpl.getPrivacyManagerId(), ConsentActionImplKt.privacyManagerTab(actionImpl));
            if (pmConfig instanceof Either.Right) {
                HttpUrl pmUrl = this.urlManager.pmUrl(this.env, actionImpl.getCampaignType(), (PmUrlConfig) ((Either.Right) pmConfig).getR(), OTTExtKt.toMessageType(this.context));
                this.pLogger.pm(actionImpl.getCampaignType().name() + " Privacy Manager", pmUrl.getUrl(), "GET", String.valueOf(actionImpl.getPrivacyManagerId()));
                pmConfig = new Either.Right(iConsentWebView.loadConsentUIFromUrlPreloadingOption(pmUrl, actionImpl.getCampaignType(), actionImpl.getPrivacyManagerId(), this.dataStorage.getGdprConsentStatus()));
            } else if (!(pmConfig instanceof Either.Left)) {
                throw new NoWhenBranchMatchedException();
            }
            if ((pmConfig instanceof Either.Right) || !(pmConfig instanceof Either.Left)) {
                return;
            }
            this.spClient.onError(((Either.Left) pmConfig).getT());
            return;
        }
        if (i == 2 || i == 3) {
            this.viewManager.removeView(view);
            Either.Right pmConfig2 = this.campaignManager.getPmConfig(campaignType, actionImpl.getPrivacyManagerId(), null);
            if (pmConfig2 instanceof Either.Right) {
                HttpUrl pmUrl2 = this.urlManager.pmUrl(this.env, actionImpl.getCampaignType(), (PmUrlConfig) ((Either.Right) pmConfig2).getR(), OTTExtKt.toMessageType(this.context));
                this.pLogger.pm(actionImpl.getCampaignType().name() + " Privacy Manager", pmUrl2.getUrl(), "GET", String.valueOf(actionImpl.getPrivacyManagerId()));
                pmConfig2 = new Either.Right(iConsentWebView.loadConsentUIFromUrlPreloadingOption(pmUrl2, actionImpl.getCampaignType(), actionImpl.getPrivacyManagerId(), this.dataStorage.getCcpaConsentStatus()));
            } else if (!(pmConfig2 instanceof Either.Left)) {
                throw new NoWhenBranchMatchedException();
            }
            if ((pmConfig2 instanceof Either.Right) || !(pmConfig2 instanceof Either.Left)) {
                return;
            }
            this.spClient.onError(((Either.Left) pmConfig2).getT());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void nativeMessageShowOption(NativeConsentAction action, IConsentWebView iConsentWebView) {
        View view = iConsentWebView instanceof View ? (View) iConsentWebView : null;
        if (view == null) {
            return;
        }
        CampaignType campaignType = action.getCampaignType();
        int i = WhenMappings.$EnumSwitchMapping$0[campaignType.ordinal()];
        if (i == 1) {
            this.viewManager.removeView(view);
            Either.Right pmConfig = this.campaignManager.getPmConfig(campaignType, action.getPrivacyManagerId(), PMTab.PURPOSES);
            if (pmConfig instanceof Either.Right) {
                HttpUrl pmUrl = this.urlManager.pmUrl(this.env, action.getCampaignType(), (PmUrlConfig) ((Either.Right) pmConfig).getR(), OTTExtKt.toMessageType(this.context));
                this.pLogger.pm(action.getCampaignType().name() + " Privacy Manager", pmUrl.getUrl(), "GET", String.valueOf(action.getPrivacyManagerId()));
                pmConfig = new Either.Right(iConsentWebView.loadConsentUIFromUrlPreloadingOption(pmUrl, action.getCampaignType(), action.getPrivacyManagerId(), this.dataStorage.getGdprConsentStatus()));
            } else if (!(pmConfig instanceof Either.Left)) {
                throw new NoWhenBranchMatchedException();
            }
            if ((pmConfig instanceof Either.Right) || !(pmConfig instanceof Either.Left)) {
                return;
            }
            this.spClient.onError(((Either.Left) pmConfig).getT());
            return;
        }
        if (i != 2) {
            return;
        }
        this.viewManager.removeView(view);
        Either.Right pmConfig2 = this.campaignManager.getPmConfig(campaignType, action.getPrivacyManagerId(), null);
        if (pmConfig2 instanceof Either.Right) {
            HttpUrl pmUrl2 = this.urlManager.pmUrl(this.env, action.getCampaignType(), (PmUrlConfig) ((Either.Right) pmConfig2).getR(), OTTExtKt.toMessageType(this.context));
            this.pLogger.pm(action.getCampaignType().name() + " Privacy Manager", pmUrl2.getUrl(), "GET", String.valueOf(action.getPrivacyManagerId()));
            pmConfig2 = new Either.Right(iConsentWebView.loadConsentUIFromUrlPreloadingOption(pmUrl2, action.getCampaignType(), action.getPrivacyManagerId(), this.dataStorage.getCcpaConsentStatus()));
        } else if (!(pmConfig2 instanceof Either.Left)) {
            throw new NoWhenBranchMatchedException();
        }
        if ((pmConfig2 instanceof Either.Right) || !(pmConfig2 instanceof Either.Left)) {
            return;
        }
        this.spClient.onError(((Either.Left) pmConfig2).getT());
    }

    @Override // com.sourcepoint.cmplibrary.NativeMessageController
    public void showOptionNativeMessage(CampaignType campaignType, String pmId) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Intrinsics.checkNotNullParameter(pmId, "pmId");
        NativeConsentAction nativeConsentAction = new NativeConsentAction(NativeMessageActionType.SHOW_OPTIONS, campaignType, pmId);
        Either.Right createWebView = this.viewManager.createWebView(this, new JSReceiverDelegate(), this.remainingCampaigns, OTTExtKt.toMessageType(this.context), null);
        if (createWebView instanceof Either.Right) {
            nativeMessageShowOption(nativeConsentAction, (IConsentWebView) ((Either.Right) createWebView).getR());
            createWebView = new Either.Right(Unit.INSTANCE);
        } else if (!(createWebView instanceof Either.Left)) {
            throw new NoWhenBranchMatchedException();
        }
        if ((createWebView instanceof Either.Right) || !(createWebView instanceof Either.Left)) {
            return;
        }
        this.spClient.onError(((Either.Left) createWebView).getT());
    }

    @Override // com.sourcepoint.cmplibrary.NativeMessageController
    public void removeNativeView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.viewManager.removeView(view);
    }

    @Override // com.sourcepoint.cmplibrary.NativeMessageController
    public void showNativeView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        showView(view);
    }

    @Override // com.sourcepoint.cmplibrary.NativeMessageController
    public void sendConsent(NativeMessageActionType action, CampaignType campaignType) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        this.clientEventManager.setAction(action);
        NativeConsentAction nativeConsentAction = new NativeConsentAction(action, campaignType, null, 4, null);
        int i = WhenMappings.$EnumSwitchMapping$2[nativeConsentAction.getActionType().ordinal()];
        if (i == 2 || i == 3) {
            moveToNextCampaign(this.remainingCampaigns, this.viewManager, this.spClient);
        } else if (i == 4 || i == 5) {
            this.consentManager.enqueueConsent(nativeConsentAction);
            moveToNextCampaign(this.remainingCampaigns, this.viewManager, this.spClient);
        }
    }

    private final void moveToNextCampaign(Queue<CampaignModel> remainingCampaigns, ViewsManager viewManager, SpClient spClient) {
        Object obj;
        CampaignModel poll = remainingCampaigns.poll();
        if (poll != null) {
            CampaignType type = poll.getType();
            int i = WhenMappings.$EnumSwitchMapping$3[poll.getMessageSubCategory().ordinal()];
            if (i == 1) {
                MessageStructure nativeMessageDTO = NativeMessageExtKt.toNativeMessageDTO(poll.getMessage(), type, this.dataStorage);
                this.currentNativeMessageCampaign = poll;
                spClient.onNativeMessageReady(nativeMessageDTO, this);
                this.pLogger.nativeMessageAction("onNativeMessageReady", "onNativeMessageReady", poll.getMessage());
                return;
            }
            if (i == 2 || i == 3 || i == 4) {
                Either<IConsentWebView> createWebView = viewManager.createWebView(this, new JSReceiverDelegate(), remainingCampaigns, SpConfigKt.toMessageType(poll.getMessageSubCategory()), null);
                boolean z = createWebView instanceof Either.Right;
                if (!z && (createWebView instanceof Either.Left)) {
                    spClient.onError(((Either.Left) createWebView).getT());
                }
                if (z) {
                    obj = ((Either.Right) createWebView).getR();
                } else {
                    if (!(createWebView instanceof Either.Left)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    obj = null;
                }
                IConsentWebView iConsentWebView = (IConsentWebView) obj;
                HttpUrl url = poll.getUrl();
                if (iConsentWebView != null) {
                    iConsentWebView.loadConsentUI(poll, url, type);
                    return;
                }
                return;
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
