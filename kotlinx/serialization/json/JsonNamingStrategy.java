package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: JsonNamingStrategy.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bç\u0080\u0001\u0018\u0000 \t2\u00020\u0001:\u0001\tJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lkotlinx/serialization/json/JsonNamingStrategy;", "", "serialNameForJson", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementIndex", "", "serialName", "Builtins", "kotlinx-serialization-json"}, k = 1, mv = {1, 8, 0}, xi = 48)
@ExperimentalSerializationApi
/* loaded from: classes8.dex */
public interface JsonNamingStrategy {

    /* renamed from: Builtins, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    String serialNameForJson(SerialDescriptor descriptor, int elementIndex, String serialName);

    /* compiled from: JsonNamingStrategy.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/serialization/json/JsonNamingStrategy$Builtins;", "", "()V", "SnakeCase", "Lkotlinx/serialization/json/JsonNamingStrategy;", "getSnakeCase$annotations", "getSnakeCase", "()Lkotlinx/serialization/json/JsonNamingStrategy;", "kotlinx-serialization-json"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ExperimentalSerializationApi
    /* renamed from: kotlinx.serialization.json.JsonNamingStrategy$Builtins, reason: from kotlin metadata */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final JsonNamingStrategy SnakeCase = new JsonNamingStrategy() { // from class: kotlinx.serialization.json.JsonNamingStrategy$Builtins$SnakeCase$1
            @Override // kotlinx.serialization.json.JsonNamingStrategy
            public String serialNameForJson(SerialDescriptor descriptor, int elementIndex, String serialName) {
                Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                Intrinsics.checkNotNullParameter(serialName, "serialName");
                StringBuilder sb = new StringBuilder(serialName.length() * 2);
                String str = serialName;
                Character ch = null;
                int i = 0;
                for (int i2 = 0; i2 < str.length(); i2++) {
                    char charAt = str.charAt(i2);
                    if (Character.isUpperCase(charAt)) {
                        if (i == 0) {
                            StringBuilder sb2 = sb;
                            if (sb2.length() > 0 && StringsKt.last(sb2) != '_') {
                                sb.append('_');
                            }
                        }
                        if (ch != null) {
                            sb.append(ch.charValue());
                        }
                        i++;
                        ch = Character.valueOf(Character.toLowerCase(charAt));
                    } else {
                        if (ch != null) {
                            if (i > 1 && Character.isLetter(charAt)) {
                                sb.append('_');
                            }
                            sb.append(ch);
                            ch = null;
                            i = 0;
                        }
                        sb.append(charAt);
                    }
                }
                if (ch != null) {
                    sb.append(ch);
                }
                String sb3 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
                return sb3;
            }

            public String toString() {
                return "kotlinx.serialization.json.JsonNamingStrategy.SnakeCase";
            }
        };

        @ExperimentalSerializationApi
        public static /* synthetic */ void getSnakeCase$annotations() {
        }

        private Companion() {
        }

        public final JsonNamingStrategy getSnakeCase() {
            return SnakeCase;
        }
    }
}
