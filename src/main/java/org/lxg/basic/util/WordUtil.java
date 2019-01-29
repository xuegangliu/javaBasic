package org.lxg.basic.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
/**************************
 * @description: WordUtil
 * @user: xuegangliu
 * @date: 2019/1/29 10:37
 ***************************/
public class WordUtil {
    //配置信息,代码本身写的还是很可读的,就不过多注解了
    private static Configuration configuration = null;
    //这里注意的是利用WordUtils的类加载器动态获得模板文件的位置
    private static final String templateFolder = WordUtil.class.getClassLoader().getResource("").
            getPath()+File.separatorChar+"config/tmp/";

    static {
        configuration = new Configuration();
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
