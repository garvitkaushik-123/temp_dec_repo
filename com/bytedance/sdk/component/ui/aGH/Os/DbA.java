package com.bytedance.sdk.component.ui.aGH.Os;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.ui.Dfc;
import com.bytedance.sdk.component.ui.NU;
import com.bytedance.sdk.component.ui.aAs;
import com.bytedance.sdk.component.ui.aGH.Os.Os;
import com.bytedance.sdk.component.ui.nGm;
import com.bytedance.sdk.component.utils.aqO;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class DbA implements Dfc {
    private volatile MGA eli;

    private DbA() {
    }

    public static Dfc eli(Context context, NU nu) {
        DbA dbA = new DbA();
        dbA.DbA(context, nu);
        return dbA;
    }

    private void DbA(Context context, NU nu) {
        if (this.eli != null) {
            Log.w("ImageLoader", "already init!");
        }
        if (nu == null) {
            nu = ui.eli(context);
        }
        this.eli = new MGA(context, nu);
    }

    @Override // com.bytedance.sdk.component.ui.Dfc
    public aAs eli(String str) {
        return new Os.DbA(this.eli).Os(str);
    }

    @Override // com.bytedance.sdk.component.ui.Dfc
    public InputStream eli(String str, String str2) {
        byte[] eli;
        if (this.eli != null) {
            if (TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                str2 = aqO.eli(str);
            }
            nGm DbA = this.eli.DbA();
            if (DbA != null && (eli = DbA.eli(str2)) != null) {
                return new ByteArrayInputStream(eli);
            }
            Collection<com.bytedance.sdk.component.ui.Os> Os = this.eli.Os();
            if (Os != null) {
                Iterator<com.bytedance.sdk.component.ui.Os> it = Os.iterator();
                while (it.hasNext()) {
                    InputStream eli2 = it.next().eli(str2);
                    if (eli2 != null) {
                        return eli2;
                    }
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.ui.Dfc
    public boolean eli(String str, String str2, String str3) {
        if (this.eli == null || TextUtils.isEmpty(str3)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            str2 = aqO.eli(str);
        }
        com.bytedance.sdk.component.ui.Os eli = this.eli.eli(str3);
        if (eli != null) {
            return eli.DbA(str2);
        }
        return false;
    }
}
