package com.mbridge.msdk.foundation.error;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.out.MBridgeIds;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: MBFailureReason.java */
/* loaded from: classes6.dex */
public class b implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private int f4251a;
    private int b;
    private String c;
    private Throwable d;
    private CampaignEx e;
    private MBridgeIds f;
    private String g;
    private String h;
    private boolean i;
    private int j = -1;
    private String k;
    private HashMap<Object, Object> l;
    private int m;
    private String n;
    private String o;
    private String p;

    public b(int i) {
        this.f4251a = i;
        this.b = a.b(i);
    }

    public void a(Throwable th) {
        this.d = th;
    }

    public int b() {
        return this.f4251a;
    }

    public void c(String str) {
        this.c = str;
    }

    public void d(String str) {
        this.k = str;
    }

    public MBridgeIds e() {
        if (this.f == null) {
            this.f = new MBridgeIds();
        }
        return this.f;
    }

    public String f() {
        return this.h;
    }

    public String h() {
        return this.k;
    }

    public int i() {
        return this.j;
    }

    public String toString() {
        return "MBFailureReason{errorCode=" + this.f4251a + ", errorSubType=" + this.b + ", message='" + this.c + "', cause=" + this.d + ", campaign=" + this.e + ", ids=" + this.f + ", requestId='" + this.g + "', localRequestId='" + this.h + "', isHeaderBidding=" + this.i + ", typeD=" + this.j + ", reasonD='" + this.k + "', extraMap=" + this.l + ", serverErrorCode=" + this.m + ", errorUrl='" + this.n + "', serverErrorResponse='" + this.o + "'}";
    }

    public CampaignEx a() {
        return this.e;
    }

    public void b(String str) {
        this.h = str;
    }

    public int c() {
        return this.b;
    }

    public String d() {
        return this.p;
    }

    public void a(CampaignEx campaignEx) {
        this.e = campaignEx;
    }

    public String g() {
        String str;
        int i;
        if (TextUtils.isEmpty(this.c)) {
            str = "";
        } else {
            str = this.c;
        }
        if (TextUtils.isEmpty(str) && (i = this.f4251a) != -1) {
            str = a.a(i);
        }
        Throwable th = this.d;
        if (th == null) {
            return str;
        }
        String message = th.getMessage();
        return !TextUtils.isEmpty(message) ? str + " # " + message : str;
    }

    public void a(MBridgeIds mBridgeIds) {
        this.f = mBridgeIds;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void a(Object obj, Object obj2) {
        if (this.l == null) {
            this.l = new HashMap<>();
        }
        this.l.put(obj, obj2);
    }

    public Object a(Object obj) {
        HashMap<Object, Object> hashMap = this.l;
        if (hashMap != null && hashMap.containsKey(obj)) {
            return this.l.get(obj);
        }
        return null;
    }

    public void a(int i) {
        this.j = i;
    }

    public void a(String str) {
        this.p = str;
    }

    public b(int i, String str) {
        this.f4251a = i;
        if (!TextUtils.isEmpty(str)) {
            a("his_reason", str);
        }
        this.c = str;
        this.b = a.b(i);
    }
}
