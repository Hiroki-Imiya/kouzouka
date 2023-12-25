<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xalan="http://xml.apache.org/xslt">
<xsl:output method="xml" encoding="UTF-8" indent="yes" xalan:indent-amount="2" />
<xsl:template match="/">
    <books>
        <xsl:apply-templates select="books/book"/>
        
    </books>
</xsl:template>
<xsl:template match="book">
    <xsl:if test="price &lt;= 3000">
        <book>
            <title><xsl:value-of select="title"/></title>
            <publisher><xsl:value-of select="price/@publisher"/></publisher>
            <price><xsl:value-of select="price"/></price>
        </book>
    </xsl:if>
</xsl:template>
</xsl:stylesheet>