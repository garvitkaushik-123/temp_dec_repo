package io.adn.sdk.internal.data.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: AudioService.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\b\u0003*\u0002#&\b\u0001\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0002J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'¨\u0006("}, d2 = {"Lio/adn/sdk/internal/data/service/AudioServiceImpl;", "Lio/adn/sdk/internal/data/service/AudioService;", "context", "Landroid/content/Context;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;)V", "_eventFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lio/adn/sdk/internal/data/service/AudioUpdate;", "audioUpdate", "Lkotlinx/coroutines/flow/Flow;", "getAudioUpdate", "()Lkotlinx/coroutines/flow/Flow;", "audioManager", "Landroid/media/AudioManager;", "lastVolume", "", "isSilentMode", "", "audioFocusRequest", "Landroid/media/AudioFocusRequest;", "currentVolume", "isSilentModeActivated", "requestAudioFocus", "", "abandonAudioFocus", "fetchAudioVolume", "fetchSilentModeState", "initializeAudioFocusRequest", "registerListeners", "emitAudioUpdate", "update", "ringerModeReceiver", "io/adn/sdk/internal/data/service/AudioServiceImpl$ringerModeReceiver$1", "Lio/adn/sdk/internal/data/service/AudioServiceImpl$ringerModeReceiver$1;", "volumeObserver", "io/adn/sdk/internal/data/service/AudioServiceImpl$volumeObserver$1", "Lio/adn/sdk/internal/data/service/AudioServiceImpl$volumeObserver$1;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AudioServiceImpl implements AudioService {
    public static final int $stable = 8;
    private final MutableSharedFlow<AudioUpdate> _eventFlow;
    private AudioFocusRequest audioFocusRequest;
    private final AudioManager audioManager;
    private final Flow<AudioUpdate> audioUpdate;
    private final Context context;
    private boolean isSilentMode;
    private float lastVolume;
    private final AudioServiceImpl$ringerModeReceiver$1 ringerModeReceiver;
    private final CoroutineScope scope;
    private final AudioServiceImpl$volumeObserver$1 volumeObserver;

    /* JADX WARN: Type inference failed for: r3v5, types: [io.adn.sdk.internal.data.service.AudioServiceImpl$ringerModeReceiver$1] */
    /* JADX WARN: Type inference failed for: r4v7, types: [io.adn.sdk.internal.data.service.AudioServiceImpl$volumeObserver$1] */
    public AudioServiceImpl(Context context, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.context = context;
        this.scope = scope;
        MutableSharedFlow<AudioUpdate> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._eventFlow = MutableSharedFlow$default;
        this.audioUpdate = MutableSharedFlow$default;
        Object systemService = context.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.audioManager = (AudioManager) systemService;
        this.lastVolume = fetchAudioVolume();
        this.isSilentMode = fetchSilentModeState();
        initializeAudioFocusRequest();
        registerListeners();
        this.ringerModeReceiver = new BroadcastReceiver() { // from class: io.adn.sdk.internal.data.service.AudioServiceImpl$ringerModeReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                boolean fetchSilentModeState;
                boolean z;
                boolean z2;
                Intrinsics.checkNotNullParameter(context2, "context");
                AudioServiceImpl audioServiceImpl = AudioServiceImpl.this;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    AudioServiceImpl$ringerModeReceiver$1 audioServiceImpl$ringerModeReceiver$1 = this;
                    if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, "android.media.RINGER_MODE_CHANGED")) {
                        fetchSilentModeState = audioServiceImpl.fetchSilentModeState();
                        z = audioServiceImpl.isSilentMode;
                        if (z != fetchSilentModeState) {
                            audioServiceImpl.isSilentMode = fetchSilentModeState;
                            z2 = audioServiceImpl.isSilentMode;
                            audioServiceImpl.emitAudioUpdate(z2 ? AudioUpdate.SilentModeOn : AudioUpdate.SilentModeOff);
                        }
                        Result.m10241constructorimpl(Unit.INSTANCE);
                    }
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m10241constructorimpl(ResultKt.createFailure(th));
                }
            }
        };
        final Handler handler = new Handler(Looper.getMainLooper());
        this.volumeObserver = new ContentObserver(handler) { // from class: io.adn.sdk.internal.data.service.AudioServiceImpl$volumeObserver$1
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange) {
                float fetchAudioVolume;
                float f;
                AudioServiceImpl audioServiceImpl = AudioServiceImpl.this;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    AudioServiceImpl$volumeObserver$1 audioServiceImpl$volumeObserver$1 = this;
                    fetchAudioVolume = audioServiceImpl.fetchAudioVolume();
                    f = audioServiceImpl.lastVolume;
                    if (fetchAudioVolume > f) {
                        audioServiceImpl.emitAudioUpdate(AudioUpdate.VolumeUp);
                    } else if (fetchAudioVolume == 0.0f) {
                        audioServiceImpl.emitAudioUpdate(AudioUpdate.VolumeMute);
                    }
                    audioServiceImpl.lastVolume = fetchAudioVolume;
                    Result.m10241constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m10241constructorimpl(ResultKt.createFailure(th));
                }
            }
        };
    }

    public /* synthetic */ AudioServiceImpl(Context context, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()) : coroutineScope);
    }

    @Override // io.adn.sdk.internal.data.service.AudioService
    public Flow<AudioUpdate> getAudioUpdate() {
        return this.audioUpdate;
    }

    @Override // io.adn.sdk.internal.data.service.AudioService
    /* renamed from: currentVolume, reason: from getter */
    public float getLastVolume() {
        return this.lastVolume;
    }

    @Override // io.adn.sdk.internal.data.service.AudioService
    /* renamed from: isSilentModeActivated, reason: from getter */
    public boolean getIsSilentMode() {
        return this.isSilentMode;
    }

    @Override // io.adn.sdk.internal.data.service.AudioService
    public void requestAudioFocus() {
        try {
            Result.Companion companion = Result.INSTANCE;
            AudioServiceImpl audioServiceImpl = this;
            AudioFocusRequest audioFocusRequest = this.audioFocusRequest;
            if (audioFocusRequest != null) {
                this.audioManager.requestAudioFocus(audioFocusRequest);
            }
            Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    @Override // io.adn.sdk.internal.data.service.AudioService
    public void abandonAudioFocus() {
        try {
            Result.Companion companion = Result.INSTANCE;
            AudioServiceImpl audioServiceImpl = this;
            AudioFocusRequest audioFocusRequest = this.audioFocusRequest;
            if (audioFocusRequest != null) {
                this.audioManager.abandonAudioFocusRequest(audioFocusRequest);
            }
            Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float fetchAudioVolume() {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            AudioServiceImpl audioServiceImpl = this;
            m10241constructorimpl = Result.m10241constructorimpl(Float.valueOf(this.audioManager.getStreamVolume(3) / this.audioManager.getStreamMaxVolume(3)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        Float valueOf = Float.valueOf(0.0f);
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = valueOf;
        }
        return ((Number) m10241constructorimpl).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean fetchSilentModeState() {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            AudioServiceImpl audioServiceImpl = this;
            int ringerMode = this.audioManager.getRingerMode();
            boolean z = true;
            if (ringerMode != 0 && ringerMode != 1) {
                z = false;
            }
            m10241constructorimpl = Result.m10241constructorimpl(Boolean.valueOf(z));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = false;
        }
        return ((Boolean) m10241constructorimpl).booleanValue();
    }

    private final void initializeAudioFocusRequest() {
        try {
            Result.Companion companion = Result.INSTANCE;
            AudioServiceImpl audioServiceImpl = this;
            this.audioFocusRequest = new AudioFocusRequest.Builder(4).build();
            Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    private final void registerListeners() {
        try {
            Result.Companion companion = Result.INSTANCE;
            AudioServiceImpl audioServiceImpl = this;
            this.context.registerReceiver(this.ringerModeReceiver, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
            this.context.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.volumeObserver);
            Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitAudioUpdate(AudioUpdate update) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AudioServiceImpl$emitAudioUpdate$1(this, update, null), 3, null);
    }
}
