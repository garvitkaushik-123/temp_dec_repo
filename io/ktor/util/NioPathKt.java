package io.ktor.util;

import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: NioPath.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002\u001a\f\u0010\b\u001a\u00020\u0002*\u00020\u0002H\u0002\u001a\n\u0010\t\u001a\u00020\u0002*\u00020\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\n"}, d2 = {"extension", "", "Ljava/nio/file/Path;", "getExtension", "(Ljava/nio/file/Path;)Ljava/lang/String;", "combineSafe", "Ljava/io/File;", "relativePath", "dropLeadingTopDirs", "normalizeAndRelativize", "ktor-utils"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class NioPathKt {
    public static final String getExtension(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return StringsKt.substringAfterLast$default(path.getFileName().toString(), ".", (String) null, 2, (Object) null);
    }

    public static final File combineSafe(Path path, Path relativePath) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        Path normalizeAndRelativize = normalizeAndRelativize(relativePath);
        if (normalizeAndRelativize.startsWith("..")) {
            throw new InvalidPathException(relativePath.toString(), "Relative path " + relativePath + " beginning with .. is invalid");
        }
        if (normalizeAndRelativize.isAbsolute()) {
            throw new IllegalStateException(("Bad relative path " + relativePath).toString());
        }
        File file = path.resolve(normalizeAndRelativize).toFile();
        Intrinsics.checkNotNullExpressionValue(file, "resolve(normalized).toFile()");
        return file;
    }

    public static final Path normalizeAndRelativize(Path path) {
        Path relativize;
        Path normalize;
        Path dropLeadingTopDirs;
        Intrinsics.checkNotNullParameter(path, "<this>");
        Path root = path.getRoot();
        if (root != null && (relativize = root.relativize(path)) != null && (normalize = relativize.normalize()) != null && (dropLeadingTopDirs = dropLeadingTopDirs(normalize)) != null) {
            return dropLeadingTopDirs;
        }
        Path normalize2 = path.normalize();
        Intrinsics.checkNotNullExpressionValue(normalize2, "normalize()");
        return dropLeadingTopDirs(normalize2);
    }

    private static final Path dropLeadingTopDirs(Path path) {
        Iterator it = path.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            Object next = it.next();
            if (i < 0) {
                kotlin.collections.CollectionsKt.throwIndexOverflow();
            }
            if (!Intrinsics.areEqual(((Path) next).toString(), "..")) {
                break;
            }
            i++;
        }
        if (i == 0) {
            return path;
        }
        Path subpath = path.subpath(i, path.getNameCount());
        Intrinsics.checkNotNullExpressionValue(subpath, "subpath(startIndex, nameCount)");
        return subpath;
    }

    public static final File combineSafe(File file, Path relativePath) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        Path normalizeAndRelativize = normalizeAndRelativize(relativePath);
        if (normalizeAndRelativize.startsWith("..")) {
            throw new InvalidPathException(relativePath.toString(), "Relative path " + relativePath + " beginning with .. is invalid");
        }
        if (normalizeAndRelativize.isAbsolute()) {
            throw new IllegalStateException(("Bad relative path " + relativePath).toString());
        }
        return new File(file, normalizeAndRelativize.toString());
    }
}
