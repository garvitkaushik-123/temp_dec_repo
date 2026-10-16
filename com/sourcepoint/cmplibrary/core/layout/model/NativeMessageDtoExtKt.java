package com.sourcepoint.cmplibrary.core.layout.model;

import com.sourcepoint.cmplibrary.model.JsonToMapExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: NativeMessageDtoExt.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0000\u001a\u001a\u0010\u0005\u001a\u00020\u0006*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0000\u001a\u001a\u0010\u0007\u001a\u00020\b*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0000\u001a\u001a\u0010\t\u001a\u00020\n*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0000¨\u0006\u000b"}, d2 = {"toActionDto", "Lcom/sourcepoint/cmplibrary/core/layout/model/ActionDto;", "", "", "", "toNativeMessageDto", "Lcom/sourcepoint/cmplibrary/core/layout/model/NativeMessageDto;", "toStyleDto", "Lcom/sourcepoint/cmplibrary/core/layout/model/StyleDto;", "toTextViewConfigDto", "Lcom/sourcepoint/cmplibrary/core/layout/model/TextViewConfigDto;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NativeMessageDtoExtKt {
    public static final TextViewConfigDto toTextViewConfigDto(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        String str = (String) JsonToMapExtKt.getFieldValue(map, "text");
        JSONObject jSONObject = new JSONObject(JsonToMapExtKt.getMap(map, "customFields"));
        Map<String, Object> map2 = JsonToMapExtKt.getMap(map, "style");
        return new TextViewConfigDto(jSONObject, map2 != null ? toStyleDto(map2) : null, str);
    }

    public static final StyleDto toStyleDto(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return new StyleDto((String) JsonToMapExtKt.getFieldValue(map, "backgroundColor"), (String) JsonToMapExtKt.getFieldValue(map, "color"), (String) JsonToMapExtKt.getFieldValue(map, "fontFamily"), (Integer) JsonToMapExtKt.getFieldValue(map, "fontSize"), (String) JsonToMapExtKt.getFieldValue(map, "fontWeight"));
    }

    public static final ActionDto toActionDto(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Integer num = (Integer) JsonToMapExtKt.getFieldValue(map, "choiceId");
        Integer num2 = (Integer) JsonToMapExtKt.getFieldValue(map, "choiceType");
        JSONObject jSONObject = new JSONObject(JsonToMapExtKt.getMap(map, "customFields"));
        Map<String, Object> map2 = JsonToMapExtKt.getMap(map, "style");
        return new ActionDto(num, num2, jSONObject, map2 != null ? toStyleDto(map2) : null, (String) JsonToMapExtKt.getFieldValue(map, "text"));
    }

    public static final NativeMessageDto toNativeMessageDto(Map<String, ? extends Object> map) {
        ArrayList emptyList;
        Intrinsics.checkNotNullParameter(map, "<this>");
        List<Map<String, Object>> list = JsonToMapExtKt.getList(map, "actions");
        Map<String, Object> map2 = JsonToMapExtKt.getMap(map, "body");
        Map<String, Object> map3 = JsonToMapExtKt.getMap(map, "customFields");
        String str = (String) JsonToMapExtKt.getFieldValue(map, "name");
        Map<String, Object> map4 = JsonToMapExtKt.getMap(map, "title");
        if (list != null) {
            List<Map<String, Object>> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(toActionDto((Map) it.next()));
            }
            emptyList = arrayList;
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        return new NativeMessageDto(emptyList, map2 != null ? toTextViewConfigDto(map2) : null, new JSONObject(map3), str, map4 != null ? toTextViewConfigDto(map4) : null, map);
    }
}
