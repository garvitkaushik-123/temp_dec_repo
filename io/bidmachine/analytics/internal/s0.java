package io.bidmachine.analytics.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import com.ironsource.C3040d4;
import java.io.Closeable;
import java.io.Flushable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public abstract class s0 {
    public static final Object a(Closeable closeable) {
        try {
            Result.Companion companion = Result.INSTANCE;
            closeable.close();
            return Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static final byte[] b(byte[] bArr, String str) {
        return a(bArr, str.getBytes(Charsets.UTF_8));
    }

    public static final String c(String str) {
        return Base64.encodeToString(str.getBytes(Charsets.UTF_8), 2);
    }

    public static final String d(String str) {
        if (str.length() == 0) {
            return str;
        }
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, C3040d4.i.b, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? StringsKt.reversed((CharSequence) str).toString() : StringsKt.reversed((CharSequence) str.substring(0, indexOf$default)).toString() + str.substring(indexOf$default);
    }

    public static final String b(String str) {
        return a(d(str));
    }

    public static final Object a(Flushable flushable) {
        try {
            Result.Companion companion = Result.INSTANCE;
            flushable.flush();
            return Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static final JSONArray a(List list) {
        JSONArray jSONArray = new JSONArray();
        for (Object obj : list) {
            if (obj instanceof List) {
                jSONArray.put(a((List) obj));
            } else if (obj instanceof Map) {
                jSONArray.put(a((Map) obj));
            } else {
                jSONArray.put(obj);
            }
        }
        return jSONArray;
    }

    public static final JSONObject a(Map map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            try {
                Result.Companion companion = Result.INSTANCE;
                String valueOf = String.valueOf(key);
                if (valueOf.length() != 0 && value != null) {
                    if (value instanceof List) {
                        value = a((List) value);
                    } else if (value instanceof Map) {
                        value = a((Map) value);
                    }
                    jSONObject.put(valueOf, value);
                }
                Result.m10241constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m10241constructorimpl(ResultKt.createFailure(th));
            }
        }
        return jSONObject;
    }

    public static final Map a(JSONObject jSONObject) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : SequencesKt.asSequence(jSONObject.keys())) {
            Object a2 = a(jSONObject.get(str));
            if (a2 != null) {
                linkedHashMap.put(str, a2);
            }
        }
        return linkedHashMap;
    }

    public static final List a(JSONArray jSONArray) {
        IntRange until = RangesKt.until(0, jSONArray.length());
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            Object a2 = a(jSONArray.get(((IntIterator) it).nextInt()));
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    private static final Object a(Object obj) {
        if (Intrinsics.areEqual(obj, JSONObject.NULL)) {
            return null;
        }
        return obj instanceof JSONObject ? a((JSONObject) obj) : obj instanceof JSONArray ? a((JSONArray) obj) : obj;
    }

    public static final Map a(Bundle bundle) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (!(obj instanceof Boolean)) {
                if (obj instanceof Byte) {
                    obj = Integer.valueOf(((Number) obj).byteValue());
                } else if (!(obj instanceof Character) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Long)) {
                    if (obj instanceof Short) {
                        obj = Integer.valueOf(((Number) obj).shortValue());
                    } else if (!(obj instanceof String)) {
                        if (obj instanceof Bundle) {
                            obj = a((Bundle) obj);
                        } else if (obj instanceof CharSequence) {
                            obj = obj.toString();
                        } else {
                            obj = obj != null ? obj.toString() : null;
                        }
                    }
                }
            }
            if (obj != null) {
                linkedHashMap.put(str, obj);
            }
        }
        return linkedHashMap;
    }

    public static final boolean a(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static final byte[] a(byte[] bArr, String str) {
        return a(bArr, str.getBytes(Charsets.UTF_8));
    }

    private static final byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i % bArr2.length]);
        }
        return bArr3;
    }

    public static final String a(String str) {
        return new String(Base64.decode(str, 2), Charsets.UTF_8);
    }

    public static final String a(Throwable th) {
        String sb;
        String message = th.getMessage();
        return (message == null || (sb = new StringBuilder().append(th.getClass().getName()).append(": ").append(message).toString()) == null) ? th.getClass().getName() : sb;
    }
}
