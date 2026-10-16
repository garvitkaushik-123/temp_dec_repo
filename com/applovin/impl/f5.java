package com.applovin.impl;

import androidx.arch.core.util.Function;
import androidx.core.util.Consumer;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class f5 {

    /* renamed from: a, reason: collision with root package name */
    private final JSONObject f453a;
    private final Object b = new Object();

    public f5(JSONObject jSONObject) {
        this.f453a = jSONObject;
    }

    public JSONObject a() {
        JSONObject deepCopy;
        synchronized (this.b) {
            deepCopy = JsonUtils.deepCopy(this.f453a);
        }
        return deepCopy;
    }

    public List b(String str, List list) {
        List<String> stringList;
        synchronized (this.b) {
            stringList = JsonUtils.getStringList(this.f453a, str, list);
        }
        return stringList;
    }

    public void c(String str) {
        synchronized (this.b) {
            this.f453a.remove(str);
        }
    }

    public String toString() {
        String jSONObject;
        synchronized (this.b) {
            jSONObject = this.f453a.toString();
        }
        return jSONObject;
    }

    public boolean a(String str) {
        boolean has;
        synchronized (this.b) {
            has = this.f453a.has(str);
        }
        return has;
    }

    public Object b(String str) {
        Object opt;
        synchronized (this.b) {
            opt = this.f453a.opt(str);
        }
        return opt;
    }

    public void a(Consumer consumer) {
        synchronized (this.b) {
            consumer.accept(this);
        }
    }

    public void b(String str, int i) {
        synchronized (this.b) {
            JsonUtils.putInt(this.f453a, str, i);
        }
    }

    public Object a(Function function) {
        Object apply;
        synchronized (this.b) {
            apply = function.apply(this);
        }
        return apply;
    }

    public void b(String str, long j) {
        synchronized (this.b) {
            JsonUtils.putLong(this.f453a, str, j);
        }
    }

    public Boolean a(String str, Boolean bool) {
        Boolean bool2;
        synchronized (this.b) {
            bool2 = JsonUtils.getBoolean(this.f453a, str, bool);
        }
        return bool2;
    }

    public void b(String str, String str2) {
        synchronized (this.b) {
            JsonUtils.putString(this.f453a, str, str2);
        }
    }

    public float a(String str, float f) {
        float f2;
        synchronized (this.b) {
            f2 = JsonUtils.getFloat(this.f453a, str, f);
        }
        return f2;
    }

    public int a(String str, int i) {
        int i2;
        synchronized (this.b) {
            i2 = JsonUtils.getInt(this.f453a, str, i);
        }
        return i2;
    }

    public JSONArray a(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        synchronized (this.b) {
            jSONArray2 = JsonUtils.getJSONArray(this.f453a, str, jSONArray);
        }
        return jSONArray2;
    }

    public JSONObject a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        synchronized (this.b) {
            jSONObject2 = JsonUtils.getJSONObject(this.f453a, str, jSONObject);
        }
        return jSONObject2;
    }

    public long a(String str, long j) {
        long j2;
        synchronized (this.b) {
            j2 = JsonUtils.getLong(this.f453a, str, j);
        }
        return j2;
    }

    public String a(String str, String str2) {
        String string;
        synchronized (this.b) {
            string = JsonUtils.getString(this.f453a, str, str2);
        }
        return string;
    }

    public List a(String str, List list) {
        List<Integer> integerList;
        synchronized (this.b) {
            integerList = JsonUtils.getIntegerList(this.f453a, str, list);
        }
        return integerList;
    }

    public void a(String str, boolean z) {
        synchronized (this.b) {
            JsonUtils.putBoolean(this.f453a, str, z);
        }
    }

    public void a(String str, Object obj) {
        synchronized (this.b) {
            JsonUtils.putObject(this.f453a, str, obj);
        }
    }
}
