package something;

import something.override.FatherClass;
import something.override.SonClass;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutorService;

/**
 * Author： fanyafeng
 * Data： 2019-12-03 14:20
 * Email: fanyafeng@live.cn
 */
public class TestOverride {
    public static void main(String[] args) {
//        SonClass sonClass = new SonClass();

//        System.out.println();
//        sonClass.testNorMethod();
        String time = String.valueOf(System.currentTimeMillis() / 1000L);
        System.out.println(System.currentTimeMillis() / 1000L);
        System.out.println(TimeStamp2Date("1582100147"));
    }

    public static String TimeStamp2Date(String timestampString) {
        String formats = "yyyy-MM-dd HH:mm:ss";
        Long timestamp = Long.parseLong(timestampString) * 1000;
        String date = new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
        return date;
    }

}


