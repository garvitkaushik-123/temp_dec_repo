package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverter;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImplKt;
import com.sourcepoint.cmplibrary.data.network.converter.MessageCategorySerializer;
import com.sourcepoint.cmplibrary.data.network.converter.MessageSubCategorySerializer;
import com.sourcepoint.cmplibrary.model.exposed.MessageCategory;
import com.sourcepoint.cmplibrary.model.exposed.MessageSubCategory;
import com.sourcepoint.cmplibrary.util.FunctionalUtilsKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: MessagesApiModel.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 92\u00020\u0001:\u000289Ba\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB=\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\u0010J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010(\u001a\u00020\fHÆ\u0003JR\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\b\u0010/\u001a\u00020\tH\u0016J&\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206HÁ\u0001¢\u0006\u0002\b7R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0018R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u001dR\u001c\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\"¨\u0006:"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;", "", "seen1", "", "bucket", "categoryId", "Lcom/sourcepoint/cmplibrary/model/exposed/MessageCategory;", "messageId", "msgDescription", "", "prtnUUID", "subCategoryId", "Lcom/sourcepoint/cmplibrary/model/exposed/MessageSubCategory;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Lcom/sourcepoint/cmplibrary/model/exposed/MessageCategory;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/model/exposed/MessageSubCategory;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Integer;Lcom/sourcepoint/cmplibrary/model/exposed/MessageCategory;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/model/exposed/MessageSubCategory;)V", "getBucket$annotations", "()V", "getBucket", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCategoryId$annotations", "getCategoryId", "()Lcom/sourcepoint/cmplibrary/model/exposed/MessageCategory;", "getMessageId$annotations", "getMessageId", "getMsgDescription$annotations", "getMsgDescription", "()Ljava/lang/String;", "getPrtnUUID$annotations", "getPrtnUUID", "getSubCategoryId$annotations", "getSubCategoryId", "()Lcom/sourcepoint/cmplibrary/model/exposed/MessageSubCategory;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Lcom/sourcepoint/cmplibrary/model/exposed/MessageCategory;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/model/exposed/MessageSubCategory;)Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class MessageMetaData {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer bucket;
    private final MessageCategory categoryId;
    private final Integer messageId;
    private final String msgDescription;
    private final String prtnUUID;
    private final MessageSubCategory subCategoryId;

    public static /* synthetic */ MessageMetaData copy$default(MessageMetaData messageMetaData, Integer num, MessageCategory messageCategory, Integer num2, String str, String str2, MessageSubCategory messageSubCategory, int i, Object obj) {
        if ((i & 1) != 0) {
            num = messageMetaData.bucket;
        }
        if ((i & 2) != 0) {
            messageCategory = messageMetaData.categoryId;
        }
        if ((i & 4) != 0) {
            num2 = messageMetaData.messageId;
        }
        if ((i & 8) != 0) {
            str = messageMetaData.msgDescription;
        }
        if ((i & 16) != 0) {
            str2 = messageMetaData.prtnUUID;
        }
        if ((i & 32) != 0) {
            messageSubCategory = messageMetaData.subCategoryId;
        }
        String str3 = str2;
        MessageSubCategory messageSubCategory2 = messageSubCategory;
        return messageMetaData.copy(num, messageCategory, num2, str, str3, messageSubCategory2);
    }

    @SerialName("bucket")
    public static /* synthetic */ void getBucket$annotations() {
    }

    @SerialName("categoryId")
    @Serializable(with = MessageCategorySerializer.class)
    public static /* synthetic */ void getCategoryId$annotations() {
    }

    @SerialName("messageId")
    public static /* synthetic */ void getMessageId$annotations() {
    }

    @SerialName("msgDescription")
    public static /* synthetic */ void getMsgDescription$annotations() {
    }

    @SerialName("prtnUUID")
    public static /* synthetic */ void getPrtnUUID$annotations() {
    }

    @Serializable(with = MessageSubCategorySerializer.class)
    public static /* synthetic */ void getSubCategoryId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getBucket() {
        return this.bucket;
    }

    /* renamed from: component2, reason: from getter */
    public final MessageCategory getCategoryId() {
        return this.categoryId;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getMessageId() {
        return this.messageId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMsgDescription() {
        return this.msgDescription;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPrtnUUID() {
        return this.prtnUUID;
    }

    /* renamed from: component6, reason: from getter */
    public final MessageSubCategory getSubCategoryId() {
        return this.subCategoryId;
    }

    public final MessageMetaData copy(Integer bucket, MessageCategory categoryId, Integer messageId, String msgDescription, String prtnUUID, MessageSubCategory subCategoryId) {
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        Intrinsics.checkNotNullParameter(subCategoryId, "subCategoryId");
        return new MessageMetaData(bucket, categoryId, messageId, msgDescription, prtnUUID, subCategoryId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageMetaData)) {
            return false;
        }
        MessageMetaData messageMetaData = (MessageMetaData) other;
        return Intrinsics.areEqual(this.bucket, messageMetaData.bucket) && this.categoryId == messageMetaData.categoryId && Intrinsics.areEqual(this.messageId, messageMetaData.messageId) && Intrinsics.areEqual(this.msgDescription, messageMetaData.msgDescription) && Intrinsics.areEqual(this.prtnUUID, messageMetaData.prtnUUID) && this.subCategoryId == messageMetaData.subCategoryId;
    }

    public int hashCode() {
        Integer num = this.bucket;
        int hashCode = (((num == null ? 0 : num.hashCode()) * 31) + this.categoryId.hashCode()) * 31;
        Integer num2 = this.messageId;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.msgDescription;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.prtnUUID;
        return ((hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.subCategoryId.hashCode();
    }

    /* compiled from: MessagesApiModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<MessageMetaData> serializer() {
            return MessageMetaData$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ MessageMetaData(int i, @SerialName("bucket") Integer num, @SerialName("categoryId") @Serializable(with = MessageCategorySerializer.class) MessageCategory messageCategory, @SerialName("messageId") Integer num2, @SerialName("msgDescription") String str, @SerialName("prtnUUID") String str2, @Serializable(with = MessageSubCategorySerializer.class) MessageSubCategory messageSubCategory, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i, 63, MessageMetaData$$serializer.INSTANCE.getDescriptor());
        }
        this.bucket = num;
        this.categoryId = messageCategory;
        this.messageId = num2;
        this.msgDescription = str;
        this.prtnUUID = str2;
        this.subCategoryId = messageSubCategory;
    }

    public MessageMetaData(Integer num, MessageCategory categoryId, Integer num2, String str, String str2, MessageSubCategory subCategoryId) {
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        Intrinsics.checkNotNullParameter(subCategoryId, "subCategoryId");
        this.bucket = num;
        this.categoryId = categoryId;
        this.messageId = num2;
        this.msgDescription = str;
        this.prtnUUID = str2;
        this.subCategoryId = subCategoryId;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(MessageMetaData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.bucket);
        output.encodeSerializableElement(serialDesc, 1, MessageCategorySerializer.INSTANCE, self.categoryId);
        output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.messageId);
        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.msgDescription);
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.prtnUUID);
        output.encodeSerializableElement(serialDesc, 5, MessageSubCategorySerializer.INSTANCE, self.subCategoryId);
    }

    public final Integer getBucket() {
        return this.bucket;
    }

    public final MessageCategory getCategoryId() {
        return this.categoryId;
    }

    public final Integer getMessageId() {
        return this.messageId;
    }

    public final String getMsgDescription() {
        return this.msgDescription;
    }

    public final String getPrtnUUID() {
        return this.prtnUUID;
    }

    public final MessageSubCategory getSubCategoryId() {
        return this.subCategoryId;
    }

    public String toString() {
        Object obj;
        Either check = FunctionalUtilsKt.check(new Function0<String>() { // from class: com.sourcepoint.cmplibrary.data.network.model.optimized.MessageMetaData$toString$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Json converter = JsonConverterImplKt.getConverter(JsonConverter.Companion);
                MessageMetaData messageMetaData = MessageMetaData.this;
                converter.getSerializersModule();
                return converter.encodeToString(MessageMetaData.INSTANCE.serializer(), messageMetaData);
            }
        });
        if (check instanceof Either.Right) {
            obj = ((Either.Right) check).getR();
        } else {
            if (!(check instanceof Either.Left)) {
                throw new NoWhenBranchMatchedException();
            }
            obj = null;
        }
        String str = (String) obj;
        return str == null ? "{}" : str;
    }
}
