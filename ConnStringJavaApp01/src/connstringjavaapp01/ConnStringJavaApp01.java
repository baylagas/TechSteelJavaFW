package connstringjavaapp01;

import connstringjavaapp01.objects.ConnString;

public class ConnStringJavaApp01 
        
{

    public static void main(String[] args) 
    {
        String strConn = "jdbc:mysql://localhost/namedb?"
                + "user=root&"
                + "password=12345&"
                + "autoReconnect=true&"
                + "useSSL=false";
        
        ConnString conn = new ConnString("localhost","namedb","root","12345");
        
        conn.useUnicodeON();
        conn.setUseUnicode(true);
        conn.useUnicodeOFF();
        
        conn.verifyServerCertificateON();
        conn.setVerifyServerCertificate(true);
        conn.verifyServerCertificateOFF();
        
        conn.useJDBCCompliantTimezoneShiftON();
        conn.setUseJDBCCompliantTimezoneShift(true);
        conn.useJDBCCompliantTimezoneShiftOFF();
        
        conn.useLegacyDatetimeCodeON();
        conn.setUseLegacyDatetimeCode(true);
        conn.useLegacyDatetimeCodeOFF();
        
        conn.serverTimezoneON();
        conn.serverTimezoneOFF();
        
        System.out.println(conn);
    }
    
}
