package com.inmobi.media;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class r extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC2971z5 f2688a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ long c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(InterfaceC2971z5 interfaceC2971z5, Context context, long j) {
        super(0);
        this.f2688a = interfaceC2971z5;
        this.b = context;
        this.c = j;
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Unit invoke() {
        if (!C2849s.d.compareAndSet(false, true)) {
            InterfaceC2971z5 interfaceC2971z5 = this.f2688a;
            if (interfaceC2971z5 == null) {
                return null;
            }
            ((A5) interfaceC2971z5).c("AdAudioTracker", "Audio volume tracking is already started");
            return Unit.INSTANCE;
        }
        C2849s c2849s = C2849s.f2699a;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) AbstractC2970z4.c.getValue();
        final InterfaceC2971z5 interfaceC2971z52 = this.f2688a;
        final Context context = this.b;
        final long j = this.c;
        scheduledThreadPoolExecutor.execute(new Runnable() { // from class: com.inmobi.media.r$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                r.a(InterfaceC2971z5.this, context, j);
            }
        });
        return Unit.INSTANCE;
    }

    public static final void a(InterfaceC2971z5 interfaceC2971z5, Context context, long j) {
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("AdAudioTracker", "Starting audio volume tracking");
        }
        if (C2849s.b == null) {
            Object systemService = context.getSystemService("audio");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            C2849s.b = (AudioManager) systemService;
        }
        C2849s c2849s = C2849s.f2699a;
        C2849s.a(j);
        C2818q c2818q = new C2818q(j);
        C2849s.h = c2818q;
        Uc.f().a(new int[]{102, 101}, c2818q);
        C2849s.c = new C2769n();
        context.registerReceiver(C2849s.c, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
        C2849s.a(Float.valueOf(c2849s.a()));
    }
}
