package io.bidmachine.rendering.model;

import com.ironsource.C3040d4;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.util.KeyHolder;
import io.bidmachine.util.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0011B\u0019\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lio/bidmachine/rendering/model/HorizontalGravity;", "", "Lio/bidmachine/util/KeyHolder;", "", C3040d4.h.W, "", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getKey", "()Ljava/lang/String;", "a", "Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "I", "getValue", "()I", "Companion", "Left", AndroidBridgeConstants.BANNER_POSITION_CENTER, "Right", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public enum HorizontalGravity implements KeyHolder {
    Left("left", 3),
    Center("center", 1),
    Right("right", 5);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String key;

    /* renamed from: b, reason: from kotlin metadata */
    private final int value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lio/bidmachine/rendering/model/HorizontalGravity$Companion;", "", "()V", "get", "Lio/bidmachine/rendering/model/HorizontalGravity;", C3040d4.h.W, "", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final HorizontalGravity get(String key) {
            return (HorizontalGravity) UtilsKt.find(HorizontalGravity.values(), key);
        }

        private Companion() {
        }
    }

    HorizontalGravity(String str, int i) {
        this.key = str;
        this.value = i;
    }

    @JvmStatic
    public static final HorizontalGravity get(String str) {
        return INSTANCE.get(str);
    }

    @Override // io.bidmachine.util.KeyHolder
    public String getKey() {
        return this.key;
    }

    public final int getValue() {
        return this.value;
    }
}
