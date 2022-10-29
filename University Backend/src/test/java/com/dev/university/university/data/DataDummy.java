package com.dev.university.university.data;

import com.dev.university.university.model.entities.Career;

public class DataDummy {

    public static Career career1() {
        return new Career(null, "System Engineering", 50, 5);
    }

    public static Career career2() {
        return new Career(null, "Degree Bachelor", 45, 5);
    }

    public static Career career3() {
        return new Career(null, "Industrial Engineering", 45, 5);
    }
}
