package com.sourcepoint.cmplibrary.data;

import com.ironsource.C3040d4;
import com.ironsource.C3337ue;
import com.ironsource.D5;
import com.sourcepoint.cmplibrary.campaign.CampaignManager;
import com.sourcepoint.cmplibrary.consent.ConsentManager;
import com.sourcepoint.cmplibrary.consent.ConsentManagerUtils;
import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.core.ExecutorManager;
import com.sourcepoint.cmplibrary.data.local.DataStorage;
import com.sourcepoint.cmplibrary.data.network.NetworkClient;
import com.sourcepoint.cmplibrary.data.network.connection.ConnectionManager;
import com.sourcepoint.cmplibrary.data.network.converter.ExceptionUtilsKt;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverter;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImplKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.CCPA;
import com.sourcepoint.cmplibrary.data.network.model.optimized.Campaigns;
import com.sourcepoint.cmplibrary.data.network.model.optimized.CcpaCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatus;
import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatusParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatusResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GDPR;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GdprCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MessageMetaData;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesApiModelExtKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataApiModelKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataArg;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.PostChoiceApiModelExtKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.PostChoiceParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.PvDataParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.PvDataResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentData;
import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentStatus;
import com.sourcepoint.cmplibrary.data.network.model.optimized.choice.ChoiceResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.choice.ChoiceTypeParam;
import com.sourcepoint.cmplibrary.data.network.model.optimized.choice.GetChoiceParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.includeData.IncludeDataKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.messages.OperatingSystemInfoParam;
import com.sourcepoint.cmplibrary.data.network.util.CampaignsEnv;
import com.sourcepoint.cmplibrary.data.network.util.Env;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.exception.ConsentLibExceptionK;
import com.sourcepoint.cmplibrary.exception.InvalidConsentResponse;
import com.sourcepoint.cmplibrary.exception.Logger;
import com.sourcepoint.cmplibrary.exception.NoInternetConnectionException;
import com.sourcepoint.cmplibrary.model.CampaignReq;
import com.sourcepoint.cmplibrary.model.CampaignTemplate;
import com.sourcepoint.cmplibrary.model.ConsentActionImpl;
import com.sourcepoint.cmplibrary.model.ConsentActionImplKt;
import com.sourcepoint.cmplibrary.model.CustomConsentReq;
import com.sourcepoint.cmplibrary.model.CustomConsentResp;
import com.sourcepoint.cmplibrary.model.MessageLanguage;
import com.sourcepoint.cmplibrary.model.PMTab;
import com.sourcepoint.cmplibrary.model.PmUrlConfig;
import com.sourcepoint.cmplibrary.model.exposed.ActionType;
import com.sourcepoint.cmplibrary.model.exposed.CcpaStatus;
import com.sourcepoint.cmplibrary.model.exposed.GDPRPurposeGrants;
import com.sourcepoint.cmplibrary.model.exposed.MessageSubCategory;
import com.sourcepoint.cmplibrary.model.exposed.SPConsents;
import com.sourcepoint.cmplibrary.model.exposed.SpConfig;
import com.sourcepoint.cmplibrary.util.FunctionalUtilsKt;
import com.sourcepoint.cmplibrary.util.extensions.ActionTypeExtKt;
import com.sourcepoint.cmplibrary.util.extensions.JSONObjectExtKt;
import com.sourcepoint.cmplibrary.util.extensions.MapExtKt;
import com.sourcepoint.cmplibrary.util.extensions.SpConfigExtKt;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ServiceImpl.kt */
@Metadata(d1 = {"\u0000\u0084\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B=\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u001f\u0010\u0083\u0001\u001a\u00030\u0084\u00012\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0096\u0001J\u000b\u0010\u0089\u0001\u001a\u00030\u0084\u0001H\u0096\u0001J\u0015\u0010\u008a\u0001\u001a\u00030\u0084\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0001J&\u0010\u008b\u0001\u001a\n\u0012\u0005\u0012\u00030\u008d\u00010\u008c\u00012\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\b\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0096\u0001J$\u0010\u0092\u0001\u001a\t\u0012\u0004\u0012\u00020A0\u008c\u00012\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\b\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0016J\u000b\u0010\u0093\u0001\u001a\u00030\u0084\u0001H\u0096\u0001J \u0010\u0094\u0001\u001a\u0018\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030\u0086\u0001\u0012\u0005\u0012\u00030\u0088\u00010\u0095\u00010\u008c\u0001H\u0096\u0001J\u001c\u0010\u0096\u0001\u001a\n\u0012\u0005\u0012\u00030\u0088\u00010\u008c\u00012\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0096\u0001J\u0015\u0010\u0097\u0001\u001a\u00030\u0098\u00012\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0096\u0001J\u001b\u0010\u009b\u0001\u001a\t\u0012\u0004\u0012\u0002030\u008c\u00012\b\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0096\u0001J\u001c\u0010\u009e\u0001\u001a\n\u0012\u0005\u0012\u00030\u009f\u00010\u008c\u00012\b\u0010\u009c\u0001\u001a\u00030 \u0001H\u0096\u0001J\u0015\u0010¡\u0001\u001a\u00030\u0098\u00012\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0096\u0001J\u0016\u0010¢\u0001\u001a\u0004\u0018\u00010\u00122\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0096\u0001J!\u0010£\u0001\u001a\u00030\u009a\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u0001H\u0096\u0001J\u001c\u0010¦\u0001\u001a\n\u0012\u0005\u0012\u00030§\u00010\u008c\u00012\b\u0010\u009c\u0001\u001a\u00030\u009a\u0001H\u0096\u0001J[\u0010¦\u0001\u001a\u00030\u0084\u00012\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0016\u0010¨\u0001\u001a\u0011\u0012\u0005\u0012\u00030§\u0001\u0012\u0005\u0012\u00030\u0084\u00010©\u00012\u000f\u0010ª\u0001\u001a\n\u0012\u0005\u0012\u00030\u0084\u00010«\u00012\u001c\u0010¬\u0001\u001a\u0017\u0012\u0005\u0012\u00030®\u0001\u0012\u0004\u0012\u00020T\u0012\u0005\u0012\u00030\u0084\u00010\u00ad\u0001H\u0016J\u001b\u0010¯\u0001\u001a\t\u0012\u0004\u0012\u00020e0\u008c\u00012\b\u0010\u009c\u0001\u001a\u00030°\u0001H\u0096\u0001J3\u0010±\u0001\u001a\n\u0012\u0005\u0012\u00030²\u00010\u008c\u00012\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\t\u0010³\u0001\u001a\u0004\u0018\u00010\u00122\n\u0010´\u0001\u001a\u0005\u0018\u00010µ\u0001H\u0096\u0001JG\u0010±\u0001\u001a\n\u0012\u0005\u0012\u00030²\u00010\u008c\u00012\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\t\u0010³\u0001\u001a\u0004\u0018\u00010\u00122\n\u0010´\u0001\u001a\u0005\u0018\u00010µ\u00012\u0007\u0010¶\u0001\u001a\u00020T2\t\u0010·\u0001\u001a\u0004\u0018\u00010\u0012H\u0096\u0001J\u0015\u0010¸\u0001\u001a\u00030\u0098\u00012\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0096\u0001J\u001f\u0010¹\u0001\u001a\u00030\u0084\u00012\t\u0010º\u0001\u001a\u0004\u0018\u00010\u00122\u0007\u0010»\u0001\u001a\u00020nH\u0096\u0001J\u0016\u0010¼\u0001\u001a\u00030\u0084\u00012\t\u0010½\u0001\u001a\u0004\u0018\u00010eH\u0096\u0001J\u000b\u0010¾\u0001\u001a\u00030\u0084\u0001H\u0096\u0001J\u0015\u0010¿\u0001\u001a\u00020T2\t\u0010À\u0001\u001a\u0004\u0018\u00010\u0012H\u0096\u0001J\u0015\u0010Á\u0001\u001a\u00020T2\t\u0010Â\u0001\u001a\u0004\u0018\u00010\u0012H\u0096\u0001J\u0015\u0010Ã\u0001\u001a\u00020T2\t\u0010½\u0001\u001a\u0004\u0018\u00010eH\u0096\u0001J\u001c\u0010Ä\u0001\u001a\n\u0012\u0005\u0012\u00030Å\u00010\u008c\u00012\b\u0010\u009c\u0001\u001a\u00030Æ\u0001H\u0096\u0001J0\u0010Ç\u0001\u001a\u00030\u0084\u00012\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u001c\u0010¬\u0001\u001a\u0017\u0012\u0005\u0012\u00030®\u0001\u0012\u0004\u0012\u00020T\u0012\u0005\u0012\u00030\u0084\u00010\u00ad\u0001J#\u0010È\u0001\u001a\u0005\u0018\u00010É\u00012\t\u0010Ê\u0001\u001a\u0004\u0018\u00010\u00122\t\u0010Ë\u0001\u001a\u0004\u0018\u00010\u0012H\u0096\u0001J\u0018\u0010Ì\u0001\u001a\u0005\u0018\u00010Í\u00012\t\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0012H\u0096\u0001JL\u0010Î\u0001\u001a\u00020T2\t\u0010Ï\u0001\u001a\u0004\u0018\u00010T2\b\u0010Ð\u0001\u001a\u00030Ñ\u00012\b\u0010Ò\u0001\u001a\u00030Æ\u00012\u001c\u0010¬\u0001\u001a\u0017\u0012\u0005\u0012\u00030®\u0001\u0012\u0004\u0012\u00020T\u0012\u0005\u0012\u00030\u0084\u00010\u00ad\u0001H\u0002¢\u0006\u0003\u0010Ó\u0001J>\u0010Ô\u0001\u001a\t\u0012\u0004\u0012\u0002030\u008c\u00012\b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\b\u0010Õ\u0001\u001a\u00030Ö\u00012\u0018\u0010×\u0001\u001a\u0013\u0012\u0005\u0012\u00030Ø\u0001\u0012\u0005\u0012\u00030\u0084\u0001\u0018\u00010©\u0001H\u0016J>\u0010Ù\u0001\u001a\t\u0012\u0004\u0012\u00020\u001d0\u008c\u00012\b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\b\u0010Õ\u0001\u001a\u00030Ö\u00012\u0018\u0010×\u0001\u001a\u0013\u0012\u0005\u0012\u00030Ø\u0001\u0012\u0005\u0012\u00030\u0084\u0001\u0018\u00010©\u0001H\u0002J>\u0010Ú\u0001\u001a\t\u0012\u0004\u0012\u00020A0\u008c\u00012\b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\b\u0010Õ\u0001\u001a\u00030Ö\u00012\u0018\u0010×\u0001\u001a\u0013\u0012\u0005\u0012\u00030Ø\u0001\u0012\u0005\u0012\u00030\u0084\u0001\u0018\u00010©\u0001H\u0002J>\u0010Û\u0001\u001a\t\u0012\u0004\u0012\u00020|0\u008c\u00012\b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\b\u0010Õ\u0001\u001a\u00030Ö\u00012\u0018\u0010Ü\u0001\u001a\u0013\u0012\u0005\u0012\u00030Ø\u0001\u0012\u0005\u0012\u00030\u0084\u0001\u0018\u00010©\u0001H\u0002J&\u0010Ý\u0001\u001a\n\u0012\u0005\u0012\u00030\u008d\u00010\u008c\u00012\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\b\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0096\u0001J$\u0010Þ\u0001\u001a\t\u0012\u0004\u0012\u00020A0\u008c\u00012\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\b\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0016J\u0014\u0010ß\u0001\u001a\u00020T2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0001J\u001b\u0010à\u0001\u001a\t\u0012\u0004\u0012\u00020\u001d0\u008c\u00012\b\u0010\u009c\u0001\u001a\u00030á\u0001H\u0096\u0001J\u001b\u0010â\u0001\u001a\t\u0012\u0004\u0012\u00020A0\u008c\u00012\b\u0010\u009c\u0001\u001a\u00030á\u0001H\u0096\u0001J\u001b\u0010ã\u0001\u001a\t\u0012\u0004\u0012\u00020|0\u008c\u00012\b\u0010\u009c\u0001\u001a\u00030á\u0001H\u0096\u0001JB\u0010ä\u0001\u001a\n\u0012\u0005\u0012\u00030\u009f\u00010\u008c\u00012\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\t\u0010å\u0001\u001a\u0004\u0018\u00010T2\t\u0010æ\u0001\u001a\u0004\u0018\u00010T2\t\u0010ç\u0001\u001a\u0004\u0018\u00010TH\u0002¢\u0006\u0003\u0010è\u0001J \u0010é\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00120ê\u0001j\t\u0012\u0004\u0012\u00020\u0012`ë\u0001*\u00030ì\u0001H\u0002R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0096\u000f¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u0004\u0018\u00010\u0012X\u0096\u000f¢\u0006\f\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R\u001a\u0010%\u001a\u0004\u0018\u00010&X\u0096\u000f¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0012\u0010+\u001a\u00020,X\u0096\u0005¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\u0004\u0018\u00010\u0012X\u0096\u000f¢\u0006\f\u001a\u0004\b0\u0010\u0014\"\u0004\b1\u0010\u0016R\u001a\u00102\u001a\u0004\u0018\u000103X\u0096\u000f¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u0004\u0018\u000109X\u0096\u000f¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u0004\u0018\u00010\u0012X\u0096\u0005¢\u0006\u0006\u001a\u0004\b?\u0010\u0014R\u001a\u0010@\u001a\u0004\u0018\u00010AX\u0096\u000f¢\u0006\f\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u0004\u0018\u00010\u0012X\u0096\u000f¢\u0006\f\u001a\u0004\bG\u0010\u0014\"\u0004\bH\u0010\u0016R\u0014\u0010I\u001a\u0004\u0018\u00010\u0012X\u0096\u0005¢\u0006\u0006\u001a\u0004\bJ\u0010\u0014R\u001a\u0010K\u001a\u0004\u0018\u00010&X\u0096\u000f¢\u0006\f\u001a\u0004\bL\u0010(\"\u0004\bM\u0010*R\u0012\u0010N\u001a\u00020,X\u0096\u0005¢\u0006\u0006\u001a\u0004\bO\u0010.R\u001a\u0010P\u001a\u0004\u0018\u00010\u0012X\u0096\u000f¢\u0006\f\u001a\u0004\bQ\u0010\u0014\"\u0004\bR\u0010\u0016R\u0012\u0010S\u001a\u00020TX\u0096\u0005¢\u0006\u0006\u001a\u0004\bU\u0010VR\u0012\u0010W\u001a\u00020TX\u0096\u0005¢\u0006\u0006\u001a\u0004\bW\u0010VR\u0012\u0010X\u001a\u00020TX\u0096\u0005¢\u0006\u0006\u001a\u0004\bX\u0010VR\u0012\u0010Y\u001a\u00020TX\u0096\u0005¢\u0006\u0006\u001a\u0004\bY\u0010VR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010Z\u001a\u00020[X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\\\u0010]R\u001a\u0010^\u001a\u0004\u0018\u00010_X\u0096\u000f¢\u0006\f\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001a\u0010d\u001a\u0004\u0018\u00010eX\u0096\u000f¢\u0006\f\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u000e\u0010\u0004\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010j\u001a\u0004\u0018\u00010_X\u0096\u000f¢\u0006\f\u001a\u0004\bk\u0010a\"\u0004\bl\u0010cR\u0018\u0010m\u001a\u00020nX\u0096\u000f¢\u0006\f\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u0012\u0010s\u001a\u00020TX\u0096\u0005¢\u0006\u0006\u001a\u0004\bt\u0010VR\u0012\u0010u\u001a\u00020vX\u0096\u0005¢\u0006\u0006\u001a\u0004\bw\u0010xR\u0012\u0010y\u001a\u000203X\u0096\u0005¢\u0006\u0006\u001a\u0004\bz\u00105R\u001b\u0010{\u001a\u0004\u0018\u00010|X\u0096\u000f¢\u0006\r\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R\u0016\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0012X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010\u0014¨\u0006í\u0001"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/ServiceImpl;", "Lcom/sourcepoint/cmplibrary/data/Service;", "Lcom/sourcepoint/cmplibrary/data/network/NetworkClient;", "Lcom/sourcepoint/cmplibrary/campaign/CampaignManager;", "networkClient", "campaignManager", "consentManagerUtils", "Lcom/sourcepoint/cmplibrary/consent/ConsentManagerUtils;", "dataStorage", "Lcom/sourcepoint/cmplibrary/data/local/DataStorage;", "logger", "Lcom/sourcepoint/cmplibrary/exception/Logger;", "execManager", "Lcom/sourcepoint/cmplibrary/core/ExecutorManager;", "connectionManager", "Lcom/sourcepoint/cmplibrary/data/network/connection/ConnectionManager;", "(Lcom/sourcepoint/cmplibrary/data/network/NetworkClient;Lcom/sourcepoint/cmplibrary/campaign/CampaignManager;Lcom/sourcepoint/cmplibrary/consent/ConsentManagerUtils;Lcom/sourcepoint/cmplibrary/data/local/DataStorage;Lcom/sourcepoint/cmplibrary/exception/Logger;Lcom/sourcepoint/cmplibrary/core/ExecutorManager;Lcom/sourcepoint/cmplibrary/data/network/connection/ConnectionManager;)V", "authId", "", "getAuthId", "()Ljava/lang/String;", "setAuthId", "(Ljava/lang/String;)V", "campaigns4Config", "", "Lcom/sourcepoint/cmplibrary/model/CampaignReq;", "getCampaigns4Config", "()Ljava/util/List;", "ccpaConsentStatus", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", "getCcpaConsentStatus", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", "setCcpaConsentStatus", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;)V", "ccpaDateCreated", "getCcpaDateCreated", "setCcpaDateCreated", "ccpaMessageMetaData", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;", "getCcpaMessageMetaData", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;", "setCcpaMessageMetaData", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;)V", "ccpaMessageSubCategory", "Lcom/sourcepoint/cmplibrary/model/exposed/MessageSubCategory;", "getCcpaMessageSubCategory", "()Lcom/sourcepoint/cmplibrary/model/exposed/MessageSubCategory;", "ccpaUuid", "getCcpaUuid", "setCcpaUuid", "choiceResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceResp;", "getChoiceResp", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceResp;", "setChoiceResp", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceResp;)V", "dataRecordedConsent", "Ljava/time/Instant;", "getDataRecordedConsent", "()Ljava/time/Instant;", "setDataRecordedConsent", "(Ljava/time/Instant;)V", "gdprAdditionsChangeDate", "getGdprAdditionsChangeDate", C3040d4.i.a0, "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", "getGdprConsentStatus", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", "setGdprConsentStatus", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;)V", "gdprDateCreated", "getGdprDateCreated", "setGdprDateCreated", "gdprLegalBasisChangeDate", "getGdprLegalBasisChangeDate", "gdprMessageMetaData", "getGdprMessageMetaData", "setGdprMessageMetaData", "gdprMessageSubCategory", "getGdprMessageSubCategory", "gdprUuid", "getGdprUuid", "setGdprUuid", "hasLocalData", "", "getHasLocalData", "()Z", "isCcpaExpired", "isGdprExpired", "isUsnatExpired", "messageLanguage", "Lcom/sourcepoint/cmplibrary/model/MessageLanguage;", "getMessageLanguage", "()Lcom/sourcepoint/cmplibrary/model/MessageLanguage;", "messagesOptimizedLocalState", "Lkotlinx/serialization/json/JsonElement;", "getMessagesOptimizedLocalState", "()Lkotlinx/serialization/json/JsonElement;", "setMessagesOptimizedLocalState", "(Lkotlinx/serialization/json/JsonElement;)V", "metaDataResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp;", "getMetaDataResp", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp;", "setMetaDataResp", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp;)V", "nonKeyedLocalState", "getNonKeyedLocalState", "setNonKeyedLocalState", "propertyId", "", "getPropertyId", "()I", "setPropertyId", "(I)V", "shouldCallMessages", "getShouldCallMessages", "spConfig", "Lcom/sourcepoint/cmplibrary/model/exposed/SpConfig;", "getSpConfig", "()Lcom/sourcepoint/cmplibrary/model/exposed/SpConfig;", "storeChoiceResp", "getStoreChoiceResp", "usNatConsentData", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "getUsNatConsentData", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "setUsNatConsentData", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;)V", "usnatAdditionsChangeDate", "getUsnatAdditionsChangeDate", "addCampaign", "", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "campaign", "Lcom/sourcepoint/cmplibrary/model/CampaignTemplate;", "clearConsents", "consentStatusLog", "deleteCustomConsentTo", "Lcom/sourcepoint/cmplibrary/core/Either;", "Lcom/sourcepoint/cmplibrary/model/CustomConsentResp;", "customConsentReq", "Lcom/sourcepoint/cmplibrary/model/CustomConsentReq;", D5.o, "Lcom/sourcepoint/cmplibrary/data/network/util/Env;", "deleteCustomConsentToServ", "deleteExpiredConsents", "getAppliedCampaign", "Lkotlin/Pair;", "getCampaignTemplate", "getCcpaPvDataBody", "Lkotlinx/serialization/json/JsonObject;", "messageReq", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesParamReq;", "getChoice", "param", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/GetChoiceParamReq;", "getConsentStatus", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusResp;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusParamReq;", "getGdprPvDataBody", "getGroupId", "getMessageOptimizedReq", "pubData", "Lorg/json/JSONObject;", "getMessages", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesResp;", "onSuccess", "Lkotlin/Function1;", "showConsent", "Lkotlin/Function0;", "onFailure", "Lkotlin/Function2;", "", "getMetaData", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataParamReq;", "getPmConfig", "Lcom/sourcepoint/cmplibrary/model/PmUrlConfig;", "pmId", "pmTab", "Lcom/sourcepoint/cmplibrary/model/PMTab;", "useGroupPmIfAvailable", "groupPmId", "getUsNatPvDataBody", "handleAuthIdOrPropertyIdChange", "newAuthId", "newPropertyId", "handleMetaDataResponse", C3337ue.n, "handleOldLocalData", "hasGdprVendorListIdChanged", "gdprVendorListId", "hasUsNatVendorListIdChanged", "usNatVendorListId", "hasUsnatApplicableSectionsChanged", "postPvData", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataResp;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataParamReq;", "pvData", "reConsentGdpr", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus;", "additionsChangeDate", "legalBasisChangeDate", "reConsentUsnat", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus;", "sampleAndPvData", "wasSampled", "rate", "", "pvDataParams", "(Ljava/lang/Boolean;DLcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataParamReq;Lkotlin/jvm/functions/Function2;)Z", "sendConsent", MRAIDPresenter.CONSENT_ACTION, "Lcom/sourcepoint/cmplibrary/model/ConsentActionImpl;", "onSpConsentsSuccess", "Lcom/sourcepoint/cmplibrary/model/exposed/SPConsents;", "sendConsentCcpa", "sendConsentGdpr", "sendConsentUsNat", "onSpConsentSuccess", "sendCustomConsent", "sendCustomConsentServ", "shouldCallConsentStatus", "storeCcpaChoice", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PostChoiceParamReq;", "storeGdprChoice", "storeUsNatChoice", "triggerConsentStatus", "gdprApplies", "ccpaApplies", "usNatApplies", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesParamReq;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/sourcepoint/cmplibrary/core/Either;", "toArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lorg/json/JSONArray;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServiceImpl implements Service, NetworkClient, CampaignManager {
    private final CampaignManager campaignManager;
    private final ConnectionManager connectionManager;
    private final ConsentManagerUtils consentManagerUtils;
    private final DataStorage dataStorage;
    private final ExecutorManager execManager;
    private final Logger logger;
    private final NetworkClient networkClient;

    /* compiled from: ServiceImpl.kt */
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
                iArr[CampaignType.CCPA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CampaignType.USNAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void addCampaign(CampaignType campaignType, CampaignTemplate campaign) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Intrinsics.checkNotNullParameter(campaign, "campaign");
        this.campaignManager.addCampaign(campaignType, campaign);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void clearConsents() {
        this.campaignManager.clearConsents();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void consentStatusLog(String authId) {
        this.campaignManager.consentStatusLog(authId);
    }

    @Override // com.sourcepoint.cmplibrary.data.network.NetworkClient
    public Either<CustomConsentResp> deleteCustomConsentTo(CustomConsentReq customConsentReq, Env env) {
        Intrinsics.checkNotNullParameter(customConsentReq, "customConsentReq");
        Intrinsics.checkNotNullParameter(env, "env");
        return this.networkClient.deleteCustomConsentTo(customConsentReq, env);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void deleteExpiredConsents() {
        this.campaignManager.deleteExpiredConsents();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public Either<Pair<CampaignType, CampaignTemplate>> getAppliedCampaign() {
        return this.campaignManager.getAppliedCampaign();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public String getAuthId() {
        return this.campaignManager.getAuthId();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public Either<CampaignTemplate> getCampaignTemplate(CampaignType campaignType) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        return this.campaignManager.getCampaignTemplate(campaignType);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public List<CampaignReq> getCampaigns4Config() {
        return this.campaignManager.getCampaigns4Config();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public CcpaCS getCcpaConsentStatus() {
        return this.campaignManager.getCcpaConsentStatus();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public String getCcpaDateCreated() {
        return this.campaignManager.getCcpaDateCreated();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public MessageMetaData getCcpaMessageMetaData() {
        return this.campaignManager.getCcpaMessageMetaData();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public MessageSubCategory getCcpaMessageSubCategory() {
        return this.campaignManager.getCcpaMessageSubCategory();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public JsonObject getCcpaPvDataBody(MessagesParamReq messageReq) {
        Intrinsics.checkNotNullParameter(messageReq, "messageReq");
        return this.campaignManager.getCcpaPvDataBody(messageReq);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public String getCcpaUuid() {
        return this.campaignManager.getCcpaUuid();
    }

    @Override // com.sourcepoint.cmplibrary.data.network.NetworkClient
    public Either<ChoiceResp> getChoice(GetChoiceParamReq param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return this.networkClient.getChoice(param);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public ChoiceResp getChoiceResp() {
        return this.campaignManager.getChoiceResp();
    }

    @Override // com.sourcepoint.cmplibrary.data.network.NetworkClient
    public Either<ConsentStatusResp> getConsentStatus(ConsentStatusParamReq param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return this.networkClient.getConsentStatus(param);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public Instant getDataRecordedConsent() {
        return this.campaignManager.getDataRecordedConsent();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public String getGdprAdditionsChangeDate() {
        return this.campaignManager.getGdprAdditionsChangeDate();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public GdprCS getGdprConsentStatus() {
        return this.campaignManager.getGdprConsentStatus();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public String getGdprDateCreated() {
        return this.campaignManager.getGdprDateCreated();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public String getGdprLegalBasisChangeDate() {
        return this.campaignManager.getGdprLegalBasisChangeDate();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public MessageMetaData getGdprMessageMetaData() {
        return this.campaignManager.getGdprMessageMetaData();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public MessageSubCategory getGdprMessageSubCategory() {
        return this.campaignManager.getGdprMessageSubCategory();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public JsonObject getGdprPvDataBody(MessagesParamReq messageReq) {
        Intrinsics.checkNotNullParameter(messageReq, "messageReq");
        return this.campaignManager.getGdprPvDataBody(messageReq);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public String getGdprUuid() {
        return this.campaignManager.getGdprUuid();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public String getGroupId(CampaignType campaignType) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        return this.campaignManager.getGroupId(campaignType);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public boolean getHasLocalData() {
        return this.campaignManager.getHasLocalData();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public MessageLanguage getMessageLanguage() {
        return this.campaignManager.getMessageLanguage();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public MessagesParamReq getMessageOptimizedReq(String authId, JSONObject pubData) {
        return this.campaignManager.getMessageOptimizedReq(authId, pubData);
    }

    @Override // com.sourcepoint.cmplibrary.data.network.NetworkClient
    public Either<MessagesResp> getMessages(MessagesParamReq param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return this.networkClient.getMessages(param);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public JsonElement getMessagesOptimizedLocalState() {
        return this.campaignManager.getMessagesOptimizedLocalState();
    }

    @Override // com.sourcepoint.cmplibrary.data.network.NetworkClient
    public Either<MetaDataResp> getMetaData(MetaDataParamReq param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return this.networkClient.getMetaData(param);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public MetaDataResp getMetaDataResp() {
        return this.campaignManager.getMetaDataResp();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public JsonElement getNonKeyedLocalState() {
        return this.campaignManager.getNonKeyedLocalState();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public Either<PmUrlConfig> getPmConfig(CampaignType campaignType, String pmId, PMTab pmTab) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        return this.campaignManager.getPmConfig(campaignType, pmId, pmTab);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public Either<PmUrlConfig> getPmConfig(CampaignType campaignType, String pmId, PMTab pmTab, boolean useGroupPmIfAvailable, String groupPmId) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        return this.campaignManager.getPmConfig(campaignType, pmId, pmTab, useGroupPmIfAvailable, groupPmId);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public int getPropertyId() {
        return this.campaignManager.getPropertyId();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public boolean getShouldCallMessages() {
        return this.campaignManager.getShouldCallMessages();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public SpConfig getSpConfig() {
        return this.campaignManager.getSpConfig();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public ChoiceResp getStoreChoiceResp() {
        return this.campaignManager.getStoreChoiceResp();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public USNatConsentData getUsNatConsentData() {
        return this.campaignManager.getUsNatConsentData();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public JsonObject getUsNatPvDataBody(MessagesParamReq messageReq) {
        Intrinsics.checkNotNullParameter(messageReq, "messageReq");
        return this.campaignManager.getUsNatPvDataBody(messageReq);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public String getUsnatAdditionsChangeDate() {
        return this.campaignManager.getUsnatAdditionsChangeDate();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void handleAuthIdOrPropertyIdChange(String newAuthId, int newPropertyId) {
        this.campaignManager.handleAuthIdOrPropertyIdChange(newAuthId, newPropertyId);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void handleMetaDataResponse(MetaDataResp response) {
        this.campaignManager.handleMetaDataResponse(response);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void handleOldLocalData() {
        this.campaignManager.handleOldLocalData();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public boolean hasGdprVendorListIdChanged(String gdprVendorListId) {
        return this.campaignManager.hasGdprVendorListIdChanged(gdprVendorListId);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public boolean hasUsNatVendorListIdChanged(String usNatVendorListId) {
        return this.campaignManager.hasUsNatVendorListIdChanged(usNatVendorListId);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public boolean hasUsnatApplicableSectionsChanged(MetaDataResp response) {
        return this.campaignManager.hasUsnatApplicableSectionsChanged(response);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public boolean isCcpaExpired() {
        return this.campaignManager.isCcpaExpired();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public boolean isGdprExpired() {
        return this.campaignManager.isGdprExpired();
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public boolean isUsnatExpired() {
        return this.campaignManager.isUsnatExpired();
    }

    @Override // com.sourcepoint.cmplibrary.data.network.NetworkClient
    public Either<PvDataResp> postPvData(PvDataParamReq param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return this.networkClient.postPvData(param);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public ConsentStatus reConsentGdpr(String additionsChangeDate, String legalBasisChangeDate) {
        return this.campaignManager.reConsentGdpr(additionsChangeDate, legalBasisChangeDate);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public USNatConsentStatus reConsentUsnat(String additionsChangeDate) {
        return this.campaignManager.reConsentUsnat(additionsChangeDate);
    }

    @Override // com.sourcepoint.cmplibrary.data.network.NetworkClient
    public Either<CustomConsentResp> sendCustomConsent(CustomConsentReq customConsentReq, Env env) {
        Intrinsics.checkNotNullParameter(customConsentReq, "customConsentReq");
        Intrinsics.checkNotNullParameter(env, "env");
        return this.networkClient.sendCustomConsent(customConsentReq, env);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setAuthId(String str) {
        this.campaignManager.setAuthId(str);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setCcpaConsentStatus(CcpaCS ccpaCS) {
        this.campaignManager.setCcpaConsentStatus(ccpaCS);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setCcpaDateCreated(String str) {
        this.campaignManager.setCcpaDateCreated(str);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setCcpaMessageMetaData(MessageMetaData messageMetaData) {
        this.campaignManager.setCcpaMessageMetaData(messageMetaData);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setCcpaUuid(String str) {
        this.campaignManager.setCcpaUuid(str);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setChoiceResp(ChoiceResp choiceResp) {
        this.campaignManager.setChoiceResp(choiceResp);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setDataRecordedConsent(Instant instant) {
        this.campaignManager.setDataRecordedConsent(instant);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setGdprConsentStatus(GdprCS gdprCS) {
        this.campaignManager.setGdprConsentStatus(gdprCS);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setGdprDateCreated(String str) {
        this.campaignManager.setGdprDateCreated(str);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setGdprMessageMetaData(MessageMetaData messageMetaData) {
        this.campaignManager.setGdprMessageMetaData(messageMetaData);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setGdprUuid(String str) {
        this.campaignManager.setGdprUuid(str);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setMessagesOptimizedLocalState(JsonElement jsonElement) {
        this.campaignManager.setMessagesOptimizedLocalState(jsonElement);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setMetaDataResp(MetaDataResp metaDataResp) {
        this.campaignManager.setMetaDataResp(metaDataResp);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setNonKeyedLocalState(JsonElement jsonElement) {
        this.campaignManager.setNonKeyedLocalState(jsonElement);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setPropertyId(int i) {
        this.campaignManager.setPropertyId(i);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public void setUsNatConsentData(USNatConsentData uSNatConsentData) {
        this.campaignManager.setUsNatConsentData(uSNatConsentData);
    }

    @Override // com.sourcepoint.cmplibrary.campaign.CampaignManager
    public boolean shouldCallConsentStatus(String authId) {
        return this.campaignManager.shouldCallConsentStatus(authId);
    }

    @Override // com.sourcepoint.cmplibrary.data.network.NetworkClient
    public Either<CcpaCS> storeCcpaChoice(PostChoiceParamReq param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return this.networkClient.storeCcpaChoice(param);
    }

    @Override // com.sourcepoint.cmplibrary.data.network.NetworkClient
    public Either<GdprCS> storeGdprChoice(PostChoiceParamReq param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return this.networkClient.storeGdprChoice(param);
    }

    @Override // com.sourcepoint.cmplibrary.data.network.NetworkClient
    public Either<USNatConsentData> storeUsNatChoice(PostChoiceParamReq param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return this.networkClient.storeUsNatChoice(param);
    }

    public ServiceImpl(NetworkClient networkClient, CampaignManager campaignManager, ConsentManagerUtils consentManagerUtils, DataStorage dataStorage, Logger logger, ExecutorManager execManager, ConnectionManager connectionManager) {
        Intrinsics.checkNotNullParameter(networkClient, "networkClient");
        Intrinsics.checkNotNullParameter(campaignManager, "campaignManager");
        Intrinsics.checkNotNullParameter(consentManagerUtils, "consentManagerUtils");
        Intrinsics.checkNotNullParameter(dataStorage, "dataStorage");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(execManager, "execManager");
        Intrinsics.checkNotNullParameter(connectionManager, "connectionManager");
        this.networkClient = networkClient;
        this.campaignManager = campaignManager;
        this.consentManagerUtils = consentManagerUtils;
        this.dataStorage = dataStorage;
        this.logger = logger;
        this.execManager = execManager;
        this.connectionManager = connectionManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<String> toArrayList(JSONArray jSONArray) {
        ArrayList<String> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    @Override // com.sourcepoint.cmplibrary.data.Service
    public Either<GdprCS> sendCustomConsentServ(final CustomConsentReq customConsentReq, final Env env) {
        Intrinsics.checkNotNullParameter(customConsentReq, "customConsentReq");
        Intrinsics.checkNotNullParameter(env, "env");
        return FunctionalUtilsKt.check(new Function0<GdprCS>() { // from class: com.sourcepoint.cmplibrary.data.ServiceImpl$sendCustomConsentServ$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GdprCS invoke() {
                ConnectionManager connectionManager;
                NetworkClient networkClient;
                CampaignManager campaignManager;
                CampaignManager campaignManager2;
                ArrayList arrayList;
                ArrayList arrayList2;
                ArrayList arrayList3;
                ArrayList arrayList4;
                CampaignManager campaignManager3;
                CampaignManager campaignManager4;
                connectionManager = ServiceImpl.this.connectionManager;
                if (connectionManager.isConnected()) {
                    networkClient = ServiceImpl.this.networkClient;
                    Either<CustomConsentResp> sendCustomConsent = networkClient.sendCustomConsent(customConsentReq, env);
                    ServiceImpl serviceImpl = ServiceImpl.this;
                    if (sendCustomConsent instanceof Either.Right) {
                        CustomConsentResp customConsentResp = (CustomConsentResp) ((Either.Right) sendCustomConsent).getR();
                        campaignManager2 = serviceImpl.campaignManager;
                        if (campaignManager2.getGdprConsentStatus() == null) {
                            ExceptionUtilsKt.genericFail("CustomConsent cannot be executed. Consent is missing!!!");
                            throw new KotlinNothingValueException();
                        }
                        Object obj = customConsentResp.getContent().get("categories");
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONArray");
                        arrayList = serviceImpl.toArrayList((JSONArray) obj);
                        ArrayList arrayList5 = arrayList;
                        Object obj2 = customConsentResp.getContent().get("vendors");
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type org.json.JSONArray");
                        arrayList2 = serviceImpl.toArrayList((JSONArray) obj2);
                        ArrayList arrayList6 = arrayList2;
                        Object obj3 = customConsentResp.getContent().get("legIntCategories");
                        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type org.json.JSONArray");
                        arrayList3 = serviceImpl.toArrayList((JSONArray) obj3);
                        ArrayList arrayList7 = arrayList3;
                        Object obj4 = customConsentResp.getContent().get("specialFeatures");
                        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type org.json.JSONArray");
                        arrayList4 = serviceImpl.toArrayList((JSONArray) obj4);
                        ArrayList arrayList8 = arrayList4;
                        Object obj5 = customConsentResp.getContent().get("grants");
                        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type org.json.JSONObject");
                        String jSONObject = ((JSONObject) obj5).toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
                        Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                        converter.getSerializersModule();
                        Map map = (Map) converter.decodeFromString(new LinkedHashMapSerializer(StringSerializer.INSTANCE, GDPRPurposeGrants.INSTANCE.serializer()), jSONObject);
                        campaignManager3 = serviceImpl.campaignManager;
                        GdprCS gdprConsentStatus = campaignManager3.getGdprConsentStatus();
                        GdprCS copy$default = gdprConsentStatus != null ? GdprCS.copy$default(gdprConsentStatus, null, arrayList5, null, null, arrayList7, null, null, null, arrayList8, arrayList6, null, null, null, null, null, null, map, null, null, null, null, null, null, null, 16710893, null) : null;
                        campaignManager4 = serviceImpl.campaignManager;
                        campaignManager4.setGdprConsentStatus(copy$default);
                        new Either.Right(Unit.INSTANCE);
                    } else if (!(sendCustomConsent instanceof Either.Left)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    campaignManager = ServiceImpl.this.campaignManager;
                    GdprCS gdprConsentStatus2 = campaignManager.getGdprConsentStatus();
                    Intrinsics.checkNotNull(gdprConsentStatus2);
                    return gdprConsentStatus2;
                }
                throw new NoInternetConnectionException(null, null, false, 7, null);
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.data.Service
    public Either<GdprCS> deleteCustomConsentToServ(final CustomConsentReq customConsentReq, final Env env) {
        Intrinsics.checkNotNullParameter(customConsentReq, "customConsentReq");
        Intrinsics.checkNotNullParameter(env, "env");
        return FunctionalUtilsKt.check(new Function0<GdprCS>() { // from class: com.sourcepoint.cmplibrary.data.ServiceImpl$deleteCustomConsentToServ$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GdprCS invoke() {
                ConnectionManager connectionManager;
                NetworkClient networkClient;
                CampaignManager campaignManager;
                CampaignManager campaignManager2;
                ArrayList arrayList;
                ArrayList arrayList2;
                ArrayList arrayList3;
                ArrayList arrayList4;
                CampaignManager campaignManager3;
                CampaignManager campaignManager4;
                connectionManager = ServiceImpl.this.connectionManager;
                if (connectionManager.isConnected()) {
                    networkClient = ServiceImpl.this.networkClient;
                    Either<CustomConsentResp> deleteCustomConsentTo = networkClient.deleteCustomConsentTo(customConsentReq, env);
                    ServiceImpl serviceImpl = ServiceImpl.this;
                    if (deleteCustomConsentTo instanceof Either.Right) {
                        CustomConsentResp customConsentResp = (CustomConsentResp) ((Either.Right) deleteCustomConsentTo).getR();
                        campaignManager2 = serviceImpl.campaignManager;
                        if (campaignManager2.getGdprConsentStatus() == null) {
                            ExceptionUtilsKt.genericFail("CustomConsent cannot be executed. Consent is missing!!!");
                            throw new KotlinNothingValueException();
                        }
                        Object obj = customConsentResp.getContent().get("categories");
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONArray");
                        arrayList = serviceImpl.toArrayList((JSONArray) obj);
                        ArrayList arrayList5 = arrayList;
                        Object obj2 = customConsentResp.getContent().get("vendors");
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type org.json.JSONArray");
                        arrayList2 = serviceImpl.toArrayList((JSONArray) obj2);
                        ArrayList arrayList6 = arrayList2;
                        Object obj3 = customConsentResp.getContent().get("legIntCategories");
                        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type org.json.JSONArray");
                        arrayList3 = serviceImpl.toArrayList((JSONArray) obj3);
                        ArrayList arrayList7 = arrayList3;
                        Object obj4 = customConsentResp.getContent().get("specialFeatures");
                        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type org.json.JSONArray");
                        arrayList4 = serviceImpl.toArrayList((JSONArray) obj4);
                        ArrayList arrayList8 = arrayList4;
                        Object obj5 = customConsentResp.getContent().get("grants");
                        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type org.json.JSONObject");
                        String jSONObject = ((JSONObject) obj5).toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
                        Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                        converter.getSerializersModule();
                        Map map = (Map) converter.decodeFromString(new LinkedHashMapSerializer(StringSerializer.INSTANCE, GDPRPurposeGrants.INSTANCE.serializer()), jSONObject);
                        campaignManager3 = serviceImpl.campaignManager;
                        campaignManager4 = serviceImpl.campaignManager;
                        GdprCS gdprConsentStatus = campaignManager4.getGdprConsentStatus();
                        campaignManager3.setGdprConsentStatus(gdprConsentStatus != null ? GdprCS.copy$default(gdprConsentStatus, null, arrayList5, null, null, arrayList7, null, null, null, arrayList8, arrayList6, null, null, null, null, null, null, map, null, null, null, null, null, null, null, 16710893, null) : null);
                        new Either.Right(Unit.INSTANCE);
                    } else if (!(deleteCustomConsentTo instanceof Either.Left)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    campaignManager = ServiceImpl.this.campaignManager;
                    GdprCS gdprConsentStatus2 = campaignManager.getGdprConsentStatus();
                    Intrinsics.checkNotNull(gdprConsentStatus2);
                    return gdprConsentStatus2;
                }
                throw new NoInternetConnectionException(null, null, false, 7, null);
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.data.Service
    public void getMessages(final MessagesParamReq messageReq, final Function1<? super MessagesResp, Unit> onSuccess, final Function0<Unit> showConsent, final Function2<? super Throwable, ? super Boolean, Unit> onFailure) {
        Intrinsics.checkNotNullParameter(messageReq, "messageReq");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(showConsent, "showConsent");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        this.execManager.executeOnWorkerThread(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.data.ServiceImpl$getMessages$1
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
                ConnectionManager connectionManager;
                CampaignManager campaignManager;
                CampaignManager campaignManager2;
                CampaignManager campaignManager3;
                CampaignManager campaignManager4;
                CampaignManager campaignManager5;
                CampaignManager campaignManager6;
                CampaignManager campaignManager7;
                CampaignManager campaignManager8;
                CampaignManager campaignManager9;
                CampaignManager campaignManager10;
                ExecutorManager executorManager;
                CampaignManager campaignManager11;
                CampaignManager campaignManager12;
                CampaignManager campaignManager13;
                CampaignManager campaignManager14;
                CampaignManager campaignManager15;
                CampaignManager campaignManager16;
                CampaignManager campaignManager17;
                JsonObject messageBody;
                Object obj;
                CampaignManager campaignManager18;
                CampaignManager campaignManager19;
                CampaignManager campaignManager20;
                ExecutorManager executorManager2;
                CampaignManager campaignManager21;
                CampaignManager campaignManager22;
                Object obj2;
                MetaDataResp.USNat usNat;
                CcpaCS ccpaCS;
                CCPA ccpa;
                Object obj3;
                MetaDataResp.Ccpa ccpa2;
                GdprCS gdprCS;
                GDPR gdpr;
                Object obj4;
                MetaDataResp.Gdpr gdpr2;
                DataStorage dataStorage;
                USNatConsentData usNat2;
                Map<String, JsonElement> gppData;
                DataStorage dataStorage2;
                CCPA ccpa3;
                Map<String, JsonElement> gppData2;
                GDPR gdpr3;
                Map<String, JsonElement> tCData;
                DataStorage dataStorage3;
                CCPA ccpa4;
                GDPR gdpr4;
                USNatConsentData usNat3;
                CampaignManager campaignManager23;
                Unit unit;
                CampaignManager campaignManager24;
                CampaignManager campaignManager25;
                CampaignManager campaignManager26;
                CCPA ccpa5;
                String expirationDate;
                DataStorage dataStorage4;
                GDPR gdpr5;
                String expirationDate2;
                DataStorage dataStorage5;
                CcpaStatus status;
                CampaignManager campaignManager27;
                CampaignManager campaignManager28;
                CampaignManager campaignManager29;
                CampaignManager campaignManager30;
                Object obj5;
                Object obj6;
                Object obj7;
                Either triggerConsentStatus;
                MetaDataResp.USNat usNat4;
                MetaDataResp.Ccpa ccpa6;
                MetaDataResp.Gdpr gdpr6;
                CampaignManager unused;
                connectionManager = ServiceImpl.this.connectionManager;
                if (connectionManager.isConnected()) {
                    campaignManager = ServiceImpl.this.campaignManager;
                    campaignManager.handleAuthIdOrPropertyIdChange(messageReq.getAuthId(), ServiceImpl.this.getSpConfig().propertyId);
                    campaignManager2 = ServiceImpl.this.campaignManager;
                    campaignManager2.deleteExpiredConsents();
                    ServiceImpl serviceImpl = ServiceImpl.this;
                    Either<MetaDataResp> metaData = serviceImpl.getMetaData(MessagesApiModelExtKt.toMetaDataParamReq(messageReq, serviceImpl.getCampaigns4Config()));
                    ServiceImpl serviceImpl2 = ServiceImpl.this;
                    boolean z = metaData instanceof Either.Right;
                    if (z) {
                        serviceImpl2.handleMetaDataResponse((MetaDataResp) ((Either.Right) metaData).getR());
                    } else {
                        boolean z2 = metaData instanceof Either.Left;
                    }
                    Function2<Throwable, Boolean, Unit> function2 = onFailure;
                    if (z || !(metaData instanceof Either.Left)) {
                        campaignManager3 = ServiceImpl.this.campaignManager;
                        campaignManager3.consentStatusLog(messageReq.getAuthId());
                        campaignManager4 = ServiceImpl.this.campaignManager;
                        USNatConsentData uSNatConsentData = null;
                        r5 = null;
                        Boolean bool = null;
                        if (campaignManager4.shouldCallConsentStatus(messageReq.getAuthId())) {
                            ServiceImpl serviceImpl3 = ServiceImpl.this;
                            MessagesParamReq messagesParamReq = messageReq;
                            if (z) {
                                obj5 = ((Either.Right) metaData).getR();
                            } else {
                                if (!(metaData instanceof Either.Left)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                obj5 = null;
                            }
                            MetaDataResp metaDataResp = (MetaDataResp) obj5;
                            Boolean applies = (metaDataResp == null || (gdpr6 = metaDataResp.getGdpr()) == null) ? null : gdpr6.getApplies();
                            if (z) {
                                obj6 = ((Either.Right) metaData).getR();
                            } else {
                                if (!(metaData instanceof Either.Left)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                obj6 = null;
                            }
                            MetaDataResp metaDataResp2 = (MetaDataResp) obj6;
                            Boolean applies2 = (metaDataResp2 == null || (ccpa6 = metaDataResp2.getCcpa()) == null) ? null : ccpa6.getApplies();
                            if (z) {
                                obj7 = ((Either.Right) metaData).getR();
                            } else {
                                if (!(metaData instanceof Either.Left)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                obj7 = null;
                            }
                            MetaDataResp metaDataResp3 = (MetaDataResp) obj7;
                            triggerConsentStatus = serviceImpl3.triggerConsentStatus(messagesParamReq, applies, applies2, (metaDataResp3 == null || (usNat4 = metaDataResp3.getUsNat()) == null) ? null : usNat4.getApplies());
                            Function2<Throwable, Boolean, Unit> function22 = onFailure;
                            if (!(triggerConsentStatus instanceof Either.Right) && (triggerConsentStatus instanceof Either.Left)) {
                                function22.invoke(((Either.Left) triggerConsentStatus).getT(), true);
                                return;
                            }
                        }
                        campaignManager5 = ServiceImpl.this.campaignManager;
                        campaignManager6 = ServiceImpl.this.campaignManager;
                        String gdprAdditionsChangeDate = campaignManager6.getGdprAdditionsChangeDate();
                        campaignManager7 = ServiceImpl.this.campaignManager;
                        ConsentStatus reConsentGdpr = campaignManager5.reConsentGdpr(gdprAdditionsChangeDate, campaignManager7.getGdprLegalBasisChangeDate());
                        if (reConsentGdpr != null) {
                            ServiceImpl serviceImpl4 = ServiceImpl.this;
                            campaignManager29 = serviceImpl4.campaignManager;
                            campaignManager30 = serviceImpl4.campaignManager;
                            GdprCS gdprConsentStatus = campaignManager30.getGdprConsentStatus();
                            campaignManager29.setGdprConsentStatus(gdprConsentStatus != null ? GdprCS.copy$default(gdprConsentStatus, null, null, null, null, null, null, null, null, null, null, null, reConsentGdpr, null, null, null, null, null, null, null, null, null, null, null, null, 16775167, null) : null);
                            Unit unit2 = Unit.INSTANCE;
                            Unit unit3 = Unit.INSTANCE;
                        }
                        campaignManager8 = ServiceImpl.this.campaignManager;
                        campaignManager9 = ServiceImpl.this.campaignManager;
                        USNatConsentStatus reConsentUsnat = campaignManager8.reConsentUsnat(campaignManager9.getUsnatAdditionsChangeDate());
                        if (reConsentUsnat != null) {
                            ServiceImpl serviceImpl5 = ServiceImpl.this;
                            campaignManager27 = serviceImpl5.campaignManager;
                            campaignManager28 = serviceImpl5.campaignManager;
                            USNatConsentData usNatConsentData = campaignManager28.getUsNatConsentData();
                            campaignManager27.setUsNatConsentData(usNatConsentData != null ? USNatConsentData.copy$default(usNatConsentData, null, reConsentUsnat, null, null, null, null, null, null, null, null, null, null, null, 8189, null) : null);
                            Unit unit4 = Unit.INSTANCE;
                            Unit unit5 = Unit.INSTANCE;
                        }
                        campaignManager10 = ServiceImpl.this.campaignManager;
                        if (!campaignManager10.getShouldCallMessages()) {
                            executorManager = ServiceImpl.this.execManager;
                            final Function0<Unit> function0 = showConsent;
                            executorManager.executeOnMain(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.data.ServiceImpl$getMessages$1.6
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
                                    function0.invoke();
                                }
                            });
                        } else {
                            long accountId = messageReq.getAccountId();
                            long propertyId = messageReq.getPropertyId();
                            String authId = messageReq.getAuthId();
                            String propertyHref = messageReq.getPropertyHref();
                            Env env = messageReq.getEnv();
                            long accountId2 = messageReq.getAccountId();
                            String propertyHref2 = messageReq.getPropertyHref();
                            campaignManager11 = ServiceImpl.this.campaignManager;
                            GdprCS gdprConsentStatus2 = campaignManager11.getGdprConsentStatus();
                            ConsentStatus consentStatus = gdprConsentStatus2 != null ? gdprConsentStatus2.getConsentStatus() : null;
                            campaignManager12 = ServiceImpl.this.campaignManager;
                            CcpaCS ccpaConsentStatus = campaignManager12.getCcpaConsentStatus();
                            String name = (ccpaConsentStatus == null || (status = ccpaConsentStatus.getStatus()) == null) ? null : status.name();
                            campaignManager13 = ServiceImpl.this.campaignManager;
                            USNatConsentData usNatConsentData2 = campaignManager13.getUsNatConsentData();
                            USNatConsentStatus consentStatus2 = usNatConsentData2 != null ? usNatConsentData2.getConsentStatus() : null;
                            campaignManager14 = ServiceImpl.this.campaignManager;
                            List<CampaignReq> campaigns4Config = campaignManager14.getCampaigns4Config();
                            campaignManager15 = ServiceImpl.this.campaignManager;
                            String value = campaignManager15.getMessageLanguage().getValue();
                            campaignManager16 = ServiceImpl.this.campaignManager;
                            CampaignsEnv campaignsEnv = campaignManager16.getSpConfig().campaignsEnv;
                            campaignManager17 = ServiceImpl.this.campaignManager;
                            messageBody = MessagesApiModelExtKt.getMessageBody(propertyHref2, accountId2, campaigns4Config, consentStatus, name, consentStatus2, value, campaignsEnv, IncludeDataKt.buildIncludeData(SpConfigExtKt.getGppCustomOption(campaignManager17.getSpConfig())), (r25 & 512) != 0 ? new OperatingSystemInfoParam((String) null, (String) null, 3, (DefaultConstructorMarker) null) : null);
                            String jsonObject = messageBody.toString();
                            if (z) {
                                obj = ((Either.Right) metaData).getR();
                            } else {
                                if (!(metaData instanceof Either.Left)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                obj = null;
                            }
                            MetaDataResp metaDataResp4 = (MetaDataResp) obj;
                            MetaDataArg metaDataArg = metaDataResp4 != null ? MetaDataApiModelKt.toMetaDataArg(metaDataResp4) : null;
                            campaignManager18 = ServiceImpl.this.campaignManager;
                            JsonElement nonKeyedLocalState = campaignManager18.getNonKeyedLocalState();
                            JsonObject jsonObject2 = nonKeyedLocalState != null ? JsonElementKt.getJsonObject(nonKeyedLocalState) : null;
                            campaignManager19 = ServiceImpl.this.campaignManager;
                            JsonElement messagesOptimizedLocalState = campaignManager19.getMessagesOptimizedLocalState();
                            Either<MessagesResp> messages = ServiceImpl.this.getMessages(new MessagesParamReq(accountId, propertyId, authId, propertyHref, env, metaDataArg, jsonObject, jsonObject2, (JsonObject) null, messagesOptimizedLocalState != null ? JsonElementKt.getJsonObject(messagesOptimizedLocalState) : null, 256, (DefaultConstructorMarker) null));
                            Function2<Throwable, Boolean, Unit> function23 = onFailure;
                            boolean z3 = messages instanceof Either.Right;
                            if (!z3 && (messages instanceof Either.Left)) {
                                function23.invoke(((Either.Left) messages).getT(), true);
                                return;
                            }
                            ServiceImpl serviceImpl6 = ServiceImpl.this;
                            MessagesParamReq messagesParamReq2 = messageReq;
                            final Function1<MessagesResp, Unit> function1 = onSuccess;
                            if (z3) {
                                final MessagesResp messagesResp = (MessagesResp) ((Either.Right) messages).getR();
                                Campaigns campaigns = messagesResp.getCampaigns();
                                if (campaigns != null && (gdpr5 = campaigns.getGdpr()) != null && (expirationDate2 = gdpr5.getExpirationDate()) != null) {
                                    dataStorage5 = serviceImpl6.dataStorage;
                                    dataStorage5.setGdprExpirationDate(expirationDate2);
                                    Unit unit6 = Unit.INSTANCE;
                                    Unit unit7 = Unit.INSTANCE;
                                }
                                Campaigns campaigns2 = messagesResp.getCampaigns();
                                if (campaigns2 != null && (ccpa5 = campaigns2.getCcpa()) != null && (expirationDate = ccpa5.getExpirationDate()) != null) {
                                    dataStorage4 = serviceImpl6.dataStorage;
                                    dataStorage4.setCcpaExpirationDate(expirationDate);
                                    Unit unit8 = Unit.INSTANCE;
                                    Unit unit9 = Unit.INSTANCE;
                                }
                                Campaigns campaigns3 = messagesResp.getCampaigns();
                                if (campaigns3 != null && (usNat3 = campaigns3.getUsNat()) != null) {
                                    campaignManager23 = serviceImpl6.campaignManager;
                                    if (campaignManager23.getUsNatConsentData() != null) {
                                        campaignManager25 = serviceImpl6.campaignManager;
                                        campaignManager26 = serviceImpl6.campaignManager;
                                        USNatConsentData usNatConsentData3 = campaignManager26.getUsNatConsentData();
                                        campaignManager25.setUsNatConsentData(usNatConsentData3 != null ? USNatConsentData.copy$default(usNatConsentData3, null, null, null, null, null, null, usNat3.getMessage(), null, usNat3.getMessageMetaData(), usNat3.getType(), usNat3.getUrl(), null, null, 6335, null) : null);
                                        Unit unit10 = Unit.INSTANCE;
                                        unit = Unit.INSTANCE;
                                    } else {
                                        unit = null;
                                    }
                                    if (unit == null) {
                                        campaignManager24 = serviceImpl6.campaignManager;
                                        campaignManager24.setUsNatConsentData(usNat3);
                                        Unit unit11 = Unit.INSTANCE;
                                    }
                                    Unit unit12 = Unit.INSTANCE;
                                    Unit unit13 = Unit.INSTANCE;
                                }
                                unused = serviceImpl6.campaignManager;
                                serviceImpl6.setMessagesOptimizedLocalState(messagesResp.getLocalState());
                                serviceImpl6.setNonKeyedLocalState(messagesResp.getNonKeyedLocalState());
                                Campaigns campaigns4 = messagesResp.getCampaigns();
                                serviceImpl6.setGdprMessageMetaData((campaigns4 == null || (gdpr4 = campaigns4.getGdpr()) == null) ? null : gdpr4.getMessageMetaData());
                                Campaigns campaigns5 = messagesResp.getCampaigns();
                                serviceImpl6.setCcpaMessageMetaData((campaigns5 == null || (ccpa4 = campaigns5.getCcpa()) == null) ? null : ccpa4.getMessageMetaData());
                                campaignManager20 = serviceImpl6.campaignManager;
                                if (!campaignManager20.getHasLocalData()) {
                                    Campaigns campaigns6 = messagesResp.getCampaigns();
                                    if (campaigns6 != null && (gdpr3 = campaigns6.getGdpr()) != null && (tCData = gdpr3.getTCData()) != null) {
                                        dataStorage3 = serviceImpl6.dataStorage;
                                        dataStorage3.setTcData(MapExtKt.toMapOfAny(tCData));
                                        Unit unit14 = Unit.INSTANCE;
                                        Unit unit15 = Unit.INSTANCE;
                                    }
                                    if (SpConfigExtKt.isIncluded(serviceImpl6.getSpConfig(), CampaignType.CCPA)) {
                                        dataStorage2 = serviceImpl6.dataStorage;
                                        Campaigns campaigns7 = messagesResp.getCampaigns();
                                        dataStorage2.setGppData((campaigns7 == null || (ccpa3 = campaigns7.getCcpa()) == null || (gppData2 = ccpa3.getGppData()) == null) ? null : MapExtKt.toMapOfAny(gppData2));
                                    }
                                    if (SpConfigExtKt.isIncluded(serviceImpl6.getSpConfig(), CampaignType.USNAT)) {
                                        dataStorage = serviceImpl6.dataStorage;
                                        Campaigns campaigns8 = messagesResp.getCampaigns();
                                        dataStorage.setGppData((campaigns8 == null || (usNat2 = campaigns8.getUsNat()) == null || (gppData = usNat2.getGppData()) == null) ? null : MapExtKt.toMapOfAny(gppData));
                                    }
                                    campaignManager21 = serviceImpl6.campaignManager;
                                    if (messagesParamReq2.getAuthId() == null) {
                                        campaignManager22 = serviceImpl6.campaignManager;
                                        if (!campaignManager22.shouldCallConsentStatus(messagesParamReq2.getAuthId())) {
                                            if (SpConfigExtKt.isIncluded(campaignManager21.getSpConfig(), CampaignType.GDPR)) {
                                                Campaigns campaigns9 = messagesResp.getCampaigns();
                                                if (campaigns9 == null || (gdpr = campaigns9.getGdpr()) == null) {
                                                    gdprCS = null;
                                                } else {
                                                    if (z) {
                                                        obj4 = ((Either.Right) metaData).getR();
                                                    } else {
                                                        if (!(metaData instanceof Either.Left)) {
                                                            throw new NoWhenBranchMatchedException();
                                                        }
                                                        obj4 = null;
                                                    }
                                                    MetaDataResp metaDataResp5 = (MetaDataResp) obj4;
                                                    gdprCS = MessagesApiModelExtKt.toGdprCS(gdpr, (metaDataResp5 == null || (gdpr2 = metaDataResp5.getGdpr()) == null) ? null : gdpr2.getApplies());
                                                }
                                                campaignManager21.setGdprConsentStatus(gdprCS);
                                            }
                                            if (SpConfigExtKt.isIncluded(campaignManager21.getSpConfig(), CampaignType.CCPA)) {
                                                Campaigns campaigns10 = messagesResp.getCampaigns();
                                                if (campaigns10 == null || (ccpa = campaigns10.getCcpa()) == null) {
                                                    ccpaCS = null;
                                                } else {
                                                    if (z) {
                                                        obj3 = ((Either.Right) metaData).getR();
                                                    } else {
                                                        if (!(metaData instanceof Either.Left)) {
                                                            throw new NoWhenBranchMatchedException();
                                                        }
                                                        obj3 = null;
                                                    }
                                                    MetaDataResp metaDataResp6 = (MetaDataResp) obj3;
                                                    ccpaCS = MessagesApiModelExtKt.toCcpaCS(ccpa, (metaDataResp6 == null || (ccpa2 = metaDataResp6.getCcpa()) == null) ? null : ccpa2.getApplies());
                                                }
                                                campaignManager21.setCcpaConsentStatus(ccpaCS);
                                            }
                                            if (SpConfigExtKt.isIncluded(campaignManager21.getSpConfig(), CampaignType.USNAT)) {
                                                USNatConsentData usNatConsentData4 = campaignManager21.getUsNatConsentData();
                                                if (usNatConsentData4 != null) {
                                                    if (z) {
                                                        obj2 = ((Either.Right) metaData).getR();
                                                    } else {
                                                        if (!(metaData instanceof Either.Left)) {
                                                            throw new NoWhenBranchMatchedException();
                                                        }
                                                        obj2 = null;
                                                    }
                                                    MetaDataResp metaDataResp7 = (MetaDataResp) obj2;
                                                    if (metaDataResp7 != null && (usNat = metaDataResp7.getUsNat()) != null) {
                                                        bool = usNat.getApplies();
                                                    }
                                                    uSNatConsentData = USNatConsentData.copy$default(usNatConsentData4, bool, null, null, null, null, null, null, null, null, null, null, null, null, 8190, null);
                                                }
                                                campaignManager21.setUsNatConsentData(uSNatConsentData);
                                            }
                                        }
                                    }
                                    Unit unit16 = Unit.INSTANCE;
                                }
                                executorManager2 = serviceImpl6.execManager;
                                executorManager2.executeOnMain(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.data.ServiceImpl$getMessages$1$5$7
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
                                        function1.invoke(messagesResp);
                                    }
                                });
                            } else {
                                boolean z4 = messages instanceof Either.Left;
                            }
                        }
                        ServiceImpl.this.pvData(messageReq, onFailure);
                        return;
                    }
                    function2.invoke(((Either.Left) metaData).getT(), true);
                    return;
                }
                onFailure.invoke(new NoInternetConnectionException(null, null, false, 7, null), true);
            }
        });
    }

    public final void pvData(MessagesParamReq messageReq, Function2<? super Throwable, ? super Boolean, Unit> onFailure) {
        ServiceImpl serviceImpl;
        Function2<? super Throwable, ? super Boolean, Unit> function2;
        Intrinsics.checkNotNullParameter(messageReq, "messageReq");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        if (SpConfigExtKt.isIncluded(getSpConfig(), CampaignType.GDPR)) {
            DataStorage dataStorage = this.dataStorage;
            serviceImpl = this;
            function2 = onFailure;
            dataStorage.setGdprSampled(Boolean.valueOf(serviceImpl.sampleAndPvData(dataStorage.getGdprSampled(), this.dataStorage.getGdprSampleRate(), new PvDataParamReq(messageReq.getEnv(), this.campaignManager.getGdprPvDataBody(messageReq), CampaignType.GDPR), function2)));
        } else {
            serviceImpl = this;
            function2 = onFailure;
        }
        if (SpConfigExtKt.isIncluded(getSpConfig(), CampaignType.CCPA)) {
            DataStorage dataStorage2 = serviceImpl.dataStorage;
            dataStorage2.setCcpaSampled(Boolean.valueOf(serviceImpl.sampleAndPvData(dataStorage2.getCcpaSampled(), serviceImpl.dataStorage.getCcpaSampleRate(), new PvDataParamReq(messageReq.getEnv(), serviceImpl.campaignManager.getCcpaPvDataBody(messageReq), CampaignType.CCPA), function2)));
        }
        if (SpConfigExtKt.isIncluded(getSpConfig(), CampaignType.USNAT)) {
            DataStorage dataStorage3 = serviceImpl.dataStorage;
            dataStorage3.setUsnatSampled(Boolean.valueOf(serviceImpl.sampleAndPvData(dataStorage3.getUsnatSampled(), serviceImpl.dataStorage.getUsnatSampleRate(), new PvDataParamReq(messageReq.getEnv(), serviceImpl.campaignManager.getUsNatPvDataBody(messageReq), CampaignType.USNAT), function2)));
        }
    }

    private final boolean sampleAndPvData(Boolean wasSampled, double rate, PvDataParamReq pvDataParams, Function2<? super Throwable, ? super Boolean, Unit> onFailure) {
        if (Intrinsics.areEqual((Object) wasSampled, (Object) false)) {
            return false;
        }
        boolean z = Intrinsics.areEqual((Object) wasSampled, (Object) true) || this.consentManagerUtils.sample(rate);
        if (z) {
            Either<PvDataResp> postPvData = postPvData(pvDataParams);
            boolean z2 = postPvData instanceof Either.Right;
            if (!z2 && (postPvData instanceof Either.Left)) {
                onFailure.invoke(((Either.Left) postPvData).getT(), false);
            }
            if (z2) {
                PvDataResp pvDataResp = (PvDataResp) ((Either.Right) postPvData).getR();
                PvDataResp.Campaign usnat = pvDataResp.getUsnat();
                if (usnat != null) {
                    USNatConsentData usNatConsentData = getUsNatConsentData();
                    setUsNatConsentData(usNatConsentData != null ? USNatConsentData.copy$default(usNatConsentData, null, null, null, null, usnat.getUuid(), null, null, null, null, null, null, null, null, 8175, null) : null);
                }
                PvDataResp.Campaign gdpr = pvDataResp.getGdpr();
                if (gdpr != null) {
                    GdprCS gdprConsentStatus = getGdprConsentStatus();
                    setGdprConsentStatus(gdprConsentStatus != null ? GdprCS.copy$default(gdprConsentStatus, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, gdpr.getUuid(), null, null, null, null, 16252927, null) : null);
                }
                PvDataResp.Campaign ccpa = pvDataResp.getCcpa();
                if (ccpa != null) {
                    CcpaCS ccpaConsentStatus = getCcpaConsentStatus();
                    setCcpaConsentStatus(ccpaConsentStatus != null ? ccpaConsentStatus.copy((r32 & 1) != 0 ? ccpaConsentStatus.applies : null, (r32 & 2) != 0 ? ccpaConsentStatus.consentedAll : null, (r32 & 4) != 0 ? ccpaConsentStatus.dateCreated : null, (r32 & 8) != 0 ? ccpaConsentStatus.gpcEnabled : null, (r32 & 16) != 0 ? ccpaConsentStatus.newUser : null, (r32 & 32) != 0 ? ccpaConsentStatus.rejectedAll : null, (r32 & 64) != 0 ? ccpaConsentStatus.rejectedCategories : null, (r32 & 128) != 0 ? ccpaConsentStatus.rejectedVendors : null, (r32 & 256) != 0 ? ccpaConsentStatus.signedLspa : null, (r32 & 512) != 0 ? ccpaConsentStatus.uspstring : null, (r32 & 1024) != 0 ? ccpaConsentStatus.status : null, (r32 & 2048) != 0 ? ccpaConsentStatus.gppData : null, (r32 & 4096) != 0 ? ccpaConsentStatus.uuid : ccpa.getUuid(), (r32 & 8192) != 0 ? ccpaConsentStatus.webConsentPayload : null, (r32 & 16384) != 0 ? ccpaConsentStatus.expirationDate : null) : null);
                    return z;
                }
            } else {
                boolean z3 = postPvData instanceof Either.Left;
            }
        }
        return z;
    }

    @Override // com.sourcepoint.cmplibrary.data.Service
    public Either<ChoiceResp> sendConsent(Env env, ConsentActionImpl consentAction, Function1<? super SPConsents, Unit> onSpConsentsSuccess) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(consentAction, "consentAction");
        if (this.connectionManager.isConnected()) {
            int i = WhenMappings.$EnumSwitchMapping$0[consentAction.getCampaignType().ordinal()];
            if (i == 1) {
                Either sendConsentGdpr = sendConsentGdpr(env, consentAction, onSpConsentsSuccess);
                if (sendConsentGdpr instanceof Either.Right) {
                    return new Either.Right(new ChoiceResp((CcpaCS) null, (GdprCS) ((Either.Right) sendConsentGdpr).getR(), (USNatConsentData) null, 5, (DefaultConstructorMarker) null));
                }
                if (sendConsentGdpr instanceof Either.Left) {
                    return sendConsentGdpr;
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i == 2) {
                Either sendConsentCcpa = sendConsentCcpa(env, consentAction, onSpConsentsSuccess);
                if (sendConsentCcpa instanceof Either.Right) {
                    return new Either.Right(new ChoiceResp((CcpaCS) ((Either.Right) sendConsentCcpa).getR(), (GdprCS) null, (USNatConsentData) null, 6, (DefaultConstructorMarker) null));
                }
                if (sendConsentCcpa instanceof Either.Left) {
                    return sendConsentCcpa;
                }
                throw new NoWhenBranchMatchedException();
            }
            if (i == 3) {
                Either sendConsentUsNat = sendConsentUsNat(env, consentAction, onSpConsentsSuccess);
                if (sendConsentUsNat instanceof Either.Right) {
                    return new Either.Right(new ChoiceResp((CcpaCS) null, (GdprCS) null, (USNatConsentData) ((Either.Right) sendConsentUsNat).getR(), 3, (DefaultConstructorMarker) null));
                }
                if (sendConsentUsNat instanceof Either.Left) {
                    return sendConsentUsNat;
                }
                throw new NoWhenBranchMatchedException();
            }
            throw new NoWhenBranchMatchedException();
        }
        Either spStoredConsent = this.consentManagerUtils.getSpStoredConsent();
        boolean z = spStoredConsent instanceof Either.Right;
        if (z) {
            SPConsents sPConsents = (SPConsents) ((Either.Right) spStoredConsent).getR();
            if (onSpConsentsSuccess != null) {
                onSpConsentsSuccess.invoke(sPConsents);
            }
        } else {
            boolean z2 = spStoredConsent instanceof Either.Left;
        }
        if (z) {
            return new Either.Right(this.campaignManager.getStoreChoiceResp());
        }
        if (spStoredConsent instanceof Either.Left) {
            return spStoredConsent;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Either<GdprCS> sendConsentGdpr(final Env env, final ConsentActionImpl consentAction, final Function1<? super SPConsents, Unit> onSpConsentsSuccess) {
        return FunctionalUtilsKt.check(new Function0<GdprCS>() { // from class: com.sourcepoint.cmplibrary.data.ServiceImpl$sendConsentGdpr$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Removed duplicated region for block: B:102:0x031a  */
            /* JADX WARN: Removed duplicated region for block: B:103:0x027b  */
            /* JADX WARN: Removed duplicated region for block: B:69:0x0274  */
            /* JADX WARN: Removed duplicated region for block: B:72:0x02b4  */
            /* JADX WARN: Removed duplicated region for block: B:84:0x032e  */
            /* JADX WARN: Removed duplicated region for block: B:86:0x0335  */
            /* JADX WARN: Removed duplicated region for block: B:87:0x0332  */
            /* JADX WARN: Removed duplicated region for block: B:89:0x0340  */
            /* JADX WARN: Removed duplicated region for block: B:97:0x03a6 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:99:0x03a7  */
            @Override // kotlin.jvm.functions.Function0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final GdprCS invoke() {
                ChoiceResp choiceResp;
                boolean z;
                NetworkClient networkClient;
                DataStorage dataStorage;
                CampaignManager campaignManager;
                CampaignManager campaignManager2;
                CampaignManager campaignManager3;
                DataStorage dataStorage2;
                CampaignManager campaignManager4;
                Either<GdprCS> storeGdprChoice;
                boolean z2;
                CampaignManager campaignManager5;
                GdprCS gdprConsentStatus;
                CampaignManager campaignManager6;
                ConsentManagerUtils consentManagerUtils;
                DataStorage dataStorage3;
                Throwable t;
                Logger logger;
                CampaignManager campaignManager7;
                CampaignManager campaignManager8;
                CampaignManager campaignManager9;
                CampaignManager campaignManager10;
                GdprCS gdpr;
                GdprCS gdpr2;
                ConsentStatus consentStatus;
                Integer messageId;
                CampaignManager campaignManager11;
                CampaignManager campaignManager12;
                NetworkClient networkClient2;
                Object obj;
                CampaignManager campaignManager13;
                GdprCS gdprCS;
                ConsentManagerUtils consentManagerUtils2;
                DataStorage dataStorage4;
                Logger logger2;
                CampaignManager campaignManager14;
                CampaignManager campaignManager15;
                CampaignManager campaignManager16;
                DataStorage dataStorage5;
                ConsentManagerUtils consentManagerUtils3;
                MetaDataArg metaDataArg;
                GdprCS gdprCS2 = null;
                if (ActionTypeExtKt.isAcceptOrRejectAll(ConsentActionImpl.this.getActionType())) {
                    ChoiceTypeParam choiceTypeParam = ConsentActionImplKt.toChoiceTypeParam(ConsentActionImpl.this.getActionType());
                    long j = this.getSpConfig().accountId;
                    long j2 = this.getSpConfig().propertyId;
                    campaignManager11 = this.campaignManager;
                    MetaDataResp metaDataResp = campaignManager11.getMetaDataResp();
                    MetaDataArg copy$default = (metaDataResp == null || (metaDataArg = MetaDataApiModelKt.toMetaDataArg(metaDataResp)) == null) ? null : MetaDataArg.copy$default(metaDataArg, null, null, null, 2, null);
                    campaignManager12 = this.campaignManager;
                    GetChoiceParamReq getChoiceParamReq = new GetChoiceParamReq(env, choiceTypeParam, copy$default, j2, j, IncludeDataKt.buildIncludeData(SpConfigExtKt.getGppCustomOption(campaignManager12.getSpConfig())), false, false, false, 448, (DefaultConstructorMarker) null);
                    networkClient2 = this.networkClient;
                    Either<ChoiceResp> choice = networkClient2.getChoice(getChoiceParamReq);
                    ServiceImpl serviceImpl = this;
                    Function1<SPConsents, Unit> function1 = onSpConsentsSuccess;
                    boolean z3 = choice instanceof Either.Right;
                    if (z3) {
                        GdprCS gdpr3 = ((ChoiceResp) ((Either.Right) choice).getR()).getGdpr();
                        if (gdpr3 != null) {
                            campaignManager14 = serviceImpl.campaignManager;
                            campaignManager15 = serviceImpl.campaignManager;
                            GdprCS gdprConsentStatus2 = campaignManager15.getGdprConsentStatus();
                            campaignManager14.setGdprConsentStatus(GdprCS.copy$default(gdpr3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, gdprConsentStatus2 != null ? gdprConsentStatus2.getUuid() : null, null, null, null, null, 16252927, null));
                            ConsentManager.Companion companion = ConsentManager.INSTANCE;
                            campaignManager16 = serviceImpl.campaignManager;
                            GdprCS gdprConsentStatus3 = campaignManager16.getGdprConsentStatus();
                            String uuid = gdprConsentStatus3 != null ? gdprConsentStatus3.getUuid() : null;
                            dataStorage5 = serviceImpl.dataStorage;
                            GdprCS copy$default2 = GdprCS.copy$default(gdpr3, Boolean.valueOf(dataStorage5.getGdprApplies()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, uuid, null, null, null, null, 16252926, null);
                            consentManagerUtils3 = serviceImpl.consentManagerUtils;
                            SPConsents responseConsentHandler$cmplibrary_release = companion.responseConsentHandler$cmplibrary_release(copy$default2, consentManagerUtils3);
                            if (function1 != null) {
                                function1.invoke(responseConsentHandler$cmplibrary_release);
                            }
                        }
                    } else {
                        boolean z4 = choice instanceof Either.Left;
                    }
                    ServiceImpl serviceImpl2 = this;
                    Function1<SPConsents, Unit> function12 = onSpConsentsSuccess;
                    if (!z3 && (choice instanceof Either.Left)) {
                        Throwable t2 = ((Either.Left) choice).getT();
                        if ((t2 instanceof ConsentLibExceptionK ? (ConsentLibExceptionK) t2 : null) != null) {
                            logger2 = serviceImpl2.logger;
                            logger2.error((RuntimeException) t2);
                        }
                        ConsentManager.Companion companion2 = ConsentManager.INSTANCE;
                        campaignManager13 = serviceImpl2.campaignManager;
                        GdprCS gdprConsentStatus4 = campaignManager13.getGdprConsentStatus();
                        if (gdprConsentStatus4 != null) {
                            dataStorage4 = serviceImpl2.dataStorage;
                            gdprCS = GdprCS.copy$default(gdprConsentStatus4, Boolean.valueOf(dataStorage4.getGdprApplies()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16777214, null);
                        } else {
                            gdprCS = null;
                        }
                        consentManagerUtils2 = serviceImpl2.consentManagerUtils;
                        SPConsents responseConsentHandler$cmplibrary_release2 = companion2.responseConsentHandler$cmplibrary_release(gdprCS, consentManagerUtils2);
                        if (function12 != null) {
                            function12.invoke(responseConsentHandler$cmplibrary_release2);
                        }
                    }
                    if (z3) {
                        obj = ((Either.Right) choice).getR();
                    } else {
                        if (!(choice instanceof Either.Left)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        obj = null;
                    }
                    choiceResp = (ChoiceResp) obj;
                } else {
                    choiceResp = null;
                }
                if (ActionTypeExtKt.isAcceptOrRejectAll(ConsentActionImpl.this.getActionType())) {
                    if ((choiceResp != null ? choiceResp.getGdpr() : null) != null) {
                        z = false;
                        networkClient = this.networkClient;
                        Env env2 = env;
                        ActionType actionType = ConsentActionImpl.this.getActionType();
                        dataStorage = this.dataStorage;
                        double gdprSampleRate = dataStorage.getGdprSampleRate();
                        long j3 = this.getSpConfig().propertyId;
                        campaignManager = this.campaignManager;
                        MessageMetaData gdprMessageMetaData = campaignManager.getGdprMessageMetaData();
                        Long valueOf = (gdprMessageMetaData != null || (messageId = gdprMessageMetaData.getMessageId()) == null) ? null : Long.valueOf(messageId.intValue());
                        campaignManager2 = this.campaignManager;
                        GdprCS gdprConsentStatus5 = campaignManager2.getGdprConsentStatus();
                        ConsentStatus.GranularStatus granularStatus = (gdprConsentStatus5 != null || (consentStatus = gdprConsentStatus5.getConsentStatus()) == null) ? null : consentStatus.getGranularStatus();
                        String consentAllRef = (choiceResp != null || (gdpr2 = choiceResp.getGdpr()) == null) ? null : gdpr2.getConsentAllRef();
                        String vendorListId = (choiceResp != null || (gdpr = choiceResp.getGdpr()) == null) ? null : gdpr.getVendorListId();
                        JsonObject saveAndExitVariablesOptimized = ConsentActionImpl.this.getSaveAndExitVariablesOptimized();
                        String authId = this.getAuthId();
                        campaignManager3 = this.campaignManager;
                        GdprCS gdprConsentStatus6 = campaignManager3.getGdprConsentStatus();
                        String uuid2 = gdprConsentStatus6 == null ? gdprConsentStatus6.getUuid() : null;
                        dataStorage2 = this.dataStorage;
                        Boolean gdprSampled = dataStorage2.getGdprSampled();
                        JsonObject jsonObject = JSONObjectExtKt.toJsonObject(ConsentActionImpl.this.getPubData());
                        campaignManager4 = this.campaignManager;
                        storeGdprChoice = networkClient.storeGdprChoice(new PostChoiceParamReq(env2, actionType, PostChoiceApiModelExtKt.postChoiceGdprBody(gdprSampleRate, j3, valueOf, consentAllRef, vendorListId, granularStatus, gdprSampled, jsonObject, saveAndExitVariablesOptimized, authId, uuid2, IncludeDataKt.buildIncludeData(SpConfigExtKt.getGppCustomOption(campaignManager4.getSpConfig())))));
                        ServiceImpl serviceImpl3 = this;
                        z2 = storeGdprChoice instanceof Either.Right;
                        if (!z2) {
                            GdprCS gdprCS3 = (GdprCS) ((Either.Right) storeGdprChoice).getR();
                            campaignManager7 = serviceImpl3.campaignManager;
                            campaignManager7.setGdprUuid(gdprCS3.getUuid());
                            campaignManager8 = serviceImpl3.campaignManager;
                            campaignManager9 = serviceImpl3.campaignManager;
                            GdprCS gdprConsentStatus7 = campaignManager9.getGdprConsentStatus();
                            campaignManager8.setGdprConsentStatus(gdprConsentStatus7 != null ? GdprCS.copy$default(gdprConsentStatus7, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, gdprCS3.getUuid(), null, null, null, null, 16252927, null) : null);
                            if (z) {
                                campaignManager10 = serviceImpl3.campaignManager;
                                campaignManager10.setGdprConsentStatus(gdprCS3);
                            }
                        } else {
                            boolean z5 = storeGdprChoice instanceof Either.Left;
                        }
                        ServiceImpl serviceImpl4 = this;
                        if (!z2 && (storeGdprChoice instanceof Either.Left)) {
                            t = ((Either.Left) storeGdprChoice).getT();
                            if ((!(t instanceof ConsentLibExceptionK) ? (ConsentLibExceptionK) t : null) != null) {
                                logger = serviceImpl4.logger;
                                logger.error((RuntimeException) t);
                            }
                        }
                        if (z) {
                            ConsentManager.Companion companion3 = ConsentManager.INSTANCE;
                            campaignManager6 = this.campaignManager;
                            GdprCS gdprConsentStatus8 = campaignManager6.getGdprConsentStatus();
                            if (gdprConsentStatus8 != null) {
                                dataStorage3 = this.dataStorage;
                                gdprCS2 = GdprCS.copy$default(gdprConsentStatus8, Boolean.valueOf(dataStorage3.getGdprApplies()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16777214, null);
                            }
                            consentManagerUtils = this.consentManagerUtils;
                            SPConsents responseConsentHandler$cmplibrary_release3 = companion3.responseConsentHandler$cmplibrary_release(gdprCS2, consentManagerUtils);
                            Function1<SPConsents, Unit> function13 = onSpConsentsSuccess;
                            if (function13 != null) {
                                function13.invoke(responseConsentHandler$cmplibrary_release3);
                            }
                        }
                        campaignManager5 = this.campaignManager;
                        gdprConsentStatus = campaignManager5.getGdprConsentStatus();
                        if (gdprConsentStatus == null) {
                            return gdprConsentStatus;
                        }
                        throw new InvalidConsentResponse(null, "The GDPR consent object cannot be null!!!", false, 4, null);
                    }
                }
                z = true;
                networkClient = this.networkClient;
                Env env22 = env;
                ActionType actionType2 = ConsentActionImpl.this.getActionType();
                dataStorage = this.dataStorage;
                double gdprSampleRate2 = dataStorage.getGdprSampleRate();
                long j32 = this.getSpConfig().propertyId;
                campaignManager = this.campaignManager;
                MessageMetaData gdprMessageMetaData2 = campaignManager.getGdprMessageMetaData();
                if (gdprMessageMetaData2 != null) {
                }
                campaignManager2 = this.campaignManager;
                GdprCS gdprConsentStatus52 = campaignManager2.getGdprConsentStatus();
                if (gdprConsentStatus52 != null) {
                }
                if (choiceResp != null) {
                }
                if (choiceResp != null) {
                }
                JsonObject saveAndExitVariablesOptimized2 = ConsentActionImpl.this.getSaveAndExitVariablesOptimized();
                String authId2 = this.getAuthId();
                campaignManager3 = this.campaignManager;
                GdprCS gdprConsentStatus62 = campaignManager3.getGdprConsentStatus();
                if (gdprConsentStatus62 == null) {
                }
                dataStorage2 = this.dataStorage;
                Boolean gdprSampled2 = dataStorage2.getGdprSampled();
                JsonObject jsonObject2 = JSONObjectExtKt.toJsonObject(ConsentActionImpl.this.getPubData());
                campaignManager4 = this.campaignManager;
                storeGdprChoice = networkClient.storeGdprChoice(new PostChoiceParamReq(env22, actionType2, PostChoiceApiModelExtKt.postChoiceGdprBody(gdprSampleRate2, j32, valueOf, consentAllRef, vendorListId, granularStatus, gdprSampled2, jsonObject2, saveAndExitVariablesOptimized2, authId2, uuid2, IncludeDataKt.buildIncludeData(SpConfigExtKt.getGppCustomOption(campaignManager4.getSpConfig())))));
                ServiceImpl serviceImpl32 = this;
                z2 = storeGdprChoice instanceof Either.Right;
                if (!z2) {
                }
                ServiceImpl serviceImpl42 = this;
                if (!z2) {
                    t = ((Either.Left) storeGdprChoice).getT();
                    if ((!(t instanceof ConsentLibExceptionK) ? (ConsentLibExceptionK) t : null) != null) {
                    }
                }
                if (z) {
                }
                campaignManager5 = this.campaignManager;
                gdprConsentStatus = campaignManager5.getGdprConsentStatus();
                if (gdprConsentStatus == null) {
                }
            }
        });
    }

    private final Either<CcpaCS> sendConsentCcpa(final Env env, final ConsentActionImpl consentAction, final Function1<? super SPConsents, Unit> onSpConsentsSuccess) {
        return FunctionalUtilsKt.check(new Function0<CcpaCS>() { // from class: com.sourcepoint.cmplibrary.data.ServiceImpl$sendConsentCcpa$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Removed duplicated region for block: B:56:0x0203  */
            /* JADX WARN: Removed duplicated region for block: B:59:0x0243  */
            /* JADX WARN: Removed duplicated region for block: B:73:0x02aa  */
            /* JADX WARN: Removed duplicated region for block: B:75:0x02b1  */
            /* JADX WARN: Removed duplicated region for block: B:76:0x02ae  */
            /* JADX WARN: Removed duplicated region for block: B:78:0x02bc  */
            /* JADX WARN: Removed duplicated region for block: B:86:0x030f A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:88:0x0310  */
            /* JADX WARN: Removed duplicated region for block: B:90:0x0296  */
            /* JADX WARN: Removed duplicated region for block: B:91:0x020a  */
            @Override // kotlin.jvm.functions.Function0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final CcpaCS invoke() {
                ChoiceResp choiceResp;
                boolean z;
                NetworkClient networkClient;
                DataStorage dataStorage;
                CampaignManager campaignManager;
                CampaignManager campaignManager2;
                DataStorage dataStorage2;
                CampaignManager campaignManager3;
                Either<CcpaCS> storeCcpaChoice;
                boolean z2;
                CampaignManager campaignManager4;
                CcpaCS ccpaConsentStatus;
                CampaignManager campaignManager5;
                ConsentManagerUtils consentManagerUtils;
                DataStorage dataStorage3;
                Throwable t;
                Logger logger;
                CampaignManager campaignManager6;
                CampaignManager campaignManager7;
                CampaignManager campaignManager8;
                Integer messageId;
                NetworkClient networkClient2;
                CampaignManager campaignManager9;
                CampaignManager campaignManager10;
                Object obj;
                CampaignManager campaignManager11;
                CcpaCS ccpaCS;
                ConsentManagerUtils consentManagerUtils2;
                DataStorage dataStorage4;
                Logger logger2;
                CampaignManager campaignManager12;
                CampaignManager campaignManager13;
                CcpaCS copy;
                CampaignManager campaignManager14;
                DataStorage dataStorage5;
                CcpaCS copy2;
                ConsentManagerUtils consentManagerUtils3;
                MetaDataArg metaDataArg;
                CcpaCS ccpaCS2 = null;
                if (ActionTypeExtKt.isAcceptOrRejectAll(ConsentActionImpl.this.getActionType())) {
                    networkClient2 = this.networkClient;
                    ChoiceTypeParam choiceTypeParam = ConsentActionImplKt.toChoiceTypeParam(ConsentActionImpl.this.getActionType());
                    long j = this.getSpConfig().accountId;
                    long j2 = this.getSpConfig().propertyId;
                    campaignManager9 = this.campaignManager;
                    MetaDataResp metaDataResp = campaignManager9.getMetaDataResp();
                    MetaDataArg copy$default = (metaDataResp == null || (metaDataArg = MetaDataApiModelKt.toMetaDataArg(metaDataResp)) == null) ? null : MetaDataArg.copy$default(metaDataArg, null, null, null, 1, null);
                    campaignManager10 = this.campaignManager;
                    Either<ChoiceResp> choice = networkClient2.getChoice(new GetChoiceParamReq(env, choiceTypeParam, copy$default, j2, j, IncludeDataKt.buildIncludeData(SpConfigExtKt.getGppCustomOption(campaignManager10.getSpConfig())), false, false, false, 448, (DefaultConstructorMarker) null));
                    ServiceImpl serviceImpl = this;
                    Function1<SPConsents, Unit> function1 = onSpConsentsSuccess;
                    boolean z3 = choice instanceof Either.Right;
                    if (z3) {
                        CcpaCS ccpa = ((ChoiceResp) ((Either.Right) choice).getR()).getCcpa();
                        if (ccpa != null) {
                            campaignManager12 = serviceImpl.campaignManager;
                            campaignManager13 = serviceImpl.campaignManager;
                            CcpaCS ccpaConsentStatus2 = campaignManager13.getCcpaConsentStatus();
                            copy = ccpa.copy((r32 & 1) != 0 ? ccpa.applies : null, (r32 & 2) != 0 ? ccpa.consentedAll : null, (r32 & 4) != 0 ? ccpa.dateCreated : null, (r32 & 8) != 0 ? ccpa.gpcEnabled : null, (r32 & 16) != 0 ? ccpa.newUser : null, (r32 & 32) != 0 ? ccpa.rejectedAll : null, (r32 & 64) != 0 ? ccpa.rejectedCategories : null, (r32 & 128) != 0 ? ccpa.rejectedVendors : null, (r32 & 256) != 0 ? ccpa.signedLspa : null, (r32 & 512) != 0 ? ccpa.uspstring : null, (r32 & 1024) != 0 ? ccpa.status : null, (r32 & 2048) != 0 ? ccpa.gppData : null, (r32 & 4096) != 0 ? ccpa.uuid : ccpaConsentStatus2 != null ? ccpaConsentStatus2.getUuid() : null, (r32 & 8192) != 0 ? ccpa.webConsentPayload : null, (r32 & 16384) != 0 ? ccpa.expirationDate : null);
                            campaignManager12.setCcpaConsentStatus(copy);
                            if (function1 != null) {
                                ConsentManager.Companion companion = ConsentManager.INSTANCE;
                                campaignManager14 = serviceImpl.campaignManager;
                                CcpaCS ccpaConsentStatus3 = campaignManager14.getCcpaConsentStatus();
                                String uuid = ccpaConsentStatus3 != null ? ccpaConsentStatus3.getUuid() : null;
                                dataStorage5 = serviceImpl.dataStorage;
                                copy2 = ccpa.copy((r32 & 1) != 0 ? ccpa.applies : Boolean.valueOf(dataStorage5.getCcpaApplies()), (r32 & 2) != 0 ? ccpa.consentedAll : null, (r32 & 4) != 0 ? ccpa.dateCreated : null, (r32 & 8) != 0 ? ccpa.gpcEnabled : null, (r32 & 16) != 0 ? ccpa.newUser : null, (r32 & 32) != 0 ? ccpa.rejectedAll : null, (r32 & 64) != 0 ? ccpa.rejectedCategories : null, (r32 & 128) != 0 ? ccpa.rejectedVendors : null, (r32 & 256) != 0 ? ccpa.signedLspa : null, (r32 & 512) != 0 ? ccpa.uspstring : null, (r32 & 1024) != 0 ? ccpa.status : null, (r32 & 2048) != 0 ? ccpa.gppData : null, (r32 & 4096) != 0 ? ccpa.uuid : uuid, (r32 & 8192) != 0 ? ccpa.webConsentPayload : null, (r32 & 16384) != 0 ? ccpa.expirationDate : null);
                                consentManagerUtils3 = serviceImpl.consentManagerUtils;
                                function1.invoke(companion.responseConsentHandler$cmplibrary_release(copy2, consentManagerUtils3));
                            }
                        }
                    } else {
                        boolean z4 = choice instanceof Either.Left;
                    }
                    ServiceImpl serviceImpl2 = this;
                    Function1<SPConsents, Unit> function12 = onSpConsentsSuccess;
                    if (!z3 && (choice instanceof Either.Left)) {
                        Throwable t2 = ((Either.Left) choice).getT();
                        if ((t2 instanceof ConsentLibExceptionK ? (ConsentLibExceptionK) t2 : null) != null) {
                            logger2 = serviceImpl2.logger;
                            logger2.error((RuntimeException) t2);
                        }
                        ConsentManager.Companion companion2 = ConsentManager.INSTANCE;
                        campaignManager11 = serviceImpl2.campaignManager;
                        CcpaCS ccpaConsentStatus4 = campaignManager11.getCcpaConsentStatus();
                        if (ccpaConsentStatus4 != null) {
                            dataStorage4 = serviceImpl2.dataStorage;
                            ccpaCS = ccpaConsentStatus4.copy((r32 & 1) != 0 ? ccpaConsentStatus4.applies : Boolean.valueOf(dataStorage4.getCcpaApplies()), (r32 & 2) != 0 ? ccpaConsentStatus4.consentedAll : null, (r32 & 4) != 0 ? ccpaConsentStatus4.dateCreated : null, (r32 & 8) != 0 ? ccpaConsentStatus4.gpcEnabled : null, (r32 & 16) != 0 ? ccpaConsentStatus4.newUser : null, (r32 & 32) != 0 ? ccpaConsentStatus4.rejectedAll : null, (r32 & 64) != 0 ? ccpaConsentStatus4.rejectedCategories : null, (r32 & 128) != 0 ? ccpaConsentStatus4.rejectedVendors : null, (r32 & 256) != 0 ? ccpaConsentStatus4.signedLspa : null, (r32 & 512) != 0 ? ccpaConsentStatus4.uspstring : null, (r32 & 1024) != 0 ? ccpaConsentStatus4.status : null, (r32 & 2048) != 0 ? ccpaConsentStatus4.gppData : null, (r32 & 4096) != 0 ? ccpaConsentStatus4.uuid : null, (r32 & 8192) != 0 ? ccpaConsentStatus4.webConsentPayload : null, (r32 & 16384) != 0 ? ccpaConsentStatus4.expirationDate : null);
                        } else {
                            ccpaCS = null;
                        }
                        consentManagerUtils2 = serviceImpl2.consentManagerUtils;
                        SPConsents responseConsentHandler$cmplibrary_release = companion2.responseConsentHandler$cmplibrary_release(ccpaCS, consentManagerUtils2);
                        if (function12 != null) {
                            function12.invoke(responseConsentHandler$cmplibrary_release);
                        }
                    }
                    if (z3) {
                        obj = ((Either.Right) choice).getR();
                    } else {
                        if (!(choice instanceof Either.Left)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        obj = null;
                    }
                    choiceResp = (ChoiceResp) obj;
                } else {
                    choiceResp = null;
                }
                if (ActionTypeExtKt.isAcceptOrRejectAll(ConsentActionImpl.this.getActionType())) {
                    if ((choiceResp != null ? choiceResp.getCcpa() : null) != null) {
                        z = false;
                        networkClient = this.networkClient;
                        Env env2 = env;
                        ActionType actionType = ConsentActionImpl.this.getActionType();
                        dataStorage = this.dataStorage;
                        double ccpaSampleRate = dataStorage.getCcpaSampleRate();
                        long j3 = this.getSpConfig().propertyId;
                        campaignManager = this.campaignManager;
                        MessageMetaData ccpaMessageMetaData = campaignManager.getCcpaMessageMetaData();
                        Long valueOf = (ccpaMessageMetaData != null || (messageId = ccpaMessageMetaData.getMessageId()) == null) ? null : Long.valueOf(messageId.intValue());
                        JsonObject saveAndExitVariablesOptimized = ConsentActionImpl.this.getSaveAndExitVariablesOptimized();
                        String authId = this.getAuthId();
                        campaignManager2 = this.campaignManager;
                        CcpaCS ccpaConsentStatus5 = campaignManager2.getCcpaConsentStatus();
                        String uuid2 = ccpaConsentStatus5 == null ? ccpaConsentStatus5.getUuid() : null;
                        dataStorage2 = this.dataStorage;
                        Boolean ccpaSampled = dataStorage2.getCcpaSampled();
                        JsonObject jsonObject = JSONObjectExtKt.toJsonObject(ConsentActionImpl.this.getPubData());
                        campaignManager3 = this.campaignManager;
                        storeCcpaChoice = networkClient.storeCcpaChoice(new PostChoiceParamReq(env2, actionType, PostChoiceApiModelExtKt.postChoiceCcpaBody(ccpaSampleRate, j3, valueOf, ccpaSampled, jsonObject, saveAndExitVariablesOptimized, authId, uuid2, IncludeDataKt.buildIncludeData(SpConfigExtKt.getGppCustomOption(campaignManager3.getSpConfig())))));
                        ServiceImpl serviceImpl3 = this;
                        z2 = storeCcpaChoice instanceof Either.Right;
                        if (!z2) {
                            CcpaCS ccpaCS3 = (CcpaCS) ((Either.Right) storeCcpaChoice).getR();
                            campaignManager6 = serviceImpl3.campaignManager;
                            campaignManager6.setCcpaUuid(ccpaCS3.getUuid());
                            campaignManager7 = serviceImpl3.campaignManager;
                            if (ccpaCS3.getWebConsentPayload() == null) {
                                campaignManager8 = serviceImpl3.campaignManager;
                                CcpaCS ccpaConsentStatus6 = campaignManager8.getCcpaConsentStatus();
                                ccpaCS3 = ccpaCS3.copy((r32 & 1) != 0 ? ccpaCS3.applies : null, (r32 & 2) != 0 ? ccpaCS3.consentedAll : null, (r32 & 4) != 0 ? ccpaCS3.dateCreated : null, (r32 & 8) != 0 ? ccpaCS3.gpcEnabled : null, (r32 & 16) != 0 ? ccpaCS3.newUser : null, (r32 & 32) != 0 ? ccpaCS3.rejectedAll : null, (r32 & 64) != 0 ? ccpaCS3.rejectedCategories : null, (r32 & 128) != 0 ? ccpaCS3.rejectedVendors : null, (r32 & 256) != 0 ? ccpaCS3.signedLspa : null, (r32 & 512) != 0 ? ccpaCS3.uspstring : null, (r32 & 1024) != 0 ? ccpaCS3.status : null, (r32 & 2048) != 0 ? ccpaCS3.gppData : null, (r32 & 4096) != 0 ? ccpaCS3.uuid : null, (r32 & 8192) != 0 ? ccpaCS3.webConsentPayload : ccpaConsentStatus6 != null ? ccpaConsentStatus6.getWebConsentPayload() : null, (r32 & 16384) != 0 ? ccpaCS3.expirationDate : null);
                            }
                            campaignManager7.setCcpaConsentStatus(ccpaCS3);
                        } else {
                            boolean z5 = storeCcpaChoice instanceof Either.Left;
                        }
                        ServiceImpl serviceImpl4 = this;
                        if (!z2 && (storeCcpaChoice instanceof Either.Left)) {
                            t = ((Either.Left) storeCcpaChoice).getT();
                            if ((!(t instanceof ConsentLibExceptionK) ? (ConsentLibExceptionK) t : null) != null) {
                                logger = serviceImpl4.logger;
                                logger.error((RuntimeException) t);
                            }
                        }
                        if (z) {
                            ConsentManager.Companion companion3 = ConsentManager.INSTANCE;
                            campaignManager5 = this.campaignManager;
                            CcpaCS ccpaConsentStatus7 = campaignManager5.getCcpaConsentStatus();
                            if (ccpaConsentStatus7 != null) {
                                dataStorage3 = this.dataStorage;
                                ccpaCS2 = ccpaConsentStatus7.copy((r32 & 1) != 0 ? ccpaConsentStatus7.applies : Boolean.valueOf(dataStorage3.getCcpaApplies()), (r32 & 2) != 0 ? ccpaConsentStatus7.consentedAll : null, (r32 & 4) != 0 ? ccpaConsentStatus7.dateCreated : null, (r32 & 8) != 0 ? ccpaConsentStatus7.gpcEnabled : null, (r32 & 16) != 0 ? ccpaConsentStatus7.newUser : null, (r32 & 32) != 0 ? ccpaConsentStatus7.rejectedAll : null, (r32 & 64) != 0 ? ccpaConsentStatus7.rejectedCategories : null, (r32 & 128) != 0 ? ccpaConsentStatus7.rejectedVendors : null, (r32 & 256) != 0 ? ccpaConsentStatus7.signedLspa : null, (r32 & 512) != 0 ? ccpaConsentStatus7.uspstring : null, (r32 & 1024) != 0 ? ccpaConsentStatus7.status : null, (r32 & 2048) != 0 ? ccpaConsentStatus7.gppData : null, (r32 & 4096) != 0 ? ccpaConsentStatus7.uuid : null, (r32 & 8192) != 0 ? ccpaConsentStatus7.webConsentPayload : null, (r32 & 16384) != 0 ? ccpaConsentStatus7.expirationDate : null);
                            }
                            consentManagerUtils = this.consentManagerUtils;
                            SPConsents responseConsentHandler$cmplibrary_release2 = companion3.responseConsentHandler$cmplibrary_release(ccpaCS2, consentManagerUtils);
                            Function1<SPConsents, Unit> function13 = onSpConsentsSuccess;
                            if (function13 != null) {
                                function13.invoke(responseConsentHandler$cmplibrary_release2);
                            }
                        }
                        campaignManager4 = this.campaignManager;
                        ccpaConsentStatus = campaignManager4.getCcpaConsentStatus();
                        if (ccpaConsentStatus == null) {
                            return ccpaConsentStatus;
                        }
                        throw new InvalidConsentResponse(null, "The CCPA consent object cannot be null!!!", false, 4, null);
                    }
                }
                z = true;
                networkClient = this.networkClient;
                Env env22 = env;
                ActionType actionType2 = ConsentActionImpl.this.getActionType();
                dataStorage = this.dataStorage;
                double ccpaSampleRate2 = dataStorage.getCcpaSampleRate();
                long j32 = this.getSpConfig().propertyId;
                campaignManager = this.campaignManager;
                MessageMetaData ccpaMessageMetaData2 = campaignManager.getCcpaMessageMetaData();
                if (ccpaMessageMetaData2 != null) {
                }
                JsonObject saveAndExitVariablesOptimized2 = ConsentActionImpl.this.getSaveAndExitVariablesOptimized();
                String authId2 = this.getAuthId();
                campaignManager2 = this.campaignManager;
                CcpaCS ccpaConsentStatus52 = campaignManager2.getCcpaConsentStatus();
                if (ccpaConsentStatus52 == null) {
                }
                dataStorage2 = this.dataStorage;
                Boolean ccpaSampled2 = dataStorage2.getCcpaSampled();
                JsonObject jsonObject2 = JSONObjectExtKt.toJsonObject(ConsentActionImpl.this.getPubData());
                campaignManager3 = this.campaignManager;
                storeCcpaChoice = networkClient.storeCcpaChoice(new PostChoiceParamReq(env22, actionType2, PostChoiceApiModelExtKt.postChoiceCcpaBody(ccpaSampleRate2, j32, valueOf, ccpaSampled2, jsonObject2, saveAndExitVariablesOptimized2, authId2, uuid2, IncludeDataKt.buildIncludeData(SpConfigExtKt.getGppCustomOption(campaignManager3.getSpConfig())))));
                ServiceImpl serviceImpl32 = this;
                z2 = storeCcpaChoice instanceof Either.Right;
                if (!z2) {
                }
                ServiceImpl serviceImpl42 = this;
                if (!z2) {
                    t = ((Either.Left) storeCcpaChoice).getT();
                    if ((!(t instanceof ConsentLibExceptionK) ? (ConsentLibExceptionK) t : null) != null) {
                    }
                }
                if (z) {
                }
                campaignManager4 = this.campaignManager;
                ccpaConsentStatus = campaignManager4.getCcpaConsentStatus();
                if (ccpaConsentStatus == null) {
                }
            }
        });
    }

    private final Either<USNatConsentData> sendConsentUsNat(final Env env, final ConsentActionImpl consentAction, final Function1<? super SPConsents, Unit> onSpConsentSuccess) {
        return FunctionalUtilsKt.check(new Function0<USNatConsentData>() { // from class: com.sourcepoint.cmplibrary.data.ServiceImpl$sendConsentUsNat$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Removed duplicated region for block: B:63:0x0222  */
            /* JADX WARN: Removed duplicated region for block: B:71:0x0273  */
            /* JADX WARN: Removed duplicated region for block: B:78:0x0298  */
            /* JADX WARN: Removed duplicated region for block: B:80:0x029f  */
            /* JADX WARN: Removed duplicated region for block: B:81:0x029c  */
            /* JADX WARN: Removed duplicated region for block: B:83:0x02aa  */
            /* JADX WARN: Removed duplicated region for block: B:91:0x02f9 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:93:0x02fa  */
            /* JADX WARN: Removed duplicated region for block: B:95:0x0284  */
            /* JADX WARN: Removed duplicated region for block: B:97:0x0229  */
            @Override // kotlin.jvm.functions.Function0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final USNatConsentData invoke() {
                ChoiceResp choiceResp;
                boolean z;
                NetworkClient networkClient;
                CampaignManager campaignManager;
                CampaignManager campaignManager2;
                DataStorage dataStorage;
                DataStorage dataStorage2;
                CampaignManager campaignManager3;
                CampaignManager campaignManager4;
                CampaignManager campaignManager5;
                CampaignManager campaignManager6;
                Either<USNatConsentData> storeUsNatChoice;
                boolean z2;
                CampaignManager campaignManager7;
                USNatConsentData usNatConsentData;
                CampaignManager campaignManager8;
                ConsentManagerUtils consentManagerUtils;
                DataStorage dataStorage3;
                Throwable t;
                Logger logger;
                CampaignManager campaignManager9;
                MetaDataResp.USNat usNat;
                MessageMetaData messageMetaData;
                Integer messageId;
                USNatConsentStatus consentStatus;
                NetworkClient networkClient2;
                CampaignManager campaignManager10;
                CampaignManager campaignManager11;
                Object obj;
                CampaignManager campaignManager12;
                USNatConsentData uSNatConsentData;
                ConsentManagerUtils consentManagerUtils2;
                DataStorage dataStorage4;
                Logger logger2;
                CampaignManager campaignManager13;
                CampaignManager campaignManager14;
                CampaignManager campaignManager15;
                DataStorage dataStorage5;
                ConsentManagerUtils consentManagerUtils3;
                MetaDataArg metaDataArg;
                USNatConsentData uSNatConsentData2 = null;
                if (ActionTypeExtKt.isAcceptOrRejectAll(ConsentActionImpl.this.getActionType())) {
                    networkClient2 = this.networkClient;
                    ChoiceTypeParam choiceTypeParam = ConsentActionImplKt.toChoiceTypeParam(ConsentActionImpl.this.getActionType());
                    long j = this.getSpConfig().accountId;
                    long j2 = this.getSpConfig().propertyId;
                    campaignManager10 = this.campaignManager;
                    MetaDataResp metaDataResp = campaignManager10.getMetaDataResp();
                    MetaDataArg copy$default = (metaDataResp == null || (metaDataArg = MetaDataApiModelKt.toMetaDataArg(metaDataResp)) == null) ? null : MetaDataArg.copy$default(metaDataArg, null, null, null, 4, null);
                    campaignManager11 = this.campaignManager;
                    Either<ChoiceResp> choice = networkClient2.getChoice(new GetChoiceParamReq(env, choiceTypeParam, copy$default, j2, j, IncludeDataKt.buildIncludeData(SpConfigExtKt.getGppCustomOption(campaignManager11.getSpConfig())), false, false, false, 448, (DefaultConstructorMarker) null));
                    ServiceImpl serviceImpl = this;
                    Function1<SPConsents, Unit> function1 = onSpConsentSuccess;
                    boolean z3 = choice instanceof Either.Right;
                    if (z3) {
                        USNatConsentData usNat2 = ((ChoiceResp) ((Either.Right) choice).getR()).getUsNat();
                        if (usNat2 != null) {
                            campaignManager13 = serviceImpl.campaignManager;
                            campaignManager14 = serviceImpl.campaignManager;
                            USNatConsentData usNatConsentData2 = campaignManager14.getUsNatConsentData();
                            campaignManager13.setUsNatConsentData(USNatConsentData.copy$default(usNat2, null, null, null, null, usNatConsentData2 != null ? usNatConsentData2.getUuid() : null, null, null, null, null, null, null, null, null, 8175, null));
                            if (function1 != null) {
                                ConsentManager.Companion companion = ConsentManager.INSTANCE;
                                campaignManager15 = serviceImpl.campaignManager;
                                USNatConsentData usNatConsentData3 = campaignManager15.getUsNatConsentData();
                                String uuid = usNatConsentData3 != null ? usNatConsentData3.getUuid() : null;
                                dataStorage5 = serviceImpl.dataStorage;
                                USNatConsentData copy$default2 = USNatConsentData.copy$default(usNat2, Boolean.valueOf(dataStorage5.getUsNatApplies()), null, null, null, uuid, null, null, null, null, null, null, null, null, 8174, null);
                                consentManagerUtils3 = serviceImpl.consentManagerUtils;
                                function1.invoke(companion.responseConsentHandler$cmplibrary_release(copy$default2, consentManagerUtils3));
                            }
                        }
                    } else {
                        boolean z4 = choice instanceof Either.Left;
                    }
                    ServiceImpl serviceImpl2 = this;
                    Function1<SPConsents, Unit> function12 = onSpConsentSuccess;
                    if (!z3 && (choice instanceof Either.Left)) {
                        Throwable t2 = ((Either.Left) choice).getT();
                        if ((t2 instanceof ConsentLibExceptionK ? (ConsentLibExceptionK) t2 : null) != null) {
                            logger2 = serviceImpl2.logger;
                            logger2.error((RuntimeException) t2);
                        }
                        ConsentManager.Companion companion2 = ConsentManager.INSTANCE;
                        campaignManager12 = serviceImpl2.campaignManager;
                        USNatConsentData usNatConsentData4 = campaignManager12.getUsNatConsentData();
                        if (usNatConsentData4 != null) {
                            dataStorage4 = serviceImpl2.dataStorage;
                            uSNatConsentData = USNatConsentData.copy$default(usNatConsentData4, Boolean.valueOf(dataStorage4.getUsNatApplies()), null, null, null, null, null, null, null, null, null, null, null, null, 8190, null);
                        } else {
                            uSNatConsentData = null;
                        }
                        consentManagerUtils2 = serviceImpl2.consentManagerUtils;
                        SPConsents responseConsentHandler$cmplibrary_release = companion2.responseConsentHandler$cmplibrary_release(uSNatConsentData, consentManagerUtils2);
                        if (function12 != null) {
                            function12.invoke(responseConsentHandler$cmplibrary_release);
                        }
                    }
                    if (z3) {
                        obj = ((Either.Right) choice).getR();
                    } else {
                        if (!(choice instanceof Either.Left)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        obj = null;
                    }
                    choiceResp = (ChoiceResp) obj;
                } else {
                    choiceResp = null;
                }
                if (ActionTypeExtKt.isAcceptOrRejectAll(ConsentActionImpl.this.getActionType())) {
                    if ((choiceResp != null ? choiceResp.getUsNat() : null) != null) {
                        z = false;
                        networkClient = this.networkClient;
                        Env env2 = env;
                        ActionType actionType = ConsentActionImpl.this.getActionType();
                        campaignManager = this.campaignManager;
                        USNatConsentData usNatConsentData5 = campaignManager.getUsNatConsentData();
                        USNatConsentStatus.USNatGranularStatus granularStatus = (usNatConsentData5 != null || (consentStatus = usNatConsentData5.getConsentStatus()) == null) ? null : consentStatus.getGranularStatus();
                        campaignManager2 = this.campaignManager;
                        USNatConsentData usNatConsentData6 = campaignManager2.getUsNatConsentData();
                        Long valueOf = (usNatConsentData6 != null || (messageMetaData = usNatConsentData6.getMessageMetaData()) == null || (messageId = messageMetaData.getMessageId()) == null) ? null : Long.valueOf(messageId.intValue());
                        JsonObject saveAndExitVariablesOptimized = ConsentActionImpl.this.getSaveAndExitVariablesOptimized();
                        long j3 = this.getSpConfig().propertyId;
                        JsonObject jsonObject = JSONObjectExtKt.toJsonObject(ConsentActionImpl.this.getPubData());
                        dataStorage = this.dataStorage;
                        Boolean usnatSampled = dataStorage.getUsnatSampled();
                        dataStorage2 = this.dataStorage;
                        double usnatSampleRate = dataStorage2.getUsnatSampleRate();
                        campaignManager3 = this.campaignManager;
                        USNatConsentData usNatConsentData7 = campaignManager3.getUsNatConsentData();
                        String uuid2 = usNatConsentData7 == null ? usNatConsentData7.getUuid() : null;
                        campaignManager4 = this.campaignManager;
                        MetaDataResp metaDataResp2 = campaignManager4.getMetaDataResp();
                        String vendorListId = (metaDataResp2 != null || (usNat = metaDataResp2.getUsNat()) == null) ? null : usNat.getVendorListId();
                        campaignManager5 = this.campaignManager;
                        JsonObject buildIncludeData = IncludeDataKt.buildIncludeData(SpConfigExtKt.getGppCustomOption(campaignManager5.getSpConfig()));
                        campaignManager6 = this.campaignManager;
                        storeUsNatChoice = networkClient.storeUsNatChoice(new PostChoiceParamReq(env2, actionType, PostChoiceApiModelExtKt.postChoiceUsNatBody(granularStatus, valueOf, saveAndExitVariablesOptimized, j3, jsonObject, usnatSampled, usnatSampleRate, uuid2, vendorListId, buildIncludeData, campaignManager6.getAuthId())));
                        ServiceImpl serviceImpl3 = this;
                        z2 = storeUsNatChoice instanceof Either.Right;
                        if (!z2) {
                            USNatConsentData uSNatConsentData3 = (USNatConsentData) ((Either.Right) storeUsNatChoice).getR();
                            campaignManager9 = serviceImpl3.campaignManager;
                            campaignManager9.setUsNatConsentData(uSNatConsentData3);
                        } else {
                            boolean z5 = storeUsNatChoice instanceof Either.Left;
                        }
                        ServiceImpl serviceImpl4 = this;
                        if (!z2 && (storeUsNatChoice instanceof Either.Left)) {
                            t = ((Either.Left) storeUsNatChoice).getT();
                            if ((!(t instanceof ConsentLibExceptionK) ? (ConsentLibExceptionK) t : null) != null) {
                                logger = serviceImpl4.logger;
                                logger.error((RuntimeException) t);
                            }
                        }
                        if (z) {
                            ConsentManager.Companion companion3 = ConsentManager.INSTANCE;
                            campaignManager8 = this.campaignManager;
                            USNatConsentData usNatConsentData8 = campaignManager8.getUsNatConsentData();
                            if (usNatConsentData8 != null) {
                                dataStorage3 = this.dataStorage;
                                uSNatConsentData2 = USNatConsentData.copy$default(usNatConsentData8, Boolean.valueOf(dataStorage3.getUsNatApplies()), null, null, null, null, null, null, null, null, null, null, null, null, 8190, null);
                            }
                            consentManagerUtils = this.consentManagerUtils;
                            SPConsents responseConsentHandler$cmplibrary_release2 = companion3.responseConsentHandler$cmplibrary_release(uSNatConsentData2, consentManagerUtils);
                            Function1<SPConsents, Unit> function13 = onSpConsentSuccess;
                            if (function13 != null) {
                                function13.invoke(responseConsentHandler$cmplibrary_release2);
                            }
                        }
                        campaignManager7 = this.campaignManager;
                        usNatConsentData = campaignManager7.getUsNatConsentData();
                        if (usNatConsentData == null) {
                            return usNatConsentData;
                        }
                        throw new InvalidConsentResponse(null, "The UsNat consent data cannot be null!!!", false, 4, null);
                    }
                }
                z = true;
                networkClient = this.networkClient;
                Env env22 = env;
                ActionType actionType2 = ConsentActionImpl.this.getActionType();
                campaignManager = this.campaignManager;
                USNatConsentData usNatConsentData52 = campaignManager.getUsNatConsentData();
                if (usNatConsentData52 != null) {
                }
                campaignManager2 = this.campaignManager;
                USNatConsentData usNatConsentData62 = campaignManager2.getUsNatConsentData();
                if (usNatConsentData62 != null) {
                }
                JsonObject saveAndExitVariablesOptimized2 = ConsentActionImpl.this.getSaveAndExitVariablesOptimized();
                long j32 = this.getSpConfig().propertyId;
                JsonObject jsonObject2 = JSONObjectExtKt.toJsonObject(ConsentActionImpl.this.getPubData());
                dataStorage = this.dataStorage;
                Boolean usnatSampled2 = dataStorage.getUsnatSampled();
                dataStorage2 = this.dataStorage;
                double usnatSampleRate2 = dataStorage2.getUsnatSampleRate();
                campaignManager3 = this.campaignManager;
                USNatConsentData usNatConsentData72 = campaignManager3.getUsNatConsentData();
                if (usNatConsentData72 == null) {
                }
                campaignManager4 = this.campaignManager;
                MetaDataResp metaDataResp22 = campaignManager4.getMetaDataResp();
                if (metaDataResp22 != null) {
                }
                campaignManager5 = this.campaignManager;
                JsonObject buildIncludeData2 = IncludeDataKt.buildIncludeData(SpConfigExtKt.getGppCustomOption(campaignManager5.getSpConfig()));
                campaignManager6 = this.campaignManager;
                storeUsNatChoice = networkClient.storeUsNatChoice(new PostChoiceParamReq(env22, actionType2, PostChoiceApiModelExtKt.postChoiceUsNatBody(granularStatus, valueOf, saveAndExitVariablesOptimized2, j32, jsonObject2, usnatSampled2, usnatSampleRate2, uuid2, vendorListId, buildIncludeData2, campaignManager6.getAuthId())));
                ServiceImpl serviceImpl32 = this;
                z2 = storeUsNatChoice instanceof Either.Right;
                if (!z2) {
                }
                ServiceImpl serviceImpl42 = this;
                if (!z2) {
                    t = ((Either.Left) storeUsNatChoice).getT();
                    if ((!(t instanceof ConsentLibExceptionK) ? (ConsentLibExceptionK) t : null) != null) {
                    }
                }
                if (z) {
                }
                campaignManager7 = this.campaignManager;
                usNatConsentData = campaignManager7.getUsNatConsentData();
                if (usNatConsentData == null) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Either<ConsentStatusResp> triggerConsentStatus(MessagesParamReq messageReq, Boolean gdprApplies, Boolean ccpaApplies, Boolean usNatApplies) {
        String expirationDate;
        String expirationDate2;
        Either<ConsentStatusResp> consentStatus = getConsentStatus(MessagesApiModelExtKt.toConsentStatusParamReq(messageReq, this.campaignManager));
        if (consentStatus instanceof Either.Right) {
            ConsentStatusResp consentStatusResp = (ConsentStatusResp) ((Either.Right) consentStatus).getR();
            CampaignManager campaignManager = this.campaignManager;
            campaignManager.handleOldLocalData();
            campaignManager.setMessagesOptimizedLocalState(consentStatusResp.getLocalState());
            ConsentStatusResp.ConsentStatusData consentStatusData = consentStatusResp.getConsentStatusData();
            if (consentStatusData != null) {
                if (SpConfigExtKt.isIncluded(campaignManager.getSpConfig(), CampaignType.GDPR)) {
                    GdprCS gdpr = consentStatusData.getGdpr();
                    campaignManager.setGdprConsentStatus(gdpr != null ? GdprCS.copy$default(gdpr, gdprApplies, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16777214, null) : null);
                    GdprCS gdpr2 = consentStatusData.getGdpr();
                    campaignManager.setGdprUuid(gdpr2 != null ? gdpr2.getUuid() : null);
                    GdprCS gdpr3 = consentStatusData.getGdpr();
                    campaignManager.setGdprDateCreated(gdpr3 != null ? gdpr3.getDateCreated() : null);
                    GdprCS gdpr4 = consentStatusData.getGdpr();
                    if (gdpr4 != null && (expirationDate2 = gdpr4.getExpirationDate()) != null) {
                        this.dataStorage.setGdprExpirationDate(expirationDate2);
                    }
                }
                if (SpConfigExtKt.isIncluded(campaignManager.getSpConfig(), CampaignType.CCPA)) {
                    CcpaCS ccpa = consentStatusData.getCcpa();
                    campaignManager.setCcpaConsentStatus(ccpa != null ? ccpa.copy((r32 & 1) != 0 ? ccpa.applies : ccpaApplies, (r32 & 2) != 0 ? ccpa.consentedAll : null, (r32 & 4) != 0 ? ccpa.dateCreated : null, (r32 & 8) != 0 ? ccpa.gpcEnabled : null, (r32 & 16) != 0 ? ccpa.newUser : null, (r32 & 32) != 0 ? ccpa.rejectedAll : null, (r32 & 64) != 0 ? ccpa.rejectedCategories : null, (r32 & 128) != 0 ? ccpa.rejectedVendors : null, (r32 & 256) != 0 ? ccpa.signedLspa : null, (r32 & 512) != 0 ? ccpa.uspstring : null, (r32 & 1024) != 0 ? ccpa.status : null, (r32 & 2048) != 0 ? ccpa.gppData : null, (r32 & 4096) != 0 ? ccpa.uuid : null, (r32 & 8192) != 0 ? ccpa.webConsentPayload : null, (r32 & 16384) != 0 ? ccpa.expirationDate : null) : null);
                    CcpaCS ccpa2 = consentStatusData.getCcpa();
                    campaignManager.setCcpaUuid(ccpa2 != null ? ccpa2.getUuid() : null);
                    CcpaCS ccpa3 = consentStatusData.getCcpa();
                    campaignManager.setCcpaDateCreated(ccpa3 != null ? ccpa3.getDateCreated() : null);
                    CcpaCS ccpa4 = consentStatusData.getCcpa();
                    if (ccpa4 != null && (expirationDate = ccpa4.getExpirationDate()) != null) {
                        this.dataStorage.setCcpaExpirationDate(expirationDate);
                    }
                }
                if (SpConfigExtKt.isIncluded(campaignManager.getSpConfig(), CampaignType.USNAT)) {
                    USNatConsentData usnat = consentStatusData.getUsnat();
                    campaignManager.setUsNatConsentData(usnat != null ? USNatConsentData.copy$default(usnat, usNatApplies, null, null, null, null, null, null, null, null, null, null, null, null, 8190, null) : null);
                }
            }
            return consentStatus;
        }
        boolean z = consentStatus instanceof Either.Left;
        return consentStatus;
    }
}
