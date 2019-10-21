package org.qr.sue;

import com.sun.jna.Memory;
import com.sun.jna.NativeLong;
import com.sun.jna.ptr.LongByReference;
import com.heta.blackbox.client.impl.ecan.*;
import com.heta.blackbox.device.*;
import com.heta.blackbox.ecan.EcanVci;
import com.heta.blackbox.ecan.protocol.CAN_OBJ;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.channels.Channel;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ToString
public class KeySightDevice extends AbstractDevice {

    private Map<Integer, Channel> canMap = new HashMap<>();
    private KeySightVci KEYSIGHTINSTANCE;
    private EcanVci INSTANCE;
    private DeviceInfo keySightdeviceInfo;
    private boolean inited = false;
    private boolean isOpened = false;
    private boolean isSetVol = false;
    private boolean isSetEle = false;
    LongByReference defaultSession;
    LongByReference vipSession;
    private LongByReference VI_ATTR_SUPPRESS_END_EN;
    private LongByReference VI_ATTR_TERMCHAR_EN;

    public KeySightDevice() {
        KEYSIGHTINSTANCE = KeySightVci.KEYSIGHTINSTANCE;
    }

    public KeySightDevice(String ip, int port, int startinf) {
        super(ip, port, startinf);
//        if (KEYSIGHTINSTANCE != null) {
//            log.error("KEYSIGHTINSTANCE已经存在，不可以再进行构造");
//            throw new IllegalStateException("KEYSIGHTINSTANCE已经存在，不可以再进行构造");
//        }
        KEYSIGHTINSTANCE = KeySightVci.KEYSIGHTINSTANCE;
    }

    @Override
    public boolean open() {
        if (isOpened) {
            return true;
        }
//        try {
//            Socket s = new Socket("192.168.1.110",5024);
//        } catch (IOException e) {
//            log.error("连接设备失败");
//            return false;
//        }
//        defaultSession = new LongByReference(getStartInf());
        try {
            String path = "D:\\台架\\keysight.xlsx";
            InputStream inputStream = null;
            inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheet("IP");
            String eleIp = sheet.getRow(0).getCell(1).getStringCellValue();
            String curIp = sheet.getRow(1).getCell(1).getStringCellValue();
            defaultSession = new LongByReference(59005407);
            int result = KEYSIGHTINSTANCE.viOpenDefaultRM(defaultSession);
            if (result != KEYSIGHTINSTANCE.STATUS_OK) {
                return false;
            }
            vipSession = new LongByReference(0);
            String cmd = "TCPIP0::" + curIp + "::inst0::INSTR";
//        String cmd = "TCPIP0::192.168.0.120::5024::SOCKET";
//        String cmd = "USB0::0x2A8D::0x1301::MY59000220::0::INSTR";
            NativeLong a = new NativeLong(defaultSession.getValue());
            NativeLong b = new NativeLong(0);
            result = KEYSIGHTINSTANCE.viOpen(a, cmd, b, b, vipSession);
            if (result != KEYSIGHTINSTANCE.STATUS_OK) {
                return false;
            }
            keySightdeviceInfo = createInfo();
            //log.info("连接ip={}的设备成功", getIP());
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.uid("KeySight");
        for (int i = 0; i < keySightdeviceInfo.getCanNum(); i++) {
            Channel channel = new Channel(i, this);
            canMap.put(i, channel);
        }
        inited = true;
        isOpened = true;
        return true;
//        try {
//            Socket socket = new Socket(getIP(), getPort());
//            System.out.println(socket.isConnected());
//
//        } catch (IOException e) {
//            log.error("连接ip={}，port={},启动信息={}失败", getIP(), getPort(), getStartInf());
//        }
//        return true;
    }

    @Override
    public boolean close() {
        NativeLong a = new NativeLong(vipSession.getValue());
        int result = KEYSIGHTINSTANCE.viClose(a);
        if (result != KEYSIGHTINSTANCE.STATUS_OK) {
            System.out.println(result);
            return false;
        }
        NativeLong b = new NativeLong(defaultSession.getValue());
        result = KEYSIGHTINSTANCE.viClose(b);
        if (result != KEYSIGHTINSTANCE.STATUS_OK) {
//            log.info("KeySight退出远程模式失败");
            System.out.println("KeySight退出远程模式失败");
            return false;
        }
//        log.info("KeySight退出远程模式成功");
        System.out.println("KeySight退出远程模式成功");
        return true;
    }


    public Boolean VI_ATTR_SUPPRESS_END_EN() {
        VI_ATTR_SUPPRESS_END_EN = new LongByReference(0x3fff0036);
        NativeLong a = new NativeLong(vipSession.getValue());
        NativeLong end = new NativeLong(VI_ATTR_SUPPRESS_END_EN.getValue());
        int result = KEYSIGHTINSTANCE.viSetAttribute(a, end, "VI_TRUE");
        if (result != KEYSIGHTINSTANCE.STATUS_OK) {
            return false;
        }
        return true;
    }

    public Boolean VI_ATTR_TERMCHAR_EN() {
        VI_ATTR_TERMCHAR_EN = new LongByReference(0x3fff0038);
        NativeLong a = new NativeLong(vipSession.getValue());
        NativeLong end = new NativeLong(VI_ATTR_TERMCHAR_EN.getValue());
        int result = KEYSIGHTINSTANCE.viSetAttribute(a, end, "VI_TRUE");
        if (result != KEYSIGHTINSTANCE.STATUS_OK) {
            return false;
        }
        return true;
    }

    public Boolean writeCmd(String cmdStr) {
//        VI_ATTR_SUPPRESS_END_EN();
//        VI_ATTR_TERMCHAR_EN();
        NativeLong a = new NativeLong(vipSession.getValue());
        int result = KEYSIGHTINSTANCE.viPrintf(a, "%s\n", cmdStr);
        if (result != KEYSIGHTINSTANCE.STATUS_OK) {
//            log.error("执行命令失败,result={}", result);
            System.out.println("执行命令失败,result=" + result);
        }
        return true;
    }

    public String readResult() {
        NativeLong a = new NativeLong(vipSession.getValue());
        Memory mem = new Memory(200);
        int result = KEYSIGHTINSTANCE.viScanf(a, "%t", mem);
        if (result != KEYSIGHTINSTANCE.STATUS_OK) {
            System.out.println(result);
            return null;
        }
        return mem.getString(0);
    }

    public boolean setVolCONF() {
        if (isSetVol) {
            return true;
        }
//        if (writeCmd("FUNC \"VOLT:DC\"") && writeCmd("VOLT:RANG 10")) {
        if (writeCmd("CONF:VOLT 0.1") && writeCmd("CONF:VOLT 0.1")) {
//            log.info("设置为DC电压模式");
            System.out.println("设置为DC电压模式");
            isSetVol = true;
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    public boolean setEleCONF() {
        if (isSetEle) {
            return true;
        }
        if (writeCmd("CONF:CURR 3") && writeCmd("CURR:DC:RANG 3")) {
            //log.info("设置为DC电流模式");
            System.out.println("设置为DC电流模式");

            isSetEle = true;
            return true;
        }
        return false;
    }

}