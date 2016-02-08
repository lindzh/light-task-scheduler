package com.lts.remoting.lts;

import com.lts.remoting.Channel;
import com.lts.remoting.ChannelHandler;

import java.net.SocketAddress;

/**
 * @author Robert HG (254963746@qq.com) on 2/8/16.
 */
public class LtsChannel implements Channel {

    private com.lts.nio.channel.NioChannel channel;

    public LtsChannel(com.lts.nio.channel.NioChannel channel) {
        this.channel = channel;
    }

    @Override
    public SocketAddress localAddress() {
        return channel.localAddress();
    }

    @Override
    public SocketAddress remoteAddress() {
        return channel.remoteAddress();
    }

    @Override
    public ChannelHandler writeAndFlush(Object msg) {
        return new LtsChannelHandler(channel.writeAndFlush(msg));
    }

    @Override
    public ChannelHandler close() {
        return new LtsChannelHandler(channel.close());
    }

    @Override
    public boolean isConnected() {
        return channel.isConnected();
    }

    @Override
    public boolean isOpen() {
        return channel.isOpen();
    }

    @Override
    public boolean isClosed() {
        return channel.isClosed();
    }
}