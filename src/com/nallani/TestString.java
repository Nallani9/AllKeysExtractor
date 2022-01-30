package com.nallani;

import java.util.Optional;

public class TestString {

    public static String call1() {
        String abc = "nallani-us-east-1";
        return abc.replace("-us-", "-").replace("-1", "");
    }

    public String call() {
        String abc = "nallani-us-east-1";
        return Optional.ofNullable(abc)
                .filter(str -> str.length() != 0)
                .map(str -> str.substring(0, str.length() - 2))
                .map(str -> str.replace("-us", ""))
                .orElse(abc);
    }

    public String call2() {
        String abc = "nallani-us-east-1";
        return Optional.ofNullable(abc)
                .filter(str -> str.length() != 0)
                .map(str -> str.substring(0, str.length() - 9))
                .map(str -> str.replace("-us", ""))
                .get().concat("sri");
    }

    public String call3() {
        String abc = "us-east-1";
        return Optional.ofNullable(abc)
                .filter(str -> str.length() != 0)
                .map(str -> str.substring(0, str.length() - 2))
                .map(str -> str.replace("-us", ""))
                .get()
                .replace("-us-", "-");
    }
}
