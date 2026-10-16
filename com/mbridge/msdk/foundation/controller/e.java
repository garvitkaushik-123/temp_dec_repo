package com.mbridge.msdk.foundation.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.p0;

/* compiled from: TCStringManager.java */
/* loaded from: classes6.dex */
public class e implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private String f4214a = "";
    private String b = "";
    private String c = "";
    private String d = "";
    private int e = 0;
    private boolean f = false;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private a l;
    private final SharedPreferences m;

    /* compiled from: TCStringManager.java */
    public interface a {
        void a();
    }

    public e(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        this.m = defaultSharedPreferences;
        if (defaultSharedPreferences != null) {
            defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        }
        a();
    }

    private void a() {
        SharedPreferences sharedPreferences = this.m;
        if (sharedPreferences != null) {
            d(sharedPreferences.getString("IABTCF_TCString", ""));
            a(this.m.getInt("IABTCF_gdprApplies", 0));
            c(this.m.getString("IABTCF_PurposeConsents", ""));
            e(this.m.getString("IABTCF_VendorConsents", ""));
            b(this.m.getString("IABTCF_AddtlConsent", ""));
        }
    }

    public String b() {
        return this.f4214a;
    }

    public void c(String str) {
        this.g = a(str, 1);
        this.h = a(str, 2);
        this.b = str;
    }

    public void d(String str) {
        this.f4214a = str;
    }

    public void e(String str) {
        this.i = a(str, 867);
        this.c = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        char c;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            switch (str.hashCode()) {
                case -2004976699:
                    if (str.equals("IABTCF_PurposeConsents")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 83641339:
                    if (str.equals("IABTCF_gdprApplies")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1218895378:
                    if (str.equals("IABTCF_TCString")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1342914771:
                    if (str.equals("IABTCF_AddtlConsent")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1450203731:
                    if (str.equals("IABTCF_VendorConsents")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                d(sharedPreferences.getString("IABTCF_TCString", ""));
            } else if (c == 1) {
                a(sharedPreferences.getInt("IABTCF_gdprApplies", 0));
            } else if (c == 2) {
                c(sharedPreferences.getString("IABTCF_PurposeConsents", ""));
            } else if (c == 3) {
                e(sharedPreferences.getString("IABTCF_VendorConsents", ""));
            } else if (c == 4) {
                b(sharedPreferences.getString("IABTCF_AddtlConsent", ""));
            }
            a aVar = this.l;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Throwable th) {
            p0.b("TCStringManager", th.getMessage());
        }
    }

    public void b(String str) {
        this.d = str;
        if (TextUtils.isEmpty(str)) {
            this.j = true;
            return;
        }
        if (MBridgeConstans.GOOGLE_ATP_ID == -1) {
            this.k = false;
            return;
        }
        this.k = true;
        try {
            String[] split = str.split("~");
            if (split.length > 1) {
                if (TextUtils.isEmpty(split[1])) {
                    this.j = false;
                } else {
                    this.j = str.contains(String.valueOf(MBridgeConstans.GOOGLE_ATP_ID));
                }
            }
        } catch (Throwable th) {
            p0.b("TCStringManager", th.getMessage());
        }
    }

    public boolean c() {
        if (this.e == 0) {
            a(true);
            return this.f;
        }
        if (MBridgeConstans.VERIFY_ATP_CONSENT) {
            a((this.i || (this.k && this.j)) && this.g && this.h);
        } else {
            a(this.i && this.g && this.h);
        }
        return this.f;
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.l = aVar;
        }
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(boolean z) {
        this.f = z;
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[01]+");
    }

    private boolean a(String str, int i) {
        return a(str) && i <= str.length() && i >= 1 && '1' == str.charAt(i - 1);
    }
}
