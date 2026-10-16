package io.bidmachine.rendering.model;

import com.ironsource.C3040d4;
import io.bidmachine.util.KeyHolder;
import io.bidmachine.util.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lio/bidmachine/rendering/model/EventType;", "", "Lio/bidmachine/util/KeyHolder;", "", C3040d4.h.W, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "a", "Ljava/lang/String;", "Companion", "OnImpression", "OnClick", "OnMute", "OnUnMute", "OnPause", "OnResume", "OnSkip", "OnClose", "OnStart", "OnFirstQuartile", "OnMidpoint", "OnThirdQuartile", "OnComplete", "OnProgress", "OnUseCustomClose", "OnScheduled", "OnNavigate", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public enum EventType implements KeyHolder {
    OnImpression("on_impression"),
    OnClick("on_click"),
    OnMute("on_mute"),
    OnUnMute("on_unmute"),
    OnPause("on_pause"),
    OnResume("on_resume"),
    OnSkip("on_skip"),
    OnClose("on_close"),
    OnStart("on_start"),
    OnFirstQuartile("on_first_quartile"),
    OnMidpoint("on_midpoint"),
    OnThirdQuartile("on_third_quartile"),
    OnComplete("on_complete"),
    OnProgress("on_progress"),
    OnUseCustomClose("on_use_custom_close"),
    OnScheduled("on_scheduled"),
    OnNavigate("on_navigate");


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String key;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lio/bidmachine/rendering/model/EventType$Companion;", "", "()V", "get", "Lio/bidmachine/rendering/model/EventType;", C3040d4.h.W, "", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final EventType get(String key) {
            return (EventType) UtilsKt.find(EventType.values(), key);
        }

        private Companion() {
        }
    }

    EventType(String str) {
        this.key = str;
    }

    @JvmStatic
    public static final EventType get(String str) {
        return INSTANCE.get(str);
    }

    @Override // io.bidmachine.util.KeyHolder
    public String getKey() {
        return this.key;
    }
}
