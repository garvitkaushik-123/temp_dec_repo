package com.lofelt.haptics;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.stream.LongStream;

/* compiled from: LofeltHaptics.java */
/* loaded from: classes6.dex */
class Player {
    private boolean clipLoaded = false;
    private boolean clipLoopingEnabled = false;
    private final Context context;
    private VibrationEffect effect;
    private Vibrator vibrator;

    static /* synthetic */ boolean lambda$loadCallback$0(long j) {
        return j == 0;
    }

    static /* synthetic */ boolean lambda$loadCallback$1(int i) {
        return i == 0;
    }

    public Player(Context context) {
        this.context = context;
    }

    private void loadCallback(long[] jArr, int[] iArr, boolean z) {
        this.clipLoaded = true;
        this.clipLoopingEnabled = z;
        if (jArr.length == 0 || iArr.length == 0 || Arrays.stream(jArr).allMatch(new LongPredicate() { // from class: com.lofelt.haptics.Player$$ExternalSyntheticLambda0
            @Override // java.util.function.LongPredicate
            public final boolean test(long j) {
                return Player.lambda$loadCallback$0(j);
            }
        }) || Arrays.stream(iArr).allMatch(new IntPredicate() { // from class: com.lofelt.haptics.Player$$ExternalSyntheticLambda1
            @Override // java.util.function.IntPredicate
            public final boolean test(int i) {
                return Player.lambda$loadCallback$1(i);
            }
        })) {
            this.effect = null;
            return;
        }
        this.vibrator = (Vibrator) this.context.getSystemService("vibrator");
        if (Build.VERSION.SDK_INT <= 30 && !this.clipLoopingEnabled) {
            this.effect = getPaddedEffect(jArr, iArr);
        } else {
            this.effect = VibrationEffect.createWaveform(jArr, iArr, getRepeatValue());
        }
    }

    private void playCallback() {
        if (!this.clipLoaded) {
            throw new RuntimeException("Unable to play, no clip loaded");
        }
        if (this.effect == null) {
            return;
        }
        if (this.vibrator == null) {
            throw new RuntimeException("Unable to play, Vibrator service unavailable");
        }
        stopCallback();
        this.vibrator.vibrate(this.effect);
    }

    private void stopCallback() {
        Vibrator vibrator = this.vibrator;
        if (vibrator != null) {
            vibrator.cancel();
        }
    }

    private void unloadCallback() {
        this.clipLoaded = false;
        this.clipLoopingEnabled = false;
        this.vibrator = null;
        this.effect = null;
    }

    private int getRepeatValue() {
        return this.clipLoopingEnabled ? 0 : -1;
    }

    private void seekCallback(long[] jArr, int[] iArr) {
        loadCallback(jArr, iArr, false);
        stopCallback();
    }

    private VibrationEffect getPaddedEffect(long[] jArr, int[] iArr) {
        long[] copyOf = Arrays.copyOf(jArr, jArr.length + 1);
        int[] copyOf2 = Arrays.copyOf(iArr, iArr.length + 1);
        long calculatePaddingTiming = calculatePaddingTiming(jArr);
        if (calculatePaddingTiming > 0) {
            copyOf[jArr.length] = calculatePaddingTiming;
            copyOf2[iArr.length] = 1;
            return VibrationEffect.createWaveform(copyOf, copyOf2, getRepeatValue());
        }
        return VibrationEffect.createWaveform(jArr, iArr, getRepeatValue());
    }

    private long calculatePaddingTiming(long[] jArr) {
        double sum = LongStream.of(jArr).sum();
        double length = jArr.length;
        if (sum < 100.0d || length < 50.0d) {
            return 0L;
        }
        return Math.round(length * 4.0d * ((Math.log(sum) * 0.39d) - 1.53d));
    }
}
