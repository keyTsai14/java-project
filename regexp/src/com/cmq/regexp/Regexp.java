package com.cmq.regexp;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author admin
 * @Date 2022/4/12
 **/
public class Regexp {

    public static void main(String[] args) {

        String content = "abc11c8ABC";
        String regStr = "abc";
        Pattern pattern = Pattern.compile(regStr,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
        }
    }

}
