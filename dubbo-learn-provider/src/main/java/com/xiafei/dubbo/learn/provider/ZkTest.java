package com.xiafei.dubbo.learn.provider;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZkTest implements Watcher {

    private ZooKeeper zk;
    CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            countDownLatch.countDown();
        }

    }


    public void connect() throws IOException, InterruptedException {
        zk = new ZooKeeper("127.0.0.1:2181", 3600000, this);
        countDownLatch.await();
    }


    public void createNode(final String path) throws KeeperException, InterruptedException {
        String s = zk.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("create zk node，path=" + s);
    }


    public void close() {
        if (zk != null) {
            try {
                zk.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                zk = null;
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZkTest zkTest = new ZkTest();
        zkTest.connect();
        zkTest.createNode("/test/qixiafei");
        zkTest.createNode("/test/qixiafei/heihei");
        zkTest.close();
    }
}
