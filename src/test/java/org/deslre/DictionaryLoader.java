package org.deslre;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.deslre.entity.po.DictionaryItem;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DictionaryLoader {

    public static List<DictionaryItem> loadDictionaryData(String filePath) throws IOException {
        // 创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();
        
        // 读取JSON文件并转换为List<DictionaryItem>
        return objectMapper.readValue(new File(filePath), objectMapper.getTypeFactory().constructCollectionType(List.class, DictionaryItem.class));
    }

    public static void main(String[] args) {
        try {
            List<DictionaryItem> dictionaryItems = loadDictionaryData("C:\\Users\\肖鑫欢\\Desktop\\words.txt");
            
            // 打印数据
            for (DictionaryItem item : dictionaryItems) {
                System.out.println("item = " + item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
