package com.sourcepoint.cmplibrary.campaign;

import android.content.SharedPreferences;
import com.example.cmplibrary.BuildConfig;
import com.ironsource.C3040d4;
import com.ironsource.C3337ue;
import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.creation.CreationalUtilityKt;
import com.sourcepoint.cmplibrary.data.local.DataStorage;
import com.sourcepoint.cmplibrary.data.network.converter.ExceptionUtilsKt;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverter;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImplKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.CcpaCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatus;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GdprCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MessageMetaData;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesApiModelExtKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataArg;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.PvDataApiModelExtKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentData;
import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentStatus;
import com.sourcepoint.cmplibrary.data.network.model.optimized.choice.ChoiceResp;
import com.sourcepoint.cmplibrary.data.network.util.CampaignsEnv;
import com.sourcepoint.cmplibrary.data.network.util.Env;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.exception.ChildPmIdNotFound;
import com.sourcepoint.cmplibrary.exception.InvalidArgumentException;
import com.sourcepoint.cmplibrary.exception.Logger;
import com.sourcepoint.cmplibrary.exception.MissingPropertyException;
import com.sourcepoint.cmplibrary.model.CampaignKt;
import com.sourcepoint.cmplibrary.model.CampaignReq;
import com.sourcepoint.cmplibrary.model.CampaignReqImpl;
import com.sourcepoint.cmplibrary.model.CampaignTemplate;
import com.sourcepoint.cmplibrary.model.MessageLanguage;
import com.sourcepoint.cmplibrary.model.PMTab;
import com.sourcepoint.cmplibrary.model.PmUrlConfig;
import com.sourcepoint.cmplibrary.model.exposed.MessageSubCategory;
import com.sourcepoint.cmplibrary.model.exposed.SpCampaign;
import com.sourcepoint.cmplibrary.model.exposed.SpConfig;
import com.sourcepoint.cmplibrary.model.exposed.TargetingParam;
import com.sourcepoint.cmplibrary.util.FunctionalUtilsKt;
import com.sourcepoint.cmplibrary.util.SpUtils;
import com.sourcepoint.cmplibrary.util.extensions.SpConfigExtKt;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import org.json.JSONObject;

/* compiled from: CampaignManager.kt */
@Metadata(d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010\u008c\u0001\u001a\u00030\u008d\u00012\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0090\u0001\u001a\u00020`H\u0016J\n\u0010\u0091\u0001\u001a\u00030\u008d\u0001H\u0016J\u0014\u0010\u0092\u0001\u001a\u00030\u008d\u00012\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0093\u0001\u001a\u00030\u008d\u0001H\u0016J\u001e\u0010\u0094\u0001\u001a\u0017\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u008f\u0001\u0012\u0004\u0012\u00020`0\u0096\u00010\u0095\u0001H\u0016J\u001a\u0010\u0097\u0001\u001a\t\u0012\u0004\u0012\u00020`0\u0095\u00012\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0016J\u001c\u0010\u0098\u0001\u001a\n\u0012\u0005\u0012\u00030\u0099\u00010\u0095\u00012\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\bH\u0002J\u0014\u0010\u009b\u0001\u001a\u00030\u009c\u00012\b\u0010\u009d\u0001\u001a\u00030\u009e\u0001H\u0016J:\u0010\u009f\u0001\u001a\n\u0012\u0005\u0012\u00030\u0099\u00010\u0095\u00012\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\b2\b\u0010 \u0001\u001a\u00030¡\u00012\u0007\u0010¢\u0001\u001a\u00020S2\t\u0010£\u0001\u001a\u0004\u0018\u00010\bH\u0002J\u0014\u0010¤\u0001\u001a\u00030\u009c\u00012\b\u0010\u009d\u0001\u001a\u00030\u009e\u0001H\u0016J\u0015\u0010¥\u0001\u001a\u0004\u0018\u00010\b2\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0016J \u0010¦\u0001\u001a\u00030\u009e\u00012\b\u0010\t\u001a\u0004\u0018\u00010\b2\n\u0010§\u0001\u001a\u0005\u0018\u00010¨\u0001H\u0016J2\u0010©\u0001\u001a\n\u0012\u0005\u0012\u00030\u0099\u00010\u0095\u00012\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\b2\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001H\u0016JF\u0010©\u0001\u001a\n\u0012\u0005\u0012\u00030\u0099\u00010\u0095\u00012\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\b2\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u00012\u0007\u0010¢\u0001\u001a\u00020S2\t\u0010£\u0001\u001a\u0004\u0018\u00010\bH\u0016J4\u0010ª\u0001\u001a\n\u0012\u0005\u0012\u00030\u0099\u00010\u0095\u00012\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\b2\u000b\b\u0002\u0010£\u0001\u001a\u0004\u0018\u00010\b2\t\b\u0002\u0010¢\u0001\u001a\u00020SH\u0002J\u0014\u0010«\u0001\u001a\u00030\u009c\u00012\b\u0010\u009d\u0001\u001a\u00030\u009e\u0001H\u0016J\u001e\u0010¬\u0001\u001a\u00030\u008d\u00012\t\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\b2\u0007\u0010®\u0001\u001a\u00020tH\u0016J\u0015\u0010¯\u0001\u001a\u00030\u008d\u00012\t\u0010°\u0001\u001a\u0004\u0018\u00010kH\u0016J\n\u0010±\u0001\u001a\u00030\u008d\u0001H\u0016J\u0014\u0010²\u0001\u001a\u00020S2\t\u0010³\u0001\u001a\u0004\u0018\u00010\bH\u0016J\u0014\u0010´\u0001\u001a\u00020S2\t\u0010µ\u0001\u001a\u0004\u0018\u00010\bH\u0016J\u0014\u0010¶\u0001\u001a\u00020S2\t\u0010°\u0001\u001a\u0004\u0018\u00010kH\u0016J\"\u0010·\u0001\u001a\u0005\u0018\u00010¸\u00012\t\u0010¹\u0001\u001a\u0004\u0018\u00010\b2\t\u0010º\u0001\u001a\u0004\u0018\u00010\bH\u0016J\u0017\u0010»\u0001\u001a\u0005\u0018\u00010¼\u00012\t\u0010¹\u0001\u001a\u0004\u0018\u00010\bH\u0016J\u0013\u0010½\u0001\u001a\u00020S2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R(\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u000b\"\u0004\b\u001b\u0010\rR(\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0007\u001a\u0004\u0018\u00010\u001c8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R(\u0010&\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b'\u0010\u000b\"\u0004\b(\u0010\rR(\u0010*\u001a\u0004\u0018\u00010)2\b\u0010\u0007\u001a\u0004\u0018\u00010)8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R(\u00100\u001a\u0004\u0018\u00010/2\b\u0010\u0007\u001a\u0004\u0018\u00010/8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001b\u00107\u001a\u0002088FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b9\u0010:R\u0016\u0010=\u001a\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u000bR(\u0010@\u001a\u0004\u0018\u00010?2\b\u0010\u0007\u001a\u0004\u0018\u00010?8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR(\u0010E\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bF\u0010\u000b\"\u0004\bG\u0010\rR\u0016\u0010H\u001a\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\u000bR(\u0010J\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0007\u001a\u0004\u0018\u00010\u001c8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bK\u0010\u001f\"\u0004\bL\u0010!R\u0014\u0010M\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010%R(\u0010O\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bP\u0010\u000b\"\u0004\bQ\u0010\rR\u0014\u0010R\u001a\u00020S8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0014\u0010V\u001a\u00020S8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010UR\u0014\u0010W\u001a\u00020S8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010UR\u0011\u0010X\u001a\u00020S8F¢\u0006\u0006\u001a\u0004\bX\u0010UR\u0014\u0010Y\u001a\u00020S8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bY\u0010UR\u0013\u0010Z\u001a\u0004\u0018\u00010[¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u001a\u0010^\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020`0_X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010a\u001a\u00020bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR(\u0010f\u001a\u0004\u0018\u00010e2\b\u0010\u0007\u001a\u0004\u0018\u00010e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR(\u0010l\u001a\u0004\u0018\u00010k2\b\u0010\u0007\u001a\u0004\u0018\u00010k8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR(\u0010q\u001a\u0004\u0018\u00010e2\b\u0010\u0007\u001a\u0004\u0018\u00010e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\br\u0010h\"\u0004\bs\u0010jR$\u0010u\u001a\u00020t2\u0006\u0010\u0007\u001a\u00020t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u0014\u0010z\u001a\u00020S8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b{\u0010UR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b|\u0010}R\u0014\u0010~\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u007f\u0010,R/\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00012\t\u0010\u0007\u001a\u0005\u0018\u00010\u0080\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0018\u0010\u0086\u0001\u001a\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u0010\u000bR\u001e\u0010\u0088\u0001\u001a\u00020SX\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0089\u0001\u0010U\"\u0006\b\u008a\u0001\u0010\u008b\u0001¨\u0006¾\u0001"}, d2 = {"Lcom/sourcepoint/cmplibrary/campaign/CampaignManagerImpl;", "Lcom/sourcepoint/cmplibrary/campaign/CampaignManager;", "dataStorage", "Lcom/sourcepoint/cmplibrary/data/local/DataStorage;", "spConfig", "Lcom/sourcepoint/cmplibrary/model/exposed/SpConfig;", "(Lcom/sourcepoint/cmplibrary/data/local/DataStorage;Lcom/sourcepoint/cmplibrary/model/exposed/SpConfig;)V", "value", "", "authId", "getAuthId", "()Ljava/lang/String;", "setAuthId", "(Ljava/lang/String;)V", "campaigns4Config", "", "Lcom/sourcepoint/cmplibrary/model/CampaignReq;", "getCampaigns4Config", "()Ljava/util/List;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", "ccpaConsentStatus", "getCcpaConsentStatus", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", "setCcpaConsentStatus", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;)V", "ccpaDateCreated", "getCcpaDateCreated", "setCcpaDateCreated", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;", "ccpaMessageMetaData", "getCcpaMessageMetaData", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;", "setCcpaMessageMetaData", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;)V", "ccpaMessageSubCategory", "Lcom/sourcepoint/cmplibrary/model/exposed/MessageSubCategory;", "getCcpaMessageSubCategory", "()Lcom/sourcepoint/cmplibrary/model/exposed/MessageSubCategory;", "ccpaUuid", "getCcpaUuid", "setCcpaUuid", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceResp;", "choiceResp", "getChoiceResp", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceResp;", "setChoiceResp", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceResp;)V", "Ljava/time/Instant;", "dataRecordedConsent", "getDataRecordedConsent", "()Ljava/time/Instant;", "setDataRecordedConsent", "(Ljava/time/Instant;)V", "getDataStorage", "()Lcom/sourcepoint/cmplibrary/data/local/DataStorage;", "formatter", "Ljava/text/SimpleDateFormat;", "getFormatter", "()Ljava/text/SimpleDateFormat;", "formatter$delegate", "Lkotlin/Lazy;", "gdprAdditionsChangeDate", "getGdprAdditionsChangeDate", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", C3040d4.i.a0, "getGdprConsentStatus", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", "setGdprConsentStatus", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;)V", "gdprDateCreated", "getGdprDateCreated", "setGdprDateCreated", "gdprLegalBasisChangeDate", "getGdprLegalBasisChangeDate", "gdprMessageMetaData", "getGdprMessageMetaData", "setGdprMessageMetaData", "gdprMessageSubCategory", "getGdprMessageSubCategory", "gdprUuid", "getGdprUuid", "setGdprUuid", "hasLocalData", "", "getHasLocalData", "()Z", "isCcpaExpired", "isGdprExpired", "isNewUser", "isUsnatExpired", "logger", "Lcom/sourcepoint/cmplibrary/exception/Logger;", "getLogger", "()Lcom/sourcepoint/cmplibrary/exception/Logger;", "mapTemplate", "", "Lcom/sourcepoint/cmplibrary/model/CampaignTemplate;", "messageLanguage", "Lcom/sourcepoint/cmplibrary/model/MessageLanguage;", "getMessageLanguage", "()Lcom/sourcepoint/cmplibrary/model/MessageLanguage;", "Lkotlinx/serialization/json/JsonElement;", "messagesOptimizedLocalState", "getMessagesOptimizedLocalState", "()Lkotlinx/serialization/json/JsonElement;", "setMessagesOptimizedLocalState", "(Lkotlinx/serialization/json/JsonElement;)V", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp;", "metaDataResp", "getMetaDataResp", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp;", "setMetaDataResp", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp;)V", "nonKeyedLocalState", "getNonKeyedLocalState", "setNonKeyedLocalState", "", "propertyId", "getPropertyId", "()I", "setPropertyId", "(I)V", "shouldCallMessages", "getShouldCallMessages", "getSpConfig", "()Lcom/sourcepoint/cmplibrary/model/exposed/SpConfig;", "storeChoiceResp", "getStoreChoiceResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "usNatConsentData", "getUsNatConsentData", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "setUsNatConsentData", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;)V", "usnatAdditionsChangeDate", "getUsnatAdditionsChangeDate", "usnatApplicableSectionChanged", "getUsnatApplicableSectionChanged", "setUsnatApplicableSectionChanged", "(Z)V", "addCampaign", "", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "campaign", "clearConsents", "consentStatusLog", "deleteExpiredConsents", "getAppliedCampaign", "Lcom/sourcepoint/cmplibrary/core/Either;", "Lkotlin/Pair;", "getCampaignTemplate", "getCcpaPmConfig", "Lcom/sourcepoint/cmplibrary/model/PmUrlConfig;", "pmId", "getCcpaPvDataBody", "Lkotlinx/serialization/json/JsonObject;", "messageReq", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesParamReq;", "getGdprPmConfig", "pmTab", "Lcom/sourcepoint/cmplibrary/model/PMTab;", "useGroupPmIfAvailable", "groupPmId", "getGdprPvDataBody", "getGroupId", "getMessageOptimizedReq", "pubData", "Lorg/json/JSONObject;", "getPmConfig", "getUsNatPmConfig", "getUsNatPvDataBody", "handleAuthIdOrPropertyIdChange", "newAuthId", "newPropertyId", "handleMetaDataResponse", C3337ue.n, "handleOldLocalData", "hasGdprVendorListIdChanged", "gdprVendorListId", "hasUsNatVendorListIdChanged", "usNatVendorListId", "hasUsnatApplicableSectionsChanged", "reConsentGdpr", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus;", "additionsChangeDate", "legalBasisChangeDate", "reConsentUsnat", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus;", "shouldCallConsentStatus", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
final class CampaignManagerImpl implements CampaignManager {
    private final DataStorage dataStorage;

    /* renamed from: formatter$delegate, reason: from kotlin metadata */
    private final Lazy formatter;
    private final Logger logger;
    private final Map<String, CampaignTemplate> mapTemplate;
    private final MessageLanguage messageLanguage;
    private final SpConfig spConfig;
    private boolean usnatApplicableSectionChanged;

    /* compiled from: CampaignManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CampaignType.values().length];
            try {
                iArr[CampaignType.GDPR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CampaignType.USNAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CampaignType.CCPA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CampaignManagerImpl(DataStorage dataStorage, SpConfig spConfig) {
        Intrinsics.checkNotNullParameter(dataStorage, "dataStorage");
        Intrinsics.checkNotNullParameter(spConfig, "spConfig");
        this.dataStorage = dataStorage;
        this.spConfig = spConfig;
        this.messageLanguage = getSpConfig().messageLanguage;
        this.formatter = LazyKt.lazy(new Function0<SimpleDateFormat>() { // from class: com.sourcepoint.cmplibrary.campaign.CampaignManagerImpl$formatter$2
            @Override // kotlin.jvm.functions.Function0
            public final SimpleDateFormat invoke() {
                return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
            }
        });
        this.mapTemplate = new LinkedHashMap();
        this.logger = getSpConfig().logger;
        if (!CreationalUtilityKt.getValidPattern().containsMatchIn(getSpConfig().propertyName)) {
            throw new InvalidArgumentException(null, "PropertyName can only include letters, numbers, '.', ':', '-' and '/'. (string) passed is invalid", false, 5, null);
        }
        SpConfig spConfig2 = getSpConfig();
        for (SpCampaign spCampaign : spConfig2.campaigns) {
            int i = WhenMappings.$EnumSwitchMapping$0[spCampaign.campaignType.ordinal()];
            if (i == 1) {
                CampaignType campaignType = spCampaign.campaignType;
                CampaignsEnv campaignsEnv = spConfig2.campaignsEnv;
                List<TargetingParam> list = spCampaign.targetingParams;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (!Intrinsics.areEqual(((TargetingParam) obj).getKey(), "campaignEnv")) {
                        arrayList.add(obj);
                    }
                }
                addCampaign(campaignType, new CampaignTemplate(campaignsEnv, arrayList, spCampaign.campaignType, spCampaign.groupPmId));
            } else if (i == 2) {
                CampaignType campaignType2 = spCampaign.campaignType;
                CampaignsEnv campaignsEnv2 = spConfig2.campaignsEnv;
                List<TargetingParam> list2 = spCampaign.targetingParams;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : list2) {
                    if (!Intrinsics.areEqual(((TargetingParam) obj2).getKey(), "campaignEnv")) {
                        arrayList2.add(obj2);
                    }
                }
                addCampaign(campaignType2, new CampaignTemplate(campaignsEnv2, arrayList2, spCampaign.campaignType, spCampaign.groupPmId));
            } else if (i == 3) {
                CampaignType campaignType3 = spCampaign.campaignType;
                CampaignsEnv campaignsEnv3 = spConfig2.campaignsEnv;
                List<TargetingParam> list3 = spCampaign.targetingParams;
                ArrayList arrayList3 = new ArrayList();
                for (Object obj3 : list3) {
                    if (!Intrinsics.areEqual(((TargetingParam) obj3).getKey(), "campaignEnv")) {
                        arrayList3.add(obj3);
                    }
                }
                addCampaign(campaignType3, new CampaignTemplate(campaignsEnv3, arrayList3, spCampaign.campaignType, spCampaign.groupPmId));
            }
        }
    }

    public final DataStorage getDataStorage() {
        return this.dataStorage;
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public SpConfig getSpConfig() {
        return this.spConfig;
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public MessageLanguage getMessageLanguage() {
        return this.messageLanguage;
    }

    public final SimpleDateFormat getFormatter() {
        return (SimpleDateFormat) this.formatter.getValue();
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final boolean getUsnatApplicableSectionChanged() {
        return this.usnatApplicableSectionChanged;
    }

    public final void setUsnatApplicableSectionChanged(boolean z) {
        this.usnatApplicableSectionChanged = z;
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public List<CampaignReq> getCampaigns4Config() {
        CampaignReqImpl campaignReqImpl$default;
        CampaignReqImpl campaignReqImpl$default2;
        CampaignReqImpl campaignReqImpl;
        ArrayList arrayList = new ArrayList();
        CampaignTemplate campaignTemplate = this.mapTemplate.get("GDPR");
        if (campaignTemplate != null && (campaignReqImpl = CampaignKt.toCampaignReqImpl(campaignTemplate, campaignTemplate.getTargetingParams(), campaignTemplate.getCampaignsEnv(), campaignTemplate.getGroupPmId())) != null) {
            arrayList.add(campaignReqImpl);
        }
        CampaignTemplate campaignTemplate2 = this.mapTemplate.get("CCPA");
        if (campaignTemplate2 != null && (campaignReqImpl$default2 = CampaignKt.toCampaignReqImpl$default(campaignTemplate2, campaignTemplate2.getTargetingParams(), campaignTemplate2.getCampaignsEnv(), null, 4, null)) != null) {
            arrayList.add(campaignReqImpl$default2);
        }
        CampaignTemplate campaignTemplate3 = this.mapTemplate.get("USNAT");
        if (campaignTemplate3 != null && (campaignReqImpl$default = CampaignKt.toCampaignReqImpl$default(campaignTemplate3, campaignTemplate3.getTargetingParams(), campaignTemplate3.getCampaignsEnv(), null, 4, null)) != null) {
            arrayList.add(campaignReqImpl$default);
        }
        return arrayList;
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public MessageSubCategory getCcpaMessageSubCategory() {
        MessageSubCategory subCategoryId;
        MessageMetaData ccpaMessageMetaData = getCcpaMessageMetaData();
        return (ccpaMessageMetaData == null || (subCategoryId = ccpaMessageMetaData.getSubCategoryId()) == null) ? MessageSubCategory.TCFv2 : subCategoryId;
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public MessageSubCategory getGdprMessageSubCategory() {
        MessageSubCategory subCategoryId;
        MessageMetaData gdprMessageMetaData = getGdprMessageMetaData();
        return (gdprMessageMetaData == null || (subCategoryId = gdprMessageMetaData.getSubCategoryId()) == null) ? MessageSubCategory.TCFv2 : subCategoryId;
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void addCampaign(CampaignType campaignType, CampaignTemplate campaign) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Intrinsics.checkNotNullParameter(campaign, "campaign");
        this.mapTemplate.put(campaignType.name(), campaign);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public Either<CampaignTemplate> getCampaignTemplate(final CampaignType campaignType) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        return FunctionalUtilsKt.check(new Function0<CampaignTemplate>() { // from class: com.sourcepoint.cmplibrary.campaign.CampaignManagerImpl$getCampaignTemplate$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CampaignTemplate invoke() {
                Map map;
                map = CampaignManagerImpl.this.mapTemplate;
                CampaignTemplate campaignTemplate = (CampaignTemplate) map.get(campaignType.name());
                if (campaignTemplate != null) {
                    return campaignTemplate;
                }
                ExceptionUtilsKt.fail(campaignType.name() + " Campaign is missing!!!");
                throw new KotlinNothingValueException();
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public Either<PmUrlConfig> getPmConfig(CampaignType campaignType, String pmId, PMTab pmTab, boolean useGroupPmIfAvailable, String groupPmId) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        int i = WhenMappings.$EnumSwitchMapping$0[campaignType.ordinal()];
        if (i == 1) {
            if (pmTab == null) {
                pmTab = PMTab.PURPOSES;
            }
            return getGdprPmConfig(pmId, pmTab, useGroupPmIfAvailable, groupPmId);
        }
        if (i == 2) {
            return getUsNatPmConfig$default(this, pmId, groupPmId, false, 4, null);
        }
        if (i == 3) {
            return getCcpaPmConfig(pmId);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public Either<PmUrlConfig> getPmConfig(CampaignType campaignType, String pmId, PMTab pmTab) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        int i = WhenMappings.$EnumSwitchMapping$0[campaignType.ordinal()];
        if (i == 1) {
            if (pmTab == null) {
                pmTab = PMTab.PURPOSES;
            }
            return getGdprPmConfig(pmId, pmTab, false, null);
        }
        if (i == 2) {
            return getUsNatPmConfig$default(this, pmId, null, false, 6, null);
        }
        if (i == 3) {
            return getCcpaPmConfig(pmId);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Either<PmUrlConfig> getGdprPmConfig(final String pmId, final PMTab pmTab, final boolean useGroupPmIfAvailable, final String groupPmId) {
        return FunctionalUtilsKt.check(new Function0<PmUrlConfig>() { // from class: com.sourcepoint.cmplibrary.campaign.CampaignManagerImpl$getGdprPmConfig$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PmUrlConfig invoke() {
                String gdprChildPmId = CampaignManagerImpl.this.getDataStorage().getGdprChildPmId();
                boolean z = gdprChildPmId == null;
                boolean z2 = groupPmId != null;
                String selectPmId = CampaignManager.INSTANCE.selectPmId(pmId, gdprChildPmId, useGroupPmIfAvailable);
                if (z2 && useGroupPmIfAvailable && z) {
                    Logger logger = CampaignManagerImpl.this.getLogger();
                    if (logger != null) {
                        logger.error(new ChildPmIdNotFound(null, StringsKt.trimIndent("\n                              childPmId not found!!!\n                              GroupPmId[" + groupPmId + "]\n                              useGroupPmIfAvailable [true] \n                    "), false, 5, null));
                    }
                    Logger logger2 = CampaignManagerImpl.this.getLogger();
                    if (logger2 != null) {
                        logger2.e("The childPmId is missing", StringsKt.trimIndent("\n                              childPmId [null]\n                              GroupPmId[" + groupPmId + "]\n                              useGroupPmIfAvailable [true] \n                "));
                    }
                }
                Logger logger3 = CampaignManagerImpl.this.getLogger();
                if (logger3 != null) {
                    logger3.computation("Property group - GDPR PM", StringsKt.trimIndent("\n                pmId[" + pmId + "]\n                childPmId[" + gdprChildPmId + "]\n                useGroupPmIfAvailable [" + useGroupPmIfAvailable + "] \n                Query Parameter pmId[" + selectPmId + "]\n            "));
                }
                return new PmUrlConfig(pmTab, CampaignManagerImpl.this.getSpConfig().messageLanguage.getValue(), CampaignManagerImpl.this.getGdprUuid(), String.valueOf(CampaignManagerImpl.this.getSpConfig().propertyId), selectPmId);
            }
        });
    }

    private final Either<PmUrlConfig> getCcpaPmConfig(final String pmId) {
        return FunctionalUtilsKt.check(new Function0<PmUrlConfig>() { // from class: com.sourcepoint.cmplibrary.campaign.CampaignManagerImpl$getCcpaPmConfig$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PmUrlConfig invoke() {
                String ccpaChildPmId = CampaignManagerImpl.this.getDataStorage().getCcpaChildPmId();
                if (ccpaChildPmId == null) {
                    ccpaChildPmId = pmId;
                }
                return new PmUrlConfig(null, CampaignManagerImpl.this.getSpConfig().messageLanguage.getValue(), CampaignManagerImpl.this.getCcpaUuid(), String.valueOf(CampaignManagerImpl.this.getSpConfig().propertyId), ccpaChildPmId, 1, null);
            }
        });
    }

    static /* synthetic */ Either getUsNatPmConfig$default(CampaignManagerImpl campaignManagerImpl, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return campaignManagerImpl.getUsNatPmConfig(str, str2, z);
    }

    private final Either<PmUrlConfig> getUsNatPmConfig(final String pmId, final String groupPmId, final boolean useGroupPmIfAvailable) {
        return FunctionalUtilsKt.check(new Function0<PmUrlConfig>() { // from class: com.sourcepoint.cmplibrary.campaign.CampaignManagerImpl$getUsNatPmConfig$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PmUrlConfig invoke() {
                String usnatChildPmId = CampaignManagerImpl.this.getDataStorage().getUsnatChildPmId();
                boolean z = usnatChildPmId == null;
                boolean z2 = groupPmId != null;
                String selectPmId = CampaignManager.INSTANCE.selectPmId(pmId, usnatChildPmId, useGroupPmIfAvailable);
                if (z2 && useGroupPmIfAvailable && z) {
                    Logger logger = CampaignManagerImpl.this.getLogger();
                    if (logger != null) {
                        logger.error(new ChildPmIdNotFound(null, StringsKt.trimIndent("\n                              childPmId not found!!!\n                              GroupPmId[" + groupPmId + "]\n                              useGroupPmIfAvailable [true] \n                    "), false, 5, null));
                    }
                    Logger logger2 = CampaignManagerImpl.this.getLogger();
                    if (logger2 != null) {
                        logger2.e("The childPmId is missing", StringsKt.trimIndent("\n                              childPmId [null]\n                              GroupPmId[" + groupPmId + "]\n                              useGroupPmIfAvailable [true] \n                "));
                    }
                }
                Logger logger3 = CampaignManagerImpl.this.getLogger();
                if (logger3 != null) {
                    logger3.computation("Property group - USNAT PM", StringsKt.trimIndent("\n                pmId[" + pmId + "]\n                childPmId[" + usnatChildPmId + "]\n                useGroupPmIfAvailable [" + useGroupPmIfAvailable + "] \n                Query Parameter pmId[" + selectPmId + "]\n            "));
                }
                String value = CampaignManagerImpl.this.getSpConfig().messageLanguage.getValue();
                USNatConsentData usNatConsentData = CampaignManagerImpl.this.getUsNatConsentData();
                return new PmUrlConfig(null, value, usNatConsentData != null ? usNatConsentData.getUuid() : null, String.valueOf(CampaignManagerImpl.this.getSpConfig().propertyId), pmId, 1, null);
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public Either<Pair<CampaignType, CampaignTemplate>> getAppliedCampaign() {
        return FunctionalUtilsKt.check(new Function0<Pair<? extends CampaignType, ? extends CampaignTemplate>>() { // from class: com.sourcepoint.cmplibrary.campaign.CampaignManagerImpl$getAppliedCampaign$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Pair<? extends CampaignType, ? extends CampaignTemplate> invoke() {
                Map map;
                Map map2;
                if (!StringsKt.isBlank(CampaignManagerImpl.this.getDataStorage().getGdprMessage())) {
                    CampaignType campaignType = CampaignType.GDPR;
                    map2 = CampaignManagerImpl.this.mapTemplate;
                    Object obj = map2.get("GDPR");
                    Intrinsics.checkNotNull(obj);
                    return new Pair<>(campaignType, obj);
                }
                if (!StringsKt.isBlank(CampaignManagerImpl.this.getDataStorage().getCcpaMessage())) {
                    CampaignType campaignType2 = CampaignType.CCPA;
                    map = CampaignManagerImpl.this.mapTemplate;
                    Object obj2 = map.get("CCPA");
                    Intrinsics.checkNotNull(obj2);
                    return new Pair<>(campaignType2, obj2);
                }
                throw new MissingPropertyException(null, "Inconsistent Legislation!!!", false, 5, null);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c9, code lost:
    
        if (r4 != null) goto L42;
     */
    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MessagesParamReq getMessageOptimizedReq(String authId, JSONObject pubData) {
        Object obj;
        Env env;
        JsonObject jsonObject;
        final String jSONObject;
        CampaignReqImpl campaignReqImpl$default;
        CampaignReqImpl campaignReqImpl$default2;
        CampaignReqImpl campaignReqImpl;
        ArrayList arrayList = new ArrayList();
        CampaignTemplate campaignTemplate = this.mapTemplate.get("GDPR");
        if (campaignTemplate != null && (campaignReqImpl = CampaignKt.toCampaignReqImpl(campaignTemplate, campaignTemplate.getTargetingParams(), campaignTemplate.getCampaignsEnv(), campaignTemplate.getGroupPmId())) != null) {
            arrayList.add(campaignReqImpl);
        }
        CampaignTemplate campaignTemplate2 = this.mapTemplate.get("CCPA");
        if (campaignTemplate2 != null && (campaignReqImpl$default2 = CampaignKt.toCampaignReqImpl$default(campaignTemplate2, campaignTemplate2.getTargetingParams(), campaignTemplate2.getCampaignsEnv(), null, 4, null)) != null) {
            arrayList.add(campaignReqImpl$default2);
        }
        CampaignTemplate campaignTemplate3 = this.mapTemplate.get("USNAT");
        if (campaignTemplate3 != null && (campaignReqImpl$default = CampaignKt.toCampaignReqImpl$default(campaignTemplate3, campaignTemplate3.getTargetingParams(), campaignTemplate3.getCampaignsEnv(), null, 4, null)) != null) {
            arrayList.add(campaignReqImpl$default);
        }
        MetaDataArg metadataArgs = MessagesApiModelExtKt.toMetadataArgs(arrayList);
        Env[] values = Env.values();
        int length = values.length;
        int i = 0;
        while (true) {
            obj = null;
            if (i >= length) {
                env = null;
                break;
            }
            env = values[i];
            if (Intrinsics.areEqual(env.name(), BuildConfig.SDK_ENV)) {
                break;
            }
            i++;
        }
        if (env == null) {
            env = Env.PROD;
        }
        Env env2 = env;
        String str = getSpConfig().propertyName;
        long j = getSpConfig().accountId;
        long j2 = getSpConfig().propertyId;
        if (pubData != null && (jSONObject = pubData.toString()) != null) {
            Either check = FunctionalUtilsKt.check(new Function0<JsonObject>() { // from class: com.sourcepoint.cmplibrary.campaign.CampaignManagerImpl$getMessageOptimizedReq$8$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final JsonObject invoke() {
                    Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                    String it = jSONObject;
                    Intrinsics.checkNotNullExpressionValue(it, "$it");
                    converter.getSerializersModule();
                    return (JsonObject) converter.decodeFromString(JsonObject.INSTANCE.serializer(), it);
                }
            });
            if (check instanceof Either.Right) {
                obj = ((Either.Right) check).getR();
            } else if (!(check instanceof Either.Left)) {
                throw new NoWhenBranchMatchedException();
            }
            jsonObject = (JsonObject) obj;
        }
        jsonObject = new JsonObject(MapsKt.emptyMap());
        return new MessagesParamReq(j, j2, authId, str, env2, metadataArgs, "", (JsonObject) null, jsonObject, (JsonObject) null, 640, (DefaultConstructorMarker) null);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public String getGroupId(CampaignType campaignType) {
        Object obj;
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Iterator<T> it = getSpConfig().campaigns.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((SpCampaign) obj).campaignType == campaignType) {
                break;
            }
        }
        SpCampaign spCampaign = (SpCampaign) obj;
        if (spCampaign != null) {
            return spCampaign.groupPmId;
        }
        return null;
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void clearConsents() {
        this.dataStorage.clearGdprConsent();
        this.dataStorage.clearCcpaConsent();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public String getAuthId() {
        return this.dataStorage.getAuthId();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setAuthId(String str) {
        this.dataStorage.saveAuthId(str);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public int getPropertyId() {
        return this.dataStorage.getPropertyId();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setPropertyId(int i) {
        this.dataStorage.setPropertyId(i);
    }

    public final boolean isNewUser() {
        JsonObject jsonObject;
        JsonElement messagesOptimizedLocalState = getMessagesOptimizedLocalState();
        int size = (messagesOptimizedLocalState == null || (jsonObject = JsonElementKt.getJsonObject(messagesOptimizedLocalState)) == null) ? 0 : jsonObject.size();
        if (getMessagesOptimizedLocalState() != null && size != 0) {
            if (getGdprUuid() == null) {
                USNatConsentData usNatConsentData = getUsNatConsentData();
                if ((usNatConsentData != null ? usNatConsentData.getUuid() : null) == null) {
                    CcpaCS ccpaConsentStatus = getCcpaConsentStatus();
                    if ((ccpaConsentStatus != null ? ccpaConsentStatus.getNewUser() : null) != null) {
                        CcpaCS ccpaConsentStatus2 = getCcpaConsentStatus();
                        if (ccpaConsentStatus2 != null ? Intrinsics.areEqual((Object) ccpaConsentStatus2.getNewUser(), (Object) true) : false) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean getShouldCallMessages() {
        boolean z;
        Logger logger;
        ConsentStatus consentStatus;
        boolean z2 = true;
        if (SpConfigExtKt.isIncluded(getSpConfig(), CampaignType.GDPR)) {
            GdprCS gdprConsentStatus = getGdprConsentStatus();
            if (!((gdprConsentStatus == null || (consentStatus = gdprConsentStatus.getConsentStatus()) == null) ? false : Intrinsics.areEqual((Object) consentStatus.getConsentedAll(), (Object) true))) {
                z = true;
                boolean isIncluded = SpConfigExtKt.isIncluded(getSpConfig(), CampaignType.CCPA);
                boolean isIncluded2 = SpConfigExtKt.isIncluded(getSpConfig(), CampaignType.USNAT);
                if (!isNewUser() && !isIncluded && !z && !isIncluded2) {
                    z2 = false;
                }
                logger = this.logger;
                if (logger != null) {
                    logger.computation("shouldCallMessages", StringsKt.trimIndent("\n                isNewUser[" + isNewUser() + "]\n                ccpaToBeCompleted[" + isIncluded + "]\n                gdprToBeCompleted[" + z + "]\n                usNatToBeCompleted[" + isIncluded2 + "]\n                shouldCallMessages[" + z2 + "]  \n                "));
                }
                return z2;
            }
        }
        z = false;
        boolean isIncluded3 = SpConfigExtKt.isIncluded(getSpConfig(), CampaignType.CCPA);
        boolean isIncluded22 = SpConfigExtKt.isIncluded(getSpConfig(), CampaignType.USNAT);
        if (!isNewUser()) {
            z2 = false;
        }
        logger = this.logger;
        if (logger != null) {
        }
        return z2;
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public boolean shouldCallConsentStatus(String authId) {
        Map<String, JsonElement> gppData;
        JsonObject jsonObject;
        boolean z = this.dataStorage.getGdprConsentUuid() != null;
        boolean z2 = this.dataStorage.getCcpaConsentUuid() != null;
        USNatConsentData usNatConsentData = getUsNatConsentData();
        boolean z3 = (usNatConsentData != null ? usNatConsentData.getUuid() : null) != null;
        JsonElement messagesOptimizedLocalState = getMessagesOptimizedLocalState();
        boolean z4 = (messagesOptimizedLocalState == null || (jsonObject = JsonElementKt.getJsonObject(messagesOptimizedLocalState)) == null || !jsonObject.isEmpty()) ? false : true;
        boolean containsKey = this.dataStorage.getPreference().getAll().containsKey("sp.key.local.state");
        boolean containsKey2 = this.dataStorage.getPreference().getAll().containsKey("key_local_state");
        boolean z5 = getCcpaConsentStatus() != null && getUsNatConsentData() == null && SpConfigExtKt.isIncluded(getSpConfig(), CampaignType.USNAT);
        CcpaCS ccpaConsentStatus = getCcpaConsentStatus();
        return ((z || z2 || z3) && z4) || containsKey || containsKey2 || (ccpaConsentStatus != null && ((gppData = ccpaConsentStatus.getGppData()) == null || gppData.isEmpty())) || this.usnatApplicableSectionChanged || z5 || authId != null;
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void consentStatusLog(String authId) {
        Map<String, JsonElement> gppData;
        JsonObject jsonObject;
        if (this.logger == null) {
            return;
        }
        boolean z = this.dataStorage.getGdprConsentUuid() != null;
        boolean z2 = this.dataStorage.getCcpaConsentUuid() != null;
        USNatConsentData usNatConsentData = getUsNatConsentData();
        boolean z3 = (usNatConsentData != null ? usNatConsentData.getUuid() : null) != null;
        JsonElement messagesOptimizedLocalState = getMessagesOptimizedLocalState();
        boolean z4 = (messagesOptimizedLocalState == null || (jsonObject = JsonElementKt.getJsonObject(messagesOptimizedLocalState)) == null || !jsonObject.isEmpty()) ? false : true;
        boolean containsKey = this.dataStorage.getPreference().getAll().containsKey("sp.key.local.state");
        boolean containsKey2 = this.dataStorage.getPreference().getAll().containsKey("key_local_state");
        boolean z5 = getCcpaConsentStatus() != null && getUsNatConsentData() == null && SpConfigExtKt.isIncluded(getSpConfig(), CampaignType.USNAT);
        CcpaCS ccpaConsentStatus = getCcpaConsentStatus();
        boolean z6 = ccpaConsentStatus != null && ((gppData = ccpaConsentStatus.getGppData()) == null || gppData.isEmpty());
        boolean z7 = ((z || z2 || z3) && z4) || containsKey || containsKey2 || this.usnatApplicableSectionChanged || z5 || authId != null || z6;
        Logger logger = this.logger;
        String trimIndent = StringsKt.trimIndent(" shouldCallConsentStatus[" + z7 + "]\n            ");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("(GdprUuid ", z);
        jSONObject2.put("OR  CcpaUuid", z2);
        jSONObject2.put("OR  UsnatUuid)", z3);
        jSONObject2.put("AND isLocalStateEmpty", z4);
        Unit unit = Unit.INSTANCE;
        jSONObject.put("consentsStoredDetails", jSONObject2);
        jSONObject.put(" consentsStored", (z || z2 || z3) && z4);
        jSONObject.put(" OR isV630LocalStatePresent", containsKey);
        jSONObject.put(" OR isV690LocalStatePresent", containsKey2);
        jSONObject.put(" OR usnatApplicableSectionChanged", this.usnatApplicableSectionChanged);
        jSONObject.put(" OR storedCcpaWithoutGPP", z6);
        jSONObject.put(" OR transitionCcpa2Usnat", z5);
        jSONObject.put(" OR authId", authId != null);
        jSONObject.put("return shouldCallConsentStatus", z7);
        Unit unit2 = Unit.INSTANCE;
        logger.computation("shouldCallConsentStatus", trimIndent, jSONObject);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public MessageMetaData getGdprMessageMetaData() {
        String gdprMessageMetaData = this.dataStorage.getGdprMessageMetaData();
        if (gdprMessageMetaData == null) {
            return null;
        }
        Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
        converter.getSerializersModule();
        return (MessageMetaData) converter.decodeFromString(MessageMetaData.INSTANCE.serializer(), gdprMessageMetaData);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setGdprMessageMetaData(MessageMetaData messageMetaData) {
        String str;
        if (messageMetaData != null) {
            Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
            converter.getSerializersModule();
            str = converter.encodeToString(MessageMetaData.INSTANCE.serializer(), messageMetaData);
        } else {
            str = null;
        }
        this.dataStorage.setGdprMessageMetaData(str);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public MessageMetaData getCcpaMessageMetaData() {
        String ccpaMessageMetaData = this.dataStorage.getCcpaMessageMetaData();
        if (ccpaMessageMetaData == null) {
            return null;
        }
        Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
        converter.getSerializersModule();
        return (MessageMetaData) converter.decodeFromString(MessageMetaData.INSTANCE.serializer(), ccpaMessageMetaData);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setCcpaMessageMetaData(MessageMetaData messageMetaData) {
        String str;
        if (messageMetaData != null) {
            Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
            converter.getSerializersModule();
            str = converter.encodeToString(MessageMetaData.INSTANCE.serializer(), messageMetaData);
        } else {
            str = null;
        }
        this.dataStorage.setCcpaMessageMetaData(str);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public GdprCS getGdprConsentStatus() {
        String gdprConsentStatus = this.dataStorage.getGdprConsentStatus();
        if (gdprConsentStatus == null) {
            return null;
        }
        Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
        converter.getSerializersModule();
        GdprCS gdprCS = (GdprCS) converter.decodeFromString(GdprCS.INSTANCE.serializer(), gdprConsentStatus);
        if (gdprCS != null) {
            return GdprCS.copy$default(gdprCS, Boolean.valueOf(this.dataStorage.getGdprApplies()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16777214, null);
        }
        return null;
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setGdprConsentStatus(GdprCS gdprCS) {
        String str;
        Map<String, JsonElement> tCData;
        Unit unit = null;
        if (gdprCS != null) {
            Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
            converter.getSerializersModule();
            str = converter.encodeToString(GdprCS.INSTANCE.serializer(), gdprCS);
        } else {
            str = null;
        }
        DataStorage dataStorage = this.dataStorage;
        dataStorage.setGdprConsentStatus(str);
        if (gdprCS != null && (tCData = gdprCS.getTCData()) != null) {
            dataStorage.setTcData(tCData);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            dataStorage.clearTCData();
        }
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public CcpaCS getCcpaConsentStatus() {
        CcpaCS copy;
        MetaDataResp.Ccpa ccpa;
        String ccpaConsentStatus = this.dataStorage.getCcpaConsentStatus();
        Boolean bool = null;
        if (ccpaConsentStatus != null) {
            Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
            converter.getSerializersModule();
            CcpaCS ccpaCS = (CcpaCS) converter.decodeFromString(CcpaCS.INSTANCE.serializer(), ccpaConsentStatus);
            if (ccpaCS != null) {
                MetaDataResp metaDataResp = getMetaDataResp();
                if (metaDataResp != null && (ccpa = metaDataResp.getCcpa()) != null) {
                    bool = ccpa.getApplies();
                }
                copy = ccpaCS.copy((r32 & 1) != 0 ? ccpaCS.applies : bool, (r32 & 2) != 0 ? ccpaCS.consentedAll : null, (r32 & 4) != 0 ? ccpaCS.dateCreated : null, (r32 & 8) != 0 ? ccpaCS.gpcEnabled : null, (r32 & 16) != 0 ? ccpaCS.newUser : null, (r32 & 32) != 0 ? ccpaCS.rejectedAll : null, (r32 & 64) != 0 ? ccpaCS.rejectedCategories : null, (r32 & 128) != 0 ? ccpaCS.rejectedVendors : null, (r32 & 256) != 0 ? ccpaCS.signedLspa : null, (r32 & 512) != 0 ? ccpaCS.uspstring : null, (r32 & 1024) != 0 ? ccpaCS.status : null, (r32 & 2048) != 0 ? ccpaCS.gppData : null, (r32 & 4096) != 0 ? ccpaCS.uuid : null, (r32 & 8192) != 0 ? ccpaCS.webConsentPayload : null, (r32 & 16384) != 0 ? ccpaCS.expirationDate : null);
                return copy;
            }
        }
        return null;
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setCcpaConsentStatus(CcpaCS ccpaCS) {
        String str;
        if (ccpaCS != null) {
            Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
            converter.getSerializersModule();
            str = converter.encodeToString(CcpaCS.INSTANCE.serializer(), ccpaCS);
        } else {
            str = null;
        }
        DataStorage dataStorage = this.dataStorage;
        dataStorage.setCcpaConsentStatus(str);
        dataStorage.setGppData(ccpaCS != null ? ccpaCS.getGppData() : null);
        dataStorage.setUspstring(ccpaCS != null ? ccpaCS.getUspstring() : null);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public USNatConsentData getUsNatConsentData() {
        MetaDataResp.USNat usNat;
        String usNatConsentData = this.dataStorage.getUsNatConsentData();
        Boolean bool = null;
        if (usNatConsentData != null) {
            Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
            converter.getSerializersModule();
            USNatConsentData uSNatConsentData = (USNatConsentData) converter.decodeFromString(USNatConsentData.INSTANCE.serializer(), usNatConsentData);
            if (uSNatConsentData != null) {
                MetaDataResp metaDataResp = getMetaDataResp();
                if (metaDataResp != null && (usNat = metaDataResp.getUsNat()) != null) {
                    bool = usNat.getApplies();
                }
                return USNatConsentData.copy$default(uSNatConsentData, bool, null, null, null, null, null, null, null, null, null, null, null, null, 8190, null);
            }
        }
        return null;
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setUsNatConsentData(USNatConsentData uSNatConsentData) {
        String str;
        if (uSNatConsentData != null) {
            Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
            converter.getSerializersModule();
            str = converter.encodeToString(USNatConsentData.INSTANCE.serializer(), uSNatConsentData);
        } else {
            str = null;
        }
        DataStorage dataStorage = this.dataStorage;
        dataStorage.setUsNatConsentData(str);
        dataStorage.setGppData(uSNatConsentData != null ? uSNatConsentData.getGppData() : null);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public JsonElement getMessagesOptimizedLocalState() {
        String messagesOptimizedLocalState = this.dataStorage.getMessagesOptimizedLocalState();
        if (messagesOptimizedLocalState == null) {
            return null;
        }
        Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
        converter.getSerializersModule();
        return (JsonElement) converter.decodeFromString(JsonElement.INSTANCE.serializer(), messagesOptimizedLocalState);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setMessagesOptimizedLocalState(JsonElement jsonElement) {
        String str;
        if (jsonElement != null) {
            Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
            converter.getSerializersModule();
            str = converter.encodeToString(JsonElement.INSTANCE.serializer(), jsonElement);
        } else {
            str = null;
        }
        this.dataStorage.setMessagesOptimizedLocalState(str);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public JsonElement getNonKeyedLocalState() {
        String nonKeyedLocalState = this.dataStorage.getNonKeyedLocalState();
        if (nonKeyedLocalState == null) {
            return null;
        }
        Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
        converter.getSerializersModule();
        return (JsonElement) converter.decodeFromString(JsonElement.INSTANCE.serializer(), nonKeyedLocalState);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setNonKeyedLocalState(JsonElement jsonElement) {
        String str;
        if (jsonElement != null) {
            Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
            converter.getSerializersModule();
            str = converter.encodeToString(JsonElement.INSTANCE.serializer(), jsonElement);
        } else {
            str = null;
        }
        this.dataStorage.setNonKeyedLocalState(str);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public String getGdprUuid() {
        return this.dataStorage.getGdprConsentUuid();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setGdprUuid(String str) {
        this.dataStorage.setGdprConsentUuid(str);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public String getCcpaUuid() {
        return this.dataStorage.getCcpaConsentUuid();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setCcpaUuid(String str) {
        this.dataStorage.setCcpaConsentUuid(str);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public boolean getHasLocalData() {
        return (this.dataStorage.getGdprConsentStatus() == null && this.dataStorage.getCcpaConsentStatus() == null) ? false : true;
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public String getGdprAdditionsChangeDate() {
        MetaDataResp.Gdpr gdpr;
        MetaDataResp metaDataResp = getMetaDataResp();
        if (metaDataResp == null || (gdpr = metaDataResp.getGdpr()) == null) {
            return null;
        }
        return gdpr.getAdditionsChangeDate();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public String getGdprLegalBasisChangeDate() {
        MetaDataResp.Gdpr gdpr;
        MetaDataResp metaDataResp = getMetaDataResp();
        if (metaDataResp == null || (gdpr = metaDataResp.getGdpr()) == null) {
            return null;
        }
        return gdpr.getLegalBasisChangeDate();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public String getUsnatAdditionsChangeDate() {
        MetaDataResp.USNat usNat;
        MetaDataResp metaDataResp = getMetaDataResp();
        if (metaDataResp == null || (usNat = metaDataResp.getUsNat()) == null) {
            return null;
        }
        return usNat.getAdditionsChangeDate();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void handleAuthIdOrPropertyIdChange(String newAuthId, int newPropertyId) {
        boolean z = true;
        boolean z2 = (newAuthId == null || Intrinsics.areEqual(newAuthId, getAuthId()) || getAuthId() == null) ? false : true;
        boolean z3 = newPropertyId != getPropertyId();
        boolean z4 = getPropertyId() != 0;
        if (z2 || (z3 && z4)) {
            this.dataStorage.clearAll();
        }
        Logger logger = this.logger;
        if (logger != null) {
            boolean z5 = z3 && z4;
            if (!z2 && (!z3 || !z4)) {
                z = false;
            }
            logger.computation("flush local data", StringsKt.trimIndent("\n                isNewAuthId[" + z2 + "] \n                isNewPropertyId && hasPreviousPropertyId[" + z5 + "]\n                return [" + z + "]\n            "));
        }
        setAuthId(newAuthId);
        setPropertyId(newPropertyId);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void handleMetaDataResponse(MetaDataResp response) {
        CcpaCS ccpaCS;
        MetaDataResp.USNat usNat;
        MetaDataResp.Gdpr gdpr;
        if (hasGdprVendorListIdChanged((response == null || (gdpr = response.getGdpr()) == null) ? null : gdpr.getVendorListId())) {
            this.dataStorage.deleteGdprConsent();
        }
        if (hasUsNatVendorListIdChanged((response == null || (usNat = response.getUsNat()) == null) ? null : usNat.getVendorListId())) {
            this.dataStorage.deleteUsNatConsent();
        }
        this.usnatApplicableSectionChanged = hasUsnatApplicableSectionsChanged(response);
        setMetaDataResp(response);
        if (response == null) {
            return;
        }
        MetaDataResp.Ccpa ccpa = response.getCcpa();
        if (ccpa != null) {
            CcpaCS ccpaConsentStatus = getCcpaConsentStatus();
            if (ccpaConsentStatus != null) {
                ccpaCS = ccpaConsentStatus.copy((r32 & 1) != 0 ? ccpaConsentStatus.applies : ccpa.getApplies(), (r32 & 2) != 0 ? ccpaConsentStatus.consentedAll : null, (r32 & 4) != 0 ? ccpaConsentStatus.dateCreated : null, (r32 & 8) != 0 ? ccpaConsentStatus.gpcEnabled : null, (r32 & 16) != 0 ? ccpaConsentStatus.newUser : null, (r32 & 32) != 0 ? ccpaConsentStatus.rejectedAll : null, (r32 & 64) != 0 ? ccpaConsentStatus.rejectedCategories : null, (r32 & 128) != 0 ? ccpaConsentStatus.rejectedVendors : null, (r32 & 256) != 0 ? ccpaConsentStatus.signedLspa : null, (r32 & 512) != 0 ? ccpaConsentStatus.uspstring : SpUtils.updateCcpaUspString(getCcpaConsentStatus(), this.logger), (r32 & 1024) != 0 ? ccpaConsentStatus.status : null, (r32 & 2048) != 0 ? ccpaConsentStatus.gppData : null, (r32 & 4096) != 0 ? ccpaConsentStatus.uuid : null, (r32 & 8192) != 0 ? ccpaConsentStatus.webConsentPayload : null, (r32 & 16384) != 0 ? ccpaConsentStatus.expirationDate : null);
            } else {
                ccpaCS = null;
            }
            setCcpaConsentStatus(ccpaCS);
            Double sampleRate = ccpa.getSampleRate();
            if (sampleRate != null) {
                double doubleValue = sampleRate.doubleValue();
                if (doubleValue != this.dataStorage.getCcpaSampleRate()) {
                    this.dataStorage.setCcpaSampleRate(doubleValue);
                    this.dataStorage.setCcpaSampled(null);
                }
            }
        }
        MetaDataResp.Gdpr gdpr2 = response.getGdpr();
        if (gdpr2 != null) {
            GdprCS gdprConsentStatus = getGdprConsentStatus();
            setGdprConsentStatus(gdprConsentStatus != null ? GdprCS.copy$default(gdprConsentStatus, gdpr2.getApplies(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16777214, null) : null);
            String childPmId = gdpr2.getChildPmId();
            if (childPmId != null) {
                this.dataStorage.setGdprChildPmId(childPmId);
            }
            Double sampleRate2 = gdpr2.getSampleRate();
            if (sampleRate2 != null) {
                double doubleValue2 = sampleRate2.doubleValue();
                if (doubleValue2 != this.dataStorage.getGdprSampleRate()) {
                    this.dataStorage.setGdprSampleRate(doubleValue2);
                    this.dataStorage.setGdprSampled(null);
                }
            }
        }
        MetaDataResp.USNat usNat2 = response.getUsNat();
        if (usNat2 != null) {
            USNatConsentData usNatConsentData = getUsNatConsentData();
            setUsNatConsentData(usNatConsentData != null ? USNatConsentData.copy$default(usNatConsentData, usNat2.getApplies(), null, null, null, null, null, null, null, null, null, null, null, null, 8190, null) : null);
            Double sampleRate3 = usNat2.getSampleRate();
            if (sampleRate3 != null) {
                double doubleValue3 = sampleRate3.doubleValue();
                if (doubleValue3 == this.dataStorage.getUsnatSampleRate()) {
                    return;
                }
                this.dataStorage.setUsnatSampleRate(doubleValue3);
                this.dataStorage.setUsnatSampled(null);
            }
        }
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public boolean hasUsnatApplicableSectionsChanged(MetaDataResp response) {
        MetaDataResp.USNat usNat;
        if (!SpConfigExtKt.isIncluded(getSpConfig(), CampaignType.USNAT)) {
            return false;
        }
        MetaDataResp metaDataResp = getMetaDataResp();
        if ((metaDataResp != null ? metaDataResp.getUsNat() : null) == null || response == null) {
            return false;
        }
        MetaDataResp metaDataResp2 = getMetaDataResp();
        JsonElement applicableSections = (metaDataResp2 == null || (usNat = metaDataResp2.getUsNat()) == null) ? null : usNat.getApplicableSections();
        return !Intrinsics.areEqual(applicableSections, response.getUsNat() != null ? r3.getApplicableSections() : null);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public boolean hasGdprVendorListIdChanged(String gdprVendorListId) {
        MetaDataResp.Gdpr gdpr;
        MetaDataResp metaDataResp = getMetaDataResp();
        String vendorListId = (metaDataResp == null || (gdpr = metaDataResp.getGdpr()) == null) ? null : gdpr.getVendorListId();
        return (gdprVendorListId == null || vendorListId == null || Intrinsics.areEqual(vendorListId, gdprVendorListId)) ? false : true;
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public boolean hasUsNatVendorListIdChanged(String usNatVendorListId) {
        MetaDataResp.USNat usNat;
        MetaDataResp metaDataResp = getMetaDataResp();
        String vendorListId = (metaDataResp == null || (usNat = metaDataResp.getUsNat()) == null) ? null : usNat.getVendorListId();
        return (usNatVendorListId == null || vendorListId == null || Intrinsics.areEqual(vendorListId, usNatVendorListId)) ? false : true;
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public ConsentStatus reConsentGdpr(String additionsChangeDate, String legalBasisChangeDate) {
        GdprCS gdprConsentStatus = getGdprConsentStatus();
        String dateCreated = gdprConsentStatus != null ? gdprConsentStatus.getDateCreated() : null;
        GdprCS gdprConsentStatus2 = getGdprConsentStatus();
        ConsentStatus consentStatus = gdprConsentStatus2 != null ? gdprConsentStatus2.getConsentStatus() : null;
        if (dateCreated == null || consentStatus == null || additionsChangeDate == null || legalBasisChangeDate == null) {
            return null;
        }
        Date parse = getFormatter().parse(dateCreated);
        Date parse2 = getFormatter().parse(additionsChangeDate);
        Date parse3 = getFormatter().parse(legalBasisChangeDate);
        boolean before = parse != null ? parse.before(parse2) : false;
        boolean before2 = parse != null ? parse.before(parse3) : false;
        boolean z = before || before2;
        Map mapOf = MapsKt.mapOf(TuplesKt.to("dataRecordedConsentDate", String.valueOf(parse)), TuplesKt.to("additionsChangeDateDate", String.valueOf(parse2)), TuplesKt.to("legalBasisChangeDateConsentDate", String.valueOf(parse3)), TuplesKt.to("creationLessThanAdditions OR creationLessThanLegalBasis", String.valueOf(z)));
        Logger logger = this.logger;
        if (logger != null) {
            String jSONObject = new JSONObject(mapOf).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
            logger.computation("Reconsent updatedGdprConsentStatus", jSONObject, new JSONObject(mapOf));
        }
        if (!z) {
            return null;
        }
        if (before) {
            consentStatus.setVendorListAdditions(true);
        }
        if (before2) {
            consentStatus.setLegalBasisChanges(true);
        }
        if (Intrinsics.areEqual((Object) consentStatus.getConsentedAll(), (Object) true)) {
            ConsentStatus.GranularStatus granularStatus = consentStatus.getGranularStatus();
            if (granularStatus != null) {
                granularStatus.setPreviousOptInAll(true);
            }
            consentStatus.setConsentedAll(false);
        }
        return consentStatus;
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public USNatConsentStatus reConsentUsnat(String additionsChangeDate) {
        USNatConsentData usNatConsentData = getUsNatConsentData();
        String dateCreated = usNatConsentData != null ? usNatConsentData.getDateCreated() : null;
        USNatConsentData usNatConsentData2 = getUsNatConsentData();
        USNatConsentStatus consentStatus = usNatConsentData2 != null ? usNatConsentData2.getConsentStatus() : null;
        if (dateCreated == null || consentStatus == null || additionsChangeDate == null) {
            return null;
        }
        Date parse = getFormatter().parse(dateCreated);
        Date parse2 = getFormatter().parse(additionsChangeDate);
        boolean before = parse != null ? parse.before(parse2) : false;
        Map mapOf = MapsKt.mapOf(TuplesKt.to("dataRecordedConsentDate", String.valueOf(parse)), TuplesKt.to("additionsChangeDateDate", String.valueOf(parse2)), TuplesKt.to("creationLessThanAdditions", String.valueOf(before)));
        Logger logger = this.logger;
        if (logger != null) {
            String jSONObject = new JSONObject(mapOf).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
            logger.computation("Reconsent updateUSNATConsent", jSONObject, new JSONObject(mapOf));
        }
        if (!before) {
            return null;
        }
        consentStatus.setVendorListAdditions(true);
        if (Intrinsics.areEqual((Object) consentStatus.getConsentedToAll(), (Object) true)) {
            USNatConsentStatus.USNatGranularStatus granularStatus = consentStatus.getGranularStatus();
            if (granularStatus != null) {
                granularStatus.setPreviousOptInAll(true);
            }
            consentStatus.setConsentedToAll(false);
        }
        return consentStatus;
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void handleOldLocalData() {
        if (this.dataStorage.getPreference().contains("sp.key.local.state") || this.dataStorage.getPreference().contains("key_local_state")) {
            SharedPreferences.Editor edit = this.dataStorage.getPreference().edit();
            edit.remove("sp.key.local.state");
            edit.remove("key_local_state");
            edit.remove("sp.key.gdpr.applies");
            edit.remove("sp.key.gdpr.message.subcategory");
            edit.remove("key_property_id");
            edit.remove("key_ccpa");
            edit.remove("key_gdpr");
            edit.remove("ccpa_consent_resp");
            edit.remove("gdpr_consent_resp");
            edit.apply();
        }
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public String getGdprDateCreated() {
        return this.dataStorage.getGdprDateCreated();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setGdprDateCreated(String str) {
        this.dataStorage.setGdprDateCreated(str);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public String getCcpaDateCreated() {
        return this.dataStorage.getCcpaDateCreated();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setCcpaDateCreated(String str) {
        this.dataStorage.setCcpaDateCreated(str);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public MetaDataResp getMetaDataResp() {
        String metaDataResp = this.dataStorage.getMetaDataResp();
        if (metaDataResp == null) {
            return null;
        }
        Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
        converter.getSerializersModule();
        return (MetaDataResp) converter.decodeFromString(MetaDataResp.INSTANCE.serializer(), metaDataResp);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setMetaDataResp(MetaDataResp metaDataResp) {
        String str;
        if (metaDataResp != null) {
            Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
            converter.getSerializersModule();
            str = converter.encodeToString(MetaDataResp.INSTANCE.serializer(), metaDataResp);
        } else {
            str = null;
        }
        this.dataStorage.setMetaDataResp(str);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public ChoiceResp getChoiceResp() {
        String choiceResp = this.dataStorage.getChoiceResp();
        if (choiceResp == null) {
            return null;
        }
        Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
        converter.getSerializersModule();
        return (ChoiceResp) converter.decodeFromString(ChoiceResp.INSTANCE.serializer(), choiceResp);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setChoiceResp(ChoiceResp choiceResp) {
        String str;
        if (choiceResp != null) {
            Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
            converter.getSerializersModule();
            str = converter.encodeToString(ChoiceResp.INSTANCE.serializer(), choiceResp);
        } else {
            str = null;
        }
        this.dataStorage.setChoiceResp(str);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public Instant getDataRecordedConsent() {
        String dataRecordedConsent = this.dataStorage.getDataRecordedConsent();
        if (dataRecordedConsent != null) {
            return Instant.parse(dataRecordedConsent);
        }
        return null;
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setDataRecordedConsent(Instant instant) {
        this.dataStorage.setDataRecordedConsent(instant != null ? instant.toString() : null);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public JsonObject getGdprPvDataBody(MessagesParamReq messageReq) {
        Intrinsics.checkNotNullParameter(messageReq, "messageReq");
        long accountId = messageReq.getAccountId();
        long propertyId = messageReq.getPropertyId();
        JsonObject pubData = messageReq.getPubData();
        MetaDataResp metaDataResp = getMetaDataResp();
        return PvDataApiModelExtKt.toPvDataBody(getGdprConsentStatus(), Long.valueOf(accountId), Long.valueOf(propertyId), getGdprMessageMetaData(), null, null, null, metaDataResp, pubData);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public JsonObject getCcpaPvDataBody(MessagesParamReq messageReq) {
        Intrinsics.checkNotNullParameter(messageReq, "messageReq");
        long accountId = messageReq.getAccountId();
        long propertyId = messageReq.getPropertyId();
        JsonObject pubData = messageReq.getPubData();
        MetaDataResp metaDataResp = getMetaDataResp();
        return PvDataApiModelExtKt.toPvDataBody(null, Long.valueOf(accountId), Long.valueOf(propertyId), null, getCcpaMessageMetaData(), getCcpaConsentStatus(), null, metaDataResp, pubData);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public JsonObject getUsNatPvDataBody(MessagesParamReq messageReq) {
        Intrinsics.checkNotNullParameter(messageReq, "messageReq");
        long accountId = messageReq.getAccountId();
        long propertyId = messageReq.getPropertyId();
        JsonObject pubData = messageReq.getPubData();
        MetaDataResp metaDataResp = getMetaDataResp();
        return PvDataApiModelExtKt.toPvDataBody(null, Long.valueOf(accountId), Long.valueOf(propertyId), null, null, null, getUsNatConsentData(), metaDataResp, pubData);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public boolean isGdprExpired() {
        String gdprExpirationDate = this.dataStorage.getGdprExpirationDate();
        Date parse = gdprExpirationDate != null ? getFormatter().parse(gdprExpirationDate) : null;
        if (parse == null) {
            return false;
        }
        return new Date().after(parse);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public boolean isCcpaExpired() {
        String ccpaExpirationDate = this.dataStorage.getCcpaExpirationDate();
        Date parse = ccpaExpirationDate != null ? getFormatter().parse(ccpaExpirationDate) : null;
        if (parse == null) {
            return false;
        }
        return new Date().after(parse);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public boolean isUsnatExpired() {
        String expirationDate;
        USNatConsentData usNatConsentData = getUsNatConsentData();
        Date parse = (usNatConsentData == null || (expirationDate = usNatConsentData.getExpirationDate()) == null) ? null : getFormatter().parse(expirationDate);
        if (parse == null) {
            return false;
        }
        return new Date().after(parse);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public ChoiceResp getStoreChoiceResp() {
        return new ChoiceResp(getCcpaConsentStatus(), getGdprConsentStatus(), getUsNatConsentData());
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void deleteExpiredConsents() {
        if (isUsnatExpired()) {
            this.dataStorage.deleteUsNatConsent();
        }
        if (isCcpaExpired()) {
            this.dataStorage.deleteCcpaConsent();
        }
        if (isGdprExpired()) {
            this.dataStorage.deleteGdprConsent();
        }
        Logger logger = this.logger;
        if (logger != null) {
            logger.computation("Expiration Date", StringsKt.trimIndent("\n                isGdprExpired[" + isGdprExpired() + "] \n                isCcpaExpired[" + isCcpaExpired() + "] \n                isUsnatExpired[" + isUsnatExpired() + "] \n            "));
        }
    }
}
