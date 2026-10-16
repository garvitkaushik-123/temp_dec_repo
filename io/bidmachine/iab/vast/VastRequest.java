package io.bidmachine.iab.vast;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import io.bidmachine.iab.CacheControl;
import io.bidmachine.iab.IabError;
import io.bidmachine.iab.measurer.MraidAdMeasurer;
import io.bidmachine.iab.measurer.VastAdMeasurer;
import io.bidmachine.iab.utils.Utils;
import io.bidmachine.iab.vast.VastUrlProcessorRegistry;
import io.bidmachine.iab.vast.activity.VastActivity;
import io.bidmachine.iab.vast.activity.VastView;
import io.bidmachine.iab.vast.processor.DefaultMediaPicker;
import io.bidmachine.iab.vast.processor.VastAd;
import io.bidmachine.iab.vast.processor.VastMediaPicker;
import io.bidmachine.iab.vast.processor.VastProcessor;
import io.bidmachine.iab.vast.processor.VastProcessorResult;
import io.bidmachine.iab.vast.tags.AppodealExtensionTag;
import io.bidmachine.iab.vast.tags.MediaFileTag;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
public class VastRequest {
    public static final String PARAMS_ERROR_CODE = "params_error_code";
    private Uri c;
    private VastAd d;
    private Bundle f;
    private VastMediaPicker<MediaFileTag> g;
    private VastVideoLoadedListener h;
    private VastAdMeasurer i;
    private Float k;
    private float l;
    private boolean m;
    private int n;
    private boolean p;
    private static final VastUrlProcessorRegistry.OnUrlReadyCallback z = new k();
    private static int A = 5;
    private CacheControl b = CacheControl.FullLoad;
    private VideoType e = VideoType.NonRewarded;
    private float j = 3.0f;
    private int o = 0;
    private boolean q = false;
    private boolean r = true;
    private boolean s = true;
    private boolean t = false;
    private boolean u = false;
    private int v = -1;
    private float w = 5.0f;
    private final AtomicBoolean x = new AtomicBoolean(false);
    private final AtomicBoolean y = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    private final String f6868a = UUID.randomUUID().toString();

    public class Builder {
        public Builder() {
        }

        public Builder addExtra(String key, String value) {
            VastRequest.this.addExtra(key, value);
            return this;
        }

        public VastRequest build() {
            return VastRequest.this;
        }

        public Builder forceUseNativeCloseTime(boolean forceUseNativeCloseTime) {
            VastRequest.this.m = forceUseNativeCloseTime;
            return this;
        }

        public Builder setAdMeasurer(VastAdMeasurer vastAdMeasurer) {
            VastRequest.this.i = vastAdMeasurer;
            return this;
        }

        public Builder setAutoClose(boolean autoClose) {
            VastRequest.this.p = autoClose;
            return this;
        }

        public Builder setCacheControl(CacheControl cacheControl) {
            VastRequest.this.b = cacheControl;
            return this;
        }

        public Builder setCompanionCloseTime(int closeTime) {
            VastRequest.this.l = closeTime;
            return this;
        }

        public Builder setMaxDuration(int maxDurationMillis) {
            VastRequest.this.n = maxDurationMillis;
            return this;
        }

        public Builder setMediaFilePicker(VastMediaPicker<MediaFileTag> mediaFilePicker) {
            VastRequest.this.g = mediaFilePicker;
            return this;
        }

        public Builder setPlaceholderTimeoutSec(float placeholderTimeoutSec) {
            VastRequest.this.j = placeholderTimeoutSec;
            return this;
        }

        public Builder setPreloadCompanion(boolean preload) {
            VastRequest.this.s = preload;
            return this;
        }

        public Builder setUseScreenSizeForCompanionOrientation(boolean use) {
            VastRequest.this.r = use;
            return this;
        }

        public Builder setUseScreenSizeForVideoOrientation(boolean use) {
            VastRequest.this.q = use;
            return this;
        }

        public Builder setVideoCloseTime(int closeTimeSec) {
            VastRequest.this.k = Float.valueOf(closeTimeSec);
            return this;
        }
    }

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6870a;

        static {
            int[] iArr = new int[CacheControl.values().length];
            f6870a = iArr;
            try {
                iArr[CacheControl.FullLoad.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6870a[CacheControl.Stream.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6870a[CacheControl.PartialLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    class b extends Thread {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6871a;
        final /* synthetic */ VastRequestListener b;
        final /* synthetic */ Context c;

        b(final String val$urlString, final VastRequestListener val$vastRequestListener, final Context val$context) {
            this.f6871a = val$urlString;
            this.b = val$vastRequestListener;
            this.c = val$context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            BufferedReader bufferedReader;
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new URL(this.f6871a).openStream()));
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        stringBuffer.append(readLine).append(System.getProperty("line.separator"));
                    } else {
                        try {
                            break;
                        } catch (IOException unused) {
                        }
                    }
                }
                bufferedReader.close();
                VastRequest.this.loadVideoWithData(this.c, stringBuffer.toString(), this.b);
            } catch (Exception e2) {
                e = e2;
                bufferedReader2 = bufferedReader;
                VastLog.e("VastRequest", e);
                VastRequest.this.sendVastSpecError(VastSpecError.XML_PARSING);
                VastRequest.this.a(IabError.throwable("Exception during loading xml by url", e), this.b);
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused2) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        }
    }

    class c extends Thread {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f6872a;
        final /* synthetic */ String b;
        final /* synthetic */ VastRequestListener c;

        c(final Context val$context, final String val$xmlData, final VastRequestListener val$vastRequestListener) {
            this.f6872a = val$context;
            this.b = val$xmlData;
            this.c = val$vastRequestListener;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            VastRequest.this.loadVideoWithDataSync(this.f6872a, this.b, this.c);
        }
    }

    class d extends Thread {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f6873a;
        final /* synthetic */ VastRequestListener b;

        d(final Context val$context, final VastRequestListener val$vastRequestListener) {
            this.f6873a = val$context;
            this.b = val$vastRequestListener;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            VastRequest vastRequest = VastRequest.this;
            vastRequest.a(this.f6873a, vastRequest.d, this.b);
        }
    }

    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VastRequestListener f6874a;

        e(final VastRequestListener val$vastRequestListener) {
            this.f6874a = val$vastRequestListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6874a.onVastLoaded(VastRequest.this);
        }
    }

    class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IabError f6875a;
        final /* synthetic */ VastRequestListener b;

        f(final IabError val$iabError, final VastRequestListener val$vastRequestListener) {
            this.f6875a = val$iabError;
            this.b = val$vastRequestListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VastRequest.this.i != null) {
                VastRequest.this.i.onError(this.f6875a);
            }
            if (this.b != null) {
                if (VastRequest.this.b != CacheControl.PartialLoad || !VastRequest.this.x.get() || VastRequest.this.y.get()) {
                    this.b.onVastLoadFailed(VastRequest.this, this.f6875a);
                    return;
                }
                VastRequestListener vastRequestListener = this.b;
                VastRequest vastRequest = VastRequest.this;
                vastRequestListener.onVastLoadFailed(vastRequest, IabError.expired(String.format("%s load failed after display - %s", vastRequest.b, this.f6875a)));
            }
        }
    }

    class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VastActivityListener f6876a;
        final /* synthetic */ IabError b;

        g(final VastActivityListener val$vastActivityListener, final IabError val$iabError) {
            this.f6876a = val$vastActivityListener;
            this.b = val$iabError;
        }

        @Override // java.lang.Runnable
        public void run() {
            VastActivityListener vastActivityListener = this.f6876a;
            if (vastActivityListener != null) {
                vastActivityListener.onVastShowFailed(VastRequest.this, this.b);
            }
        }
    }

    class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VastViewListener f6877a;
        final /* synthetic */ VastView b;
        final /* synthetic */ IabError c;

        h(final VastViewListener val$vastViewListener, final VastView val$vastView, final IabError val$iabError) {
            this.f6877a = val$vastViewListener;
            this.b = val$vastView;
            this.c = val$iabError;
        }

        @Override // java.lang.Runnable
        public void run() {
            VastViewListener vastViewListener = this.f6877a;
            if (vastViewListener != null) {
                vastViewListener.onShowFailed(this.b, VastRequest.this, this.c);
            }
        }
    }

    class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VastAd f6878a;

        i(final VastAd val$vastAd) {
            this.f6878a = val$vastAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VastRequest.this.h != null) {
                VastRequest.this.h.onSuccess(VastRequest.this, this.f6878a);
            }
        }
    }

    class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IabError f6879a;

        j(final IabError val$iabError) {
            this.f6879a = val$iabError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VastRequest.this.h != null) {
                VastRequest.this.h.onError(VastRequest.this, this.f6879a);
            }
        }
    }

    static class k implements VastUrlProcessorRegistry.OnUrlReadyCallback {
        k() {
        }

        @Override // io.bidmachine.iab.vast.VastUrlProcessorRegistry.OnUrlReadyCallback
        public void onUrlReady(String url) {
            VastLog.d("VastRequest", "Fire url: %s", url);
            Utils.simpleTrackUrl(url);
        }
    }

    static class l implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        public long f6880a;
        public File b;

        public l(File file) {
            this.b = file;
            this.f6880a = file.lastModified();
        }

        @Override // java.lang.Comparable
        public int compareTo(Object o) {
            long j = this.f6880a;
            long j2 = ((l) o).f6880a;
            if (j > j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }
    }

    private VastRequest() {
    }

    public static Builder newBuilder() {
        return new VastRequest().new Builder();
    }

    public static void setCacheSize(int cacheSize) {
        if (cacheSize > 0) {
            A = cacheSize;
        }
    }

    public void addExtra(String key, String value) {
        if (this.f == null) {
            this.f = new Bundle();
        }
        this.f.putString(key, value);
    }

    public boolean canDisplay() {
        if (this.x.get()) {
            return this.b != CacheControl.FullLoad || checkFile();
        }
        return false;
    }

    public boolean checkFile() {
        try {
            Uri uri = this.c;
            if (uri == null || TextUtils.isEmpty(uri.getPath())) {
                return false;
            }
            return new File(this.c.getPath()).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public void destroy() {
        this.h = null;
        VastRequestManager.a(this);
    }

    public void display(Context context, VideoType videoType, VastActivityListener vastActivityListener) {
        display(context, videoType, vastActivityListener, null, null, null);
    }

    public void fireErrorUrls(List<String> urls, Bundle params) {
        fireUrls(urls, params);
    }

    public void fireUrls(List<String> urls, Bundle params) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (params != null) {
            bundle.putAll(params);
        }
        if (urls != null) {
            VastUrlProcessorRegistry.processUrls(urls, bundle, z);
        } else {
            VastLog.d("VastRequest", "Url list is null", new Object[0]);
        }
    }

    public CacheControl getCacheControl() {
        return this.b;
    }

    public float getCompanionCloseTime() {
        return this.l;
    }

    public Uri getFileUri() {
        return this.c;
    }

    public int getForceOrientation() {
        return this.v;
    }

    public float getFusedVideoCloseTimeSec() {
        return this.w;
    }

    public String getId() {
        return this.f6868a;
    }

    public int getMaxDurationMillis() {
        return this.n;
    }

    public float getPlaceholderTimeoutSec() {
        return this.j;
    }

    public int getPreferredVideoOrientation() {
        if (!shouldUseScreenSizeForVideoOrientation()) {
            return 0;
        }
        VastAd vastAd = this.d;
        if (vastAd == null) {
            return 2;
        }
        MediaFileTag pickedMediaFileTag = vastAd.getPickedMediaFileTag();
        return Utils.orientationBySize(pickedMediaFileTag.getWidth(), pickedMediaFileTag.getHeight());
    }

    public int getRequestedOrientation() {
        return this.o;
    }

    public VastAd getVastAd() {
        return this.d;
    }

    public Float getVideoCloseTime() {
        return this.k;
    }

    public VideoType getVideoType() {
        return this.e;
    }

    public boolean isAutoClose() {
        return this.p;
    }

    public boolean isForceUseNativeCloseTime() {
        return this.m;
    }

    public boolean isR1() {
        return this.t;
    }

    public boolean isR2() {
        return this.u;
    }

    public void loadVideoWithData(final Context context, final String xmlData, final VastRequestListener vastRequestListener) {
        VastLog.d("VastRequest", "loadVideoWithData\n%s", xmlData);
        this.d = null;
        if (!Utils.isNetworkAvailable(context)) {
            a(IabError.NO_NETWORK, vastRequestListener);
            return;
        }
        try {
            new c(context, xmlData, vastRequestListener).start();
        } catch (Exception e2) {
            VastLog.e("VastRequest", e2);
            a(IabError.throwable("Exception during creating background thread", e2), vastRequestListener);
        }
    }

    public void loadVideoWithDataSync(final Context context, final String xmlData, final VastRequestListener vastRequestListener) {
        String str;
        VastMediaPicker vastMediaPicker = this.g;
        if (vastMediaPicker == null) {
            vastMediaPicker = new DefaultMediaPicker(context);
        }
        VastProcessorResult process = new VastProcessor(this, vastMediaPicker).process(xmlData);
        VastAd vastAd = process.getVastAd();
        this.d = vastAd;
        if (vastAd == null) {
            VastSpecError vastSpecError = process.getVastSpecError();
            if (vastSpecError != null) {
                sendVastSpecError(vastSpecError);
                str = String.format("VastAd is null during loadVideoWithDataSync with VastSpecCode - %s", Integer.valueOf(vastSpecError.getCode()));
            } else {
                str = "VastAd is null during loadVideoWithDataSync without VastSpecCode";
            }
            a(IabError.badContent(str), vastRequestListener);
            return;
        }
        vastAd.setVastRequest(this);
        AppodealExtensionTag appodealExtension = this.d.getAppodealExtension();
        if (appodealExtension != null) {
            Boolean isAutoRotate = appodealExtension.isAutoRotate();
            if (isAutoRotate != null) {
                if (isAutoRotate.booleanValue()) {
                    this.q = false;
                    this.r = false;
                } else {
                    this.q = true;
                    this.r = true;
                }
            }
            if (appodealExtension.getPostBannerTag().getCloseTimeSec() > 0.0f) {
                this.l = appodealExtension.getPostBannerTag().getCloseTimeSec();
            }
            this.t = appodealExtension.isR1();
            this.u = appodealExtension.isR2();
            Integer forceOrientation = appodealExtension.getForceOrientation();
            if (forceOrientation != null) {
                this.v = forceOrientation.intValue();
            }
        }
        this.w = a(this.d, appodealExtension).floatValue();
        VastAdMeasurer vastAdMeasurer = this.i;
        if (vastAdMeasurer != null) {
            vastAdMeasurer.onVastModelLoaded(this);
        }
        int i2 = a.f6870a[this.b.ordinal()];
        if (i2 == 1) {
            a(context, this.d, vastRequestListener);
            return;
        }
        if (i2 == 2) {
            a(vastRequestListener);
        } else {
            if (i2 != 3) {
                return;
            }
            a(vastRequestListener);
            a(context, this.d, vastRequestListener);
        }
    }

    public void loadVideoWithUrl(final Context context, final String urlString, final VastRequestListener vastRequestListener) {
        VastLog.d("VastRequest", "loadVideoWithUrl - %s", urlString);
        this.d = null;
        if (!Utils.isNetworkAvailable(context)) {
            a(IabError.NO_NETWORK, vastRequestListener);
            return;
        }
        try {
            new b(urlString, vastRequestListener, context).start();
        } catch (Exception e2) {
            VastLog.e("VastRequest", e2);
            a(IabError.throwable("Exception during creating background thread", e2), vastRequestListener);
        }
    }

    public void performCache(final Context context, final VastRequestListener vastRequestListener) {
        if (this.d == null) {
            a(IabError.internal("VastAd is null during performCache"), vastRequestListener);
            return;
        }
        try {
            new d(context, vastRequestListener).start();
        } catch (Exception e2) {
            VastLog.e("VastRequest", e2);
            a(IabError.throwable("Exception during creating background thread", e2), vastRequestListener);
        }
    }

    public void sendVastSpecError(VastSpecError vastSpecError) {
        VastLog.d("VastRequest", "sendVastSpecError - %s", vastSpecError);
        try {
            if (this.d != null) {
                Bundle bundle = new Bundle();
                bundle.putInt(PARAMS_ERROR_CODE, vastSpecError.getCode());
                fireErrorUrls(this.d.getErrorUrlList(), bundle);
            }
        } catch (Exception e2) {
            VastLog.e("VastRequest", e2);
        }
    }

    public synchronized void setVastVideoLoadedListener(VastVideoLoadedListener vastVideoLoadedListener) {
        this.h = vastVideoLoadedListener;
    }

    public boolean shouldPreloadCompanion() {
        return this.s;
    }

    public boolean shouldUseScreenSizeForCompanionOrientation() {
        return this.r;
    }

    public boolean shouldUseScreenSizeForVideoOrientation() {
        return this.q;
    }

    public void display(Context context, VideoType videoType, VastActivityListener vastActivityListener, VastView vastView, VastPlaybackListener vastPlaybackListener, MraidAdMeasurer postBannerAdMeasurer) {
        VastLog.d("VastRequest", "display", new Object[0]);
        this.y.set(true);
        if (this.d == null) {
            a(IabError.internal("VastAd is null during display VastActivity"), vastActivityListener);
            return;
        }
        this.e = videoType;
        this.o = context.getResources().getConfiguration().orientation;
        IabError display = new VastActivity.Builder().setRequest(this).setListener(vastActivityListener).setVastView(vastView).setPlaybackListener(vastPlaybackListener).setAdMeasurer(this.i).setPostBannerAdMeasurer(postBannerAdMeasurer).display(context);
        if (display != null) {
            a(display, vastActivityListener);
        }
    }

    private String b(Context context) {
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            return externalFilesDir.getPath() + "/vast_rtb_cache/";
        }
        return null;
    }

    private Float a(VastAd vastAd, VastExtension vastExtension) {
        Float closeTimeSec = vastExtension != null ? vastExtension.getCloseTimeSec() : null;
        if (isForceUseNativeCloseTime()) {
            closeTimeSec = Utils.max(closeTimeSec, getVideoCloseTime());
        }
        Float min = Utils.min(closeTimeSec, vastAd.getDurationSec());
        return min == null ? Float.valueOf(5.0f) : min;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, VastAd vastAd, VastRequestListener vastRequestListener) {
        try {
            Uri a2 = a(context, vastAd.getPickedMediaFileTag().getText());
            if (a2 != null && !TextUtils.isEmpty(a2.getPath()) && new File(a2.getPath()).exists()) {
                Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(a2.getPath(), 1);
                if (createVideoThumbnail != null) {
                    if (!createVideoThumbnail.equals(Bitmap.createBitmap(createVideoThumbnail.getWidth(), createVideoThumbnail.getHeight(), createVideoThumbnail.getConfig()))) {
                        try {
                            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                            mediaMetadataRetriever.setDataSource(context, a2);
                            long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                            int i2 = this.n;
                            if (i2 != 0 && parseLong > i2) {
                                sendVastSpecError(VastSpecError.DURATION);
                                a(IabError.badContent("Estimated duration does not match actual duration"), vastRequestListener);
                            }
                            this.c = a2;
                            a(vastAd);
                            a(vastRequestListener);
                        } catch (Exception e2) {
                            VastLog.e("VastRequest", e2);
                            sendVastSpecError(VastSpecError.BAD_FILE);
                            a(IabError.throwable("Exception during metadata retrieval", e2), vastRequestListener);
                        }
                    } else {
                        VastLog.d("VastRequest", "Empty thumbnail", new Object[0]);
                        sendVastSpecError(VastSpecError.BAD_FILE);
                        a(IabError.badContent("Thumbnail is empty"), vastRequestListener);
                    }
                } else {
                    VastLog.d("VastRequest", "Video file not supported", new Object[0]);
                    sendVastSpecError(VastSpecError.BAD_FILE);
                    a(IabError.badContent("Failed to get thumbnail by file URI"), vastRequestListener);
                }
                a(context);
                return;
            }
            VastLog.d("VastRequest", "fileUri is null", new Object[0]);
            sendVastSpecError(VastSpecError.BAD_URI);
            a(IabError.badContent("Can't find video by local URI"), vastRequestListener);
        } catch (Exception e3) {
            VastLog.e("VastRequest", e3);
            sendVastSpecError(VastSpecError.BAD_URI);
            a(IabError.throwable("Exception during caching media file", e3), vastRequestListener);
        }
    }

    public void display(VastView vastView) {
        this.y.set(true);
        if (this.d == null) {
            a(IabError.internal("VastAd is null during display VastView"), vastView, vastView.getListener());
            return;
        }
        this.e = VideoType.NonRewarded;
        VastRequestManager.store(this);
        vastView.display(this, Boolean.FALSE);
    }

    private Uri a(Context context, String pickedMediaFileURL) {
        String b2 = b(context);
        if (b2 != null) {
            File file = new File(b2);
            if (!file.exists()) {
                file.mkdirs();
            }
            int length = 230 - file.getPath().length();
            String str = "temp" + System.currentTimeMillis();
            String replace = pickedMediaFileURL.substring(0, Math.min(length, pickedMediaFileURL.length())).replace(RemoteSettings.FORWARD_SLASH_STRING, "").replace(":", "");
            File file2 = new File(file, replace);
            if (file2.exists()) {
                return Uri.fromFile(file2);
            }
            File file3 = new File(file, str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(pickedMediaFileURL).openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(file3);
            long contentLength = httpURLConnection.getContentLength();
            byte[] bArr = new byte[1024];
            long j2 = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
                j2 += read;
            }
            fileOutputStream.close();
            if (contentLength == j2) {
                file3.renameTo(new File(file, replace));
                return Uri.fromFile(new File(file, replace));
            }
            throw new IllegalStateException("The downloaded file size does not match the stated size");
        }
        throw new FileNotFoundException("No dir for caching file");
    }

    private void a(Context context) {
        File[] listFiles;
        try {
            String b2 = b(context);
            if (b2 == null || (listFiles = new File(b2).listFiles()) == null || listFiles.length <= A) {
                return;
            }
            l[] lVarArr = new l[listFiles.length];
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                lVarArr[i2] = new l(listFiles[i2]);
            }
            Arrays.sort(lVarArr);
            for (int i3 = 0; i3 < listFiles.length; i3++) {
                listFiles[i3] = lVarArr[i3].b;
            }
            for (int i4 = A; i4 < listFiles.length; i4++) {
                if (!Uri.fromFile(listFiles[i4]).equals(this.c)) {
                    listFiles[i4].delete();
                }
            }
        } catch (Exception e2) {
            VastLog.e("VastRequest", e2);
        }
    }

    private void a(final VastRequestListener vastRequestListener) {
        if (this.x.getAndSet(true)) {
            return;
        }
        VastLog.d("VastRequest", "sendLoaded", new Object[0]);
        if (vastRequestListener != null) {
            Utils.onUiThread(new e(vastRequestListener));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IabError iabError, VastRequestListener vastRequestListener) {
        VastLog.d("VastRequest", "sendLoadFailed - %s", iabError);
        a(iabError);
        Utils.onUiThread(new f(iabError, vastRequestListener));
    }

    private void a(IabError iabError, VastActivityListener vastActivityListener) {
        VastLog.d("VastRequest", "sendShowFailed - %s", iabError);
        Utils.onUiThread(new g(vastActivityListener, iabError));
    }

    private void a(IabError iabError, VastView vastView, VastViewListener vastViewListener) {
        VastLog.d("VastRequest", "sendShowFailed - %s", iabError);
        Utils.onUiThread(new h(vastViewListener, vastView, iabError));
    }

    private synchronized void a(final VastAd vastAd) {
        if (this.h == null) {
            return;
        }
        Utils.onUiThread(new i(vastAd));
    }

    private synchronized void a(IabError iabError) {
        if (this.h == null) {
            return;
        }
        Utils.onUiThread(new j(iabError));
    }
}
