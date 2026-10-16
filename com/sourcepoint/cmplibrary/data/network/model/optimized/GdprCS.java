package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.sourcepoint.cmplibrary.data.network.converter.GrantsSerializer;
import com.sourcepoint.cmplibrary.data.network.converter.JsonMapSerializer;
import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatus;
import com.sourcepoint.cmplibrary.model.exposed.GDPRPurposeGrants;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* compiled from: ConsentStatusApiModel.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bb\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 \u0093\u00012\u00020\u0001:\b\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001Bí\u0002\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0001\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0001\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\u0016\b\u0001\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b\u0012\u0016\b\u0001\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001b\u0012\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010#\u0012\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010%\u001a\u0004\u0018\u00010&\u0012\b\u0010'\u001a\u0004\u0018\u00010(¢\u0006\u0002\u0010)B\u00ad\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b\u0012\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010 \u001a\u0004\u0018\u00010\b\u0012\b\u0010!\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\b\u0010$\u001a\u0004\u0018\u00010\b\u0012\b\u0010%\u001a\u0004\u0018\u00010&¢\u0006\u0002\u0010*J\u0010\u0010l\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00103J\u0011\u0010m\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0010\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010AJ\u000b\u0010q\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0017\u0010t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bHÆ\u0003J\u0017\u0010u\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001bHÆ\u0003J\u0010\u0010v\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00103J\u0011\u0010w\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010#HÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010&HÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010~\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00103J\u0011\u0010\u007f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0012\u0010\u0080\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0011\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00103J\u0012\u0010\u0083\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003Jæ\u0002\u0010\u0084\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&HÆ\u0001¢\u0006\u0003\u0010\u0085\u0001J\u0015\u0010\u0086\u0001\u001a\u00020\u00052\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010\u0089\u0001\u001a\u00020\bHÖ\u0001J.\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u008c\u0001\u001a\u00020\u00002\b\u0010\u008d\u0001\u001a\u00030\u008e\u00012\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001HÁ\u0001¢\u0006\u0003\b\u0091\u0001R*\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010,\u001a\u0004\b0\u00101R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00104\u001a\u0004\b2\u00103R$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010,\u001a\u0004\b6\u00107R\u001e\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b8\u0010,\u001a\u0004\b9\u00101R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010,\u001a\u0004\b;\u0010<R \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00104\u0012\u0004\b=\u0010,\u001a\u0004\b>\u00103R \u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010B\u0012\u0004\b?\u0010,\u001a\u0004\b@\u0010AR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bC\u0010,\u001a\u0004\bD\u0010ER\u001e\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bF\u0010,\u001a\u0004\bG\u00101R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bH\u0010,\u001a\u0004\bI\u00101R&\u0010$\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bJ\u0010,\u001a\u0004\bK\u00101\"\u0004\bL\u0010MR&\u0010%\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bN\u0010,\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR*\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bS\u0010,\u001a\u0004\bT\u0010.R$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bU\u0010,\u001a\u0004\bV\u00107R$\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bW\u0010,\u001a\u0004\bX\u00107R \u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00104\u0012\u0004\bY\u0010,\u001a\u0004\bZ\u00103R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b[\u0010,\u001a\u0004\b\\\u0010]R \u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00104\u0012\u0004\b^\u0010,\u001a\u0004\b_\u00103R$\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b`\u0010,\u001a\u0004\ba\u00107R&\u0010 \u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bb\u0010,\u001a\u0004\bc\u00101\"\u0004\bd\u0010MR\u001e\u0010!\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\be\u0010,\u001a\u0004\bf\u00101R$\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bg\u0010,\u001a\u0004\bh\u00107R\u001e\u0010\"\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bi\u0010,\u001a\u0004\bj\u0010k¨\u0006\u0096\u0001"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", "", "seen1", "", "applies", "", "categories", "", "", "consentAllRef", "consentedToAll", "legIntCategories", "legIntVendors", "postPayload", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$PostPayload;", "rejectedAny", "specialFeatures", "vendors", "addtlConsent", "consentStatus", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus;", "cookieExpirationDays", "customVendorsResponse", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse;", "dateCreated", "euconsent", "grants", "", "Lcom/sourcepoint/cmplibrary/model/exposed/GDPRPurposeGrants;", "TCData", "Lkotlinx/serialization/json/JsonElement;", "localDataCurrent", "uuid", "vendorListId", "webConsentPayload", "Lkotlinx/serialization/json/JsonObject;", "expirationDate", "googleConsentMode", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$PostPayload;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus;Ljava/lang/Integer;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$PostPayload;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus;Ljava/lang/Integer;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode;)V", "getTCData$annotations", "()V", "getTCData", "()Ljava/util/Map;", "getAddtlConsent$annotations", "getAddtlConsent", "()Ljava/lang/String;", "getApplies", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCategories$annotations", "getCategories", "()Ljava/util/List;", "getConsentAllRef$annotations", "getConsentAllRef", "getConsentStatus$annotations", "getConsentStatus", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus;", "getConsentedToAll$annotations", "getConsentedToAll", "getCookieExpirationDays$annotations", "getCookieExpirationDays", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCustomVendorsResponse$annotations", "getCustomVendorsResponse", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse;", "getDateCreated$annotations", "getDateCreated", "getEuconsent$annotations", "getEuconsent", "getExpirationDate$annotations", "getExpirationDate", "setExpirationDate", "(Ljava/lang/String;)V", "getGoogleConsentMode$annotations", "getGoogleConsentMode", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode;", "setGoogleConsentMode", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode;)V", "getGrants$annotations", "getGrants", "getLegIntCategories$annotations", "getLegIntCategories", "getLegIntVendors$annotations", "getLegIntVendors", "getLocalDataCurrent$annotations", "getLocalDataCurrent", "getPostPayload$annotations", "getPostPayload", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$PostPayload;", "getRejectedAny$annotations", "getRejectedAny", "getSpecialFeatures$annotations", "getSpecialFeatures", "getUuid$annotations", "getUuid", "setUuid", "getVendorListId$annotations", "getVendorListId", "getVendors$annotations", "getVendors", "getWebConsentPayload$annotations", "getWebConsentPayload", "()Lkotlinx/serialization/json/JsonObject;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$PostPayload;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus;Ljava/lang/Integer;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode;)Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "CustomVendorsResponse", "PostPayload", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class GdprCS {
    private final Map<String, JsonElement> TCData;
    private final String addtlConsent;
    private final Boolean applies;
    private final List<String> categories;
    private final String consentAllRef;
    private final ConsentStatus consentStatus;
    private final Boolean consentedToAll;
    private final Integer cookieExpirationDays;
    private final CustomVendorsResponse customVendorsResponse;
    private final String dateCreated;
    private final String euconsent;
    private String expirationDate;
    private GoogleConsentMode googleConsentMode;
    private final Map<String, GDPRPurposeGrants> grants;
    private final List<String> legIntCategories;
    private final List<String> legIntVendors;
    private final Boolean localDataCurrent;
    private final PostPayload postPayload;
    private final Boolean rejectedAny;
    private final List<String> specialFeatures;
    private String uuid;
    private final String vendorListId;
    private final List<String> vendors;
    private final JsonObject webConsentPayload;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(StringSerializer.INSTANCE), null, null, new ArrayListSerializer(StringSerializer.INSTANCE), new ArrayListSerializer(StringSerializer.INSTANCE), null, null, new ArrayListSerializer(StringSerializer.INSTANCE), new ArrayListSerializer(StringSerializer.INSTANCE), null, null, null, null, null, null, null, null, null, null, null, null, null, null};

    public static /* synthetic */ GdprCS copy$default(GdprCS gdprCS, Boolean bool, List list, String str, Boolean bool2, List list2, List list3, PostPayload postPayload, Boolean bool3, List list4, List list5, String str2, ConsentStatus consentStatus, Integer num, CustomVendorsResponse customVendorsResponse, String str3, String str4, Map map, Map map2, Boolean bool4, String str5, String str6, JsonObject jsonObject, String str7, GoogleConsentMode googleConsentMode, int i, Object obj) {
        GoogleConsentMode googleConsentMode2;
        String str8;
        Boolean bool5 = (i & 1) != 0 ? gdprCS.applies : bool;
        List list6 = (i & 2) != 0 ? gdprCS.categories : list;
        String str9 = (i & 4) != 0 ? gdprCS.consentAllRef : str;
        Boolean bool6 = (i & 8) != 0 ? gdprCS.consentedToAll : bool2;
        List list7 = (i & 16) != 0 ? gdprCS.legIntCategories : list2;
        List list8 = (i & 32) != 0 ? gdprCS.legIntVendors : list3;
        PostPayload postPayload2 = (i & 64) != 0 ? gdprCS.postPayload : postPayload;
        Boolean bool7 = (i & 128) != 0 ? gdprCS.rejectedAny : bool3;
        List list9 = (i & 256) != 0 ? gdprCS.specialFeatures : list4;
        List list10 = (i & 512) != 0 ? gdprCS.vendors : list5;
        String str10 = (i & 1024) != 0 ? gdprCS.addtlConsent : str2;
        ConsentStatus consentStatus2 = (i & 2048) != 0 ? gdprCS.consentStatus : consentStatus;
        Integer num2 = (i & 4096) != 0 ? gdprCS.cookieExpirationDays : num;
        CustomVendorsResponse customVendorsResponse2 = (i & 8192) != 0 ? gdprCS.customVendorsResponse : customVendorsResponse;
        Boolean bool8 = bool5;
        String str11 = (i & 16384) != 0 ? gdprCS.dateCreated : str3;
        String str12 = (i & 32768) != 0 ? gdprCS.euconsent : str4;
        Map map3 = (i & 65536) != 0 ? gdprCS.grants : map;
        Map map4 = (i & 131072) != 0 ? gdprCS.TCData : map2;
        Boolean bool9 = (i & 262144) != 0 ? gdprCS.localDataCurrent : bool4;
        String str13 = (i & 524288) != 0 ? gdprCS.uuid : str5;
        String str14 = (i & 1048576) != 0 ? gdprCS.vendorListId : str6;
        JsonObject jsonObject2 = (i & 2097152) != 0 ? gdprCS.webConsentPayload : jsonObject;
        String str15 = (i & 4194304) != 0 ? gdprCS.expirationDate : str7;
        if ((i & 8388608) != 0) {
            str8 = str15;
            googleConsentMode2 = gdprCS.googleConsentMode;
        } else {
            googleConsentMode2 = googleConsentMode;
            str8 = str15;
        }
        return gdprCS.copy(bool8, list6, str9, bool6, list7, list8, postPayload2, bool7, list9, list10, str10, consentStatus2, num2, customVendorsResponse2, str11, str12, map3, map4, bool9, str13, str14, jsonObject2, str8, googleConsentMode2);
    }

    @SerialName("addtlConsent")
    public static /* synthetic */ void getAddtlConsent$annotations() {
    }

    @SerialName("categories")
    public static /* synthetic */ void getCategories$annotations() {
    }

    @SerialName("consentAllRef")
    public static /* synthetic */ void getConsentAllRef$annotations() {
    }

    @SerialName("consentStatus")
    public static /* synthetic */ void getConsentStatus$annotations() {
    }

    @SerialName("consentedToAll")
    public static /* synthetic */ void getConsentedToAll$annotations() {
    }

    @SerialName("cookieExpirationDays")
    public static /* synthetic */ void getCookieExpirationDays$annotations() {
    }

    @SerialName("customVendorsResponse")
    public static /* synthetic */ void getCustomVendorsResponse$annotations() {
    }

    @SerialName("dateCreated")
    public static /* synthetic */ void getDateCreated$annotations() {
    }

    @SerialName("euconsent")
    public static /* synthetic */ void getEuconsent$annotations() {
    }

    @SerialName("expirationDate")
    public static /* synthetic */ void getExpirationDate$annotations() {
    }

    @SerialName("gcmStatus")
    public static /* synthetic */ void getGoogleConsentMode$annotations() {
    }

    @Serializable(with = GrantsSerializer.class)
    public static /* synthetic */ void getGrants$annotations() {
    }

    @SerialName("legIntCategories")
    public static /* synthetic */ void getLegIntCategories$annotations() {
    }

    @SerialName("legIntVendors")
    public static /* synthetic */ void getLegIntVendors$annotations() {
    }

    @SerialName("localDataCurrent")
    public static /* synthetic */ void getLocalDataCurrent$annotations() {
    }

    @SerialName("postPayload")
    public static /* synthetic */ void getPostPayload$annotations() {
    }

    @SerialName("rejectedAny")
    public static /* synthetic */ void getRejectedAny$annotations() {
    }

    @SerialName("specialFeatures")
    public static /* synthetic */ void getSpecialFeatures$annotations() {
    }

    @Serializable(with = JsonMapSerializer.class)
    public static /* synthetic */ void getTCData$annotations() {
    }

    @SerialName("uuid")
    public static /* synthetic */ void getUuid$annotations() {
    }

    @SerialName("vendorListId")
    public static /* synthetic */ void getVendorListId$annotations() {
    }

    @SerialName("vendors")
    public static /* synthetic */ void getVendors$annotations() {
    }

    @SerialName("webConsentPayload")
    public static /* synthetic */ void getWebConsentPayload$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getApplies() {
        return this.applies;
    }

    public final List<String> component10() {
        return this.vendors;
    }

    /* renamed from: component11, reason: from getter */
    public final String getAddtlConsent() {
        return this.addtlConsent;
    }

    /* renamed from: component12, reason: from getter */
    public final ConsentStatus getConsentStatus() {
        return this.consentStatus;
    }

    /* renamed from: component13, reason: from getter */
    public final Integer getCookieExpirationDays() {
        return this.cookieExpirationDays;
    }

    /* renamed from: component14, reason: from getter */
    public final CustomVendorsResponse getCustomVendorsResponse() {
        return this.customVendorsResponse;
    }

    /* renamed from: component15, reason: from getter */
    public final String getDateCreated() {
        return this.dateCreated;
    }

    /* renamed from: component16, reason: from getter */
    public final String getEuconsent() {
        return this.euconsent;
    }

    public final Map<String, GDPRPurposeGrants> component17() {
        return this.grants;
    }

    public final Map<String, JsonElement> component18() {
        return this.TCData;
    }

    /* renamed from: component19, reason: from getter */
    public final Boolean getLocalDataCurrent() {
        return this.localDataCurrent;
    }

    public final List<String> component2() {
        return this.categories;
    }

    /* renamed from: component20, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* renamed from: component21, reason: from getter */
    public final String getVendorListId() {
        return this.vendorListId;
    }

    /* renamed from: component22, reason: from getter */
    public final JsonObject getWebConsentPayload() {
        return this.webConsentPayload;
    }

    /* renamed from: component23, reason: from getter */
    public final String getExpirationDate() {
        return this.expirationDate;
    }

    /* renamed from: component24, reason: from getter */
    public final GoogleConsentMode getGoogleConsentMode() {
        return this.googleConsentMode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getConsentAllRef() {
        return this.consentAllRef;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getConsentedToAll() {
        return this.consentedToAll;
    }

    public final List<String> component5() {
        return this.legIntCategories;
    }

    public final List<String> component6() {
        return this.legIntVendors;
    }

    /* renamed from: component7, reason: from getter */
    public final PostPayload getPostPayload() {
        return this.postPayload;
    }

    /* renamed from: component8, reason: from getter */
    public final Boolean getRejectedAny() {
        return this.rejectedAny;
    }

    public final List<String> component9() {
        return this.specialFeatures;
    }

    public final GdprCS copy(Boolean applies, List<String> categories, String consentAllRef, Boolean consentedToAll, List<String> legIntCategories, List<String> legIntVendors, PostPayload postPayload, Boolean rejectedAny, List<String> specialFeatures, List<String> vendors, String addtlConsent, ConsentStatus consentStatus, Integer cookieExpirationDays, CustomVendorsResponse customVendorsResponse, String dateCreated, String euconsent, Map<String, GDPRPurposeGrants> grants, Map<String, ? extends JsonElement> TCData, Boolean localDataCurrent, String uuid, String vendorListId, JsonObject webConsentPayload, String expirationDate, GoogleConsentMode googleConsentMode) {
        return new GdprCS(applies, categories, consentAllRef, consentedToAll, legIntCategories, legIntVendors, postPayload, rejectedAny, specialFeatures, vendors, addtlConsent, consentStatus, cookieExpirationDays, customVendorsResponse, dateCreated, euconsent, grants, TCData, localDataCurrent, uuid, vendorListId, webConsentPayload, expirationDate, googleConsentMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GdprCS)) {
            return false;
        }
        GdprCS gdprCS = (GdprCS) other;
        return Intrinsics.areEqual(this.applies, gdprCS.applies) && Intrinsics.areEqual(this.categories, gdprCS.categories) && Intrinsics.areEqual(this.consentAllRef, gdprCS.consentAllRef) && Intrinsics.areEqual(this.consentedToAll, gdprCS.consentedToAll) && Intrinsics.areEqual(this.legIntCategories, gdprCS.legIntCategories) && Intrinsics.areEqual(this.legIntVendors, gdprCS.legIntVendors) && Intrinsics.areEqual(this.postPayload, gdprCS.postPayload) && Intrinsics.areEqual(this.rejectedAny, gdprCS.rejectedAny) && Intrinsics.areEqual(this.specialFeatures, gdprCS.specialFeatures) && Intrinsics.areEqual(this.vendors, gdprCS.vendors) && Intrinsics.areEqual(this.addtlConsent, gdprCS.addtlConsent) && Intrinsics.areEqual(this.consentStatus, gdprCS.consentStatus) && Intrinsics.areEqual(this.cookieExpirationDays, gdprCS.cookieExpirationDays) && Intrinsics.areEqual(this.customVendorsResponse, gdprCS.customVendorsResponse) && Intrinsics.areEqual(this.dateCreated, gdprCS.dateCreated) && Intrinsics.areEqual(this.euconsent, gdprCS.euconsent) && Intrinsics.areEqual(this.grants, gdprCS.grants) && Intrinsics.areEqual(this.TCData, gdprCS.TCData) && Intrinsics.areEqual(this.localDataCurrent, gdprCS.localDataCurrent) && Intrinsics.areEqual(this.uuid, gdprCS.uuid) && Intrinsics.areEqual(this.vendorListId, gdprCS.vendorListId) && Intrinsics.areEqual(this.webConsentPayload, gdprCS.webConsentPayload) && Intrinsics.areEqual(this.expirationDate, gdprCS.expirationDate) && Intrinsics.areEqual(this.googleConsentMode, gdprCS.googleConsentMode);
    }

    public int hashCode() {
        Boolean bool = this.applies;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        List<String> list = this.categories;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.consentAllRef;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool2 = this.consentedToAll;
        int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        List<String> list2 = this.legIntCategories;
        int hashCode5 = (hashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<String> list3 = this.legIntVendors;
        int hashCode6 = (hashCode5 + (list3 == null ? 0 : list3.hashCode())) * 31;
        PostPayload postPayload = this.postPayload;
        int hashCode7 = (hashCode6 + (postPayload == null ? 0 : postPayload.hashCode())) * 31;
        Boolean bool3 = this.rejectedAny;
        int hashCode8 = (hashCode7 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        List<String> list4 = this.specialFeatures;
        int hashCode9 = (hashCode8 + (list4 == null ? 0 : list4.hashCode())) * 31;
        List<String> list5 = this.vendors;
        int hashCode10 = (hashCode9 + (list5 == null ? 0 : list5.hashCode())) * 31;
        String str2 = this.addtlConsent;
        int hashCode11 = (hashCode10 + (str2 == null ? 0 : str2.hashCode())) * 31;
        ConsentStatus consentStatus = this.consentStatus;
        int hashCode12 = (hashCode11 + (consentStatus == null ? 0 : consentStatus.hashCode())) * 31;
        Integer num = this.cookieExpirationDays;
        int hashCode13 = (hashCode12 + (num == null ? 0 : num.hashCode())) * 31;
        CustomVendorsResponse customVendorsResponse = this.customVendorsResponse;
        int hashCode14 = (hashCode13 + (customVendorsResponse == null ? 0 : customVendorsResponse.hashCode())) * 31;
        String str3 = this.dateCreated;
        int hashCode15 = (hashCode14 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.euconsent;
        int hashCode16 = (hashCode15 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Map<String, GDPRPurposeGrants> map = this.grants;
        int hashCode17 = (hashCode16 + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, JsonElement> map2 = this.TCData;
        int hashCode18 = (hashCode17 + (map2 == null ? 0 : map2.hashCode())) * 31;
        Boolean bool4 = this.localDataCurrent;
        int hashCode19 = (hashCode18 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        String str5 = this.uuid;
        int hashCode20 = (hashCode19 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.vendorListId;
        int hashCode21 = (hashCode20 + (str6 == null ? 0 : str6.hashCode())) * 31;
        JsonObject jsonObject = this.webConsentPayload;
        int hashCode22 = (hashCode21 + (jsonObject == null ? 0 : jsonObject.hashCode())) * 31;
        String str7 = this.expirationDate;
        int hashCode23 = (hashCode22 + (str7 == null ? 0 : str7.hashCode())) * 31;
        GoogleConsentMode googleConsentMode = this.googleConsentMode;
        return hashCode23 + (googleConsentMode != null ? googleConsentMode.hashCode() : 0);
    }

    public String toString() {
        return "GdprCS(applies=" + this.applies + ", categories=" + this.categories + ", consentAllRef=" + this.consentAllRef + ", consentedToAll=" + this.consentedToAll + ", legIntCategories=" + this.legIntCategories + ", legIntVendors=" + this.legIntVendors + ", postPayload=" + this.postPayload + ", rejectedAny=" + this.rejectedAny + ", specialFeatures=" + this.specialFeatures + ", vendors=" + this.vendors + ", addtlConsent=" + this.addtlConsent + ", consentStatus=" + this.consentStatus + ", cookieExpirationDays=" + this.cookieExpirationDays + ", customVendorsResponse=" + this.customVendorsResponse + ", dateCreated=" + this.dateCreated + ", euconsent=" + this.euconsent + ", grants=" + this.grants + ", TCData=" + this.TCData + ", localDataCurrent=" + this.localDataCurrent + ", uuid=" + this.uuid + ", vendorListId=" + this.vendorListId + ", webConsentPayload=" + this.webConsentPayload + ", expirationDate=" + this.expirationDate + ", googleConsentMode=" + this.googleConsentMode + ")";
    }

    /* compiled from: ConsentStatusApiModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<GdprCS> serializer() {
            return GdprCS$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ GdprCS(int i, Boolean bool, @SerialName("categories") List list, @SerialName("consentAllRef") String str, @SerialName("consentedToAll") Boolean bool2, @SerialName("legIntCategories") List list2, @SerialName("legIntVendors") List list3, @SerialName("postPayload") PostPayload postPayload, @SerialName("rejectedAny") Boolean bool3, @SerialName("specialFeatures") List list4, @SerialName("vendors") List list5, @SerialName("addtlConsent") String str2, @SerialName("consentStatus") ConsentStatus consentStatus, @SerialName("cookieExpirationDays") Integer num, @SerialName("customVendorsResponse") CustomVendorsResponse customVendorsResponse, @SerialName("dateCreated") String str3, @SerialName("euconsent") String str4, @Serializable(with = GrantsSerializer.class) Map map, @Serializable(with = JsonMapSerializer.class) Map map2, @SerialName("localDataCurrent") Boolean bool4, @SerialName("uuid") String str5, @SerialName("vendorListId") String str6, @SerialName("webConsentPayload") JsonObject jsonObject, @SerialName("expirationDate") String str7, @SerialName("gcmStatus") GoogleConsentMode googleConsentMode, SerializationConstructorMarker serializationConstructorMarker) {
        if (14680063 != (i & 14680063)) {
            PluginExceptionsKt.throwMissingFieldException(i, 14680063, GdprCS$$serializer.INSTANCE.getDescriptor());
        }
        this.applies = bool;
        this.categories = list;
        this.consentAllRef = str;
        this.consentedToAll = bool2;
        this.legIntCategories = list2;
        this.legIntVendors = list3;
        this.postPayload = postPayload;
        this.rejectedAny = bool3;
        this.specialFeatures = list4;
        this.vendors = list5;
        this.addtlConsent = str2;
        this.consentStatus = consentStatus;
        this.cookieExpirationDays = num;
        this.customVendorsResponse = customVendorsResponse;
        this.dateCreated = str3;
        this.euconsent = str4;
        this.grants = map;
        this.TCData = map2;
        this.localDataCurrent = bool4;
        this.uuid = str5;
        this.vendorListId = str6;
        this.webConsentPayload = (i & 2097152) == 0 ? null : jsonObject;
        this.expirationDate = str7;
        this.googleConsentMode = googleConsentMode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GdprCS(Boolean bool, List<String> list, String str, Boolean bool2, List<String> list2, List<String> list3, PostPayload postPayload, Boolean bool3, List<String> list4, List<String> list5, String str2, ConsentStatus consentStatus, Integer num, CustomVendorsResponse customVendorsResponse, String str3, String str4, Map<String, GDPRPurposeGrants> map, Map<String, ? extends JsonElement> map2, Boolean bool4, String str5, String str6, JsonObject jsonObject, String str7, GoogleConsentMode googleConsentMode) {
        this.applies = bool;
        this.categories = list;
        this.consentAllRef = str;
        this.consentedToAll = bool2;
        this.legIntCategories = list2;
        this.legIntVendors = list3;
        this.postPayload = postPayload;
        this.rejectedAny = bool3;
        this.specialFeatures = list4;
        this.vendors = list5;
        this.addtlConsent = str2;
        this.consentStatus = consentStatus;
        this.cookieExpirationDays = num;
        this.customVendorsResponse = customVendorsResponse;
        this.dateCreated = str3;
        this.euconsent = str4;
        this.grants = map;
        this.TCData = map2;
        this.localDataCurrent = bool4;
        this.uuid = str5;
        this.vendorListId = str6;
        this.webConsentPayload = jsonObject;
        this.expirationDate = str7;
        this.googleConsentMode = googleConsentMode;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(GdprCS self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.applies);
        output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.categories);
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.consentAllRef);
        output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.consentedToAll);
        output.encodeNullableSerializableElement(serialDesc, 4, kSerializerArr[4], self.legIntCategories);
        output.encodeNullableSerializableElement(serialDesc, 5, kSerializerArr[5], self.legIntVendors);
        output.encodeNullableSerializableElement(serialDesc, 6, GdprCS$PostPayload$$serializer.INSTANCE, self.postPayload);
        output.encodeNullableSerializableElement(serialDesc, 7, BooleanSerializer.INSTANCE, self.rejectedAny);
        output.encodeNullableSerializableElement(serialDesc, 8, kSerializerArr[8], self.specialFeatures);
        output.encodeNullableSerializableElement(serialDesc, 9, kSerializerArr[9], self.vendors);
        output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.addtlConsent);
        output.encodeNullableSerializableElement(serialDesc, 11, ConsentStatus$$serializer.INSTANCE, self.consentStatus);
        output.encodeNullableSerializableElement(serialDesc, 12, IntSerializer.INSTANCE, self.cookieExpirationDays);
        output.encodeNullableSerializableElement(serialDesc, 13, GdprCS$CustomVendorsResponse$$serializer.INSTANCE, self.customVendorsResponse);
        output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.dateCreated);
        output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.euconsent);
        output.encodeNullableSerializableElement(serialDesc, 16, GrantsSerializer.INSTANCE, self.grants);
        output.encodeNullableSerializableElement(serialDesc, 17, JsonMapSerializer.INSTANCE, self.TCData);
        output.encodeNullableSerializableElement(serialDesc, 18, BooleanSerializer.INSTANCE, self.localDataCurrent);
        output.encodeNullableSerializableElement(serialDesc, 19, StringSerializer.INSTANCE, self.uuid);
        output.encodeNullableSerializableElement(serialDesc, 20, StringSerializer.INSTANCE, self.vendorListId);
        if (output.shouldEncodeElementDefault(serialDesc, 21) || self.webConsentPayload != null) {
            output.encodeNullableSerializableElement(serialDesc, 21, JsonObjectSerializer.INSTANCE, self.webConsentPayload);
        }
        output.encodeNullableSerializableElement(serialDesc, 22, StringSerializer.INSTANCE, self.expirationDate);
        output.encodeNullableSerializableElement(serialDesc, 23, GoogleConsentMode$$serializer.INSTANCE, self.googleConsentMode);
    }

    public /* synthetic */ GdprCS(Boolean bool, List list, String str, Boolean bool2, List list2, List list3, PostPayload postPayload, Boolean bool3, List list4, List list5, String str2, ConsentStatus consentStatus, Integer num, CustomVendorsResponse customVendorsResponse, String str3, String str4, Map map, Map map2, Boolean bool4, String str5, String str6, JsonObject jsonObject, String str7, GoogleConsentMode googleConsentMode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bool, list, str, bool2, list2, list3, postPayload, bool3, list4, list5, str2, consentStatus, num, customVendorsResponse, str3, str4, map, map2, bool4, str5, str6, (i & 2097152) != 0 ? null : jsonObject, str7, googleConsentMode);
    }

    public final Boolean getApplies() {
        return this.applies;
    }

    public final List<String> getCategories() {
        return this.categories;
    }

    public final String getConsentAllRef() {
        return this.consentAllRef;
    }

    public final Boolean getConsentedToAll() {
        return this.consentedToAll;
    }

    public final List<String> getLegIntCategories() {
        return this.legIntCategories;
    }

    public final List<String> getLegIntVendors() {
        return this.legIntVendors;
    }

    public final PostPayload getPostPayload() {
        return this.postPayload;
    }

    public final Boolean getRejectedAny() {
        return this.rejectedAny;
    }

    public final List<String> getSpecialFeatures() {
        return this.specialFeatures;
    }

    public final List<String> getVendors() {
        return this.vendors;
    }

    public final String getAddtlConsent() {
        return this.addtlConsent;
    }

    public final ConsentStatus getConsentStatus() {
        return this.consentStatus;
    }

    public final Integer getCookieExpirationDays() {
        return this.cookieExpirationDays;
    }

    public final CustomVendorsResponse getCustomVendorsResponse() {
        return this.customVendorsResponse;
    }

    public final String getDateCreated() {
        return this.dateCreated;
    }

    public final String getEuconsent() {
        return this.euconsent;
    }

    public final Map<String, GDPRPurposeGrants> getGrants() {
        return this.grants;
    }

    public final Map<String, JsonElement> getTCData() {
        return this.TCData;
    }

    public final Boolean getLocalDataCurrent() {
        return this.localDataCurrent;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final void setUuid(String str) {
        this.uuid = str;
    }

    public final String getVendorListId() {
        return this.vendorListId;
    }

    public final JsonObject getWebConsentPayload() {
        return this.webConsentPayload;
    }

    public final String getExpirationDate() {
        return this.expirationDate;
    }

    public final void setExpirationDate(String str) {
        this.expirationDate = str;
    }

    public final GoogleConsentMode getGoogleConsentMode() {
        return this.googleConsentMode;
    }

    public final void setGoogleConsentMode(GoogleConsentMode googleConsentMode) {
        this.googleConsentMode = googleConsentMode;
    }

    /* compiled from: ConsentStatusApiModel.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B=\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB!\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J&\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%HÁ\u0001¢\u0006\u0002\b&R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010¨\u0006)"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$PostPayload;", "", "seen1", "", "consentAllRef", "", "granularStatus", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus$GranularStatus;", "vendorListId", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus$GranularStatus;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus$GranularStatus;Ljava/lang/String;)V", "getConsentAllRef$annotations", "()V", "getConsentAllRef", "()Ljava/lang/String;", "getGranularStatus$annotations", "getGranularStatus", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus$GranularStatus;", "getVendorListId$annotations", "getVendorListId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class PostPayload {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String consentAllRef;
        private final ConsentStatus.GranularStatus granularStatus;
        private final String vendorListId;

        public static /* synthetic */ PostPayload copy$default(PostPayload postPayload, String str, ConsentStatus.GranularStatus granularStatus, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = postPayload.consentAllRef;
            }
            if ((i & 2) != 0) {
                granularStatus = postPayload.granularStatus;
            }
            if ((i & 4) != 0) {
                str2 = postPayload.vendorListId;
            }
            return postPayload.copy(str, granularStatus, str2);
        }

        @SerialName("consentAllRef")
        public static /* synthetic */ void getConsentAllRef$annotations() {
        }

        @SerialName("granularStatus")
        public static /* synthetic */ void getGranularStatus$annotations() {
        }

        @SerialName("vendorListId")
        public static /* synthetic */ void getVendorListId$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final String getConsentAllRef() {
            return this.consentAllRef;
        }

        /* renamed from: component2, reason: from getter */
        public final ConsentStatus.GranularStatus getGranularStatus() {
            return this.granularStatus;
        }

        /* renamed from: component3, reason: from getter */
        public final String getVendorListId() {
            return this.vendorListId;
        }

        public final PostPayload copy(String consentAllRef, ConsentStatus.GranularStatus granularStatus, String vendorListId) {
            Intrinsics.checkNotNullParameter(granularStatus, "granularStatus");
            return new PostPayload(consentAllRef, granularStatus, vendorListId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PostPayload)) {
                return false;
            }
            PostPayload postPayload = (PostPayload) other;
            return Intrinsics.areEqual(this.consentAllRef, postPayload.consentAllRef) && Intrinsics.areEqual(this.granularStatus, postPayload.granularStatus) && Intrinsics.areEqual(this.vendorListId, postPayload.vendorListId);
        }

        public int hashCode() {
            String str = this.consentAllRef;
            int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.granularStatus.hashCode()) * 31;
            String str2 = this.vendorListId;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "PostPayload(consentAllRef=" + this.consentAllRef + ", granularStatus=" + this.granularStatus + ", vendorListId=" + this.vendorListId + ")";
        }

        /* compiled from: ConsentStatusApiModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$PostPayload$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$PostPayload;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<PostPayload> serializer() {
                return GdprCS$PostPayload$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ PostPayload(int i, @SerialName("consentAllRef") String str, @SerialName("granularStatus") ConsentStatus.GranularStatus granularStatus, @SerialName("vendorListId") String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, GdprCS$PostPayload$$serializer.INSTANCE.getDescriptor());
            }
            this.consentAllRef = str;
            this.granularStatus = granularStatus;
            this.vendorListId = str2;
        }

        public PostPayload(String str, ConsentStatus.GranularStatus granularStatus, String str2) {
            Intrinsics.checkNotNullParameter(granularStatus, "granularStatus");
            this.consentAllRef = str;
            this.granularStatus = granularStatus;
            this.vendorListId = str2;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$cmplibrary_release(PostPayload self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.consentAllRef);
            output.encodeSerializableElement(serialDesc, 1, ConsentStatus$GranularStatus$$serializer.INSTANCE, self.granularStatus);
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.vendorListId);
        }

        public final String getConsentAllRef() {
            return this.consentAllRef;
        }

        public final ConsentStatus.GranularStatus getGranularStatus() {
            return this.granularStatus;
        }

        public final String getVendorListId() {
            return this.vendorListId;
        }
    }

    /* compiled from: ConsentStatusApiModel.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0005)*+,-BO\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0001\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB5\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005HÆ\u0003J?\u0010\u001a\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001J&\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'HÁ\u0001¢\u0006\u0002\b(R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012¨\u0006."}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse;", "", "seen1", "", "consentedPurposes", "", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse$ConsentedPurpose;", "consentedVendors", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse$ConsentedVendor;", "legIntPurposes", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse$LegIntPurpose;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getConsentedPurposes$annotations", "()V", "getConsentedPurposes", "()Ljava/util/List;", "getConsentedVendors$annotations", "getConsentedVendors", "getLegIntPurposes$annotations", "getLegIntPurposes", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "ConsentedPurpose", "ConsentedVendor", "LegIntPurpose", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class CustomVendorsResponse {
        private final List<ConsentedPurpose> consentedPurposes;
        private final List<ConsentedVendor> consentedVendors;
        private final List<LegIntPurpose> legIntPurposes;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(GdprCS$CustomVendorsResponse$ConsentedPurpose$$serializer.INSTANCE), new ArrayListSerializer(GdprCS$CustomVendorsResponse$ConsentedVendor$$serializer.INSTANCE), new ArrayListSerializer(GdprCS$CustomVendorsResponse$LegIntPurpose$$serializer.INSTANCE)};

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CustomVendorsResponse copy$default(CustomVendorsResponse customVendorsResponse, List list, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = customVendorsResponse.consentedPurposes;
            }
            if ((i & 2) != 0) {
                list2 = customVendorsResponse.consentedVendors;
            }
            if ((i & 4) != 0) {
                list3 = customVendorsResponse.legIntPurposes;
            }
            return customVendorsResponse.copy(list, list2, list3);
        }

        @SerialName("consentedPurposes")
        public static /* synthetic */ void getConsentedPurposes$annotations() {
        }

        @SerialName("consentedVendors")
        public static /* synthetic */ void getConsentedVendors$annotations() {
        }

        @SerialName("legIntPurposes")
        public static /* synthetic */ void getLegIntPurposes$annotations() {
        }

        public final List<ConsentedPurpose> component1() {
            return this.consentedPurposes;
        }

        public final List<ConsentedVendor> component2() {
            return this.consentedVendors;
        }

        public final List<LegIntPurpose> component3() {
            return this.legIntPurposes;
        }

        public final CustomVendorsResponse copy(List<ConsentedPurpose> consentedPurposes, List<ConsentedVendor> consentedVendors, List<LegIntPurpose> legIntPurposes) {
            return new CustomVendorsResponse(consentedPurposes, consentedVendors, legIntPurposes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CustomVendorsResponse)) {
                return false;
            }
            CustomVendorsResponse customVendorsResponse = (CustomVendorsResponse) other;
            return Intrinsics.areEqual(this.consentedPurposes, customVendorsResponse.consentedPurposes) && Intrinsics.areEqual(this.consentedVendors, customVendorsResponse.consentedVendors) && Intrinsics.areEqual(this.legIntPurposes, customVendorsResponse.legIntPurposes);
        }

        public int hashCode() {
            List<ConsentedPurpose> list = this.consentedPurposes;
            int hashCode = (list == null ? 0 : list.hashCode()) * 31;
            List<ConsentedVendor> list2 = this.consentedVendors;
            int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
            List<LegIntPurpose> list3 = this.legIntPurposes;
            return hashCode2 + (list3 != null ? list3.hashCode() : 0);
        }

        public String toString() {
            return "CustomVendorsResponse(consentedPurposes=" + this.consentedPurposes + ", consentedVendors=" + this.consentedVendors + ", legIntPurposes=" + this.legIntPurposes + ")";
        }

        /* compiled from: ConsentStatusApiModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<CustomVendorsResponse> serializer() {
                return GdprCS$CustomVendorsResponse$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ CustomVendorsResponse(int i, @SerialName("consentedPurposes") List list, @SerialName("consentedVendors") List list2, @SerialName("legIntPurposes") List list3, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, GdprCS$CustomVendorsResponse$$serializer.INSTANCE.getDescriptor());
            }
            this.consentedPurposes = list;
            this.consentedVendors = list2;
            this.legIntPurposes = list3;
        }

        public CustomVendorsResponse(List<ConsentedPurpose> list, List<ConsentedVendor> list2, List<LegIntPurpose> list3) {
            this.consentedPurposes = list;
            this.consentedVendors = list2;
            this.legIntPurposes = list3;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$cmplibrary_release(CustomVendorsResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeNullableSerializableElement(serialDesc, 0, kSerializerArr[0], self.consentedPurposes);
            output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.consentedVendors);
            output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.legIntPurposes);
        }

        public final List<ConsentedPurpose> getConsentedPurposes() {
            return this.consentedPurposes;
        }

        public final List<ConsentedVendor> getConsentedVendors() {
            return this.consentedVendors;
        }

        /* compiled from: ConsentStatusApiModel.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHÁ\u0001¢\u0006\u0002\b R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006#"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse$ConsentedPurpose;", "", "seen1", "", "id", "", "name", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "getName$annotations", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @Serializable
        public static final /* data */ class ConsentedPurpose {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final String id;
            private final String name;

            public static /* synthetic */ ConsentedPurpose copy$default(ConsentedPurpose consentedPurpose, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = consentedPurpose.id;
                }
                if ((i & 2) != 0) {
                    str2 = consentedPurpose.name;
                }
                return consentedPurpose.copy(str, str2);
            }

            @SerialName("_id")
            public static /* synthetic */ void getId$annotations() {
            }

            @SerialName("name")
            public static /* synthetic */ void getName$annotations() {
            }

            /* renamed from: component1, reason: from getter */
            public final String getId() {
                return this.id;
            }

            /* renamed from: component2, reason: from getter */
            public final String getName() {
                return this.name;
            }

            public final ConsentedPurpose copy(String id, String name) {
                return new ConsentedPurpose(id, name);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ConsentedPurpose)) {
                    return false;
                }
                ConsentedPurpose consentedPurpose = (ConsentedPurpose) other;
                return Intrinsics.areEqual(this.id, consentedPurpose.id) && Intrinsics.areEqual(this.name, consentedPurpose.name);
            }

            public int hashCode() {
                String str = this.id;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.name;
                return hashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "ConsentedPurpose(id=" + this.id + ", name=" + this.name + ")";
            }

            /* compiled from: ConsentStatusApiModel.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse$ConsentedPurpose$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse$ConsentedPurpose;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<ConsentedPurpose> serializer() {
                    return GdprCS$CustomVendorsResponse$ConsentedPurpose$$serializer.INSTANCE;
                }
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ ConsentedPurpose(int i, @SerialName("_id") String str, @SerialName("name") String str2, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i & 3)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 3, GdprCS$CustomVendorsResponse$ConsentedPurpose$$serializer.INSTANCE.getDescriptor());
                }
                this.id = str;
                this.name = str2;
            }

            public ConsentedPurpose(String str, String str2) {
                this.id = str;
                this.name = str2;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$cmplibrary_release(ConsentedPurpose self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.id);
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.name);
            }

            public final String getId() {
                return this.id;
            }

            public final String getName() {
                return this.name;
            }
        }

        public final List<LegIntPurpose> getLegIntPurposes() {
            return this.legIntPurposes;
        }

        /* compiled from: ConsentStatusApiModel.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B=\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB#\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#HÁ\u0001¢\u0006\u0002\b$R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f¨\u0006'"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse$ConsentedVendor;", "", "seen1", "", "id", "", "name", "vendorType", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "getName$annotations", "getName", "getVendorType$annotations", "getVendorType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @Serializable
        public static final /* data */ class ConsentedVendor {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final String id;
            private final String name;
            private final String vendorType;

            public static /* synthetic */ ConsentedVendor copy$default(ConsentedVendor consentedVendor, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = consentedVendor.id;
                }
                if ((i & 2) != 0) {
                    str2 = consentedVendor.name;
                }
                if ((i & 4) != 0) {
                    str3 = consentedVendor.vendorType;
                }
                return consentedVendor.copy(str, str2, str3);
            }

            @SerialName("_id")
            public static /* synthetic */ void getId$annotations() {
            }

            @SerialName("name")
            public static /* synthetic */ void getName$annotations() {
            }

            @SerialName("vendorType")
            public static /* synthetic */ void getVendorType$annotations() {
            }

            /* renamed from: component1, reason: from getter */
            public final String getId() {
                return this.id;
            }

            /* renamed from: component2, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* renamed from: component3, reason: from getter */
            public final String getVendorType() {
                return this.vendorType;
            }

            public final ConsentedVendor copy(String id, String name, String vendorType) {
                return new ConsentedVendor(id, name, vendorType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ConsentedVendor)) {
                    return false;
                }
                ConsentedVendor consentedVendor = (ConsentedVendor) other;
                return Intrinsics.areEqual(this.id, consentedVendor.id) && Intrinsics.areEqual(this.name, consentedVendor.name) && Intrinsics.areEqual(this.vendorType, consentedVendor.vendorType);
            }

            public int hashCode() {
                String str = this.id;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.name;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.vendorType;
                return hashCode2 + (str3 != null ? str3.hashCode() : 0);
            }

            public String toString() {
                return "ConsentedVendor(id=" + this.id + ", name=" + this.name + ", vendorType=" + this.vendorType + ")";
            }

            /* compiled from: ConsentStatusApiModel.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse$ConsentedVendor$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse$ConsentedVendor;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<ConsentedVendor> serializer() {
                    return GdprCS$CustomVendorsResponse$ConsentedVendor$$serializer.INSTANCE;
                }
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ ConsentedVendor(int i, @SerialName("_id") String str, @SerialName("name") String str2, @SerialName("vendorType") String str3, SerializationConstructorMarker serializationConstructorMarker) {
                if (7 != (i & 7)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 7, GdprCS$CustomVendorsResponse$ConsentedVendor$$serializer.INSTANCE.getDescriptor());
                }
                this.id = str;
                this.name = str2;
                this.vendorType = str3;
            }

            public ConsentedVendor(String str, String str2, String str3) {
                this.id = str;
                this.name = str2;
                this.vendorType = str3;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$cmplibrary_release(ConsentedVendor self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.id);
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.name);
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.vendorType);
            }

            public final String getId() {
                return this.id;
            }

            public final String getName() {
                return this.name;
            }

            public final String getVendorType() {
                return this.vendorType;
            }
        }

        /* compiled from: ConsentStatusApiModel.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHÁ\u0001¢\u0006\u0002\b R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006#"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse$LegIntPurpose;", "", "seen1", "", "id", "", "name", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "getName$annotations", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @Serializable
        public static final /* data */ class LegIntPurpose {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final String id;
            private final String name;

            public static /* synthetic */ LegIntPurpose copy$default(LegIntPurpose legIntPurpose, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = legIntPurpose.id;
                }
                if ((i & 2) != 0) {
                    str2 = legIntPurpose.name;
                }
                return legIntPurpose.copy(str, str2);
            }

            @SerialName("_id")
            public static /* synthetic */ void getId$annotations() {
            }

            @SerialName("name")
            public static /* synthetic */ void getName$annotations() {
            }

            /* renamed from: component1, reason: from getter */
            public final String getId() {
                return this.id;
            }

            /* renamed from: component2, reason: from getter */
            public final String getName() {
                return this.name;
            }

            public final LegIntPurpose copy(String id, String name) {
                return new LegIntPurpose(id, name);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LegIntPurpose)) {
                    return false;
                }
                LegIntPurpose legIntPurpose = (LegIntPurpose) other;
                return Intrinsics.areEqual(this.id, legIntPurpose.id) && Intrinsics.areEqual(this.name, legIntPurpose.name);
            }

            public int hashCode() {
                String str = this.id;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.name;
                return hashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "LegIntPurpose(id=" + this.id + ", name=" + this.name + ")";
            }

            /* compiled from: ConsentStatusApiModel.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse$LegIntPurpose$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse$LegIntPurpose;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<LegIntPurpose> serializer() {
                    return GdprCS$CustomVendorsResponse$LegIntPurpose$$serializer.INSTANCE;
                }
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ LegIntPurpose(int i, @SerialName("_id") String str, @SerialName("name") String str2, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i & 3)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 3, GdprCS$CustomVendorsResponse$LegIntPurpose$$serializer.INSTANCE.getDescriptor());
                }
                this.id = str;
                this.name = str2;
            }

            public LegIntPurpose(String str, String str2) {
                this.id = str;
                this.name = str2;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$cmplibrary_release(LegIntPurpose self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.id);
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.name);
            }

            public final String getId() {
                return this.id;
            }

            public final String getName() {
                return this.name;
            }
        }
    }
}
