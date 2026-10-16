package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.demandOnly.h;
import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public interface q {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f3528a;

        public a(String adFormat) {
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            this.f3528a = adFormat;
        }

        public final IronSourceError a(h loadParams) {
            Intrinsics.checkNotNullParameter(loadParams, "loadParams");
            h.b bVar = (h.b) loadParams;
            if (bVar.f() == null) {
                return new IronSourceError(1060, this.f3528a + " was initialized and loaded without Activity");
            }
            if (bVar.g() == null) {
                return new IronSourceError(510, "Missing banner layout");
            }
            if (bVar.g().isDestroyed()) {
                return new IronSourceError(510, "Banner layout is destroyed");
            }
            ISBannerSize size = bVar.g().getSize();
            if (size == null) {
                return new IronSourceError(510, "Missing banner size");
            }
            if ("CUSTOM" == size.getDescription() && (size.getHeight() <= 0 || size.getWidth() <= 0)) {
                return new IronSourceError(510, "Unsupported banner size. Height and width must be bigger than 0");
            }
            if (bVar.e() == null) {
                return new IronSourceError(510, "Missing instance Id");
            }
            String b = bVar.b();
            if ((b == null || b.length() == 0) && loadParams.c()) {
                return new IronSourceError(510, "Missing adm");
            }
            return null;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f3529a;

        public b(String adFormat) {
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            this.f3529a = adFormat;
        }

        public final IronSourceError a(h.d loadParams) {
            Intrinsics.checkNotNullParameter(loadParams, "loadParams");
            if (loadParams.d() == null) {
                return new IronSourceError(1060, this.f3529a + " was initialized and loaded without Activity");
            }
            if (loadParams.e() == null) {
                return new IronSourceError(510, "Missing instance Id");
            }
            String b = loadParams.b();
            if ((b == null || b.length() == 0) && loadParams.c()) {
                return new IronSourceError(510, "Missing adm");
            }
            return null;
        }
    }

    IronSourceError a();
}
