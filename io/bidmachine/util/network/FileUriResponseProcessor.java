package io.bidmachine.util.network;

import android.content.Context;
import android.net.Uri;
import com.ironsource.C3040d4;
import io.bidmachine.util.file.FileUtilsKt;
import java.io.File;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileUriResponseProcessor.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lio/bidmachine/util/network/FileUriResponseProcessor;", "Lio/bidmachine/util/network/ResponseProcessor;", "Landroid/net/Uri;", "context", "Landroid/content/Context;", C3040d4.h.b, "Ljava/io/File;", "tempDir", "(Landroid/content/Context;Ljava/io/File;Ljava/io/File;)V", "fileResponseProcessor", "Lio/bidmachine/util/network/FileResponseProcessor;", "process", "urlConnection", "Ljava/net/URLConnection;", "bidmachine-android-sdk_ca_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class FileUriResponseProcessor implements ResponseProcessor<Uri> {
    private final FileResponseProcessor fileResponseProcessor;

    public FileUriResponseProcessor(Context context, File file, File file2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        this.fileResponseProcessor = new FileResponseProcessor(context, file, file2);
    }

    public /* synthetic */ FileUriResponseProcessor(Context context, File file, File file2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, file, (i & 4) != 0 ? null : file2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.util.network.ResponseProcessor
    public Uri process(URLConnection urlConnection) throws Throwable {
        Intrinsics.checkNotNullParameter(urlConnection, "urlConnection");
        return FileUtilsKt.toUri(this.fileResponseProcessor.process(urlConnection));
    }
}
