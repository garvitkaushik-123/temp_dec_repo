package com.bytedance.sdk.component.adexpress.dynamic.ui;

import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.DbA.NU;
import com.bytedance.sdk.component.adexpress.dynamic.ui.DbA;
import com.bytedance.sdk.component.utils.ev;
import com.google.firebase.crashlytics.internal.common.IdManager;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class du {
    private static String DbA;
    private static final Set<String> eli = Collections.unmodifiableSet(new HashSet(Arrays.asList("dislike", "close", "close-fill", "webview-close")));

    /* JADX WARN: Can't wrap try/catch for region: R(9:(3:186|(1:189)|190)(2:214|(1:216)(4:217|192|(5:201|202|203|(3:205|(1:211)(1:208)|209)|212)|200))|191|192|(3:194|196|198)|201|202|203|(0)|212) */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0465 A[Catch: Exception -> 0x0476, JSONException -> 0x047a, TryCatch #2 {JSONException -> 0x047a, blocks: (B:163:0x03aa, B:165:0x03d8, B:167:0x03dd, B:169:0x03e5, B:177:0x03fa, B:179:0x0401, B:181:0x040d, B:183:0x0415, B:186:0x041c, B:190:0x0426, B:192:0x043a, B:194:0x0442, B:196:0x0448, B:198:0x0450, B:200:0x0476, B:203:0x045a, B:205:0x0465, B:209:0x046f, B:214:0x042f), top: B:162:0x03aa }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DbA.Os eli(String str, String str2, String str3, boolean z, boolean z2, int i, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar, double d, int i2, double d2, String str4, NU nu) {
        int i3;
        String str5;
        int i4;
        int i5;
        float f;
        float f2;
        com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA ui;
        String str6 = str;
        int i6 = i;
        String aGH = nu.aGH();
        int kb = nu.kb();
        if (com.bytedance.sdk.component.adexpress.aGH.DbA() && i2 != 4 && (TextUtils.equals(str2, "text_star") || TextUtils.equals(str2, "score-count") || TextUtils.equals(str2, "score-count-type-1") || TextUtils.equals(str2, "score-count-type-2"))) {
            return new DbA.Os(0.0f, 0.0f);
        }
        DbA.Os os = new DbA.Os();
        if (str6.startsWith("<svg") || eli.contains(str2)) {
            try {
                if ("close".equals(str2) || (com.bytedance.sdk.component.adexpress.aGH.DbA() && "close-fill".equals(str2))) {
                    float optDouble = (float) new JSONObject(str3).optDouble("fontSize");
                    os.eli = optDouble;
                    os.DbA = optDouble;
                    return os;
                }
            } catch (Exception unused) {
            }
            os.eli = 10.0f;
            os.DbA = 10.0f;
            return os;
        }
        if ("logo".equals(str2)) {
            if (!com.bytedance.sdk.component.adexpress.aGH.DbA() && ((!TextUtils.isEmpty(str6) && str6.contains("adx:")) || DbA())) {
                if (DbA()) {
                    return eli(os, str6, str3, DbA);
                }
                return eli(os, str6, str3, "");
            }
            os.eli = "union".equals(str6) ? 14.0f : 20.0f;
            os.DbA = 10.0f;
            if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
                String Ue = nu.Ue();
                if ("union".equals(str6) && TextUtils.isEmpty(Ue)) {
                    os.eli = 0.0f;
                }
                String str7 = str2 + str6;
                float DbA2 = (float) DbA(str3);
                if (str7.contains("logoad")) {
                    String KM = nu.KM();
                    if (TextUtils.isEmpty(KM)) {
                        os.eli = 0.0f;
                    } else {
                        return eli(KM, str3);
                    }
                }
                os.DbA = DbA2;
                return os;
            }
        } else {
            if ("development-name".equals(str2)) {
                i3 = kb;
                str6 = ev.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), "tt_text_privacy_development") + str6;
            } else {
                i3 = kb;
            }
            if ("app-version".equals(str2)) {
                str5 = "";
                str6 = ev.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), "tt_text_privacy_app_version") + str6;
            } else {
                str5 = "";
            }
            if ("score-count".equals(str2)) {
                try {
                    i4 = Integer.parseInt(str6);
                } catch (NumberFormatException unused2) {
                    i4 = 0;
                }
                if (com.bytedance.sdk.component.adexpress.aGH.DbA() && i4 < 0) {
                    return new DbA.Os(0.0f, 0.0f);
                }
                return eli("(" + String.format(ev.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), "tt_comment_num"), Integer.valueOf(i4)) + ")", str3);
            }
            if ("score-count-type-2".equals(str2)) {
                try {
                    i5 = Integer.parseInt(str6);
                } catch (NumberFormatException unused3) {
                    i5 = 0;
                }
                if (com.bytedance.sdk.component.adexpress.aGH.DbA() && i5 < 0) {
                    return new DbA.Os(0.0f, 0.0f);
                }
                return eli("(" + String.format(new DecimalFormat("###,###,###").format(i5), Integer.valueOf(i5)) + ")", str3);
            }
            if ("feedback-dislike".equals(str2) && com.bytedance.sdk.component.adexpress.aGH.DbA()) {
                DbA.Os os2 = new DbA.Os();
                float DbA3 = (float) DbA(str3);
                os2.eli = DbA3;
                os2.DbA = DbA3;
                return os2;
            }
            if ("skip-with-time-countdown".equals(str2) || TextUtils.equals("skip-with-countdowns-video-countdown", str2)) {
                if (!nu.eli() || !com.bytedance.sdk.component.adexpress.aGH.MGA.DbA(aGH)) {
                    if (d < 10.0d) {
                        return eli("0S", str3);
                    }
                    return eli("00S", str3);
                }
                if (((int) (d + 0.5d)) - i3 < 10) {
                    if (!com.bytedance.sdk.component.adexpress.aGH.DbA()) {
                        return eli(String.format(ev.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), "tt_reward_full_skip"), "0"), str3);
                    }
                    return eli("0s", str3);
                }
                if (!com.bytedance.sdk.component.adexpress.aGH.DbA()) {
                    return eli(String.format(ev.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), "tt_reward_full_skip"), "00"), str3);
                }
                return eli("00s", str3);
            }
            if (TextUtils.equals("skip-with-countdowns-skip-btn", str2)) {
                return eli("| " + ev.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), "tt_reward_screen_skip_tx"), str3);
            }
            if (TextUtils.equals("skip-with-countdowns-skip-countdown", str2)) {
                return eli("| ".concat(String.valueOf(String.format(ev.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), "tt_reward_full_skip_count_down"), "00"))), str3);
            }
            if ("skip-with-time-skip-btn".equals(str2)) {
                DbA.Os eli2 = eli("| " + ev.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), "tt_reward_screen_skip_tx"), str3);
                if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
                    try {
                        eli2.DbA = (float) ((eli2.DbA * new JSONObject(str3).optDouble("lineHeight")) / 1.2d);
                    } catch (Throwable unused4) {
                    }
                    eli2.eli = eli2.DbA;
                }
                return eli2;
            }
            if ("skip".equals(str2)) {
                return eli(ev.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), "tt_reward_screen_skip_tx"), str3);
            }
            if ("timedown".equals(str2)) {
                return eli(IdManager.DEFAULT_VERSION_NAME, str3);
            }
            if ("text_star".equals(str2)) {
                if (com.bytedance.sdk.component.adexpress.aGH.DbA() && (d2 < 0.0d || d2 > 5.0d)) {
                    return new DbA.Os(0.0f, 0.0f);
                }
                return eli(IdManager.DEFAULT_VERSION_NAME, str3);
            }
            if (TextUtils.equals("privacy-detail", str2)) {
                return eli("Permission list | Privacy policy", str3);
            }
            if ("arrowButton".equals(str2)) {
                return eli("Download", str3);
            }
            if ("text".equals(str2) && com.bytedance.sdk.component.adexpress.aGH.DbA() && TextUtils.isEmpty(str6) && (ui = wCVar.aAs().ui()) != null) {
                if (ui.DE() != null) {
                    str5 = wCVar.aAs().ui().DE().optString(com.bytedance.sdk.component.adexpress.aGH.kb.Os(com.bytedance.sdk.component.adexpress.aGH.eli()));
                }
                str6 = str5;
            }
            if ("fillButton".equals(str2) || "text".equals(str2) || "button".equals(str2) || "downloadWithIcon".equals(str2) || "downloadButton".equals(str2) || "laceButton".equals(str2) || "cardButton".equals(str2) || "colourMixtureButton".equals(str2) || "arrowButton".equals(str2) || (("source".equals(str2) && (!com.bytedance.sdk.component.adexpress.aGH.DbA() || !"open_ad".equals(aGH))) || TextUtils.equals("app-version", str2) || TextUtils.equals("development-name", str2))) {
                return eli(str6, str3);
            }
            try {
                JSONObject jSONObject = new JSONObject(str3);
                int length = str6.length();
                float optDouble2 = (float) jSONObject.optDouble("fontSize");
                float optDouble3 = (float) jSONObject.optDouble("letterSpacing");
                float optDouble4 = (float) jSONObject.optDouble("lineHeight");
                float optDouble5 = (float) jSONObject.optDouble("maxWidth");
                float f3 = (length * (optDouble2 + optDouble3)) - optDouble3;
                if ("muted".equals(str2)) {
                    os.eli = optDouble2;
                    os.DbA = optDouble2;
                    return os;
                }
                if ("star".equals(str2)) {
                    if (com.bytedance.sdk.component.adexpress.aGH.DbA() && (d2 < 0.0d || d2 > 5.0d || i2 != 4)) {
                        return new DbA.Os(0.0f, 0.0f);
                    }
                    DbA.Os eli3 = eli("str", str3);
                    eli3.eli = optDouble2 * 5.0f;
                    return eli3;
                }
                if ("icon".equals(str2)) {
                    os.eli = optDouble2;
                    os.DbA = optDouble2;
                    return os;
                }
                if (z) {
                    int i7 = ((int) (f3 / optDouble5)) + 1;
                    if (z2 && i7 >= i6) {
                        i7 = i6;
                    }
                    f = (float) (optDouble4 * optDouble2 * i7 * 1.2d);
                } else {
                    f = (float) (optDouble4 * optDouble2 * 1.2d);
                    if (f3 <= optDouble5) {
                        f2 = f3;
                        if (!"title".equals(str2) || (com.bytedance.sdk.component.adexpress.aGH.DbA() && "open_ad".equals(aGH) && "source".equals(str2))) {
                            DbA.Os eli4 = eli(str6.replace('\n', ' '), str3, false);
                            if (z) {
                                int i8 = ((int) (f3 / optDouble5)) + 1;
                                if (!z2 || i8 < i6) {
                                    i6 = i8;
                                }
                                eli4.DbA *= i6;
                            }
                            return eli4;
                        }
                        os.eli = f2;
                        os.DbA = f;
                    }
                }
                f2 = optDouble5;
                if (!"title".equals(str2)) {
                }
                DbA.Os eli42 = eli(str6.replace('\n', ' '), str3, false);
                if (z) {
                }
                return eli42;
            } catch (JSONException unused5) {
            }
        }
        return os;
    }

    public static String eli(String str) {
        String[] split;
        return (TextUtils.isEmpty(str) || (split = str.split("adx:")) == null || split.length < 2) ? "" : split[1];
    }

    private static DbA.Os eli(DbA.Os os, String str, String str2, String str3) {
        if (str.contains("union")) {
            os.eli = 0.0f;
            os.DbA = 0.0f;
            return os;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = eli(str);
        }
        if (TextUtils.isEmpty(str3)) {
            os.eli = 0.0f;
            os.DbA = 0.0f;
            return os;
        }
        return eli(str3, str2);
    }

    public static DbA.Os eli(String str, String str2) {
        return eli(str, str2, false);
    }

    public static DbA.Os eli(String str, String str2, boolean z) {
        DbA.Os os = new DbA.Os();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int[] eli2 = eli(str, (float) DbA(str2), z);
            os.eli = eli2[0];
            os.DbA = eli2[1];
            if (jSONObject.optDouble("lineHeight", 1.0d) == 0.0d) {
                os.DbA = 0.0f;
            }
        } catch (Exception unused) {
        }
        return os;
    }

    public static double DbA(String str) {
        try {
            return Double.parseDouble(new JSONObject(str).optString("fontSize"));
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    public static int[] eli(String str, float f, boolean z) {
        int[] DbA2 = DbA(str, f, z);
        return new int[]{com.bytedance.sdk.component.adexpress.aGH.kb.DbA(com.bytedance.sdk.component.adexpress.aGH.eli(), DbA2[0]), com.bytedance.sdk.component.adexpress.aGH.kb.DbA(com.bytedance.sdk.component.adexpress.aGH.eli(), DbA2[1])};
    }

    public static int[] DbA(String str, float f, boolean z) {
        try {
            TextView textView = new TextView(com.bytedance.sdk.component.adexpress.aGH.eli());
            textView.setTextSize(f);
            textView.setText(str);
            textView.setIncludeFontPadding(false);
            if (z) {
                textView.setSingleLine();
            }
            textView.measure(-2, -2);
            return new int[]{textView.getMeasuredWidth() + 2, textView.getMeasuredHeight() + 2};
        } catch (Exception unused) {
            return new int[]{0, 0};
        }
    }

    public static String eli() {
        return DbA;
    }

    public static boolean DbA() {
        return !TextUtils.isEmpty(DbA);
    }
}
