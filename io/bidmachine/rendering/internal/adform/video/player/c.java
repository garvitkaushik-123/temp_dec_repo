package io.bidmachine.rendering.internal.adform.video.player;

import android.content.Context;
import io.bidmachine.rendering.internal.o;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/bidmachine/rendering/internal/adform/video/player/c;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "player", "Lio/bidmachine/rendering/internal/adform/video/player/b;", "a", "(Landroid/content/Context;Ljava/lang/String;)Lio/bidmachine/rendering/internal/adform/video/player/b;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f6954a = new c();

    private c() {
    }

    @JvmStatic
    public static final b a(Context context, String player) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual(player, "exo")) {
            o.b("PlayerFactory", "Create player (ExoPlayerImpl)", new Object[0]);
            return new io.bidmachine.rendering.internal.adform.video.player.exo.a(context);
        }
        o.b("PlayerFactory", "Create player (MediaPlayerImpl)", new Object[0]);
        return new io.bidmachine.rendering.internal.adform.video.player.media.a(context);
    }
}
