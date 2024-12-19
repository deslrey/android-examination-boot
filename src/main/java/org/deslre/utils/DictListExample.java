package org.deslre.utils;

import org.deslre.entity.po.Dict;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DictListExample {

    public static List<Dict> getDictList() {
        List<Dict> dictList = new ArrayList<>();

        String path = "D:\\dem\\qwerty-learner\\public\\";

        dictList.add(new Dict("coder", "Coder Dict", "程序员常见单词词库", "代码练习", List.of("通用"), path + "dicts\\it-words.json", 1700, "code", "code"));
        dictList.add(new Dict("childCode", "少儿 Python", "少儿 Python 常见词", "代码练习", Arrays.asList("少儿编程", "Python"), path + "dicts\\Child_python_code.json", 19, "en", "code"));
        dictList.add(new Dict("childCode002", "少儿 Python Turtle", "少儿 Python Turtle 常见词", "代码练习", Arrays.asList("少儿编程", "Python"), path + "dicts\\Child_python_turtle_code.json", 27, "en", "code"));
        dictList.add(new Dict("childCode003", "少儿 C++", "少儿 C++ 常见词", "代码练习", Arrays.asList("少儿编程", "C++"), path + "dicts\\Child_cpp.json", 39, "en", "code"));
        dictList.add(new Dict("oi-xcpc", "OI / XCPC 竞赛词汇", "OI / XCPC 竞赛词汇", "代码练习", List.of("C++"), path + "dicts\\OI_XCPC.json", 195, "en", "code"));
        dictList.add(new Dict("childCode004", "Arduino", "Arduino常见词", "代码练习", Arrays.asList("少儿编程", "Arduino"), path + "dicts\\arduino_keywords.json", 78, "en", "code"));
        dictList.add(new Dict("jsArray", "JS: Array", "JavaScript API 词典", "代码练习", List.of("JavaScript"), path + "dicts\\js-array.json", 36, "code", "code"));
        dictList.add(new Dict("jsDate", "JS: Date", "JavaScript API 词典", "代码练习", List.of("JavaScript"), path + "dicts\\js-date.json", 34, "code", "code"));
        dictList.add(new Dict("jsGlobal", "JS: Global", "JavaScript API 词典", "代码练习", List.of("JavaScript"), path + "dicts\\js-global.json", 9, "code", "code"));
        dictList.add(new Dict("jsMapSet", "JS: Map & Set", "JavaScript API 词典", "代码练习", List.of("JavaScript"), path + "dicts\\js-map-set.json", 16, "code", "code"));
        dictList.add(new Dict("jsMath", "JS: Math", "JavaScript API 词典", "代码练习", List.of("JavaScript"), path + "dicts\\js-math.json", 38, "code", "code"));
        dictList.add(new Dict("jsNumber", "JS: Number", "JavaScript API 词典", "代码练习", List.of("JavaScript"), path + "dicts\\js-number.json", 22, "code", "code"));
        dictList.add(new Dict("jsObject", "JS: Object", "JavaScript API 词典", "代码练习", List.of("JavaScript"), path + "dicts\\js-object.json", 37, "code", "code"));
        dictList.add(new Dict("jsPromise", "JS: Promise", "JavaScript API 词典", "代码练习", List.of("JavaScript"), path + "dicts\\js-promise.json", 9, "code", "code"));
        dictList.add(new Dict("jsString", "JS: String", "JavaScript API 词典", "代码练习", List.of("JavaScript"), path + "dicts\\js-string.json", 32, "code", "code"));
        dictList.add(new Dict("python-builtin", "Python: Built-in", "Python Built-in API", "代码练习", List.of("Python"), path + "dicts\\python-builtin.json", 65, "code", "code"));
        dictList.add(new Dict("python-array", "Python: array", "Python array API", "代码练习", List.of("Python"), path + "dicts\\python-array.json", 11, "code", "code"));
        dictList.add(new Dict("python-date", "Python: date", "Python date API", "代码练习", List.of("Python"), path + "dicts\\python-date.json", 39, "code", "code"));
        dictList.add(new Dict("python-file", "Python: file", "Python file API", "代码练习", List.of("Python"), path + "dicts\\python-file.json", 21, "code", "code"));
        dictList.add(new Dict("python-class", "Python: class", "Python class API", "代码练习", List.of("Python"), path + "dicts\\python-class.json", 13, "code", "code"));
        dictList.add(new Dict("python-set", "Python: set", "Python set API", "代码练习", List.of("Python"), path + "dicts\\python-set.json", 29, "code", "code"));
        dictList.add(new Dict("python-math", "Python: math", "Python math API", "代码练习", List.of("Python"), path + "dicts\\python-math.json", 37, "code", "code"));
        dictList.add(new Dict("python-string", "Python: string", "Python string API", "代码练习", List.of("Python"), path + "dicts\\python-string.json", 40, "code", "code"));
        dictList.add(new Dict("python-system", "Python: system", "Python system API", "代码练习", List.of("Python"), path + "dicts\\python-sys.json", 24, "code", "code"));
        return dictList;
    }

    public static void main(String[] args) {
        List<Dict> dicts = getDictList();
        for (Dict dict : dicts) {
            System.out.println("ID: " + dict.getId() + ", Name: " + dict.getName());
        }
    }
}
