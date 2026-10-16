package io.bidmachine.nativead.utils;

import io.bidmachine.core.Utils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes6.dex */
public class NoSSLv3SocketFactory extends SSLSocketFactory {
    private final SSLSocketFactory delegate;

    public NoSSLv3SocketFactory() {
        this.delegate = HttpsURLConnection.getDefaultSSLSocketFactory();
    }

    public NoSSLv3SocketFactory(SSLSocketFactory delegate) {
        this.delegate = delegate;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    private Socket makeSocketSafe(Socket socket) {
        return socket instanceof SSLSocket ? new NoSSLv3SSLSocket((SSLSocket) socket) : socket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        return makeSocketSafe(this.delegate.createSocket(s, host, port, autoClose));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String host, int port) throws IOException {
        return makeSocketSafe(this.delegate.createSocket(host, port));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException {
        return makeSocketSafe(this.delegate.createSocket(host, port, localHost, localPort));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress host, int port) throws IOException {
        return makeSocketSafe(this.delegate.createSocket(host, port));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
        return makeSocketSafe(this.delegate.createSocket(address, port, localAddress, localPort));
    }

    private static class NoSSLv3SSLSocket extends DelegateSSLSocket {
        private NoSSLv3SSLSocket(SSLSocket delegate) {
            super(delegate);
        }

        @Override // io.bidmachine.nativead.utils.NoSSLv3SocketFactory.DelegateSSLSocket, javax.net.ssl.SSLSocket
        public void setEnabledProtocols(String[] protocols) {
            if (protocols != null && protocols.length == 1 && "SSLv3".equals(protocols[0])) {
                ArrayList arrayList = new ArrayList(Arrays.asList(this.delegate.getEnabledProtocols()));
                if (arrayList.size() > 1) {
                    arrayList.remove("SSLv3");
                    System.out.println("Removed SSLv3 from enabled protocols");
                } else {
                    System.out.println("SSL stuck with protocol available for " + arrayList);
                }
                protocols = (String[]) arrayList.toArray(new String[0]);
            }
            super.setEnabledProtocols(protocols);
        }
    }

    public static class DelegateSSLSocket extends SSLSocket {
        final SSLSocket delegate;

        DelegateSSLSocket(SSLSocket delegate) {
            this.delegate = delegate;
        }

        @Override // javax.net.ssl.SSLSocket
        public String[] getSupportedCipherSuites() {
            return this.delegate.getSupportedCipherSuites();
        }

        @Override // javax.net.ssl.SSLSocket
        public String[] getEnabledCipherSuites() {
            return this.delegate.getEnabledCipherSuites();
        }

        @Override // javax.net.ssl.SSLSocket
        public void setEnabledCipherSuites(String[] suites) {
            this.delegate.setEnabledCipherSuites(suites);
        }

        @Override // javax.net.ssl.SSLSocket
        public String[] getSupportedProtocols() {
            return this.delegate.getSupportedProtocols();
        }

        @Override // javax.net.ssl.SSLSocket
        public String[] getEnabledProtocols() {
            return this.delegate.getEnabledProtocols();
        }

        @Override // javax.net.ssl.SSLSocket
        public void setEnabledProtocols(String[] protocols) {
            this.delegate.setEnabledProtocols(protocols);
        }

        @Override // javax.net.ssl.SSLSocket
        public SSLSession getSession() {
            return this.delegate.getSession();
        }

        @Override // javax.net.ssl.SSLSocket
        public void addHandshakeCompletedListener(HandshakeCompletedListener listener) {
            this.delegate.addHandshakeCompletedListener(listener);
        }

        @Override // javax.net.ssl.SSLSocket
        public void removeHandshakeCompletedListener(HandshakeCompletedListener listener) {
            this.delegate.removeHandshakeCompletedListener(listener);
        }

        @Override // javax.net.ssl.SSLSocket
        public void startHandshake() throws IOException {
            this.delegate.startHandshake();
        }

        @Override // javax.net.ssl.SSLSocket
        public void setUseClientMode(boolean mode) {
            this.delegate.setUseClientMode(mode);
        }

        @Override // javax.net.ssl.SSLSocket
        public boolean getUseClientMode() {
            return this.delegate.getUseClientMode();
        }

        @Override // javax.net.ssl.SSLSocket
        public void setNeedClientAuth(boolean need) {
            this.delegate.setNeedClientAuth(need);
        }

        @Override // javax.net.ssl.SSLSocket
        public void setWantClientAuth(boolean want) {
            this.delegate.setWantClientAuth(want);
        }

        @Override // javax.net.ssl.SSLSocket
        public boolean getNeedClientAuth() {
            return this.delegate.getNeedClientAuth();
        }

        @Override // javax.net.ssl.SSLSocket
        public boolean getWantClientAuth() {
            return this.delegate.getWantClientAuth();
        }

        @Override // javax.net.ssl.SSLSocket
        public void setEnableSessionCreation(boolean flag) {
            this.delegate.setEnableSessionCreation(flag);
        }

        @Override // javax.net.ssl.SSLSocket
        public boolean getEnableSessionCreation() {
            return this.delegate.getEnableSessionCreation();
        }

        @Override // java.net.Socket
        public void bind(SocketAddress localAddress) throws IOException {
            this.delegate.bind(localAddress);
        }

        @Override // java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            Utils.close(this.delegate);
        }

        @Override // java.net.Socket
        public void connect(SocketAddress remoteAddress) throws IOException {
            this.delegate.connect(remoteAddress);
        }

        @Override // java.net.Socket
        public void connect(SocketAddress remoteAddress, int timeout) throws IOException {
            this.delegate.connect(remoteAddress, timeout);
        }

        @Override // java.net.Socket
        public SocketChannel getChannel() {
            return this.delegate.getChannel();
        }

        @Override // java.net.Socket
        public InetAddress getInetAddress() {
            return this.delegate.getInetAddress();
        }

        @Override // java.net.Socket
        public InputStream getInputStream() throws IOException {
            return this.delegate.getInputStream();
        }

        @Override // java.net.Socket
        public boolean getKeepAlive() throws SocketException {
            return this.delegate.getKeepAlive();
        }

        @Override // java.net.Socket
        public InetAddress getLocalAddress() {
            return this.delegate.getLocalAddress();
        }

        @Override // java.net.Socket
        public int getLocalPort() {
            return this.delegate.getLocalPort();
        }

        @Override // java.net.Socket
        public SocketAddress getLocalSocketAddress() {
            return this.delegate.getLocalSocketAddress();
        }

        @Override // java.net.Socket
        public boolean getOOBInline() throws SocketException {
            return this.delegate.getOOBInline();
        }

        @Override // java.net.Socket
        public OutputStream getOutputStream() throws IOException {
            return this.delegate.getOutputStream();
        }

        @Override // java.net.Socket
        public int getPort() {
            return this.delegate.getPort();
        }

        @Override // java.net.Socket
        public synchronized int getReceiveBufferSize() throws SocketException {
            return this.delegate.getReceiveBufferSize();
        }

        @Override // java.net.Socket
        public SocketAddress getRemoteSocketAddress() {
            return this.delegate.getRemoteSocketAddress();
        }

        @Override // java.net.Socket
        public boolean getReuseAddress() throws SocketException {
            return this.delegate.getReuseAddress();
        }

        @Override // java.net.Socket
        public synchronized int getSendBufferSize() throws SocketException {
            return this.delegate.getSendBufferSize();
        }

        @Override // java.net.Socket
        public int getSoLinger() throws SocketException {
            return this.delegate.getSoLinger();
        }

        @Override // java.net.Socket
        public synchronized int getSoTimeout() throws SocketException {
            return this.delegate.getSoTimeout();
        }

        @Override // java.net.Socket
        public boolean getTcpNoDelay() throws SocketException {
            return this.delegate.getTcpNoDelay();
        }

        @Override // java.net.Socket
        public int getTrafficClass() throws SocketException {
            return this.delegate.getTrafficClass();
        }

        @Override // java.net.Socket
        public boolean isBound() {
            return this.delegate.isBound();
        }

        @Override // java.net.Socket
        public boolean isClosed() {
            return this.delegate.isClosed();
        }

        @Override // java.net.Socket
        public boolean isConnected() {
            return this.delegate.isConnected();
        }

        @Override // java.net.Socket
        public boolean isInputShutdown() {
            return this.delegate.isInputShutdown();
        }

        @Override // java.net.Socket
        public boolean isOutputShutdown() {
            return this.delegate.isOutputShutdown();
        }

        @Override // java.net.Socket
        public void sendUrgentData(int value) throws IOException {
            this.delegate.sendUrgentData(value);
        }

        @Override // java.net.Socket
        public void setKeepAlive(boolean keepAlive) throws SocketException {
            this.delegate.setKeepAlive(keepAlive);
        }

        @Override // java.net.Socket
        public void setOOBInline(boolean oobInline) throws SocketException {
            this.delegate.setOOBInline(oobInline);
        }

        @Override // java.net.Socket
        public void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
            this.delegate.setPerformancePreferences(connectionTime, latency, bandwidth);
        }

        @Override // java.net.Socket
        public synchronized void setReceiveBufferSize(int size) throws SocketException {
            this.delegate.setReceiveBufferSize(size);
        }

        @Override // java.net.Socket
        public void setReuseAddress(boolean reuse) throws SocketException {
            this.delegate.setReuseAddress(reuse);
        }

        @Override // java.net.Socket
        public synchronized void setSendBufferSize(int size) throws SocketException {
            this.delegate.setSendBufferSize(size);
        }

        @Override // java.net.Socket
        public void setSoLinger(boolean on, int timeout) throws SocketException {
            this.delegate.setSoLinger(on, timeout);
        }

        @Override // java.net.Socket
        public synchronized void setSoTimeout(int timeout) throws SocketException {
            this.delegate.setSoTimeout(timeout);
        }

        @Override // java.net.Socket
        public void setTcpNoDelay(boolean on) throws SocketException {
            this.delegate.setTcpNoDelay(on);
        }

        @Override // java.net.Socket
        public void setTrafficClass(int value) throws SocketException {
            this.delegate.setTrafficClass(value);
        }

        @Override // java.net.Socket
        public void shutdownInput() throws IOException {
            this.delegate.shutdownInput();
        }

        @Override // java.net.Socket
        public void shutdownOutput() throws IOException {
            this.delegate.shutdownOutput();
        }

        @Override // javax.net.ssl.SSLSocket, java.net.Socket
        public String toString() {
            return this.delegate.toString();
        }

        public boolean equals(Object o) {
            return this.delegate.equals(o);
        }
    }
}
