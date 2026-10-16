package com.mbridge.msdk.foundation.controller.authoritycontroller;

import android.text.TextUtils;

/* compiled from: BaseAuthorityInfoBean.java */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected int f4202a;
    protected int b;
    protected int c;
    protected int d;

    protected void a(int i) {
        this.f4202a = i;
        this.b = i;
        this.c = i;
    }

    public void authDeviceIdStatus(int i) {
        this.b = i;
    }

    public void authGenDataStatus(int i) {
        this.f4202a = i;
    }

    public void authOtherDataStatus(int i) {
        this.d = i;
    }

    public void authSerialIdStatus(int i) {
        this.c = i;
    }

    public int getAuthDeviceIdStatus() {
        return this.b;
    }

    public int getAuthGenDataStatus() {
        return this.f4202a;
    }

    public int getAuthSerialIdStatus() {
        return this.c;
    }

    public int getOtherDataStatus() {
        return this.d;
    }

    public int getStatusByKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            str.hashCode();
            switch (str) {
                case "authority_serial_id":
                    return this.c;
                case "authority_device_id":
                    return this.b;
                case "authority_general_data":
                    return this.f4202a;
                case "authority_other":
                    return this.d;
            }
        }
        return 1;
    }
}
