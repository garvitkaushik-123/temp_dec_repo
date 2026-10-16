package com.inmobi.media;

import android.content.Context;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import com.inmobi.commons.core.configs.SignalsConfig;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes4.dex */
public final class Z9 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2507a;
    public final InterfaceC2971z5 b;
    public final String c;
    public final boolean d;
    public final SignalsConfig.NovatiqConfig e;

    public Z9(Context context, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2507a = context;
        this.b = interfaceC2971z5;
        this.c = "";
        LinkedHashMap linkedHashMap = O2.f2380a;
        SignalsConfig.NovatiqConfig novatiqConfig = ((SignalsConfig) AbstractC2808p5.a("signals", "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig", null)).getNovatiqConfig();
        this.e = novatiqConfig;
        Intrinsics.checkNotNullParameter(context, "context");
        if (novatiqConfig.getIsNovatiqEnabled()) {
            Object systemService = context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
            TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
            String networkOperatorName = telephonyManager != null ? telephonyManager.getNetworkOperatorName() : null;
            String str = networkOperatorName != null ? networkOperatorName : "";
            List<String> carrierNames = novatiqConfig.getCarrierNames();
            if (!(carrierNames instanceof Collection) || !carrierNames.isEmpty()) {
                Iterator<T> it = carrierNames.iterator();
                while (it.hasNext()) {
                    if (StringsKt.contains((CharSequence) str, (CharSequence) it.next(), true)) {
                        try {
                            Context context2 = this.f2507a;
                            Intrinsics.checkNotNullParameter(context2, "context");
                            String str2 = StringsKt.replace$default(context2.getPackageManager().getApplicationLabel(context2.getApplicationInfo()).toString(), ' ', '_', false, 4, (Object) null) + "_app";
                            this.d = true;
                            StringBuilder sb = new StringBuilder();
                            Random random = new Random();
                            for (int i = 0; i < 40; i++) {
                                char charAt = "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxxxxxx".charAt(i);
                                if (charAt == 'x') {
                                    sb.append(Character.forDigit(random.nextInt(16), 16));
                                } else {
                                    sb.append(charAt);
                                }
                            }
                            String sb2 = sb.toString();
                            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                            this.c = sb2;
                            new C2581ba(new C2563aa(sb2, str2, this.e), this.b).a(new Y9(this));
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                }
            }
        }
        InterfaceC2971z5 interfaceC2971z52 = this.b;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).a("NovatiqDataHandler", "Novatiq disabled.. skipping");
        }
    }
}
