package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import kotlin.io.encoding.Base64;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* renamed from: com.facebook.ads.redexgen.X.3h, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C06963h {
    public static byte[] A0R;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public int A0E;
    public int A0F;
    public HashMap<C2452pg, C2450pe> A0G;
    public HashSet<Integer> A0H;
    public List<String> A0I;
    public List<String> A0J;
    public List<String> A0K;

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "D56211926, support language flag in video track")
    public List<String> A0L;
    public List<String> A0M;
    public boolean A0N;
    public boolean A0O;
    public boolean A0P;
    public boolean A0Q;

    static {
        A0P();
    }

    public static String A0H(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0R, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 34);
        }
        return new String(copyOfRange);
    }

    public static void A0P() {
        A0R = new byte[]{63, Base64.padSymbol, 44, 40, 53, 51, 50, 53, 50, 59};
    }

    @Deprecated
    public C06963h() {
        this.A06 = Integer.MAX_VALUE;
        this.A05 = Integer.MAX_VALUE;
        this.A04 = Integer.MAX_VALUE;
        this.A03 = Integer.MAX_VALUE;
        this.A0F = Integer.MAX_VALUE;
        this.A0E = Integer.MAX_VALUE;
        this.A0Q = true;
        this.A0M = MetaExoPlayerCustomizedCollections.A01();
        this.A0D = 0;
        this.A0L = MetaExoPlayerCustomizedCollections.A01();
        this.A0I = MetaExoPlayerCustomizedCollections.A01();
        this.A0B = 0;
        this.A02 = Integer.MAX_VALUE;
        this.A01 = Integer.MAX_VALUE;
        this.A0J = MetaExoPlayerCustomizedCollections.A01();
        this.A0K = MetaExoPlayerCustomizedCollections.A01();
        this.A0C = 0;
        this.A00 = 0;
        this.A0P = false;
        this.A0O = false;
        this.A0N = false;
        this.A0G = new HashMap<>();
        this.A0H = new HashSet<>();
    }

    public C06963h(Context context) {
        this();
        A0n(context);
        A0o(context, true);
    }

    public C06963h(Bundle bundle) {
        List A01;
        this.A06 = bundle.getInt(C2448pc.A0e, C2448pc.A0U.A06);
        this.A05 = bundle.getInt(C2448pc.A0d, C2448pc.A0U.A05);
        this.A04 = bundle.getInt(C2448pc.A0c, C2448pc.A0U.A04);
        this.A03 = bundle.getInt(C2448pc.A0b, C2448pc.A0U.A03);
        this.A0A = bundle.getInt(C2448pc.A0i, C2448pc.A0U.A0A);
        this.A09 = bundle.getInt(C2448pc.A0h, C2448pc.A0U.A09);
        this.A08 = bundle.getInt(C2448pc.A0n(), C2448pc.A0U.A08);
        this.A07 = bundle.getInt(C2448pc.A0f, C2448pc.A0U.A07);
        this.A0F = bundle.getInt(C2448pc.A0v, C2448pc.A0U.A0F);
        this.A0E = bundle.getInt(C2448pc.A0t, C2448pc.A0U.A0E);
        this.A0Q = bundle.getBoolean(C2448pc.A0u, C2448pc.A0U.A0Q);
        this.A0M = BP.A07((String[]) AbstractC2152ka.A00(bundle.getStringArray(C2448pc.A0p), new String[0]));
        this.A0D = bundle.getInt(C2448pc.A0q, C2448pc.A0U.A0D);
        String[] preferredVideoLanguages1 = (String[]) AbstractC2152ka.A00(bundle.getStringArray(C2448pc.A0o), new String[0]);
        this.A0L = A0G(preferredVideoLanguages1);
        String[] preferredVideoLanguages12 = new String[0];
        this.A0I = A0G((String[]) AbstractC2152ka.A00(bundle.getStringArray(C2448pc.A0j), preferredVideoLanguages12));
        this.A0B = bundle.getInt(C2448pc.A0l, C2448pc.A0U.A0B);
        this.A02 = bundle.getInt(C2448pc.A0a, C2448pc.A0U.A02);
        this.A01 = bundle.getInt(C2448pc.A0Z, C2448pc.A0U.A01);
        String[] preferredVideoLanguages13 = new String[0];
        this.A0J = BP.A07((String[]) AbstractC2152ka.A00(bundle.getStringArray(C2448pc.A0k), preferredVideoLanguages13));
        String[] preferredVideoLanguages14 = new String[0];
        this.A0K = A0G((String[]) AbstractC2152ka.A00(bundle.getStringArray(C2448pc.A0m), preferredVideoLanguages14));
        this.A0C = bundle.getInt(C2448pc.A0n, C2448pc.A0U.A0C);
        this.A00 = bundle.getInt(C2448pc.A0e(), C2448pc.A0U.A00);
        this.A0P = bundle.getBoolean(C2448pc.A0s, C2448pc.A0U.A0P);
        this.A0O = bundle.getBoolean(C2448pc.A0X, C2448pc.A0U.A0O);
        this.A0N = bundle.getBoolean(C2448pc.A0W, C2448pc.A0U.A0N);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(C2448pc.A0r);
        if (parcelableArrayList == null) {
            A01 = MetaExoPlayerCustomizedCollections.A01();
        } else {
            A01 = AnonymousClass44.A01(C2450pe.A02, parcelableArrayList);
        }
        this.A0G = new HashMap<>();
        for (int i = 0; i < A01.size(); i++) {
            C2450pe c2450pe = (C2450pe) A01.get(i);
            this.A0G.put(c2450pe.A00, c2450pe);
        }
        int[] iArr = (int[]) AbstractC2152ka.A00(bundle.getIntArray(C2448pc.A0V), new int[0]);
        this.A0H = new HashSet<>();
        for (int i2 : iArr) {
            this.A0H.add(Integer.valueOf(i2));
        }
    }

    public C06963h(C2448pc c2448pc) {
        A0R(c2448pc);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.google.common.collect.ImmutableList$Builder<java.lang.String> */
    public static BP<String> A0G(String[] strArr) {
        C2K A01 = BP.A01();
        for (String str : (String[]) AbstractC07133y.A01(strArr)) {
            A01.A04(C5C.A0k((String) AbstractC07133y.A01(str)));
        }
        return A01.A05();
    }

    private void A0Q(Context context) {
        CaptioningManager captioningManager;
        if ((C5C.A02 < 23 && Looper.myLooper() == null) || (captioningManager = (CaptioningManager) context.getSystemService(A0H(0, 10, 126))) == null || !captioningManager.isEnabled()) {
            return;
        }
        this.A0C = 1088;
        Locale locale = captioningManager.getLocale();
        if (locale != null) {
            this.A0K = BP.A04(C5C.A0o(locale));
        }
    }

    @EnsuresNonNull({"preferredVideoMimeTypes", "preferredAudioLanguages", "preferredAudioMimeTypes", "preferredTextLanguages", "overrides", "disabledTrackTypes"})
    private void A0R(C2448pc c2448pc) {
        this.A06 = c2448pc.A06;
        this.A05 = c2448pc.A05;
        this.A04 = c2448pc.A04;
        this.A03 = c2448pc.A03;
        this.A0A = c2448pc.A0A;
        this.A09 = c2448pc.A09;
        this.A08 = c2448pc.A08;
        this.A07 = c2448pc.A07;
        this.A0F = c2448pc.A0F;
        this.A0E = c2448pc.A0E;
        this.A0Q = c2448pc.A0Q;
        this.A0M = c2448pc.A0M;
        this.A0D = c2448pc.A0D;
        this.A0L = c2448pc.A0L;
        this.A0I = c2448pc.A0I;
        this.A0B = c2448pc.A0B;
        this.A02 = c2448pc.A02;
        this.A01 = c2448pc.A01;
        this.A0J = c2448pc.A0J;
        this.A0K = c2448pc.A0K;
        this.A0C = c2448pc.A0C;
        this.A00 = c2448pc.A00;
        this.A0P = c2448pc.A0P;
        this.A0O = c2448pc.A0O;
        this.A0N = c2448pc.A0N;
        this.A0H = new HashSet<>(c2448pc.A0H);
        this.A0G = new HashMap<>(c2448pc.A0G);
    }

    public C06963h A0W(C2448pc c2448pc) {
        A0R(c2448pc);
        return this;
    }

    public C06963h A0m(int i, int i2, boolean z) {
        this.A0F = i;
        this.A0E = i2;
        this.A0Q = z;
        return this;
    }

    public C06963h A0n(Context context) {
        if (C5C.A02 >= 19) {
            A0Q(context);
        }
        return this;
    }

    public C06963h A0o(Context context, boolean z) {
        Point viewportSize = C5C.A0W(context);
        return A0m(viewportSize.x, viewportSize.y, z);
    }

    public C2448pc A0p() {
        return new C2448pc(this);
    }
}
