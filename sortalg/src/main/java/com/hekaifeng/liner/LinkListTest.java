package com.hekaifeng.liner;

public class LinkListTest {

    public static void main(String[] args) {
        LinkList<String> integerLinkList = new LinkList<>();
        integerLinkList.insert("ljr");
        integerLinkList.insert("htj");
        integerLinkList.insert("ll");
        integerLinkList.insert("hkf");
        integerLinkList.insert("hzx");
        for (String str : integerLinkList) {
            System.out.println("元素:" + str);
        }

        integerLinkList.reverse();
        System.out.println("反转链表");
        for (String str : integerLinkList) {
            System.out.println("元素:" + str);
        }

        System.out.println("第0个元素:" + integerLinkList.get(0));
        integerLinkList.remove(3);
        System.out.println("移除后元素个数:" + integerLinkList.length());
        for (String str : integerLinkList) {
            System.out.println("元素:" + str);
        }
        integerLinkList.clear();
        System.out.println("集合长度:" + integerLinkList.length());
    }
}
