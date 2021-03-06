package xyz.zhangyi.practicejava.ut;


import org.junit.Assert;
import org.junit.Test;

import java.rmi.server.ExportException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.fail;

public class FileServerUtilTest {
    @Test
    public void testGetRandomServer() {
        try {
            FileServerUtil.getRandomServer("");
            fail("Not Throw Exception");
        } catch (FileServerException ee) {
            Assert.assertEquals("No server configurated.", ee.getMessage());
        }
        String servers = "uploadServer1,uploadServer2";
        Set<String> serverSet = new HashSet<>(Arrays.asList("uploadServer1", "uploadServer2"));
        for (int i=0; i<100;i++) {
            String server = FileServerUtil.getRandomServer(servers);
            Assert.assertTrue(serverSet.contains(server));
        }
    }
}