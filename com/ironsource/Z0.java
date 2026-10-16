package com.ironsource;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes6.dex */
public class Z0 implements Parcelable {
    public static final Parcelable.Creator<Z0> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f3153a;
    private String b;
    private String c;
    private boolean d;
    private int e;
    private ArrayList<String> f;
    private ArrayList<String> g;
    private ArrayList<String> h;
    private ArrayList<String> i;
    private String j;
    private String k;
    private Map<String, String> l;

    class a implements Parcelable.Creator<Z0> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Z0 createFromParcel(Parcel parcel) {
            return new Z0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Z0[] newArray(int i) {
            return new Z0[i];
        }
    }

    public Z0() {
        i();
    }

    private void i() {
        this.d = false;
        this.e = -1;
        this.f = new ArrayList<>();
        this.g = new ArrayList<>();
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.k = "";
        this.j = "";
        this.l = new HashMap();
    }

    public void a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!z) {
            this.g.remove(str);
        } else if (this.g.indexOf(str) == -1) {
            this.g.add(str);
        }
    }

    public boolean b(String str) {
        return !TextUtils.isEmpty(str) && this.g.indexOf(str) > -1;
    }

    public boolean c(String str) {
        return !TextUtils.isEmpty(str) && this.i.indexOf(str) > -1;
    }

    public String d() {
        return this.j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<String, String> e() {
        return this.l;
    }

    public String f() {
        return this.k;
    }

    public void g(String str) {
        this.j = str;
    }

    public void h(String str) {
        this.k = str;
    }

    public boolean j() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("shouldRestore:").append(this.d).append(", ");
            sb.append("displayedProduct:").append(this.e).append(", ");
            sb.append("ISReportInit:").append(this.f).append(", ");
            sb.append("ISInitSuccess:").append(this.g).append(", ");
            sb.append("ISAppKey").append(this.j).append(", ");
            sb.append("ISUserId").append(this.k).append(", ");
            sb.append("ISExtraParams").append(this.l).append(", ");
        } catch (Throwable th) {
            C3260q4.d().a(th);
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.e);
            parcel.writeString(this.f3153a);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
            parcel.writeString(this.j);
            parcel.writeString(this.k);
            parcel.writeString(new JSONObject(this.l).toString());
        } catch (Throwable th) {
            C3260q4.d().a(th);
        }
    }

    public boolean d(String str) {
        return !TextUtils.isEmpty(str) && this.f.indexOf(str) > -1;
    }

    public boolean e(String str) {
        return !TextUtils.isEmpty(str) && this.h.indexOf(str) > -1;
    }

    public void f(String str) {
        this.c = str;
    }

    public String g() {
        return this.f3153a;
    }

    public String h() {
        return this.b;
    }

    public void j(String str) {
        this.b = str;
    }

    private Z0(Parcel parcel) {
        i();
        try {
            this.d = parcel.readByte() != 0;
            this.e = parcel.readInt();
            this.f3153a = parcel.readString();
            this.b = parcel.readString();
            this.c = parcel.readString();
            this.j = parcel.readString();
            this.k = parcel.readString();
            this.l = a(parcel.readString());
        } catch (Throwable th) {
            C3260q4.d().a(th);
            i();
        }
    }

    public String b() {
        return this.c;
    }

    public int c() {
        return this.e;
    }

    public void b(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            if (this.i.indexOf(str) == -1) {
                this.i.add(str);
                return;
            }
            return;
        }
        this.i.remove(str);
    }

    public void c(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            if (this.f.indexOf(str) == -1) {
                this.f.add(str);
                return;
            }
            return;
        }
        this.f.remove(str);
    }

    public void d(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            if (this.h.indexOf(str) == -1) {
                this.h.add(str);
                return;
            }
            return;
        }
        this.h.remove(str);
    }

    public void a(Map<String, String> map) {
        this.l = map;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void a(int i) {
        this.e = i;
    }

    public void a() {
        this.e = -1;
    }

    private Map<String, String> a(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
        } catch (JSONException e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        } catch (Throwable th) {
            C3260q4.d().a(th);
            IronLog.INTERNAL.error(th.toString());
        }
        return hashMap;
    }

    public void i(String str) {
        this.f3153a = str;
    }
}
