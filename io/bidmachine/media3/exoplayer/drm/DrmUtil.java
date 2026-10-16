package io.bidmachine.media3.exoplayer.drm;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import com.google.common.io.ByteStreams;
import io.bidmachine.media3.common.util.Util;
import io.bidmachine.media3.datasource.DataSource;
import io.bidmachine.media3.datasource.DataSourceInputStream;
import io.bidmachine.media3.datasource.DataSpec;
import io.bidmachine.media3.datasource.HttpDataSource;
import io.bidmachine.media3.datasource.StatsDataSource;
import io.bidmachine.media3.exoplayer.drm.DefaultDrmSessionManager;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public final class DrmUtil {
    public static final int ERROR_SOURCE_EXO_MEDIA_DRM = 1;
    public static final int ERROR_SOURCE_LICENSE_ACQUISITION = 2;
    public static final int ERROR_SOURCE_PROVISIONING = 3;
    private static final int MAX_MANUAL_REDIRECTS = 5;

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorSource {
    }

    public static int getErrorCodeForMediaDrmException(Throwable th, int i) {
        if (th instanceof MediaDrm.MediaDrmStateException) {
            return Util.getErrorCodeForMediaDrmErrorCode(Util.getErrorCodeFromPlatformDiagnosticsInfo(((MediaDrm.MediaDrmStateException) th).getDiagnosticInfo()));
        }
        if (Util.SDK_INT >= 23 && Api23.isMediaDrmResetException(th)) {
            return 6006;
        }
        if ((th instanceof NotProvisionedException) || isFailureToConstructNotProvisionedException(th)) {
            return 6002;
        }
        if (th instanceof DeniedByServerException) {
            return 6007;
        }
        if (th instanceof UnsupportedDrmException) {
            return 6001;
        }
        if (th instanceof DefaultDrmSessionManager.MissingSchemeDataException) {
            return 6003;
        }
        if (th instanceof KeysExpiredException) {
            return 6008;
        }
        if (i == 1) {
            return 6006;
        }
        if (i == 2) {
            return 6004;
        }
        if (i == 3) {
            return 6002;
        }
        throw new IllegalArgumentException();
    }

    public static boolean isFailureToConstructNotProvisionedException(Throwable th) {
        return Util.SDK_INT == 34 && (th instanceof NoSuchMethodError) && th.getMessage() != null && th.getMessage().contains("Landroid/media/NotProvisionedException;.<init>(");
    }

    public static boolean isFailureToConstructResourceBusyException(Throwable th) {
        return Util.SDK_INT == 34 && (th instanceof NoSuchMethodError) && th.getMessage() != null && th.getMessage().contains("Landroid/media/ResourceBusyException;.<init>(");
    }

    public static byte[] executePost(DataSource dataSource, String str, byte[] bArr, Map<String, String> map) throws MediaDrmCallbackException {
        StatsDataSource statsDataSource = new StatsDataSource(dataSource);
        DataSpec build = new DataSpec.Builder().setUri(str).setHttpRequestHeaders(map).setHttpMethod(2).setHttpBody(bArr).setFlags(1).build();
        int i = 0;
        DataSpec dataSpec = build;
        while (true) {
            try {
                DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(statsDataSource, dataSpec);
                try {
                    try {
                        byte[] byteArray = ByteStreams.toByteArray(dataSourceInputStream);
                        Util.closeQuietly(dataSourceInputStream);
                        return byteArray;
                    } catch (HttpDataSource.InvalidResponseCodeException e) {
                        String redirectUrl = getRedirectUrl(e, i);
                        if (redirectUrl == null) {
                            throw e;
                        }
                        i++;
                        dataSpec = dataSpec.buildUpon().setUri(redirectUrl).build();
                        Util.closeQuietly(dataSourceInputStream);
                    }
                } catch (Throwable th) {
                    Util.closeQuietly(dataSourceInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                throw new MediaDrmCallbackException(build, statsDataSource.getLastOpenedUri(), statsDataSource.getResponseHeaders(), statsDataSource.getBytesRead(), e2);
            }
        }
    }

    private static String getRedirectUrl(HttpDataSource.InvalidResponseCodeException invalidResponseCodeException, int i) {
        Map<String, List<String>> map;
        List<String> list;
        if ((invalidResponseCodeException.responseCode != 307 && invalidResponseCodeException.responseCode != 308) || i >= 5 || (map = invalidResponseCodeException.headerFields) == null || (list = map.get("Location")) == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private static final class Api23 {
        private Api23() {
        }

        public static boolean isMediaDrmResetException(Throwable th) {
            return th instanceof MediaDrmResetException;
        }
    }

    private DrmUtil() {
    }
}
