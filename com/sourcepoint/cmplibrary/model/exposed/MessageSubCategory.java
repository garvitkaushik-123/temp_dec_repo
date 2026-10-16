package com.sourcepoint.cmplibrary.model.exposed;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ActionType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/MessageSubCategory;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "TCFv2", "NATIVE_IN_APP", "OTT", "NATIVE_OTT", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final class MessageSubCategory {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MessageSubCategory[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int code;
    public static final MessageSubCategory TCFv2 = new MessageSubCategory("TCFv2", 0, 5);
    public static final MessageSubCategory NATIVE_IN_APP = new MessageSubCategory("NATIVE_IN_APP", 1, 6);
    public static final MessageSubCategory OTT = new MessageSubCategory("OTT", 2, 7);
    public static final MessageSubCategory NATIVE_OTT = new MessageSubCategory("NATIVE_OTT", 3, 14);

    private static final /* synthetic */ MessageSubCategory[] $values() {
        return new MessageSubCategory[]{TCFv2, NATIVE_IN_APP, OTT, NATIVE_OTT};
    }

    public static EnumEntries<MessageSubCategory> getEntries() {
        return $ENTRIES;
    }

    public static MessageSubCategory valueOf(String str) {
        return (MessageSubCategory) Enum.valueOf(MessageSubCategory.class, str);
    }

    public static MessageSubCategory[] values() {
        return (MessageSubCategory[]) $VALUES.clone();
    }

    /* compiled from: ActionType.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/MessageSubCategory$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/model/exposed/MessageSubCategory;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) MessageSubCategory.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<MessageSubCategory> serializer() {
            return get$cachedSerializer();
        }
    }

    private MessageSubCategory(String str, int i, int i2) {
        this.code = i2;
    }

    public final int getCode() {
        return this.code;
    }

    static {
        MessageSubCategory[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.sourcepoint.cmplibrary.model.exposed.MessageSubCategory.Companion.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return EnumsKt.createSimpleEnumSerializer("com.sourcepoint.cmplibrary.model.exposed.MessageSubCategory", MessageSubCategory.values());
            }
        });
    }
}
