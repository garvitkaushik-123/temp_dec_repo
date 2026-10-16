package com.instagram.common.viewpoint.core;

import android.net.Uri;
import com.facebook.ads.androidx.media3.extractor.ExtractorsFactory;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* renamed from: com.facebook.ads.redexgen.X.9o, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C08519o {
    public static byte[] A08;
    public static String[] A09 = {"634gowWrnODsCbHJW3RM2adSB8UjvpNK", "SJrAWOr70TCHX", "EwIuJu9eGNp0k", "E6EVZDT", "sHeITXs", "FXQ6HdUX", "YL7g5rxYaYN1DF5ZV43is2fGGs0zV37S", "j2oNEgxbTlE4krYsb5twTfwtoUHd8Sk9"};
    public DC A02;
    public String A05;
    public final C5Y A06;
    public final Object A07;
    public A6 A01 = A3.A01();
    public FF A03 = new C2296n9();
    public int A00 = 1048576;

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "https://github.com/androidx/media/pull/1754")
    public InterfaceC2170ku<InterfaceExecutorC0983Fb> A04 = new InterfaceC2170ku() { // from class: com.facebook.ads.redexgen.X.nj
        @Override // com.instagram.common.viewpoint.core.InterfaceC2170ku
        public final Object get() {
            return C08519o.A01();
        }
    };

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A09[7].charAt(23) != 't') {
                throw new RuntimeException();
            }
            A09[4] = "2gbF6ls";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 26);
            i4++;
        }
    }

    public static void A03() {
        A08 = new byte[]{Ascii.DC4, 35, 35, 62, 35, 113, 56, 63, 34, 37, 48, 63, 37, 56, 48, 37, 56, 63, 54, 113, Ascii.NAK, 52, 55, 48, 36, Base64.padSymbol, 37, Ascii.DC4, 41, 37, 35, 48, 50, 37, 62, 35, 34, Ascii.ETB, 48, 50, 37, 62, 35, 40, 106, 102, 100, 39, 111, 104, 106, 108, 107, 102, 102, 98, 39, 104, 109, 122, 39, 104, 103, 109, 123, 102, 96, 109, 113, 39, 100, 108, 109, 96, 104, 58, 39, 108, 113, 125, 123, 104, 106, 125, 102, 123, 39, 77, 108, 111, 104, 124, 101, 125, 76, 113, 125, 123, 104, 106, 125, 102, 123, 122, 79, 104, 106, 125, 102, 123, 112};
    }

    static {
        A03();
    }

    public C08519o(C5Y c5y) {
        this.A06 = c5y;
    }

    public static /* synthetic */ C2343nu A00(HD hd, C8O c8o) {
        return new C2343nu(hd);
    }

    public static /* synthetic */ InterfaceExecutorC0983Fb A01() {
        return null;
    }

    @MetaExoPlayerCustomization("Custom reflection logic to avoid loading DefaultExtractorsFactory")
    public final C08509n A04(Uri uri) {
        String A02 = A02(0, 44, 75);
        if (this.A02 == null) {
            try {
                Constructor<? extends ExtractorsFactory> constructor = Class.forName(A02(44, 67, 19)).asSubclass(HD.class).getConstructor(new Class[0]);
                final HD hd = (HD) constructor.newInstance(new Object[0]);
                this.A02 = new DC() { // from class: com.facebook.ads.redexgen.X.nl
                    @Override // com.instagram.common.viewpoint.core.DC
                    public final DD A5X(C8O c8o) {
                        return C08519o.A00(HD.this, c8o);
                    }
                };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(A02, e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(A02, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException(A02, e3);
            } catch (NoSuchMethodException e4) {
                throw new RuntimeException(A02, e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException(A02, e5);
            }
        }
        return new C08509n(new C06852u().A00(uri).A02(this.A05).A01(this.A07).A05(), this.A06, this.A02, this.A01, this.A03, this.A00, null);
    }
}
