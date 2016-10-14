package com.github.binarywang.demo.spring.util;

/**
 * User: mickzhang@tcl.com
 * Date: 2016-10-11
 * Time: 11:18
 */
public class PageStyleUtil {

    public static final int wrapLength = 30;

    /**
     * @param song
     */
    public static String autoWrap(String song) {
        StringBuffer wrapped = new StringBuffer();
        String line[] = song.split("<br>");
        StringBuffer newLine = new StringBuffer();
        for (int i = 0; i < line.length; i++) {
            System.out.println(line[i]);
            String oldLine = line[i];

            if (oldLine.length() > wrapLength) {
                String firstLetter = oldLine.substring(0, 2);
                if (firstLetter.equalsIgnoreCase("G—") || firstLetter.equalsIgnoreCase("D—")
                        || firstLetter.equalsIgnoreCase("A—") || firstLetter.equalsIgnoreCase("E—")
                        || firstLetter.equalsIgnoreCase("G|") || firstLetter.equalsIgnoreCase("D|")
                        || firstLetter.equalsIgnoreCase("A|") || firstLetter.equalsIgnoreCase("E|")
                        || firstLetter.equalsIgnoreCase("G||") || firstLetter.equalsIgnoreCase("D||")
                        || firstLetter.equalsIgnoreCase("A||") || firstLetter.equalsIgnoreCase("E||")
                        || firstLetter.equalsIgnoreCase("G/") || firstLetter.equalsIgnoreCase("D/")
                        || firstLetter.equalsIgnoreCase("A/") || firstLetter.equalsIgnoreCase("E/")
                        || firstLetter.equalsIgnoreCase("G/") || firstLetter.equalsIgnoreCase("D/")
                        || firstLetter.equalsIgnoreCase("A/") || firstLetter.equalsIgnoreCase("E/")
                        || firstLetter.equalsIgnoreCase("G —") || firstLetter.equalsIgnoreCase("D —")
                        || firstLetter.equalsIgnoreCase("A —") || firstLetter.equalsIgnoreCase("E —")
                        || firstLetter.equalsIgnoreCase("G:") || firstLetter.equalsIgnoreCase("D:")
                        || firstLetter.equalsIgnoreCase("A:") || firstLetter.equalsIgnoreCase("E:")
                        ) {
                    wrapped.append(oldLine.substring(0, wrapLength));
                    newLine.append(firstLetter);
                    newLine.append(oldLine.substring(wrapLength, oldLine.length()));
                    newLine.append("<br>");
                    if (firstLetter.equalsIgnoreCase("E—") || firstLetter.equalsIgnoreCase("E|") ||
                            firstLetter.equalsIgnoreCase("E/") || firstLetter.equalsIgnoreCase("E:") ||
                            firstLetter.equalsIgnoreCase("E —") || firstLetter.equalsIgnoreCase("E||")) {
                        wrapped.append("<br><br>");
                        wrapped.append(newLine);
                        newLine.delete(0, newLine.length());//清空
                    }
                } else {
                    // TODO: 2016/10/11
                    // 文字过长暂不处理
                    wrapped.append(oldLine);
                }
            } else {
                wrapped.append(oldLine);
            }
            wrapped.append("<br>");
        }
        return wrapped.toString();
    }

    public static void main(String[] args) {
        String l = "G———————————————————————————————";
        System.out.println(l.substring(0, 1).equalsIgnoreCase("G"));
    }
}
