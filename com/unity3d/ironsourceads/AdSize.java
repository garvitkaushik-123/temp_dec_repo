package com.unity3d.ironsourceads;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes7.dex */
public final class AdSize {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f6420a;
    private final int b;
    private final String c;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final AdSize banner() {
            return new AdSize(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 50, "BANNER", null);
        }

        @JvmStatic
        public final AdSize large() {
            return new AdSize(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 90, "LARGE", null);
        }

        @JvmStatic
        public final AdSize leaderboard() {
            return new AdSize(728, 90, "LEADERBOARD", null);
        }

        @JvmStatic
        public final AdSize mediumRectangle() {
            return new AdSize(300, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, "MEDIUM_RECTANGLE", null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ AdSize(int i, int i2, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, str);
    }

    @JvmStatic
    public static final AdSize banner() {
        return Companion.banner();
    }

    @JvmStatic
    public static final AdSize large() {
        return Companion.large();
    }

    @JvmStatic
    public static final AdSize leaderboard() {
        return Companion.leaderboard();
    }

    @JvmStatic
    public static final AdSize mediumRectangle() {
        return Companion.mediumRectangle();
    }

    public final int getHeight() {
        return this.b;
    }

    public final String getSizeDescription() {
        return this.c;
    }

    public final int getWidth() {
        return this.f6420a;
    }

    private AdSize(int i, int i2, String str) {
        this.f6420a = i;
        this.b = i2;
        this.c = str;
    }
}
