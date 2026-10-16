package com.sourcepoint.cmplibrary.data.network.model;

import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.data.network.converter.ExceptionUtilsKt;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverter;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImplKt;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.ConsentActionImpl;
import com.sourcepoint.cmplibrary.model.ConsentActionImplOptimized;
import com.sourcepoint.cmplibrary.model.JsonToMapExtKt;
import com.sourcepoint.cmplibrary.model.exposed.ActionType;
import com.sourcepoint.cmplibrary.model.exposed.CCPAConsentInternal;
import com.sourcepoint.cmplibrary.model.exposed.CcpaStatus;
import com.sourcepoint.cmplibrary.util.FunctionalUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import org.json.JSONObject;

/* compiled from: ConsentRespExt.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00030\u0003H\u0000\u001a,\u0010\u0005\u001a\u00020\u0006*\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0000\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\u0002H\u0000\u001a\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\u00020\u0002H\u0000¨\u0006\u000f"}, d2 = {"toAcceptedCategories", "", "", "", "", "toCCPAUserConsent", "Lcom/sourcepoint/cmplibrary/model/exposed/CCPAConsentInternal;", "", "uuid", "applies", "toConsentAction", "Lcom/sourcepoint/cmplibrary/model/ConsentActionImpl;", "toConsentActionOptimized", "Lcom/sourcepoint/cmplibrary/core/Either;", "Lcom/sourcepoint/cmplibrary/model/ConsentActionImplOptimized;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConsentRespExtKt {
    public static final Either<ConsentActionImplOptimized> toConsentActionOptimized(final String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return FunctionalUtilsKt.check(new Function0<ConsentActionImplOptimized>() { // from class: com.sourcepoint.cmplibrary.data.network.model.ConsentRespExtKt$toConsentActionOptimized$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConsentActionImplOptimized invoke() {
                Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                String str2 = str;
                converter.getSerializersModule();
                return (ConsentActionImplOptimized) converter.decodeFromString(ConsentActionImplOptimized.INSTANCE.serializer(), str2);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00de, code lost:
    
        if (r2 != null) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ConsentActionImpl toConsentAction(String str) {
        ActionType actionType;
        String str2;
        Map<String, Object> map;
        JsonObject jsonObject;
        String str3;
        final String jSONObject;
        Either check;
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Map<String, Object> treeMap = JsonToMapExtKt.toTreeMap(new JSONObject(str));
        Object obj = treeMap.get("actionType");
        Object obj2 = null;
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        if (num != null) {
            int intValue = num.intValue();
            ActionType[] values = ActionType.values();
            int length = values.length;
            for (int i = 0; i < length; i++) {
                actionType = values[i];
                if (actionType.getCode() == intValue) {
                    break;
                }
            }
        }
        actionType = null;
        Object obj3 = treeMap.get("choiceId");
        String str4 = obj3 instanceof String ? (String) obj3 : null;
        String str5 = (String) JsonToMapExtKt.getFieldValue(treeMap, "legislation");
        if (str5 == null) {
            str5 = "CCPA";
        }
        Object obj4 = treeMap.get("pmId");
        String str6 = obj4 instanceof String ? (String) obj4 : null;
        if (str6 == null) {
            Object obj5 = treeMap.get("localPmId");
            if (!(obj5 instanceof String)) {
                str2 = null;
                Object obj6 = treeMap.get("pmTab");
                String str7 = !(obj6 instanceof String) ? (String) obj6 : null;
                Boolean bool = (Boolean) JsonToMapExtKt.getFieldValue(treeMap, "requestFromPm");
                boolean booleanValue = bool != null ? bool.booleanValue() : false;
                Map<String, Object> map2 = JsonToMapExtKt.getMap(treeMap, "saveAndExitVariables");
                JSONObject jSONObject2 = map2 == null ? new JSONObject(map2) : new JSONObject();
                map = JsonToMapExtKt.getMap(treeMap, "saveAndExitVariables");
                if (map != null && (jSONObject = JsonToMapExtKt.toJSONObj(map).toString()) != null) {
                    check = FunctionalUtilsKt.check(new Function0<JsonElement>() { // from class: com.sourcepoint.cmplibrary.data.network.model.ConsentRespExtKt$toConsentAction$saveAndExitVariables2$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final JsonElement invoke() {
                            Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                            String it = jSONObject;
                            Intrinsics.checkNotNullExpressionValue(it, "$it");
                            return converter.parseToJsonElement(it);
                        }
                    });
                    if (!(check instanceof Either.Right)) {
                        obj2 = ((Either.Right) check).getR();
                    } else if (!(check instanceof Either.Left)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    jsonElement = (JsonElement) obj2;
                    if (jsonElement != null) {
                        jsonObject = JsonElementKt.getJsonObject(jsonElement);
                    }
                }
                jsonObject = new JsonObject(MapsKt.emptyMap());
                JsonObject jsonObject2 = jsonObject;
                str3 = (String) JsonToMapExtKt.getFieldValue(treeMap, "consentLanguage");
                if (str3 == null) {
                    str3 = "EN";
                }
                String str8 = str3;
                String str9 = (String) JsonToMapExtKt.getFieldValue(treeMap, "customActionId");
                if (actionType == null) {
                    actionType = ActionType.UNKNOWN;
                }
                return new ConsentActionImpl(CampaignType.valueOf(str5), null, null, actionType, str9, str2, str4, booleanValue, jSONObject2, str8, jsonObject2, str7, JsonToMapExtKt.toJSONObj(treeMap), 6, null);
            }
            str6 = (String) obj5;
        }
        str2 = str6;
        Object obj62 = treeMap.get("pmTab");
        if (!(obj62 instanceof String)) {
        }
        Boolean bool2 = (Boolean) JsonToMapExtKt.getFieldValue(treeMap, "requestFromPm");
        boolean booleanValue2 = bool2 != null ? bool2.booleanValue() : false;
        Map<String, Object> map22 = JsonToMapExtKt.getMap(treeMap, "saveAndExitVariables");
        if (map22 == null) {
        }
        map = JsonToMapExtKt.getMap(treeMap, "saveAndExitVariables");
        if (map != null) {
            check = FunctionalUtilsKt.check(new Function0<JsonElement>() { // from class: com.sourcepoint.cmplibrary.data.network.model.ConsentRespExtKt$toConsentAction$saveAndExitVariables2$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final JsonElement invoke() {
                    Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                    String it = jSONObject;
                    Intrinsics.checkNotNullExpressionValue(it, "$it");
                    return converter.parseToJsonElement(it);
                }
            });
            if (!(check instanceof Either.Right)) {
            }
            jsonElement = (JsonElement) obj2;
            if (jsonElement != null) {
            }
        }
        jsonObject = new JsonObject(MapsKt.emptyMap());
        JsonObject jsonObject22 = jsonObject;
        str3 = (String) JsonToMapExtKt.getFieldValue(treeMap, "consentLanguage");
        if (str3 == null) {
        }
        String str82 = str3;
        String str92 = (String) JsonToMapExtKt.getFieldValue(treeMap, "customActionId");
        if (actionType == null) {
        }
        return new ConsentActionImpl(CampaignType.valueOf(str5), null, null, actionType, str92, str2, str4, booleanValue2, jSONObject2, str82, jsonObject22, str7, JsonToMapExtKt.toJSONObj(treeMap), 6, null);
    }

    public static final CCPAConsentInternal toCCPAUserConsent(final Map<String, ? extends Object> map, String str, boolean z) {
        List filterIsInstance;
        List filterIsInstance2;
        Object obj;
        CcpaStatus ccpaStatus;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Iterable iterable = (Iterable) JsonToMapExtKt.getFieldValue(map, "rejectedCategories");
        if (iterable == null || (filterIsInstance = CollectionsKt.filterIsInstance(iterable, String.class)) == null) {
            ExceptionUtilsKt.failParam("Ccpa  rejectedCategories");
            throw new KotlinNothingValueException();
        }
        Iterable iterable2 = (Iterable) JsonToMapExtKt.getFieldValue(map, "rejectedVendors");
        if (iterable2 == null || (filterIsInstance2 = CollectionsKt.filterIsInstance(iterable2, String.class)) == null) {
            ExceptionUtilsKt.failParam("Ccpa  rejectedVendors");
            throw new KotlinNothingValueException();
        }
        String str2 = (String) JsonToMapExtKt.getFieldValue(map, "status");
        if (str2 != null) {
            CcpaStatus[] values = CcpaStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                obj = null;
                if (i >= length) {
                    ccpaStatus = null;
                    break;
                }
                ccpaStatus = values[i];
                if (Intrinsics.areEqual(ccpaStatus.name(), str2)) {
                    break;
                }
                i++;
            }
            if (ccpaStatus != null) {
                Either check = FunctionalUtilsKt.check(new Function0<String>() { // from class: com.sourcepoint.cmplibrary.data.network.model.ConsentRespExtKt$toCCPAUserConsent$childPmId$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return (String) JsonToMapExtKt.getFieldValue(map, "childPmId");
                    }
                });
                if (check instanceof Either.Right) {
                    obj = ((Either.Right) check).getR();
                } else if (!(check instanceof Either.Left)) {
                    throw new NoWhenBranchMatchedException();
                }
                return new CCPAConsentInternal(str, null, filterIsInstance, filterIsInstance2, ccpaStatus, null, (String) obj, z, new JSONObject(map), null, null, 1570, null);
            }
        }
        ExceptionUtilsKt.fail("CCPAStatus cannot be null!!!");
        throw new KotlinNothingValueException();
    }

    public static final Iterable<String> toAcceptedCategories(Map<String, ? extends Map<String, Boolean>> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, ? extends Map<String, Boolean>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, MapsKt.toList(it.next().getValue()));
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList) {
            if (((Boolean) ((Pair) obj).getSecond()).booleanValue()) {
                arrayList2.add(obj);
            } else {
                arrayList3.add(obj);
            }
        }
        Pair pair = new Pair(arrayList2, arrayList3);
        Iterable iterable = (Iterable) pair.getFirst();
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            arrayList4.add((String) ((Pair) it2.next()).getFirst());
        }
        Set set = CollectionsKt.toSet(arrayList4);
        Iterable iterable2 = (Iterable) pair.getSecond();
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        Iterator it3 = iterable2.iterator();
        while (it3.hasNext()) {
            arrayList5.add((String) ((Pair) it3.next()).getFirst());
        }
        return SetsKt.minus(set, (Iterable) CollectionsKt.toSet(arrayList5));
    }
}
