package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Objects;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcdx extends SSLSocketFactory {
    final SSLSocketFactory zza;
    final /* synthetic */ zzcdy zzb;

    zzcdx(zzcdy zzcdyVar) {
        Objects.requireNonNull(zzcdyVar);
        this.zzb = zzcdyVar;
        this.zza = (SSLSocketFactory) SSLSocketFactory.getDefault();
    }

    private final Socket zza(Socket socket) throws SocketException {
        int i;
        int i2;
        zzcdy zzcdyVar = this.zzb;
        i = zzcdyVar.zzq;
        if (i > 0) {
            i2 = zzcdyVar.zzq;
            socket.setReceiveBufferSize(i2);
        }
        zzcdyVar.zzr.add(socket);
        return socket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i) throws IOException {
        Socket createSocket = this.zza.createSocket(str, i);
        zza(createSocket);
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.zza.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.zza.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        Socket createSocket = this.zza.createSocket(str, i, inetAddress, i2);
        zza(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Socket createSocket = this.zza.createSocket(inetAddress, i);
        zza(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        Socket createSocket = this.zza.createSocket(inetAddress, i, inetAddress2, i2);
        zza(createSocket);
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Socket createSocket = this.zza.createSocket(socket, str, i, z);
        zza(createSocket);
        return createSocket;
    }
}
