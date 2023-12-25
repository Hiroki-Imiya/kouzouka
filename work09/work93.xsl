<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xalan="http://xml.apache.org/xslt">
<xsl:output method="xml" encoding="UTF-8" indent="yes" xalan:indent-amount="2" />
<xsl:template match="/">
    <本リスト>
        <xsl:apply-templates select="books/book"/>
    </本リスト>
</xsl:template>
<xsl:template match="book">
    <xsl:element name="本">
        <xsl:attribute name="ISBN"><xsl:value-of select="@isbn"/></xsl:attribute>
        <xsl:attribute name="出版社"><xsl:value-of select="price/@publisher"></xsl:value-of></xsl:attribute>
        <タイトル><xsl:value-of select="title"/></タイトル>
        <著者><xsl:value-of select="author"/></著者>
        <値段><xsl:value-of select="price"/></値段>
    </xsl:element>
</xsl:template>
</xsl:stylesheet>