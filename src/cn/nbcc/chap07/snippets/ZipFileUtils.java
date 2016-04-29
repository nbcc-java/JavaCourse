/**
 * ��������cn.nbcc.chap07.snippets
 * �ļ�����ZipUnZipUsingAnt.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-6-11 ����09:14:09
 */
package cn.nbcc.chap07.snippets;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

/**
 * ����:zipѹ������ѹ(֧�������ļ���)
 * ˵��:ʹ��Apache Ant�ṩ��zip����org.apache.tools.zipʵ��zipѹ���ͽ�ѹ����.
 * ���������java.util.zip����֧�ֺ��ֵ����⡣
 * ʹ��java.util.zip��ʱ,��zip�ļ���������Ϊ���ĵ��ļ�ʱ,
 * �ͻ�����쳣:
 * "Exception  in thread "main " java.lang.IllegalArgumentException
 * at   java.util.zip.ZipInputStream.getUTF8String(ZipInputStream.java:285)
 * <p/>
 * <p/>
 * ע��:
 * 1��ʹ��ʱ��ant.jar�ŵ�classpath��,������ʹ�� import org.apache.tools.zip.*;
 * 2��������ʹ��Ant 1.7.1 �е�ant.jar�����࣬ant-zip-1.7.1ֻ����Ant��zipѹ�����ܣ��Լ�Сant.jar�Ĵ�С��
 * 4��ZipEntry��isDirectory()������,Ŀ¼��"/"��β��
 * <p/>
 * <p/>
 * ------------------------------------------------
 * �ɽ�������ע��ȥ���Ե�������ZipFileUtils�ࡣ
 * Compile:
 * javac -cp Ant.jar ZipFileUtils.java
 * <p/>
 * Usage:(��ant.jarֱ�ӷ��ڵ�ǰĿ¼)
 * ѹ��: java -cp Ant.jar;.  ZipFileUtils -zip [directoryName | fileName]...
 * ��ѹ: java -cp Ant.jar;.  ZipFileUtils -unzip "fileName.zip"
 * <p/>
 * ------------------------------------------------
 */
public class ZipFileUtils
{
    private static int bufSize = 8096;    //size of bytes


    /**
     * ѹ���ļ����ڵ������ļ���Ŀ¼(��֧��������Ŀ¼���ļ���)��
     *
     * @param zipDirectory ��Ҫѹ�����ļ�����
     * @return �ɹ�����null�����򷵻�ʧ����Ϣ
     */
    public static String zip(String zipDirectory)
    {
        File zipDir = new File(zipDirectory);
        return zip(zipDirectory, zipDir.getPath(), false);
    }

    /**
     * ѹ���ļ����ڵ������ļ���Ŀ¼(��֧��������Ŀ¼���ļ���)��
     *
     * @param zipDirectory   ��Ҫѹ�����ļ�����
     * @param zipFileName    ѹ�����zip�ļ����������׺����".zip, .jar, .war"�� �Զ���Ӻ�׺".zip"��
     * @param includeSelfDir �Ƿ���������ļ���
     * @return �ɹ�����null�����򷵻�ʧ����Ϣ
     */
    public static String zip(String zipDirectory, String zipFileName, boolean includeSelfDir)
    {
        File zipDir = new File(zipDirectory);
        File[] willZipFileArr;
        if(includeSelfDir || zipDir.isFile())
        {
            willZipFileArr = new File[]{zipDir};
        }
        else
        {
            willZipFileArr = zipDir.listFiles();
        }
        return zip(willZipFileArr, zipFileName);
    }

    /**
     * ѹ������ļ���Ŀ¼������ָ������������ļ���Ŀ¼��
     *
     * @param files       Ҫѹ�����ļ���Ŀ¼��ɵ�<code>File</code>���顣
     * @param zipFileName ѹ�����zip�ļ����������׺����".zip, .jar, .war"���Զ���Ӻ�׺".zip"��
     * @return �ɹ�����null�����򷵻�ʧ����Ϣ
     */
    public static String zip(File[] files, String zipFileName)
    {
        if(files == null)
        {
            return "��ѹ�����ļ������ڡ�";
        }

        //δָ��ѹ���ļ�����Ĭ��Ϊ"ZipFile"
        if(zipFileName == null || zipFileName.equals(""))
            zipFileName = "ZipFile";

        //���".zip"��׺
        if(!zipFileName.toLowerCase().endsWith(".zip")
            && !zipFileName.toLowerCase().endsWith(".jar") && !zipFileName.toLowerCase().endsWith(".war"))
            zipFileName += ".zip";

        JarOutputStream jarOutput = null;
        try
        {
            jarOutput = new JarOutputStream(new FileOutputStream(zipFileName), new Manifest());

            for(File file : files)
            {
                zipFiles(file, jarOutput, "");
            }

        } catch(Exception e)
        {
        } finally
        {
            if(jarOutput != null)
            {
                try
                {
                    jarOutput.close();
                } catch(IOException e)
                {
                }
            }
        }
        return null;
    }

    /**
     * @param file     ѹ���ļ�
     * @param jos      JarOutputStream
     * @param pathName ���·��
     * @throws Exception �쳣
     */
    private static void zipFiles(File file, JarOutputStream jos, String pathName)
        throws Exception
    {
        String fileName = pathName + file.getName();
        if(file.isDirectory())
        {
            fileName = fileName + "/";
            jos.putNextEntry(new JarEntry(fileName));
            String fileNames[] = file.list();
            if(fileNames != null)
            {
                for(int i = 0; i < fileNames.length; i++)
                {
                    zipFiles(new File(file, fileNames[i]), jos, fileName);
                }
                jos.closeEntry();
            }
        }
        else
        {
            JarEntry jarEntry = new JarEntry(fileName);
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
            jos.putNextEntry(jarEntry);

            byte[] buf = new byte[bufSize];
            int len;
            while((len = in.read(buf)) >= 0)
            {
                jos.write(buf, 0, len);
            }
            in.close();
            jos.closeEntry();
        }
    }

    /**
     * ѹ���ļ����ڵ������ļ���Ŀ¼��֧������
     *
     * @param zipDirectory ��Ҫѹ�����ļ�����
     * @return �ɹ�����null�����򷵻�ʧ����Ϣ
     */
    public static String antzip(String zipDirectory)
    {
        File zipDir = new File(zipDirectory);
        return antzip(zipDirectory, zipDir.getPath(), false);
    }

    /**
     * ѹ���ļ����ڵ������ļ���Ŀ¼��
     *
     * @param zipDirectory   ��Ҫѹ�����ļ�����
     * @param zipFileName    ѹ�����zip�ļ����������׺����".zip, .jar, .war"�� �Զ���Ӻ�׺".zip"��
     * @param includeSelfDir �Ƿ���������ļ���
     * @return �ɹ�����null�����򷵻�ʧ����Ϣ
     */
    public static String antzip(String zipDirectory, String zipFileName, boolean includeSelfDir)
    {
        File zipDir = new File(zipDirectory);
        File[] willZipFileArr;
        if(includeSelfDir || zipDir.isFile())
        {
            willZipFileArr = new File[]{zipDir};
        }
        else
        {
            willZipFileArr = zipDir.listFiles();
        }
        return antzip(willZipFileArr, zipFileName);
    }

    /**
     * ѹ������ļ���Ŀ¼������ָ������������ļ���Ŀ¼��
     *
     * @param files       Ҫѹ�����ļ���Ŀ¼��ɵ�<code>File</code>���顣
     * @param zipFileName ѹ�����zip�ļ����������׺����".zip, .jar, .war"���Զ���Ӻ�׺".zip"��
     * @return �ɹ�����null�����򷵻�ʧ����Ϣ
     */
    public static String antzip(File[] files, String zipFileName)
    {
        //δָ��ѹ���ļ�����Ĭ��Ϊ"ZipFile"
        if(zipFileName == null || zipFileName.equals(""))
            zipFileName = "ZipFile";

        //���".zip"��׺
        if(!zipFileName.toLowerCase().endsWith(".zip")
            && !zipFileName.toLowerCase().endsWith(".jar") && !zipFileName.toLowerCase().endsWith(".war"))
            zipFileName += ".zip";

        ZipOutputStream zipOutput = null;
        try
        {
            zipOutput = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(zipFileName)));
            zipOutput.setEncoding("GBK");//֧������

            for(File file : files)
            {
                antzipFiles(file, zipOutput, "");
            }

        } catch(Exception e)
        {
            return e.getMessage();
        }
        finally
        {
            try
            {
                assert zipOutput != null;
                zipOutput.close();
            } catch(Exception e)
            {
            }
        }
        return null;
    }

    /**
     * @param file      ѹ���ļ�
     * @param zipOutput ZipOutputStream
     * @param pathName  ���·��
     * @throws Exception �쳣
     */
    private static void antzipFiles(File file, ZipOutputStream zipOutput, String pathName)
        throws Exception
    {
        String fileName = pathName + file.getName();
        if(file.isDirectory())
        {
            fileName = fileName + "/";
            zipOutput.putNextEntry(new ZipEntry(fileName));
            String fileNames[] = file.list();
            if(fileNames != null)
            {
                for(int i = 0; i < fileNames.length; i++)
                {
                    antzipFiles(new File(file, fileNames[i]), zipOutput, fileName);
                }
                zipOutput.closeEntry();
            }
        }
        else
        {
            ZipEntry jarEntry = new ZipEntry(fileName);
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
            zipOutput.putNextEntry(jarEntry);

            byte[] buf = new byte[bufSize];
            int len;
            while((len = in.read(buf)) >= 0)
            {
                zipOutput.write(buf, 0, len);
            }
            in.close();
            zipOutput.closeEntry();
        }
    }

    /**
     * ��ѹָ��zip�ļ���
     *
     * @param unZipFile ��Ҫ��ѹ��zip�ļ�����
     * @return �ɹ�����null�����򷵻�ʧ����Ϣ
     */
    public static String unZip(File unZipFile)
    {
        return unZip(unZipFile.getPath(), null);
    }

    /**
     * ��ѹָ��zip�ļ���ָ����Ŀ¼��
     *
     * @param unZipFile    ��Ҫ��ѹ��zip�ļ�����
     * @param destFileName ��ѹĿ��Ŀ¼
     * @return �ɹ�����null�����򷵻�ʧ����Ϣ
     */
    public static String unZip(File unZipFile, String destFileName)
    {
        return unZip(unZipFile.getPath(), destFileName);
    }

    /**
     * ��ѹָ��zip�ļ���
     *
     * @param unZipFileName ��Ҫ��ѹ��zip�ļ���
     * @return �ɹ�����null�����򷵻�ʧ����Ϣ
     */
    public static String unZip(String unZipFileName)
    {
        return unZip(unZipFileName, null);
    }

    
    /**
     * ��ѹָ��zip�ļ���ָ����Ŀ¼��
     *
     * @param unZipFileName ��Ҫ��ѹ��zip�ļ���
     * @param destFileName  ��ѹĿ��Ŀ¼�����Ϊnull��Ϊ��ǰzip�ļ�����Ŀ¼
     * @return �ɹ�����null�����򷵻�ʧ����Ϣ
     */
    public static String unZip(String unZipFileName, String destFileName)
    {
        File unzipFile = new File(unZipFileName);

        if(destFileName == null || destFileName.trim().length() == 0)
        {
            destFileName = unzipFile.getParent();
        }

        File destFile;
        ZipFile zipFile = null;
        try
        {
            zipFile = new ZipFile(unzipFile, "GBK");//���������������
            for(Enumeration entries = zipFile.getEntries(); entries.hasMoreElements();)
            {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                destFile = new File(destFileName, entry.getName());

                unZipFile(destFile, zipFile, entry); //ִ�н�ѹ
            }
        } catch(Exception e)
        {
            return e.getMessage();
        }
        finally
        {
            try
            {
                assert zipFile != null;
                zipFile.close();
            } catch(Exception e)
            {
            }
        }
        return null;
    }

    /* ִ�н�ѹ */
    private static void unZipFile(File destFile, ZipFile zipFile, ZipEntry entry)
        throws IOException
    {
        InputStream inputStream;
        FileOutputStream fileOut;
        if(entry.isDirectory()) //��Ŀ¼���򴴽�֮
        {
            destFile.mkdirs();
        }
        else //���ļ�
        {
            //���ָ���ļ��ĸ�Ŀ¼������,�򴴽�֮.
            File parent = destFile.getParentFile();
            if(parent != null && !parent.exists())
            {
                parent.mkdirs();
            }

            inputStream = zipFile.getInputStream(entry);

            fileOut = new FileOutputStream(destFile);
            byte[] buf = new byte[bufSize];
            int readedBytes;
            while((readedBytes = inputStream.read(buf)) > 0)
            {
                fileOut.write(buf, 0, readedBytes);
            }
            fileOut.close();

            inputStream.close();
        }
    }

    /**
     * ����ѹ�����ѹʱ��������С����λ�ֽڡ�
     *
     * @param bufSize ��������С
     */
    public void setBufSize(int bufSize)
    {
        ZipFileUtils.bufSize = bufSize;
    }

    //�����������ڲ���ZipFileUtils��
    public static void main(String[] args) throws Exception
    {
    	String msg = ZipFileUtils.antzip("C:\\Users\\Administrator\\Desktop\\��������2014���У��������Ŀ�걨������֪ͨ");
    	System.out.println(msg);
//        ZipFileUtils.unZip(new File("c:/a.zip"));
    }

}

