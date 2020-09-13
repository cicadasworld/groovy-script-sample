package oop.beans

/**
 * create by
 * @author hujin 2020/9/9
 */
class Employee {
    String first, last, email

    String fullName

    String getFullName() {
        "Full Name: $fullName"
    }

    void setFullName(String name) {
        fullName = name
    }
}
