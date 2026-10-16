package com.unity3d.mediation;

import android.content.Context;
import com.ironsource.C3054e1;
import com.ironsource.C3154k0;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class LevelPlayAdSize {
    private static final int f = 320;
    private static final int g = 50;
    private static final int h = 320;
    private static final int i = 90;
    private static final int j = 300;
    private static final int k = 250;
    private static final int m = 90;

    /* renamed from: a, reason: collision with root package name */
    private int f6443a;
    private int b;
    private final String c;
    private final boolean d;
    private final LevelPlayAdSize e;
    public static final Companion Companion = new Companion(null);
    public static final LevelPlayAdSize BANNER = new LevelPlayAdSize(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 50, "BANNER", false, null, 16, null);
    public static final LevelPlayAdSize MEDIUM_RECTANGLE = new LevelPlayAdSize(300, 250, "MEDIUM_RECTANGLE", false, null, 16, null);
    private static final int l = 728;
    public static final LevelPlayAdSize LEADERBOARD = new LevelPlayAdSize(l, 90, "LEADERBOARD", false, null, 16, null);
    public static final LevelPlayAdSize LARGE = new LevelPlayAdSize(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 90, "LARGE", false, null, 16, null);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ LevelPlayAdSize createAdaptiveAdSize$default(Companion companion, Context context, Integer num, int i, Object obj) {
            if ((i & 2) != 0) {
                num = null;
            }
            return companion.createAdaptiveAdSize(context, num);
        }

        @JvmStatic
        public final LevelPlayAdSize createAdSize$mediationsdk_release(String adSize) {
            Intrinsics.checkNotNullParameter(adSize, "adSize");
            int hashCode = adSize.hashCode();
            if (hashCode != -96588539) {
                if (hashCode != 72205083) {
                    if (hashCode != 446888797) {
                        if (hashCode == 1951953708 && adSize.equals("BANNER")) {
                            return LevelPlayAdSize.BANNER;
                        }
                    } else if (adSize.equals("LEADERBOARD")) {
                        return LevelPlayAdSize.LEADERBOARD;
                    }
                } else if (adSize.equals("LARGE")) {
                    return LevelPlayAdSize.LARGE;
                }
            } else if (adSize.equals("MEDIUM_RECTANGLE")) {
                return LevelPlayAdSize.MEDIUM_RECTANGLE;
            }
            throw new IllegalArgumentException("Wrong Ad Size");
        }

        @JvmStatic
        public final LevelPlayAdSize createAdaptiveAdSize(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return createAdaptiveAdSize$default(this, context, null, 2, null);
        }

        @Deprecated(message = "Use createCustomSize instead", replaceWith = @ReplaceWith(expression = "createCustomSize(width, height)", imports = {}))
        @JvmStatic
        public final LevelPlayAdSize createCustomBanner(int i, int i2) {
            return createCustomSize(i, i2);
        }

        @JvmStatic
        public final LevelPlayAdSize createCustomSize(int i, int i2) {
            return new LevelPlayAdSize(i, i2, "CUSTOM", false, null, 16, null);
        }

        private Companion() {
        }

        @JvmStatic
        public final LevelPlayAdSize createAdaptiveAdSize(Context context, Integer num) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new C3054e1(new C3154k0()).a(context, num);
        }
    }

    public LevelPlayAdSize(int i2, int i3, String str, boolean z, LevelPlayAdSize levelPlayAdSize) {
        this.f6443a = i2;
        this.b = i3;
        this.c = str;
        this.d = z;
        this.e = levelPlayAdSize;
    }

    @JvmStatic
    public static final LevelPlayAdSize createAdaptiveAdSize(Context context) {
        return Companion.createAdaptiveAdSize(context);
    }

    @Deprecated(message = "Use createCustomSize instead", replaceWith = @ReplaceWith(expression = "createCustomSize(width, height)", imports = {}))
    @JvmStatic
    public static final LevelPlayAdSize createCustomBanner(int i2, int i3) {
        return Companion.createCustomBanner(i2, i3);
    }

    @JvmStatic
    public static final LevelPlayAdSize createCustomSize(int i2, int i3) {
        return Companion.createCustomSize(i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(LevelPlayAdSize.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.unity3d.mediation.LevelPlayAdSize");
        LevelPlayAdSize levelPlayAdSize = (LevelPlayAdSize) obj;
        return this.f6443a == levelPlayAdSize.f6443a && this.b == levelPlayAdSize.b && Intrinsics.areEqual(this.c, levelPlayAdSize.c);
    }

    public final String getDescription() {
        return String.valueOf(this.c);
    }

    public final LevelPlayAdSize getFallbackAdSize$mediationsdk_release() {
        return this.e;
    }

    public final int getHeight() {
        return this.b;
    }

    public final int getWidth() {
        return this.f6443a;
    }

    public int hashCode() {
        int i2 = ((this.f6443a * 31) + this.b) * 31;
        String str = this.c;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public final boolean isAdaptive() {
        return this.d;
    }

    public String toString() {
        return this.c + " " + this.f6443a + VastAttributes.HORIZONTAL_POSITION + this.b;
    }

    @JvmStatic
    public static final LevelPlayAdSize createAdaptiveAdSize(Context context, Integer num) {
        return Companion.createAdaptiveAdSize(context, num);
    }

    public /* synthetic */ LevelPlayAdSize(int i2, int i3, String str, boolean z, LevelPlayAdSize levelPlayAdSize, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, i3, (i4 & 4) != 0 ? null : str, z, (i4 & 16) != 0 ? null : levelPlayAdSize);
    }
}
