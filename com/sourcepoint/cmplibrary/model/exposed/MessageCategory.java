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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/MessageCategory;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "GDPR", "CCPA", "USNAT", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final class MessageCategory {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MessageCategory[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int code;
    public static final MessageCategory GDPR = new MessageCategory("GDPR", 0, 1);
    public static final MessageCategory CCPA = new MessageCategory("CCPA", 1, 2);
    public static final MessageCategory USNAT = new MessageCategory("USNAT", 2, 6);

    private static final /* synthetic */ MessageCategory[] $values() {
        return new MessageCategory[]{GDPR, CCPA, USNAT};
    }

    public static EnumEntries<MessageCategory> getEntries() {
        return $ENTRIES;
    }

    public static MessageCategory valueOf(String str) {
        return (MessageCategory) Enum.valueOf(MessageCategory.class, str);
    }

    public static MessageCategory[] values() {
        return (MessageCategory[]) $VALUES.clone();
    }

    /* compiled from: ActionType.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/MessageCategory$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/model/exposed/MessageCategory;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) MessageCategory.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<MessageCategory> serializer() {
            return get$cachedSerializer();
        }
    }

    private MessageCategory(String str, int i, int i2) {
        this.code = i2;
    }

    public final int getCode() {
        return this.code;
    }

    static {
        MessageCategory[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.sourcepoint.cmplibrary.model.exposed.MessageCategory.Companion.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return EnumsKt.createSimpleEnumSerializer("com.sourcepoint.cmplibrary.model.exposed.MessageCategory", MessageCategory.values());
            }
        });
    }
}
