package io.adn.sdk.internal.domain.model.ad;

import com.ironsource.C3040d4;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoadedFile.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÇ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001b\u001a\u00020\u001cH×\u0001J\t\u0010\u001d\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/LoadedFile;", "", "url", "", "contentType", "Lio/adn/sdk/internal/domain/model/ad/FileContentType;", C3040d4.h.b, "Ljava/io/File;", "fromCache", "", "<init>", "(Ljava/lang/String;Lio/adn/sdk/internal/domain/model/ad/FileContentType;Ljava/io/File;Z)V", "getUrl", "()Ljava/lang/String;", "getContentType", "()Lio/adn/sdk/internal/domain/model/ad/FileContentType;", "getFile", "()Ljava/io/File;", "getFromCache", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class LoadedFile {
    public static final int $stable = 8;
    private final FileContentType contentType;
    private final File file;
    private final boolean fromCache;
    private final String url;

    public static /* synthetic */ LoadedFile copy$default(LoadedFile loadedFile, String str, FileContentType fileContentType, File file, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loadedFile.url;
        }
        if ((i & 2) != 0) {
            fileContentType = loadedFile.contentType;
        }
        if ((i & 4) != 0) {
            file = loadedFile.file;
        }
        if ((i & 8) != 0) {
            z = loadedFile.fromCache;
        }
        return loadedFile.copy(str, fileContentType, file, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final FileContentType getContentType() {
        return this.contentType;
    }

    /* renamed from: component3, reason: from getter */
    public final File getFile() {
        return this.file;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getFromCache() {
        return this.fromCache;
    }

    public final LoadedFile copy(String url, FileContentType contentType, File file, boolean fromCache) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(file, "file");
        return new LoadedFile(url, contentType, file, fromCache);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadedFile)) {
            return false;
        }
        LoadedFile loadedFile = (LoadedFile) other;
        return Intrinsics.areEqual(this.url, loadedFile.url) && this.contentType == loadedFile.contentType && Intrinsics.areEqual(this.file, loadedFile.file) && this.fromCache == loadedFile.fromCache;
    }

    public int hashCode() {
        return (((((this.url.hashCode() * 31) + this.contentType.hashCode()) * 31) + this.file.hashCode()) * 31) + Boolean.hashCode(this.fromCache);
    }

    public String toString() {
        return "LoadedFile(url=" + this.url + ", contentType=" + this.contentType + ", file=" + this.file + ", fromCache=" + this.fromCache + ')';
    }

    public LoadedFile(String url, FileContentType contentType, File file, boolean z) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(file, "file");
        this.url = url;
        this.contentType = contentType;
        this.file = file;
        this.fromCache = z;
    }

    public final String getUrl() {
        return this.url;
    }

    public final FileContentType getContentType() {
        return this.contentType;
    }

    public final File getFile() {
        return this.file;
    }

    public final boolean getFromCache() {
        return this.fromCache;
    }
}
