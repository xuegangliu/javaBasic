package org.lxg.basic.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

/**************************
 * @description: WordUtil
 * @author xuegangliu
 * @date: 2019/1/29 10:37
 ***************************/
public class WordUtil {
    private static Configuration configuration = null;
    private static final String templateFolder = WordUtil.class.getClassLoader().getResource("").
            getPath()+File.separatorChar+"config/tmp/";

    static {
        configuration = new Configuration(new Version("2.3.0.1"));
        configuration.setDefaultEncoding("utf-8");
        try {
            configuration.setDirectoryForTemplateLoading(new File(templateFolder));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建doc文档
     * @param dataMap 模板中占位符的map值
     * @param ftlFile 模板文件
     * @param outName 文档名称
     * @return
     * @throws IOException
     */
    public static File createDoc(Map<?, ?> dataMap ,String ftlFile,String outName) throws IOException {
        Template t = configuration.getTemplate(ftlFile);
        File f = new File(outName);
        try {
            Writer w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
            t.process(dataMap, w);
            w.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return f;
    }
}
