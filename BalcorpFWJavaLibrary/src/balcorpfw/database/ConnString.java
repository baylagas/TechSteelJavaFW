package balcorpfw.database;

public class ConnString 
{
    private static final String CONN_STR_PROPERTY_START = "?";
    private static final String CONN_STR_PROPERTY_AND = "&";
    
    private StringBuilder m_strFinal;
    private String m_strBase;
    private String m_strUrl;
    private String m_strDatabase;
    private String m_strUser;
    private String m_strPassword;
    private boolean m_bAutoReconnect;
    private boolean m_bUseSSL;
    private boolean m_bAddVerifyServerCertificate;
    private boolean m_bValueVerifyServerCertificate;
    private boolean m_bAddUseUnicode;
    private boolean m_bValueUseUnicode;
    private boolean m_bAddUseJDBCCompliantTimezoneShift;
    private boolean m_bValueUseJDBCCompliantTimezoneShift;
    private boolean m_bAddUseLegacyDatetimeCode;
    private boolean m_bValueUseLegacyDatetimeCode;
    private boolean m_bAddServerTimezone;
    private String m_bValueServerTimezone;

    public ConnString(String p_strUrl, String p_strDatabase, String p_strUser, 
            String p_strPassword) 
    {
        setFinal( createFinal() );
        setBase( createBase() );
        initSetup(p_strUrl, p_strDatabase, p_strUser, p_strPassword);
    }

    public ConnString(String p_strBase, String p_strUrl, String p_strDatabase, 
            String p_strUser, String p_strPassword) 
    {
        setFinal( createFinal() );
        setBase(p_strBase);
        initSetup(p_strUrl, p_strDatabase, p_strUser, p_strPassword);
    }

    public StringBuilder getFinal() {
        return m_strFinal;
    }

    private void setFinal(StringBuilder p_strFinal) {
        this.m_strFinal = p_strFinal;
    }

    public String getBase() {
        return m_strBase;
    }

    private void setBase(String p_strBase) {
        this.m_strBase = p_strBase;
    }

    public String getUrl() {
        return m_strUrl;
    }

    private void setUrl(String p_strUrl) {
        this.m_strUrl = p_strUrl;
    }

    public String getDatabase() {
        return m_strDatabase;
    }

    private void setDatabase(String p_strDatabase) {
        this.m_strDatabase = p_strDatabase;
    }

    public String getUser() {
        return m_strUser;
    }

    private void setUser(String p_strUser) {
        this.m_strUser = p_strUser;
    }

    public String getPassword() {
        return m_strPassword;
    }

    private void setPassword(String p_strPassword) {
        this.m_strPassword = p_strPassword;
    }

    public boolean getAutoReconnect() {
        return m_bAutoReconnect;
    }

    public void setAutoReconnect(boolean p_bAutoReconnect) {
        this.m_bAutoReconnect = p_bAutoReconnect;
    }

    public boolean getUseSSL() {
        return m_bUseSSL;
    }

    public void setUseSSL(boolean p_bUseSSL) {
        this.m_bUseSSL = p_bUseSSL;
    }

    public boolean getAddVerifyServerCertificate() {
        return m_bAddVerifyServerCertificate;
    }

    private void setAddVerifyServerCertificate(boolean p_bValue) {
        this.m_bAddVerifyServerCertificate = p_bValue;
    }

    public void verifyServerCertificateON(){
        setAddVerifyServerCertificate(true);
    }
    
    public void verifyServerCertificateOFF(){
        setAddVerifyServerCertificate(false);
    }

    public boolean getVerifyServerCertificate() {
        return m_bValueVerifyServerCertificate;
    }
    
    public void setVerifyServerCertificate(boolean p_bValue) {
        this.m_bValueVerifyServerCertificate = p_bValue;
    }

    public boolean getAddUseUnicode() {
        return m_bAddUseUnicode;
    }

    private void setAddUseUnicode(boolean p_bValue) {
        this.m_bAddUseUnicode = p_bValue;
    }
    
    public void useUnicodeON(){
        setAddUseUnicode(true);
    }
    
    public void useUnicodeOFF(){
        setAddUseUnicode(false);
    }

    public boolean getUseUnicode() {
        return m_bValueUseUnicode;
    }

    public void setUseUnicode(boolean p_bValue) {
        this.m_bValueUseUnicode = p_bValue;
    }

    public boolean getAddUseJDBCCompliantTimezoneShift() {
        return m_bAddUseJDBCCompliantTimezoneShift;
    }

    private void setAddUseJDBCCompliantTimezoneShift(boolean p_bValue) {
        this.m_bAddUseJDBCCompliantTimezoneShift = p_bValue;
    }
    
    public void useJDBCCompliantTimezoneShiftON(){
        setAddUseJDBCCompliantTimezoneShift(true);
    }
    
    public void useJDBCCompliantTimezoneShiftOFF(){
        setAddUseJDBCCompliantTimezoneShift(false);
    }

    public boolean getUseJDBCCompliantTimezoneShift() {
        return m_bValueUseJDBCCompliantTimezoneShift;
    }

    public void setUseJDBCCompliantTimezoneShift(boolean p_bValue) {
        this.m_bValueUseJDBCCompliantTimezoneShift = p_bValue;
    }

    public boolean getAddUseLegacyDatetimeCode() {
        return m_bAddUseLegacyDatetimeCode;
    }

    private void setAddUseLegacyDatetimeCode(boolean p_bValue) {
        this.m_bAddUseLegacyDatetimeCode = p_bValue;
    }

    public void useLegacyDatetimeCodeON(){
        setAddUseLegacyDatetimeCode(true);
    }
    
    public void useLegacyDatetimeCodeOFF(){
        setAddUseLegacyDatetimeCode(false);
    }    
    
    public boolean getUseLegacyDatetimeCode() {
        return m_bValueUseLegacyDatetimeCode;
    }

    public void setUseLegacyDatetimeCode(boolean p_bValue) {
        this.m_bValueUseLegacyDatetimeCode = p_bValue;
    }

    public boolean getAddServerTimezone() {
        return m_bAddServerTimezone;
    }

    private void setAddServerTimezone(boolean p_bValue) {
        this.m_bAddServerTimezone = p_bValue;
    }
    
    public void serverTimezoneON(){
        setAddServerTimezone(true);
    }
    
    public void serverTimezoneOFF(){
        setAddServerTimezone(false);
    }     

    public String getServerTimezone() {
        return m_bValueServerTimezone;
    }

    private void setServerTimezone(String p_bValue) {
        this.m_bValueServerTimezone = p_bValue;
    }
    
    private StringBuilder createFinal() 
    {
        StringBuilder builder = getFinal();
        if(builder==null)
        {
            builder = new StringBuilder();
        }
        return builder;
    }
    
    private String createBase() 
    {
        return "jdbc:mysql://";
    }
    
    private void appendProperty(StringBuilder p_CBuilder, String p_strSymbol, 
            String p_strPropertyName, String p_strPropertyValue)
    {
            p_CBuilder.append(p_strSymbol);
            p_CBuilder.append(p_strPropertyName);
            p_CBuilder.append("=");
            p_CBuilder.append(p_strPropertyValue);
    }
    
    private void appendProperty(StringBuilder p_CBuilder, String p_strSymbol, 
            String p_strPropertyName, boolean p_bPropertyValue)
    {
            p_CBuilder.append(p_strSymbol);
            p_CBuilder.append(p_strPropertyName);
            p_CBuilder.append("=");
            p_CBuilder.append(p_bPropertyValue);
    }

    private void initSetup(String p_strUrl, String p_strDatabase, String p_strUser, String p_strPassword) {
        setUrl(p_strUrl);
        setDatabase(p_strDatabase);
        setUser(p_strUser);
        setPassword(p_strPassword);
        m_bAutoReconnect = true;
        m_bUseSSL = false;
        setAddVerifyServerCertificate(false);
        setAddUseUnicode(false);
        setAddUseJDBCCompliantTimezoneShift(false);
        setAddUseLegacyDatetimeCode(false);
        setAddServerTimezone(false);
        setServerTimezone("UTC");
    }
    
    @Override
    public String toString(){
        StringBuilder builder = getFinal();
        builder.append(getBase());
        builder.append(getUrl());
        builder.append("/");
        builder.append(getDatabase());
        appendProperty(builder, CONN_STR_PROPERTY_START, "user", getUser());
        appendProperty(builder, CONN_STR_PROPERTY_AND, "password", getPassword());
        appendProperty(builder, CONN_STR_PROPERTY_AND, "autoReconnect", getAutoReconnect());
        appendProperty(builder, CONN_STR_PROPERTY_AND, "useSSL", getUseSSL());
        
        if(getAddVerifyServerCertificate())
        {
            appendProperty(builder, CONN_STR_PROPERTY_AND, "verifyServerCertificate", getVerifyServerCertificate());
        }
        
        if(getAddUseUnicode())
        {
            appendProperty(builder, CONN_STR_PROPERTY_AND, "useUnicode", getUseUnicode());
        }
        
        if(getAddUseJDBCCompliantTimezoneShift())
        {
            appendProperty(builder, CONN_STR_PROPERTY_AND, "useJDBCCompliantTimezoneShift", getUseJDBCCompliantTimezoneShift());
        }

        if(getAddUseLegacyDatetimeCode())
        {
            appendProperty(builder, CONN_STR_PROPERTY_AND, "useLegacyDatetimeCode", getUseLegacyDatetimeCode());
        }
        
        if(getAddServerTimezone())
        {
            appendProperty(builder, CONN_STR_PROPERTY_AND, "serverTimezone", getServerTimezone());
        }
        
        return builder.toString();
    }
    
}
