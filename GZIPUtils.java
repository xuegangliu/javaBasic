
  
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream; 

import org.apache.commons.codec.binary.Base64;
 public abstract class GZIPUtils {  

    public static final int BUFFER = 1024;  
    public static final String EXT = ".gz";  

    /** 
     * 数据压缩 
     *  
     * @param data 
     * @return 
     * @throws Exception 
     */  
    public static byte[] compress(byte[] data) throws Exception {  
        ByteArrayInputStream bais = new ByteArrayInputStream(data);  
        ByteArrayOutputStream baos = new ByteArrayOutputStream();  

        // 压缩  
        compress(bais, baos);  

        byte[] output = baos.toByteArray();  

        baos.flush();  
        baos.close();  

        bais.close();  

        return output;  
    }  

    /** 
     * 文件压缩 
     *  
     * @param file 
     * @throws Exception 
     */  
    public static void compress(File file) throws Exception {  
        compress(file, true);  
    }  

    /** 
     * 文件压缩 
     *  
     * @param file 
     * @param delete 
     *            是否删除原始文件 
     * @throws Exception 
     */  
    public static void compress(File file, boolean delete) throws Exception {  
        FileInputStream fis = new FileInputStream(file);  
        FileOutputStream fos = new FileOutputStream(file.getPath() + EXT);  

        compress(fis, fos);  

        fis.close();  
        fos.flush();  
        fos.close();  

        if (delete) {  
            file.delete();  
        }  
    }  

    /** 
     * 数据压缩 
     *  
     * @param is 
     * @param os 
     * @throws Exception 
     */  
    public static void compress(InputStream is, OutputStream os)  
            throws Exception {  

        GZIPOutputStream gos = new GZIPOutputStream(os);  

        int count;  
        byte data[] = new byte[BUFFER];  
        while ((count = is.read(data, 0, BUFFER)) != -1) {  
            gos.write(data, 0, count);  
        }  

        gos.finish();  

        gos.flush();  
        gos.close();  
    }  

    /** 
     * 文件压缩 
     *  
     * @param path 
     * @throws Exception 
     */  
    public static void compress(String path) throws Exception {  
        compress(path, true);  
    }  

    /** 
     * 文件压缩 
     *  
     * @param path 
     * @param delete 
     *            是否删除原始文件 
     * @throws Exception 
     */  
    public static void compress(String path, boolean delete) throws Exception {  
        File file = new File(path);  
        compress(file, delete);  
    }  

    /** 
     * 数据解压缩 
     *  
     * @param data 
     * @return 
     * @throws Exception 
     */  
    public static byte[] decompress(byte[] data) throws Exception {  
        ByteArrayInputStream bais = new ByteArrayInputStream(data);  
        ByteArrayOutputStream baos = new ByteArrayOutputStream();  

        // 解压缩  

        decompress(bais, baos);  

        data = baos.toByteArray();  

        baos.flush();  
        baos.close();  

        bais.close();  

        return data;  
    }  

    /** 
     * 文件解压缩 
     *  
     * @param file 
     * @throws Exception 
     */  
    public static void decompress(File file) throws Exception {  
        decompress(file, true);  
    }  

    /** 
     * 文件解压缩 
     *  
     * @param file 
     * @param delete 
     *            是否删除原始文件 
     * @throws Exception 
     */  
    public static void decompress(File file, boolean delete) throws Exception {  
        FileInputStream fis = new FileInputStream(file);  
        FileOutputStream fos = new FileOutputStream(file.getPath().replace(EXT,  
                ""));  
        decompress(fis, fos);  
        fis.close();  
        fos.flush();  
        fos.close();  

        if (delete) {  
            file.delete();  
        }  
    }  

    /** 
     * 数据解压缩 
     *  
     * @param is 
     * @param os 
     * @throws Exception 
     */  
    public static void decompress(InputStream is, OutputStream os)  
            throws Exception {  

        GZIPInputStream gis = new GZIPInputStream(is);  

        int count;  
        byte data[] = new byte[BUFFER];  
        while ((count = gis.read(data, 0, BUFFER)) != -1) {  
            os.write(data, 0, count);  
        }  

        gis.close();  
    }  

    /** 
     * 文件解压缩 
     *  
     * @param path 
     * @throws Exception 
     */  
    public static void decompress(String path) throws Exception {  
        decompress(path, true);  
    }  

    /** 
     * 文件解压缩 
     *  
     * @param path 
     * @param delete 
     *            是否删除原始文件 
     * @throws Exception 
     */  
    public static void decompress(String path, boolean delete) throws Exception {  
        File file = new File(path);  
        decompress(file, delete);  
    }  
    
    public static void main(String[] args) {
		String str = "<1f8b0800 00000000 0003ed99 cf6fd330 14c7effb 2ba29ed7 c9bf1d73 6b935620 8d31d169 17c4e191 b8c35a6a 47ae3b34 21fe77d2 75dd1454 714a0201 1f92c37b 8efdeccf d73f9ef3 e92c49be 374f924c 5cadedd2 bbcd2479 934cd0e4 fc60adbf 3aab9f4c 47cbc67d 3195be79 ac0f6673 bd2f91ac cc665741 70fe586c 5f5d069b 1acc9d6d 7daf1fb4 0d4f96b5 f1dbf071 678f1ea8 eb5bedb7 c6d92b77 88e2425d 60797417 5055fb66 9f9db855 610ee110 0f66142b ca712a84 7829b2db 6affae6c 855154a6 f9ec0a82 79d0cfae b5524494 1c942a4b 20055525 519c1129 94d4140a 25250581 58f1522b c02f95be f6a01de2 61cc5601 6c09be6c fbf6dd5a b99d2f74 7be483bb d7b63c36 d0d87e9c ff4958db 003ef446 8a46529d 91babe7c eb36fad6 e86f99b3 c1bbaad2 be0f7084 61825404 d721b80c fc35f8fb 01d8718a 545c1e3b 6697eb00 a61a821e c782457a 1dd2bb74 77c60e41 4e282a23 b90ec9cd e7ab81f6 3b812546 915d87ec de1b3b08 382a489c 7423c805 88c452c5 5c607cb9 c07e82c5 f3e408d7 46863096 71531be1 51b221a7 38ff6fc9 618e1026 4c3421f7 32fb1e33 a84d8001 b239869b 5e881320 15914b91 a5cdd29a 1346a598 e365aee6 394df96c 31cb94ea 053486b2 4c0b48a7 80049932 49d8345d 23340560 9c2326d7 3455bd8b 81ce2465 482e48be 60b35c2c 39268a2c 24ce9a98 90c0b3bf 4c2c835d db309ce2 2895314b e5c683dd d6ce870f bed47e00 c510d2ec 145131ff 8a6286ba 6264840a 742a678e ba19856e 7a4bd19b 3727a7fe fa4461fc 5618679f 7f026530 fb2f6c1f 0000>";
		str = "14141434142ewrwrwqrqewr3232323222";
		try {
			byte[] b = compress(str.getBytes());
//			System.out.println("===="+Base64.encodeBase64String(b));
			String bs = new String(b);
			System.out.println(bs);
			System.out.println("===="+new String(decompress(bs.getBytes())));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
 