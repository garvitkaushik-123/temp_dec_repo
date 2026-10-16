package io.bidmachine.rendering.model;

import androidx.core.app.NotificationCompat;
import com.ironsource.C3040d4;
import com.ironsource.C3207n2;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.bidmachine.iab.vast.tags.VastTagName;
import io.bidmachine.util.KeyHolder;
import io.bidmachine.util.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lio/bidmachine/rendering/model/EventTaskType;", "", "Lio/bidmachine/util/KeyHolder;", "", C3040d4.h.W, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "a", "Ljava/lang/String;", "Companion", "Track", "Open", "NotifyOpen", "Skip", "Close", VastTagName.MUTE, "UnMute", "Repeat", "Show", "Hide", VastTagName.PROGRESS, "Schedule", "Start", "LockVisibility", "UnlockVisibility", "SimulateClick", "OpenPrivacySheet", "ToggleStateGroups", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public enum EventTaskType implements KeyHolder {
    Track("track"),
    Open("open"),
    NotifyOpen("notify_open"),
    Skip("skip"),
    Close("close"),
    Mute(CampaignEx.JSON_NATIVE_VIDEO_MUTE),
    UnMute(CampaignEx.JSON_NATIVE_VIDEO_UNMUTE),
    Repeat("repeat"),
    Show(C3207n2.v),
    Hide("hide"),
    Progress(NotificationCompat.CATEGORY_PROGRESS),
    Schedule("schedule"),
    Start("start"),
    LockVisibility("lock_visibility"),
    UnlockVisibility("unlock_visibility"),
    SimulateClick("simulate_click"),
    OpenPrivacySheet("open_privacy_sheet"),
    ToggleStateGroups("toggle_state_groups");


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String key;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lio/bidmachine/rendering/model/EventTaskType$Companion;", "", "()V", "get", "Lio/bidmachine/rendering/model/EventTaskType;", C3040d4.h.W, "", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final EventTaskType get(String key) {
            return (EventTaskType) UtilsKt.find(EventTaskType.values(), key);
        }

        private Companion() {
        }
    }

    EventTaskType(String str) {
        this.key = str;
    }

    @JvmStatic
    public static final EventTaskType get(String str) {
        return INSTANCE.get(str);
    }

    @Override // io.bidmachine.util.KeyHolder
    public String getKey() {
        return this.key;
    }
}
