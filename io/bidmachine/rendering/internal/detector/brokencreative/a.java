package io.bidmachine.rendering.internal.detector.brokencreative;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import io.bidmachine.rendering.internal.o;
import io.bidmachine.rendering.model.BrokenCreativeAlgorithmParams;
import io.bidmachine.rendering.model.BrokenCreativeAlgorithmResult;
import io.bidmachine.rendering.model.BrokenCreativeDetectorParams;
import io.bidmachine.rendering.model.BrokenCreativeEvent;
import io.bidmachine.rendering.model.StopDetectorAfter;
import io.bidmachine.util.ImageUtilsKt;
import io.bidmachine.util.taskmanager.CancelableTask;
import io.bidmachine.util.taskmanager.coroutine.CoroutineTaskManager;
import io.bidmachine.util.taskmanager.handler.HandlerTaskManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0011\u0015B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u000eJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u001d\u0010\u0011\u001a\u00020\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002¢\u0006\u0004\b\u0011\u0010\u0019J\u0017\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u0011\u0010\u001cJ\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u0011\u0010\u001fJ\r\u0010 \u001a\u00020\u0012¢\u0006\u0004\b \u0010\u0014J\r\u0010!\u001a\u00020\u0012¢\u0006\u0004\b!\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\"R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010#R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010$R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001b\u0010*\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010(\u001a\u0004\b%\u0010)R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001a0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010/R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010/R\u0014\u00102\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010/R\u0014\u00105\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006>"}, d2 = {"Lio/bidmachine/rendering/internal/detector/brokencreative/a;", "", "", "adPhaseSequence", "", "adElementName", "Lio/bidmachine/rendering/model/BrokenCreativeDetectorParams;", "brokenCreativeDetectorParams", "Lio/bidmachine/rendering/internal/detector/brokencreative/b;", "brokenCreativeDetectorListener", "<init>", "(ILjava/lang/String;Lio/bidmachine/rendering/model/BrokenCreativeDetectorParams;Lio/bidmachine/rendering/internal/detector/brokencreative/b;)V", "", InneractiveMediationDefs.GENDER_FEMALE, "()Z", "g", "e", "a", "", "h", "()V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmResult;", "algorithmResultList", "(Ljava/util/List;)V", "Lio/bidmachine/rendering/model/BrokenCreativeEvent;", "brokenCreativeEvent", "(Lio/bidmachine/rendering/model/BrokenCreativeEvent;)V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "(Landroid/view/View;)V", "i", "c", "I", "Ljava/lang/String;", "Lio/bidmachine/rendering/model/BrokenCreativeDetectorParams;", "d", "Lio/bidmachine/rendering/internal/detector/brokencreative/b;", "Lio/bidmachine/util/taskmanager/handler/HandlerTaskManager;", "Lkotlin/Lazy;", "()Lio/bidmachine/util/taskmanager/handler/HandlerTaskManager;", "handlerTaskManager", "", "Ljava/util/List;", "brokenCreativeEventList", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRunning", "isDestroyed", "isTargetDetectReached", j.b, "Ljava/lang/Object;", "lock", "", CampaignEx.JSON_KEY_AD_K, "J", "startTimeMs", "Lio/bidmachine/rendering/internal/detector/brokencreative/a$b;", "l", "Lio/bidmachine/rendering/internal/detector/brokencreative/a$b;", "detectorTask", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int adPhaseSequence;

    /* renamed from: b, reason: from kotlin metadata */
    private final String adElementName;

    /* renamed from: c, reason: from kotlin metadata */
    private final BrokenCreativeDetectorParams brokenCreativeDetectorParams;

    /* renamed from: d, reason: from kotlin metadata */
    private final io.bidmachine.rendering.internal.detector.brokencreative.b brokenCreativeDetectorListener;

    /* renamed from: e, reason: from kotlin metadata */
    private final Lazy handlerTaskManager;

    /* renamed from: f, reason: from kotlin metadata */
    private final List<BrokenCreativeEvent> brokenCreativeEventList;

    /* renamed from: g, reason: from kotlin metadata */
    private final AtomicBoolean isRunning;

    /* renamed from: h, reason: from kotlin metadata */
    private final AtomicBoolean isDestroyed;

    /* renamed from: i, reason: from kotlin metadata */
    private final AtomicBoolean isTargetDetectReached;

    /* renamed from: j, reason: from kotlin metadata */
    private final Object lock;

    /* renamed from: k, reason: from kotlin metadata */
    private volatile long startTimeMs;

    /* renamed from: l, reason: from kotlin metadata */
    private b detectorTask;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00128\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015RF\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lio/bidmachine/rendering/internal/detector/brokencreative/a$a;", "Lio/bidmachine/util/taskmanager/CancelableTask;", "Lio/bidmachine/rendering/internal/detector/brokencreative/algorithm/a;", "algorithm", "Landroid/graphics/Bitmap;", "image", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "algorithmTask", "Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmResult;", "brokenCreativeAlgorithmResult", "", "callback", "<init>", "(Lio/bidmachine/rendering/internal/detector/brokencreative/algorithm/a;Landroid/graphics/Bitmap;Lkotlin/jvm/functions/Function2;)V", "runTask", "()V", "a", "Lio/bidmachine/rendering/internal/detector/brokencreative/algorithm/a;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/graphics/Bitmap;", "c", "Lkotlin/jvm/functions/Function2;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: io.bidmachine.rendering.internal.detector.brokencreative.a$a, reason: collision with other inner class name */
    private static final class C0620a extends CancelableTask {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final io.bidmachine.rendering.internal.detector.brokencreative.algorithm.a algorithm;

        /* renamed from: b, reason: from kotlin metadata */
        private final Bitmap image;

        /* renamed from: c, reason: from kotlin metadata */
        private final Function2<C0620a, BrokenCreativeAlgorithmResult, Unit> callback;

        /* JADX WARN: Multi-variable type inference failed */
        public C0620a(io.bidmachine.rendering.internal.detector.brokencreative.algorithm.a algorithm, Bitmap image, Function2<? super C0620a, ? super BrokenCreativeAlgorithmResult, Unit> callback) {
            Intrinsics.checkNotNullParameter(algorithm, "algorithm");
            Intrinsics.checkNotNullParameter(image, "image");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.algorithm = algorithm;
            this.image = image;
            this.callback = callback;
        }

        @Override // io.bidmachine.util.taskmanager.CancelableTask
        public void runTask() {
            long currentTimeMillis = System.currentTimeMillis();
            Boolean b = this.algorithm.b(this.image);
            if (b != null) {
                this.callback.invoke(this, new BrokenCreativeAlgorithmResult(b.booleanValue(), this.algorithm.getAlgorithmParams(), System.currentTimeMillis() - currentTimeMillis));
            } else {
                this.callback.invoke(this, null);
            }
        }
    }

    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015BV\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012'\u0010\u0011\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\f0\b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0015\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0015\u0010\u001fJ\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u0015\u0010 J\u000f\u0010!\u001a\u00020\u0010H\u0002¢\u0006\u0004\b!\u0010\u001bJ\u000f\u0010\"\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\"\u0010\u001bJ\u0017\u0010$\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0014H\u0016¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010&R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010'R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010(R5\u0010\u0011\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\f0\b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u001c038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010(R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010(¨\u00067"}, d2 = {"Lio/bidmachine/rendering/internal/detector/brokencreative/a$b;", "Lio/bidmachine/util/taskmanager/CancelableTask;", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/os/Handler;", "screenshotCallbackHandler", "", "downscaleFactor", "", "Lio/bidmachine/rendering/internal/detector/brokencreative/algorithm/a;", "algorithms", "Lkotlin/Function1;", "Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmResult;", "Lkotlin/ParameterName;", "name", "algorithmResultList", "", "callback", "<init>", "(Landroid/view/View;Landroid/os/Handler;DLjava/util/List;Lkotlin/jvm/functions/Function1;)V", "", "a", "()Z", "Landroid/graphics/Bitmap;", "bitmap", "(Landroid/graphics/Bitmap;)V", "c", "()V", "Lio/bidmachine/rendering/internal/detector/brokencreative/a$a;", "algorithmTask", "brokenCreativeAlgorithmResult", "(Lio/bidmachine/rendering/internal/detector/brokencreative/a$a;Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmResult;)V", "(Lio/bidmachine/rendering/internal/detector/brokencreative/a$a;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "runTask", "isCancel", "setCancel", "(Z)V", "Landroid/os/Handler;", "D", "Ljava/util/List;", "d", "Lkotlin/jvm/functions/Function1;", "Lio/bidmachine/util/taskmanager/coroutine/CoroutineTaskManager;", "e", "Lio/bidmachine/util/taskmanager/coroutine/CoroutineTaskManager;", "taskManager", "Ljava/lang/ref/WeakReference;", InneractiveMediationDefs.GENDER_FEMALE, "Ljava/lang/ref/WeakReference;", "weakView", "", "g", "workingTaskList", "h", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class b extends CancelableTask {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Handler screenshotCallbackHandler;

        /* renamed from: b, reason: from kotlin metadata */
        private final double downscaleFactor;

        /* renamed from: c, reason: from kotlin metadata */
        private final List<io.bidmachine.rendering.internal.detector.brokencreative.algorithm.a> algorithms;

        /* renamed from: d, reason: from kotlin metadata */
        private final Function1<List<BrokenCreativeAlgorithmResult>, Unit> callback;

        /* renamed from: e, reason: from kotlin metadata */
        private final CoroutineTaskManager taskManager;

        /* renamed from: f, reason: from kotlin metadata */
        private final WeakReference<View> weakView;

        /* renamed from: g, reason: from kotlin metadata */
        private final List<C0620a> workingTaskList;

        /* renamed from: h, reason: from kotlin metadata */
        private final List<BrokenCreativeAlgorithmResult> algorithmResultList;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\t¨\u0006\n"}, d2 = {"Lio/bidmachine/rendering/internal/detector/brokencreative/a$b$a;", "Lio/bidmachine/rendering/internal/screenshot/b;", "<init>", "(Lio/bidmachine/rendering/internal/detector/brokencreative/a$b;)V", "Landroid/graphics/Bitmap;", "bitmap", "", "a", "(Landroid/graphics/Bitmap;)V", "()V", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* renamed from: io.bidmachine.rendering.internal.detector.brokencreative.a$b$a, reason: collision with other inner class name */
        private final class C0621a implements io.bidmachine.rendering.internal.screenshot.b {
            public C0621a() {
            }

            @Override // io.bidmachine.rendering.internal.screenshot.b
            public void a(Bitmap bitmap) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                b.this.a(bitmap);
            }

            @Override // io.bidmachine.rendering.internal.screenshot.b
            public void a() {
                b.this.c();
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/bidmachine/rendering/internal/detector/brokencreative/a$a;", "algorithmTask", "Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmResult;", "brokenCreativeAlgorithmResult", "", "a", "(Lio/bidmachine/rendering/internal/detector/brokencreative/a$a;Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmResult;)V"}, k = 3, mv = {1, 7, 1})
        /* renamed from: io.bidmachine.rendering.internal.detector.brokencreative.a$b$b, reason: collision with other inner class name */
        static final class C0622b extends Lambda implements Function2<C0620a, BrokenCreativeAlgorithmResult, Unit> {
            C0622b() {
                super(2);
            }

            public final void a(C0620a algorithmTask, BrokenCreativeAlgorithmResult brokenCreativeAlgorithmResult) {
                Intrinsics.checkNotNullParameter(algorithmTask, "algorithmTask");
                b.this.a(algorithmTask, brokenCreativeAlgorithmResult);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(C0620a c0620a, BrokenCreativeAlgorithmResult brokenCreativeAlgorithmResult) {
                a(c0620a, brokenCreativeAlgorithmResult);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(View view, Handler screenshotCallbackHandler, double d, List<? extends io.bidmachine.rendering.internal.detector.brokencreative.algorithm.a> algorithms, Function1<? super List<BrokenCreativeAlgorithmResult>, Unit> callback) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(screenshotCallbackHandler, "screenshotCallbackHandler");
            Intrinsics.checkNotNullParameter(algorithms, "algorithms");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.screenshotCallbackHandler = screenshotCallbackHandler;
            this.downscaleFactor = d;
            this.algorithms = algorithms;
            this.callback = callback;
            this.taskManager = new CoroutineTaskManager(CoroutineScopeKt.CoroutineScope(new CoroutineName("DetectorTaskManager").plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(Dispatchers.getDefault())));
            this.weakView = new WeakReference<>(view);
            this.workingTaskList = new CopyOnWriteArrayList();
            this.algorithmResultList = new CopyOnWriteArrayList();
        }

        private final void b() {
            if (a()) {
                this.callback.invoke(this.algorithmResultList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c() {
            b();
        }

        @Override // io.bidmachine.util.taskmanager.CancelableTask
        public void runTask() {
            View view = this.weakView.get();
            if (view == null) {
                return;
            }
            io.bidmachine.rendering.internal.screenshot.a.f7093a.a(view, this.screenshotCallbackHandler, new C0621a());
        }

        @Override // io.bidmachine.util.taskmanager.CancelableTask, io.bidmachine.util.Cancelable
        public void setCancel(boolean isCancel) {
            super.setCancel(isCancel);
            if (isCancel) {
                Iterator<T> it = this.workingTaskList.iterator();
                while (it.hasNext()) {
                    this.taskManager.cancel((C0620a) it.next());
                }
                this.workingTaskList.clear();
            }
        }

        private final boolean a() {
            return !isCanceled();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(Bitmap bitmap) {
            if (!a()) {
                ImageUtilsKt.recycleSafely(bitmap);
                return;
            }
            Bitmap createDownscaledBitmapSafely = ImageUtilsKt.createDownscaledBitmapSafely(bitmap, this.downscaleFactor);
            if (!Intrinsics.areEqual(createDownscaledBitmapSafely, bitmap)) {
                ImageUtilsKt.recycleSafely(bitmap);
            }
            if (!a()) {
                ImageUtilsKt.recycleSafely(bitmap);
                return;
            }
            List<io.bidmachine.rendering.internal.detector.brokencreative.algorithm.a> list = this.algorithms;
            ArrayList<C0620a> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new C0620a((io.bidmachine.rendering.internal.detector.brokencreative.algorithm.a) it.next(), createDownscaledBitmapSafely, new C0622b()));
            }
            this.workingTaskList.addAll(arrayList);
            for (C0620a c0620a : arrayList) {
                if (!this.taskManager.executeSafely(c0620a)) {
                    a(c0620a);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(C0620a algorithmTask, BrokenCreativeAlgorithmResult brokenCreativeAlgorithmResult) {
            if (brokenCreativeAlgorithmResult != null) {
                this.algorithmResultList.add(brokenCreativeAlgorithmResult);
            }
            a(algorithmTask);
        }

        private final void a(C0620a algorithmTask) {
            this.workingTaskList.remove(algorithmTask);
            if (this.workingTaskList.isEmpty()) {
                b();
            }
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/bidmachine/util/taskmanager/handler/HandlerTaskManager;", "a", "()Lio/bidmachine/util/taskmanager/handler/HandlerTaskManager;"}, k = 3, mv = {1, 7, 1})
    static final class c extends Lambda implements Function0<HandlerTaskManager> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f7052a = new c();

        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HandlerTaskManager invoke() {
            HandlerThread handlerThread = new HandlerThread("BrokenCreativeDetectorTaskManager");
            handlerThread.start();
            return new HandlerTaskManager(new Handler(handlerThread.getLooper()));
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmResult;", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 7, 1})
    static final class d extends Lambda implements Function1<List<? extends BrokenCreativeAlgorithmResult>, Unit> {
        d() {
            super(1);
        }

        public final void a(List<BrokenCreativeAlgorithmResult> it) {
            Intrinsics.checkNotNullParameter(it, "it");
            a.this.a(it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends BrokenCreativeAlgorithmResult> list) {
            a(list);
            return Unit.INSTANCE;
        }
    }

    public a(int i, String adElementName, BrokenCreativeDetectorParams brokenCreativeDetectorParams, io.bidmachine.rendering.internal.detector.brokencreative.b brokenCreativeDetectorListener) {
        Intrinsics.checkNotNullParameter(adElementName, "adElementName");
        Intrinsics.checkNotNullParameter(brokenCreativeDetectorParams, "brokenCreativeDetectorParams");
        Intrinsics.checkNotNullParameter(brokenCreativeDetectorListener, "brokenCreativeDetectorListener");
        this.adPhaseSequence = i;
        this.adElementName = adElementName;
        this.brokenCreativeDetectorParams = brokenCreativeDetectorParams;
        this.brokenCreativeDetectorListener = brokenCreativeDetectorListener;
        this.handlerTaskManager = LazyKt.lazy(c.f7052a);
        this.brokenCreativeEventList = new CopyOnWriteArrayList();
        this.isRunning = new AtomicBoolean(false);
        this.isDestroyed = new AtomicBoolean(false);
        this.isTargetDetectReached = new AtomicBoolean(false);
        this.lock = new Object();
    }

    private final void b() {
        synchronized (this.lock) {
            b bVar = this.detectorTask;
            if (bVar != null) {
                d().cancel(bVar);
            }
        }
    }

    private final HandlerTaskManager d() {
        return (HandlerTaskManager) this.handlerTaskManager.getValue();
    }

    private final boolean e() {
        return this.isDestroyed.get();
    }

    private final boolean f() {
        return this.isRunning.get();
    }

    private final boolean g() {
        return this.isTargetDetectReached.get();
    }

    private final void h() {
        synchronized (this.lock) {
            b();
            if (a()) {
                b bVar = this.detectorTask;
                if (bVar != null) {
                    d().scheduleSafely(bVar, this.brokenCreativeDetectorParams.getTimeout());
                }
            }
        }
    }

    public final void c() {
        this.isDestroyed.set(true);
        i();
    }

    public final void i() {
        synchronized (this.lock) {
            this.isRunning.set(false);
            b();
            this.detectorTask = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (g() || e()) {
            return;
        }
        synchronized (this.lock) {
            if (this.isRunning.compareAndSet(false, true)) {
                List<BrokenCreativeAlgorithmParams> algorithms = this.brokenCreativeDetectorParams.getAlgorithms();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(algorithms, 10));
                Iterator<T> it = algorithms.iterator();
                while (it.hasNext()) {
                    arrayList.add(io.bidmachine.rendering.internal.detector.brokencreative.algorithm.b.f7055a.a((BrokenCreativeAlgorithmParams) it.next()));
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                this.startTimeMs = System.currentTimeMillis();
                this.detectorTask = new b(view, d().getHandler(), this.brokenCreativeDetectorParams.getDownscaleFactor(), arrayList, new d());
                h();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final boolean a() {
        return (!f() || g() || e()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<BrokenCreativeAlgorithmResult> algorithmResultList) {
        if (a()) {
            double d2 = 0.0d;
            double d3 = 0.0d;
            for (BrokenCreativeAlgorithmResult brokenCreativeAlgorithmResult : algorithmResultList) {
                float weight = brokenCreativeAlgorithmResult.getAlgorithmParams().getWeight();
                if (brokenCreativeAlgorithmResult.getIsBroken()) {
                    d3 += weight;
                }
                d2 += weight;
            }
            boolean z = (d2 != 0.0d ? d3 / d2 : 0.0d) >= this.brokenCreativeDetectorParams.getWeightThreshold();
            if (!this.brokenCreativeDetectorParams.getIsErrorOnly() || z) {
                BrokenCreativeEvent brokenCreativeEvent = new BrokenCreativeEvent(io.bidmachine.rendering.internal.detector.brokencreative.c.f7056a.a(z), this.adPhaseSequence, this.adElementName, System.currentTimeMillis() - this.startTimeMs, algorithmResultList);
                if (this.brokenCreativeDetectorParams.getIsAllowDuplicate() || !this.brokenCreativeEventList.contains(brokenCreativeEvent)) {
                    this.brokenCreativeEventList.add(brokenCreativeEvent);
                    a(brokenCreativeEvent);
                }
            }
            StopDetectorAfter stopAfter = this.brokenCreativeDetectorParams.getStopAfter();
            if ((stopAfter == StopDetectorAfter.ValidCreative && z) || ((stopAfter == StopDetectorAfter.BrokenCreative && !z) || stopAfter == StopDetectorAfter.Never)) {
                h();
            } else {
                this.isTargetDetectReached.set(true);
            }
        }
    }

    private final void a(BrokenCreativeEvent brokenCreativeEvent) {
        if (a()) {
            o.b("BrokenCreativeDetector", "Notify detector result: %s", brokenCreativeEvent);
            this.brokenCreativeDetectorListener.a(brokenCreativeEvent);
        }
    }
}
