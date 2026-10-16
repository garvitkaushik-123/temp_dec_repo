package com.sourcepoint.cmplibrary.core.layout.model;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: NativeMessageDto.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\r\u0018\u00002\u00020\u0001BY\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r¢\u0006\u0002\u0010\u000eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001f\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/sourcepoint/cmplibrary/core/layout/model/NativeMessageDto;", "", "actions", "", "Lcom/sourcepoint/cmplibrary/core/layout/model/ActionDto;", "body", "Lcom/sourcepoint/cmplibrary/core/layout/model/TextViewConfigDto;", "customFields", "Lorg/json/JSONObject;", "name", "", "title", "thisContent", "", "(Ljava/util/List;Lcom/sourcepoint/cmplibrary/core/layout/model/TextViewConfigDto;Lorg/json/JSONObject;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/core/layout/model/TextViewConfigDto;Ljava/util/Map;)V", "getActions", "()Ljava/util/List;", "getBody", "()Lcom/sourcepoint/cmplibrary/core/layout/model/TextViewConfigDto;", "getCustomFields", "()Lorg/json/JSONObject;", "getName", "()Ljava/lang/String;", "getThisContent", "()Ljava/util/Map;", "getTitle", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NativeMessageDto {
    private final List<ActionDto> actions;
    private final TextViewConfigDto body;
    private final JSONObject customFields;
    private final String name;
    private final Map<String, Object> thisContent;
    private final TextViewConfigDto title;

    public NativeMessageDto(List<ActionDto> actions, TextViewConfigDto textViewConfigDto, JSONObject customFields, String str, TextViewConfigDto textViewConfigDto2, Map<String, ? extends Object> thisContent) {
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(customFields, "customFields");
        Intrinsics.checkNotNullParameter(thisContent, "thisContent");
        this.actions = actions;
        this.body = textViewConfigDto;
        this.customFields = customFields;
        this.name = str;
        this.title = textViewConfigDto2;
        this.thisContent = thisContent;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ NativeMessageDto(List list, TextViewConfigDto textViewConfigDto, JSONObject jSONObject, String str, TextViewConfigDto textViewConfigDto2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r4, textViewConfigDto, r6, r7, r8, r9);
        TextViewConfigDto textViewConfigDto3;
        Map map2;
        JSONObject jSONObject2;
        String str2;
        List list2;
        list = (i & 1) != 0 ? CollectionsKt.emptyList() : list;
        textViewConfigDto = (i & 2) != 0 ? null : textViewConfigDto;
        jSONObject = (i & 4) != 0 ? new JSONObject() : jSONObject;
        str = (i & 8) != 0 ? null : str;
        if ((i & 16) != 0) {
            textViewConfigDto3 = null;
            jSONObject2 = jSONObject;
            map2 = map;
            list2 = list;
            str2 = str;
        } else {
            textViewConfigDto3 = textViewConfigDto2;
            map2 = map;
            jSONObject2 = jSONObject;
            str2 = str;
            list2 = list;
        }
    }

    public final List<ActionDto> getActions() {
        return this.actions;
    }

    public final TextViewConfigDto getBody() {
        return this.body;
    }

    public final JSONObject getCustomFields() {
        return this.customFields;
    }

    public final String getName() {
        return this.name;
    }

    public final TextViewConfigDto getTitle() {
        return this.title;
    }

    public final Map<String, Object> getThisContent() {
        return this.thisContent;
    }
}
