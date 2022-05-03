package cn.edu.guet.shopdemo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CatchNullException {
    public int  notNull(String message){   //获取异常描述属于非空还是唯一约束
        int chose = 0;
        String duplicate="Duplicate";
        String username="username";
        String password="password";
        String patten=".+Exception: (.{8})";
        String patten1=".+Exception: (.{9})";
        Pattern r =Pattern.compile(patten);
        Matcher m =r.matcher(message);
        Pattern r1 =Pattern.compile(patten1);
        Matcher m1 =r1.matcher(message);
        if (m.find()){
            if (m.group(1).equals(password)){
                chose = 1;
            }
        }
        if (m1.find()){
            if (m1.group(1).equals(duplicate)){
                chose = 2;
            }
        }
        return chose;
    }

    public int catchEx(String message){
        int chose = 0;
        String duplicate="Duplicate";
        String username="username";
        String password="password";
        String patten=".+Column '(.{8})";
        String patten1=".+Exception: (.{9})";
        Pattern r =Pattern.compile(patten);
        Matcher m =r.matcher(message);
        Pattern r1 =Pattern.compile(patten1);
        Matcher m1 =r1.matcher(message);
        if (m.find()){
            if (m.group(1).equals(password)){
                chose = 1;
            }
        }
        if (m1.find()){
            if (m1.group(1).equals(duplicate)){
                chose = 2;
            }
        }
        return chose;
    }
}
