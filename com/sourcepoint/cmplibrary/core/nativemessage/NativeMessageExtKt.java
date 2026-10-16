package com.sourcepoint.cmplibrary.core.nativemessage;

import com.ironsource.C3040d4;
import com.sourcepoint.cmplibrary.data.local.DataStorage;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.JsonToMapExtKt;
import com.sourcepoint.cmplibrary.model.exposed.NativeMessageActionType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: NativeMessageExt.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0000\u001a\u00020\u0001*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\"\u0010\u0007\u001a\u00020\u0001*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\b\u001a\u00020\t*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u001a\u0010\f\u001a\u00020\r*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0000\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0014\u0010\u0014\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0000\u001a\u001a\u0010\u0015\u001a\u00020\u0016*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0000\u001a\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0003*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0018\u001a\u00020\u0003H\u0000¨\u0006\u0019"}, d2 = {"toMessageComponents", "Lcom/sourcepoint/cmplibrary/core/nativemessage/MessageComponents;", "", "", "", "legislation", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "toMessageComponentsOptimized", "toNativeAction", "Lcom/sourcepoint/cmplibrary/core/nativemessage/NativeAction;", "toNativeActions", "", "toNativeComponent", "Lcom/sourcepoint/cmplibrary/core/nativemessage/NativeComponent;", "toNativeMessageDTO", "Lcom/sourcepoint/cmplibrary/core/nativemessage/MessageStructure;", "Lorg/json/JSONObject;", "campaignType", "dataStorage", "Lcom/sourcepoint/cmplibrary/data/local/DataStorage;", "toNativeMessageDTOOptimized", "toNativeStyle", "Lcom/sourcepoint/cmplibrary/core/nativemessage/NativeStyle;", "toStringOrNull", C3040d4.h.W, "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NativeMessageExtKt {
    public static final MessageStructure toNativeMessageDTO(JSONObject jSONObject, CampaignType campaignType, DataStorage dataStorage) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Intrinsics.checkNotNullParameter(dataStorage, "dataStorage");
        if (dataStorage.getMessagesOptimizedLocalState() == null) {
            return toNativeMessageDTO(jSONObject, campaignType);
        }
        return toNativeMessageDTOOptimized(jSONObject, campaignType);
    }

    public static final MessageStructure toNativeMessageDTO(JSONObject jSONObject, CampaignType campaignType) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Map<String, Object> map = JsonToMapExtKt.getMap(JsonToMapExtKt.toTreeMap(jSONObject), "message_json");
        return new MessageStructure(map != null ? toMessageComponents(map, campaignType) : null, campaignType);
    }

    public static final MessageStructure toNativeMessageDTOOptimized(JSONObject jSONObject, CampaignType campaignType) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Map<String, Object> map = JsonToMapExtKt.getMap(JsonToMapExtKt.toTreeMap(jSONObject), "message_json");
        return new MessageStructure(map != null ? toMessageComponentsOptimized(map, campaignType) : null, campaignType);
    }

    public static final MessageComponents toMessageComponents(Map<String, ? extends Object> map, CampaignType legislation) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(legislation, "legislation");
        String str = (String) JsonToMapExtKt.getFieldValue(map, "name");
        if (str == null) {
            str = "";
        }
        String str2 = str;
        Map<String, Object> map2 = JsonToMapExtKt.getMap(map, "title");
        NativeComponent nativeComponent = map2 != null ? toNativeComponent(map2) : null;
        Map<String, Object> map3 = JsonToMapExtKt.getMap(map, "body");
        NativeComponent nativeComponent2 = map3 != null ? toNativeComponent(map3) : null;
        Map<String, Object> map4 = JsonToMapExtKt.getMap(map, "customFields");
        Map<String, Object> map5 = map4 instanceof Map ? map4 : null;
        if (map5 == null) {
            map5 = MapsKt.emptyMap();
        }
        return new MessageComponents(str2, nativeComponent, nativeComponent2, toNativeActions(map, legislation), map5);
    }

    public static final MessageComponents toMessageComponentsOptimized(Map<String, ? extends Object> map, CampaignType legislation) {
        String str;
        List<NativeAction> emptyList;
        Map<String, Object> map2;
        Map<String, Object> map3;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(legislation, "legislation");
        String str2 = (String) JsonToMapExtKt.getFieldValue(map, "message_json_string");
        Map<String, Object> treeMap = str2 != null ? JsonToMapExtKt.toTreeMap(new JSONObject(str2)) : null;
        if (treeMap == null || (str = (String) JsonToMapExtKt.getFieldValue(treeMap, "name")) == null) {
            str = "";
        }
        String str3 = str;
        NativeComponent nativeComponent = (treeMap == null || (map3 = JsonToMapExtKt.getMap(treeMap, "title")) == null) ? null : toNativeComponent(map3);
        NativeComponent nativeComponent2 = (treeMap == null || (map2 = JsonToMapExtKt.getMap(treeMap, "body")) == null) ? null : toNativeComponent(map2);
        Map<String, Object> map4 = treeMap != null ? JsonToMapExtKt.getMap(treeMap, "customFields") : null;
        Map<String, Object> map5 = map4 instanceof Map ? map4 : null;
        if (map5 == null) {
            map5 = MapsKt.emptyMap();
        }
        Map<String, Object> map6 = map5;
        if (treeMap == null || (emptyList = toNativeActions(treeMap, legislation)) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        return new MessageComponents(str3, nativeComponent, nativeComponent2, emptyList, map6);
    }

    public static final List<NativeAction> toNativeActions(Map<String, ? extends Object> map, CampaignType legislation) {
        List filterIsInstance;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(legislation, "legislation");
        Iterable iterable = (Iterable) JsonToMapExtKt.getFieldValue(map, "actions");
        if (iterable == null || (filterIsInstance = CollectionsKt.filterIsInstance(iterable, Map.class)) == null) {
            return CollectionsKt.emptyList();
        }
        List list = filterIsInstance;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(toNativeAction((Map) it.next(), legislation));
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0036, code lost:
    
        if (r5 != null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final NativeAction toNativeAction(Map<?, ?> map, CampaignType legislation) {
        NativeMessageActionType nativeMessageActionType;
        NativeStyle nativeStyle;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(legislation, "legislation");
        Object obj = map.get("choiceType");
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        if (num != null) {
            int intValue = num.intValue();
            NativeMessageActionType[] values = NativeMessageActionType.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    nativeMessageActionType = null;
                    break;
                }
                nativeMessageActionType = values[i];
                if (nativeMessageActionType.getCode() == intValue) {
                    break;
                }
                i++;
            }
        }
        nativeMessageActionType = NativeMessageActionType.UNKNOWN;
        NativeMessageActionType nativeMessageActionType2 = nativeMessageActionType;
        String stringOrNull = toStringOrNull(map, "text");
        if (stringOrNull == null) {
            throw new RuntimeException();
        }
        Object obj2 = map.get("style");
        Map map2 = obj2 instanceof Map ? (Map) obj2 : null;
        if (map2 != null && (nativeStyle = toNativeStyle(map2)) != null) {
            return new NativeAction(stringOrNull, nativeStyle, null, nativeMessageActionType2, legislation, 4, null);
        }
        throw new RuntimeException();
    }

    public static final NativeComponent toNativeComponent(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        String str = (String) JsonToMapExtKt.getFieldValue(map, "text");
        Map<String, Object> map2 = JsonToMapExtKt.getMap(map, "style");
        NativeStyle nativeStyle = map2 != null ? toNativeStyle(map2) : null;
        Map<String, Object> map3 = JsonToMapExtKt.getMap(map, "customFields");
        Map<String, Object> map4 = map3 instanceof Map ? map3 : null;
        if (map4 == null) {
            map4 = MapsKt.emptyMap();
        }
        return new NativeComponent(str, nativeStyle, map4);
    }

    public static final NativeStyle toNativeStyle(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        String str = (String) JsonToMapExtKt.getFieldValue(map, "fontFamily");
        if (str == null) {
            str = "Arial";
        }
        String str2 = str;
        float intValue = ((Integer) JsonToMapExtKt.getFieldValue(map, "fontSize")) != null ? r0.intValue() : 16.0f;
        String str3 = (String) JsonToMapExtKt.getFieldValue(map, "fontWeight");
        float parseFloat = str3 != null ? Float.parseFloat(str3) : 400.0f;
        String str4 = (String) JsonToMapExtKt.getFieldValue(map, "backgroundColor");
        if (str4 == null) {
            str4 = "#FFFFFF";
        }
        return new NativeStyle(str2, parseFloat, intValue, (String) JsonToMapExtKt.getFieldValue(map, "color"), str4);
    }

    public static final String toStringOrNull(Map<?, ?> map, String key) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (map.get(key) == null || Intrinsics.areEqual(String.valueOf(map.get(key)), "null")) {
            return null;
        }
        return String.valueOf(map.get(key));
    }
}
