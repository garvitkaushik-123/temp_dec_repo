package com.inmobi.media;

import android.content.Context;
import android.location.Location;
import com.ironsource.C3040d4;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* renamed from: com.inmobi.media.ab, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2564ab {

    /* renamed from: a, reason: collision with root package name */
    public static int f2520a = Integer.MIN_VALUE;
    public static Boolean b = null;
    public static String c = null;
    public static String d = null;
    public static String e = null;
    public static String f = null;
    public static String g = null;
    public static String h = null;
    public static int i = Integer.MIN_VALUE;
    public static String j;
    public static String k;
    public static String l;
    public static String m;
    public static Location n;

    public static void a(final boolean z) {
        b = Boolean.valueOf(z);
        final Context d2 = Uc.d();
        if (d2 != null) {
            Uc.a(new Runnable() { // from class: com.inmobi.media.ab$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC2564ab.a(d2, z);
                }
            });
        }
    }

    public static Location b() {
        Location location = n;
        if (location != null) {
            return location;
        }
        Context d2 = Uc.d();
        Location location2 = null;
        if (d2 == null) {
            return null;
        }
        ConcurrentHashMap concurrentHashMap = C6.b;
        C6 a2 = B6.a(d2, "user_info_store");
        Intrinsics.checkNotNullParameter("user_location", C3040d4.h.W);
        String string = a2.f2249a.getString("user_location", null);
        if (string == null) {
            return null;
        }
        Location location3 = new Location("");
        try {
            String[] strArr = (String[]) new Regex(",").split(string, 0).toArray(new String[0]);
            location3.setLatitude(Double.parseDouble(strArr[0]));
            location3.setLongitude(Double.parseDouble(strArr[1]));
            location3.setAccuracy(Float.parseFloat(strArr[2]));
            location3.setTime(Long.parseLong(strArr[3]));
            location2 = location3;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
        }
        n = location2;
        return location2;
    }

    public static boolean c() {
        Boolean bool = b;
        if (bool != null) {
            return bool.booleanValue();
        }
        Context d2 = Uc.d();
        if (d2 != null) {
            ConcurrentHashMap concurrentHashMap = C6.b;
            C6 a2 = B6.a(d2, "user_info_store");
            Intrinsics.checkNotNullParameter("user_age_restricted", C3040d4.h.W);
            b = Boolean.valueOf(a2.f2249a.getBoolean("user_age_restricted", false));
        }
        Boolean bool2 = b;
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        return false;
    }

    public static final void a(Context it, boolean z) {
        Intrinsics.checkNotNullParameter(it, "$it");
        ConcurrentHashMap concurrentHashMap = C6.b;
        C6.a(B6.a(it, "user_info_store"), "user_age_restricted", z, false, 4, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0136  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HashMap a() {
        String str;
        int length;
        int i2;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        HashMap hashMap = new HashMap();
        int i3 = f2520a;
        int i4 = Integer.MIN_VALUE;
        if (i3 == Integer.MIN_VALUE) {
            Context d2 = Uc.d();
            if (d2 == null) {
                i3 = Integer.MIN_VALUE;
            } else {
                ConcurrentHashMap concurrentHashMap = C6.b;
                C6 a2 = B6.a(d2, "user_info_store");
                Intrinsics.checkNotNullParameter("user_age", C3040d4.h.W);
                i3 = a2.f2249a.getInt("user_age", Integer.MIN_VALUE);
            }
            f2520a = i3;
        }
        if (i3 > 0) {
            hashMap.put("u-age", String.valueOf(i3));
        }
        int i5 = i;
        if (i5 == Integer.MIN_VALUE) {
            Context d3 = Uc.d();
            if (d3 != null) {
                ConcurrentHashMap concurrentHashMap2 = C6.b;
                C6 a3 = B6.a(d3, "user_info_store");
                Intrinsics.checkNotNullParameter("user_yob", C3040d4.h.W);
                i4 = a3.f2249a.getInt("user_yob", Integer.MIN_VALUE);
            }
            i = i4;
            i5 = i4;
        }
        if (i5 > 0) {
            hashMap.put("u-yearofbirth", String.valueOf(i5));
        }
        String str10 = f;
        String str11 = null;
        if (str10 == null) {
            Context d4 = Uc.d();
            if (d4 == null) {
                str10 = null;
            } else {
                ConcurrentHashMap concurrentHashMap3 = C6.b;
                C6 a4 = B6.a(d4, "user_info_store");
                Intrinsics.checkNotNullParameter("user_city_code", C3040d4.h.W);
                str10 = a4.f2249a.getString("user_city_code", null);
            }
            f = str10;
        }
        String str12 = g;
        if (str12 == null) {
            Context d5 = Uc.d();
            if (d5 == null) {
                str12 = null;
            } else {
                ConcurrentHashMap concurrentHashMap4 = C6.b;
                C6 a5 = B6.a(d5, "user_info_store");
                Intrinsics.checkNotNullParameter("user_state_code", C3040d4.h.W);
                str12 = a5.f2249a.getString("user_state_code", null);
            }
            g = str12;
        }
        String str13 = h;
        if (str13 == null) {
            Context d6 = Uc.d();
            if (d6 == null) {
                str13 = null;
            } else {
                ConcurrentHashMap concurrentHashMap5 = C6.b;
                C6 a6 = B6.a(d6, "user_info_store");
                Intrinsics.checkNotNullParameter("user_country_code", C3040d4.h.W);
                str13 = a6.f2249a.getString("user_country_code", null);
            }
            h = str13;
        }
        if (str10 != null) {
            int length2 = str10.length() - 1;
            int i6 = 0;
            boolean z = false;
            while (i6 <= length2) {
                boolean z2 = Intrinsics.compare((int) str10.charAt(!z ? i6 : length2), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length2--;
                } else if (z2) {
                    i6++;
                } else {
                    z = true;
                }
            }
            if (str10.subSequence(i6, length2 + 1).toString().length() > 0) {
                int length3 = str10.length() - 1;
                int i7 = 0;
                boolean z3 = false;
                while (i7 <= length3) {
                    boolean z4 = Intrinsics.compare((int) str10.charAt(!z3 ? i7 : length3), 32) <= 0;
                    if (z3) {
                        if (!z4) {
                            break;
                        }
                        length3--;
                    } else if (z4) {
                        i7++;
                    } else {
                        z3 = true;
                    }
                }
                str = I7.a(length3, 1, str10, i7);
                if (str12 != null) {
                    int length4 = str12.length() - 1;
                    int i8 = 0;
                    boolean z5 = false;
                    while (i8 <= length4) {
                        boolean z6 = Intrinsics.compare((int) str12.charAt(!z5 ? i8 : length4), 32) <= 0;
                        if (z5) {
                            if (!z6) {
                                break;
                            }
                            length4--;
                        } else if (z6) {
                            i8++;
                        } else {
                            z5 = true;
                        }
                    }
                    if (str12.subSequence(i8, length4 + 1).toString().length() > 0) {
                        StringBuilder append = new StringBuilder().append(str).append('-');
                        int length5 = str12.length() - 1;
                        int i9 = 0;
                        boolean z7 = false;
                        while (i9 <= length5) {
                            boolean z8 = Intrinsics.compare((int) str12.charAt(!z7 ? i9 : length5), 32) <= 0;
                            if (z7) {
                                if (!z8) {
                                    break;
                                }
                                length5--;
                            } else if (z8) {
                                i9++;
                            } else {
                                z7 = true;
                            }
                        }
                        str = append.append(str12.subSequence(i9, length5 + 1).toString()).toString();
                    }
                }
                if (str13 != null) {
                    int length6 = str13.length() - 1;
                    int i10 = 0;
                    boolean z9 = false;
                    while (i10 <= length6) {
                        boolean z10 = Intrinsics.compare((int) str13.charAt(!z9 ? i10 : length6), 32) <= 0;
                        if (z9) {
                            if (!z10) {
                                break;
                            }
                            length6--;
                        } else if (z10) {
                            i10++;
                        } else {
                            z9 = true;
                        }
                    }
                    if (str13.subSequence(i10, length6 + 1).toString().length() > 0) {
                        StringBuilder append2 = new StringBuilder().append(str).append('-');
                        int length7 = str13.length() - 1;
                        int i11 = 0;
                        boolean z11 = false;
                        while (i11 <= length7) {
                            boolean z12 = Intrinsics.compare((int) str13.charAt(!z11 ? i11 : length7), 32) <= 0;
                            if (z11) {
                                if (!z12) {
                                    break;
                                }
                                length7--;
                            } else if (z12) {
                                i11++;
                            } else {
                                z11 = true;
                            }
                        }
                        str = append2.append(str13.subSequence(i11, length7 + 1).toString()).toString();
                    }
                }
                length = str.length() - 1;
                i2 = 0;
                boolean z13 = false;
                while (i2 <= length) {
                    boolean z14 = Intrinsics.compare((int) str.charAt(!z13 ? i2 : length), 32) <= 0;
                    if (z13) {
                        if (!z14) {
                            break;
                        }
                        length--;
                    } else if (z14) {
                        i2++;
                    } else {
                        z13 = true;
                    }
                }
                if (str.subSequence(i2, length + 1).toString().length() > 0) {
                    hashMap.put("u-location", str);
                }
                str2 = c;
                if (str2 == null) {
                    Context d7 = Uc.d();
                    if (d7 == null) {
                        str2 = null;
                    } else {
                        ConcurrentHashMap concurrentHashMap6 = C6.b;
                        C6 a7 = B6.a(d7, "user_info_store");
                        Intrinsics.checkNotNullParameter("user_age_group", C3040d4.h.W);
                        str2 = a7.f2249a.getString("user_age_group", null);
                    }
                    c = str2;
                }
                if (str2 != null) {
                    Locale ENGLISH = Locale.ENGLISH;
                    Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
                    String lowerCase = str2.toLowerCase(ENGLISH);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    hashMap.put("u-agegroup", lowerCase);
                }
                str3 = d;
                if (str3 == null) {
                    Context d8 = Uc.d();
                    if (d8 == null) {
                        str3 = null;
                    } else {
                        ConcurrentHashMap concurrentHashMap7 = C6.b;
                        C6 a8 = B6.a(d8, "user_info_store");
                        Intrinsics.checkNotNullParameter("user_area_code", C3040d4.h.W);
                        str3 = a8.f2249a.getString("user_area_code", null);
                    }
                    d = str3;
                }
                if (str3 != null) {
                    hashMap.put("u-areacode", str3);
                }
                str4 = e;
                if (str4 == null) {
                    Context d9 = Uc.d();
                    if (d9 == null) {
                        str4 = null;
                    } else {
                        ConcurrentHashMap concurrentHashMap8 = C6.b;
                        C6 a9 = B6.a(d9, "user_info_store");
                        Intrinsics.checkNotNullParameter("user_post_code", C3040d4.h.W);
                        str4 = a9.f2249a.getString("user_post_code", null);
                    }
                    e = str4;
                }
                if (str4 != null) {
                    hashMap.put("u-postalcode", str4);
                }
                str5 = j;
                if (str5 == null) {
                    Context d10 = Uc.d();
                    if (d10 == null) {
                        str5 = null;
                    } else {
                        ConcurrentHashMap concurrentHashMap9 = C6.b;
                        C6 a10 = B6.a(d10, "user_info_store");
                        Intrinsics.checkNotNullParameter("user_gender", C3040d4.h.W);
                        str5 = a10.f2249a.getString("user_gender", null);
                    }
                    j = str5;
                }
                if (str5 != null) {
                    hashMap.put("u-gender", str5);
                }
                str6 = k;
                if (str6 == null) {
                    Context d11 = Uc.d();
                    if (d11 == null) {
                        str6 = null;
                    } else {
                        ConcurrentHashMap concurrentHashMap10 = C6.b;
                        C6 a11 = B6.a(d11, "user_info_store");
                        Intrinsics.checkNotNullParameter("user_education", C3040d4.h.W);
                        str6 = a11.f2249a.getString("user_education", null);
                    }
                    k = str6;
                }
                if (str6 != null) {
                    hashMap.put("u-education", str6);
                }
                str7 = l;
                if (str7 == null) {
                    Context d12 = Uc.d();
                    if (d12 == null) {
                        str7 = null;
                    } else {
                        ConcurrentHashMap concurrentHashMap11 = C6.b;
                        C6 a12 = B6.a(d12, "user_info_store");
                        Intrinsics.checkNotNullParameter("user_language", C3040d4.h.W);
                        str7 = a12.f2249a.getString("user_language", null);
                    }
                    l = str7;
                }
                if (str7 != null) {
                    hashMap.put("u-language", str7);
                }
                str8 = m;
                if (str8 == null) {
                    Context d13 = Uc.d();
                    if (d13 != null) {
                        ConcurrentHashMap concurrentHashMap12 = C6.b;
                        C6 a13 = B6.a(d13, "user_info_store");
                        Intrinsics.checkNotNullParameter("user_interest", C3040d4.h.W);
                        str11 = a13.f2249a.getString("user_interest", null);
                    }
                    m = str11;
                    str8 = str11;
                }
                if (str8 != null) {
                    hashMap.put("u-interests", str8);
                }
                if (!c()) {
                    str9 = "1";
                } else {
                    str9 = "0";
                }
                hashMap.put("u-age-restricted", str9);
                return hashMap;
            }
        }
        str = "";
        if (str12 != null) {
        }
        if (str13 != null) {
        }
        length = str.length() - 1;
        i2 = 0;
        boolean z132 = false;
        while (i2 <= length) {
        }
        if (str.subSequence(i2, length + 1).toString().length() > 0) {
        }
        str2 = c;
        if (str2 == null) {
        }
        if (str2 != null) {
        }
        str3 = d;
        if (str3 == null) {
        }
        if (str3 != null) {
        }
        str4 = e;
        if (str4 == null) {
        }
        if (str4 != null) {
        }
        str5 = j;
        if (str5 == null) {
        }
        if (str5 != null) {
        }
        str6 = k;
        if (str6 == null) {
        }
        if (str6 != null) {
        }
        str7 = l;
        if (str7 == null) {
        }
        if (str7 != null) {
        }
        str8 = m;
        if (str8 == null) {
        }
        if (str8 != null) {
        }
        if (!c()) {
        }
        hashMap.put("u-age-restricted", str9);
        return hashMap;
    }
}
