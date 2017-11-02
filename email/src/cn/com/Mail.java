package cn.com;

import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;

/**
 * JavaMail �汾: 1.6.0
 * JDK �汾: JDK 1.7 ���ϣ����룩
 */
public class Mail {

    public static void main(String[] args) throws Exception {
        // 1. ����һ���ʼ�
        Properties props = new Properties();                // ���������ʼ��������Ĳ������ã������ʼ�ʱ����Ҫ�õ���
        Session session= Session.getInstance(props);        // ���ݲ������ã������Ự����Ϊ�˷����ʼ�׼���ģ�
        MimeMessage message = new MimeMessage(session);     // �����ʼ�����

        /*
         * Ҳ���Ը������е�eml�ʼ��ļ����� MimeMessage ����
         * MimeMessage message = new MimeMessage(session, new FileInputStream("MyEmail.eml"));
         */

        // 2. From: ������
        //    ���� InternetAddress �����������ֱ�Ϊ: ����, ��ʾ���ǳ�(ֻ������ʾ, û���ر��Ҫ��), �ǳƵ��ַ�������
        //    ����Ҫ����ʱ, �����������ʵ��Ч�����䡣
        message.setFrom(new InternetAddress("hr1432391788@163.com", "USER_AA", "UTF-8"));

        // 3. To: �ռ���
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("1432391788qq.com", "USER_CC", "UTF-8"));
        //    To: �����ռ��ˣ���ѡ��
//        message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress("1432391788qq.com", "USER_DD", "UTF-8"));
        //    Cc: ���ͣ���ѡ��
//        message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress("1432391788qq.com", "USER_EE", "UTF-8"));
        //    Bcc: ���ͣ���ѡ��
//        message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress("1432391788qq.com", "USER_FF", "UTF-8"));

        // 4. Subject: �ʼ�����
        message.setSubject("TEST�ʼ�����", "UTF-8");

        // 5. Content: �ʼ����ģ�����ʹ��html��ǩ��
        message.setContent("TEST�����ʼ����ġ�����", "text/html;charset=UTF-8");

        // 6. ������ʾ�ķ���ʱ��
        message.setSentDate(new Date());

        // 7. ����ǰ�������
        message.saveChanges();

        // 8. �����ʼ����浽����
        OutputStream out = new FileOutputStream("MyEmail.eml");
        message.writeTo(out);
        out.flush();
        out.close();
    }

}
