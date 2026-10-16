package io.bidmachine.rendering.internal.event;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.internal.o;
import io.bidmachine.rendering.model.EventTaskParams;
import io.bidmachine.rendering.model.EventTaskType;
import io.bidmachine.rendering.model.EventType;
import io.bidmachine.rendering.model.PrivacySheetParams;
import io.bidmachine.rendering.utils.PrivacySheetParamsParser;
import io.bidmachine.util.UtilsKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007JI\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u000f\"\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0014\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0015JA\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u000f\"\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0016JA\u0010\u0017\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u000f\"\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u001f\u0010\u0014\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0018J\u001f\u0010\u0017\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J?\u0010\u0014\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u000f\"\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0019J?\u0010\u001a\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u000f\"\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u001a\u0010\u0019J'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u001bJ?\u0010\u001c\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u000f\"\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u001c\u0010\u0019J?\u0010\u0017\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u000f\"\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0019J?\u0010\u001d\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u000f\"\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u001d\u0010\u0019J1\u0010\u0017\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0017\u0010\u001eJ1\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0012\u0010\u001eJI\u0010\u0017\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u000f\"\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0013J'\u0010\u001d\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ'\u0010\u0014\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u001bJ)\u0010\u0017\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0015J)\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0015J\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\u0018JA\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0016\u0010 \u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u000f\"\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0019J'\u0010\u0017\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u001bJ3\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u000f\"\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0017\u0010\"J7\u0010\u0017\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010$\u001a\u00020#2\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u000f\"\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0017\u0010%R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010&R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010'¨\u0006("}, d2 = {"Lio/bidmachine/rendering/internal/event/a;", "Lio/bidmachine/rendering/internal/event/d;", "Lio/bidmachine/rendering/internal/event/f;", "eventTaskExecutor", "", "sourceName", "<init>", "(Lio/bidmachine/rendering/internal/event/f;Ljava/lang/String;)V", "Lio/bidmachine/rendering/model/EventType;", "eventType", "Lio/bidmachine/rendering/model/EventTaskType;", "eventTaskType", "target", "", "value", "", "params", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lio/bidmachine/rendering/model/EventType;Lio/bidmachine/rendering/model/EventTaskType;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "c", "(Lio/bidmachine/rendering/model/EventType;Lio/bidmachine/rendering/model/EventTaskType;Ljava/lang/Object;)V", "(Lio/bidmachine/rendering/model/EventType;Lio/bidmachine/rendering/model/EventTaskType;Ljava/lang/Object;[Ljava/lang/Object;)V", "a", "(Lio/bidmachine/rendering/model/EventType;Lio/bidmachine/rendering/model/EventTaskType;)V", "(Lio/bidmachine/rendering/model/EventType;Lio/bidmachine/rendering/model/EventTaskType;Ljava/lang/String;[Ljava/lang/Object;)V", InneractiveMediationDefs.GENDER_FEMALE, "(Lio/bidmachine/rendering/model/EventType;Lio/bidmachine/rendering/model/EventTaskType;Ljava/lang/String;)V", "e", "d", "(Lio/bidmachine/rendering/model/EventType;Lio/bidmachine/rendering/model/EventTaskType;Ljava/lang/String;Ljava/lang/Object;)V", "taskParametersFormat", "taskParametersArray", "parameters", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/String;", "Lio/bidmachine/rendering/model/EventTaskParams;", "eventTaskParams", "(Lio/bidmachine/rendering/model/EventType;Lio/bidmachine/rendering/model/EventTaskParams;[Ljava/lang/Object;)V", "Lio/bidmachine/rendering/internal/event/f;", "Ljava/lang/String;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final f eventTaskExecutor;

    /* renamed from: b, reason: from kotlin metadata */
    private final String sourceName;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventTaskType.values().length];
            try {
                iArr[EventTaskType.Track.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EventTaskType.Open.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EventTaskType.NotifyOpen.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EventTaskType.Skip.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EventTaskType.Close.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EventTaskType.Mute.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EventTaskType.UnMute.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[EventTaskType.Repeat.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[EventTaskType.Show.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[EventTaskType.Hide.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[EventTaskType.Progress.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[EventTaskType.Schedule.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[EventTaskType.Start.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[EventTaskType.LockVisibility.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[EventTaskType.UnlockVisibility.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[EventTaskType.SimulateClick.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[EventTaskType.OpenPrivacySheet.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[EventTaskType.ToggleStateGroups.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public a(f eventTaskExecutor, String sourceName) {
        Intrinsics.checkNotNullParameter(eventTaskExecutor, "eventTaskExecutor");
        Intrinsics.checkNotNullParameter(sourceName, "sourceName");
        this.eventTaskExecutor = eventTaskExecutor;
        this.sourceName = sourceName;
    }

    private final void b(EventType eventType, EventTaskType eventTaskType, String target, Object value, Object... params) {
        Throwable th;
        try {
            try {
                try {
                    switch (b.$EnumSwitchMapping$0[eventTaskType.ordinal()]) {
                        case 1:
                            c(eventType, eventTaskType, value);
                            return;
                        case 2:
                            b(eventType, eventTaskType, value, Arrays.copyOf(params, params.length));
                            return;
                        case 3:
                            a(eventType, eventTaskType, value, Arrays.copyOf(params, params.length));
                            return;
                        case 4:
                            c(eventType, eventTaskType);
                            return;
                        case 5:
                            a(eventType, eventTaskType);
                            return;
                        case 6:
                            c(eventType, eventTaskType, target, Arrays.copyOf(params, params.length));
                            return;
                        case 7:
                            f(eventType, eventTaskType, target, Arrays.copyOf(params, params.length));
                            return;
                        case 8:
                            b(eventType, eventTaskType, target);
                            return;
                        case 9:
                            e(eventType, eventTaskType, target, Arrays.copyOf(params, params.length));
                            return;
                        case 10:
                            a(eventType, eventTaskType, target, Arrays.copyOf(params, params.length));
                            return;
                        case 11:
                            d(eventType, eventTaskType, target, Arrays.copyOf(params, params.length));
                            return;
                        case 12:
                            a(eventType, eventTaskType, target, value);
                            return;
                        case 13:
                            b(eventType, eventTaskType, target, value);
                            return;
                        case 14:
                            a(eventType, eventTaskType, target, value, Arrays.copyOf(params, params.length));
                            return;
                        case 15:
                            d(eventType, eventTaskType, target);
                            return;
                        case 16:
                            c(eventType, eventTaskType, target);
                            return;
                        case 17:
                            a(eventType, eventTaskType, value);
                            return;
                        case 18:
                            b(eventType, eventTaskType, value);
                            return;
                        default:
                            return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        th = th4;
        th = th;
        o.b(th);
    }

    private final void c(EventType eventType, EventTaskType eventTaskType, Object value) {
        String obj = value != null ? value.toString() : null;
        if (obj == null || StringsKt.isBlank(obj)) {
            a(eventType, eventTaskType, "track url");
        } else {
            b(eventType, eventTaskType, "%s", obj);
            this.eventTaskExecutor.g(obj);
        }
    }

    private final void d(EventType eventType, EventTaskType eventTaskType, String target, Object... params) {
        if (params.length < 2) {
            a(eventType, eventTaskType, "progress parameters");
            return;
        }
        Long longOrDefault$default = UtilsKt.toLongOrDefault$default(params[0], null, 1, null);
        long longValue = longOrDefault$default != null ? longOrDefault$default.longValue() : Long.MIN_VALUE;
        Long longOrDefault$default2 = UtilsKt.toLongOrDefault$default(params[1], null, 1, null);
        long longValue2 = longOrDefault$default2 != null ? longOrDefault$default2.longValue() : Long.MIN_VALUE;
        if (longValue < 1 || longValue2 < 0) {
            a(eventType, eventTaskType, "maxProgressMs, currentProgressMs");
        } else {
            this.eventTaskExecutor.a(target, longValue, longValue2, (longValue2 * 100.0f) / longValue);
        }
    }

    private final void e(EventType eventType, EventTaskType eventTaskType, String target, Object... params) {
        b(eventType, eventTaskType, "target - %s", target);
        f fVar = this.eventTaskExecutor;
        Object firstOrNull = ArraysKt.firstOrNull(params);
        fVar.b(target, firstOrNull != null ? UtilsKt.toIntOrDefault$default(firstOrNull, null, 1, null) : null);
    }

    private final void f(EventType eventType, EventTaskType eventTaskType, String target, Object... params) {
        b(eventType, eventTaskType, "target - %s", target);
        f fVar = this.eventTaskExecutor;
        Object firstOrNull = ArraysKt.firstOrNull(params);
        fVar.d(target, firstOrNull != null ? UtilsKt.toIntOrDefault$default(firstOrNull, null, 1, null) : null);
    }

    @Override // io.bidmachine.rendering.internal.event.d
    public void a(EventType eventType, EventTaskParams eventTaskParams, Object... params) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(eventTaskParams, "eventTaskParams");
        Intrinsics.checkNotNullParameter(params, "params");
        b(eventType, eventTaskParams.getEventTaskType(), eventTaskParams.getTarget(), eventTaskParams.getValue(), Arrays.copyOf(params, params.length));
    }

    private final void a(EventType eventType, EventTaskType eventTaskType, Object value, Object... params) {
        String a2 = a(value, Arrays.copyOf(params, params.length));
        if (a2 == null || StringsKt.isBlank(a2)) {
            a(eventType, eventTaskType, "notify open url");
        } else {
            b(eventType, eventTaskType, "%s", a2);
            this.eventTaskExecutor.d(a2);
        }
    }

    private final void c(EventType eventType, EventTaskType eventTaskType) {
        b(eventType, eventTaskType);
        this.eventTaskExecutor.e();
    }

    private final void a(EventType eventType, EventTaskType eventTaskType) {
        b(eventType, eventTaskType);
        this.eventTaskExecutor.b();
    }

    private final void c(EventType eventType, EventTaskType eventTaskType, String target, Object... params) {
        b(eventType, eventTaskType, "target - %s", target);
        f fVar = this.eventTaskExecutor;
        Object firstOrNull = ArraysKt.firstOrNull(params);
        fVar.c(target, firstOrNull != null ? UtilsKt.toIntOrDefault$default(firstOrNull, null, 1, null) : null);
    }

    private final void a(EventType eventType, EventTaskType eventTaskType, String target, Object... params) {
        b(eventType, eventTaskType, "target - %s", target);
        f fVar = this.eventTaskExecutor;
        Object firstOrNull = ArraysKt.firstOrNull(params);
        fVar.a(target, firstOrNull != null ? UtilsKt.toIntOrDefault$default(firstOrNull, null, 1, null) : null);
    }

    private final void c(EventType eventType, EventTaskType eventTaskType, String target) {
        b(eventType, eventTaskType, "target - %s", target);
        this.eventTaskExecutor.f(target);
    }

    private final void a(EventType eventType, EventTaskType eventTaskType, String target, Object value) {
        Long longOrDefault$default;
        long longValue = (value == null || (longOrDefault$default = UtilsKt.toLongOrDefault$default(value, null, 1, null)) == null) ? Long.MIN_VALUE : longOrDefault$default.longValue();
        if (longValue < 0) {
            a(eventType, eventTaskType, "schedule time");
        } else {
            b(eventType, eventTaskType, "target - %s, timeMs - %s", target, Long.valueOf(longValue));
            this.eventTaskExecutor.a(target, longValue);
        }
    }

    private final void d(EventType eventType, EventTaskType eventTaskType, String target) {
        b(eventType, eventTaskType, "target - %s", target);
        this.eventTaskExecutor.e(target);
    }

    private final void a(EventType eventType, EventTaskType eventTaskType, String target, Object value, Object... params) {
        Boolean booleanOrDefault$default = UtilsKt.toBooleanOrDefault$default(value, null, 1, null);
        if (booleanOrDefault$default == null && params.length != 0) {
            booleanOrDefault$default = UtilsKt.toBooleanOrDefault$default(params[0], null, 1, null);
        }
        if (booleanOrDefault$default == null) {
            a(eventType, eventTaskType, "visibility value");
        } else {
            b(eventType, eventTaskType, "target - %s, lockVisibility - %s", target, booleanOrDefault$default);
            this.eventTaskExecutor.a(target, booleanOrDefault$default.booleanValue());
        }
    }

    private final void a(EventType eventType, EventTaskType eventTaskType, Object value) {
        String obj = value != null ? value.toString() : null;
        if (obj != null && !StringsKt.isBlank(obj)) {
            PrivacySheetParams parseJson = PrivacySheetParamsParser.parseJson(obj);
            if (parseJson == null) {
                a(eventType, eventTaskType, "value");
                return;
            } else {
                b(eventType, eventTaskType, "%s", obj);
                this.eventTaskExecutor.a(parseJson);
                return;
            }
        }
        a(eventType, eventTaskType, "value");
    }

    private final void a(EventType eventType, EventTaskType eventTaskType, String parameters) {
        o.a("Event", "Could not find required params (" + parameters + ") for execute task (" + eventType + ", " + eventTaskType + ')', new Object[0]);
    }

    private final String a(Object value, Object... params) {
        String obj = value != null ? value.toString() : null;
        if (!TextUtils.isEmpty(obj) || params.length == 0) {
            return obj;
        }
        Object obj2 = params[0];
        if (obj2 != null) {
            return obj2.toString();
        }
        return null;
    }

    private final void b(EventType eventType, EventTaskType eventTaskType, Object value, Object... params) {
        String a2 = a(value, Arrays.copyOf(params, params.length));
        if (a2 != null && !StringsKt.isBlank(a2)) {
            b(eventType, eventTaskType, "%s", a2);
            this.eventTaskExecutor.b(a2);
        } else {
            a(eventType, eventTaskType, "open url");
        }
    }

    private final void b(EventType eventType, EventTaskType eventTaskType, String target) {
        b(eventType, eventTaskType, "target - %s", target);
        this.eventTaskExecutor.c(target);
    }

    private final void b(EventType eventType, EventTaskType eventTaskType, String target, Object value) {
        String obj;
        if (value == null || (obj = value.toString()) == null) {
            return;
        }
        b(eventType, eventTaskType, "target - %s, value - %s", target, obj);
        this.eventTaskExecutor.a(target, obj);
    }

    private final void b(EventType eventType, EventTaskType eventTaskType, Object value) {
        String obj = value != null ? value.toString() : null;
        if (obj != null && !StringsKt.isBlank(obj)) {
            b(eventType, eventTaskType, "%s", obj);
            this.eventTaskExecutor.a(obj);
        } else {
            a(eventType, eventTaskType, "state groups value");
        }
    }

    private final void b(EventType eventType, EventTaskType eventTaskType) {
        b(eventType, eventTaskType, (String) null, new Object[0]);
    }

    private final void b(EventType eventType, EventTaskType eventTaskType, String taskParametersFormat, Object... taskParametersArray) {
        if (o.a()) {
            if (taskParametersFormat == null) {
                o.b("Event", "Event - " + eventType.getCom.ironsource.d4.h.W java.lang.String() + " (source - " + this.sourceName + "), Task - " + eventTaskType.getCom.ironsource.d4.h.W java.lang.String(), new Object[0]);
                return;
            }
            try {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Object[] copyOf = Arrays.copyOf(taskParametersArray, taskParametersArray.length);
                String format = String.format(taskParametersFormat, Arrays.copyOf(copyOf, copyOf.length));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                o.b("Event", "Event - " + eventType.getCom.ironsource.d4.h.W java.lang.String() + " (source - " + this.sourceName + "), Task - " + eventTaskType.getCom.ironsource.d4.h.W java.lang.String() + " (" + format + ')', new Object[0]);
            } catch (Throwable th) {
                o.b(th);
            }
        }
    }
}
