package com.apm.insight.l;

import com.ironsource.C3040d4;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JSONWriter.java */
/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private Writer f294a;
    private final List<a> b = new ArrayList();

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: JSONWriter.java */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f295a = new a("EMPTY_ARRAY", 0);
        public static final a b = new a("NONEMPTY_ARRAY", 1);
        public static final a c = new a("EMPTY_OBJECT", 2);
        public static final a d = new a("DANGLING_KEY", 3);
        public static final a e = new a("NONEMPTY_OBJECT", 4);
        public static final a f = new a("NULL", 5);

        private a(String str, int i) {
        }
    }

    private h(Writer writer) {
        this.f294a = writer;
    }

    private h a() throws JSONException, IOException {
        return a(a.f295a, C3040d4.i.d);
    }

    private h b() throws JSONException, IOException {
        a aVar = a.f295a;
        a aVar2 = a.b;
        return a(C3040d4.i.e);
    }

    private h c() throws JSONException, IOException {
        return a(a.c, "{");
    }

    private h d() throws JSONException, IOException {
        a aVar = a.c;
        a aVar2 = a.e;
        return a("}");
    }

    private h a(a aVar, String str) throws JSONException, IOException {
        f();
        this.b.add(aVar);
        this.f294a.write(str);
        return this;
    }

    private h a(String str) throws JSONException, IOException {
        e();
        this.b.remove(r0.size() - 1);
        this.f294a.write(str);
        return this;
    }

    private a e() throws JSONException {
        return this.b.get(r0.size() - 1);
    }

    private void a(a aVar) {
        this.b.set(r0.size() - 1, aVar);
    }

    private h a(Object obj) throws JSONException, IOException {
        if (obj instanceof JSONArray) {
            a((JSONArray) obj);
            return this;
        }
        if (obj instanceof JSONObject) {
            a((JSONObject) obj);
            return this;
        }
        f();
        if (obj == null || obj == JSONObject.NULL) {
            this.f294a.write("null");
            return this;
        }
        if (obj instanceof Boolean) {
            this.f294a.write(String.valueOf(obj));
            return this;
        }
        if (obj instanceof Number) {
            this.f294a.write(JSONObject.numberToString((Number) obj));
            return this;
        }
        b(obj.toString());
        return this;
    }

    private void b(String str) throws IOException {
        this.f294a.write("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\f') {
                this.f294a.write("\\f");
            } else if (charAt == '\r') {
                this.f294a.write("\\r");
            } else {
                if (charAt == '\"' || charAt == '/' || charAt == '\\') {
                    this.f294a.write(92);
                } else {
                    switch (charAt) {
                        case '\b':
                            this.f294a.write("\\b");
                            continue;
                        case '\t':
                            this.f294a.write("\\t");
                            continue;
                        case '\n':
                            this.f294a.write("\\n");
                            continue;
                        default:
                            if (charAt <= 31) {
                                this.f294a.write(String.format("\\u%04x", Integer.valueOf(charAt)));
                                break;
                            }
                            break;
                    }
                }
                this.f294a.write(charAt);
            }
        }
        this.f294a.write("\"");
    }

    private void f() throws JSONException, IOException {
        if (this.b.isEmpty()) {
            return;
        }
        a e = e();
        if (e == a.f295a) {
            a(a.b);
            return;
        }
        if (e == a.b) {
            this.f294a.write(44);
        } else if (e == a.d) {
            this.f294a.write(":");
            a(a.e);
        } else if (e != a.f) {
            throw new JSONException("Nesting problem");
        }
    }

    public final String toString() {
        return "";
    }

    public static void a(JSONObject jSONObject, Writer writer) throws Throwable {
        new h(writer).a(jSONObject);
        writer.flush();
    }

    public static void a(JSONArray jSONArray, Writer writer) throws Throwable {
        new h(writer).a(jSONArray);
        writer.flush();
    }

    private void a(JSONObject jSONObject) throws JSONException, IOException {
        c();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            c(next).a(jSONObject.get(next));
        }
        d();
    }

    private void a(JSONArray jSONArray) throws JSONException, IOException {
        a();
        for (int i = 0; i < jSONArray.length(); i++) {
            a(jSONArray.get(i));
        }
        b();
    }

    private h c(String str) throws JSONException, IOException {
        a e = e();
        if (e == a.e) {
            this.f294a.write(44);
        } else if (e != a.c) {
            throw new JSONException("Nesting problem");
        }
        a(a.d);
        b(str);
        return this;
    }
}
