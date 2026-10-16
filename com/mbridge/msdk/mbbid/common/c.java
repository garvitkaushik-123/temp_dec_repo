package com.mbridge.msdk.mbbid.common;

/* compiled from: BidRequestParams.java */
/* loaded from: classes6.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private String f4484a;
    private String b;
    private String c;

    public c(String str, String str2) {
        this.f4484a = str;
        this.b = str2;
    }

    public String getmFloorPrice() {
        return this.c;
    }

    public String getmPlacementId() {
        return this.f4484a;
    }

    public String getmUnitId() {
        return this.b;
    }

    public void setmFloorPrice(String str) {
        this.c = str;
    }

    public void setmPlacementId(String str) {
        this.f4484a = str;
    }

    public void setmUnitId(String str) {
        this.b = str;
    }

    public c(String str, String str2, String str3) {
        this.f4484a = str;
        this.b = str2;
        this.c = str3;
    }
}
