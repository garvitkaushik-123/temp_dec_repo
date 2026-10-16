package com.sourcepoint.cmplibrary.core.nativemessage;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeModel.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u0015\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003JQ\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006\""}, d2 = {"Lcom/sourcepoint/cmplibrary/core/nativemessage/MessageComponents;", "", "name", "", "title", "Lcom/sourcepoint/cmplibrary/core/nativemessage/NativeComponent;", "body", "actions", "", "Lcom/sourcepoint/cmplibrary/core/nativemessage/NativeAction;", "customFields", "", "(Ljava/lang/String;Lcom/sourcepoint/cmplibrary/core/nativemessage/NativeComponent;Lcom/sourcepoint/cmplibrary/core/nativemessage/NativeComponent;Ljava/util/List;Ljava/util/Map;)V", "getActions", "()Ljava/util/List;", "getBody", "()Lcom/sourcepoint/cmplibrary/core/nativemessage/NativeComponent;", "getCustomFields", "()Ljava/util/Map;", "getName", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MessageComponents {
    private final List<NativeAction> actions;
    private final NativeComponent body;
    private final Map<String, String> customFields;
    private final String name;
    private final NativeComponent title;

    public static /* synthetic */ MessageComponents copy$default(MessageComponents messageComponents, String str, NativeComponent nativeComponent, NativeComponent nativeComponent2, List list, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messageComponents.name;
        }
        if ((i & 2) != 0) {
            nativeComponent = messageComponents.title;
        }
        if ((i & 4) != 0) {
            nativeComponent2 = messageComponents.body;
        }
        if ((i & 8) != 0) {
            list = messageComponents.actions;
        }
        if ((i & 16) != 0) {
            map = messageComponents.customFields;
        }
        Map map2 = map;
        NativeComponent nativeComponent3 = nativeComponent2;
        return messageComponents.copy(str, nativeComponent, nativeComponent3, list, map2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final NativeComponent getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final NativeComponent getBody() {
        return this.body;
    }

    public final List<NativeAction> component4() {
        return this.actions;
    }

    public final Map<String, String> component5() {
        return this.customFields;
    }

    public final MessageComponents copy(String name, NativeComponent title, NativeComponent body, List<NativeAction> actions, Map<String, String> customFields) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(customFields, "customFields");
        return new MessageComponents(name, title, body, actions, customFields);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageComponents)) {
            return false;
        }
        MessageComponents messageComponents = (MessageComponents) other;
        return Intrinsics.areEqual(this.name, messageComponents.name) && Intrinsics.areEqual(this.title, messageComponents.title) && Intrinsics.areEqual(this.body, messageComponents.body) && Intrinsics.areEqual(this.actions, messageComponents.actions) && Intrinsics.areEqual(this.customFields, messageComponents.customFields);
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        NativeComponent nativeComponent = this.title;
        int hashCode2 = (hashCode + (nativeComponent == null ? 0 : nativeComponent.hashCode())) * 31;
        NativeComponent nativeComponent2 = this.body;
        return ((((hashCode2 + (nativeComponent2 != null ? nativeComponent2.hashCode() : 0)) * 31) + this.actions.hashCode()) * 31) + this.customFields.hashCode();
    }

    public String toString() {
        return "MessageComponents(name=" + this.name + ", title=" + this.title + ", body=" + this.body + ", actions=" + this.actions + ", customFields=" + this.customFields + ")";
    }

    public MessageComponents(String name, NativeComponent nativeComponent, NativeComponent nativeComponent2, List<NativeAction> actions, Map<String, String> customFields) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(customFields, "customFields");
        this.name = name;
        this.title = nativeComponent;
        this.body = nativeComponent2;
        this.actions = actions;
        this.customFields = customFields;
    }

    public final String getName() {
        return this.name;
    }

    public final NativeComponent getTitle() {
        return this.title;
    }

    public final NativeComponent getBody() {
        return this.body;
    }

    public /* synthetic */ MessageComponents(String str, NativeComponent nativeComponent, NativeComponent nativeComponent2, List list, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, nativeComponent, nativeComponent2, (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? MapsKt.emptyMap() : map);
    }

    public final List<NativeAction> getActions() {
        return this.actions;
    }

    public final Map<String, String> getCustomFields() {
        return this.customFields;
    }
}
