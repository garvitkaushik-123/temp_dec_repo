package io.adn.sdk.internal.common.utils;

import android.graphics.BitmapFactory;
import io.adn.sdk.internal.domain.model.ad.FileContentType;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: File.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0007"}, d2 = {"existsAndNotEmpty", "", "Ljava/io/File;", "hasValidContent", "contentType", "Lio/adn/sdk/internal/domain/model/ad/FileContentType;", "hasValidImageContent", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FileKt {

    /* compiled from: File.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FileContentType.values().length];
            try {
                iArr[FileContentType.Image.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean existsAndNotEmpty(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return file.exists() && file.isFile() && file.length() > 0;
    }

    public static final boolean hasValidContent(File file, FileContentType contentType) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        if (WhenMappings.$EnumSwitchMapping$0[contentType.ordinal()] == 1) {
            return hasValidImageContent(file);
        }
        return true;
    }

    private static final boolean hasValidImageContent(File file) {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            m10241constructorimpl = Result.m10241constructorimpl(Boolean.valueOf(options.outWidth > 0 && options.outHeight > 0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = true;
        }
        return ((Boolean) m10241constructorimpl).booleanValue();
    }
}
