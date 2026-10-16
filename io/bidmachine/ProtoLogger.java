package io.bidmachine;

import com.explorestack.protobuf.Any;
import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.Descriptors;
import com.explorestack.protobuf.MessageOrBuilder;
import com.explorestack.protobuf.TextFormat;
import com.google.firebase.sessions.settings.RemoteSettings;
import io.bidmachine.core.Logger;
import io.bidmachine.utils.lazy.LazyValue;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
class ProtoLogger {
    private static final String[] PROTO_KNOWN_PACKAGES = {BuildConfig.LIBRARY_PACKAGE_NAME, "com.explorestack"};

    ProtoLogger() {
    }

    static void log(final String tag, final MessageOrBuilder messageOrBuilder) {
        if (messageOrBuilder != null) {
            Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ProtoLogger$$ExternalSyntheticLambda0
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String format;
                    format = String.format("[%s] %s", tag, ProtoLogger.toJsonObject(messageOrBuilder));
                    return format;
                }
            });
        }
    }

    private static JSONObject toJsonObject(MessageOrBuilder messageOrBuilder) {
        if (messageOrBuilder instanceof Any) {
            return map((Any) messageOrBuilder);
        }
        return map(messageOrBuilder.getAllFields());
    }

    private static JSONArray toJsonArray(Descriptors.FieldDescriptor fieldDescriptor, List<?> valueList) {
        JSONArray jSONArray = new JSONArray();
        Iterator<?> it = valueList.iterator();
        while (it.hasNext()) {
            append(jSONArray, map(fieldDescriptor, it.next()));
        }
        return jSONArray;
    }

    private static JSONObject map(Map<Descriptors.FieldDescriptor, Object> fieldMap) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : fieldMap.entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            append(jSONObject, key.getName(), map(key, entry.getValue()));
        }
        return jSONObject;
    }

    private static Object map(Descriptors.FieldDescriptor fieldDescriptor, Object value) {
        try {
            if (fieldDescriptor.isRepeated() && (value instanceof List)) {
                return toJsonArray(fieldDescriptor, (List) value);
            }
            switch (AnonymousClass1.$SwitchMap$com$explorestack$protobuf$Descriptors$FieldDescriptor$JavaType[fieldDescriptor.getJavaType().ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    return value;
                case 7:
                    return byteToString(value);
                case 8:
                    return ((Descriptors.GenericDescriptor) value).getName();
                case 9:
                    return toJsonObject((MessageOrBuilder) value);
                default:
                    return "Unsupported type";
            }
        } catch (Throwable unused) {
            return "Parsing error";
        }
    }

    /* renamed from: io.bidmachine.ProtoLogger$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$explorestack$protobuf$Descriptors$FieldDescriptor$JavaType;

        static {
            int[] iArr = new int[Descriptors.FieldDescriptor.JavaType.values().length];
            $SwitchMap$com$explorestack$protobuf$Descriptors$FieldDescriptor$JavaType = iArr;
            try {
                iArr[Descriptors.FieldDescriptor.JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$explorestack$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$explorestack$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$explorestack$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$explorestack$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$explorestack$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$explorestack$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$explorestack$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$explorestack$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    private static JSONObject map(Any any) {
        String str = any.getTypeUrl().split(RemoteSettings.FORWARD_SLASH_STRING)[r0.length - 1];
        for (String str2 : PROTO_KNOWN_PACKAGES) {
            try {
                return toJsonObject(any.unpack(Class.forName(str2 + str.substring(str.indexOf(".")))));
            } catch (Exception unused) {
            }
        }
        return new JSONObject();
    }

    private static void append(JSONObject target, String key, Object value) {
        try {
            target.put(key, value);
        } catch (JSONException unused) {
        }
    }

    private static void append(JSONArray target, Object value) {
        target.put(value);
    }

    private static String byteToString(Object value) {
        if (value instanceof ByteString) {
            return TextFormat.escapeBytes((ByteString) value);
        }
        return TextFormat.escapeBytes((byte[]) value);
    }
}
