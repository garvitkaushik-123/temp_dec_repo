package io.bidmachine.analytics.internal;

import android.content.Context;
import io.bidmachine.analytics.ReaderConfig;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* renamed from: io.bidmachine.analytics.internal.z, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3585z extends AbstractC3564d {
    public static final a i = new a(null);
    private final File g;
    private final String h = "aints";

    /* renamed from: io.bidmachine.analytics.internal.z$a */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public C3585z(File file) {
        this.g = file;
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3570j
    public String a() {
        return this.h;
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3570j
    public void d(Context context) {
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3564d
    public File a(ReaderConfig.Rule rule) {
        return new File(this.g, s0.b(rule.getPath()));
    }
}
